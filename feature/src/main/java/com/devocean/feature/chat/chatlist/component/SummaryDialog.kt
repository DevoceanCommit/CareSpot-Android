package com.devocean.feature.chat.chatlist.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.devocean.core.designsystem.theme.DevoceanSpotTheme
import com.devocean.core.designsystem.theme.SpotGray

@Composable
fun SummaryDialog(
    onDismissRequest: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    properties: DialogProperties = DialogProperties(
        usePlatformDefaultWidth = false,
        decorFitsSystemWindows = true,
        dismissOnBackPress = true,
        dismissOnClickOutside = true,
    ),
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = properties,
    ) {
        Column(
            modifier = modifier
                .padding(horizontal = 20.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.White)
                .padding(10.dp)
        ) {
            Text(
                text = "한 줄 요약",
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(thickness = 2.dp, color = SpotGray)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = text)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SummaryDialogPreview() {
    DevoceanSpotTheme {
        SummaryDialog(
            onDismissRequest = {},
            text = "이것은 한 줄 요약입니다."
        )
    }
}