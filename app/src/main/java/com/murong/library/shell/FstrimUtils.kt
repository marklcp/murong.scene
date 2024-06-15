package com.murong.library.shell

import com.murong.common.shell.KeepShell

class FstrimUtils(private val keepShell: KeepShell) {
    fun run() {
        keepShell.doCmdSync("" +
                "fstrim /data\n" +
                "fstrim /data\n" +
                "fstrim /system\n" +
                "fstrim /system\n" +
                "fstrim /cache\n" +
                "fstrim /cache\n" +
                "sm fstrim\n")
    }
}