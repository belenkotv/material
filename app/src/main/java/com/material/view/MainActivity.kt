package com.material.view

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatDelegate
import com.material.view.chips.SettingsFragment
import com.material.view.picture.PictureOfTheDayFragment
import com.material.R

class Parameters {

    var resetFragment: Boolean = false
    var theme: Int = R.style.Theme_Material

    companion object {
        @Volatile
        private var INSTANCE: Parameters? = null
        fun getInstance(): Parameters {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Parameters()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(Parameters.getInstance().theme)
        setContentView(R.layout.activity_main)
        if ((savedInstanceState == null) || Parameters.getInstance().resetFragment) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PictureOfTheDayFragment.newInstance()).commit()
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, SettingsFragment.newInstance()).commit()
        }
        //recreate()
    }

    private fun isConnecton(): Boolean {
        return true
    }

}