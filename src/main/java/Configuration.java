import lombok.Getter;
import lombok.Setter;

import java.util.*;


@Getter
@Setter
public class Configuration {
  private int size; // bytes
  private List<String> allowedExtensions;
  private boolean isDefault;
  private Map<String,Integer> numberOfFilesInFolder; // String je relativna putanja, Integer je br fajlova.

  // Default configuration
  public Configuration() {
    this.allowedExtensions = new ArrayList<>();
    this.size = 10000;
    this.numberOfFilesInFolder=new HashMap<>();
  }

  @Override
  public String toString() {
    StringBuilder ans = new StringBuilder();
    ans.append(this.size).append("\n");
    for (String str1 : this.allowedExtensions) {
      ans.append(str1).append(" ");
    }
    for(Map.Entry<String,Integer> e:numberOfFilesInFolder.entrySet())
    {
      ans.append(e.getKey()).append(" ").append(e.getValue()).append("\n");
    }


    //20000
    //.exe .pdf .jpg .png
    //putanj1 5
    //putanj2 10


    return ans.toString();
  }
}
