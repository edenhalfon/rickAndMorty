package com.ehapps.core.di

import androidx.room.Room
import com.ehapps.cache.AppDatabase
import com.ehapps.cache.source.CharactersLocalSource
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val cacheModule = module {
    factory { get<AppDatabase>().charactersDao() }
    single { CharactersLocalSource(get()) }

    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("SOME_CIPHER_CODE".toCharArray())
        val factory = SupportFactory(passphrase)

        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java, "AppCache.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}