package com.android.today.presentation.diary

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.android.today.R
import com.android.today.databinding.FragmentDiaryBinding
import com.android.today.util.binding.BindingFragment

class DiaryFragment :
    BindingFragment<FragmentDiaryBinding>(R.layout.fragment_diary_list) {
    private val diaryViewModel: DiaryViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = diaryViewModel
    }

    private fun initDiaryBtnClickListener() {
        binding.tvDiary.setSingleOnClickListener {
            startActivity(Intent(requireActivity(), DiaryActivity::class.java))
        }
    }
}

