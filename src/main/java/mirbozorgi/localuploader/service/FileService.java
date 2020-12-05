package mirbozorgi.localuploader.service;

import java.io.FileNotFoundException;
import mirbozorgi.localuploader.entity.File;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

  File save( MultipartFile multipartFile) throws FileNotFoundException;

  File edit(long id, MultipartFile multipartFile) throws FileNotFoundException;

  File get(long id);


}
