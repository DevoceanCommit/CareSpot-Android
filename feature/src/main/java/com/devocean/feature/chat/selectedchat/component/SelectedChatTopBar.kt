package com.devocean.feature.chat.selectedchat.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.devocean.core.designsystem.theme.SpotSub
import com.devocean.core.extension.noRippleClickable
import com.devocean.feature.R

@Composable
fun SelectedChatTopBar(
    onDialogClick: () -> Unit,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp, horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
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
            modifier = modifier.padding(start = 20.dp),
            fontWeight = FontWeight.Bold,
        )
        Icon(
            painter = painterResource(R.drawable.ic_notes_24),
            tint = Color.Black,
            modifier = Modifier
                .clickable { onDialogClick() }
                .clip(CircleShape)
                .background(SpotSub)
                .padding(5.dp),
            contentDescription = "summary_icon"
        )
    }
}