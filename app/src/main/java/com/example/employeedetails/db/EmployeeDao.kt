package com.example.employeedetails.db

import androidx.room.*
import com.example.employeedetails.model.DataModelItem

@Dao
interface EmployeeDao {

    @Query("SELECT * FROM Employee")
    suspend fun getAll():List<DataModelItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(dataModelItem: List<DataModelItem?>?):List<Long>?

    @Delete
    suspend fun delete(dataModelItem: DataModelItem)

    @Query("select count(*) from Employee")
    suspend fun getAllCount():Long


}

