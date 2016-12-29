package com.cybage.mobitvassignment.details;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import com.cybage.mobitvassignment.R;
import com.cybage.mobitvassignment.details.model.Details;
import com.cybage.mobitvassignment.details.model.SimilarClip;
import com.cybage.mobitvassignment.details.model.SimilarClipsList;
import com.cybage.mobitvassignment.framework.common.Utils;
import com.cybage.mobitvassignment.framework.global.Constants;
import com.cybage.mobitvassignment.framework.network.ResponseBean;
import com.cybage.mobitvassignment.framework.ui.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Fragment for details screen
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends BaseFragment implements View.OnClickListener {

    private static final String TAG = "DetailsFragment";
    private String mDetailsId;
    private TextView mTvTitle;
    private TextView mTvDescription;
    private TextView mTvTime;
    private TextView mTvDuration;
    private TextView mTvSeeMore;
    private TextView mTvLoadMore;
    private TextView mTvSimilarClipLabel;
    private RecyclerView mRvSimilarClips;
    private boolean mIsExpanded;
    private boolean mIsExpandable;
    private SimilarClipsAdapter mScAdapter;
    private ArrayList<SimilarClip> mClipList;
    private List<SimilarClip> mAllClipsList;
    private int mOffset = 0;

    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getActivity().getIntent().getExtras();
        mDetailsId = bundle.getString(Constants.DETAILS_ID_KEY, null);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_details, container, false);
        showProgressDialog(getActivity(), getString(R.string.loading));

        initUI(rootView);

        return rootView;
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DetailsHelper detailsHelper = new DetailsHelper(this, Constants.GET_DETAILS);
        detailsHelper.getDetails(mDetailsId);
    }

    /**
     * Method used to init UI
     *
     * @param rootView root view
     */
    private void initUI(View rootView) {

        mTvTitle = (TextView) rootView.findViewById(R.id.tvTitle);
        mTvDescription = (TextView) rootView.findViewById(R.id.tvDescription);
        mTvTime = (TextView) rootView.findViewById(R.id.tvTime);
        mTvDuration = (TextView) rootView.findViewById(R.id.tvDuration);
        mTvSeeMore = (TextView) rootView.findViewById(R.id.tvSeeMore);
        mTvLoadMore = (TextView) rootView.findViewById(R.id.tvLoadMore);
        mTvSimilarClipLabel = (TextView) rootView.findViewById(R.id.tvSimilarClipLabel);

        mRvSimilarClips = (RecyclerView) rootView.findViewById(R.id.rvSimilarClips);
        mRvSimilarClips.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvSimilarClips.setNestedScrollingEnabled(false);

        mAllClipsList = new ArrayList<>();
        mClipList = new ArrayList<>();

        mScAdapter = new SimilarClipsAdapter(getActivity(), mClipList);
        mRvSimilarClips.setAdapter(mScAdapter);

        mTvSeeMore.setOnClickListener(this);
        mTvLoadMore.setOnClickListener(this);
    }


    @Override
    protected void onSuccessPostAction(ResponseBean responseBean) {
        stopProgressDialog();
        Log.i(TAG, "onSuccessPostAction");
        switch (responseBean.getOperationIdentifier()) {
            case Constants.GET_DETAILS:
                Details details = (Details) responseBean.getResponse().body();
                Log.i(TAG, "Response: " + details.toString());
                updateUI(details);
                if (details.getSimilarClipsId() != null && !details.getSimilarClipsId().isEmpty()) {
                    //get similar clips data
                    DetailsHelper detailsHelper = new DetailsHelper(this, Constants.GET_SIMILAR_CLIPS);
                    detailsHelper.getSimilarClips(details.getSimilarClipsId());
                }
                break;
            case Constants.GET_SIMILAR_CLIPS:
                mTvSimilarClipLabel.setVisibility(View.VISIBLE);
                SimilarClipsList similarClipsList = (SimilarClipsList) responseBean.getResponse().body();
                Log.i(TAG, "Response: " + similarClipsList.toString());
                mAllClipsList.clear();
                mAllClipsList = similarClipsList.getSimilarClips();
                mClipList.clear();
                if (mAllClipsList.size() <= 10) {
                    mClipList.addAll(mAllClipsList);
                } else {
                    mTvLoadMore.setVisibility(View.VISIBLE);
                    for (int i = 0; i < 10; i++) {
                        mClipList.add(mAllClipsList.get(i));
                    }
                    mOffset = 10;
                }
                mScAdapter.notifyDataSetChanged();
                mRvSimilarClips.setFocusable(false);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onErrorPostAction(ResponseBean responseBean) {
        stopProgressDialog();
        Log.i(TAG, "onErrorPostAction");
        switch (responseBean.getOperationIdentifier()) {
            case Constants.GET_DETAILS:
                Log.e(TAG, "Response: " + responseBean.getError().getMessage());
                handleException(getString(R.string.alert), responseBean.getError().getMessage());
                break;
            case Constants.GET_SIMILAR_CLIPS:
                Log.e(TAG, "Response: " + responseBean.getError().getMessage());
                handleException(getString(R.string.alert), responseBean.getError().getMessage());
                break;
            default:
                break;
        }
    }

    /**
     * Method used to update UI
     *
     * @param details Details object
     */
    private void updateUI(Details details) {
        Utils.loadImage(getActivity(), details.getUrl(), R.drawable.placeholder, ((DetailsActivity) getActivity()).getTopImageView());
        mTvTitle.setText(details.getTitle());
        mTvTime.setText(details.getTime());
        mTvDuration.setText(details.getDuration());
        mTvDescription.setText(details.getDescription());
        mTvDescription.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (!mIsExpandable) {
                    if (mTvDescription.getLineCount() > 3) {
                        mIsExpandable = true;
                        mTvDescription.setEllipsize(TextUtils.TruncateAt.END);
                        mTvSeeMore.setText(getString(R.string.see_more));
                        mTvSeeMore.setVisibility(View.VISIBLE);
                    } else {
                        mIsExpandable = false;
                        mTvSeeMore.setVisibility(View.GONE);
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvSeeMore:
                if (mIsExpandable) {
                    if (!mIsExpanded) {
                        mIsExpanded = true;
                        mTvDescription.setMaxLines(Integer.MAX_VALUE);
                        mTvSeeMore.setText(getString(R.string.see_less));
                    } else {
                        mIsExpanded = false;
                        mTvDescription.setMaxLines(3);
                        mTvDescription.setEllipsize(TextUtils.TruncateAt.END);
                        mTvSeeMore.setText(getString(R.string.see_more));
                    }
                }
                break;
            case R.id.tvLoadMore:
                if ((mOffset + 10) > mAllClipsList.size()) {
                    mClipList.clear();
                    mClipList.addAll(mAllClipsList);
                    mScAdapter.notifyDataSetChanged();
                    mTvLoadMore.setVisibility(View.GONE);
                } else {
                    for (int i = mOffset; i < mOffset + 10; i++) {
                        mClipList.add(mAllClipsList.get(i));
                        mScAdapter.notifyDataSetChanged();
                    }
                    mOffset = mOffset + 10;
                }
                break;
            default:
                break;
        }
    }
}
