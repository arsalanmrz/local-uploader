package mirbozorgi.localuploader.repositories.imp;

import javax.transaction.Transactional;
import mirbozorgi.localuploader.entity.File;
import mirbozorgi.localuploader.repositories.FileRepository;
import org.springframework.stereotype.Repository;

@Repository
public class FileRepositoryImp extends CustomRepository implements FileRepository {

  @Transactional
  @Override
  public File save(File file) {
    return save(File.class, file);
  }


  @Override
  public File findById(long id) {
    return findById(File.class, id);
  }
}
