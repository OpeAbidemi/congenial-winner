package com.example.lasttime

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btn)

        btn.setOnClickListener {
            val notificationBuilder =
                NotificationCompat.Builder(this).setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentTitle("Hello World").setContentText("My name is Divad")
                    .setDefaults(NotificationCompat.DEFAULT_ALL)

            var noteManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                val channelId = "Notie"
                val notificationChannel = NotificationChannel(channelId, "Notie", NotificationManager.IMPORTANCE_DEFAULT)
                noteManager.createNotificationChannel(notificationChannel)
                notificationBuilder.setChannelId(channelId)
            }

            noteManager.notify(0, notificationBuilder.build())
        }
    }
}