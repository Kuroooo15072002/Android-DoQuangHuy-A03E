package com.uef.hero_adventure

import android.annotation.SuppressLint
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class Story(val gs: GameScreen) {
    val gameImage = gs.findViewById<ImageView>(R.id.gameImage)
    val gameText =  gs.findViewById<TextView>(R.id.gameText)

    val choice1 = gs.findViewById<Button>(R.id.choiceButton1)
    val choice2 = gs.findViewById<Button>(R.id.choiceButton2)
    val choice3 = gs.findViewById<Button>(R.id.choiceButton3)
    val choice4 = gs.findViewById<Button>(R.id.choiceButton4)

    var nextPosition1 = ""
    var nextPosition2 = ""
    var nextPosition3 = ""
    var nextPosition4 = ""
    var masterSword = false
    var masterShield = false
    var killedPlant = false

    fun selectPosition(position: String) {
        when(position) {
            "goTitleScreen" -> gs.goTitleScreen()
            "startingPoint" -> startingPoint()

            "intro_1" -> intro1()
            "intro_2" -> intro2()
            "intro_3" -> intro3()

            "dragon" -> dragon()
            "attack" -> attack()
            "chest" -> chest()
            "treasure_exe" -> gs.treasure_exe()

            "pipe" -> pipe()
            "plant" -> plant()
            "dead" -> dead()
            "sword" -> sword()

            "sign" -> sign()
            "shield" -> shield()
        }
    }

    fun showButtons() {
        choice1.visibility = View.VISIBLE
        choice2.visibility = View.VISIBLE
        choice3.visibility = View.VISIBLE
        choice4.visibility = View.VISIBLE
    }

    @SuppressLint("SetTextI18n")
    fun intro1() {
        gameImage.setImageResource(R.drawable.cavalry)
        gameText.text = "You are a knight on a mission to fight the all-mighty dragon\n\nThe dragon was a fearsome beast, with scales as hard as steel, claws as sharp as swords, and breath as hot as fire."

        choice1.visibility = View.INVISIBLE
        choice2.visibility = View.INVISIBLE
        choice3.text = "next"
        choice4.visibility = View.INVISIBLE

        nextPosition3 = "intro_2"
    }

    @SuppressLint("SetTextI18n")
    fun intro2() {
        gameImage.setImageResource(R.drawable.cavalry)
        gameText.text = "It had destroyed countless villages, devoured countless lives, and hoarded countless treasures. No one had ever faced it and lived to tell the tale."

        choice1.visibility = View.INVISIBLE
        choice2.visibility = View.INVISIBLE
        choice3.text = "next"
        choice4.visibility = View.INVISIBLE

        nextPosition3 = "intro_3"
    }

    @SuppressLint("SetTextI18n")
    fun intro3() {
        gameImage.setImageResource(R.drawable.cavalry)
        gameText.text = "But you are different. You are the chosen one, the hero of prophecy, the one who would end the dragon's reign of terror.\n\nWill you be able to defeat the all-mighty dragon and save the world"

        choice1.visibility = View.INVISIBLE
        choice2.visibility = View.INVISIBLE
        choice3.text = "next"
        choice4.visibility = View.INVISIBLE

        nextPosition3 = "startingPoint"
    }

    @SuppressLint("SetTextI18n")
    fun startingPoint() {
        gameImage.setImageResource(R.drawable.trail)
        gameText.text = "You are on the road. There's a wooden sign nearby.\n\nWhat will you do?"

        choice1.text = "Go north"
        choice2.text = "Go east"
        choice3.text = "Go west"
        choice4.text = "Read the sign"

        showButtons()

        nextPosition1 = "dragon"
        nextPosition2 = "sword"
        nextPosition3 = "pipe"
        nextPosition4 = "sign"
    }

    @SuppressLint("SetTextI18n")
    fun dragon() {
        gameImage.setImageResource(R.drawable.dragon_head)
        gameText.text = "You encounter a Dragon\n\nWhat you want to do?"

        choice1.text = "Attack"
        choice2.text = "Run"
        choice3.visibility = View.INVISIBLE
        choice4.visibility = View.INVISIBLE

        nextPosition1 = "attack"
        nextPosition2 = "startingPoint"
    }

    @SuppressLint("SetTextI18n")
    fun attack() {
        if(masterSword && masterShield && killedPlant) {
            gameImage.setImageResource(R.drawable.dragon_head)
            gameText.text = "With your Master Sword and Shield you had defeated the dragon!\n\nYou get the treasure and the world is saved!\n\nTHE END!"

            choice1.text = "next"
            choice2.visibility = View.INVISIBLE
            choice3.visibility = View.INVISIBLE
            choice4.visibility = View.INVISIBLE

            nextPosition1 = "chest"
        }else{
            dead()
        }
    }

    @SuppressLint("SetTextI18n")
    fun sword() {
        gameImage.setImageResource(R.drawable.sword)
        gameText.text = "Amazing! You found a Master Sword!!!\n\n(You obtain a Master Sword)"

        masterSword = true

        choice1.text = "back"
        choice2.visibility = View.INVISIBLE
        choice3.visibility = View.INVISIBLE
        choice4.visibility = View.INVISIBLE

        nextPosition1 = "startingPoint"
    }

    @SuppressLint("SetTextI18n")
    fun chest() {
        gameImage.setImageResource(R.drawable.chest)
        gameText.text = "Amazing! You found a treasure chest\n\n What will you do??"
        showButtons()

        choice1.text = "Open it!"
        choice2.text = "Let it be!"
        choice3.visibility = View.INVISIBLE
        choice4.visibility = View.INVISIBLE

        nextPosition1 = "treasure_exe"
        nextPosition2 = "startingPoint"
    }

    @SuppressLint("SetTextI18n")
    fun pipe() {
        gameImage.setImageResource(R.drawable.pipe)
        gameText.text = "You find a gigantic pipe"

        choice1.text = "Look inside"
        choice2.text = "Back"
        choice3.visibility = View.INVISIBLE
        choice4.visibility = View.INVISIBLE

        nextPosition1 = "plant"
        nextPosition2 = "startingPoint"
    }

    @SuppressLint("SetTextI18n")
    fun plant() {
        if(!masterSword) {
            gameImage.setImageResource(R.drawable.plant)
            gameText.text = "Piranha plant is inside!!!\nAlas, you are eaten by it."

            choice1.text = "next"
            choice2.visibility = View.INVISIBLE
            choice3.visibility = View.INVISIBLE
            choice4.visibility = View.INVISIBLE

            nextPosition1 = "dead"
        }else{
            gameImage.setImageResource(R.drawable.plant)
            gameText.text = "You have defeated the Piranha plant with your Master Sword\n\nYou feed much stronger now"

            killedPlant = true

            choice1.text = "next"
            choice2.visibility = View.INVISIBLE
            choice3.visibility = View.INVISIBLE
            choice4.visibility = View.INVISIBLE

            nextPosition1 = "startingPoint"
        }
    }

    @SuppressLint("SetTextI18n")
    fun dead() {
        gameImage.setImageResource(R.drawable.grave)
        gameText.text = "You are dead. Your adventure ends here.\n\nGAME OVER"

        choice1.text = "Go to the the title screen"
        choice2.visibility = View.INVISIBLE
        choice3.visibility = View.INVISIBLE
        choice4.visibility = View.INVISIBLE

        nextPosition1 = "goTitleScreen"
    }

    @SuppressLint("SetTextI18n")
    fun sign() {
        gameImage.setImageResource(R.drawable.sign)
        gameText.text = "The sign says: \n\nDRAGON AHEAD!!!"

        choice1.text = "look around"
        choice2.text = "back"
        choice3.visibility = View.INVISIBLE
        choice4.visibility = View.INVISIBLE

        nextPosition1 = "shield"
        nextPosition2 = "startingPoint"
    }

    @SuppressLint("SetTextI18n")
    fun shield() {
        gameImage.setImageResource(R.drawable.shield)
        gameText.text = "You look around and find some kind of weird Shield but it might help\n\n(You obtain a Master Shield)"

        masterShield = true

        choice1.text = "next"
        choice2.visibility = View.INVISIBLE
        choice3.visibility = View.INVISIBLE
        choice4.visibility = View.INVISIBLE

        nextPosition1 = "startingPoint"
    }
}