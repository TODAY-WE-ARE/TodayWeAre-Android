package com.android.today.util.extension

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

inline fun <reified T : Fragment> AppCompatActivity.replaceFragment(@IdRes frameId: Int) {
    supportFragmentManager.commit {
        replace(frameId, T::class.java, null)
        setReorderingAllowed(true)
    }
}
