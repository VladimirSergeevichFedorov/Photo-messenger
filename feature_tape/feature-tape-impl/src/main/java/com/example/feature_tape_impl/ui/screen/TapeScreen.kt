package com.example.feature_tape_impl.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.feature_tape_impl.ui.viewModel.TapeScreenViewModel

@OptIn(ExperimentalCoilApi::class)
@Composable
fun TapeScreen(viewModel: TapeScreenViewModel) {

    val usersData by viewModel.networkResultStateFlow.collectAsState()
    viewModel.loadUsersData()

    LazyColumn {
        if (usersData.isNotEmpty()) {
            usersData.forEach { userDataForTape ->
                item {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(top = 8.dp, start = 8.dp)
                            .clickable { }
                            .fillMaxWidth()
                    ) {
                        Image(
                            painter = rememberImagePainter(userDataForTape.avatar.orEmpty()),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(78.dp)
                                .clip(CircleShape)
                                .border(2.dp, Color.Gray, CircleShape)
                        )
                        Column(modifier = Modifier.padding(start = 6.dp)) {
                            Text(userDataForTape.firstName.orEmpty())
                            Text(userDataForTape.lastName.orEmpty())
                            Text(userDataForTape.email.orEmpty())
                        }
                    }
                }
            }
        }
    }
}
