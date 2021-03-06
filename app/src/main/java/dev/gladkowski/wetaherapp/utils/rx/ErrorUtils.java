package dev.gladkowski.wetaherapp.utils.rx;


import dev.gladkowski.wetaherapp.entity.app.domain.BaseException;
import dev.gladkowski.wetaherapp.entity.app.domain.ServiceCodeException;
import dev.gladkowski.wetaherapp.presentation.common.activity.BaseMvpView;
import ru.terrakok.cicerone.Router;

public class ErrorUtils {

    public void processErrors(Throwable throwable,
                              Router router,
                              ErrorResourceProvider errorResourceProvider,
                              BaseMvpView baseView) {
        if (router != null) {
            if (throwable instanceof BaseException) {
                BaseException baseException = (BaseException) throwable;

                if (baseException.getTag().equals(ServiceCodeException.TAG)) {
                    ServiceCodeException exception = (ServiceCodeException) throwable;
                    if (exception.getServiceCode() >= 500) {
                        router.showSystemMessage(errorResourceProvider.getInternalServerException());
                    }
                } else {
                    router.showSystemMessage(baseException.getMessage());
                }
            } else {
                router.showSystemMessage(errorResourceProvider.getGenericException());
            }
        }
    }
}
