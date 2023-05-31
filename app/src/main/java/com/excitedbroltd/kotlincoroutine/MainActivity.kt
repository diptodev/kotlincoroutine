package com.excitedbroltd.kotlincoroutine

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.excitedbroltd.kotlincoroutine.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.buttonSubmit.setOnClickListener {
            for (i in 1..100000) {
                Log.i("DebugLog", "onCreate: $i")
            }


            Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()
        }
    }
}