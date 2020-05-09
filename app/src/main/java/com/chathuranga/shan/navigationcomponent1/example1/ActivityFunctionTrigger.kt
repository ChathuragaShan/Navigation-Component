package com.chathuranga.shan.navigationcomponent1.example1

import io.reactivex.subjects.PublishSubject

class ActivityFunctionTrigger private constructor() {

    val favoriteStatusChangePublishSubject: PublishSubject<Boolean>
            = PublishSubject.create()

    private object HOLDER {
        val INSTANCE = ActivityFunctionTrigger()
    }

    companion object {
        val INSTANCE: ActivityFunctionTrigger by lazy { HOLDER.INSTANCE }
    }

    fun changeFavoriteStatus(markedFavorite: Boolean){
        favoriteStatusChangePublishSubject.onNext(markedFavorite)
    }
}