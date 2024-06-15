package com.murong.store

import android.content.Context
import com.murong.common.shared.ObjectStorage
import com.murong.model.TimingTaskInfo

class TimingTaskStorage(private val context: Context) : ObjectStorage<TimingTaskInfo>(context) {
    override public fun load(configFile: String): TimingTaskInfo? {
        return super.load(configFile)
    }

    public fun save(obj: TimingTaskInfo): Boolean {
        return super.save(obj, obj.taskId)
    }

    override public fun remove(configFile: String) {
        super.remove(configFile)
    }
}