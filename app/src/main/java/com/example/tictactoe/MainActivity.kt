package com.example.tictactoe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun resetGame(){
        val bottomFragment = supportFragmentManager.findFragmentById(R.id.bottomFragment) as? bottomFragment
        bottomFragment?.resetBoard()

        val topFragment = supportFragmentManager.findFragmentById(R.id.topFragment) as? topFragment
        topFragment?.updateStatus("Player 1's turn")
    }
}
