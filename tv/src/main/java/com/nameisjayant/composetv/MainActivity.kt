package com.nameisjayant.composetv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Surface
import com.nameisjayant.composetv.feature.navigation_drawer.data.DrawerData
import com.nameisjayant.composetv.feature.navigation_drawer.drawer.AppDrawer
import com.nameisjayant.composetv.feature.navigation_drawer.navigation.AppNavigation
import com.nameisjayant.composetv.ui.theme.ComposeTVTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTVTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    shape = RectangleShape
                ) {
                    var selectedId by
                    remember { mutableStateOf(DrawerData.drawerModalData().first().id) }
                    val navHostController = rememberNavController()
                    AppDrawer(onDrawerModalSelected = {
                        selectedId = it.id
                        navHostController.navigate(it.id){
                            popUpTo(DrawerData.drawerModalData().first().id){
                                inclusive = true
                            }
                        }
                    }, selectedItem = selectedId) {
                        AppNavigation(navHostController = navHostController)
                    }
                }
            }
        }
    }
}
