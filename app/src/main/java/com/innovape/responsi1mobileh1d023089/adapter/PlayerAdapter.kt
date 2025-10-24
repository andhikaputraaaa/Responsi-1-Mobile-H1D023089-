package com.innovape.responsi1mobileh1d023089.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.innovape.responsi1mobileh1d023089.data.model.Player
import com.innovape.responsi1mobileh1d023089.databinding.ItemPlayerBinding

class PlayerAdapter(
    private val players: List<Player>,
    private val onItemClick: (Player) -> Unit
) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    inner class PlayerViewHolder(private val binding: ItemPlayerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(player: Player) {
            binding.tvPlayerName.text = player.name
            binding.tvPlayerNationality.text = player.nationality

            val backgroundColor = when {
                player.position.contains("Goalkeeper", ignoreCase = true) -> Color.YELLOW
                player.position.contains("Defence", ignoreCase = true) ||
                        player.position.contains("Right-Back", ignoreCase = true) ||
                        player.position.contains("Centre-Back", ignoreCase = true) ||
                        player.position.contains("Left-Back", ignoreCase = true) -> Color.BLUE
                player.position.contains("Midfield", ignoreCase = true) ||
                        player.position.contains("Left Midfield", ignoreCase = true) ||
                        player.position.contains("Defensive Midfield", ignoreCase = true) ||
                        player.position.contains("Attacking Midfield", ignoreCase = true) ||
                        player.position.contains("Central Midfield", ignoreCase = true) -> Color.GREEN
                player.position.contains("Offence", ignoreCase = true) ||
                        player.position.contains("Centre-Forward", ignoreCase = true) ||
                        player.position.contains("Right Winger", ignoreCase = true) -> Color.RED
                else -> Color.LTGRAY
            }
            binding.PlayerContainer.setBackgroundColor(backgroundColor)

            binding.root.setOnClickListener {
                onItemClick(player)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val binding = ItemPlayerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PlayerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bind(players[position])
    }

    override fun getItemCount(): Int = players.size
}