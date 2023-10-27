package com.uef.hero_adventure

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class GameScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_screen)

        val story = Story(this)
        val choice1 = findViewById<Button>(R.id.choiceButton1)
        val choice2 = findViewById<Button>(R.id.choiceButton2)
        val choice3 = findViewById<Button>(R.id.choiceButton3)
        val choice4 = findViewById<Button>(R.id.choiceButton4)

        choice1.setOnClickListener{
            story.selectPosition(story.nextPosition1)
        }

        choice2.setOnClickListener{
            story.selectPosition(story.nextPosition2)
        }

        choice3.setOnClickListener{
            story.selectPosition(story.nextPosition3)
        }

        choice4.setOnClickListener{
            story.selectPosition(story.nextPosition4)
        }

        story.intro1()


    }

    fun goTitleScreen() {
        val titleScreen = Intent(this, TitleScreen::class.java)
        startActivity(titleScreen)
    }

    fun treasure_exe() {
        val video = Intent(Intent.ACTION_VIEW, Uri.parse("https://bit.ly/treasure_exe"))
        startActivity(video) //
    }
}