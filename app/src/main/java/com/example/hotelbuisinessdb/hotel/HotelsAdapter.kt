package com.example.hotelbuisinessdb.hotel

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hotelbuisinessdb.R
import com.example.hotelbuisinessdb.entity.Hotel
import kotlinx.android.synthetic.main.item_hotel.view.*

class HotelsAdapter : RecyclerView.Adapter<HotelsAdapter.HotelViewHolder>() {

    private var list = mutableListOf<Hotel>()

    fun setList(newList: List<Hotel>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hotel, parent, false)
        return HotelViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: HotelsAdapter.HotelViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class HotelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: Hotel) {
            with(itemView) {
                idHotel.text = model.id.toString()
                addressHotel.text = model.address
                phoneNumber.text = model.phone.toString()
            }
        }
    }


}
