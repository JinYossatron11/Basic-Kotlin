package com.example.add.begibkotlin

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.RingtoneManager
import android.support.v4.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import java.io.IOException
import java.net.URL

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        super.onMessageReceived(remoteMessage)

        val notification = remoteMessage!!.notification
        val data = remoteMessage.data

        sendNotification(notification, data)
    }

    private fun sendNotification(notification: RemoteMessage.Notification, data: Map<String, String>) {
        val icon = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)

        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)

        val notificationBuilder = NotificationCompat.Builder(this)
                .setContentTitle(notification.title)
                .setContentText(notification.body)
                .setAutoCancel(true)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setContentIntent(pendingIntent)
                .setContentInfo(notification.title)
                .setLargeIcon(icon)
                .setColor(Color.RED)
                .setSmallIcon(R.mipmap.ic_launcher)

        try {
            val picture_url = data["picture_url"]
            if (picture_url != null && "" != picture_url) {
                val url = URL(picture_url)
                val bigPicture = BitmapFactory.decodeStream(url.openConnection().getInputStream())
                notificationBuilder.setStyle(
                        NotificationCompat.BigPictureStyle().bigPicture(bigPicture).setSummaryText(notification.body)
                )
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        notificationBuilder.setDefaults(Notification.DEFAULT_VIBRATE)
        notificationBuilder.setLights(Color.YELLOW, 1000, 300)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(0, notificationBuilder.build())
    }
}