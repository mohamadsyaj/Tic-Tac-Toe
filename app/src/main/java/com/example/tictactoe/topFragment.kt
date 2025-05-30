package com.example.tictactoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tictactoe.databinding.FragmentTopBinding

class topFragment : Fragment() {
    private var _binding: FragmentTopBinding? = null
    private val binding get() = _binding!!

    private var player1Score = 0
    private var player2Score = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTopBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.resetButton.setOnClickListener{
            (activity as? MainActivity)?.resetGame()
        }
    }
    fun updateStatus(massage: String){
        binding.statusTextView.text = massage
    }
    fun addPlayerScore(player: String){
        if(player == "X"){
            player1Score++
            binding.player1Score.text = "Player 1 Score: $player1Score"
        }
        else{
            player2Score++
            binding.player2Score.text = "Player 2 Score: $player2Score"
        }
    }
    fun resetScores(){
        player1Score = 0
        player2Score = 0
        binding.player1Score.text = "Player 1 Score: 0"
        binding.player2Score.text = "Player 2 Score: 0"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}