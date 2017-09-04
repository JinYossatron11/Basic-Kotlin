package com.example.add.begibkotlin.coursepeewee.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import butterknife.ButterKnife
import com.example.add.begibkotlin.R
import com.example.add.begibkotlin.coursepeewee.fragment.FirstPageFragment

class FirstPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_page)
        ButterKnife.bind(this)

        initFragment()
    }

    fun initFragment() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, FirstPageFragment.newInstance())
                .commit()
    }

    fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit()
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .add(R.id.container, fragment)
                .addToBackStack(null)
                .commit()
    }

}

