package com.example.project001

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.project001.databinding.ActivityDisplayScreenBinding
import kotlin.random.Random

class DisplayScreen : AppCompatActivity() {
    private lateinit var binding: ActivityDisplayScreenBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDisplayScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            val username =getusername()
            val rNumber= generaterandomnumber()

            dispName.text="Hi $username, Here we go..."
            luckyNm.text=""+rNumber.toString()
            shareBtn.setOnClickListener {
                implicitintent(username,rNumber)
            }
        }
    }
    private fun implicitintent(username:String,num:Int) {
        val share=Intent(Intent.ACTION_SEND)
        share.putExtra(Intent.EXTRA_SUBJECT,"$username is super exited to share")
        share.putExtra(Intent.EXTRA_TEXT,"Here is the Lucky Number $num")
        share.type="Plain/text"
        startActivity(share)
    }

    private fun generaterandomnumber(): Int {
        return Random.nextInt(1000)
    }

    private fun getusername():String {
        val bundle:Bundle?=intent.extras
        val name =bundle?.getString("name")
        return name!!

    }
}