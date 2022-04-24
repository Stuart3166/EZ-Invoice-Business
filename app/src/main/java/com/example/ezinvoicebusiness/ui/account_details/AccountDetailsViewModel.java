package com.example.ezinvoicebusiness.ui.account_details;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AccountDetailsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AccountDetailsViewModel() {
        mText = new MutableLiveData<>();
//        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}