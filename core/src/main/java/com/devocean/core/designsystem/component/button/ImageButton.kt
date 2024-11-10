package com.devocean.core.designsystem.component.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.devocean.core.util.NoRippleTheme

@Composable
fun ImageButton(
    paddingVertical: Dp,
    onButtonClick: () -> Unit,
    painterResource: Int,
    containerColor: Color,
    contentColor: Color,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
) {
    val interactionSource = remember { MutableInteractionSource() }

    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        Button(
            modifier = modifier,
            contentPadding = PaddingValues(paddingVertical),
            interactionSource = interactionSource,
            enabled = isEnabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = containerColor,
                contentColor = contentColor
            ),
            shape = CircleShape,
            onClick = onButtonClick
        ) {
            Image(
                painter = painterResource(id = painterResource),
                contentDescription = null,
            )
        }
    }
}
