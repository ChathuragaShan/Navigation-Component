package com.chathuranga.shan.navigationcomponent1.example1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.chathuranga.shan.navigationcomponent1.R
import kotlinx.android.synthetic.main.activity_example2.*

class Example2Activity : AppCompatActivity() {

    private lateinit var navigationController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example2)

        initialization()
    }

    private fun initialization() {

        navigationController = Navigation.findNavController(this, R.id.hostFragment)
        setSupportActionBar(toolbar)
        NavigationUI.setupActionBarWithNavController(this, navigationController)

    }
}
