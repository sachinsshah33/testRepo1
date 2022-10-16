package com.example.myapplication.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.myapplication.R
import com.example.myapplication.databinding.CircularProgressViewBinding


class CircularProgressView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    var binding: CircularProgressViewBinding

    init {
        LayoutInflater.from(context).inflate(R.layout.circular_progress_view, this)
        binding = CircularProgressViewBinding.bind(this)
        setupView()
    }

    private fun setupView() {

    }
}