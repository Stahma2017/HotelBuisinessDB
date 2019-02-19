package com.example.hotelbuisinessdb.employee

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hotelbuisinessdb.R
import com.example.hotelbuisinessdb.entity.Employee
import kotlinx.android.synthetic.main.item_employee.view.*

class EmployeeAdapter : RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>(){

    private var list = mutableListOf<Employee>()

    fun setList(newList: List<Employee>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_employee, parent, false)
        return EmployeeViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: EmployeeAdapter.EmployeeViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class EmployeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(model: Employee){
            with(itemView){
                idEmployee.text = model.id.toString()
                idPosition.text = model.positionId.toString()
                fName.text = model.firstName
                sName.text = model.secondName
            }
        }

    }
}

