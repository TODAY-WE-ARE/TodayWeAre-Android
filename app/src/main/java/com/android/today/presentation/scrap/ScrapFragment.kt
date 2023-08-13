package com.android.today.presentation.scrap

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.android.today.R
import com.android.today.data.Pick
import com.android.today.databinding.FragmentScrapBinding
import com.android.today.util.binding.BindingFragment
import com.android.today.util.extension.setSingleOnClickListener

class ScrapFragment :
    BindingFragment<FragmentScrapBinding>(R.layout.fragment_scrap) {
    private val scrapViewModel: ScrapViewModel by viewModels()
    private val scrapAdapter: ScrapAdapter = ScrapAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = scrapViewModel
        initAdapter()
        initRecommendBtnClickListener()
    }

    private fun initAdapter() {
        binding.rvPick.adapter = scrapAdapter
        scrapAdapter.submitList(scrapList)
    }

    private fun initRecommendBtnClickListener() {
        binding.tvScrapRecommend.setSingleOnClickListener {
            startActivity(Intent(requireActivity(), RecommendFragment::class.java))
        }
    }

    companion object {
        private val scrapList = listOf(
            Pick(
                "",
                "잠실",
                "3.5km",
                "롯데월드 아쿠아리움",
                "카페 - 진저베어",
                "저녁 - 마카나이"
            ),
            Pick(
                "",
                "강남",
                "1.5km",
                "점심 - 하이디라오",
                "메가박스 영화",
                "카페 - 탐앤탐스"
            ),
            Pick(
                "",
                "한남동, 한강진역",
                "6.7km",
                "저녁 - 파이프그라운드",
                "카페 - 올드페리도넛",
                "술 - 칵테일바 헤엄"
            )
        )
    }
}