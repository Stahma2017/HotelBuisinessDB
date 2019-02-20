package com.example.hotelbuisinessdb.department

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hotelbuisinessdb.R
import com.example.hotelbuisinessdb.entity.Department
import kotlinx.android.synthetic.main.item_department.view.*

class DepartmentAdapter : RecyclerView.Adapter<DepartmentAdapter.DepartmentViewHolder>(){

    private var list = mutableListOf<Department>()
    var onClickListener: (Department) -> Unit = {}

    fun setList(newList: List<Department>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepartmentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_department, parent, false)
        return DepartmentViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: DepartmentViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class DepartmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(model: Department){
            with(itemView){
                departmentId.text = model.id.toString()
                name.text = model.name
                hotelId.text = model.hotelId.toString()
                itemContainer.setOnClickListener{
                    onClickListener.invoke(model)
                }
            }
        }
    }
}