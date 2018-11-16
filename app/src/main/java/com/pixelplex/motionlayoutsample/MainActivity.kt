package com.pixelplex.motionlayoutsample

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.pixelplex.motionlayoutsample.samples.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.simple_motion -> {
                supportFragmentManager.beginTransaction().replace(R.id.container, SimpleMove())
                    .commit()
            }
            R.id.simple_motion_attrs -> {
                supportFragmentManager.beginTransaction().replace(R.id.container, SimpleMoveAttrs())
                    .commit()
            }
            R.id.simple_motion_custom_attrs -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, SimpleMoveCustomAttrs())
                    .commit()
            }
            R.id.image_view_filter -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ImageFilterViewSample())
                    .commit()
            }
            R.id.image_view_filter_advanced -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ImageViewFilterAdvancedSample())
                    .commit()
            }
            R.id.key_frame -> {
                supportFragmentManager.beginTransaction().replace(R.id.container, KeyFrameSample())
                    .commit()
            }
            R.id.key_frame_attrs -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, KeyFrameAttrsSample())
                    .commit()
            }
            R.id.coordinator_sample -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, CoordinatorSample())
                    .commit()
            }
            R.id.viewpager_sample -> {
                supportFragmentManager.beginTransaction().replace(R.id.container, ViewPagerSample())
                    .commit()
            }
            R.id.lottie_sample -> {
                supportFragmentManager.beginTransaction().replace(R.id.container, LottieSample())
                    .commit()
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
