package mirbozorgi.localuploader.constants;


public class Constants {

  public static String ROOT_STORAGE;
  public static String ROOT_SERVER_URL;
  public static String ROOT_NGINX_URL;
  public static String IMAGE_DIRECTORY;
  public static String DEFAULT_IMAGE;
  public static String ROOT_SITE;
  public static String[] ALLOWED_FORMATS;
  public static String ROOT_USER_DIRECTORY;


  public Constants(ConstantsBean bean) {
    IMAGE_DIRECTORY = bean.getImageDirectory();
    DEFAULT_IMAGE = bean.getDefaultImage();
    ROOT_NGINX_URL = bean.getRootNginxUrl();
    ROOT_STORAGE = bean.getRootStorage();
    ROOT_SERVER_URL = bean.getRootServerUrl();
    ROOT_SITE = bean.getRootSite();
    ALLOWED_FORMATS = bean.getAllowedFormats();
    ROOT_USER_DIRECTORY = bean.getRootUserDirectory();
  }

}

