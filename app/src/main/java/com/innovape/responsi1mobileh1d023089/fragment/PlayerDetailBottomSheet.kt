package com.innovape.responsi1mobileh1d023089.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.innovape.responsi1mobileh1d023089.data.model.Player
import com.innovape.responsi1mobileh1d023089.databinding.FragmentPlayerDetailBinding

class PlayerDetailBottomSheet : BottomSheetDialogFragment() {
    private var _binding: FragmentPlayerDetailBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val ARG_PLAYER = "player"

        fun newInstance(player: Player): PlayerDetailBottomSheet {
            val fragment = PlayerDetailBottomSheet()
            val args = Bundle()
            args.putSerializable(ARG_PLAYER, player)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayerDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getSerializable(ARG_PLAYER)?.let { player ->
            val playerData = player as Player
            binding.apply {
                tvPlayerName.text = playerData.name
                tvDateOfBirth.text = playerData.dateOfBirth
                tvNationality.text = playerData.nationality
                tvPosition.text = playerData.position
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}