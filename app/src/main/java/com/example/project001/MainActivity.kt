package com.example.project001

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.project001.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //viewbinding initialization

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        Thread.sleep(3000)
        //viewbinding assignation
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //getting views from binding
        binding.apply {


            btnGenerate.setOnClickListener {
                if(eTname.text.isNullOrBlank()){
                    eTname.error="Please enter name"
                }
                else{
                val userEnteredText=eTname.text.toString()
                val passingdatatodisplay = Intent(this@MainActivity,DisplayScreen::class.java)
                passingdatatodisplay.putExtra("name",userEnteredText)
                startActivity(passingdatatodisplay)
            }
            }

        }


    }
}