package com.technicien_superieur.thequizcapitale

/**
 * Created by Fayçal KADDOURI on 25/04/2018.
 * Website : www.technicien-superieur.com
 */
class Quiz(var question: String, var answer1: String, var answer2: String, var answer3: String, var correctAnswerNumber: Int) {

    fun isCorrect(answerNumber: Int) : Boolean {
        if (answerNumber == correctAnswerNumber)
            return true

        return false
    }

}