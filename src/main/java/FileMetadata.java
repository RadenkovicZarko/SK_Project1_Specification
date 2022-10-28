import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class FileMetadata {
  private long size;
  private Date createdDate;
  private Date modifiedDate;
  private String extensions;
  private String name;
  //TODO - add more metadata


  public FileMetadata(long size, Date createdDate, Date modifiedDate, String extensions, String name) {
    this.size = size;
    this.createdDate = createdDate;
    this.modifiedDate = modifiedDate;
    this.extensions = extensions;
    this.name = name;
  }
}
