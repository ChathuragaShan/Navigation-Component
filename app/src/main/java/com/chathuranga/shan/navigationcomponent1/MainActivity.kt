package com.chathuranga.shan.navigationcomponent1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chathuranga.shan.navigationcomponent1.example1.Example1Activity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onClickExampleOn()
    }

    private fun onClickExampleOn(){

        example1Button.setOnClickListener {

            val intent = Intent(this,Example1Activity::class.java)
            startActivity(intent)

        }
    }
}
