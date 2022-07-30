package com.ropstam.demoapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ropstam.demoapp.R
import com.ropstam.demoapp.databinding.ActivityItemDetailsBinding
import com.ropstam.demoapp.databinding.ActivityMainBinding

class ItemDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityItemDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.apply {
            textViewBack.setOnClickListener { onBackPressed() }

            textView6x3.setOnClickListener { changeBackground(it) }
            textView6x4.setOnClickListener { changeBackground(it) }
            textView6x5.setOnClickListener { changeBackground(it) }
            textView6x6.setOnClickListener { changeBackground(it) }
        }
    }

    private fun changeBackground(view:View){
        when(view.id){
            R.id.textView6x3->{
                binding.textView6x3.background = getDrawable(R.drawable.blue_stroke)
                binding.textView6x4.background = getDrawable(R.drawable.white_stroke)
                binding.textView6x5.background = getDrawable(R.drawable.white_stroke)
                binding.textView6x6.background = getDrawable(R.drawable.white_stroke)
            }
            R.id.textView6x4->{
                binding.textView6x3.background = getDrawable(R.drawable.white_stroke)
                binding.textView6x4.background = getDrawable(R.drawable.blue_stroke)
                binding.textView6x5.background = getDrawable(R.drawable.white_stroke)
                binding.textView6x6.background = getDrawable(R.drawable.white_stroke)
            }
            R.id.textView6x5->{
                binding.textView6x3.background = getDrawable(R.drawable.white_stroke)
                binding.textView6x4.background = getDrawable(R.drawable.white_stroke)
                binding.textView6x5.background = getDrawable(R.drawable.blue_stroke)
                binding.textView6x6.background = getDrawable(R.drawable.white_stroke)
            }
            R.id.textView6x6->{
                binding.textView6x3.background = getDrawable(R.drawable.white_stroke)
                binding.textView6x4.background = getDrawable(R.drawable.white_stroke)
                binding.textView6x5.background = getDrawable(R.drawable.white_stroke)
                binding.textView6x6.background = getDrawable(R.drawable.blue_stroke)
            }
        }

    }
}