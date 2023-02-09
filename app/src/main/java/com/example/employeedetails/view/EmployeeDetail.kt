package com.example.employeedetails.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.employeedetails.databinding.ActivityEmployeeDetailsBinding
import com.squareup.picasso.Picasso

class EmployeeDetail : AppCompatActivity() {
    private lateinit var binding: ActivityEmployeeDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_employee_details)

        binding = ActivityEmployeeDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back.setOnClickListener {
            onBackPressed()
        }

        val image = intent.getStringExtra("image")
        val name = intent.getStringExtra("name")
        val username = intent.getStringExtra("username")
        val email = intent.getStringExtra("email")
        val street = intent.getStringExtra("street")
        val suite = intent.getStringExtra("suite")
        val city = intent.getStringExtra("city")
        val zipcode = intent.getStringExtra("zipcode")
        val phone = intent.getStringExtra("phone")
        val website = intent.getStringExtra("website")
        val companyname = intent.getStringExtra("companyname")
        val catchPhrase = intent.getStringExtra("catchPhrase")
        val bs = intent.getStringExtra("bs")

        Picasso.with(binding.profileImageED.context).load(image).into(binding.profileImageED)
        binding.nameApi.text = name
        binding.userNameApi.text = username
        binding.emailApi.text = email
        binding.streetApi.text = street
        binding.suiteApi.text = suite
        binding.cityApi.text = city
        binding.zipcodeApi.text = zipcode
        binding.phoneApi.text = phone
        binding.websiteApi.text = website
        binding.companyNameApi.text = companyname
        binding.catchPhraseApi.text = catchPhrase
        binding.bsApi.text = bs
    }
}