package com.cybage.mobitvassignment.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cybage.mobitvassignment.R;

/**
 * Temp
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends android.support.v4.app.Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public PlaceholderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sections, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        String selectedTabName = null;
        int sectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);
        switch (sectionNumber) {
            case 1:
                //Live
                selectedTabName = getString(R.string.live);
                break;
            case 2:
                //Shows
                selectedTabName = getString(R.string.shows);
                break;
            case 3:
                //Contacts
                selectedTabName = getString(R.string.movie);
                break;
            default:
                break;
        }
        textView.setText(selectedTabName);
        return rootView;
    }
}