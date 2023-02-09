package com.example.employeedetails.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.employeedetails.db.converter.AddressConverter
import com.example.employeedetails.db.converter.CompanyConverter

@Entity(tableName = "Employee")
data class DataModelItem(
    @PrimaryKey val id: Int?,

    @ColumnInfo(name = "address")
    @TypeConverters(AddressConverter::class)
    val address: Address?,

    @ColumnInfo(name = "company")
    @TypeConverters(CompanyConverter::class)
    val company: Company?,

    @ColumnInfo(name = "email") val email: String?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "phone") val phone: String?,
    @ColumnInfo(name = "profile_image") val profile_image: String?,
    @ColumnInfo(name = "username") val username: String?,
    @ColumnInfo(name = "website") val website: String?
)

//data class DataModelItem(
//    val address: Address?,
//    val company: Company?,
//    val email: String?,
//    val id: Int?,
//    val name: String?,
//    val phone: String?,
//    val profile_image: String?,
//    val username: String?,
//    val website: String?
//)