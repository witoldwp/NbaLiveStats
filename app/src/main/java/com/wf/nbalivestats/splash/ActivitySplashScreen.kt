package com.wf.nbalivestats.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.aghajari.powerview.AXPowerView
import com.wf.nbalivestats.features.main.MainActivity
import com.wf.nbalivestats.R

class ActivitySplashScreen : AppCompatActivity() {

    private val delaySwitchToLoading : Long = 1
    private val delaySwitchToSucceed : Long = 1
    private val delaySwitchToNavigateFurther : Long = 2000

    override fun onCreate(savedInstantState: Bundle?) {
        super.onCreate(savedInstantState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splash_screen)
        animateLoading()
    }

    private fun animateLoading() {
        Handler(Looper.myLooper()!!).postDelayed({
            findViewById<AXPowerView>(R.id.power_view).setState(AXPowerView.State.LOADING)
            animateSuccess()
        }, delaySwitchToLoading)
    }

    private fun animateSuccess() {
        Handler(Looper.myLooper()!!).postDelayed({
            findViewById<AXPowerView>(R.id.power_view).setState(AXPowerView.State.SUCCEED)
            navigateToApp()
        }, delaySwitchToSucceed)
    }

    private fun navigateToApp() {
        Handler(Looper.myLooper()!!).postDelayed({
            startApp()
        }, delaySwitchToNavigateFurther)
    }

    private fun startApp() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}