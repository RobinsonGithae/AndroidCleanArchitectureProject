package com.example.androidcleanarchitectureproject.ui.compose.camera

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.view.PreviewView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Check
import androidx.compose.material.icons.sharp.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.myapplication.R
import com.example.myapplication.data.model.others.CustomUriHolder
import com.example.myapplication.ui.compose.dialogs.PermissionsRationaleDialog
import com.example.myapplication.ui.viewmodel.CameraViewModel
import com.example.androidcleanarchitectureproject.utils.CameraUtils
import com.example.androidcleanarchitectureproject.utils.CameraUtils.getCameraProvider
import dagger.hilt.android.AndroidEntryPoint
import java.io.File
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


@AndroidEntryPoint
class CameraActivity:ComponentActivity() {

    val cameraViewModel: CameraViewModel by viewModels<CameraViewModel> ()

    var cameraLauncherScreen: String? = ""

    var showPermissionRationaleDialog by mutableStateOf(false)



    val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            Log.d("Camera Permission request", "Permission granted")
        } else {
            Log.d("Camera permission Request", "Permission denied")
            //todo handle permission denied
           // showPermissionRationaleDialog=true

        }
    }



    private lateinit var outputDirectory: File
    private lateinit var cameraExecutor: ExecutorService

    //private var shouldShowCamera by mutableStateOf(true)

    private var shouldShowCamera : MutableState<Boolean> = mutableStateOf(true)


    private lateinit var photoUriForPreviewingImage: Uri
    private var showPhotoPreview: MutableState<Boolean> = mutableStateOf(false)

   // private var showPhotoPreview by mutableStateOf(false)






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /** get which screen launched the camera screen **/

        val cameraActivityIntent: Intent = intent
         cameraLauncherScreen = cameraActivityIntent.getStringExtra("cameraLauncherScreen")

        /** End of getting which screen launched the camera screen **/
















        //request camera permission
        requestCameraPermission()

        //initialize late inited value to avoid exception. Late inits must be initialized before being used
        outputDirectory = getOutputDirectory()
        cameraExecutor = Executors.newSingleThreadExecutor()










        setContent {

            val cameraViewModel2:CameraViewModel= hiltViewModel()






            if (shouldShowCamera.value) {
                //show camera camera conditionally

                CameraScreen(outputDirectory=outputDirectory, executor = cameraExecutor, onImageCaptured = ::handleImageCapture , onError = {
                    Log.e("camera error", "View error:", it)
                },

                    rememberNavController(),

                    cameraViewModel,

                )

            }

            if (showPermissionRationaleDialog){
                PermissionsRationaleDialog(
                    onDismiss = {
                        //close the dialog as well as camera activity
                        showPermissionRationaleDialog=false
                        onBackPressedDispatcher.onBackPressed()

                                },
                    onConfirm ={ openAppSettings() } )
            }


            if (showPhotoPreview.value) {



                CapturedPhotoThumbnailScreen(photoUriForPreviewingImage,
                    onUpdateIsImageOkay = {

                                       // onBackPressed()

                        onBackPressedDispatcher.onBackPressed()


                    },
                    onUpdateRetakePhoto = {
                            showPhotoPreview.value=false

                            shouldShowCamera.value=true

                },
                    onUpdateCapturedImageUri = {
                        uriOfImageTakenWithCamera->

                        cameraViewModel.onEvent(CameraEvent.OnUpdateCapturedImageUri(uriOfImageTakenWithCamera))
                        cameraViewModel2.cameraState.capturedImageUri=uriOfImageTakenWithCamera

                        Log.d("uri is at on updateCaptured", "uri is "+uriOfImageTakenWithCamera)

                        cameraViewModel.cameraState.capturedImageUri=uriOfImageTakenWithCamera




                    }

                )

            }










        }

    }














    private fun requestCameraPermission() {
        when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED -> {
                Log.d("camera permissions", "Permission previously granted")
            }

            ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.CAMERA
            ) -> requestPermissionLauncher.launch(Manifest.permission.CAMERA)

               // Log.d("camera permissions", "Show camera permissions dialog")
                //showPermissionRationaleDialog=true
            else -> /* requestPermissionLauncher.launch(Manifest.permission.CAMERA) */ showPermissionRationaleDialog=true
        }
    }






    // Open app settings
    private fun openAppSettings() {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        intent.data = Uri.fromParts("package", packageName, null)
        startActivity(intent)
    }








    private fun handleImageCapture(uri: Uri) {
        Log.i("Image captured", "Image captured: $uri")
        shouldShowCamera.value= false

        photoUriForPreviewingImage = uri
       // showPhotoPreview.value = true

        cameraViewModel.onEvent(CameraEvent.OnUpdateCapturedImageUri(uri))

        var customUriHolder:CustomUriHolder=CustomUriHolder()
        customUriHolder.uri=uri.toString()

        if (cameraLauncherScreen?.equals("proofOfOwnershipScreen") == true) {
            //determine which viewmodel to assign captured image

            cameraViewModel.dataManager.setCurrentSelectedProofOfOwnershipDocumentUri(
                customUriHolder
            )
        }

        if (cameraLauncherScreen?.equals("identificationScreen") == true){
            //determine which viewmodel to assign captured image
            cameraViewModel.dataManager.setCurrentSelectedNationalIDDocumentUri(
                customUriHolder
            )

        }


        showPhotoPreview.value=true
    }

    private fun getOutputDirectory(): File {
        val mediaDir = externalMediaDirs.firstOrNull()?.let {
            File(it, resources.getString(R.string.app_name)).apply { mkdirs() }
        }

        return if (mediaDir != null && mediaDir.exists()) mediaDir else filesDir
    }

    override fun onDestroy() {
        super.onDestroy()
        cameraExecutor.shutdown()
    }


