import lombok.Getter;
import lombok.Setter;

import java.util.*;


@Getter
@Setter
public class Configuration {
  private int size;
  private List<String> forbiddenExtensions;
  private boolean isDefault;
  private Map<String,Integer> numberOfFilesInFolder;

  // Default configuration
  public Configuration() {
    this.forbiddenExtensions = new ArrayList<>();
    this.size = 10000;
    this.numberOfFilesInFolder=new HashMap<>();
  }

  @Override
  public String toString() {
    StringBuilder ans = new StringBuilder();
    ans.append(this.size).append("\n");
    for (String str1 : this.forbiddenExtensions) {
      ans.append(str1).append(" ");
    }
    ans.append("\n");
    for(Map.Entry<String,Integer> e:numberOfFilesInFolder.entrySet())
    {
      ans.append(e.getKey()).append(" ").append(e.getValue()).append("\n");
    }

    return ans.toString();
  }
}
