package mirbozorgi.localuploader;

import javax.annotation.PostConstruct;
import mirbozorgi.localuploader.constants.Constants;
import mirbozorgi.localuploader.constants.ConstantsBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LocalUploaderApplication {

  public static void main(String[] args) {
    SpringApplication.run(LocalUploaderApplication.class, args);
  }

  @Bean
  public ConstantsBean constantBean() {
    return new ConstantsBean();

  }

  @PostConstruct
  public void initiateLocalUploaderApplication() {

    new Constants(constantBean());
  }

}
