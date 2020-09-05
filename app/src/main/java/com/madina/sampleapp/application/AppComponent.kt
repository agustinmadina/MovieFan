package com.madina.sampleapp.application


import com.madina.sampleapp.domain.repository.RepositoryModule
import com.madina.sampleapp.networking.NetworkingModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        NetworkingModule::class,
        RepositoryModule::class,
        BindingModule::class
    ]
)
interface AppComponent : AndroidInjector<SampleApp> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<SampleApp>()
}