package com.android.today.presentation.main

import android.os.Bundle
import com.android.today.R
import com.android.today.data.ResultData
import com.android.today.databinding.ActivityResultBinding
import com.android.today.util.binding.BindingActivity
import com.android.today.util.extension.setSingleOnClickListener

class ResultActivity : BindingActivity<ActivityResultBinding>(R.layout.activity_result) {
    private val resultAdapter: ResultAdapter = ResultAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBadBtnOnClickListener()
        initAdapter()
    }

    private fun initBadBtnOnClickListener() {
        binding.btnResultBad.setSingleOnClickListener {
            finish()
        }
    }

    private fun initAdapter() {
        binding.rvResult.adapter = resultAdapter
        resultAdapter.submitList(resultList)
    }

    companion object {
        private val resultList = listOf(
            ResultData(
                "카페",
                "진저베어"
            ),
            ResultData(
                "연극",
                "대학로 예술극장"
            ),
            ResultData(
                "산책",
                "마로니에 공원"
            ),
            ResultData(
                "저녁",
                "미도인"
            )
        )
    }
}
