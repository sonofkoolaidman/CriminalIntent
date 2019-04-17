package com.ctech.max.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

public class CrimePagerActivity extends AppCompatActivity {

    // this is just a constant string we will use to set and get the crimeactivity in our intent
    private static final String EXTRA_CRIME_ID = "com.ctech.max.criminalintent.crime_id";

    private ViewPager mViewPager;
    private List<Crime> mCrimes;

    public static Intent newIntent(Context packageContext, UUID crimeId) {
        Intent myIntent = new Intent(packageContext, CrimePagerActivity.class);
        myIntent.putExtra(EXTRA_CRIME_ID, crimeId);
        return myIntent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_pager);

        //get the crimeId that was passed to us from the crimelist via the Intent
        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);

        //set the layout for the viewpager to be this view
        mViewPager = findViewById(R.id.crime_view_pager);

        //get the list of crimes(to scroll through)
        mCrimes = CrimeLab.get(this).getCrimes();

        //set up the adapter so it can create a crimefragment for a specific crime
        FragmentManager myFragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(myFragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Crime myCrime = mCrimes.get(position);
                return CrimeFragment.newInstance(myCrime.getId());
            }

            @Override
            public int getCount() {
                return mCrimes.size();
            }
        });

        //we got the crimeId from the Intent
        //so figure out what number in the list matches that crimeId and set it to be shown
        for (int i = 0; i < mCrimes.size(); i++) {
            if (mCrimes.get(i).getId().equals(crimeId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
