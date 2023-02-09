package com.example.employeedetails.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.employeedetails.data.ApiInterface
import com.example.employeedetails.db.EmployeeRepository
import com.example.employeedetails.viewModel.MainViewModel

class MainViewModelFactory(private val apiInterface: ApiInterface,private val employeeRepository: EmployeeRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.apiInterface,this.employeeRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}