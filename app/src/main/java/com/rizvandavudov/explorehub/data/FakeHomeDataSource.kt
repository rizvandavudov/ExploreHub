package com.rizvandavudov.explorehub.data

import com.rizvandavudov.explorehub.R
import com.rizvandavudov.explorehub.domain.model.CategoryType
import com.rizvandavudov.explorehub.domain.model.HomeCategory

object  FakeHomeDataSource {
    private val categories: List<HomeCategory> = listOf(
        HomeCategory(
            id =1,
            type = CategoryType.ANIMALS,
            title = "Heyvanlar",
            imageRes = R.drawable.animal
        ),
        HomeCategory(
            id = 2,
            type = CategoryType.CARS,
            title = "Masinlar",
            imageRes = R.drawable.car
        )
    )
    fun getCategories(): List<HomeCategory>{
        return categories
    }
}