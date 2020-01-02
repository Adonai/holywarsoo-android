package com.kanedias.holywarsoo.misc

import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.transition.Slide
import com.kanedias.holywarsoo.R
import kotlin.reflect.KClass

private val UNNEEDED_INT_CHARS = Regex("[,. ]")

var View.visibilityBool: Boolean
    get() = visibility == View.VISIBLE
    set(value) { visibility = if (value) { View.VISIBLE } else { View.INVISIBLE } }

/**
 * Show toast exactly under specified view
 *
 * @param view view at which toast should be located
 * @param text text of toast
 */
fun View.showToast(text: String) {
    val toast = Toast.makeText(this.context, text, Toast.LENGTH_SHORT)

    val location = IntArray(2)
    this.getLocationOnScreen(location)

    toast.setGravity(Gravity.TOP or Gravity.START, location[0] - 25, location[1] - 10)
    toast.show()
}

fun String.sanitizeInt(): Int {
    return this
        .replace(UNNEEDED_INT_CHARS, "")
        .replace(Regex("^-$"), "-1")
        .replace(Regex("-{2,}"), "-1")
        .toInt()
}

fun String.trySanitizeInt(): Int? {
    return this
        .replace(UNNEEDED_INT_CHARS, "")
        .replace(Regex("^-$"), "-1")
        .replace(Regex("-{2,}"), "-1")
        .toIntOrNull()
}

fun FragmentActivity.showFullscreenFragment(frag: Fragment) {
    frag.enterTransition = Slide(Gravity.END)
    frag.exitTransition = Slide(Gravity.START)

    supportFragmentManager.beginTransaction()
        .addToBackStack("Showing fragment: $frag")
        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        .add(R.id.main_content_area, frag)
        .commit()
}