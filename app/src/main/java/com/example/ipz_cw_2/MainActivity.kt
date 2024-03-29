package com.example.ipz_cw_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ipz_cw_2.ui.theme.IPZ_CW_2_Serhii_MelnykTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { Navigation() }
    }
}

@Composable
fun SignIn(modifier: Modifier = Modifier, navController: NavController) {


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(value = "", onValueChange = {}, placeholder = { Text("Enter Email") })
        TextField(value = "", onValueChange = {}, placeholder = { Text("Enter password") })
        Button(onClick = {
            navController.navigate(Screen.DetailScreen.withArgs("email"))
        }) {
            Text(text = "Sign in")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun SignInPreview() {
    IPZ_CW_2_Serhii_MelnykTheme {
        SignIn(navController = NavController(LocalContext.current))
    }
}


@Composable
fun DetailScreen(modifier: Modifier = Modifier, navController: NavController, email: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Hello, $email")
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    IPZ_CW_2_Serhii_MelnykTheme {
        DetailScreen(
            navController = NavController(LocalContext.current),
            email = "email"
        )
    }
}


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            SignIn(navController = navController)
        }
        composable(route = Screen.DetailScreen.route + "/{email}",
            arguments = listOf(navArgument("email") {
                type = NavType.StringType
                defaultValue = "Some Default"
                nullable = true
            })) { entry ->
            DetailScreen(navController = navController, email = entry.arguments?.getString("email") )
        }
    }
}