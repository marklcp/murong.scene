package com.murong.diaodu.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.murong.diaodu.R
import kotlinx.android.synthetic.main.fragment_donate.*

class FragmentDonate : Fragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_donate, container, false)

    override fun onResume() {
        super.onResume()
        // activity!!.title = getString(R.string.menu_paypal)
        activity!!.title = getString(R.string.app_name)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pay_alipay.setOnClickListener {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_link))
            sendIntent.type = "text/plain"
            startActivity(sendIntent)
        }

        pay_wxpay.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&k=BuaZdRKusnEUUuHdnN1z1_PgazhNcY0P&authKey=OOdbzey5xNjheKKYCIn2xzzQ6LgfsVRzK8dMD3a3JXaZ%2BRPpIMuPcf9oXJLlckHb&noverify=0&group_code=974835379")))
        }
    }

    override fun onClick(v: View?) {
        // Handle other click events if needed
    }
}