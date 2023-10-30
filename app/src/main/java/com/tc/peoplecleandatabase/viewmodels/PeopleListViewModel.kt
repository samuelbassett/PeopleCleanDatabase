package com.tc.peoplecleandatabase.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tc.data.model.local.PeopleEntity
import com.tc.domain.usecase.FetchAllPeopleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleListViewModel @Inject constructor(
    private val fetchAllPeopleUseCase: FetchAllPeopleUseCase
): ViewModel() {
    private val _peopleData = MutableStateFlow<List<PeopleEntity>>(emptyList())
    val peopleData: StateFlow<List<PeopleEntity>> = _peopleData

    fun fetchAllPeople() {
        viewModelScope.launch {
            _peopleData.emit(fetchAllPeopleUseCase.execute())
        }
    }
}