package com.android.today.util.extension

import android.view.View

fun View.setSingleOnClickListener(onSingleClick: (View) -> Unit) {
    setOnClickListener(OnSingleClickListener { onSingleClick(it) })
}
