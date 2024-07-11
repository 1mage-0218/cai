package com.test.project

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.gyf.immersionbar.ImmersionBar
import java.util.*

class WordActivity : AppCompatActivity() {
    private var vp_main: ViewPager? = null
    private var mFragments: MutableList<Fragment>? = null
    private var size = 0
    var mAllList: MutableList<WordBean>? = null
    var isLeft = false
    var isRight = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word)
        initView()
        ImmersionBar.with(this).transparentStatusBar().fitsSystemWindows(false).statusBarDarkFont(false).init()
    }

    private fun initView() {
        vp_main = findViewById<View>(R.id.vp_main) as ViewPager
        //添加fragment
        mFragments = ArrayList()
        mAllList = ArrayList()
        mAllList?.add(WordBean(1, "1.Начнём с простого. Как называется эта игра?", "a) Minecraft", "b) Roblox +", "c) Masanya", "d) Worms", 1, R.mipmap.a))
        mAllList?.add(WordBean(2, "2.Какая песня ассоциируется с этой пикчей?", "a) Whistle - Flo Rida +", "b) Baby - Justin Bieber", "c) Never gonna give you up - Rick Astley", "d) Friday - Rebecca Black", 0, R.mipmap.b))
        mAllList?.add(WordBean(3, "3.Что написано снизу? ", "a) ears", "b) bears", "c) b +", "d) s", 2, R.mipmap.c))
        mAllList?.add(WordBean(4, "4.На какой картинке изображен SKUF?", "a) a", "b) b", "c) c", "d) d +", 3, R.mipmap.d))
        mAllList?.add(WordBean(5, "5.Как называется этот мем?", "A) Distracted Boyfriend +", "B) Jealous Boyfriend", "C) Flirting Guy", "D) Cheating Partner", 0, R.mipmap.e))
        mAllList?.add(WordBean(6, "6.Название этого мема?", "A) Genius Guy", "B) Smart Guy", "C) Roll Safe (Think About It) +", "D) Brainy Boy", 2, R.mipmap.f))
        mAllList?.add(WordBean(7, "7.Название этого мема?", "A) Blue Cat", "B) Wandering Cat", "C) Smurf Cat +", "D) Blue guy", 2, R.mipmap.g))
        mAllList?.add(WordBean(8, "8.Как зовут этого прекрасного мужчину?", "A) Старый Бог +", "B) Cancel-", "C) Iceberg", "D) No[o]ne-", 0, R.mipmap.h))
        mAllList?.add(WordBean(9, "9.Что сделал парень в этот меме?", "A)Потушил пожар", "B)Спас кота +", "C)Срубил дерево", "D)Остановил аварию", 1, R.mipmap.i))
        mAllList?.add(WordBean(10, "10.Как зовут енота на фотографии?", "A) Маркос", " B) Педро +", "C) Олег", "D) Клара", 1, R.mipmap.j))
        mAllList?.add(WordBean(11, "11.Как подписанно второе фото?", "A) Small", "B) Small engineer", "C) Enginfar +", "D) Tiny engineer", 2, R.mipmap.k))
        mAllList?.add(WordBean(12, "12.Название этого мема?", "A) I am stuck", "B) Broken Door", "C) Let me out", "D) Door Stuck +", 3, R.mipmap.l))
        mAllList?.add(WordBean(13, "13.Что кричал английский стример GREEKGODX в этом клипе?", " A) OOOOOOOOOOO", "B) LET ME OUT, PLEASE", "C) БАЖЖОЖДА, ОТПУШИТЕ МЕНЬЯ? +", "D) Screen, ДУШИ", 2, R.mipmap.m))
        mAllList?.add(WordBean(14, "14.Заполните пропущенный текст", "A) Джин, Чонгук, Юнги, Гойко Митич, Намджун, Чингачгук", "B) Намджун, Чонгук, Чингачгук, Гойко Митич, Джин, Юнги +", "C) Чонгук, Джин, Чингачгук, Намджун, Юнги, Гойко Митич", "D) Намджун, Джин, Юнги, Хосок, Чимин, Тэхен, Чонгук", 1, R.mipmap.n))
        mAllList?.add(WordBean(15, "15.Настоящее имя этого актера", "A) Jackie Chan", "B) Lyu Chengxuan", "C) Zhang Weilin", "D) Chan kong-san +", 3, R.mipmap.o))
        if (mAllList != null) {
            size = mAllList!!.size
            for (i in mAllList!!.indices) {
                mFragments!!.add(WordFragment.newInstance(mAllList!!.get(i)))
            }
        }
        val adapter = TabViewPagerAdapter(supportFragmentManager, mFragments!!)
        vp_main!!.adapter = adapter
        vp_main!!.offscreenPageLimit = 3
    }

    fun setPre() {
        val currentItem = vp_main!!.currentItem
        if (currentItem != 0) {
            vp_main!!.currentItem = currentItem - 1
        }
    }

    fun setNext() {
        val currentItem = vp_main!!.currentItem
        if (currentItem == size - 1) {
            startActivity(Intent(this, SuccessActivity::class.java))
            finish()
        } else {
            vp_main!!.currentItem = currentItem + 1
        }
    }
}