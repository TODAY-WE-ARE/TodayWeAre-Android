package com.android.today.presentation.scrap

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.android.today.R
import com.android.today.data.Recommend
import com.android.today.databinding.FragmentRecommendBinding
import com.android.today.util.binding.BindingFragment

class RecommendFragment : BindingFragment<FragmentRecommendBinding>(R.layout.fragment_recommend) {
    private val recommendViewModel: RecommendViewModel by viewModels()
    private val recommendAdapter: RecommendAdapter = RecommendAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = recommendViewModel
        initAdapter()
    }

    private fun initAdapter() {
        binding.rvRecommend.adapter = recommendAdapter
        recommendAdapter.submitList(recommendedList)
    }

    companion object {
        private val recommendedList = listOf(
            Recommend(
                "https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20221224_60%2F1671816481138jef1l_JPEG%2F459050D4-7A5D-4429-86F4-99DF7F5FDBA4.jpeg",
                "혜화",
                "연극 '옥탑방 고양이'",
                "카페 - 에이라운드",
                "저녁 - 피터팬스테이크"
            ),
            Recommend(
                "https://www.google.co.kr/url?sa=i&url=https%3A%2F%2Fv.daum.net%2Fv%2F20220315111331997&psig=AOvVaw3JL5WM02_gK-XWQZa7n3pB&ust=1691407654831000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCOiqwNb2x4ADFQAAAAAdAAAAABAE",
                "잠실",
                "카페 - 진저베어",
                "석촌호수 산책",
                "저녁 - 차만다"
            ),
            Recommend(
                "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA5MjlfMjEw%2FMDAxNjY0NDU4NTEwMTkz.Nz1_g7ejFkDAEiy5_4fll5vXhnn4sVksNX8xe_yAxdEg.LzFk_2oN78AYW74jw5ImKXyao-m5M_ZUQzrrLYs6VqMg.JPEG.lynn1025%2FKakaoTalk_20220926_005701649_12.jpg&type=sc960_832",
                "성수",
                "편집샵 투어",
                "카페 - 옹근달",
                "저녁 - 성수부두"
            )
        )
    }
}
