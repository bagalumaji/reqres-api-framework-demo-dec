package com.bagal.configs;

import com.bagal.constants.ReqResConstants;
import com.bagal.exceptions.PropertyKeyNotFoundException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class PropertyConfig {
    private PropertyConfig(){}
    private static final Map<String,String> PROPERTY_MAP  = new HashMap<>();
    static {
        try(FileInputStream fileInputStream = new FileInputStream(ReqResConstants.getAPPLICATION_PROPERTY_FILE_LOCATION())){
            Properties properties = new Properties();
            properties.load(fileInputStream);
            properties.forEach((key, value) -> PROPERTY_MAP.put(String.valueOf(key),String.valueOf(value)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getValue(String key){
        String value = PROPERTY_MAP.get(key);
        if(value!=null)
            return value;
        else
            throw new PropertyKeyNotFoundException(key+" is not found");
    }
}
