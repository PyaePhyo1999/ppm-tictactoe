package com.example.tictactoe

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var p1 = ArrayList<Int>()
    var p2 = ArrayList<Int>()
    private var activePlayer = 1

    private val btnOne by lazy { findViewById<Button>(R.id.BtnOne) }
    private val btnTwo by lazy { findViewById<Button>(R.id.BtnTwo) }
    private val btnThree by lazy { findViewById<Button>(R.id.BtnThree) }
    private val btnFour by lazy { findViewById<Button>(R.id.BtnFour) }
    private val btnFive by lazy { findViewById<Button>(R.id.BtnFive) }
    private val btnSix by lazy { findViewById<Button>(R.id.BtnSix) }
    private val btnSeven by lazy { findViewById<Button>(R.id.BtnSeven) }
    private val btnEight by lazy { findViewById<Button>(R.id.BtnEight) }
    private val btnNine by lazy { findViewById<Button>(R.id.BtnNine) }
    private val btnReset by lazy { findViewById<Button>(R.id.BtnReset) }

    companion object{
        fun intent(context : Context):Intent{
            return Intent(context,MainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        reset()

    }
    private fun reset(){
        btnReset.setOnClickListener {
            val intent = MainActivity.intent(applicationContext)
            startActivity(intent)
            finish()

        }
    }
    fun onClick(view: View){
        val btnSelected = view as Button
        var cellId = 0
        when (btnSelected.id){
            R.id.BtnOne->cellId = 1
            R.id.BtnTwo->cellId = 2
            R.id.BtnThree->cellId = 3
            R.id.BtnFour->cellId = 4
            R.id.BtnFive->cellId = 5
            R.id.BtnSix->cellId = 6
            R.id.BtnSeven->cellId = 7
            R.id.BtnEight->cellId = 8
            R.id.BtnNine->cellId = 9

        }
        playGame(cellId,btnSelected)
    }

    private fun playGame(cellId: Int, btnSelected: Button) {
       if (activePlayer == 1){
           btnSelected.text = "X"
           btnSelected.setBackgroundColor(Color.parseColor("#FF9300"))
           p1.add(cellId)
           activePlayer=2
       }
        else{
           btnSelected.text = "O"
           btnSelected.setBackgroundColor(Color.parseColor("#BB86FC"))
           p2.add(cellId)
           activePlayer=1
       }
        btnSelected.isEnabled = false
        checkWinner()


    }
    private fun checkWinner(){
        var winner = -1
        //row1
        if (p1.contains(1) && p1.contains(2) && p1.contains(3)){ winner = 1 }
        if(p2.contains(1) && p2.contains(2) && p2.contains(3)){ winner = 2 }

        //row2
        if (p1.contains(4) && p1.contains(5) && p1.contains(6)){ winner = 1 }
        if(p2.contains(4) && p2.contains(5) && p2.contains(6)) { winner = 2 }
        //row3
        if (p1.contains(7) && p1.contains(8) && p1.contains(9)){ winner = 1 }
        if(p2.contains(7) && p2.contains(8) && p2.contains(9)){ winner = 2 }
        //col1
        if (p1.contains(1) && p1.contains(4) && p1.contains(7)){ winner = 1 }
        if(p2.contains(1) && p2.contains(4) && p2.contains(7)) { winner = 2 }
        //col2
        if (p1.contains(2) && p1.contains(5) && p1.contains(8)){ winner = 1 }
        if(p2.contains(2) && p2.contains(5) && p2.contains(8)) { winner = 2 }
        //col3
        if (p1.contains(3) && p1.contains(6) && p1.contains(9)){ winner = 1 }
        if(p2.contains(3) && p2.contains(6) && p2.contains(9)) { winner = 2 }
        //crossline1
        if (p1.contains(1) && p1.contains(5) && p1.contains(9)){ winner = 1 }
        if(p2.contains(1) && p2.contains(5) && p2.contains(9)) { winner = 2 }
        //crossline2
        if (p1.contains(3) && p1.contains(5) && p1.contains(7)){ winner = 1 }
        if(p2.contains(3) && p2.contains(5) && p2.contains(7)) { winner = 2 }

        if(winner!=-1){
            if (winner == 1){
                buttonDisable()
                Toast.makeText(this,"Player 1 won the game.",Toast.LENGTH_LONG).show()

            }
            else {
                buttonDisable()
                Toast.makeText(this,"Player 2 won the game.",Toast.LENGTH_LONG).show()
            }
        }
        else if (!(winner==1 && winner==2)){
            Toast.makeText(this,"Draw",Toast.LENGTH_LONG).show()
        }
    }
    private fun buttonDisable(){
        btnOne.isClickable=false
        btnTwo.isClickable=false
        btnThree.isClickable=false
        btnFour.isClickable=false
        btnFive.isClickable=false
        btnSeven.isClickable=false
        btnSix.isClickable=false
        btnEight.isClickable=false
        btnNine.isClickable=false
    }
}