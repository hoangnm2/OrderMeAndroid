package com.android.orderme;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.android.CustomUI.CircleTransformation;
import com.android.CustomUI.RevealBackground;
import com.android.adapter.CustomViewPagerAdapter;
import com.android.fragment.ListDishImageFragment;
import com.squareup.picasso.Picasso;

public class DishDetailsActivity extends AppCompatActivity
        implements RevealBackground.OnStateChangeListener,
        ListDishImageFragment.OnFragmentInteractionListener {

    private RevealBackground mRevealBackground;
    public static final String ARG_REVEAL_START_LOCATION = "reveal_start_location";
    private static final int USER_OPTIONS_ANIMATION_DELAY = 300;
    private static final Interpolator INTERPOLATOR = new DecelerateInterpolator();

    private TabLayout mTabLayout;
    private ImageView mDishPhoto;
    private View mDishDetails;
    private Button mOrderButton;
    private View mDishStats;
    private View mDishDetailsRoot;
    private ViewPager mViewPager;
    private CustomViewPagerAdapter mViewPagerAdapter;

    private ListDishImageFragment mImageFragmentTab;

    private int avatarSize;
    private String profilePhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_details);

        mImageFragmentTab = new ListDishImageFragment();

        mRevealBackground = (RevealBackground) findViewById(R.id.dishdetails_revealbg);
        mTabLayout = (TabLayout) findViewById(R.id.dishdetails_tablayout);
        mDishPhoto = (ImageView) findViewById(R.id.dishdetails_avatar);
        mDishDetails = findViewById(R.id.dishdetails_details);
        mOrderButton = (Button) findViewById(R.id.dishdetails_btn);
        mDishStats = findViewById(R.id.dishdetails_statsview);
        mDishDetailsRoot = findViewById(R.id.dishdetails_profileroot);
        mViewPager = (ViewPager) findViewById(R.id.dishdetails_viewpager);

        this.avatarSize = getResources().getDimensionPixelSize(R.dimen.dish_avatar_size);

        Picasso.with(this)
                .load(profilePhoto)
                .placeholder(R.drawable.dish_circle_image)
                .resize(avatarSize, avatarSize)
                .centerCrop()
                .transform(new CircleTransformation())
                .into(mDishPhoto);

        if (mViewPager != null)
            setupViewPager(mViewPager);

        setupTabs();
        setupRevealBackground(savedInstanceState);
    }

    private void setupViewPager(ViewPager viewPager) {
        mViewPagerAdapter = new CustomViewPagerAdapter(this.getBaseContext(), getSupportFragmentManager());
        mViewPagerAdapter.addFragment(mImageFragmentTab, "TabImage");
        viewPager.setAdapter(mViewPagerAdapter);
    }

    private void setupRevealBackground(Bundle savedInstanceState) {
        mRevealBackground.setOnStateChangeListener(this);
        if (savedInstanceState == null) {
            final int[] startingLocation = getIntent().getIntArrayExtra(ARG_REVEAL_START_LOCATION);
            mRevealBackground.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    mRevealBackground.getViewTreeObserver().removeOnPreDrawListener(this);
                    mRevealBackground.startFromLocation(startingLocation);
                    return true;
                }
            });
        } else {
            mRevealBackground.setToFinishedFrame();
        }
    }

    private void animateDishDetailsOptions() {
        mTabLayout.setTranslationY(-mTabLayout.getHeight());
        mTabLayout.animate().translationY(0).setDuration(300).setStartDelay(USER_OPTIONS_ANIMATION_DELAY).setInterpolator(INTERPOLATOR);
    }

    private void animateDishDetailsHeader() {
        mDishDetailsRoot.setTranslationY(-mDishDetailsRoot.getHeight());
        mDishPhoto.setTranslationY(-mDishPhoto.getHeight());
        mDishDetails.setTranslationY(-mDishDetails.getHeight());
        mDishStats.setAlpha(0);

        mDishDetailsRoot.animate().translationY(0).setDuration(300).setInterpolator(INTERPOLATOR);
        mDishPhoto.animate().translationY(0).setDuration(300).setStartDelay(100).setInterpolator(INTERPOLATOR);
        mDishDetails.animate().translationY(0).setDuration(300).setStartDelay(200).setInterpolator(INTERPOLATOR);
        mDishStats.animate().alpha(1).setDuration(200).setStartDelay(400).setInterpolator(INTERPOLATOR).start();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onStateChange(int state) {
        if (RevealBackground.STATE_FINISHED == state) {
            mImageFragmentTab.setVisualizeView(View.VISIBLE);
            mTabLayout.setVisibility(View.VISIBLE);
            mDishDetailsRoot.setVisibility(View.VISIBLE);
            animateDishDetailsOptions();
            animateDishDetailsHeader();
        } else {
            mTabLayout.setVisibility(View.INVISIBLE);
            mImageFragmentTab.setVisualizeView(View.INVISIBLE);
            mDishDetailsRoot.setVisibility(View.INVISIBLE);
        }
    }

    private void setupTabs() {
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.ic_action_search));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onBackPressed() {
        NavUtils.navigateUpFromSameTask(this);
    }

    public static void startActivityFromLocation(int[] startingLocation, Activity activity) {
        Intent intent = new Intent(activity, DishDetailsActivity.class);
        intent.putExtra(ARG_REVEAL_START_LOCATION, startingLocation);
        activity.startActivity(intent);
    }
}
