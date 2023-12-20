package com.bagal.constants;

import lombok.Getter;

public final class ReqResConstants {
    private ReqResConstants(){}

    private static final String BASE_PATH=System.getProperty("user.dir");
    private @Getter static final String APPLICATION_PROPERTY_FILE_LOCATION = BASE_PATH+"/src/test/resources/configs/application.properties";
}
