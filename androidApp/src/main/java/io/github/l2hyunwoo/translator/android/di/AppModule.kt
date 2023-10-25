package io.github.l2hyunwoo.translator.android.di

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.l2hyunwoo.translator.TranslateDatabase
import io.github.l2hyunwoo.translator.translate.data.history.SqlDelightHistoryDataSource
import io.github.l2hyunwoo.translator.translate.data.local.DatabaseDriverFactory
import io.github.l2hyunwoo.translator.translate.data.remote.HttpClientFactory
import io.github.l2hyunwoo.translator.translate.data.translate.KtorTranslateClient
import io.github.l2hyunwoo.translator.translate.domain.history.HistoryDataSource
import io.github.l2hyunwoo.translator.translate.domain.translate.Translate
import io.github.l2hyunwoo.translator.translate.domain.translate.TranslateClient
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient = HttpClientFactory().create()

    @Provides
    @Singleton
    fun provideTranslateClient(
        httpClient: HttpClient
    ): TranslateClient {
        return KtorTranslateClient(httpClient)
    }

    @Provides
    @Singleton
    fun provideDatabaseDriverFactory(
        @ApplicationContext context: Context
    ): SqlDriver {
        return DatabaseDriverFactory(context).create()
    }

    @Provides
    @Singleton
    fun provideHistoryDataSource(
        driver: SqlDriver
    ): HistoryDataSource {
        return SqlDelightHistoryDataSource(TranslateDatabase(driver))
    }

    @Provides
    @Singleton
    fun provideTranslateUseCase(
        client: TranslateClient,
        dataSource: HistoryDataSource
    ): Translate {
        return Translate(client, dataSource)
    }
}
