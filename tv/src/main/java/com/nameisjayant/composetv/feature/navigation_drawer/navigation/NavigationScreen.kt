package com.nameisjayant.composetv.feature.navigation_drawer.navigation


sealed class NavigationScreen (val route:String){

    data object Home  : NavigationScreen("/home")
    data object Movie : NavigationScreen("/movie")
    data object Show : NavigationScreen("/show")
    data object Wishlist : NavigationScreen("/wishlist")
    data object Setting : NavigationScreen("/setting-")

}