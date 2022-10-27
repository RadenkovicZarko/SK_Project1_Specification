import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FileMetadata {
  private long size;
  private String date;
  private String extensions;
  private String name;
  //TODO - add more metadata


  public FileMetadata(long size, String date, String extensions, String name) {
    this.size = size;
    this.date = date;
    this.extensions = extensions;
    this.name = name;
  }
}
