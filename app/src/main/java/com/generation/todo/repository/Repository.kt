package com.generation.todo.repository

import com.generation.todo.api.RetrofitInstance
import com.generation.todo.model.Categoria
import okhttp3.Response

class Repository {
    suspend fun listaCategoria(): retrofit2.Response<List<Categoria>> {
        return RetrofitInstance.api.listaCategoria() }
}