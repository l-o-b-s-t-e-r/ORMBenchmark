package com.lobster.ormbenchmark.di

import android.os.Build
import com.lobster.ormbenchmark.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.CipherSuite
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.TlsVersion
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Lobster on 30.03.18.
 */

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val httpClient: OkHttpClient
        if (Build.VERSION.SDK_INT == 24) {
            val spec = ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                    .tlsVersions(TlsVersion.TLS_1_2)
                    .cipherSuites(CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256)
                    .build()

            httpClient = OkHttpClient.Builder()
                    .connectTimeout(AppModule.CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                    .readTimeout(AppModule.READ_TIMEOUT, TimeUnit.MILLISECONDS)
                    .writeTimeout(AppModule.WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
                    .connectionSpecs(listOf(spec))
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()
        } else {
            httpClient = OkHttpClient.Builder()
                    .connectTimeout(AppModule.CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                    .readTimeout(AppModule.READ_TIMEOUT, TimeUnit.MILLISECONDS)
                    .writeTimeout(AppModule.WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()
        }

        return httpClient
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.HOST)
                .client(httpClient)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

}