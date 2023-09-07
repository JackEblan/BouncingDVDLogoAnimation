package com.android.bouncingdvd

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.Random
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRandom(): Random = Random()

    @Provides
    @Singleton
    fun provideImageUtil(@ApplicationContext context: Context): ImageUtil = ImageUtil(context)

    @Provides
    @Singleton
    fun provideResourceUtil(): ResourceUtil = ResourceUtil()
}