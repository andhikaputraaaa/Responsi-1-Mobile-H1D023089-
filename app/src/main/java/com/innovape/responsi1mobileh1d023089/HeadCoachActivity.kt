package com.innovape.responsi1mobileh1d023089

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.innovape.responsi1mobileh1d023089.data.model.TeamResponse
import com.innovape.responsi1mobileh1d023089.data.network.RetrofitInstance
import com.innovape.responsi1mobileh1d023089.databinding.ActivityHeadCoachBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeadCoachActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityHeadCoachBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityHeadCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Get team ID from intent
        val teamId = intent.getIntExtra("TEAM_ID", 0)
        fetchCoachData(teamId)
    }
    
    private fun fetchCoachData(teamId: Int) {
        RetrofitInstance.api.getTeamById(teamId).enqueue(object : Callback<TeamResponse> {
            override fun onResponse(call: Call<TeamResponse>, response: Response<TeamResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let { teamResponse ->
                        val coach = teamResponse.coach
                        
                        binding.tvName.text = coach.name
                        binding.tvBirthDate.text = coach.dateOfBirth
                        binding.tvCountry.text = coach.nationality
                    }
                } else {
                    Toast.makeText(
                        this@HeadCoachActivity,
                        "Gagal memuat data pelatih",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<TeamResponse>, t: Throwable) {
                Log.e("HeadCoachActivity", "Error fetching coach data", t)
                Toast.makeText(
                    this@HeadCoachActivity,
                    "Gagal memuat data pelatih: ${t.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        })
    }
}