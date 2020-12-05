package mirbozorgi.localuploader.repositories;

import mirbozorgi.localuploader.entity.File;


public interface FileRepository {


  File save(File file);

  File findById(long id);

}
