package mirbozorgi.localuploader.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("constants")
public class ConstantsBean {

    @Value("${constants.image-directory}")
    private String imageDirectory;

    @Value("${constants.default-image}")
    private String defaultImage;

    @Value("${root-storage}")
    private String rootStorage;

    @Value("${root-server-url}")
    private String rootServerUrl;

    @Value("${root-nginx-url}")
    private String rootNginxUrl;

    @Value("${root-site}")
    private String rootSite;

    @Value("${file-allowed-formats}")
    private String [] allowedFormats;

    @Value("${root-user-directory}")
    private String rootUserDirectory;


    public String getImageDirectory() {
        return imageDirectory;
    }

    public String getDefaultImage() {
        return defaultImage;
    }

    public String getRootStorage() {
        return rootStorage;
    }

    public String getRootServerUrl() {
        return rootServerUrl;
    }

    public String getRootNginxUrl() {
        return rootNginxUrl;
    }

    public String getRootSite() {
        return rootSite;
    }

    public String[] getAllowedFormats() {
        return allowedFormats;
    }

    public String getRootUserDirectory() {
        return rootUserDirectory;
    }
}
