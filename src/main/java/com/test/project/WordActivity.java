package com.test.project;

import android.content.Intent;
import android.os.Bundle;

import com.gyf.immersionbar.ImmersionBar;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class WordActivity extends AppCompatActivity {

    private ViewPager vp_main;
    private List<Fragment> mFragments;
    private int size;
    public List<WordBean> mAllList;
    public boolean isLeft;
    public boolean isRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
        initView();
        ImmersionBar.with(this).transparentStatusBar().fitsSystemWindows(false).statusBarDarkFont(false).init();

    }

    private void initView() {
        vp_main = (ViewPager) findViewById(R.id.vp_main);
        //添加fragment
        mFragments = new ArrayList<>();
        mAllList = new ArrayList<>();
        mAllList.add(new WordBean(1,"1.Начнём с простого. Как называется эта игра?", "a) Minecraft", "b) Roblox ", "c) Masanya", "d) Worms", 1, R.mipmap.a));
        mAllList.add(new WordBean(2,"2.Какая песня ассоциируется с этой пикчей?", "a) Whistle - Flo Rida ", "b) Baby - Justin Bieber", "c) Never gonna give you up - Rick Astley", "d) Friday - Rebecca Black", 0, R.mipmap.b));
        mAllList.add(new WordBean(3,"3.Что написано снизу? ", "a) ears", "b) bears", "c) b ", "d) s", 2, R.mipmap.c));
        mAllList.add(new WordBean(4,"4.На какой картинке изображен SKUF?", "a) a", "b) b", "c) c", "d) d ", 3, R.mipmap.d));
        mAllList.add(new WordBean(5,"5.Как называется этот мем?", "A) Distracted Boyfriend ", "B) Jealous Boyfriend", "C) Flirting Guy", "D) Cheating Partner", 0, R.mipmap.e));
        mAllList.add(new WordBean(6,"6.Название этого мема?", "A) Genius Guy", "B) Smart Guy", "C) Roll Safe (Think About It) ", "D) Brainy Boy", 2, R.mipmap.f));
        mAllList.add(new WordBean(7,"7.Название этого мема?", "A) Blue Cat", "B) Wandering Cat", "C) Smurf Cat ", "D) Blue guy", 2, R.mipmap.g));
        mAllList.add(new WordBean(8,"8.Как зовут этого прекрасного мужчину?", "A) Старый Бог ", "B) Cancel-", "C) Iceberg", "D) No[o]ne-", 0, R.mipmap.h));
        mAllList.add(new WordBean(9,"9.Что сделал парень в этот меме?", "A)Потушил пожар", "B)Спас кота ", "C)Срубил дерево", "D)Остановил аварию", 1, R.mipmap.i));
        mAllList.add(new WordBean(10,"10.Как зовут енота на фотографии?", "A) Маркос", " B) Педро ", "C) Олег", "D) Клара", 1, R.mipmap.j));
        mAllList.add(new WordBean(11,"11.Как подписанно второе фото?", "A) Small", "B) Small engineer", "C) Enginfar ", "D) Tiny engineer", 2, R.mipmap.k));
        mAllList.add(new WordBean(12,"12.Название этого мема?", "A) I am stuck", "B) Broken Door", "C) Let me out", "D) Door Stuck ", 3, R.mipmap.l));
        mAllList.add(new WordBean(13,"13.Что кричал английский стример GREEKGODX в этом клипе?", " A) OOOOOOOOOOO", "B) LET ME OUT, PLEASE", "C) БАЖЖОЖДА, ОТПУШИТЕ МЕНЬЯ? ", "D) Screen, ДУШИ", 2, R.mipmap.m));
        mAllList.add(new WordBean(14,"14.Заполните пропущенный текст", "A) Джин, Чонгук, Юнги, Гойко Митич, Намджун, Чингачгук", "B) Намджун, Чонгук, Чингачгук, Гойко Митич, Джин, Юнги ", "C) Чонгук, Джин, Чингачгук, Намджун, Юнги, Гойко Митич", "D) Намджун, Джин, Юнги, Хосок, Чимин, Тэхен, Чонгук", 1, R.mipmap.n));
        mAllList.add(new WordBean(15,"15.Настоящее имя этого актера", "A) Jackie Chan", "B) Lyu Chengxuan", "C) Zhang Weilin", "D) Chan kong-san ", 3, R.mipmap.o));
        if (mAllList != null) {
            size = mAllList.size();
            for (int i = 0; i < mAllList.size(); i++) {
                mFragments.add(WordFragment.newInstance(mAllList.get(i)));
            }
        }
        TabViewPagerAdapter adapter = new TabViewPagerAdapter(getSupportFragmentManager(), mFragments);
        vp_main.setAdapter(adapter);
        vp_main.setOffscreenPageLimit(3);

    }

    public void setPre() {
        int currentItem = vp_main.getCurrentItem();
        if (currentItem != 0) {
            vp_main.setCurrentItem(currentItem - 1);
        }
    }

    public void setNext() {
        int currentItem = vp_main.getCurrentItem();
        if (currentItem == size - 1) {
            startActivity(new Intent(this, SuccessActivity.class));
            finish();
        } else {
            vp_main.setCurrentItem(currentItem + 1);
        }
    }
}