package com.example.kotlin_fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ClassCastException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigationView.setNavigationItemSelectedListener {
            selectDrawItem(it)
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.firstFragmentItem -> {
                val fragment = FirstImageFragment.newInstance()
                replaceFragment(fragment)
                true
            }
            R.id.secondFragmentItem -> {
                val fragment = SecondImageFragment.newInstance()
                replaceFragment(fragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
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


    private fun selectDrawItem(item: MenuItem) {
        var fragment: Fragment? = null
        var fragmentClass = when (item.itemId) {
            R.id.firstFragmentItem -> FirstImageFragment::class.java
            R.id.secondFragmentItem -> SecondImageFragment::class.java
            else -> FirstImageFragment::class.java
        }

        try {
            fragment = fragmentClass.newInstance() as Fragment
        } catch (e: ClassCastException) {
            e.printStackTrace()
        }
        replaceFragment(fragment)
        drawerLayout.closeDrawer(GravityCompat.START)
    }
}