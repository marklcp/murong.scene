package com.murong.krscript.ui

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.murong.krscript.R
import com.murong.krscript.model.PageNode

class ListItemPage(context: Context, config: PageNode) : ListItemClickable(context, R.layout.kr_action_list_item, config) {
    private val widgetView = layout.findViewById<ImageView?>(R.id.kr_widget)

    init {
        widgetView?.visibility = View.VISIBLE
        widgetView?.setImageDrawable(context.getDrawable(R.drawable.kr_arrow))
    }
}