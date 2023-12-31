package com.example.recipeapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import com.example.recipeapp.data.Recipe
import com.example.recipeapp.ui.theme.RecipeTheme

// This page is the 'new' activity page, this is what the user will see after clicking on a list item.

//This was the start of the process to allow the user to be taken to the specific recipe they clicked on in the home page. 'getSerializableExtra is deprecated in API 33, I couldn't find an up to date tutorial explaining the changes to the process (that I could understand).
/*
private val recipe : Recipe by lazy{
    intent?.getSerializableExtra(RECIPE_ID) as Recipe
}
*/


class RecipeActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeTheme {
                Column(modifier = Modifier.fillMaxSize()) {
                    BoxWithConstraints {
                        Surface {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize(),
                            ) {
                                    RecPageTopBar()
                                    RecipeHeader(600.dp)
                                    RecipeName(2.dp)
                                    RecipeMethod(20.dp)
                                    RecipeNutrition(20.dp)
                                }


                            }
                        }

                    }

                }
            }

        }
    }
// Part 2 of issue getSerializableExtra Deprecated//

    /*object RecId{
    private const val RECIPE_ID = "recipe_id"
    fun newIntent(context: Context, recipe: Recipe) = Intent(context, RecipeActivity::class.java).apply {
        putExtra(RECIPE_ID, recipe)
    }
}
*/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecPageTopBar() {
    TopAppBar(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            .padding(10.dp),
        title = {
            Text(text = "ReciPie", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.onPrimary)
        },
        /*navigationIcon = {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back",
                color = MaterialTheme.colorScheme.onPrimary
            )
        },*/
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
    )
}

//Below this comment are functions that can be called into the field above


@Composable
    private fun RecipeHeader(containerHeight: Dp) {
        Image(
            modifier = Modifier
                .heightIn(max = containerHeight / 2)
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.fooditem),
            contentScale = ContentScale.Crop,
            contentDescription = null,
        )
    }

    @Composable
    private fun RecipeName(containerHeight: Dp) {
        Row(
            modifier = Modifier
                .padding(top = 25.dp, bottom = 10.dp, start = 15.dp, end = 15.dp)
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Recipe Name", style = MaterialTheme.typography.titleLarge)
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(top = 10.dp)
            ) {
                Text(text = "10 minutes", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }

    @Composable
    private fun RecipeMethod(containerHeight: Dp) {
        Column(
            modifier = Modifier
                .padding(top = 10.dp, bottom = 10.dp, start = 15.dp, end = 15.dp)
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Method:", style = MaterialTheme.typography.titleMedium)
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ut metus in felis dignissim venenatis. Suspendisse elementum risus nisl eu lacinia tellus placerat sit amet. Curabitur auctor justo eget tortor euismod sollicitudin quis id dui.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }

    @Composable
    private fun RecipeNutrition(containerHeight: Dp) {
        Column(
            modifier = Modifier
                .padding(top = 10.dp, bottom = 10.dp, start = 15.dp, end = 15.dp)
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Nutrition:", style = MaterialTheme.typography.titleMedium)
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ut metus in felis dignissim venenatis. Suspendisse elementum risus nisl eu lacinia tellus placerat sit amet. Curabitur auctor justo eget tortor euismod sollicitudin quis id dui.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }


