package com.oktalk.fragmentviewer;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements EditTextFragment.OnButtonClickedListener{

    FrameLayout ll_editTextContainer;
    FrameLayout ll_textViewContainer;

    EditTextFragment fragmentEditText;
    TextViewFragment fragmentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        ll_editTextContainer = (FrameLayout) findViewById(R.id.ll_edit_text_container);
        ll_textViewContainer = (FrameLayout) findViewById(R.id.ll_text_view_container);


        if(savedInstanceState == null){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            if(fragmentEditText == null){
                fragmentEditText = new EditTextFragment();
            }

            if(fragmentTextView == null){
                fragmentTextView = new TextViewFragment();
            }

            transaction.add(R.id.ll_edit_text_container, fragmentEditText, "EDIT_TEXT_FRAGMENT");
            transaction.add(R.id.ll_text_view_container, fragmentTextView, "TEXT_VIEW_FRAGMENT");

            transaction.commit();
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onButtonClicked(String text) {
        TextViewFragment textViewFragment = (TextViewFragment) getSupportFragmentManager().findFragmentByTag("TEXT_VIEW_FRAGMENT");
            textViewFragment.updateFragment(text);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

}
