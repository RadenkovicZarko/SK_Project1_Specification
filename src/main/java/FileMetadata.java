import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FileMetadata {
  private int size;
  private String date;
  private String type;
  private String extensions;
  private String name;
  //TODO - add more metadata


  public FileMetadata(int size, String date, String type, String extensions, String name) {
    this.size = size;
    this.date = date;
    this.type = type;
    this.extensions = extensions;
    this.name = name;
  }
}
