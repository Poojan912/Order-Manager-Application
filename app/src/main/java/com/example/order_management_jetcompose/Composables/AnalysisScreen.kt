package com.example.order_management_jetcompose.Composables

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import com.example.order_management_jetcompose.BottomBarScreen.Constants.BottomBarScreen



@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun AnalysisScreen(){
    val navController: NavHostController  = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }, content = { padding ->
            BottomNavGraph(navController = navController, padding = padding)
        }
    )
}

@Composable
fun BottomBar(navController: NavHostController){
    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination?.route




        com.example.order_management_jetcompose.BottomBarScreen.Constants.BottomBarScreen.forEach { navItem ->


            BottomNavigationItem(
                selected = currentDestination == navItem.route,
                onClick = {
                    navController.navigate(navItem.route)
                },
                icon = {
                    Icon(painter = painterResource(id = navItem.icon), contentDescription = navItem.label)
                },
                label = {
                    Text(text = navItem.label)
                },
                alwaysShowLabel = false
            )
        }
        }

}


