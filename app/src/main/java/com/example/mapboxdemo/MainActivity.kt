package com.example.mapboxdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    var bottomNavView:BottomNavigationView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        bottomNavView?.let {
            NavigationUI.setupWithNavController(it,Navigation.findNavController(this,R.id.nav_host_home))
        }
    }
}