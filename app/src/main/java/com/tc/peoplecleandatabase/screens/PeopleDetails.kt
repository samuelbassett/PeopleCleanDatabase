package com.tc.peoplecleandatabase.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.tc.peoplecleandatabase.viewmodels.PeopleDetailsViewModel

@Composable
fun PeopleDetails(
    id: Int
) {
    val viewModel = hiltViewModel<PeopleDetailsViewModel>()
    val peopleData by viewModel.selectedPerson.collectAsState()
    viewModel.fetchPersonById(id)
    Column {
        Row {
            AsyncImage(
                model = peopleData?.avatarImage,
                contentDescription = "Avatar Image",
                modifier = Modifier
                    .height(128.dp)
                    .padding(end = 8.dp)
            )
            Text(
                text = "${peopleData?.firstName} ${peopleData?.lastName}",
                maxLines = 2,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp
                )
        }
        Spacer(modifier = Modifier.padding(top = 8.dp))
        Text(text = peopleData?.dateOfBirth.toString(), textAlign = TextAlign.End)
        Text(text = peopleData?.role.toString())
    }
}