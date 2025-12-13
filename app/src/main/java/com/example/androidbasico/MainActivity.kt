package com.example.androidbasico

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidbasico.ui.theme.AndroidBasicoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidBasicoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AllLayoutFstExample()
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String = "Default message", fromText: String = "Default From", modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = fromText,
            fontSize = 36.sp,
            lineHeight = 52.sp,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.End
        )
    }
}

@Composable
fun AllLayoutFstExample(modifier: Modifier = Modifier) {
    GreetingText(
        message = "Happy Birthday M!",
        fromText = "From Gabriel, your Love <3",
        modifier = modifier.padding(8.dp)
    )
    
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    AndroidBasicoTheme {
        AllLayoutFstExample()

    }
}