package com.example.superheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero
import com.example.superheroes.model.HeroesRepository
import com.example.superheroes.ui.theme.SuperheroesTheme

@Composable
fun HeroItem(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .height(72.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            HeroInfo(
                hero = hero,
                modifier = Modifier.weight(1F)
            )
            Spacer(
                modifier = Modifier.width(16.dp)
            )
            HeroImage(
                hero = hero,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun HeroImage(hero: Hero, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = hero.imageRes),
        contentDescription = stringResource(id = hero.nameRes),
        modifier = modifier
            .clip(MaterialTheme.shapes.small)
    )
}

@Composable
fun HeroInfo(hero: Hero, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = hero.nameRes),
            style = MaterialTheme.typography.displaySmall
        )
        Text(
            text = stringResource(id = hero.descriptionRes),
            style = MaterialTheme.typography.bodyLarge

        )
    }
}

@Composable
fun HeroList(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)

    ) {
        items(HeroesRepository.heroes) { hero ->
            HeroItem(hero)
        }
    }
}

@Preview
@Composable
fun HeroItemPreview() {
    SuperheroesTheme {
        HeroItem(hero = HeroesRepository.heroes[3])
    }
}

@Preview(showBackground = true)
@Composable
fun HeroListPreview() {
    SuperheroesTheme {
        HeroList()
    }
}