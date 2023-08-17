package com.android.today.presentation.diary

import android.os.Bundle
import com.android.today.R
import com.android.today.databinding.ActivityDiaryDetailBinding
import com.android.today.util.binding.BindingActivity
import com.android.today.util.extension.setSingleOnClickListener

class DiaryDetailActivity :
    BindingActivity<ActivityDiaryDetailBinding>(R.layout.activity_diary_detail) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary_detail)
        initBackBtnOnClickListener()
    }

    private fun initBackBtnOnClickListener() {
        binding.backBtn.setSingleOnClickListener {
            finish()
        }
    }
}