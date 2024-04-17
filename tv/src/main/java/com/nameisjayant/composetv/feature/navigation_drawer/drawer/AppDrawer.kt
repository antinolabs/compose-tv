package com.nameisjayant.composetv.feature.navigation_drawer.drawer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.tv.material3.DrawerValue
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Icon
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.ModalNavigationDrawer
import androidx.tv.material3.NavigationDrawerItem
import androidx.tv.material3.NavigationDrawerItemDefaults
import androidx.tv.material3.NavigationDrawerScope
import androidx.tv.material3.Text
import androidx.tv.material3.rememberDrawerState
import com.nameisjayant.composetv.feature.navigation_drawer.data.DrawerData
import com.nameisjayant.composetv.feature.navigation_drawer.data.DrawerItem


@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun AppDrawer(
    modifier: Modifier = Modifier,
    selectedItem: String = DrawerData.drawerModalData().first().id,
    onDrawerModalSelected: (DrawerItem) -> Unit,
    content: @Composable () -> Unit
) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerContent = {
            AppDrawerContent(
                selectedId = selectedItem,
                onDrawerModalSelected = onDrawerModalSelected
            ) {
                drawerState.setValue(DrawerValue.Closed)
            }
        }, drawerState = drawerState, modifier = modifier, scrimBrush = Brush.horizontalGradient(
            listOf(
                MaterialTheme.colorScheme.surface, Color.Transparent
            )
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 80.dp)
        ) {
            content()
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
private fun NavigationDrawerScope.AppDrawerContent(
    modifier: Modifier = Modifier,
    selectedId: String,
    onDrawerModalSelected: (DrawerItem) -> Unit,
    onDrawerClose: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box {}
        Column {
            DrawerData.drawerModalData().forEachIndexed { _, drawerItem ->
                AppDrawerItem(
                    data = drawerItem,
                    selected = selectedId == drawerItem.id,
                    onDrawerModalSelected = {
                        onDrawerModalSelected.invoke(it)
                        onDrawerClose()
                    })
            }
        }
        AppDrawerItem(
            data = DrawerData.settingItem,
            selected = selectedId == DrawerData.settingItem.id,
            onDrawerModalSelected = {
                onDrawerModalSelected.invoke(it)
                onDrawerClose()
            }
        )
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
private fun NavigationDrawerScope.AppDrawerItem(
    modifier: Modifier = Modifier,
    data: DrawerItem,
    selected: Boolean,
    onDrawerModalSelected: (DrawerItem) -> Unit,
) {
    NavigationDrawerItem(selected = selected, onClick = {
        onDrawerModalSelected.invoke(data)
    }, leadingContent = {
        Icon(imageVector = data.icon, contentDescription = null)
    }, modifier = modifier, colors = NavigationDrawerItemDefaults.colors(
        selectedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(
            alpha = 0.5f
        ),
        selectedContentColor = MaterialTheme.colorScheme.onSurface,
    )
    ) {
        Text(text = stringResource(id = data.title))
    }
}