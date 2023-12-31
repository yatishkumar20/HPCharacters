package com.yatish.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.yatish.presentation.R
import com.yatish.presentation.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    title: String,
    showBack: Boolean = false,
    content: @Composable () -> Unit,
    onBackClick: () -> Unit = {}
) {
    Scaffold(
        topBar =
        {
            Column(modifier = Modifier.height(dimensionResource(id = R.dimen.toolbar_height))) {
                CenterAlignedTopAppBar(
                    title = {
                        Text(title, color = White)
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        MaterialTheme.colors.primaryVariant
                    ),
                    navigationIcon = {
                        if (showBack) {
                            Image(
                                painter = painterResource(com.google.android.material.R.drawable.abc_ic_ab_back_material),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(start = dimensionResource(id = R.dimen.toolbar_padding))
                                    .size(
                                        dimensionResource(id = R.dimen.toolbar_image_width),
                                        dimensionResource(id = R.dimen.toolbar_image_height)
                                    )
                                    .clickable {
                                        onBackClick()
                                    }
                            )
                        }
                    }
                )
            }

        }, content = { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                content()
            }
        })
}