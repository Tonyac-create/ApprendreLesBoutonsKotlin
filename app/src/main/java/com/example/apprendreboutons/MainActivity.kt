package com.example.apprendreboutons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apprendreboutons.ui.theme.ApprendreBoutonsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApprendreBoutonsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Body()
                }
            }
        }
    }
}

@Composable
fun Body() {

    val list = listOf("Angelique", "Cyril", "Léa", "Anthony")
    var color by remember {  mutableStateOf(Color.Black) }
    var count by remember { mutableStateOf(0) }
    var index by remember { mutableStateOf(0) }

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Salut ${list.get(index)}\nCount : $count", color = color)
        Button(
            shape = RoundedCornerShape(percent = 50),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 12.dp,
                pressedElevation = 0.dp
            ),
            onClick = {
                color = if (color == Color.Black) {
                        Color.Blue
                    } else {
                        Color.Black
                }
            }
        ) {
            Row() {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
                Text(text = "Changer de couleur")
            }

        }
        TextButton(onClick = { count++ }) {
            Text(text = "Incrémenter")
        }
        TextButton(
            onClick = { count-- },
            content = {Text(text = "Décrémenter", color = Color.Magenta)}
            )
        IconButton(onClick = { count = 0 }) {
            Icon(imageVector = Icons.Default.Done, contentDescription = null)
        }
        FloatingActionButton(
            onClick = {
                index = (list.indices).random()
        }) {
            Icon(imageVector = Icons.Default.Person, contentDescription = null)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ApprendreBoutonsTheme {
        Body()
    }
}