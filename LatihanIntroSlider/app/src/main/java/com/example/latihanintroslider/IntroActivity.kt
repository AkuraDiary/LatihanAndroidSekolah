package com.example.latihanintroslider


import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener


class IntroActivity : AppCompatActivity() {
    private val MAX_STEP = 4

    private var btn_got_it: Button? = null
    private val title_array = arrayOf(
        "Intro One", "Intro Two",
        "Intro Three", "Intro Four"
    )
    private val description_array = arrayOf(
        "Tambahkan teks disini agar terlihat lebih keren",
        "Tambahkan teks disini agar terlihat lebih keren",
        "Tambahkan teks disini agar terlihat lebih keren",
        "Tambahkan teks disini agar terlihat lebih keren"
    )
    private val about_images_array = intArrayOf(
        R.drawable.ic_android, R.drawable.ic_notifications,
        R.drawable.ic_help, R.drawable.ic_favorite
    )
    private val color_array = intArrayOf(
        R.color.colorBlackDoff, R.color.colorBlackDoff,
        R.color.colorBlackDoff, R.color.colorBlackDoff
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        initComponent()
    }

    private fun initComponent() {
        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        btn_got_it = findViewById(R.id.btn_got_it)
        bottomProgressDots(0)
        val myViewPagerAdapter = MyViewPagerAdapter()
        viewPager.adapter = myViewPagerAdapter
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener)
        btn_got_it.setVisibility(View.GONE)
        btn_got_it.setOnClickListener(object : OnClickListener() {
            fun onClick(v: View?) {
                val intent = Intent(this@Intro, MainActivity::class.java)
                startActivity(intent)
            }
        })
        findViewById<View>(R.id.btn_skip).setOnClickListener(object : OnClickListener() {
            fun onClick(v: View?) {
                val intent = Intent(this@Intro, MainActivity::class.java)
                startActivity(intent)
            }
        })
    }

    private fun bottomProgressDots(index: Int) {
        val dotsLayout = findViewById<LinearLayout>(R.id.layoutDots)
        val dots: Array<ImageView?> = arrayOfNulls<ImageView>(MAX_STEP)
        dotsLayout.removeAllViews()
        for (i in dots.indices) {
            dots[i] = ImageView(this)
            val width_height = 15
            val params =
                LinearLayout.LayoutParams(ViewGroup.LayoutParams(width_height, width_height))
            params.setMargins(10, 10, 10, 10)
            dots[i].setLayoutParams(params)
            dots[i].setImageResource(R.drawable.dot)
            dots[i].setColorFilter(resources.getColor(R.color.colorWhite), PorterDuff.Mode.SRC_IN)
            dotsLayout.addView(dots[i])
        }
        dots[index].setImageResource(R.drawable.dot)
        dots[index].setColorFilter(resources.getColor(R.color.colorGold), PorterDuff.Mode.SRC_IN)
    }


    var viewPagerPageChangeListener: OnPageChangeListener = object : OnPageChangeListener {
        override fun onPageSelected(position: Int) {
            bottomProgressDots(position)
            if (position == title_array.size - 1) {
                btn_got_it.setVisibility(View.VISIBLE)
            } else {
                btn_got_it.setVisibility(View.GONE)
            }
        }

        override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {}
        override fun onPageScrollStateChanged(arg0: Int) {}
    }


    class MyViewPagerAdapter internal constructor() : PagerAdapter() {
        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val layoutInflater =
                getSystemService<Any>(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view: View = layoutInflater.inflate(R.layout.item_intro, container, false)
            (view.findViewById(R.id.title) as TextView).setText(title_array.get(position))
            (view.findViewById(R.id.description) as TextView).setText(description_array.get(position))
            (view.findViewById(R.id.image) as ImageView).setImageResource(
                about_images_array.get(
                    position
                )
            )
            view.findViewById(R.id.lyt_parent)
                .setBackgroundColor(getResources().getColor(color_array.get(position)))
            container.addView(view)
            return view
        }

        override fun getCount(): Int {
            return title_array.size
        }

        override fun isViewFromObject(view: View, obj: Any): Boolean {
            return view === obj
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            val view: View = `object` as View
            container.removeView(view)
        }
    }
}