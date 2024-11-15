package com.devocean.feature.chat.selectedchat.model

import com.devocean.domain.entity.chat.SummaryReport

data class SummaryReportModel(
    val subtitle: String,
    val context: String
)

fun SummaryReport.toSummaryReportModel() = SummaryReportModel(
    subtitle = subtitle,
    context = context
)
