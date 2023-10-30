package com.tc.peoplecleandatabase.screens.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tc.domain.model.local.People
import com.tc.domain.usecase.FetchAllPeopleUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleListViewModel @Inject constructor(
    val repository: FetchAllPeopleUseCaseImpl
): ViewModel() {
    private val _peopleData = MutableStateFlow<List<People>>(emptyList())
    val peopleData: StateFlow<List<People>> = _peopleData

    fun fetchAllPeople() {
        viewModelScope.launch {
            repository.execute().collect {
                if (it.isNotEmpty()) {
                    _peopleData.emit(it)
                } else {
                    _peopleData.emit(emptyList())
                }
            }

        }
    }
}