//    @Deprecated("Deprecated in Java")
//    override fun onBackPressed() {
//        super.onBackPressed()
//    }




//    // Set up onBackPressedDispatcher
//    val callback = object : OnBackPressedCallback(true) {
//        override fun handleOnBackPressed() {
//            // Add navigation logic here
//        //   onBackPressed()
//          //  onBackPressedDispatcher.onBackPressed()
//
//
//        }
//    }











}







@Composable
fun CameraActivityScreen (
    outputDirectory: File,
    executor: Executor,
    onImageCaptured: (Uri) -> Unit,
    onError: (ImageCaptureException) -> Unit,
    cameraViewModel: CameraViewModel,
    navHostController: NavHostController

) {

    CameraScreen(
        outputDirectory = outputDirectory ,
        executor = executor,
        onImageCaptured = { capturedImageUri->
            cameraViewModel.onEvent(CameraEvent.OnUpdateCapturedImageUri(capturedImageUri))
                          },
        onError = onError ,
        navHostController = navHostController,
        cameraViewModel = cameraViewModel
    )
    
}



















@Composable
fun CameraScreen( outputDirectory: File,
                  executor: Executor,
                  onImageCaptured: (Uri) -> Unit,
                  onError: (ImageCaptureException) -> Unit,
                  navHostController: NavHostController,
                  cameraViewModel: CameraViewModel) {

    CameraScreenContent(
        outputDirectory=outputDirectory,
        executor=executor,
        onImageCaptured=onImageCaptured,
        onError=onError
    )


}


@Composable
fun CameraScreenContent(  outputDirectory: File,
                          executor: Executor,
                          onImageCaptured: (Uri) -> Unit,
                          onError: (ImageCaptureException) -> Unit) {

    CameraView(outputDirectory =outputDirectory , executor = executor, onImageCaptured = onImageCaptured, onError = onError)


}



