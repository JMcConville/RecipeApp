package com.example.recipeapp.data

import androidx.compose.ui.graphics.painter.Painter
import java.io.Serializable

// a data class which allows us to set values for different variables of our the recipes, these values will be declared in the DataProvider file
data class Recipe(
    val id: Int,
    val title: String,
    val description: String,
    val method: String,
    val nutrition: String,
    val RecipeImageId: Int = 0,
) //:Serializable - this was an attempt to take the user to the exact recipe page that they clicked on, further comments about the issue are explained in RecipeActivity