package com.rizvandavudov.explorehub.domain.model

import androidx.annotation.DrawableRes

data class HomeCategory(
    val id: Int,
    val type: CategoryType,
    val title: String,
    @param:DrawableRes val imageRes: Int
)