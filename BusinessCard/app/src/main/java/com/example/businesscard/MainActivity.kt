package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(colorResource(R.color.background_green))
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(start = 32.dp, end = 32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val image = painterResource(id = R.drawable.android_logo)

            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
//                    .fillMaxWidth(0.4F)
                    .size(96.dp)
                    .background(colorResource(id = R.color.logo_bg_grey))
                    .padding(8.dp)
            )
            Text(
                text = stringResource(R.string.full_name),
                fontSize = 32.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = stringResource(R.string.title),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.icon_green),
                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp, top = 360.dp)
        ) {
            BottomInfoRow(
                Icons.Default.Phone,
                stringResource(R.string.phone),
            )
            BottomInfoRow(
                Icons.Default.Share,
                stringResource(R.string.share),
            )
            BottomInfoRow(
                Icons.Default.Email,
                stringResource(R.string.email),
            )
        }
    }
}

@Composable
fun BottomInfoRow(icon: ImageVector, text: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            icon,
            contentDescription = null,
            colorFilter = ColorFilter.tint(colorResource(id = R.color.icon_green)),
            modifier = Modifier
                .size(24.dp)
                .padding(end = 8.dp)
        )
        Text(
            text = text,
            fontSize = 12.sp,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}