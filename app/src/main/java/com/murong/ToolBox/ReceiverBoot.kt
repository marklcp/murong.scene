package com.murong.diaodu

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.murong.diaodu.services.BootService


class ReceiverBoot : BroadcastReceiver() {
    companion object {
        var bootCompleted: Boolean = false
    }

    override fun onReceive(context: Context, intent: Intent) {
        if (bootCompleted) {
            return
        }
        bootCompleted = true

        try {
            val service = Intent(context, BootService::class.java)
            context.startService(service)
        } catch (ex: Exception) {
        }
    }
}