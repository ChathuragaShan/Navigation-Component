package com.chathuranga.shan.navigationcomponent1.example1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.chathuranga.shan.navigationcomponent1.R
import com.chathuranga.shan.navigationcomponent1.example1.ActivityFunctionTrigger
import com.chathuranga.shan.navigationcomponent1.example1.MenuItemClickListener
import kotlinx.android.synthetic.main.fragment_summary.*

class FragmentSummary : Fragment(){

    private lateinit var navigationController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_summary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initialization(view)
        onClickSummaryCardView()
    }

    private fun initialization(view: View){

        navigationController = Navigation.findNavController(view)
    }

    private fun onClickSummaryCardView(){

        summaryCardView.setOnClickListener {
            navigationController.navigate(R.id.to_description)
        }
    }

}
