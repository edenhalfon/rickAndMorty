package com.ehapps.core

import android.view.View

fun View.setVisible() {
    visibility = View.VISIBLE
}

fun View.setGone() {
    visibility = View.GONE
}

fun View.setInvisible() {
    visibility = View.INVISIBLE
}

fun View.setVisibility(isVisible: Boolean) {
    if (isVisible) {
        setVisible()
    } else {
        setGone()
    }
}