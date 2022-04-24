package com.example.ezinvoicebusiness.ui.my_clients;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyClientsModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MyClientsModel() {
        mText = new MutableLiveData<>();
//        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}