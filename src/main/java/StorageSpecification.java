import java.io.File;
import java.util.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public abstract class StorageSpecification {

  private final Configuration configuration=new Configuration();
  private String rootFolderPath="";
  private int searchAttributes=SearchAttributes.wholePath;

  abstract void createRootFolder();

  void setConfigurationSizeOfStorage(int size)
  {
    configuration.setSize(size);
  }
  void setConfigurationExtensions(List<String> extensions)
  {
    configuration.setAllowedExtensions(extensions);
  }
  void setConfigurationNumberOfFilesInFolder(Map<String,Integer> map)
  {
    configuration.setNumberOfFilesInFolder(map);
  }
  abstract boolean setRootFolderPathInitialization(String path); // Da li je path root-a dobar
  abstract boolean createFolderOnSpecifiedPath(String path,String name);
  abstract boolean putFilesOnSpecifiedPath(List<String> listFiles, String path); //Proslede se putanje od fajlova i onda se u implementaciji proveravaju i traze ti fajlovi
  abstract void deleteFileOrDirectory(String path);
  abstract boolean moveFileFromDirectoryToAnother(String filePath,String pathTo); //Putanja fajla i putanja do drugog foldera u koji treba da se sacuva
  abstract boolean downloadFileOrDirectory(String pathFrom,String pathTo);
  abstract void renameFileOrDirectory(String path,String nameAfter);

  abstract Map<String,FileMetadata> filesFromDirectory(String path);
  abstract Map<String,FileMetadata> filesFromChildrenDirectory(String path);
  abstract Map<String,FileMetadata> allFilesFromDirectoryAndSubdirectory(String path);

  abstract Map<String,FileMetadata> filesFromDirectoryExt(String path, List<String> extensions);
  abstract Map<String,FileMetadata> filesFromChildrenDirectoryExt(String path,List<String> extensions);
  abstract Map<String,FileMetadata> allFilesFromDirectoryAndSubdirectoryExt(String path,List<String> extensions);

  abstract Map<String,FileMetadata> filesFromDirectorySubstring(String path,String substring);
  abstract Map<String,FileMetadata> filesFromChildrenDirectorySubstring(String path,String substring);
  abstract Map<String,FileMetadata> filesFromDirectoryAndSubdirectorySubstring(String path,String substring);

  abstract String doesDirectoryContainFiles(String path,List<String> namesOfFiles); // Vraca null ukoliko nije dobar path, vraca "Ne postoji takvi fajlovi u ovom folderu", vraca "Postoje fajlovi: test.txt image.jpg"
  abstract String folderNameByFileName(String fileName);

  abstract Map<String,FileMetadata> returnCreatedFilesInDateInterval(String pathToDirectory, Date fromDate, Date toDate);
  abstract Map<String,FileMetadata> returnModifiedFilesInDateInterval(String pathToDirectory, Date fromDate, Date toDate);

  public Map<String, FileMetadata> sortFilesByName(Map<String, FileMetadata> hashMap, boolean desc) {
    List<Map.Entry<String, FileMetadata>> arrayList = new ArrayList<>(hashMap.entrySet());
    arrayList.sort((o1, o2) -> {
      FileMetadata fm1 = o1.getValue();
      FileMetadata fm2 = o2.getValue();
      if (desc) {
        return fm1.getName().compareTo(fm2.getName());
      } else {
        return fm2.getName().compareTo(fm1.getName());
      }
    });
    Map<String, FileMetadata> sortedMap = new LinkedHashMap<>();
    for(Map.Entry<String, FileMetadata> entry : arrayList) {
      sortedMap.put(entry.getKey(), entry.getValue());
    }
    return sortedMap;
  }

  public Map<String, FileMetadata> sortFilesByCreatedDate(Map<String, FileMetadata> hashMap, boolean desc) {
    List<Map.Entry<String, FileMetadata>> arrayList = new ArrayList<>(hashMap.entrySet());
    arrayList.sort((o1, o2) -> {
      FileMetadata fm1 = o1.getValue();
      FileMetadata fm2 = o2.getValue();
      if (desc) {
        return fm2.getCreatedDate().compareTo(fm1.getCreatedDate());
      } else {
        return fm1.getCreatedDate().compareTo(fm2.getCreatedDate());
      }
    });
    Map<String, FileMetadata> sortedMap = new LinkedHashMap<>();
    for(Map.Entry<String, FileMetadata> entry : arrayList) {
      sortedMap.put(entry.getKey(), entry.getValue());
    }
    return sortedMap;
  }

  public Map<String, FileMetadata> sortFilesBySize(Map<String, FileMetadata> hashMap, boolean desc) {
    List<Map.Entry<String, FileMetadata>> arrayList = new ArrayList<>(hashMap.entrySet());
    arrayList.sort((o1, o2) -> {
      FileMetadata fm1 = o1.getValue();
      FileMetadata fm2 = o2.getValue();
      if (desc) {
        return Long.compare(fm1.getSize(), fm2.getSize());
      } else {
        return Long.compare(fm2.getSize(), fm1.getSize());
      }
    });
    Map<String, FileMetadata> sortedMap = new LinkedHashMap<>();
    for(Map.Entry<String, FileMetadata> entry : arrayList) {
      sortedMap.put(entry.getKey(), entry.getValue());
    }
    return sortedMap;
  }

  public Configuration getConfiguration() {
    return configuration;
  }

  public String getRootFolderPath() {
    return rootFolderPath;
  }

  public void setRootFolderPath(String rootFolderPath) {
    this.rootFolderPath = rootFolderPath;
  }

  public void setWholePathAttribute() {
    this.searchAttributes |= (SearchAttributes.wholePath);
  }

  public void removeWholePathAttribute() {
    this.searchAttributes &= ~(SearchAttributes.wholePath);
  }

  public void setFileSizeAttribute() {
    this.searchAttributes |= (SearchAttributes.fileSize);
  }

  public void removeFileSizeAttribute() {
    this.searchAttributes &= ~(SearchAttributes.fileSize);
  }

  public void setDateAttribute() {
    this.searchAttributes |= (SearchAttributes.createdDate);
  }

  public void removeDateAttribute() {
    this.searchAttributes &= ~(SearchAttributes.createdDate);
  }

  public void setModificationDateAttribute() {
    this.searchAttributes |= (SearchAttributes.modificationDate);
  }

  public void removeModificationDateAttribute() {
    this.searchAttributes &= ~(SearchAttributes.modificationDate);
  }

  public String returnStringForOutput(Map<String, FileMetadata> map)
  {
      StringBuilder stringBuilder=new StringBuilder();
      for(Map.Entry<String , FileMetadata> e : map.entrySet())
      {
        stringBuilder.append(e.getKey()).append(" ");
        if((this.searchAttributes & SearchAttributes.wholePath) != 0)
        {
          stringBuilder.append(e.getValue().getAbsolutePath()).append(" ");
        }
        if((this.searchAttributes & SearchAttributes.fileSize) != 0)
        {
          stringBuilder.append(e.getValue().getSize()).append(" ");
        }
        if((this.searchAttributes & SearchAttributes.createdDate) != 0)
        {
          stringBuilder.append(e.getValue().getCreatedDate()).append(" ");
        }
        if((this.searchAttributes & SearchAttributes.modificationDate) != 0)
        {
          stringBuilder.append(e.getValue().getModifiedDate()).append(" ");
        }
        stringBuilder.append("\n");
      }
      return stringBuilder.toString();
  }
}
