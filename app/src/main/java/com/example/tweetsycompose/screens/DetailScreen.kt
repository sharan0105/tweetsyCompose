package com.example.tweetsycompose.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tweetsycompose.viewModel.DetailViewModel

@Composable
fun DetailScreen(
    factory:() -> ViewModelProvider.Factory,
    category: String
)
{
    val viewModel = viewModel(modelClass = DetailViewModel::class, factory = factory())
    //Trigger the API to collect quotes for the given category
    viewModel.getTweets(category)
    val tweetList = viewModel.tweets.collectAsState()
    LazyColumn{
        items(tweetList.value){
            TweetsListItem(tweet = it.text)
        }
    }

}


@Composable
fun TweetsListItem(tweet: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        border = BorderStroke(1.dp, Color(0xFFCCCCCC))
    ) {
        Text(
            text = tweet,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyMedium
        )

    }
}

@Preview
@Composable
fun PreviewTweetListItem(){
    TweetsListItem(tweet = "You got this")
}