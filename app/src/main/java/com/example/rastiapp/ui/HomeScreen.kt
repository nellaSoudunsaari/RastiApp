package com.example.rastiapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import com.example.rastiapp.viewModel.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(taskViewModel: TaskViewModel){
    var taskTitle by remember { mutableStateOf("") }
    val state = taskViewModel.uiState

    Scaffold(
        containerColor = Color(red = 47, green = 70, blue = 110),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color( red = 11, green = 47, blue = 110)
                ),
                title = { Text("Rästitehtävä", color = Color.White)}
            )
        }
    ){ paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            OutlinedTextField(
                value = taskTitle,
                label = { Text("Task name") },
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {taskTitle = it}
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                            taskViewModel.addTask(taskTitle)
                            taskTitle = ""
                            }
            ) {
                Text("Add task")
            }

            LazyColumn() {
                items(taskViewModel.tasks) { task ->
                    Card(){
                        Row(
                            modifier = Modifier.fillMaxWidth()
                                                .padding(4.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row (verticalAlignment =  Alignment.CenterVertically){
                                Checkbox(
                                    checked = task.done,
                                    onCheckedChange = {taskViewModel.toggleDone(task.id)}
                                )
                                Spacer(modifier = Modifier.width(8.dp))

                                Column {
                                    Text(text = task.title)
                                }
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = state.name,
                onValueChange = {taskViewModel.updateName(it)},
                label = { Text("Search for a pokemon") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = { taskViewModel.fetchPokemon() },
                modifier = Modifier.fillMaxWidth()
            ) { Text("Search") }

            when{
                state.pokemon != null ->
                    Text(
                        text = "Pokemon name: ${state.pokemon.name} Pokemon id: ${state.pokemon.id}",
                        color = Color.White
                    )
            }
        }
    }
}