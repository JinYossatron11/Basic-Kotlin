package com.example.add.begibkotlin.notifirebase

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.add.begibkotlin.R
import com.example.add.begibkotlin.coursepeewee.activity.MainActivity

import com.google.firebase.iid.FirebaseInstanceId

import com.google.firebase.messaging.FirebaseMessaging.*

class MyFirebaseInstance : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_firebase_instance)
        if (intent.extras != null) {
            for (key in intent.extras.keySet()) {
                val value = intent.extras.get(key)
                Log.d(TAG, "Key: $key Value: $value")
            }
        }

        findViewById(R.id.subscribeButton).setOnClickListener(this)
        findViewById(R.id.unsubscribeButton).setOnClickListener(this)
        findViewById(R.id.logTokenButton).setOnClickListener(this)
    }

    override fun onClick(view: View) {

        when (view.id) {
            R.id.subscribeButton -> {
                getInstance().subscribeToTopic("news")
                Log.d(TAG, "SubscribeToTopic")
                Toast.makeText(this, "SubscribeToTopic", Toast.LENGTH_SHORT).show()

            }
            R.id.unsubscribeButton -> {
                getInstance().unsubscribeFromTopic("news")
                Log.d(TAG, "UnsubscribeFromTopic")
                Toast.makeText(this, "UnsubscribeFromTopic", Toast.LENGTH_SHORT).show()
            }
            R.id.logTokenButton -> {
                val token = FirebaseInstanceId.getInstance().token
                Log.d(TAG, "Token : " + token!!)
                Toast.makeText(this, "Token : " + token, Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private val TAG = "MainActivity"
    }
}
