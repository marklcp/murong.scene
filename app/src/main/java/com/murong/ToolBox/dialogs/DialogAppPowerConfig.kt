package com.murong.diaodu.dialogs

import android.app.Activity
import android.view.View
import com.murong.common.ui.DialogHelper
import com.murong.scene_mode.ModeSwitcher
import com.murong.diaodu.R

class DialogAppPowerConfig(var context: Activity, val current: String?, val iResultCallback: IResultCallback) {
    interface IResultCallback {
        fun onChange(mode: String?)
    }

    private fun onModeClick (mode: String?) {
        if (mode != current) {
            iResultCallback.onChange(mode)
        }
    }

    fun show() {
        val view = context.layoutInflater.inflate(R.layout.dialog_scene_app_powercfg, null)
        val dialog = DialogHelper.customDialog(context, view)

        view.findViewById<View>(R.id.mode_powersave).setOnClickListener {
            dialog.dismiss()
            onModeClick(ModeSwitcher.POWERSAVE)
        }
        view.findViewById<View>(R.id.mode_balance).setOnClickListener {
            dialog.dismiss()
            onModeClick(ModeSwitcher.BALANCE)
        }
        view.findViewById<View>(R.id.mode_performance).setOnClickListener {
            dialog.dismiss()
            onModeClick(ModeSwitcher.PERFORMANCE)
        }
        view.findViewById<View>(R.id.mode_fast).setOnClickListener {
            dialog.dismiss()
            onModeClick(ModeSwitcher.FAST)
        }

        view.findViewById<View>(R.id.mode_empty).setOnClickListener {
            dialog.dismiss()
            onModeClick("")
        }
        view.findViewById<View>(R.id.mode_keep).setOnClickListener {
            dialog.dismiss()
            onModeClick(ModeSwitcher.IGONED)
        }
    }
}