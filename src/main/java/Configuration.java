import lombok.Getter;
import lombok.Setter;

import java.util.*;


@Getter
@Setter
public class Configuration {
  private int size; // bytes
  private int numberOfFiles;
  private List<String> allowedExtensions;
  private boolean isDefault;
  private Map<String,Integer> numberOfFilesInFolder; // String je relativna putanja, Integer je br fajlova.

  // Default configuration
  public Configuration() {
    this.allowedExtensions = new ArrayList<>();
    this.size = 10000;
    this.numberOfFiles = 10;
    this.numberOfFilesInFolder=new HashMap<>();
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
