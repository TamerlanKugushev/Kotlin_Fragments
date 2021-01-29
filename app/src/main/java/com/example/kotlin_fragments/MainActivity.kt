package com.example.kotlin_fragments

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {

    val drawerToogle by lazy {
        ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.drawer_open,
            R.string.drawer_close
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        navigationView.setNavigationItemSelectedListener {
            selectItem(it)
        }
        bottomNavigationView.setOnNavigationItemSelectedListener {
            selectItem(it)
        }
        drawerLayout.addDrawerListener(drawerToogle)
        val pagerAdapter = ImageFragmentPagerAdapter(supportFragmentManager)
        viewPager.adapter = pagerAdapter
        viewPager.addOnPageChangeListener(this)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        drawerToogle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        drawerToogle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (drawerToogle.onOptionsItemSelected(item)) true else super.onOptionsItemSelected(
            item
        )

//        return when (item.itemId) {
//            R.id.firstFragmentItem -> {
//                val fragment = FirstImageFragment.newInstance()
//                replaceFragment(fragment)
//                true
//            }
//            R.id.secondFragmentItem -> {
//                val fragment = SecondImageFragment.newInstance()
//                replaceFragment(fragment)
//                true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.fragment_menu, menu)
        return true
    }


    private fun replaceFragment(fragment: Fragment?) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragment?.let { fragmentTransaction.replace(R.id.fragmentContainer, it) }
        fragmentTransaction.commit()
    }


    private fun selectItem(item: MenuItem): Boolean {
//        var fragment: Fragment? = null
//        var fragmentClass = when (item.itemId) {
//            R.id.firstFragmentItem -> FirstImageFragment::class.java
//            R.id.secondFragmentItem -> SecondImageFragment::class.java
//            else -> FirstImageFragment::class.java
//        }
//
//        try {
//            fragment = fragmentClass.newInstance() as Fragment
//        } catch (e: ClassCastException) {
//            e.printStackTrace()
//        }
//        replaceFragment(fragment)
        when (item.itemId) {
            R.id.firstFragmentItem -> viewPager.currentItem = 0
            R.id.secondFragmentItem -> viewPager.currentItem = 1
            R.id.thirdFragmentItem -> viewPager.currentItem = 2
            else -> viewPager.currentItem = 0
        }

        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START)
        return true

    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
        val currentMenuItem = bottomNavigationView.menu.getItem(position).itemId
        if (currentMenuItem != bottomNavigationView.selectedItemId) {
            bottomNavigationView.menu.getItem(position).isChecked = true
            bottomNavigationView.menu.findItem(bottomNavigationView.selectedItemId).isChecked =
                false
        }
    }
}