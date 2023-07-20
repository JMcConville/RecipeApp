package com.example.recipeapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.example.recipeapp.data.Recipe
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.recipeapp.ui.theme.RecipeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeTheme {
                //calling our function that takes the structure of another function and allows it to be clickable to a new activity, which will be the recipe page
                RecipeApp(){
                    startActivity(Intent(this, RecipeActivity::class.java))
                }
                RecTopBar()
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecTopBar() {
    TopAppBar(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            .padding(10.dp),
        title = {
            Text(text = "ReciPie", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.onPrimary)
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
    )
}
// creating a function that gets information created in the function RecipeHomeContent from RecipeHome.kt
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeApp(navigateToProfile: (Recipe)->Unit){
    Scaffold ( modifier = Modifier.padding(top = 80.dp),

        content = {
            RecipeHomeContent(navigateToProfile = navigateToProfile)
        }
    )
}