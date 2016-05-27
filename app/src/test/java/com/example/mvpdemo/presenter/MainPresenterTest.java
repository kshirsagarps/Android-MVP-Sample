package com.example.mvpdemo.presenter;

import com.example.mvpdemo.model.DDGOPhoto;
import com.example.mvpdemo.model.DataManager;
import com.example.mvpdemo.view.MainView;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.mock;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class MainPresenterTest {

    private MainView mockView;
    private DataManager mockDataManager;
    private MainPresenterImp mainPresenter;

    @Before
    public void setUp() throws Exception {
        mockView = mock(MainView.class);
        mockDataManager = mock(DataManager.class);
        mainPresenter = spy(new MainPresenterImp(mockView));
        mainPresenter.mDataManager = mockDataManager;
    }

    @Test
    public void ModelChangeSuccess() {
        DDGOPhoto ddgoPhoto = mock(DDGOPhoto.class);
        mainPresenter.onSuccess(ddgoPhoto);
        verify(mockView, times(1)).cancelProgress();
        verify(mockView, times(1)).updateList(ddgoPhoto);
    }

    @Test
    public void ModelChangeError() {
        String message = "Error";
        mainPresenter.onError(message);
        verify(mockView, times(1)).cancelProgress();
        verify(mockView, times(1)).showToast(message);
    }

    @Test
    public void onCreateTest() {
        mainPresenter.onCreate();
        verify(mockView, times(1)).showProgress();
    }
}