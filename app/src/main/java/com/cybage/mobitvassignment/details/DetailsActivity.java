package com.cybage.mobitvassignment.details;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.cybage.mobitvassignment.R;
import com.cybage.mobitvassignment.framework.ui.BaseActivity;

public class DetailsActivity extends BaseActivity {

    private ImageView mIvTopImage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(" ");

        mIvTopImage = (ImageView) findViewById(R.id.ivTopImage);

        //collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar);
        //collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public ImageView getTopImageView() {
        return mIvTopImage;
    }
}
