package com.vast.customview.presentation.healthDiary

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.vast.customview.R
import com.vast.customview.databinding.HealthDiaryDashboardWidget2Binding

class HealthDiaryDashboardWidget2(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int,
    defStyleRes: Int
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val binding: HealthDiaryDashboardWidget2Binding

    constructor (context : Context, attrs: AttributeSet?, defStyleAttr: Int): this(context, attrs, defStyleAttr, 0)
    constructor (context : Context, attrs: AttributeSet?): this(context, attrs, 0)
    constructor (context : Context): this(context, null)

    init {
        val inflater  = LayoutInflater.from(context)
        inflater.inflate(R.layout.health_diary_dashboard_widget2, this, true)
        binding = HealthDiaryDashboardWidget2Binding.bind(this)
        initAttr(attrs, defStyleAttr, defStyleRes)
    }

    private fun initAttr(attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) {
        if (attrs == null) return

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.HealthDiaryDashboardWidget2, defStyleAttr, defStyleRes)
        typedArray.recycle()
    }
}