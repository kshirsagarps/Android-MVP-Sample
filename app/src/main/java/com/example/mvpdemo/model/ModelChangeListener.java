package com.example.mvpdemo.model;

/**
 * Created by pratyush on 5/24/16.
 */
public interface ModelChangeListener {
    public void onSuccess(DDGOPhoto ddgoPhoto);
    public void onError(String message);
}
