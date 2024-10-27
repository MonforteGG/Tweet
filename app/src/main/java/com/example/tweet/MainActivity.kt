package com.example.tweet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tweet.ui.theme.TweetTheme
import com.example.tweet.ui.theme.Background

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TweetTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        Modifier
                            .padding(innerPadding)
                            .background(color = Color.Gray))
                    {
                        Tweet()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    TweetTheme {
        Box(
            Modifier
                .fillMaxSize()
                .background(color = Color.Gray))
        {
            Tweet()
        }
    }
}


@Composable
fun Tweet() {

    var isCommented by remember { mutableStateOf(false) }
    var commentCount by remember { mutableStateOf(0) }

    var isRetweeted by remember { mutableStateOf(false) }
    var retweetCount by remember { mutableStateOf(0) }

    var isLiked by remember { mutableStateOf(false) }
    var likeCount by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 12.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Imagen perfil",
                    modifier = Modifier.size(50.dp)
                )
                Column(modifier = Modifier.padding(12.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Blanca", color = Color.White)
                        Text(text = "@BlancaDevs", color = Color.Gray)
                        Text(text = "6h", color = Color.Gray)
                        Spacer(modifier = Modifier.height(5.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.ic_dots),
                            contentDescription = "Three Dots",
                            tint = Color.White
                        )
                    }
                    Text(
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
                        color = Color.White
                    )
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "Large Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .padding(10.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )

                    Spacer(modifier = Modifier.height(5.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth().padding(end = 30.dp),
                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {

                        Row (verticalAlignment = Alignment.CenterVertically) {
                            IconButton(onClick = {
                                if (isCommented) commentCount-- else commentCount++
                                isCommented = !isCommented
                            }) {
                                Icon(
                                    painter = painterResource(
                                        id = if (isCommented) R.drawable.ic_chat_filled else R.drawable.ic_chat
                                    ),
                                    contentDescription = "Comments",
                                    tint = Color.Gray
                                )
                            }
                            Text(text = "$commentCount", color = Color.Gray)
                        }

                        Row (verticalAlignment = Alignment.CenterVertically) {
                            IconButton(onClick = {
                                if (isRetweeted) retweetCount-- else retweetCount++
                                isRetweeted = !isRetweeted
                            }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_rt),
                                    contentDescription = "Retweets",
                                    tint = if (isRetweeted) Color.Green else Color.Gray
                                )
                            }
                            Text(text = "$retweetCount", color = Color.Gray)
                        }

                        Row (verticalAlignment = Alignment.CenterVertically) {
                            IconButton(onClick = {
                                if (isLiked) likeCount-- else likeCount++
                                isLiked = !isLiked
                            }) {
                                Icon(
                                    painter = painterResource(
                                        id = if (isLiked) R.drawable.ic_like_filled else R.drawable.ic_like
                                    ),
                                    contentDescription = "Retweets",
                                    tint = if (isLiked) Color.Red else Color.Gray
                                )
                            }
                            Text(text = "$likeCount", color = Color.Gray)
                        }

                    }
                }
            }
        }
    }
}

