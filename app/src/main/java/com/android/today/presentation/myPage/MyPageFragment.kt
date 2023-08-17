package com.android.today.presentation.myPage

import android.os.Bundle
import android.view.View
import com.android.today.R
import com.android.today.databinding.FragmentMyPageBinding
import com.android.today.util.binding.BindingFragment

class MyPageFragment : BindingFragment<FragmentMyPageBinding>(R.layout.fragment_my_page) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
    }
}
