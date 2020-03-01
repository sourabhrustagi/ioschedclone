package com.google.samples.apps.shared.util

import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.*

inline fun <reified VM : ViewModel> FragmentActivity.viewModelProvider(
    provider: ViewModelProvider.Factory
) =
    ViewModelProvider(this, provider).get(VM::class.java)

fun <X, Y> LiveData<X>.map(body: (X) -> Y): LiveData<Y> {
    return Transformations.map(this, body)
}

val <T> T.checkAllMatched: T
    get() = this

data class ViewPadddingState(
    val left: Int,
    val top: Int,
    val right: Int,
    val bottom: Int,
    val start: Int,
    val end: Int
)

private fun createStateForView(view: View) = ViewPadddingState(
    view.paddingLeft,
    view.paddingTop, view.paddingRight, view.paddingBottom, view.paddingStart, view.paddingEnd
)

fun View.requestApplyInsetsWhenAttached() {
    if (isAttachedToWindow) {
        requestApplyInsets()
    } else {
        addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
            override fun onViewAttachedToWindow(v: View) {
                v.requestApplyInsets()
            }

            override fun onViewDetachedFromWindow(v: View) = Unit
        })
    }
}

fun View.doOnApplyWindowInsets(f: (View, WindowInsetsCompat, ViewPadddingState) -> Unit) {
    val paddingState = createStateForView(this)
    ViewCompat.setOnApplyWindowInsetsListener(this) { v, insets ->
        f(v, insets, paddingState)
        insets
    }
    requestApplyInsetsWhenAttached()
}
