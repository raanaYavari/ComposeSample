package com.raana.bamacodechallenge.ui.component

import android.graphics.Color
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.raana.bamacodechallenge.R
import com.raana.bamacodechallenge.ui.navigation.Screen
import com.raana.bamacodechallenge.ui.theme.white


private sealed class NavigationItem(
    val screen: Screen,
    @StringRes val labelResId: Int,
    val icon: ImageVector
) {
    object Post : NavigationItem(
        screen = Screen.Post,
        labelResId = R.string.post,
        icon = Icons.Outlined.Edit,
    )

    object User : NavigationItem(
        screen = Screen.User,
        labelResId = R.string.user,
        icon = Icons.Outlined.Person,
    )
}


@Composable
fun AppBottomNavigationBar(
    navController: NavController,
    modifier: Modifier = Modifier,
    onNavigationSelected: (Screen) -> Unit
) {
    val items = listOf(
        NavigationItem.Post,
        NavigationItem.User,
    )

    BottomNavigation(
        modifier = modifier,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.screen.route,
                selectedContentColor = white,
                unselectedContentColor = white.copy(0.4f),
                onClick = { onNavigationSelected(item.screen) },
                label = {
                    Text(text = stringResource(item.labelResId))
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = stringResource(item.labelResId)
                    )
                },
                alwaysShowLabel = false,
            )
        }
    }
}