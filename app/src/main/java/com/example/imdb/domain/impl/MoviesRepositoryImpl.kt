package com.example.imdb.domain.impl

import com.example.imdb.data.NetworkClient
import com.example.imdb.data.dto.MoviesSearchRequest
import com.example.imdb.data.dto.MoviesSearchResponse
import com.example.imdb.domain.models.Movie
import com.example.imdb.domain.api.MoviesRepository
import com.example.imdb.util.Resource

class MoviesRepositoryImpl(private val networkClient: NetworkClient) : MoviesRepository {

    override fun searchMovies(expression: String): Resource<List<Movie>> {
        val response = networkClient.doRequest(MoviesSearchRequest(expression))
        return when (response.resultCode) {
            -1 -> {
                Resource.Error("Проверьте подключение к интернету")
            }
            200 -> {
                Resource.Success((response as MoviesSearchResponse).results.map {
                    Movie(it.id, it.resultType, it.image, it.title, it.description)})
            }
            else -> {
                Resource.Error("Ошибка сервера")
            }
        }
    }
}

