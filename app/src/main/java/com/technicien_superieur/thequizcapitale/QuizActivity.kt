package com.technicien_superieur.thequizcapitale

import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {


    var quizs = ArrayList<Quiz>()
    var numberOfGoodAnswers: Int = 0
    var currentQuizIndex: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        quizs.add(Quiz("Quelle est la capitale de l'Algérie ?", "Alger", "Paris", "Marseille", 1))
        quizs.add(Quiz("Quelle est la capitale de la France ?", "Alger", "Paris", "Marseille", 2))
        quizs.add(Quiz("Quelle est la capitale de l'Angola ?", "Alger", "Paris", "Luanda", 3))
        quizs.add(Quiz("Quelle est la capitale de l'Autriche ?", "Alger", "Vienne", "Marseille", 2))


        showQuestion(quizs.get(currentQuizIndex))
    }

    fun showQuestion(quiz: Quiz) {
        txtQuestion.setText(quiz.question)
        answer1.setText(quiz.answer1)
        answer2.setText(quiz.answer2)
        answer3.setText(quiz.answer3)
    }

    fun handleAnswer(answerID: Int) {
        val quiz = quizs.get(currentQuizIndex)

        if (quiz.isCorrect(answerID)) {
            numberOfGoodAnswers++
            Toast.makeText(this, "+1", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "+0", Toast.LENGTH_SHORT).show()
        }

        // Pour pouvoir aller à la question suivante
        currentQuizIndex++


        if (currentQuizIndex >= quizs.size) { // Partie terminé

            val sharedPreferences = getSharedPreferences("com.technicien_superieur.thequizcapitale", Context.MODE_PRIVATE)
            sharedPreferences.edit().putInt("userScore", numberOfGoodAnswers).apply()

            var alert = AlertDialog.Builder(this)
            alert.setTitle("Partie terminé!")
            alert.setMessage("Tu as eu : " + numberOfGoodAnswers + " bonne(s) réponse(s)")
            alert.setPositiveButton("OK") { dialogInterface: DialogInterface?, i: Int ->
                finish()
            }
            alert.show()

        } else { // On continue la partie
            showQuestion(quizs.get(currentQuizIndex))
        }

    }

    fun onClickAnwerOne(view: View) {
        handleAnswer(1)
    }

    fun onClickAnwerTwo(view: View) {
        handleAnswer(2)
    }

    fun onClickAnwerThree(view: View) {
        handleAnswer(3)
    }


}
