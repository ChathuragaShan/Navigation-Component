package com.chathuranga.shan.navigationcomponent1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chathuranga.shan.navigationcomponent1.example1.Example1Activity
import com.chathuranga.shan.navigationcomponent1.example2.Example2Activity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onClickExampleOne()
        onClickExampleTwo()
    }

    private fun onClickExampleOne(){

        example1Button.setOnClickListener {

            val intent = Intent(this,Example1Activity::class.java)
            startActivity(intent)

        }
    }
    
    private fun onClickExampleTwo(){

        example2Button.setOnClickListener {

            val intent = Intent(this, Example2Activity::class.java)
            startActivity(intent)
        }
    }
}
