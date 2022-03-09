package com.biocatch.dialogasfragment

import android.app.Application
import android.util.Log
import com.biocatch.client.android.sdk.contract.ExtendedOptions
import com.biocatch.dialogasfragment.SDKManager.SDK_TAG
import java.util.*

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startBioCatch()
    }

    private fun startBioCatch() {
        val serverUrl = "https://wup-4ff4f23f.eu.v2.we-stats.com"
        val customerID = "dummy"
        val csId = UUID.randomUUID().toString()
        val extendedOptions = ExtendedOptions()     //.apply { enableHybridSolution = true }

        Log.d(SDK_TAG, "csId: $csId")

        with(SDKManager) {
            start(
                serverUrl = serverUrl,
                customerID = customerID,
                application = this@App,
                csid = csId,
                extendedOptions = extendedOptions
            )
        }
    }
}