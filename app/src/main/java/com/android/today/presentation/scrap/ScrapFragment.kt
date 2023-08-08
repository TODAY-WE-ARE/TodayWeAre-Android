package com.android.today.presentation.scrap

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.android.today.R
import com.android.today.databinding.FragmentScrapBinding
import com.android.today.util.binding.BindingFragment

class ScrapFragment :
    BindingFragment<FragmentScrapBinding>(R.layout.fragment_scrap) {
    private val scrapViewModel: ScrapViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm=scrapViewModel
     }

    private fun initScrapBtnClickListener() {
        binding.tvMainBoxChu.setSingleOnClickListener {
            startActivity(Intent(requireActivity(), RecommendFragment::class.java))
        }
    }
}