package com.android.today.presentation.main

import android.os.Bundle
import com.android.today.R
import com.android.today.databinding.ActivityMainBinding
import com.android.today.presentation.diary.DiaryFragment
import com.android.today.presentation.myPage.MyPageFragment
import com.android.today.presentation.scrap.ScrapFragment
import com.android.today.util.binding.BindingActivity
import com.android.today.util.extension.replaceFragment

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.bnvMain.itemIconTintList = null
        setOnItemSelectedListener()
        startTargetFragment(R.id.menu_home)
    }

    private fun setOnItemSelectedListener() {
        binding.bnvMain.setOnItemSelectedListener { item ->
            startTargetFragment(item.itemId)
            true
        }
    }

    private fun startTargetFragment(itemId: Int): Any = when (itemId) {
        R.id.menu_home -> replaceFragment<MainFragment>(R.id.fcv_main)
        R.id.menu_heart -> replaceFragment<ScrapFragment>(R.id.fcv_main)
        R.id.menu_note -> replaceFragment<DiaryFragment>(R.id.fcv_main)
        R.id.menu_user -> replaceFragment<MyPageFragment>(R.id.fcv_main)
        else -> IllegalArgumentException("Not found error.")
    }
}
