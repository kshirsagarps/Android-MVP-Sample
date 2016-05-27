package com.example.mvpdemo.presenter;

import com.example.mvpdemo.model.DDGOPhoto;
import com.example.mvpdemo.model.DataManager;
import com.example.mvpdemo.model.ModelChangeListener;
import com.example.mvpdemo.view.MainView;

/**
 * Created by pratyush on 5/24/16.
 */
public class MainPresenterImp implements MainPresenter, ModelChangeListener {

    MainView mMainView;
    DataManager mDataManager;

    public MainPresenterImp(MainView mainView) {
        mMainView = mainView;
        mDataManager = new DataManager();
    }

    //Attach to the activity life-cycle onCreate().
    @Override
    public void onCreate() {
        //Show MainView Progress Spinner and getData from the Data Manager.
        mMainView.showProgress();
        mDataManager.getData(this);
    }

    //Attach to the activity life-cycle onStop().
    @Override
    public void onStop() {
        //Cancel any pending operations in the data manager.
        mDataManager.cancelData();
    }

    @Override
    public void onSuccess(DDGOPhoto ddgoPhoto) {
        //Cancel/Dismiss the Progress spinner and pass in the model data to view.
        mMainView.cancelProgress();
        mMainView.updateList(ddgoPhoto);
    }

    @Override
    public void onError(String message) {
        //Cancel/Dismiss the Progress spinner and show Toast with error message.
        mMainView.cancelProgress();
        mMainView.showToast(message);
    }
}
