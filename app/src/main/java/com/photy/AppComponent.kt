package com.photy

import com.photy.data.api.ApiModule
import dagger.Component
import javax.inject.Singleton

@Singleton @Component(modules = arrayOf(ApiModule::class))
interface AppComponent {
}