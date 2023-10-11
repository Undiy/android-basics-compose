package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                ArtSpace()
            }
        }
    }
}

val artworks = Artwork.artworks()

@Composable
fun ArtSpace() {
    var artworkIdx by remember { mutableStateOf(0) }

    val artwork = artworks[artworkIdx]

    Column(
        modifier = Modifier
            .padding(32.dp)
            .verticalScroll(rememberScrollState())
//            .fillMaxSize(),
                ,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        ArtworkDisplay(artwork)

        Spacer(Modifier.defaultMinSize(minHeight = 32.dp))

        ArtworkLabel(artwork)

        ArtworkControls(
            artworkIdx < artworks.lastIndex,
            { artworkIdx++ },
            artworkIdx > 0,
            { artworkIdx-- },
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        )
    }

}

@Composable
fun ArtworkDisplay(artwork: Artwork, modifier: Modifier = Modifier) {
    Surface(modifier = modifier
        .shadow(16.dp)
    ) {
        Image(
            painter = painterResource(id = artwork.image),
            contentDescription = stringResource(id = artwork.title),
            modifier = Modifier
                .padding(32.dp)
        )
    }
}

@Composable
fun ArtworkLabel(artwork: Artwork, modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .border(
            width = 4.dp,
            color = MaterialTheme.colorScheme.outlineVariant,
            RoundedCornerShape(8.dp)
        )
        .padding(16.dp)

    ) {
        Text(
            text = stringResource(id = artwork.title),
            style = MaterialTheme.typography.headlineLarge,
            fontStyle = FontStyle.Italic
        )
        Text(
            text = "${stringResource(id = artwork.artist)} (${stringResource(id = artwork.year)})",
            style = MaterialTheme.typography.labelLarge,
            fontStyle = FontStyle.Normal
        )
    }
}

@Composable
fun ArtworkControls(
    hasNext: Boolean,
    onNext: () -> Unit,
    hasPrevious: Boolean,
    onPrevious: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = onPrevious,
            enabled = hasPrevious
        ) {
            Text(
                text = stringResource(R.string.previous)
            )
        }
        Spacer(modifier = Modifier.defaultMinSize(minWidth = 16.dp))
        Button(
            onClick = onNext,
            enabled = hasNext
        ) {
            Text(
                text = stringResource(R.string.next)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpace()
    }
}