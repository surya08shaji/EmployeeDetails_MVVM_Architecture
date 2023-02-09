package com.example.employeedetails.db

import android.content.Context
import com.example.employeedetails.model.DataModelItem

class EmployeeRepository(context: Context) {
    private val database : EmployeeDatabase? = EmployeeDatabase.getInstance(context)

    suspend fun insertAll(dataModelItem: List<DataModelItem?>?):List<Long>{
       return database?.EmployeeDao()?.insertAll(dataModelItem)?: arrayListOf()
    }

    suspend fun getAllData():List<DataModelItem>{
        return database?.EmployeeDao()?.getAll()?: arrayListOf()
    }

    suspend fun getCount():Long{
        return database?.EmployeeDao()?.getAllCount()?:0
    }
}


