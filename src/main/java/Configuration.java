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
  private boolean isDefault; // is configuration default

  // Default configuration
  public Configuration() {
    this.allowedExtensions = new ArrayList<>();
    this.size = 10000;
    this.numberOfFiles = 10;
  }

  @Override
  public String toString() {
    StringBuilder ans = new StringBuilder();
    ans.append(this.numberOfFiles).append("\n").append(this.size).append("\n");
    for (String str1 : this.allowedExtensions) {
      ans.append(str1).append(" ");
    }
    return ans.toString();
  }
}
