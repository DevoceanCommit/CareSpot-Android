package com.devocean.feature.chat.selectedchat.model

import com.devocean.domain.entity.chat.SummaryReport

data class SummaryReportModel(
    val context: String
)

fun SummaryReport.toSummaryReportModel() = SummaryReportModel(
    context = context
)
