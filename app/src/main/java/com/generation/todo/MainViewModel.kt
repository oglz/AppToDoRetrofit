package com.generation.todo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.generation.todo.model.Categoria
import com.generation.todo.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor
    (val repository: Repository) :
    ViewModel() {
    private val _respostaListCategoria =
        MutableLiveData<retrofit2.Response<List<Categoria>>>()
    val respostaListCategoria: LiveData<retrofit2.Response<List<Categoria>>> =
        _respostaListCategoria

    fun listaCategoria(){
        viewModelScope.launch {
            try {
                val resposta = repository.listaCategoria()
                _respostaListCategoria.value = resposta }
            catch (e: Exception){
                Log.d("Erro", e.message.toString()) }
        }
    }
}