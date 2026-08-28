package com.rizvandavudov.explorehub.data.repository

import com.rizvandavudov.explorehub.data.FakeHomeDataSource
import com.rizvandavudov.explorehub.domain.model.HomeCategory

class HomeRepository{
    fun getCategoies(): List<HomeCategory>{
        return FakeHomeDataSource.getCategories()
    }
}