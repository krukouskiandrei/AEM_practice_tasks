package com.adobe.cq.sling.impl;

import api.MyConfigurationService;
import org.apache.felix.scr.annotations.*;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@Service
@Component(immediate = true, metatype = true, label = "My Example Configuration Service")
public class MyConfigurationServiceImpl implements MyConfigurationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyConfigurationServiceImpl.class);
    @Property(unbounded = PropertyUnbounded.ARRAY,  label = "My Multi String", cardinality = 50, description="Example for Multi field config")
    private static final String MULTI_FIELD = "mymultifield";
    @Property(unbounded = PropertyUnbounded.DEFAULT, label = "My Single String", description="Example for Simple text field config")
    private static final String SIMPLE_FIELD = "mysinglefield";
    private String[] multiString;
    private String singleString;

    public String getMySingleField() {
        return this.singleString;
    }

    public String[] getMyMultiField() {
        return this.multiString;
    }

    @Activate
    protected void activate(Map<String, Object> properties)
    {
        LOGGER.info("[*** AEM ConfigurationService]: activating configuration service");
        readProperties(properties);
    }

    protected void readProperties(Map<String, Object> properties)
    {
        LOGGER.info(properties.toString());
        this.multiString = PropertiesUtil.toStringArray(properties.get(MULTI_FIELD));
        LOGGER.info("Mutli String Size: " + this.multiString.length);
        this.singleString = PropertiesUtil.toString(properties.get(SIMPLE_FIELD), "default");
        LOGGER.info("Simple String: " + this.singleString);
    }

}
