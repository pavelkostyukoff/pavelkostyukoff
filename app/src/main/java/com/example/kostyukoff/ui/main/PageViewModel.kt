package com.example.kostyukoff.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kostyukoff.model.LatestsEntity
import com.example.kostyukoff.ui.latest.GetLatestsUseCase
import com.example.kostyukoff.ui.latest.LatestState
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PageViewModel(private val useCase: GetLatestsUseCase) : ViewModel() {

    private val _index = MutableLiveData<Int>()
    private val _image = MutableLiveData<String>()
    var list = listOf<LatestsEntity>()
    private val stateInternal = MutableLiveData<LatestState>(LatestState.Loading)
    val state : LiveData<LatestState> = stateInternal
    //val text: LiveData<String> = Transformations.map(_index) {

        //"${list.firstOrNull()?.linkGif}: $it"
    //}
    init {
        viewModelScope.launch {
            useCase.getLatests()
                .map {
                    LatestState.Success(it) as LatestState
                }
                .catch {
                    emit(LatestState.Error)
                }
                .collect{
                    stateInternal.value = it
                }
        }
    }

    val image: LiveData<String> = Transformations.map(_image) {
        it
    }

    fun setIndex(index: Int) {
        _index.value = index
        _image.value = image.toString()
    }
}