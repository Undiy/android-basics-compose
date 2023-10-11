package com.example.artspace

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Artwork(
    @DrawableRes val image: Int,
    @StringRes val title: Int,
    @StringRes val artist: Int,
    @StringRes val year: Int
) {
    companion object {
        fun artworks() : List<Artwork> {
            return listOf(
                Artwork(
                    R.drawable.horses_in_a_meadow_1995_11_1,
                    R.string.horses_in_a_meadow_title,
                    R.string.horses_in_a_meadow_artist,
                    R.string.horses_in_a_meadow_year
                ),
                Artwork(
                    R.drawable.leisure_and_labor_2014_136_111,
                    R.string.leisure_and_labor_title,
                    R.string.leisure_and_labor_artist,
                    R.string.leisure_and_labor_year
                ),
                Artwork(
                    R.drawable.the_trap_1994_59_13,
                    R.string.the_trap_title,
                    R.string.the_trap_artist,
                    R.string.the_trap_year
                ),
                Artwork(
                    R.drawable.the_last_of_the_buffalo_2014_79_5,
                    R.string.the_last_of_the_buffalo_title,
                    R.string.the_last_of_the_buffalo_artist,
                    R.string.the_last_of_the_buffalo_year
                ),
                Artwork(
                    R.drawable.crossing_the_james_river_2015_19_788,
                    R.string.crossing_the_james_river_title,
                    R.string.crossing_the_james_river_artist,
                    R.string.crossing_the_james_river_year
                )
            )
        }
    }
}