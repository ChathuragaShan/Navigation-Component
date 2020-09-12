package com.chathuranga.shan.navigationcomponent1.example2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.chathuranga.shan.navigationcomponent1.R
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {

    private lateinit var navigationController: NavController

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initialization(view)
        onDetailViewClickListener()
    }

    private fun initialization(view: View){
        navigationController = Navigation.findNavController(view)
    }

    private fun onDetailViewClickListener(){
        detailViewButton.setOnClickListener {
            val example2Activity = activity as Example2Activity
            example2Activity.animateToolBar()
            navigationController.navigate(R.id.to_detail_view)
        }
    }

}