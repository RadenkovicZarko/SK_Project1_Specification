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
  void setConfigurationNumberOfFiles(int numberOfFiles)
  {
    configuration.setNumberOfFiles(numberOfFiles);
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

  abstract Map<String,FileMetadata> sortFilesByName(Map<String,FileMetadata> mapa, boolean desc);
  abstract Map<String,FileMetadata> sortFilesByCreatedDate(Map<String,FileMetadata> mapa, boolean desc);
  abstract Map<String,FileMetadata> sortFilesBySize(Map<String,FileMetadata> mapa, boolean desc);

  abstract Map<String,FileMetadata> returnCreatedFilesInDateInterval(String pathToDirectory, Date fromDate, Date toDate);
  abstract Map<String,FileMetadata> returnModifiedFilesInDateInterval(String pathToDirectory, Date fromDate, Date toDate);



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
    this.searchAttributes |= (SearchAttributes.date);
  }

  public void removeDateAttribute() {
    this.searchAttributes &= ~(SearchAttributes.date);
  }

  public void setModificationDateAttribute() {
    this.searchAttributes |= (SearchAttributes.modificationDate);
  }

  public void removeModificationDateAttribute() {
    this.searchAttributes &= ~(SearchAttributes.modificationDate);
  }
}
