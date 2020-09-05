package com.madina.sampleapp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.madina.sampleapp.domain.repository.interfaces.MovieRepository
import com.madina.sampleapp.ui.utils.Resource
import com.madina.sampleapp.ui.utils.RuntimeScoped
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

/**
 * Created by Agustin Madina on 05/09/20.
 */
@RuntimeScoped
class MainViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {

    fun getTopRatedMovies() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getTopRatedMovies()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}