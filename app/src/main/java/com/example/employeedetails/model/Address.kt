package com.example.employeedetails.model

import androidx.room.ColumnInfo

data class Address(
    @ColumnInfo(name = "city") val city: String?,
    @ColumnInfo(name = "street") val street: String?,
    @ColumnInfo(name = "suite") val suite: String?,
    @ColumnInfo(name = "zipcode") val zipcode: String?
)