package dev.roeeyn.neonergia.services

import android.app.AlarmManager
import android.app.IntentService
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import org.koin.android.ext.android.inject

class TimerService: IntentService("TimerService"){

    override fun onHandleIntent(intent: Intent?) {
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val alarmIntent = Intent(this, TimerReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, 0)
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, 0, 20000, pendingIntent)
    }

}