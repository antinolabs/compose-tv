package com.nameisjayant.composetv.feature.home.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.tv.foundation.lazy.list.TvLazyRow
import androidx.tv.material3.Card
import androidx.tv.material3.ExperimentalTvMaterial3Api


@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier.padding(top=20.dp)
    ) {
        Card(onClick = { }, modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        ) {}
        Spacer(modifier = Modifier.height(20.dp))
        TvLazyRow{
            items(10){
                Card(onClick = { }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp)
                    .size(100.dp),
                ) {}
            }
        }
    }

}