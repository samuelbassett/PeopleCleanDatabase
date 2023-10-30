package com.tc.peoplecleandatabase.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tc.data.model.PeopleModel
import com.tc.data.model.local.PeopleEntity
import com.tc.domain.usecase.FetchPeopleByIdUseCase
import com.tc.domain.usecase.FetchPeopleByIdUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleDetailsViewModel @Inject constructor(
    private val fetchPeopleByIdUseCase: FetchPeopleByIdUseCaseImpl
) : ViewModel() {
    private val _selectedPerson = MutableStateFlow(PeopleEntity())
    val selectedPerson: StateFlow<PeopleEntity> = _selectedPerson

    fun fetchPersonById(personId: Int) {
        viewModelScope.launch {
            val person = fetchPeopleByIdUseCase.execute(personId)
            _selectedPerson.value = person
        }
    }
}