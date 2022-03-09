package com.biocatch.dialogasfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        SDKManager.changeContext("MainActivity")
        findViewById<AppCompatButton>(R.id.clickMeButton).setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                findViewById<ConstraintLayout>(R.id.mainFormLayout).visibility = View.GONE
                changeFragment(MainFragment())
            }
        })
    }

    private fun changeFragment(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.placeHolder, fragment)
        ft.commit()
    }
}