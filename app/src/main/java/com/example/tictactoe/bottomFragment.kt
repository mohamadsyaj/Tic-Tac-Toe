package com.example.tictactoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.tictactoe.databinding.FragmentBottomBinding

class bottomFragment : Fragment() {
    private var _binding: FragmentBottomBinding? = null
    private val binding get () = _binding!!
    private var currentPlayer = "Player 1"
    private var currentSymbol = "X"
    private lateinit var buttons: List<Button>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBottomBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttons = listOf(
            binding.button1,
            binding.button2,
            binding.button3,
            binding.button4,
            binding.button5,
            binding.button6,
            binding.button7,
            binding.button8,
            binding.button9,
        )

        for(button in buttons) {
            button.setOnClickListener{
                button.text = currentSymbol
                button.isEnabled = false

                val winner = gameStatues()
                if (!winner) switchPlayer()
            }
        }//End loop
    }//end onViewCreated
    private fun switchPlayer() {
        if(currentSymbol == "X"){
            currentSymbol = "O"
            currentPlayer = "Player 2"
        }
        else{
            currentSymbol = "X"
            currentPlayer = "Player 1"
        }
        val topFragment = parentFragmentManager.findFragmentById(R.id.topFragment) as? topFragment
        topFragment?.updateStatus("$currentPlayer's Turn")
    }
    fun resetBoard(){
        for(button in buttons){
            button.text = ""
            button.isEnabled = true
        }
        currentPlayer = "Player 1"
        currentSymbol = "X"
    }//end reset player
    private fun gameStatues() : Boolean{
        val board = buttons.map {it.text.toString()}
        val winnerPattern = listOf(
            listOf(0,1,2),
            listOf(3,4,5),
            listOf(6,7,8),
            listOf(0,3,6),
            listOf(1,4,7),
            listOf(2,5,8),
            listOf(0,4,8),
            listOf(2,4,6)
        )
        for (pattern in winnerPattern){
            val (a,b,c) = pattern
            if(board[a] == currentSymbol && board[b] == currentSymbol && board[c] == currentSymbol){
                disableButtons()
                val topFragment = parentFragmentManager.findFragmentById(R.id.topFragment) as? topFragment
                topFragment?.addPlayerScore(currentSymbol)
                topFragment?.updateStatus("$currentPlayer's Wins")
                return true
            }
        }
        if (board.all { it.isNotEmpty()}){
            val topFragment = parentFragmentManager.findFragmentById(R.id.topFragment) as? topFragment
            topFragment?.updateStatus("Draw")
            return true
        }
        return false
    }//end gameStatus

    private fun disableButtons(){
        for (button in buttons){
            button.isEnabled = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}//end fragment