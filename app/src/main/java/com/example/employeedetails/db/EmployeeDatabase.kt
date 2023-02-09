package com.example.employeedetails.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.employeedetails.model.DataModelItem
import com.example.employeedetails.db.converter.AddressConverter
import com.example.employeedetails.db.converter.CompanyConverter

@Database(entities = [DataModelItem::class], version = 1)
@TypeConverters(AddressConverter::class, CompanyConverter::class)
abstract class EmployeeDatabase : RoomDatabase() {
    abstract fun EmployeeDao() : EmployeeDao

    companion object {
        private var INSTANCE: EmployeeDatabase? = null

        fun getInstance(context: Context): EmployeeDatabase? {
            if (INSTANCE == null) {
                synchronized(EmployeeDatabase::class) {
                    if (INSTANCE == null){
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                            EmployeeDatabase::class.java, "employee.db")
                            .allowMainThreadQueries()
                            .build()
                    }

                }
            }
            return INSTANCE
        }

    }
}
