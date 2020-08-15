package com.tmw.foodparadise.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tmw.foodparadise.R
import com.tmw.foodparadise.model.Option
import kotlinx.android.synthetic.main.main_page.view.*

class MainAdapter1(var mainList1: ArrayList<Option>) :
    RecyclerView.Adapter<MainAdapter1.MainViewHolder>() {
    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindMain1(option: Option) {
            itemView.txtOption.text=option.txtOption
            itemView.imgOption.setImageResource(option.imgOption)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.main_page, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mainList1.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bindMain1(mainList1[position])
    }
}