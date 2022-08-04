package com.vast.customview.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.vast.customview.R
import com.vast.customview.databinding.ActivityMainBinding
import com.vast.customview.presentation.healthDiary.HealthDiaryTodayContext
import com.vast.customview.presentation.healthDiary.HealthDiaryTodayStatus

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val healthDiaryTodayContextCom = HealthDiaryTodayContext(
            status = HealthDiaryTodayStatus.COMPLETE,
            mainTitle = "Спасибо!",
            secondTitle = "Сегодня все заполнено :)",
            nextDate = "20.07 ПН"
        )

        binding.healthDiaryDashboardWidgetCom.setData(healthDiaryTodayContextCom)

        val healthDiaryTodayContextReq = HealthDiaryTodayContext(
            status = HealthDiaryTodayStatus.REQUIRED,
            mainTitle = "Заполните сегодня опросник дневника самочувствия",
            nextDate = "20.07 ПН"
            )

        binding.healthDiaryDashboardWidgetReq.setData(healthDiaryTodayContextReq)

        val healthDiaryTodayContextNotReq = HealthDiaryTodayContext(
            status = HealthDiaryTodayStatus.NOT_REQUIRED,
            mainTitle = "Дата заполнения: 20.07 ПН",
            description = "При необходимости вы можете заполнять опросник ежедневно",
            nextDate = "20.07 ПН"
        )

        binding.healthDiaryDashboardWidgetNotReq.setData(healthDiaryTodayContextNotReq)

    }
}