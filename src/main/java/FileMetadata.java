import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FileMetadata {
  private long size;
  private Date date;
  private String extensions;
  private String name;
  //TODO - add more metadata


  public FileMetadata(long size, Date date, String extensions, String name) {
    this.size = size;
    this.date = date;
    this.extensions = extensions;
    this.name = name;
  }
}
