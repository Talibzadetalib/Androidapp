package com.example.androidapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidapp.databinding.FragmentRecipesBinding
import com.example.androidapp.CoreFragment
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
class RecipesFragment : CoreFragment<FragmentRecipesBinding>() {
    private val viewModel: RecipesViewModel by lazy { RecipesViewModel() }
    private val recipesAdapter = RecipesAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentRecipesBinding.inflate(inflater, container, false)
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupSearchView()
        // Collect the StateFlow to update the RecyclerView
        lifecycleScope.launch {
            viewModel.recipesStateFlow.collectLatest { recipes ->
                recipesAdapter.submitList(recipes)
            }
        }
    }
    private fun setupRecyclerView() {
        binding?.recipesRecyclerView?.layoutManager = LinearLayoutManager(requireContext())
        binding?.recipesRecyclerView?.adapter = recipesAdapter
    }
    private fun setupSearchView() {
        binding?.recipeSearchView?.setOnQueryTextListener(object :
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { viewModel.searchRecipes(it) }
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { viewModel.searchRecipes(it) }
                return true
            }
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}