package com.vast.customview.presentation.healthDiary

data class HealthDiaryTodayContext(
    val status: HealthDiaryTodayStatus,
    val mainTitle: String,
    val secondTitle: String? = null,
    val description: String? = null,
    val nextDate: String
)