package com.example.hotelbuisinessdb.order

import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hotelbuisinessdb.R
import com.example.hotelbuisinessdb.entity.Order
import kotlinx.android.synthetic.main.item_order.view.*

class OrderAdapter : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>(){

    private var list = mutableListOf<Order>()

    fun setList(newList: List<Order>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_order, parent, false)
        return OrderViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(model: Order){
            with(itemView){
                idOrder.text = model.id.toString()
                daySpan.text = model.daySnap.toString()
                startDay.text = model.startDate
                clientId.text = model.clientId.toString()
                roomId.text = model.roomId.toString()
                peymentId.text = model.paymentId.toString()
            }
        }
    }
}