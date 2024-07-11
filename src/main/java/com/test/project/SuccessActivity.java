package com.test.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gyf.immersionbar.ImmersionBar;

import androidx.appcompat.app.AppCompatActivity;

public class SuccessActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        ImmersionBar.with(this).transparentStatusBar().fitsSystemWindows(false).statusBarDarkFont(false).init();
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SuccessActivity.this,WordActivity.class));
                finish();
            }
        });
    }


}