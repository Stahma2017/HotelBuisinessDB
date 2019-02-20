package com.example.hotelbuisinessdb.client

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hotelbuisinessdb.R
import com.example.hotelbuisinessdb.entity.Client
import com.example.hotelbuisinessdb.entity.Hotel
import kotlinx.android.synthetic.main.item_client.view.*


class ClientAdapter : RecyclerView.Adapter<ClientAdapter.ClientViewHolder>(){

    private var list = mutableListOf<Client>()
    var onClickListener: (Client) -> Unit = {}

    fun setList(newList: List<Client>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.item_client, parent, false)
        return ClientViewHolder(view)
    }

    override fun getItemCount()= list.size

    override fun onBindViewHolder(holder: ClientAdapter.ClientViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class ClientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(model : Client){
            with(itemView){
                idClient.text = model.id.toString()
                fName.text = model.name
                sName.text = model.secondName
                passport.text = model.passportNumber.toString()
                phone.text = model.phone.toString()
                itemContainer.setOnClickListener{
                    onClickListener.invoke(model)
                }
            }

        }
    }
}