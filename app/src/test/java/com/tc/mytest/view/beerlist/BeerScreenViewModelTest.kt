package com.tc.mytest.view.beerlist

import com.tc.mytest.data.model.beer.BeerItemModel
import com.tc.mytest.data.remote.ApiRequest
import com.tc.mytest.data.repository.RepositoryImplTest
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class BeerScreenViewModelTest {

    lateinit var repository: RepositoryImplTest
    val apiRequest: ApiRequest = mockk()


    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        repository = RepositoryImplTest(apiRequest)
    }

    @Test
    fun `Check response success in getBeers`() = runTest {
        val expectedBeers = listOf<BeerItemModel>(
            BeerItemModel(name = "beer")
        )
        coEvery { apiRequest.getBeers() } returns expectedBeers

        val actualBeers = repository.getBeers()

        assertEquals(expectedBeers, actualBeers)
    }

    @Test
    fun `Check response failure on getBeers`() = runTest {
        val expectedBeers = listOf<BeerItemModel>(
            BeerItemModel(name = "not beer")
        )
        coEvery { apiRequest.getBeers() } returns expectedBeers

        val actualBeers = repository.getBeers()

        assertNotEquals(expectedBeers, actualBeers)
    }

}