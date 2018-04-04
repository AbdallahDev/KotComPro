package com.example.user.kotcompro

import android.bluetooth.BluetoothAdapter
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            var manager=getSystemService(Context.WIFI_SERVICE)
                         as WifiManager
            manager.isWifiEnabled=true
        }

        button2.setOnClickListener {
            var manager=getSystemService(Context.WIFI_SERVICE)
                    as WifiManager
            manager.isWifiEnabled=false
        }

        button3.setOnClickListener {
            var ba=BluetoothAdapter.getDefaultAdapter()
            if(!ba.isEnabled)
            {
                var i=Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                startActivityForResult(i,0)
            }
            else
                Toast.makeText(this,"BL is on",
                        Toast.LENGTH_LONG).show()
        }

        button4.setOnClickListener {
            var ba=BluetoothAdapter.getDefaultAdapter()
            ba.disable()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

}
