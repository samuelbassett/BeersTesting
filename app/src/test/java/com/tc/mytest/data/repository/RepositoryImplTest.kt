package com.tc.mytest.data.repository

import com.tc.mytest.data.model.beer.BeerItemModel
import com.tc.mytest.data.remote.ApiRequest

class RepositoryImplTest(apiRequest: ApiRequest) : Repository {

    val getBeersSuccess = listOf<BeerItemModel>(
        BeerItemModel(name = "beer")
    )

    val getBeersFailure = listOf<BeerItemModel>()

    val getBeerItemSuccess = listOf<BeerItemModel>(
        BeerItemModel(id = 1)
    )

    val getBeerItemFailure = listOf<BeerItemModel>()

    override suspend fun getBeers():List<BeerItemModel> {
        return getBeersSuccess
    }

    override suspend fun getBeerItem(id: Int): List<BeerItemModel> {
        return getBeerItemSuccess
    }
}