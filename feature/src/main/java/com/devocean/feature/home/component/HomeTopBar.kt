package com.devocean.feature.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devocean.core.designsystem.theme.SpotMain
import com.devocean.feature.R

@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.home_top_bar_title),
            color = SpotMain,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}