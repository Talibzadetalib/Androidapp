package com.example.androidapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
class RecipesViewModel : ViewModel() {
    // Sample list of recipes
    private val allRecipes = listOf(
        Recipe(1, "Spaghetti Bolognese", "A classic Italian dish."),
        Recipe(2, "Chicken Curry", "A spicy and flavorful curry."),
        Recipe(3, "Vegetable Stir Fry", "A quick and healthy stir fry."),
        Recipe(4, "Pancakes", "A sweet breakfast favorite."),
        Recipe(5, "Grilled Cheese", "A simple and delicious sandwich.")
    )
    // StateFlow to expose filtered recipes
    private val _recipesStateFlow = MutableStateFlow(allRecipes)
    val recipesStateFlow: StateFlow<List<Recipe>> = _recipesStateFlow
    // Function to filter recipes based on query
    fun searchRecipes(query: String) {
        if (query.length < 3) {
            // If the query is less than 3 characters, show all recipes
            _recipesStateFlow.value = allRecipes
        } else {
            val filteredRecipes = allRecipes.filter { recipe ->
                recipe.title.contains(query, ignoreCase = true) ||
                        recipe.description.contains(query, ignoreCase = true)
            }
            // Update the state only if the result is different from the previous one
            if (filteredRecipes != _recipesStateFlow.value) {
                _recipesStateFlow.update { filteredRecipes }
            }
        }
    }
}