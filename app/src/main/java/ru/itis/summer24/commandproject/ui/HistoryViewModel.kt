package ru.itis.summer24.commandproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.itis.summer24.commandproject.data.LandmarksRepository

class HistoryViewModel (val repository: LandmarksRepository) : ViewModel(){

    val cart = repository.getHistory()

    class Factory(val repository: LandmarksRepository) : ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return HistoryViewModel(repository) as T
        }
    }
}