package com.example.androidcleanarchitectureproject.utils

import com.example.androidcleanarchitectureproject.data.model.SecurityQuestions
import com.example.androidcleanarchitectureproject.data.model.UserSecurityQuestions

object SecurityQuestionsMapper {





    fun mapSecurityQuestionsListToUserSecurityQuestionsList(securityQuestionsListFromBackend: List<SecurityQuestions?>?): List<UserSecurityQuestions> {
        val emptyUserSecurityQuestionsList:List<UserSecurityQuestions> = emptyList()
        val mappedList = mutableListOf<UserSecurityQuestions>()

        //check if list is null first
        if (securityQuestionsListFromBackend?.isEmpty()==true) {
            return emptyUserSecurityQuestionsList
        } else {

            //loop through received list items and map each
            for (securityQuestion in securityQuestionsListFromBackend!!) {
                val mappedQuestion = securityQuestion?.let {
                    UserSecurityQuestions(
                        answer = "",  // Initially set answer as empty string
                        code = securityQuestion.code,
                        question = it.description
                    )
                }
                if (mappedQuestion != null) {
                    mappedList.add(mappedQuestion)
                }
            }
            //return a list of UserSecurityQuestions when loop finishes
            return mappedList
        }

    }








}