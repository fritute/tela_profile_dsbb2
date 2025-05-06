package br.senai.sp.jandira.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun ProfileScreen() {
    val backgroundImage = painterResource(id = R.drawable.background)
    val profileImage = painterResource(id = R.drawable.perfil)
    val addContactClicked = remember { mutableStateOf(false) }
    val magentaColor = Color(0xFFD409EA)

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = backgroundImage,
            contentDescription = "Background Image Top",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .align(Alignment.TopCenter),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.White
            )
            Text(
                text = "Details",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(290.dp)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = profileImage,
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Text(
                text = "Jenny Wilson",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Sr. UI/UX Designer",
                fontSize = 16.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }


        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .offset(y = 230.dp)
        ) {
            ContactButton(icon = Icons.Filled.Email, text = "Email", iconColor = magentaColor)
            ContactButton(icon = Icons.Filled.Call, text = "Call", iconColor = magentaColor)
            ContactButton(icon = Icons.Filled.Place, text = "Whatsapp", iconColor = magentaColor)
            ContactButton(icon = Icons.Filled.Star, text = "Favorite", iconColor = magentaColor)
        }


        // Card Content (Bottom)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(610.dp) // Altura fixa do card
                .align(Alignment.BottomCenter)
                .offset(y = 100.dp),
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),

        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "Email",
                        tint = magentaColor,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = "Email",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.Black,
                    )
                }
                EmailRow(type = "Official", email = "michael.mitc@example.com")
                EmailRow(type = "Personal", email = "michael@example.com")

                Spacer(modifier = Modifier.height(16.dp))


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Call,
                        contentDescription = "Phone number",
                        tint = magentaColor,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = "Phone number",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.Black,
                    )
                }
                PhoneNumberRow(type = "Mobile", number = "(209) 555-0104")

                Spacer(modifier = Modifier.height(16.dp))

                // Team Section
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Team",
                        tint = magentaColor,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = "Team",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.Black,
                    )

                }
                Row(

                    modifier = Modifier.fillMaxWidth()
                        .padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Leads by",
                        tint = magentaColor,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = "Leads By",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.Black,
                    )

                }
                TeamRow(teamName = "Project Operation Team", leadsBy = "Darrell Steward")

                Spacer(modifier = Modifier.height(24.dp))


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { addContactClicked.value = true }
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "Add to contact",
                            tint = magentaColor
                        )
                        Text(
                            text = "Add to contact",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = magentaColor
                        )
                    }
                    Icon(
                        imageVector = Icons.Filled.Share,
                        contentDescription = "Share",
                        tint = magentaColor
                    )
                }


                if (addContactClicked.value) {

                    Text(
                        text = "Clicked!",
                        color = Color.Red
                    )
                }
            }
        }
    }
}

@Composable
fun EmailRow(type: String, email: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = type,
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.weight(0.3f)
        )
        Text(
            text = email,
            fontSize = 14.sp,
            color = Color.Black,
            modifier = Modifier.weight(0.7f)
        )
    }
}

@Composable
fun PhoneNumberRow(type: String, number: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = type,
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.weight(0.3f)
        )
        Text(
            text = number,
            fontSize = 14.sp,
            color = Color.Black,
            modifier = Modifier.weight(0.7f)
        )
    }
}

@Composable
fun TeamRow(teamName: String, leadsBy: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = teamName,
            fontSize = 14.sp,
            color = Color.Black,
        )
        Text(
            text = "Leads by: $leadsBy",
            fontSize = 14.sp,
            color = Color.Gray,
        )
    }
}

@Composable
fun ContactButton(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    text: String,
    iconColor: Color
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = icon,
                contentDescription = text,
                tint = iconColor
            )
        }
        Text(
            text = text,
            fontSize = 12.sp,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ProfileScreen()
}