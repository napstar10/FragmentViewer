package com.oktalk.fragmentviewer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link TextViewFragment#} factory method to
 * create an instance of this fragment.
 */
public class TextViewFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    TextView textView;
    View view;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private static final String PERSISTENT_VARIABLE_BUNDLE_KEY = "persistentVariable";


    public TextViewFragment() {
        setArguments(new Bundle());
        // Required empty public constructor
    }


    public void updateFragment(String text){
        textView.setText(text);
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void setText(String text) {
        TextView textView = (TextView) view.findViewById(R.id.tv);
        textView.setText(text);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_text_view, container, false);
        textView = (TextView) view.findViewById(R.id.tv);
        if(savedInstanceState != null){
            String text = savedInstanceState.getString(PERSISTENT_VARIABLE_BUNDLE_KEY);
            setText(text);
        }
        return view;
    }

    public void setName(String text){
        textView.setText(text);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String persistentVariable = textView.getText().toString();
        outState.putString(PERSISTENT_VARIABLE_BUNDLE_KEY, persistentVariable);
    }

}
