package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var isFirstFragmentLoaded = true
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showFragmentOne()
        btn_fragment.setOnClickListener {
            if (isFirstFragmentLoaded)
                showFragmentTwo()
            else
                showFragmentOne()

        }


    }
    fun showFragmentOne(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentOne()
        transaction.replace(R.id.fragment_holder,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFirstFragmentLoaded = true
    }
    fun showFragmentTwo(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentTwo()
        transaction.replace(R.id.fragment_holder,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFirstFragmentLoaded = false
    }
}