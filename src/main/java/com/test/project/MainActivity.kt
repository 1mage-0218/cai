package com.test.project

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.gyf.immersionbar.ImmersionBar

class MainActivity : AppCompatActivity() {
    private var btn: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        ImmersionBar.with(this).transparentStatusBar().fitsSystemWindows(false).statusBarDarkFont(false).init()
    }

    private fun initView() {
        btn = findViewById(R.id.btn)
        btn?.setOnClickListener(View.OnClickListener { startActivity(Intent(this@MainActivity, WordActivity::class.java)) })
    }
}