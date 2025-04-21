package com.example.tweetsycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tweetsycompose.screens.CategoryScreen
import com.example.tweetsycompose.screens.DetailScreen
import com.example.tweetsycompose.ui.theme.TweetsyComposeTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component = (application as? TweetsyApplication)?.appComponent
        component?.injectMainActivity(this)
        setContent {
            TweetsyComposeTheme {
                //Whenever you need to implement a material design layout
                //such as a toolbar, bottomBar, snackBar, FAB, you can use scaffold
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Tweetsy")
                            },
                            colors = topAppBarColors(
                                containerColor = Color.Black,
                                titleContentColor = Color.White
                            )
                        )
                    }
                ) {
                    Box(
                        modifier = Modifier.padding(it)
                    ){
                        App { viewModelFactory }
                    }
                }
            }
        }
    }
}

@Composable
fun App(viewModelFactoryProvider: ()-> ViewModelProvider.Factory) {
    val navController = rememberNavController()
    NavHost(navController = navController , startDestination = "category"){
        composable(route = "category") {
            CategoryScreen(viewModelFactoryProvider) {
                navController.navigate("detail/$it")
            }
        }

        composable(
            route = "detail/{category}",
            arguments = listOf(navArgument("category"){
                type = NavType.StringType
            })
        ) {
            val category = it.arguments?.getString("category") ?: "default"
            DetailScreen(viewModelFactoryProvider, category)
        }
    }
}