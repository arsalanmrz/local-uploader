package mirbozorgi.localuploader.controller;


import java.io.FileNotFoundException;
import mirbozorgi.localuploader.domain.FileEditRequest;
import mirbozorgi.localuploader.service.FileService;
import mirbozorgi.localuploader.service.SerializerService;
import mirbozorgi.localuploader.util.helper.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {

  @Autowired
  private FileService fileService;
  @Autowired
  private SerializerService serializerService;


  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public ResponseEntity add(
      @RequestPart(value = "file") MultipartFile file
  ) throws FileNotFoundException {
    return ResponseHelper.response(
        fileService.save(file));

  }


  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public ResponseEntity addList(
      @RequestPart(value = "data") String data,
      @RequestPart(value = "file") MultipartFile multipartFile
  ) throws FileNotFoundException {
    FileEditRequest fileEditRequest = serializerService.toObj(data, FileEditRequest.class);
    return ResponseHelper.response(
        fileService.edit(fileEditRequest.getId(), multipartFile));
  }


  @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
  public ResponseEntity get(
      @PathVariable("id") long id) {
    return ResponseHelper.response(
        fileService.get(id));

  }


}
