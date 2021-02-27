package com.asadmansoor.jetpup.ui.detail

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.asadmansoor.jetpup.R
import com.asadmansoor.jetpup.data.Puppies
import com.asadmansoor.jetpup.data.Puppy

@Composable
fun PuppyDetailScreen(puppyId: Int, navigateBack: () -> Unit) {
    val context = LocalContext.current
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "") },
                    navigationIcon = {
                        IconButton(onClick = {
                            navigateBack()
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_arrow_back_white_24),
                                contentDescription = null
                            )
                        }
                    }
                )
            },
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        Toast.makeText(context, "yay \uD83C\uDF89 Adopted!", Toast.LENGTH_LONG).show()
                    }
                ) {
                    Icon(
                        painterResource(id = R.drawable.baseline_pets_black_24),
                        contentDescription = null
                    )
                }
            },
            content = {
                PuppyDescription(puppy = Puppies.data[puppyId])
            }
        )
    }
}

@Composable
fun PuppyDescription(puppy: Puppy) {
    MaterialTheme {
        val typography = MaterialTheme.typography
        Column(Modifier.padding(horizontal = 24.dp)) {
            Spacer(Modifier.height(24.dp))
            Image(
                painter = painterResource(puppy.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(96.dp)
                    .clip(CircleShape),
                alignment = Alignment.Center
            )
            Spacer(Modifier.height(24.dp))
            Text(
                text = puppy.name,
                Modifier.padding(vertical = 4.dp),
                style = typography.h6,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = puppy.breed,
                Modifier.padding(vertical = 4.dp),
                style = typography.h6,
            )
            Text(
                text = puppy.description,
                Modifier.padding(vertical = 4.dp),
                style = typography.body1,
            )
            Text(
                text = "Hobby: ${puppy.hobby}",
                Modifier.padding(vertical = 8.dp),
                style = typography.body1,
            )
            Text(
                text = "Favourite Android Version: ${puppy.favouriteAndroid}",
                Modifier.padding(vertical = 4.dp),
                style = typography.body1,
            )
        }
    }
}
