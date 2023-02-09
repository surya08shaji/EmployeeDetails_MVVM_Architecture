package com.example.employeedetails.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.employeedetails.adapter.Adapter
import com.example.employeedetails.data.ApiInterface
import com.example.employeedetails.databinding.ActivityMainBinding
import com.example.employeedetails.db.EmployeeRepository
import com.example.employeedetails.viewModel.MainViewModel
import com.example.employeedetails.viewModelFactory.MainViewModelFactory


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val adapter = Adapter()
    private lateinit var binding: ActivityMainBinding
    private  val apiCall = ApiInterface.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       // employeeRepository = EmployeeRepository(this)


        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        binding.recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this, MainViewModelFactory(apiCall, EmployeeRepository(this)))
            .get(MainViewModel::class.java)

        observeGetDetails()
        observeInsertion()
        observeGetDetails()
        observeAllList()
        observeCount()
        viewModel.getCount()

    }

    private fun observeGetDetails() {
        viewModel.listLiveData.observe(this) { list ->
            if (list != null) {
                viewModel.insertAllData(list)
            }
        }
    }

    private fun observeInsertion(){
        viewModel.insertListLiveData.observe(this){
            if(it!=null && it.isNotEmpty()){
                Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun observeAllList(){
        viewModel.localListLiveData.observe(this){
            if(it!=null && it.isNotEmpty()){

                adapter.setArtList(it)
            }
        }
    }

    private fun observeCount(){
        viewModel.countLive.observe(this){
            if(it!=null){
                if(it<=0){
                    viewModel.getDetails()
                }else{
                    viewModel.getAllData()
                }
            }
        }
    }


}
