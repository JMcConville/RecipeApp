package com.example.recipeapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.recipeapp.data.Recipe

// This function creates a card based layout, which displays content taken from the DataProvider file

@Composable
fun RecipeListItem(recipe: Recipe, navigateToProfile: (Recipe)->Unit) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 8.dp)
            .fillMaxWidth(),
        border = BorderStroke(3.dp, Color.Black),
        elevation = CardDefaults.cardElevation(15.dp),

    ) {
        Row (Modifier.clickable { navigateToProfile(recipe) }){
            RecipeImage(recipe)
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = recipe.title, style = typography.titleMedium)
                Text(text = recipe.description, style = typography.bodyMedium)
            }

        }
    }
}

// creating the image layout on the card, this will be called in the row section of the RecipeListItem function
@Composable
fun RecipeImage(recipe: Recipe){
    Image(
        painter = painterResource(id = recipe.RecipeImageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(1.dp)
            .size(120.dp)
    )
}
