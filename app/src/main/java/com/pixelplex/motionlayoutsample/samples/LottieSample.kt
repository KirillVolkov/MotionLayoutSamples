package com.pixelplex.motionlayoutsample.samples

import android.support.v4.view.ViewPager
import com.pixelplex.motionlayoutsample.PositionPagerAdapter
import com.pixelplex.motionlayoutsample.R
import kotlinx.android.synthetic.main.lottie_header_sample.*
import kotlinx.android.synthetic.main.lottie_sample.*

class LottieSample : BaseFragment() {
    override val resourceId: Int
        get() = R.layout.lottie_sample

    override fun init() {
        pager.adapter = PositionPagerAdapter(context!!)
        tabs.setupWithViewPager(pager)

        if (motionLayout != null) {
            pager.addOnPageChangeListener(motionLayout as ViewPager.OnPageChangeListener)
        }
    }

}