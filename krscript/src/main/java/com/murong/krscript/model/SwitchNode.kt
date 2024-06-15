package com.murong.krscript.model

class SwitchNode(currentConfigXml: String) : RunnableNode(currentConfigXml){
    var getState: String = ""
    var checked = false
}