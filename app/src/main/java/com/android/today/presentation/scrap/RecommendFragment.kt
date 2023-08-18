package com.android.today.presentation.scrap

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.android.today.R
import com.android.today.data.Pick
import com.android.today.databinding.FragmentRecommendBinding
import com.android.today.util.binding.BindingFragment
import com.android.today.util.extension.setSingleOnClickListener

class RecommendFragment : BindingFragment<FragmentRecommendBinding>(R.layout.fragment_recommend) {
    private val recommendViewModel: RecommendViewModel by viewModels()
    private val recommendAdapter: RecommendAdapter = RecommendAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = recommendViewModel
        initAdapter()
        initScrapClickListener()
        initRecommendClickListener()
    }

    private fun initAdapter() {
        binding.rvRecommend.adapter = recommendAdapter
        recommendAdapter.submitList(recommendList)
    }

    private fun initScrapClickListener() {
        binding.tvRecommendPick.setSingleOnClickListener {
            recommendAdapter.submitList(scrapList)
            with(binding) {
                tvRecommendPick.isSelected = true
                tvRecommendPick.isSelected = false
                tvRecommendStar.visibility = View.GONE
                tvRecommendKm.visibility = View.GONE
                tvRecommendPopular.visibility = View.GONE
            }
            Log.d("asdf", scrapList.toString())
        }
    }

    private fun initRecommendClickListener() {
        binding.tvRecommendRecommend.setSingleOnClickListener {
            recommendAdapter.submitList(recommendList)
            with(binding) {
                tvRecommendPick.isSelected = false
                tvRecommendRecommend.isSelected = true
                tvRecommendStar.visibility = View.VISIBLE
                tvRecommendKm.visibility = View.VISIBLE
                tvRecommendPopular.visibility = View.VISIBLE
            }
        }
    }

    companion object {
        private val scrapList = listOf(
            Pick(
                "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzAzMzFfMTIz%2FMDAxNjgwMjQ2ODM0NDY2.vdjqWc5QpK9IS1o79Er_Hxya61CUATsoTbiDDnJ39nQg.cLbdqs-UrLzherB5iNLK77RVjf4X7_12BR8psXjf4X8g.JPEG.eulsoo95%2F20230331%25A3%25DF132844.jpg&type=a340",
                "잠실",
                "3.5km",
                "롯데월드 아쿠아리움",
                "카페 - 진저베어",
                "저녁 - 마카나이"
            ),
            Pick(
                "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzA3MTlfMjIz%2FMDAxNjg5NzYwNjAwNzcw.u94O38YI-hUBKKrtE4niyCWwEVT_-yLX-QmmhSvHD6Ig.FHmxXajwSAt3i7tJV36ZT7_GE1ygKqpO6OKk8viNp8sg.JPEG.kde7878%2FIMG_4249.jpg&type=a340",
                "강남",
                "1.5km",
                "저녁 - 하이디라오",
                "메가박스 영화",
                "카페 - 탐앤탐스"
            ),
            Pick(
                "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzA0MjVfMjM4%2FMDAxNjgyNDA0MTU5OTc4.jRz34uJ71NWzaJ5k5A1cHeg9t4uWeUaol8DeZD-afFUg.c3_VSUdpMPTjLxfaVbKRgzCxP45FJRjSSc-6mlwSTdAg.JPEG.saena0315%2FIMG_5054.jpeg&type=a340",
                "한남동, 한강진역",
                "6.7km",
                "저녁 - 파이프그라운드",
                "카페 - 올드페리도넛",
                "술 - 칵테일바 헤엄"
            )
        )
        private val recommendList = listOf(
            Pick(
                "http://ticket.interpark.com/Gate/OtherSite/NaverTotalSearchGate.asp?fn=mgoodsdetail&r1=19018396",
                "혜화",
                "2.1km",
                "연극 '옥탑방 고양이'",
                "카페 - 에이라운드",
                "저녁 - 피터팬스테이크"
            ),
            Pick(
                "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA1MDdfMjU5%2FMDAxNjUxOTIxNDM2MzA3.uO8hCBHbAkPPrLqlxrRRKfcyMPfpMiYNQEVNXAu2U8Ig.pMVY_Sit88_1OCInyv37i_dIRROq7WyDDWNKcEeafCcg.JPEG.parkhj1117%2Foutput_499791020.jpg&type=a340",
                "잠실",
                "4.3km",
                "카페 - 진저베어",
                "석촌호수 산책",
                "저녁 - 차만다"
            ),
            Pick(
                "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjA5MjlfMjEw%2FMDAxNjY0NDU4NTEwMTkz.Nz1_g7ejFkDAEiy5_4fll5vXhnn4sVksNX8xe_yAxdEg.LzFk_2oN78AYW74jw5ImKXyao-m5M_ZUQzrrLYs6VqMg.JPEG.lynn1025%2FKakaoTalk_20220926_005701649_12.jpg&type=sc960_832",
                "성수",
                "5.6km",
                "편집샵 투어",
                "카페 - 옹근달",
                "저녁 - 성수부두"
            )
        )
    }
}
