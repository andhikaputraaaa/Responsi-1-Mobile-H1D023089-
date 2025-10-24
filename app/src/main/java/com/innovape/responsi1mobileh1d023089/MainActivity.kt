package com.innovape.responsi1mobileh1d023089

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.innovape.responsi1mobileh1d023089.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initLayout()
        initListener()
    }

    private fun initLayout() {
        binding.layoutHistory.let {
            it.imgIcon.setImageResource(R.drawable.ic_history)
            it.tvLayout.setText(R.string.club_history)
        }
        binding.layoutCoach.let {
            it.imgIcon.setImageResource(R.drawable.ic_coach)
            it.tvLayout.setText(R.string.head_coach)
        }
        binding.layoutSquad.let {
            it.imgIcon.setImageResource(R.drawable.ic_squad)
            it.tvLayout.setText(R.string.squad)
        }
    }

    private fun initListener() {
        binding.layoutHistory.root.setOnClickListener {
            startActivity(Intent(this, ClubHistoryActivity::class.java))
        }

        binding.layoutCoach.root.setOnClickListener {
            val intent = Intent(this, HeadCoachActivity::class.java)
            intent.putExtra("TEAM_ID", 11)
            startActivity(intent)
        }

        binding.layoutSquad.root.setOnClickListener {
            val intent = Intent(this, TeamSquadActivity::class.java)
            intent.putExtra("TEAM_ID", 11)
            startActivity(intent)
        }
    }
}