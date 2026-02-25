package com.example.rastiapp.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rastiapp.data.Task
import com.example.rastiapp.data.model.ApiResponse
import com.example.rastiapp.data.remote.RetrofitInstance
import kotlinx.coroutines.launch

data class PokemonUiState(
    val name: String = "",
    val id: Int = 0,
    val pokemon: ApiResponse? = null
)
class TaskViewModel: ViewModel() {
    var uiState by mutableStateOf(PokemonUiState())
        private set

    fun updateName(newName: String){
        uiState = uiState.copy(name = newName)
    }
    var tasks by mutableStateOf(listOf<Task>())
    private set
    init {
        tasks = listOf(
            Task(1, "Task1"),
            Task(2, "Task2"),
            Task(3, "Task3"),
            Task(4, "Task4")
        )
    }

    fun toggleDone(id: Int){
        tasks = tasks.map{
            if(it.id == id) {
                it.copy(done = !it.done)
            } else {
                it
            }
        }
    }

    fun addTask(title: String) {
        val nextId = (tasks.maxOfOrNull { it.id } ?: 0) + 1
        tasks = tasks + Task(nextId, title)
    }

    fun fetchPokemon() {
        viewModelScope.launch {
            val res = RetrofitInstance.api.getPokemonByName(
                pokemon = uiState.name
            )

            uiState = uiState.copy(pokemon = res)
        }
    }

}