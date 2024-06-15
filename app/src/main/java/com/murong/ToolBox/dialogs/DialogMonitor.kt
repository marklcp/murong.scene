package com.murong.diaodu.dialogs

import android.app.Activity
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import com.murong.Scene
import com.murong.common.ui.DialogHelper
import com.murong.utils.AccessibleServiceHelper
import com.murong.diaodu.R
import com.murong.diaodu.popup.*

class DialogMonitor(var context: Activity) {
    fun show() {
        val view = context.layoutInflater.inflate(R.layout.dialog_float_monitor, null)
        val dialog = DialogHelper.customDialog(context, view)

        view.findViewById<CompoundButton>(R.id.monitor_perf).run {
            isChecked = FloatMonitor.show == true
            setOnClickListener {
                if (isChecked) {
                    FloatMonitor(context).showPopupWindow()
                } else {
                    FloatMonitor(context).hidePopupWindow()
                }
            }
        }
        view.findViewById<CompoundButton>(R.id.monitor_proc).run {
            isChecked = FloatTaskManager.show == true
            setOnClickListener {
                if (isChecked) {
                    val floatTaskManager = FloatTaskManager(context)
                    if (floatTaskManager.supported) {
                        FloatTaskManager(context).showPopupWindow()
                    } else {
                        Toast.makeText(context, context.getString(R.string.monitor_process_unsupported), Toast.LENGTH_SHORT).show()
                        isChecked = false
                    }
                } else {
                    FloatTaskManager(context).hidePopupWindow()
                }
            }
        }
        view.findViewById<CompoundButton>(R.id.monitor_threads).run {
            isChecked = FloatMonitorThreads.show == true
            setOnClickListener {
                if (isChecked) {
                    val floatTaskManager = FloatMonitorThreads(context)
                    if (floatTaskManager.supported) {
                        FloatMonitorThreads(context).showPopupWindow()
                    } else {
                        Toast.makeText(context, context.getString(R.string.monitor_process_unsupported), Toast.LENGTH_SHORT).show()
                        isChecked = false
                    }
                } else {
                    FloatMonitorThreads(context).hidePopupWindow()
                }
            }
        }
        view.findViewById<CompoundButton>(R.id.monitor_game).run {
            isChecked = FloatMonitorMini.show == true
            setOnClickListener {
                if (isChecked) {
                    FloatMonitorMini(context).showPopupWindow()
                } else {
                    FloatMonitorMini(context).hidePopupWindow()
                }
            }
        }
        view.findViewById<CompoundButton>(R.id.monitor_watch).run {
            isChecked = FloatFpsWatch.show == true
            setOnClickListener {
                if (isChecked) {
                    FloatFpsWatch(context).showPopupWindow()
                    /*
                    val serviceState = AccessibleServiceHelper().serviceRunning(context)
                    if (serviceState) {
                        FloatFpsWatch(context).showPopupWindow()
                    } else {
                        isChecked = false
                        Scene.toast("请在系统设置里激活[慕容调度 - 场景模式]辅助服务", Toast.LENGTH_SHORT)
                    }
                    */
                } else {
                    FloatFpsWatch(context).hidePopupWindow()
                }
            }
        }

        view.findViewById<View>(R.id.btn_cancel).setOnClickListener {
            dialog.dismiss()
        }
    }
}