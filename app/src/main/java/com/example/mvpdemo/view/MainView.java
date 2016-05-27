package com.example.mvpdemo.view;

import com.example.mvpdemo.model.DDGOPhoto;

/**
 * Created by pratyush on 5/24/16.
 */
public interface MainView {

    public void showProgress();

    public void cancelProgress();

    public void showToast(String message);

    public void updateList(DDGOPhoto ddgoPhoto);
}
