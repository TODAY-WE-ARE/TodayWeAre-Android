package com.android.today.presentation.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.android.today.R
import com.android.today.databinding.FragmentMainBinding
import com.android.today.util.binding.BindingFragment
import com.android.today.util.extension.setSingleOnClickListener

class MainFragment : BindingFragment<FragmentMainBinding>(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initResultBtnClickListener()
    }

    private fun initResultBtnClickListener() {
        binding.tvMainRecommend.setSingleOnClickListener {
            startActivity(Intent(requireActivity(), ResultActivity::class.java))
        }
    }
}
