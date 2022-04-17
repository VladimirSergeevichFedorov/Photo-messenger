package com.example.photoch.ui

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.common.Destinations
import com.example.common.find
import com.example.common.theme.AppBlack
import com.example.common.utils.glow
import com.example.feature_tape_api.TapeEntry

@Composable
fun BottomMenuBar(
    navController: NavController,
    destinations: Destinations
) {
    BottomNavigationLayout {
        GlowingMenuIcon(
            isGlowing = true,
            glowingIcon = Icons.Rounded.Home,
            idleIcon = Icons.Outlined.Home,
            modifier = Modifier
                .clickable(
                    indication = rememberRipple(bounded = false),
                    interactionSource = remember { MutableInteractionSource() }
                ) {
//                    val route = destinations.find<LoginEntry>().featureRoute
//                    navController.popBackStack(route, inclusive = false)
                }
        )
        Box(contentAlignment = Alignment.Center) {
            val context = LocalContext.current
            GlowingMenuIcon(
                isGlowing = false,
                glowingIcon = Icons.Rounded.Add,
                idleIcon = Icons.Outlined.Add,
                modifier = Modifier.clickable {
                    Toast.makeText(context, "Not implemented.", Toast.LENGTH_SHORT).show()
                }
            )
            Box(
                Modifier
                    .aspectRatio(1f)
                    .padding(15.dp)
                    .fillMaxSize()
                    .border(
                        border = BorderStroke(width = 2.dp, color = Color.White),
                        shape = RoundedCornerShape(percent = 50)
                    )
            )
        }
        GlowingMenuIcon(
            isGlowing = false,
            glowingIcon = Icons.Rounded.Person,
            idleIcon = Icons.Outlined.Person,
            modifier = Modifier.clickable(
                indication = rememberRipple(bounded = false),
                interactionSource = remember { MutableInteractionSource() }
            ) {
                val route = destinations
                    .find<TapeEntry>()
                    .myProfileDestination()
                navController.navigate(route) {
                    launchSingleTop = true
                }
            }
        )
    }
}

@Composable
private inline fun BottomNavigationLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Row(
        modifier
            .padding(top = 5.dp)
            .fillMaxWidth()
            .height(70.dp)
            .glow(AppBlack, radius = 20.dp, alpha = 0.9f, offsetY = 10.dp)
            .clip(RoundedCornerShape(topStartPercent = 40, topEndPercent = 40))
            .background(AppBlack),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}
