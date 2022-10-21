import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FileMetadata {
  private int size;

  //TODO - add more metadata
  public FileMetadata(int size) {
    this.size = size;
  }
}
