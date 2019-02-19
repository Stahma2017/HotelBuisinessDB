package com.example.hotelbuisinessdb.position

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hotelbuisinessdb.R
import com.example.hotelbuisinessdb.entity.Position
import kotlinx.android.synthetic.main.item_position.view.*

class PositionAdapter : RecyclerView.Adapter<PositionAdapter.PositionViewHolder>(){
    private var list = mutableListOf<Position>()

    fun setList(newList: List<Position>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PositionAdapter.PositionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_position, parent, false)
        return PositionViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: PositionAdapter.PositionViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class PositionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(model: Position){
            with(itemView) {
                positionId.text = model.id.toString()
                departmentId.text = model.departmentId.toString()
                name.text = model.name
            }
        }
    }
}