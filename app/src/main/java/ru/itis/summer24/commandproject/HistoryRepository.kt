package ru.itis.summer24.commandproject

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object HistoryRepository {
    private val _sights = MutableLiveData<List<History>>()
    val sights: LiveData<List<History>> get() = _sights

    fun loadData(context: Context) {
        val database = AppDatabase.getDatabase(context)
        val historyDao = database.historyDao()

        CoroutineScope(Dispatchers.IO).launch {
            val data = historyDao.getAll()
            withContext(Dispatchers.Main) {
                _sights.postValue(data)
            }
        }
    }
}

