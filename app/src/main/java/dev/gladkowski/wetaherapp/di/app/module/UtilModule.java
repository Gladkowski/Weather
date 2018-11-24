package dev.gladkowski.wetaherapp.di.app.module;


import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dev.gladkowski.wetaherapp.utils.rx.CompletableErrorHandler;
import dev.gladkowski.wetaherapp.utils.rx.ErrorProcessing;
import dev.gladkowski.wetaherapp.utils.rx.ErrorResourceProvider;
import dev.gladkowski.wetaherapp.utils.rx.ErrorResourceProviderImpl;
import dev.gladkowski.wetaherapp.utils.rx.RxUtils;
import dev.gladkowski.wetaherapp.utils.rx.SingleErrorHandler;


@Module
public interface UtilModule {

    @Provides
    @Singleton
    static ErrorProcessing provideErrorProcessing(ErrorResourceProvider errorResourceProvider) {
        return new ErrorProcessing(errorResourceProvider);
    }

    @Provides
    @Singleton
    static SingleErrorHandler provideSingleErrorHandler(ErrorProcessing errorProcessing) {
        return new SingleErrorHandler(errorProcessing);
    }

    @Provides
    @Singleton
    static CompletableErrorHandler provideCompletableErrorHandler(ErrorProcessing errorProcessing) {
        return new CompletableErrorHandler(errorProcessing);
    }

    @Provides
    @Singleton
    static RxUtils provideRxUtils() {
        return new RxUtils();
    }

    @Binds
    @Singleton
    ErrorResourceProvider provideErrorResourceProvider(ErrorResourceProviderImpl resourceProvider);

}
