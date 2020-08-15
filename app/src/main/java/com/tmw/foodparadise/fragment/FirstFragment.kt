package com.tmw.foodparadise.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tmw.foodparadise.R
import com.tmw.foodparadise.adapter.RandomAdapter
import com.tmw.foodparadise.model.Meal
import com.tmw.foodparadise.model.Random
import com.tmw.foodparadise.viewmodel.RandomViewModel
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment(), RandomAdapter.clickListener {

    lateinit var randomViweModel: RandomViewModel
    lateinit var randomAdapter: RandomAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        randomViweModel = ViewModelProvider(this).get(RandomViewModel::class.java)

        randomViweModel.loadRandom()

        randomAdapter = RandomAdapter()

        randomAdapter.setOnClickListener(this)

        recyclerview3.layoutManager = LinearLayoutManager(context)
        recyclerview3.adapter = randomAdapter

        observeViewModel()
    }

    fun observeViewModel() {
        randomViweModel.getResultRandom().observe(
            viewLifecycleOwner, Observer<Random> { Random ->
                randomAdapter.updateMeal(Random.meals)
            }
        )
    }

    override fun onClick(meal: Meal) {
        findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
    }
}
