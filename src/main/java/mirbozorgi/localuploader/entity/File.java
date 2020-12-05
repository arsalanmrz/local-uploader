package mirbozorgi.localuploader.entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "file")
public class File {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


  @Column(name = "file_url")
  private String fileUrl;


  public File(String fileUrl) {
    this.fileUrl = fileUrl;
  }


  public File() {
  }

  @Column(name = "created_date", updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdDate;

  @Column(name = "updated_Date")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedDate;

  @PrePersist
  public void prePersist() {
    createdDate = new Date();
  }

  @PreUpdate
  public void preUpdate() {
    updatedDate = new Date();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFileUrl() {
    return fileUrl;
  }

  public void setFileUrl(String fileUrl) {
    this.fileUrl = fileUrl;
  }
}
