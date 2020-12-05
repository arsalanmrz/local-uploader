package mirbozorgi.localuploader.service;

import java.io.FileNotFoundException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface UploaderService {

  String saveFile(MultipartFile file) throws FileNotFoundException;

  List<String> saveFiles(List<MultipartFile> files) throws FileNotFoundException;

}
