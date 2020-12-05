package mirbozorgi.localuploader.service.imp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import mirbozorgi.localuploader.constants.Constants;
import mirbozorgi.localuploader.service.UploaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploaderServiceImp implements UploaderService {

  private String fileName = "";
  private String[] allowedFormats = Constants.ALLOWED_FORMATS;
  private String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());

  private static final Logger logger = LoggerFactory.getLogger(UploaderServiceImp.class);


  @Override
  public String saveFile(MultipartFile file) throws FileNotFoundException {

    try {
      List<String> nameAndFormat = getNameAndFormat(
          Objects.requireNonNull(file.getOriginalFilename()).
              replace(" ", "-"));
      String name = nameAndFormat.get(0);

      String format = nameAndFormat.get(1);

      if (file.isEmpty()) {
        throw new FileNotFoundException(file.getName());
      }

      if (!Arrays.asList(allowedFormats).contains(nameAndFormat.get(1).toLowerCase())) {
        throw new IOException();
      }

      String directoryName = makeDirectory(
          Constants.ROOT_USER_DIRECTORY + Constants.ROOT_STORAGE + Constants.IMAGE_DIRECTORY)
          .getAbsolutePath();

      fileName = directoryName + "/" + timeStamp + "_" + name + "." + format;

      File convertedFile = new java.io.File(fileName);

      if (convertedFile.exists()) {
        convertedFile.mkdirs();
      }

      file.transferTo(convertedFile);
      byte[] bytes = file.getBytes();
      Path path = Paths.get(fileName);
      Files.write(path, bytes);

    } catch (IOException e) {
      logger.error(e.getMessage());

    }

    return fileName;

  }


  @Override
  public List<String> saveFiles(List<MultipartFile> files) throws FileNotFoundException {
    List<String> array = new ArrayList<>();
    for (MultipartFile file : files) {
      array.add(saveFile(file));
    }
    return array;
  }

//////////////////////////////////
///////////private methods/////////
/////////////////////////////////


  private List<String> getNameAndFormat(String fileName) {
    String[] array = fileName.split("\\.");
    String name = array[0];
    String format = array[array.length - 1];
    List<String> result = new ArrayList<>();
    result.add(name);
    result.add(format);
    return result;
  }


  private File makeDirectory(String path) {
    File dir = new File(path);
    if (!dir.exists()) {
      dir.mkdirs();

    }
    return dir;
  }


}
