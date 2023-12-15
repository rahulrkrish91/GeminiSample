package com.example.sampleapp

 import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.sampleapp.databinding.ActivityMainBinding
import com.example.sampleapp.ui.WhatIsInImageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val whatIsInImageViewModel: WhatIsInImageViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupObservers()
        whatIsInImageViewModel.getImageInfo(applicationContext)
    }

    private fun setupObservers() {
        whatIsInImageViewModel.mutableImageInfo.observe(this@MainActivity) {
            binding.progressBar.visibility = View.GONE
            binding.lblImageContent.text = it
        }
    }
}