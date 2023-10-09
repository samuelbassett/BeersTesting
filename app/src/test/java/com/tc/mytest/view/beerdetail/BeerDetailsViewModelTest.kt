package com.tc.mytest.view.beerdetail

import com.tc.mytest.data.model.beer.BeerItemModel
import com.tc.mytest.data.remote.ApiRequest
import com.tc.mytest.data.repository.RepositoryImpl
import com.tc.mytest.data.repository.RepositoryImplTest
import com.tc.mytest.view.beerlist.BeerScreenViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test

class BeerDetailsViewModelTest {

    lateinit var repository: RepositoryImplTest
    val apiRequest: ApiRequest = mockk()


    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        repository = RepositoryImplTest(apiRequest)
    }

    @Test
    fun `Check response success in getBeerItem`() = runTest {
        val expectedBeers = listOf<BeerItemModel>(
            BeerItemModel(id = 1)
        )
        val beerId = 1
        coEvery { apiRequest.getBeerItem(beerId) } returns expectedBeers

        val actualBeers = repository.getBeerItem(beerId)

        assertEquals(expectedBeers, actualBeers)
    }

    @Test
    fun `Check response failure on getBeerItem`() = runTest {
        val expectedBeers = listOf<BeerItemModel>(
            BeerItemModel(id = 2)
        )
        val beerId = 1
        coEvery { apiRequest.getBeerItem(beerId) } returns expectedBeers

        val actualBeers = repository.getBeerItem(beerId)

        assertNotEquals(expectedBeers, actualBeers)
    }

}