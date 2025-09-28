package com.unsoed.informatikamobile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import kotlinx.coroutines.launch
import android.util.Log
import com.unsoed.informatikamobile.data.model.BookDoc
import com.unsoed.informatikamobile.data.network.RetrofitInstance

class MainViewModel : ViewModel() {

    private val _books = MutableLiveData<List<BookDoc>>(emptyList())
    val books: LiveData<List<BookDoc>> = _books

    fun fetchBooks(query: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.searchBooks(query)
                if (response.isSuccessful) {
                    val result = response.body()?.docs ?: emptyList()
                    _books.value = result
                    Log.d("MainViewModel", "Fetched ${result.size} items")
                } else {
                    Log.e("MainViewModel", "API error ${response.code()} ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("MainViewModel", "Exception: ${e.localizedMessage}", e)
            }
        }
    }
}
