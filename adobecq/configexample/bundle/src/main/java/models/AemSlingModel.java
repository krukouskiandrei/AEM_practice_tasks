package models;

import api.MyConfigurationService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import javax.inject.Inject;

@Model(adaptables = Resource.class)
public class AemSlingModel {

    @Inject
    private String aemTitle;

    @Self
    Resource resource;

    @OSGiService
    MyConfigurationService myConfigurationService;

    public String getAemTitle() {
        return this.aemTitle;
    }

    public String getMyConfigurationServiceField() {
        return myConfigurationService.getMySingleField();
    }


}
