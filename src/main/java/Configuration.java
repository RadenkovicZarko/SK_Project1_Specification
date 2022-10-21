import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class Configuration {
  private int size; // bytes
  private int numberOfFiles;
  private List<String> allowedExtensions;

  // Default configuration
  public Configuration() {
    this.allowedExtensions = new ArrayList<>();
    this.size = 1000;
    this.numberOfFiles = 10;
    //TODO - add configuration file (textual file)
  }
}
