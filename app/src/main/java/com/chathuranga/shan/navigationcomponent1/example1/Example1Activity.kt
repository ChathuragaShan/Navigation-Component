package com.chathuranga.shan.navigationcomponent1.example1

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.chathuranga.shan.navigationcomponent1.R
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_example2.*

class Example1Activity : AppCompatActivity() {

    private lateinit var navigationController: NavController

    private var markedAsFavorite = false

    private val activityFunctionTrigger by lazy { ActivityFunctionTrigger.INSTANCE }
    private val navHostFragment by lazy { supportFragmentManager.findFragmentById(R.id.hostFragment) }

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example2)

        initialization()
        updateToolBarIcon()
    }

    private fun initialization() {

        navigationController = Navigation.findNavController(this, R.id.hostFragment)
        setSupportActionBar(toolbar)
        NavigationUI.setupActionBarWithNavController(this, navigationController)

    }

    private fun updateToolBarIcon(){

        val favoriteStatusChangeObserver = activityFunctionTrigger
            .favoriteStatusChangePublishSubject
            .subscribe {
                markedAsFavorite = it
                invalidateOptionsMenu()
            }

        compositeDisposable.add(favoriteStatusChangeObserver)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        return when (navigationController.currentDestination?.id) {

            R.id.fragmentDescription -> {

                menuInflater.inflate(R.menu.favorite_menu, menu)

                val actionMarkFavorite = menu.findItem(R.id.mark_favorite)
                val actionMarkNonFavorite = menu.findItem(R.id.mark_not_favorite)

                if(markedAsFavorite){
                    actionMarkFavorite.isVisible = true
                    actionMarkNonFavorite.isVisible = false
                }else{
                    actionMarkFavorite.isVisible = false
                    actionMarkNonFavorite.isVisible = true
                }

                true
            }

            else -> true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val menuItemClickListener = navHostFragment?.childFragmentManager
            ?.fragments?.get(0) as MenuItemClickListener

        return when(item.itemId){
            R.id.mark_favorite ->{
                menuItemClickListener.onClickFavoriteMenuItem(false)
                true
            }
            R.id.mark_not_favorite ->{
                menuItemClickListener.onClickFavoriteMenuItem(true)
                true
            }
            else ->{
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {

        when (navigationController.currentDestination?.id) {
            R.id.fragmentDescription->{
                invalidateOptionsMenu()
                navigationController.navigateUp()
            }
            else ->{
                navigationController.navigateUp()
            }
        }

        return true
    }

    override fun onBackPressed() {
        onSupportNavigateUp()
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }
}
