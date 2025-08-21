package com.example.room_siswa.viewmodel

import androidx.lifecycle.*
import com.example.room_siswa.repositori.RepositoriSiswa
import com.example.room_siswa.room.Siswa
import kotlinx.coroutines.flow.*

class HomeViewModel(private val repositoriSiswa: RepositoriSiswa) : ViewModel() {

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val homeUiState: StateFlow<HomeUiState> = repositoriSiswa.getAllSiswaStream()
        .filterNotNull()
        .map { HomeUiState(listSiswa = it.toList()) }
        .stateIn(scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = HomeUiState()
        )

    data class HomeUiState(
        val listSiswa: List<Siswa> = listOf()
    )
}