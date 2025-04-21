package com.example.tweetsycompose.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tweetsycompose.R
import com.example.tweetsycompose.viewModel.CategoryViewModel

@Composable
fun CategoryScreen(
    factory: () -> ViewModelProvider.Factory,
    launchDetailScreen: (category: String)-> Unit
) {
    //Had to pass the factory to create the viewModel within the composable but will
    //The VM shouldn't get recreated each time the composable is recomposed as per the documentation
    //It says that if the viewModel is already present in the scope then there it will reuse
    //the VM else it will create a fresh instance.
    val categoryViewModel: CategoryViewModel = viewModel(modelClass = CategoryViewModel::class, factory = factory())
    //Whenever state flow gets updated, the composable gets recomposed
    val categories by categoryViewModel.categories.collectAsState()

    if(categories.isEmpty()){
        Box(
            modifier = Modifier.fillMaxSize(1f),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "Loading...",
                style = MaterialTheme.typography.headlineLarge
            )
        }
    } else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            items(categories) {
                CategoryItem(category = it, launchDetailScreen)
            }
        }
    }
}

@Composable
fun CategoryItem(
    category: String,
    navigateToDetailScreen: (category: String) -> Unit
) {
    Box(modifier = Modifier
        .padding(4.dp)
        .clickable {
            navigateToDetailScreen(category)
        }
        .size(160.dp)
        .clip(RoundedCornerShape(8.dp))
        .paint(
            painter = painterResource(id = R.drawable.bg),
            contentScale = ContentScale.Crop
        )
        .border(1.dp, Color(0XFFEEEEEE)),
        contentAlignment = Alignment.BottomCenter
    ){
        Text(
            text = category,
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier.padding(0.dp, 20.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCategoryItem(){
    CategoryItem(category = "Hello", {})
}