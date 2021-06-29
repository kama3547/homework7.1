package com.example.homework71.onboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.homework71.R;

public class OnBoardingitemFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";


    private String text,description;
    private int image;

    private ImageView itemImage;
    private TextView itemTitle,itemDescription;


    public OnBoardingitemFragment() {
    }

    public static OnBoardingitemFragment newInstance(String text, String description, int image) {
        OnBoardingitemFragment fragment = new OnBoardingitemFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, text);
        args.putInt(ARG_PARAM2, image);
        args.putString(ARG_PARAM2, description);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            text = getArguments().getString(ARG_PARAM1);
            image = getArguments().getInt(ARG_PARAM2);
            description = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_on_boardingitem, container, false);
        itemImage = view.findViewById(R.id.item_image);
        itemTitle = view.findViewById(R.id.item_title);
        itemDescription = view.findViewById(R.id.description_item);
        itemImage.setImageResource(image);
        itemTitle.setText(text);
        itemDescription.setText(description);
        return view ;
    }
}