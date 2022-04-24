package com.example.ezinvoicebusiness.ui.my_invoices;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyInvoicesModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MyInvoicesModel() {
        mText = new MutableLiveData<>();
//        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}