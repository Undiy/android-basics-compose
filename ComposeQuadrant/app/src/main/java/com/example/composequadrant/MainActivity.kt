package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Quadrants()
                }
            }
        }
    }
}

@Composable
fun Quadrant(color: Color, title: String, text: String, modifier: Modifier) {
    Surface(
        color = color,
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = text,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Composable
fun Quadrants(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.weight(1F)
        ) {
            Quadrant(
                color = Color(0xFFEADDFF),
                title = stringResource(R.string.text_composable_title),
                text = stringResource(R.string.text_composable_text),
                modifier = Modifier.weight(1F)
            )
            Quadrant(
                color = Color(0xFFD0BCFF),
                title = stringResource(R.string.image_composable_title),
                text = stringResource(R.string.image_composable_text),
                modifier = Modifier.weight(1F)
            )
        }
        Row(
            modifier = Modifier.weight(1F)
        ) {
            Quadrant(
                color = Color(0xFFB69DF8),
                title = stringResource(R.string.row_composable_title),
                text = stringResource(R.string.row_composable_text),
                modifier = Modifier.weight(1F)
            )
            Quadrant(
                color = Color(0xFFF6EDFF),
                title = stringResource(R.string.column_composable_title),
                text = stringResource(R.string.column_composable_text),
                modifier = Modifier.weight(1F)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuadrantPreview() {
    ComposeQuadrantTheme {
        Quadrants()
    }
}