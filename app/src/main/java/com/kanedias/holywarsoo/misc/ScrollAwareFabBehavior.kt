package com.kanedias.holywarsoo.misc

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorListener
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * FloatingActionButton behaviour that hides it when user scrolls down the inner view.
 *
 * @author Kanedias
 *
 * Created on 18.11.17 2017-11-18
 */
@Suppress(
        "UNUSED_PARAMETER", // these are instantiated by inflater
        "unused" // this class is actually used in XML-descriptor and inflated from there
)
class ScrollAwareFabBehavior(context: Context, attrs: AttributeSet) : FloatingActionButton.Behavior() {

    companion object {
        private val INTERPOLATOR = FastOutSlowInInterpolator()
    }

    private var mIsAnimatingOut = false

    override fun onStartNestedScroll(layout: CoordinatorLayout, child: FloatingActionButton,
                                     directTargetChild: View, target: View, nestedScrollAxes: Int, type: Int): Boolean {
        // Ensure we react to vertical scrolling
        if (nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL)
            return true

        return super.onStartNestedScroll(layout, child, directTargetChild, target, nestedScrollAxes, type)
    }

    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: FloatingActionButton, target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int, consumed: IntArray) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type, consumed)
        if (dyConsumed > 0 && !mIsAnimatingOut && child.visibility == View.VISIBLE) {
            // User scrolled down and the FAB is currently visible -> hide the FAB
            animateOut(child)
        } else if (dyConsumed < 0 && child.visibility != View.VISIBLE) {
            // User scrolled up and the FAB is currently not visible -> show the FAB
            animateIn(child)
        }
    }

    // Same animation that FloatingActionButton.Behavior uses to hide the FAB when the AppBarLayout exits
    private fun animateOut(button: FloatingActionButton) {
        ViewCompat.animate(button)
                .scaleX(0.0f).scaleY(0.0f).alpha(0.0f)
                .setInterpolator(INTERPOLATOR).withLayer()
                .setListener(object : ViewPropertyAnimatorListener {
                    override fun onAnimationStart(view: View) {
                        mIsAnimatingOut = true
                    }

                    override fun onAnimationCancel(view: View) {
                        mIsAnimatingOut = false
                    }

                    override fun onAnimationEnd(view: View) {
                        mIsAnimatingOut = false
                        view.visibility = View.INVISIBLE
                    }
                }).start()
    }

    // Same animation that FloatingActionButton.Behavior uses to show the FAB when the AppBarLayout enters
    private fun animateIn(button: FloatingActionButton) {
        button.visibility = View.VISIBLE
        ViewCompat.animate(button).scaleX(1.0f).scaleY(1.0f).alpha(1.0f)
                .setInterpolator(INTERPOLATOR).withLayer().setListener(null)
                .start()
    }
}