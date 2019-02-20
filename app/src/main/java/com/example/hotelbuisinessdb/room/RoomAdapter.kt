package com.example.hotelbuisinessdb.room

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hotelbuisinessdb.R

import com.example.hotelbuisinessdb.entity.Room
import kotlinx.android.synthetic.main.item_room.view.*

class RoomAdapter : RecyclerView.Adapter<RoomAdapter.RoomViewHolder>(){

    private var list = mutableListOf<Room>()
    var onClickListener: (Room) -> Unit = {}

    fun setList(newList: List<Room>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomAdapter.RoomViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_room, parent, false)
        return RoomViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: RoomAdapter.RoomViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class RoomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(model : Room){
            with(itemView){
                idRoom.text = model.id.toString()
                doorNumber.text = model.doorNumber.toString()
                description.text = model.description
                categoryID.text = model.categoryId.toString()
                itemContainer.setOnClickListener{
                    onClickListener.invoke(model)
                }
            }
        }
    }
}