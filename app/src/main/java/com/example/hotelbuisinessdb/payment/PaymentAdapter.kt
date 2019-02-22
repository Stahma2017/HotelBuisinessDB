package com.example.hotelbuisinessdb.payment

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hotelbuisinessdb.R
import com.example.hotelbuisinessdb.entity.Payment
import kotlinx.android.synthetic.main.item_payment.view.*

class PaymentAdapter : RecyclerView.Adapter<PaymentAdapter.PaymentViewHolder>(){

    private var list = mutableListOf<Payment>()
    var onClickListener: (Payment) -> Unit = {}


    fun setList(newList: List<Payment>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_payment, parent, false)
        return PaymentViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: PaymentAdapter.PaymentViewHolder, position: Int) {
        holder.bind(list[position])
    }


    inner class PaymentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(model: Payment){
            with(itemView){
                paymentId.text = model.id.toString()
                card.text = model.creditType
                cost.text = model.cost.toString()
                itemContainer.setOnClickListener{
                    onClickListener.invoke(model)
                }
            }

        }
    }
}