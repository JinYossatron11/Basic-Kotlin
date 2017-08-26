package com.example.add.begibkotlin.notifirebase

import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.RingtoneManager
import android.support.v4.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.example.add.begibkotlin.R


class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        super.onMessageReceived(remoteMessage)

        val notification = remoteMessage!!.notification
        val data = remoteMessage.data

        sendNotification(remoteMessage)
    }

    private fun sendNotification(remoteMessage: RemoteMessage) {

        val notificationPayload = remoteMessage.notification
        val dataPayload = remoteMessage.data

        val notificationMessageStyle = NotificationCompat.MessagingStyle(getString(R.string.app_name))
        notificationMessageStyle.conversationTitle = getString(R.string.news_feed)

        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(this)
                .setContentTitle(notificationPayload.title)
                .setContentText(notificationPayload.body)
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.anonymous_new)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.anonymous))
                .setColor(Color.parseColor("#00a3dc"))
                .setSound(defaultSoundUri)


//        notificationBuilder.setDefaults(Notification.DEFAULT_VIBRATE)
//        notificationBuilder.setLights(Color.YELLOW, 1000, 300)
//        notificationBuilder.setVibrate(longArrayOf(1000, 1000, 1000, 1000, 1000))
//        notificationBuilder.setDefaults(Notification.DEFAULT_SOUND)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(0, notificationBuilder.build())
    }

}

