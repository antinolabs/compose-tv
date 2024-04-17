package com.nameisjayant.composetv.feature.navigation_drawer.data

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LiveTv
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.nameisjayant.composetv.R
import com.nameisjayant.composetv.feature.navigation_drawer.navigation.NavigationScreen

data class DrawerItem(
    val id: String,
    @StringRes val title: Int,
    val icon: ImageVector
)


object DrawerData {

    fun drawerModalData(): List<DrawerItem> {
        return listOf(
            DrawerItem(NavigationScreen.Home.route, R.string.home, Icons.Filled.Home),
            DrawerItem(NavigationScreen.Movie.route, R.string.movies, Icons.Filled.Movie),
            DrawerItem(NavigationScreen.Show.route, R.string.shows, Icons.Filled.LiveTv),
            DrawerItem(
                NavigationScreen.Wishlist.route,
                R.string.wishlist,
                Icons.Filled.ShoppingCart
            ),
        )
    }

    val settingItem =
        DrawerItem(NavigationScreen.Setting.route, R.string.settings, Icons.Filled.Settings)

}