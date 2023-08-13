package com.android.today.presentation.diary

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.android.today.R
import com.android.today.data.Diary
import com.android.today.databinding.FragmentDiaryListBinding
import com.android.today.util.binding.BindingFragment

class DiaryFragment :
    BindingFragment<FragmentDiaryListBinding>(R.layout.fragment_diary_list) {
    private val diaryViewModel: DiaryViewModel by viewModels()
    private val diaryAdapter: DiaryAdapter = DiaryAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = diaryViewModel
        initAdapter()

    }

    private fun initAdapter() {
        binding.rvDiary.adapter = diaryAdapter
        diaryAdapter.submitList(diaryList)

    }



    companion object {
        private val diaryList = listOf(
            Diary(
                "2023/08/03",
                "<오늘은 팀원들이랑 맛있는 거 먹은 날~~>"
            ),
            Diary(
                "2023/08/02",
                "<엄마랑 맛집 데이트, 날씨가 너무 좋아>"
            ),
            Diary(
                "2023/08/01",
                "<남자친구랑 두번째 데이트!!! 꺄악!!>"
            )
        )
    }
}

