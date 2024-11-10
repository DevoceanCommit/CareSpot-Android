package com.devocean.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devocean.core.designsystem.theme.DevoceanSpotTheme
import com.devocean.core.designsystem.theme.SpotMain
import com.devocean.core.designsystem.theme.SpotSub

@Composable
fun HomeSensorData(
    modifier: Modifier = Modifier
) {
    val sensorDataItems = listOf(
        "움직임" to 4.2f,
        "응급상황 발생 여부" to 4.2f,
        "온습도 현황" to 4.2f,
        "소음 정도" to 4.2f,
        "공기질" to 4.2f
    )

    Column(modifier = modifier) {
        Text(
            text = "센서 데이터 확인",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 5.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            sensorDataItems.take(2).forEach { item ->
                SensorDataItem(
                    text = item.first,
                    data = item.second,
                    modifier = Modifier
                        .weight(1f)
                        .padding(5.dp)
                )
            }
        }
        Row {
            sensorDataItems.drop(2).forEach { item ->
                SensorDataItem(
                    text = item.first,
                    data = item.second,
                    modifier = Modifier
                        .weight(1f)
                        .padding(5.dp)
                )
            }
        }
    }
}

@Composable
private fun SensorDataItem(
    text: String,
    data: Float,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(15.dp))
            .background(SpotSub)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = data.toString(),
            fontWeight = FontWeight.Bold,
            color = SpotMain
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeSensorDataPreview() {
    DevoceanSpotTheme {
        HomeSensorData()
    }
}