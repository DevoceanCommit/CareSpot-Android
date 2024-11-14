package com.devocean.data.mapper.chat

import com.devocean.data.dto.response.SummaryReportResponseDto
import com.devocean.domain.entity.chat.SummaryReport

fun SummaryReportResponseDto.toContext(): List<SummaryReport> =
    this.contents.map { content ->
        SummaryReport(
            context = content.context
        )
    }