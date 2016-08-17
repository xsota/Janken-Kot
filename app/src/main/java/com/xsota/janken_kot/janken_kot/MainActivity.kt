package com.xsota.janken_kot.janken_kot

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import butterknife.bindView
import java.util.*

class MainActivity : AppCompatActivity() {

    val resultTextView: TextView by bindView(R.id.reslut_textview)
    val tekiHandTextView: TextView by bindView(R.id.teki_hand_textview)
    val guTextView: TextView by bindView(R.id.gu_textview)
    val tyokiTextView: TextView by bindView(R.id.tyoki_textview)
    val paTextView: TextView by bindView(R.id.pa_textview)

    val random = Random()

    enum class hands(val id: Int){
        gu(0),
        tyoki(1),
        pa(2)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        guTextView.setOnClickListener {
            resetBG()
            clickHands(hands.gu.id)
            guTextView.setBackgroundColor(Color.GRAY)
        }

        tyokiTextView.setOnClickListener {
            resetBG()
            clickHands(hands.tyoki.id)
            tyokiTextView.setBackgroundColor(Color.GRAY)
        }

        paTextView.setOnClickListener {
            resetBG()
            clickHands(hands.pa.id)
            paTextView.setBackgroundColor(Color.GRAY)
        }
    }


    fun clickHands(handsId: Int){

        val tekiHand = random.nextInt(3)
        val result = ((handsId-tekiHand)+3)%3

        when(tekiHand){
            0 -> tekiHandTextView.setText("相手の手 ぐ")
            1 -> tekiHandTextView.setText("相手の手 ちょ")
            2 -> tekiHandTextView.setText("相手の手 ぱ")
        }

        when(result){
            0 -> resultTextView.setText("あいこ")
            1 -> resultTextView.setText("おまえまけ")
            2 -> resultTextView.setText("おまえかち")
        }

    }

    fun resetBG(){
        guTextView.setBackgroundColor(Color.TRANSPARENT)
        tyokiTextView.setBackgroundColor(Color.TRANSPARENT)
        paTextView.setBackgroundColor(Color.TRANSPARENT)
    }
}
