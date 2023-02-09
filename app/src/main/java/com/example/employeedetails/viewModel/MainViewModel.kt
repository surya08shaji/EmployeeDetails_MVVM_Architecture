package com.example.employeedetails.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.employeedetails.data.ApiInterface
import com.example.employeedetails.db.EmployeeRepository
import com.example.employeedetails.model.DataModelItem
import kotlinx.coroutines.launch

class MainViewModel(private val apiInterface: ApiInterface,private val employeeRepository: EmployeeRepository) : ViewModel() {


    private val list = MutableLiveData<List<DataModelItem>?>()
    val listLiveData: LiveData<List<DataModelItem>?> = list

    private val insertList = MutableLiveData<List<Long>?>()
    val insertListLiveData: LiveData<List<Long>?> = insertList

    private val localList = MutableLiveData<List<DataModelItem>?>()
    val localListLiveData: LiveData<List<DataModelItem>?> = localList

    private val count = MutableLiveData<Long?>()
    val countLive: LiveData<Long?> = count



    fun getDetails() = viewModelScope.launch {
        try {
            val response = apiInterface.getList()
            if(response.isSuccessful){
                list.postValue(response.body())
            }else{
                list.postValue(null)
            }
        }catch (e:Exception){
            list.postValue(null)
        }
    }


    fun insertAllData(list: List<DataModelItem>)=viewModelScope.launch {
        try {
            val response = employeeRepository.insertAll(list)
            insertList.postValue(response)
            getAllData()
        }catch (e:Exception){
            insertList.postValue(null)
        }
    }

    fun getAllData()=viewModelScope.launch {
        try {
            val response = employeeRepository.getAllData()
            localList.postValue(response)
        }catch (e:Exception){
            localList.postValue(null)
        }
    }

    fun getCount()=viewModelScope.launch {
        try {
            val response = employeeRepository.getCount()
            count.postValue(response)
        }catch (e:Exception){
            count.postValue(null)
        }
    }


    /*fun networkRequest() {

        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            withContext(Dispatchers.Main) {
                try {
                    val response = apiInterface.getList()
                    if (response.isSuccessful) {
                        getAllData.postValue(response.body())
                    } else {
                        getAllData.postValue(null)
                    }

                } catch (e: Exception) {
                    getAllData.postValue(null)
                }
            }
        }
    }*/

    /* fun insertAll(list: List<UserDetailsModel>) = viewModelScope.launch {
         localRepository.insertAll(list)
         getAllData()
     }

     fun getAllData() = viewModelScope.launch {
         val response = localRepository.getAllData()
         userDetailsLocalModel.postValue(response)
         Log.e("insert result", "<<<<<<< ${response.size} >>>>>>>")
     }

     fun getAllDataCount() = viewModelScope.launch {
         val response = localRepository.getAllDataCount()
         userDetailsModelCount.postValue(response)
     }*/
}


//                if (response.isSuccessful) {
//
//                    val data = response.body()
//                    employeeList = data
//
//                    try {
//                        val insertListStatus =   employeeRepository?.insertAll(employeeList)
//                        Log.e("insertTag","<<<<<  ${insertListStatus?.size}")
//
//
//                        employeeRepository?.getAllData()?.forEach {
//
//
//                            Log.e("details","name: ${it.name}\t email:${it.email} address:${it.address?.zipcode},${it.address?.city}\n")
//                        }
//
//                    }  catch (e:Exception){
//                        Log.e("exce","${e.message}")
//                    }
//
//
//                } else {
//                    Toast.makeText(this@MainActivity, "something went wrong...", Toast.LENGTH_SHORT)
//                        .show()
//                }


//    suspend fun insertAll(dataModelItem: List<DataModelItem?>?){
//        employeeRepository?.insertAll(dataModelItem)
//    }
//    val allEmployee: LiveData<List<DataModelItem?>?>?
//    get() = getAllEmployee





