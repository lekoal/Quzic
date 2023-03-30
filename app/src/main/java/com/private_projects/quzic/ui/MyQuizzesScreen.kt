package com.private_projects.quzic.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.private_projects.quzic.R
import com.private_projects.quzic.ui.theme.*

@Composable
fun MyQuizzesScreen() {
    val typography = MaterialTheme.typography
    val context = LocalContext.current
    val mainColumnModifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(horizontal = 10.dp, vertical = 30.dp)
    Column(modifier = mainColumnModifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.my_quizzes_title),
                style = typography.headlineLarge
            )
            Text(
                text = "temp_user_name",
                style = typography.titleLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = CutCornerShape(10.dp))
                .border(
                    width = 4.dp,
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Yellow600,
                            Yellow800,
                            Yellow900
                        )
                    ),
                    shape = CutCornerShape(10.dp)
                )
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(PurpleGrey40, Pink40)
                    )
                )
        ) {
            itemsIndexed(
                listOf(
                    "One",
                    "Two",
                    "Three",
                    "Four",
                    "Five",
                    "Six",
                    "Seven"
                )
            ) { index, item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(8.dp, 5.dp),
                    shape = CutCornerShape(10.dp),
                    elevation = CardDefaults.cardElevation(5.dp)
                ) {
                    Row(modifier = Modifier
                        .fillMaxSize()
                        .clip(shape = CutCornerShape(10.dp))
                        .clickable {
                            Toast
                                .makeText(context, item, Toast.LENGTH_SHORT)
                                .show()
                        }) {
                        Text(
                            text = "${index + 1}. $item",
                            fontSize = 30.sp,
                            modifier = Modifier.padding(5.dp)
                        )
                    }
                }
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp, 20.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingActionButton(
            modifier = Modifier
                .border(width = 2.dp, color = Brown900, shape = CutCornerShape(15.dp)),
            shape = CutCornerShape(15.dp),
            elevation = FloatingActionButtonDefaults.elevation(5.dp),
            onClick = {
                Toast.makeText(context, "ADD QUIZ", Toast.LENGTH_SHORT).show()
            }
        ) {
            Icon(painter = painterResource(R.drawable.baseline_add_24), contentDescription = null)
        }
    }
}