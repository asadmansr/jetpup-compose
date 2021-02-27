package com.asadmansoor.jetpup.ui.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.asadmansoor.jetpup.data.Puppies
import com.asadmansoor.jetpup.data.Puppy

@Composable
fun PuppyListScreen(openPuppyDetail: (Int) -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.fillMaxHeight()) {
            Title()
            PuppyList(puppies = Puppies.data, Modifier.weight(1f), openPuppyDetail)
        }
    }
}

@Composable
fun Title() {
    MaterialTheme {
        val typography = MaterialTheme.typography
        Text(
            text = "Adopt a friend",
            Modifier.padding(24.dp),
            style = typography.h1,
        )
        Spacer(Modifier.height(36.dp))
    }
}

@Composable
fun PuppyList(puppies: List<Puppy>, modifier: Modifier = Modifier, openPuppyDetail: (Int) -> Unit) {
    val typography = MaterialTheme.typography
    LazyRow(modifier = modifier) {
        items(items = puppies) { puppy ->
            Spacer(Modifier.width(16.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = puppy.image),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(16.dp)
                        .height(300.dp)
                        .width(300.dp)
                        .shadow(24.dp, shape = RoundedCornerShape(16.dp))
                        .clip(shape = RoundedCornerShape(16.dp))
                        .clickable {
                            openPuppyDetail(puppy.id)
                        },
                    contentScale = ContentScale.None
                )
                Text(
                    text = puppy.name,
                    Modifier.padding(24.dp),
                    style = typography.h5,
                )
            }

            Spacer(Modifier.width(16.dp))
        }
    }
}