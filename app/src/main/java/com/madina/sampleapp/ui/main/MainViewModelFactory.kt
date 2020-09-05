package com.madina.sampleapp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.madina.sampleapp.domain.repository.interfaces.MovieRepository
import com.madina.sampleapp.ui.utils.RuntimeScoped
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
@RuntimeScoped
class MainViewModelFactory @Inject constructor(private val repository: MovieRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}