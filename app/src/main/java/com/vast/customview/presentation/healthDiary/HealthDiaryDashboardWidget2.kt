package com.vast.customview.presentation.healthDiary

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.drawable.toDrawable
import com.vast.customview.R
import com.vast.customview.databinding.HealthDiaryDashboardWidget2Binding

class HealthDiaryDashboardWidget2(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int,
    defStyleRes: Int
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val binding: HealthDiaryDashboardWidget2Binding

    constructor (context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(
        context,
        attrs,
        defStyleAttr,
        0
    )

    constructor (context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor (context: Context) : this(context, null)

    init {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.health_diary_dashboard_widget2, this, true)
        binding = HealthDiaryDashboardWidget2Binding.bind(this)
    }

    fun setData(healthDiaryTodayContext: HealthDiaryTodayContext) {
        with(binding) {
            when(healthDiaryTodayContext.status) {
                HealthDiaryTodayStatus.COMPLETE -> {
                    mainTitle.visibility = View.VISIBLE
                    secondTitle.visibility = View.VISIBLE
                    description.visibility = View.GONE
                    statusInfoDivider.visibility = View.VISIBLE
                    statusInfoIcon.visibility = View.VISIBLE
                    statusInfoNextDate.visibility = View.VISIBLE
                    statusInfoDate.visibility = View.VISIBLE

                    mainTitle.text = healthDiaryTodayContext.mainTitle
                    secondTitle.text = healthDiaryTodayContext.secondTitle
                    statusInfoDate.text = healthDiaryTodayContext.nextDate

                    submitButton.isEnabled = false
                    submitButton.setBackgroundColor(Color.parseColor("#F5F5F5"))
                }
                HealthDiaryTodayStatus.REQUIRED -> {
                    mainTitle.visibility = View.VISIBLE
                    secondTitle.visibility = View.GONE
                    description.visibility = View.GONE
                    statusInfoDivider.visibility = View.VISIBLE
                    statusInfoIcon.visibility = View.VISIBLE
                    statusInfoNextDate.visibility = View.VISIBLE
                    statusInfoDate.visibility = View.VISIBLE

                    mainTitle.text = healthDiaryTodayContext.mainTitle
                    statusInfoDate.text = healthDiaryTodayContext.nextDate
                }
                HealthDiaryTodayStatus.NOT_REQUIRED -> {
                    mainTitle.visibility = View.VISIBLE
                    secondTitle.visibility = View.GONE
                    description.visibility = View.VISIBLE
                    statusInfoDivider.visibility = View.GONE
                    statusInfoIcon.visibility = View.GONE
                    statusInfoNextDate.visibility = View.GONE
                    statusInfoDate.visibility = View.GONE

                    mainTitle.text = healthDiaryTodayContext.mainTitle
                    description.text = healthDiaryTodayContext.description
                    submitButton.setBackgroundColor(Color.WHITE)
                    submitButton.setTextColor(Color.BLACK)
                    submitButton.strokeWidth = 2
                }
            }
        }
    }

    fun setOnCLickListener(listener: () -> Unit) {
        binding.submitButton.setOnClickListener {
            listener.invoke()
        }
    }
}