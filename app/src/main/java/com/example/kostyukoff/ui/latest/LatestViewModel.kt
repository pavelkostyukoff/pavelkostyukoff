package com.example.kostyukoff.ui.latest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kostyukoff.model.LatestsEntity
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class LatestViewModel(private val useCase: GetLatestsUseCase) :ViewModel() {
    private val _index = MutableLiveData<Int>()
    private val stateInternal = MutableLiveData<LatestState>(LatestState.Loading)
    val state : LiveData<LatestState> = stateInternal
    var list = listOf<LatestsEntity>()
    val text: LiveData<Int> = MutableLiveData<Int>()

    //private val movieRepository= LatestsRepository()
    //val allLatestPosts: MutableLiveData<List<LatestsEntity>> get() = movieRepository.getMutableLiveData()

    init {
        viewModelScope.launch {
            useCase.getLatests()
                .map {
                    LatestState.Success(it, 0) as LatestState
                }
                .catch {
                    emit(LatestState.Error)
                }
                .collect{
                    stateInternal.value = it
                }
        }
    }

    fun setIndex(index: Int) {
        _index.value = index
    }
}