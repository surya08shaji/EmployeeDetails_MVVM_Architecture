package com.example.employeedetails.db.converter

import androidx.room.TypeConverter
import com.example.employeedetails.model.Company
import com.google.gson.Gson

class CompanyConverter {

    @TypeConverter
    fun fromCompanyToString(company: Company?):String{
        return Gson().toJson(company)
    }

    @TypeConverter
    fun fromStringToCompany(company: String): Company? {
        return Gson().fromJson(company, Company::class.java)
    }
}