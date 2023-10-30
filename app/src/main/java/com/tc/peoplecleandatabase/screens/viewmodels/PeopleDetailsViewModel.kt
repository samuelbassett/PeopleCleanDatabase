package com.tc.peoplecleandatabase.screens.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tc.domain.model.local.People
import com.tc.domain.model.local.PeopleDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleDetailsViewModel @Inject constructor(
    private val peopleDao: PeopleDao
) : ViewModel() {
    private val _selectedPerson = MutableStateFlow<People?>(null)
    val selectedPerson: StateFlow<People?> = _selectedPerson

    fun fetchPersonById(personId: Long) {
        viewModelScope.launch {
            val person = peopleDao.getPersonById(personId)
            _selectedPerson.value = person
        }
    }
}