@Composable
fun CameraView(
    outputDirectory: File,
    executor: Executor,
    onImageCaptured: (Uri) -> Unit,
    onError: (ImageCaptureException) -> Unit
) {
    /* uses CameraX to launch and manage camera **/

    // 1
    val lensFacing = CameraSelector.LENS_FACING_BACK
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val preview = androidx.camera.core.Preview.Builder().build()
    val previewView = remember { PreviewView(context) }
    val imageCapture: ImageCapture = remember { ImageCapture.Builder().build() }
    val cameraSelector = CameraSelector.Builder()
        .requireLensFacing(lensFacing)
        .build()

    // 2
    LaunchedEffect(lensFacing) {
        val cameraProvider =  context.getCameraProvider()
        cameraProvider.unbindAll()
        cameraProvider.bindToLifecycle(
            lifecycleOwner,
            cameraSelector,
            preview,
            imageCapture
        )

        preview.setSurfaceProvider(previewView.surfaceProvider)
    }

    // 3
    Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier.fillMaxSize()) {
        AndroidView({ previewView }, modifier = Modifier.fillMaxSize())

        IconButton(
            modifier = Modifier.padding(bottom = 20.dp),
            onClick = {
                Log.i("CAMERA", "ON CLICK")
                CameraUtils.takePhoto(
                    filenameFormat = "yyyy-MM-dd-HH-mm-ss-SSS",
                    imageCapture = imageCapture,
                    outputDirectory = outputDirectory,
                    executor = executor,
                    onImageCaptured = onImageCaptured,
                    onError = onError
                )
            },
            content = {
                Icon(
                    //imageVector = painterResource(id = R.drawable.camera_lens),
                    painter =painterResource(id = R.drawable.camera_lens),
                    contentDescription = "Take picture",
                    tint = Color.White,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(1.dp)
                        .border(1.dp, Color.White, CircleShape)
                )
            }
        )









    }
}






@Preview
@Composable
fun CameraScreenContentPreview () {
     lateinit var outputDirectory: File
     lateinit var cameraExecutor: ExecutorService


    CameraScreenContent(outputDirectory =outputDirectory , executor =cameraExecutor , onImageCaptured = {}, onError ={} )


}


@Composable
fun CapturedPhotoThumbnailScreen(photoUriForPreviewingImage:Uri,onUpdateIsImageOkay:(Boolean)->Unit, onUpdateRetakePhoto:(Boolean)->Unit , onUpdateCapturedImageUri:(Uri)->Unit) {

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Black) ) {

        Image(
            painter = rememberAsyncImagePainter(photoUriForPreviewingImage),
            contentDescription = "photo preview",
            modifier = Modifier.fillMaxSize()
        )

        Row (verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.Center, modifier = Modifier
            .align(Alignment.BottomCenter)
            .fillMaxWidth()
            .padding(bottom = 15.dp)){

            IconButton(
                modifier = Modifier.padding(bottom = 20.dp),
                onClick = {
                    Log.i("CAMERA photo not oay", "ON CLICK cancel icon")


                    onUpdateRetakePhoto(true)

                },
                content = {
                    Icon(
                        imageVector = Icons.Sharp.Clear,
                        // painter =painterResource(id = R.drawable.camera_lens),
                        contentDescription = "cancel catured picture and retake",
                        tint = Color.White,
                        modifier = Modifier
                            .size(100.dp)
                            .padding(1.dp)
                            .border(1.dp, Color.White, CircleShape)
                            .background(color = Color.DarkGray, shape = CircleShape)
                    )
                }
            )



            Spacer(modifier = Modifier.width(75.dp))



            IconButton(
                modifier = Modifier.padding(bottom = 20.dp),
                onClick = {
                    Log.i("CAMERA photo okay", "ON CLICK okay icon")

                    onUpdateIsImageOkay(true)
                    onUpdateCapturedImageUri(photoUriForPreviewingImage)

                },
                content = {
                    Icon(
                        imageVector = Icons.Sharp.Check,
                        // painter =painterResource(id = R.drawable.camera_lens),
                        contentDescription = "Use this picture",
                        tint = Color.Yellow,
                        modifier = Modifier
                            .size(100.dp)
                            .padding(1.dp)
                            .border(1.dp, Color.White, CircleShape)
                            .background(color = Color.DarkGray, shape = CircleShape)
                    )
                }
            )







        }








    }



    
}