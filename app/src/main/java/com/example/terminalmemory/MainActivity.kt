package com.example.terminalmemory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainMenuPlayButton = findViewById<Button>(R.id.mainMenuPlayButton).setOnClickListener {
            val gameEasyActivity = Intent(this, GameEasyActivity::class.java)
            startActivity(gameEasyActivity)
        }
        val mainMenuHelpButton = findViewById<Button>(R.id.mainMenuHelpButton).setOnClickListener{
            val mainMenuHelpDialog = AlertDialog.Builder(this)
            mainMenuHelpDialog.setTitle("Como jugar:")
            mainMenuHelpDialog.setMessage("Ejecuta ./play.sh \n" +
                                            "Encuentra las parejas")
            mainMenuHelpDialog.show()
        }
    }
}