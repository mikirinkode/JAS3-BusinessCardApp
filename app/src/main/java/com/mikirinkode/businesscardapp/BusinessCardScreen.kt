package com.mikirinkode.businesscardapp

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mikirinkode.businesscardapp.ui.theme.BusinessCardAppTheme

@Composable
fun BusinessCardScreen(
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .verticalScroll(scrollState)
    ) {
        Box(
            modifier = Modifier.weight(1f)
        ) {
            ProfileSection(
                imageId = R.drawable.android_logo,
                name = "Muhammad Wafa",
                title = "Android Developer Extraordinaire",
                modifier = Modifier.align(Alignment.Center)
            )
        }
        ContactSection(
            phoneNumber = "+62 812 7130 6749",
            profileUsername = "@wafa",
            email = "muhammadwafa105@gmail.com"
        )
    }
}

@Composable
fun ProfileSection(
    imageId: Int,
    name: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "Profile Photo",
            modifier = Modifier
                .size(120.dp)
                .background(color = Color(0xFF073042))
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(name, fontSize = 32.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Text(title, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
fun ContactSection(
    phoneNumber: String,
    profileUsername: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .padding(bottom = 32.dp)
    ) {
        ContactItem(
            icon = Icons.Rounded.Phone,
            iconDesc = "Phone Icon",
            value = phoneNumber,
            onItemClicked = {},
            modifier = Modifier
                .wrapContentWidth()
        )
        ContactItem(
            icon = Icons.Rounded.Share,
            iconDesc = "Share Icon",
            value = profileUsername,
            onItemClicked = {})
        ContactItem(
            icon = Icons.Rounded.Email,
            iconDesc = "Email Icon",
            value = email,
            onItemClicked = {})
    }
}

@Composable
fun ContactItem(
    icon: ImageVector,
    iconDesc: String,
    value: String,
    onItemClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .clickable(onClick = onItemClicked)
            .padding(8.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = iconDesc,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(24.dp),
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(value, modifier = Modifier)
    }
}


@Preview(name = "light", showBackground = true, showSystemUi = true)
@Preview(
    name = "night",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun BusinessCardScreenPreview() {
    BusinessCardAppTheme {
        Surface() {
            BusinessCardScreen()
        }
    }
}