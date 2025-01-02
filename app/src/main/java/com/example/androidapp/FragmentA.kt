package com.example.androidapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidapp.databinding.FragmentABinding

class FragmentA :CoreFragment<FragmentABinding>() {

    private val recipeAdapter = RecipeAdapter(
        emptyList(),
        itemClickListener = { id ->
            Toast.makeText(requireContext(), "Item clicked: $id", Toast.LENGTH_SHORT).show()
            Log.d("FragmentA", "Item clicked: $id")
        },
        buttonClickListener = { action, id ->
            Toast.makeText(requireContext(), "$action clicked for item $id", Toast.LENGTH_SHORT)
                .show()
            Log.d("FragmentA", "$action clicked for item $id")
        }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentABinding.inflate(inflater, container, false)

        binding?.recyclerView?.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = recipeAdapter
        }

        loadRecipes()

        return binding?.root
    }

    private fun loadRecipes() {
        val recipes = listOf(
            RecipeModel(
                1,
                "Spaghetti",
                "Delicious spaghetti recipe.",
                "https://images.pexels.com/photos/1279330/pexels-photo-1279330.jpeg"
            ),
            RecipeModel(
                2,
                "Pizza",
                "Tasty pizza recipe.",
                "https://images.pexels.com/photos/315755/pexels-photo-315755.jpeg"
            )
            // Add more recipes
        )

        // Update adapter's data
        recipeAdapter.updateData(recipes)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}