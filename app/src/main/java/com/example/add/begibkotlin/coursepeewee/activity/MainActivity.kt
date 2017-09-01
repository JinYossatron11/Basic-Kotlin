package com.example.add.begibkotlin.coursepeewee.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.MenuItem
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import com.example.add.begibkotlin.R
import com.example.add.begibkotlin.coursepeewee.fragment.MainFragment
import com.example.add.begibkotlin.view.CustomCheckBox

class MainActivity : AppCompatActivity() {

    lateinit var edtUsername : EditText
    lateinit var edtPassword : EditText
    lateinit var cbRemember  : CustomCheckBox
    lateinit var btLogin     : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit()
    }

}

