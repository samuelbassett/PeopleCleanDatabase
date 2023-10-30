package com.tc.peoplecleandatabase.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.tc.data.model.local.PeopleEntity
import com.tc.peoplecleandatabase.viewmodels.PeopleListViewModel

@Composable
fun PeopleScreen(
    navController: NavController
) {
    val viewModel = hiltViewModel<PeopleListViewModel>()
    val peopleData by viewModel.peopleData.collectAsState()

    viewModel.fetchAllPeople()

    val navigateToDetails: (Int) -> Unit = { id ->
        navController.navigate("${Screens.PeopleDetails.route}/$id")
    }

    LazyColumn(
        modifier = Modifier
            .padding(top = 64.dp)
            .fillMaxSize()
    ) {
        items(peopleData) { people ->
            PeopleItem(people, navigateToDetails)
        }
    }
}

@Composable
fun PeopleItem(people: PeopleEntity, navigateToDetails: (Int) -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(10.dp),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxSize()
            .clickable { navigateToDetails(people.id) }
    ) {
        Row {
            AsyncImage(
                model = people.avatarImage,
                contentDescription = "Avatar Image",
                modifier = Modifier
                    .clip(CircleShape)
                    .height(64.dp)
                    .padding(8.dp)
            )
            Text(
                text = "${people.firstName} ${people.lastName}",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}