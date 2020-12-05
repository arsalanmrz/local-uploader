package mirbozorgi.localuploader.service.imp;

import java.io.FileNotFoundException;
import mirbozorgi.localuploader.entity.File;
import mirbozorgi.localuploader.repositories.FileRepository;
import mirbozorgi.localuploader.service.FileService;
import mirbozorgi.localuploader.service.UploaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileServiceImp implements FileService {

  @Autowired
  private UploaderService uploaderService;
  @Autowired
  private FileRepository fileRepository;

  @Override
  public File save(MultipartFile multipartFile) throws FileNotFoundException {
    String fileUrl = uploaderService.saveFile(multipartFile);
    return fileRepository.save(new File(fileUrl));
  }

  @Override
  public File edit(long id, MultipartFile multipartFile) throws FileNotFoundException {
    File fileFounded = fileRepository.findById(id);

    if (multipartFile != null) {
      String fileUrl = uploaderService.saveFile(multipartFile);
      fileFounded.setFileUrl(fileUrl);
    }

    if (multipartFile == null && fileFounded.getFileUrl() != null) {
      fileFounded.setFileUrl(fileFounded.getFileUrl());
    }

    return fileRepository.save(fileFounded);
  }

  @Override
  public File get(long id) {
    return fileRepository.findById(id);
  }
}
