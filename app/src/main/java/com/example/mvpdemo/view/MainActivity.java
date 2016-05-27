package com.example.mvpdemo.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.mvpdemo.R;
import com.example.mvpdemo.adapter.ImageListAdapter;
import com.example.mvpdemo.model.DDGOPhoto;
import com.example.mvpdemo.presenter.MainPresenter;
import com.example.mvpdemo.presenter.MainPresenterImp;

public class MainActivity extends AppCompatActivity implements MainView{

    private RecyclerView mRecyclerView;
    private ImageListAdapter mImageListAdapter;
    private ProgressDialog mProgressDialog;
    private MainPresenter mMainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inflate the Recycler View and components.
        int columns = getResources().getInteger(R.integer.num_thumbnail_columns);
        mRecyclerView = (RecyclerView) findViewById(R.id.image_list_rv);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getBaseContext(), columns));
        mImageListAdapter = new ImageListAdapter();
        mRecyclerView.setAdapter(mImageListAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        //Create a presenter.
        mMainPresenter = new MainPresenterImp(this);
        //Call presenter onCreate.
        mMainPresenter.onCreate();
    }

    @Override
    public void showProgress() {
        mProgressDialog = ProgressDialog.show(this, "", getResources().getString(R.string.loading_image_message));
    }

    @Override
    public void cancelProgress() {
        mProgressDialog.cancel();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateList(DDGOPhoto ddgoPhoto) {
        mImageListAdapter.setData(ddgoPhoto.getResults());
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Call presenter onStop.
        mMainPresenter.onStop();
    }

}
