package com.innovape.responsi1mobileh1d023089

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.innovape.responsi1mobileh1d023089.adapter.PlayerAdapter
import com.innovape.responsi1mobileh1d023089.data.model.TeamResponse
import com.innovape.responsi1mobileh1d023089.data.network.RetrofitInstance
import com.innovape.responsi1mobileh1d023089.databinding.ActivityTeamSquadBinding
import com.innovape.responsi1mobileh1d023089.fragment.PlayerDetailBottomSheet
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamSquadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTeamSquadBinding
    private var teamId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        binding = ActivityTeamSquadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        teamId = intent.getIntExtra("TEAM_ID", 0)

        setupRecyclerView()
        fetchTeamSquad()
    }

    private fun setupRecyclerView() {
        binding.rvPlayers.layoutManager = LinearLayoutManager(this)
    }

    private fun fetchTeamSquad() {
        RetrofitInstance.api.getTeamById(teamId).enqueue(object : Callback<TeamResponse> {
            override fun onResponse(call: Call<TeamResponse>, response: Response<TeamResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let { teamResponse ->
                        val adapter = PlayerAdapter(teamResponse.squad) { player ->
                            val bottomSheet = PlayerDetailBottomSheet.newInstance(player)
                            bottomSheet.show(supportFragmentManager, "PlayerDetailBottomSheet")
                        }
                        binding.rvPlayers.adapter = adapter
                    }
                } else {
                    Log.e("TeamSquadActivity", "Error: ${response.code()} - ${response.message()}")
                    Toast.makeText(
                        this@TeamSquadActivity,
                        "Failed to load team squad: ${response.code()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<TeamResponse>, t: Throwable) {
                Log.e("TeamSquadActivity", "Error: ${t.message}", t)
                Toast.makeText(
                    this@TeamSquadActivity,
                    "Error: ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}