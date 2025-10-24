package com.innovape.responsi1mobileh1d023089

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.innovape.responsi1mobileh1d023089.databinding.ActivityClubHistoryBinding

class ClubHistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityClubHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityClubHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}