package com.example.employeedetails.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.employeedetails.view.EmployeeDetail
import com.example.employeedetails.databinding.EmployeeListAdapterBinding
import com.example.employeedetails.model.DataModelItem
import com.squareup.picasso.Picasso

class Adapter: RecyclerView.Adapter<Adapter.ViewHolder>() {

    private var lists = mutableListOf<DataModelItem>()
    @SuppressLint("NotifyDataSetChanged")
    fun setArtList(lists:List<DataModelItem>?){
        if (lists != null) {
            this.lists = lists.toMutableList()
        }
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: EmployeeListAdapterBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = EmployeeListAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = lists[position]
        Picasso.with(holder.binding.profileImage.context).load(list.profile_image).into(holder.binding.profileImage)
        holder.binding.name.text = list.name
        holder.binding.companyName.text = list.company?.name

        /*try {
            holder.binding.companyName.setText(list.company.name)
        }catch (e:Exception){
            Log.e("error",e.message?:"")
        }*/


        holder.binding.listCardView.setOnClickListener {

            val bundle = Bundle()
            bundle.putString("image", list.profile_image)
            bundle.putString("name",list.name)
            bundle.putString("username",list.username)
            bundle.putString("email",list.email)
            bundle.putString("street",list.address?.street)
            bundle.putString("suite",list.address?.suite)
            bundle.putString("city",list.address?.city)
            bundle.putString("zipcode",list.address?.zipcode)
            bundle.putString("phone",list.phone)
            bundle.putString("website",list.website)
            bundle.putString("companyname",list.company?.name)
            bundle.putString("catchPhrase",list.company?.catchPhrase)
            bundle.putString("bs",list.company?.bs)

            val intent = Intent(holder.binding.profileImage.context, EmployeeDetail::class.java)
            intent.putExtras(bundle)
            holder.binding.profileImage.context.startActivity(intent)


//            val bundle = Bundle()
//            bundle.putString("view",list.views)
//            bundle.putInt("id",list.id)
//
//            val intent = Intent(holder.binding.image.context,DetailActivity::class.java)
//            intent.putExtras(bundle)
//            holder.binding.image.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return lists.size
    }
}