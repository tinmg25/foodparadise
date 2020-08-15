package com.tmw.foodparadise.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tmw.foodparadise.R
import com.tmw.foodparadise.model.Meal
import kotlinx.android.synthetic.main.main_page.view.*
import kotlinx.android.synthetic.main.main_page_2.view.*
import kotlin.collections.ArrayList

class RandomAdapter(var meal: List<Meal> = ArrayList()) :
    RecyclerView.Adapter<RandomAdapter.RandomViewHolder>() {

    var mClickListener: clickListener? = null

    fun setOnClickListener(clickListener: clickListener) {
        this.mClickListener = clickListener
    }

    fun updateMeal(meal: List<Meal>) {
        this.meal = meal
        notifyDataSetChanged()
    }

    inner class RandomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        lateinit var meal: Meal
        private var view: View = itemView

        init {
            view.setOnClickListener(this)
        }

        fun bindRandom(meal: Meal) {
            this.meal = meal
            Picasso.get().load(meal.strMealThumb).placeholder(R.drawable.ic_launcher_background)
                .into(view.imgRandom)
            view.txtOption.text = meal.strMeal
        }

        override fun onClick(p0: View?) {
            mClickListener?.onClick(meal)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.main_page_2, parent, false)
        return RandomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return meal.size
    }

    override fun onBindViewHolder(holder: RandomViewHolder, position: Int) {
        holder.bindRandom(meal[position])
    }

    interface clickListener {
        fun onClick(meal: Meal)
    }
}