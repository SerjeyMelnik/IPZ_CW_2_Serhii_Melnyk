package com.example.ipz_cw_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ipz_cw_2.ui.theme.IPZ_CW_2_Serhii_MelnykTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IPZ_CW_2_Serhii_MelnykTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SignIn(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun SignIn(modifier: Modifier = Modifier) {

    Column {
        TextField(value = "", onValueChange = {}, placeholder = { Text("Enter Email") })
        TextField(value = "", onValueChange = {}, placeholder = { Text("Enter password") })
        Button(onClick = {

        }) {
            Text(text = "Sign in")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun SignInPreview() {
    IPZ_CW_2_Serhii_MelnykTheme {
        SignIn()
    }
}