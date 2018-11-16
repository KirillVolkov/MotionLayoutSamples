package com.pixelplex.motionlayoutsample.samples

import android.support.v4.view.ViewPager
import com.pixelplex.motionlayoutsample.PositionPagerAdapter
import com.pixelplex.motionlayoutsample.R
import kotlinx.android.synthetic.main.motion_parallax.*
import kotlinx.android.synthetic.main.viewpager_sample.*

class ViewPagerSample : BaseFragment() {
    override val resourceId: Int
        get() = R.layout.viewpager_sample

    override fun init() {
        pager.adapter = PositionPagerAdapter(context!!)
        tabs.setupWithViewPager(pager)

        if (motionLayout != null) {
            pager.addOnPageChangeListener(motionLayout as ViewPager.OnPageChangeListener)
        }
    }

}