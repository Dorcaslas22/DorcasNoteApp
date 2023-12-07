package com.wtm.dorcasnoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wtm.dorcasnoteapp.ui.theme.DorcasNoteAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DorcasNoteAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(){
    var username by remember {mutableStateOf("")}
    var password by remember { mutableStateOf("")}
    var confirmPassword by remember { mutableStateOf("")}
    var fullName by remember { mutableStateOf("")}
    var emailAddress by remember { mutableStateOf("")

    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(all=8.dp)
    ){
        Text(
            text = "Simple Login Page!",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
        )
        TextField(
            value = fullName,
            onValueChange = {fullNameInput -> fullName = fullNameInput},
            label = {Text("Fullname")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        )
        TextField(
            value = emailAddress,
            onValueChange = {emailAddressInput -> emailAddress = emailAddressInput},
            label = {Text("EmailAddress")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        )
        TextField(
            value = username,
            onValueChange = {usernameInput -> username = usernameInput},
            label = {Text("Username")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        )
        TextField(
            value = password,
            onValueChange = {pwdInput -> password = pwdInput},
            label = {Text("Password")},
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        )

        TextField(
            value = confirmPassword,
            onValueChange = {confirmPasswordInput -> confirmPassword = confirmPasswordInput},
            label = {Text("confirmPassword")},
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)

        )
       RememberMe()
        Button(onClick = {}){
            Text(text="Login")
        }
        Row {
          Image(painter = painterResource(id = R.drawable.google_1),
              contentDescription = "Clickable facebook icon",
              modifier = Modifier.size(24.dp)
          )
            Image(painter = painterResource(id = R.drawable.facebook_1),
                contentDescription = "Clickable google icon",
                 modifier = Modifier
                     .size(24.dp)
                     .clickable {

                     }

            )
        }
    }
}
@Composable
fun RememberMe(){
    var isChecked by remember{ mutableStateOf(false) }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Remember Me")
        Switch(checked = isChecked,
            onCheckedChange = {isChecked= !isChecked
            }
        )

    }
}
   @Preview
   @Composable
   fun LoginScreenPreview(){
       Surface(
           modifier = Modifier.fillMaxSize(),
           color = MaterialTheme.colorScheme.background
       ) {
           LoginScreen()
       }
}