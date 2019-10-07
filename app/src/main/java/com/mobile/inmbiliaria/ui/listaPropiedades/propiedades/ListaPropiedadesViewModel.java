package com.mobile.inmbiliaria.ui.listaPropiedades.propiedades;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ListaPropiedadesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ListaPropiedadesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}