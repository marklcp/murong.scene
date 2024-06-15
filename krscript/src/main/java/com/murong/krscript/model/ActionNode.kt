package com.murong.krscript.model

import java.util.*

class ActionNode(currentConfigXml: String) : RunnableNode(currentConfigXml){
    var params: ArrayList<ActionParamInfo>? = null
}