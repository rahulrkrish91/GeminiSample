package com.example.sampleapp.ui

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampleapp.use_case.GetWhatIsInImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WhatIsInImageViewModel @Inject constructor(
    private val getWhatIsInImageUseCase: GetWhatIsInImageUseCase
) : ViewModel() {

    private val _mutableImageInfo:MutableLiveData<String> = MutableLiveData()
    val mutableImageInfo:LiveData<String>
        get() = _mutableImageInfo

    fun getImageInfo(context: Context) = viewModelScope.launch {
        _mutableImageInfo.value = getWhatIsInImageUseCase.invoke(context)
    }
}