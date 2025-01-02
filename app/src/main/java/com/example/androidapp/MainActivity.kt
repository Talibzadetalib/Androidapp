package com.example.androidapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.androidapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isFragmentAVisible = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Switch fragments
//        binding.switchFragmentButton.setOnClickListener {
//            val navController =
//                (supportFragmentManager.findFragmentById(R.id.bottomMenuContainer) as NavHostFragment).findNavController()
//            if (isFragmentAVisible) {
//                navController.navigate(R.id.fragmentB)
//            } else {
//                navController.navigate(R.id.fragmentA)
//            }
//            isFragmentAVisible = !isFragmentAVisible
//        }

    }
}