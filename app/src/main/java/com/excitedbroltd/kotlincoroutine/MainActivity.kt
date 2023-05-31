package com.excitedbroltd.kotlincoroutine

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.excitedbroltd.kotlincoroutine.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        var count = 0
        CoroutineScope(Dispatchers.IO).launch {
            count = getCount()

        }
        binding.buttonSubmit.setOnClickListener {
            Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private suspend fun getCount(): Int {
        var count = 0;
        coroutineScope {
            for (i in 1..200000) {
                count = i
                Log.d("TAG", "getCount: $i")
                withContext(Dispatchers.Main){
                    binding.textView.text = "$count"
                }

            }
        }
        return count
    }
}