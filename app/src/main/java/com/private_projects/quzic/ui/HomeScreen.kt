package com.private_projects.quzic.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.private_projects.quzic.R
import com.private_projects.quzic.ui.theme.*

@Composable
fun HomeScreen() {
    NewsStory()
}

@Composable
fun NewsStory() {
    val image = painterResource(id = R.drawable.ic_launcher_background)
    val icon = painterResource(id = R.drawable.ic_launcher_foreground)
    val typography = MaterialTheme.typography
    var count by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        val imageModifier = Modifier
            .height(180.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(40.dp))
            .border(
                width = 4.dp,
                brush = Brush.linearGradient(colors = listOf(Pink80, Purple40, Yellow800)),
                shape = RoundedCornerShape(40.dp)
            )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = image,
                contentDescription = "foreground",
                modifier = imageModifier,
                contentScale = ContentScale.Crop
            )
            Icon(painter = icon, contentDescription = null, tint = Yellow900)
            Text(fontSize = 40.sp,text = "$count", color = Brown900)
        }
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = stringResource(R.string.first_string),
            style = typography.displaySmall,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Text(text = stringResource(R.string.second_string), style = typography.bodyLarge)
        Text(text = stringResource(R.string.third_string), style = typography.bodySmall)
        Button(onClick = {
            count++
        }) {
            Text(text = "Click me!")
        }
    }
}