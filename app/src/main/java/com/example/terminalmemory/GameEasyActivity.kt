package com.example.terminalmemory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class GameEasyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_easy)
        val card1 = findViewById<ImageView>(R.id.card1)
        val card2 = findViewById<ImageView>(R.id.card2)
        val card3 = findViewById<ImageView>(R.id.card3)
        val card4 = findViewById<ImageView>(R.id.card4)
        val card5 = findViewById<ImageView>(R.id.card5)
        val card6 = findViewById<ImageView>(R.id.card6)
        val listToCompareCards = mutableListOf<ImageView>()
        val listOfCards = listOf<Pair<ImageView,Int>>(Pair(card1,R.drawable.ls_card),
            Pair(card2,R.drawable.ls_card),
            Pair(card3,R.drawable.val_card),
            Pair(card4,R.drawable.val_card),
            Pair(card5,R.drawable.var_card),
            Pair(card6,R.drawable.var_card)).forEach { card ->
                card.first.setOnClickListener {
                    listToCompareCards.add(it as ImageView)
                    card.first.setImageDrawable(getDrawable(card.second))
                    isListFull(listToCompareCards)
                }
            }
    }

    private fun isListFull(listToCompareCards: MutableList<ImageView>) {
        if (listToCompareCards.size == 2) {
            areCardsEqual(listToCompareCards)
        }
    }

    private fun areCardsEqual(listToCompareCards: MutableList<ImageView>) {
        if (listToCompareCards[0].id == listToCompareCards[1].id){
            val gameEqualCardsDialog = AlertDialog.Builder(this)
            gameEqualCardsDialog.setMessage("No puedes elegir la misma carta dos veces")
            gameEqualCardsDialog.show()
        } else {
            compareCards(listToCompareCards)
        }
    }

    private fun compareCards(listToCompareCards: MutableList<ImageView>) {
        if (listToCompareCards[0].tag == listToCompareCards[1].tag){
            Toast.makeText(this@GameEasyActivity, "Son iguales", Toast.LENGTH_SHORT).show()
            listToCompareCards.forEach { it.isEnabled = false }
            listToCompareCards.clear()
        } else {
            Toast.makeText(this@GameEasyActivity, "Son diferentes", Toast.LENGTH_SHORT).show()
            listToCompareCards[0].setImageDrawable(getDrawable(R.drawable.card_back))
            listToCompareCards[1].setImageDrawable(getDrawable(R.drawable.card_back))
            listToCompareCards.clear()
        }
    }

    private fun areAllPairsFound() {

    }
}