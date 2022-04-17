package com.example.feature_tape_impl.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.example.feature_tape_impl.ui.viewModel.UserScreenViewModel

@OptIn(ExperimentalCoilApi::class)
@Composable
fun UserScreen(
    viewModel: UserScreenViewModel,
) {

    val usersDatas by viewModel.getUserStateFlow.collectAsState()
    viewModel.get()
    usersDatas?.let { user ->
        Column(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = rememberImagePainter(user.avatar),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 50.dp)
                    .size(78.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
                    .align(Alignment.CenterHorizontally)
            )
            Column(modifier = Modifier.padding(start = 6.dp)) {
                Text(user.firstName)
                Text(user.lastName)
                Text(user.email)
            }
        }

//        Image(
//            painter = rememberImagePainter(usersDatas?.avatar),
//            contentDescription = null,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .padding(top = 20.dp, bottom = 50.dp)
//                .size(78.dp)
//                .clip(CircleShape)
//                .border(2.dp, Color.Gray, CircleShape)
//                .align(Alignment.CenterHorizontally)
//        )
//        Column(modifier = Modifier.padding(start = 6.dp)) {
//            Text("name: ${usersDatas?.firstName}")
//            Text("lastname: ${usersDatas?.lastName}")
//            Text("email: ${usersDatas?.email}")
//        }
    }
}
