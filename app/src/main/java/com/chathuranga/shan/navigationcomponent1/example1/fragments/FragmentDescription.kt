package com.chathuranga.shan.navigationcomponent1.example1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.chathuranga.shan.navigationcomponent1.R
import com.chathuranga.shan.navigationcomponent1.example1.ActivityFunctionTrigger
import com.chathuranga.shan.navigationcomponent1.example1.MenuItemClickListener

class FragmentDescription : Fragment(), MenuItemClickListener {

    private val activityFunctionTrigger by lazy { ActivityFunctionTrigger.INSTANCE }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_description, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initialization(view)
    }

    private fun initialization(view: View){
        activity?.invalidateOptionsMenu()
    }

    override fun onClickFavoriteMenuItem(markedFavorite: Boolean) {

        if(markedFavorite){
            Toast.makeText(context,"Marked favorite", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context,"Marked non favorite", Toast.LENGTH_SHORT).show()
        }

        activityFunctionTrigger.changeFavoriteStatus(markedFavorite)

    }
}
