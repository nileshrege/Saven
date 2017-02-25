package com.saven.alerts.saven;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by nrege on 2/25/2017.
 */

public class DailyAnalyticsFragment extends Fragment {

    final String IMAGE_RESOURCE = "IMAGE_RESOURCE";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_main, container, false);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);
        Glide.with(this)
                .load(getString(R.string.image_path)+getArguments().get(IMAGE_RESOURCE)+".png")
                .centerCrop()
                .crossFade()
                .into(imageView);
        return rootView;
    }
}
