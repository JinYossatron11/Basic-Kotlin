package com.example.add.begibkotlin

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

class MyFirebaseInstanceIDService : FirebaseInstanceIdService() {

    override fun onTokenRefresh() {
        super.onTokenRefresh()

        val refreshedToken = FirebaseInstanceId.getInstance().token
        Log.d(TAG, "Refreshed token: " + refreshedToken!!)

        sendRegistrationToServer(refreshedToken)
    }

    private fun sendRegistrationToServer(token: String?) {
        // Add custom implementation, as needed.
    }

    companion object {
        private val TAG = "MyFirebaseIIDService"
    }
}