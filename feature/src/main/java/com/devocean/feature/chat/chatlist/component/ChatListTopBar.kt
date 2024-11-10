package com.devocean.feature.chat.chatlist.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.devocean.core.extension.noRippleClickable
import com.devocean.feature.R

@Composable
fun MyPageTopBar(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp, horizontal = 10.dp),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_back_24),
            contentDescription = null,
            modifier = Modifier.noRippleClickable {
                onBackClick()
            }
        )
        Text(
            text = stringResource(id = R.string.chatlist_title),
            modifier = modifier.padding(start = 10.dp)
        )
    }
}