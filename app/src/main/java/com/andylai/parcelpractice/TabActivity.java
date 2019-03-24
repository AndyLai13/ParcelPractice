package com.andylai.parcelpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Albums is a Parcel object basically,
        // that is not allowed to pass Parcel for addTab()
        // while Bundle is allowed.
        // So that, we can then wrap parcel into bundle, and pass bundle.
        Intent intent = getIntent();
        Albums cloud = intent.getParcelableExtra("cloud");

        Bundle bundle = new Bundle();
        bundle.putParcelable("cloud", cloud);

        setContentView(R.layout.activity_tab);
        FragmentTabHost tabHost = findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), R.id.fragmentContainer);

        tabHost.addTab(tabHost.newTabSpec("one").setIndicator(
                "Tab 1", getResources().getDrawable(R.mipmap.ic_launcher, null)), Fragment1.class, bundle);
        tabHost.addTab(tabHost.newTabSpec("two").setIndicator(
                "Tab 2", getResources().getDrawable(R.mipmap.ic_launcher, null)), Fragment2.class, null);
        tabHost.addTab(tabHost.newTabSpec("three").setIndicator(
                "Tab 3", getResources().getDrawable(R.mipmap.ic_launcher, null)), Fragment3.class, null);
    }

    public static class Fragment1 extends Fragment {

        public Fragment1() {
        }

        public static Fragment1 newInstance() {
            Bundle args = new Bundle();
            Fragment1 fragment = new Fragment1();
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            final View view = inflater.inflate(R.layout.fragment_layout, container, false);

            Bundle bundle = getArguments();
            Albums cloud = bundle.getParcelable("cloud");

            ((TextView)view.findViewById(R.id.textView1)).setText(String.valueOf(cloud.getUserId()));
            ((TextView)view.findViewById(R.id.textView2)).setText(String.valueOf(cloud.getId()));
            ((TextView)view.findViewById(R.id.textView3)).setText(cloud.getTitle());

            return view;
        }
    }

    public static class Fragment2 extends Fragment {

    }

    public static class Fragment3 extends Fragment {

    }
}
