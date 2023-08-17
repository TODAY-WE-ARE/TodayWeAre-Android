package com.android.today.presentation.main

import android.os.Bundle
import com.android.today.R
import com.android.today.databinding.ActivityResultBinding
import com.android.today.util.binding.BindingActivity
import com.android.today.util.extension.setSingleOnClickListener

class ResultActivity : BindingActivity<ActivityResultBinding>(R.layout.activity_result) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBadBtnOnClickListener()
    }

    private fun initBadBtnOnClickListener() {
        binding.btnResultBad.setSingleOnClickListener {
            finish()
        }
    }
}
