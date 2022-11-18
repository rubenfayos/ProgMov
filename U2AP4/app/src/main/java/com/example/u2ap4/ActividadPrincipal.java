package com.example.u2ap4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

public class ActividadPrincipal extends AppCompatActivity {

    private TabLayout tableLayout;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);

        tableLayout = findViewById(R.id.tabLayout);
        pager = findViewById(R.id.pager);

        tableLayout.setupWithViewPager(pager);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        pagerAdapter.addFragment(new MainFragment(), "Inicio");
        pagerAdapter.addFragment(new IntroduccionFragment(), "Introduccion");
        pagerAdapter.addFragment(new VideotutorialFragment(), "Videotutorial");
        pagerAdapter.addFragment(new FAQFragment(), "FAQ");
        pager.setAdapter(pagerAdapter);

    }
}