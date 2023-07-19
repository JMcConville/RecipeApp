package com.example.recipeapp

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp

import com.example.recipeapp.data.DataProvider
import com.example.recipeapp.data.Recipe

// a composable that uses 'DataProvider' to create a list of recipes based off the values in the 'Data' file. naviateToProfile is set to allow the list to be clickable and for the user to be taken to the correct page

@Composable
fun RecipeHomeContent(navigateToProfile: (Recipe) -> Unit){
    val recipes = remember {DataProvider.recipeList}
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ){
        items(
            items = recipes,
            itemContent = {
                RecipeListItem(recipe = it, navigateToProfile)
            }
        )
    }
}