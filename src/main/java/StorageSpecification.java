import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public abstract class StorageSpecification {

  private final Configuration configuration=new Configuration();
  private String rootFolderPath="";

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
  abstract void downloadFileOrDirectory(String pathFrom,String pathTo);
  abstract void renameFileOrDirectory(String path,String nameAfter);

  abstract HashMap<String,FileMetadata> filesFromDirectory(String path);
  abstract HashMap<String,FileMetadata> filesFromChildrenDirectory(String path);
  abstract HashMap<String,FileMetadata> allFilesFromDirectoryAndSubdirectory(String path);

  abstract HashMap<String,String> filesFromDirectoryExt(String path, List<String> extensions);
  abstract HashMap<String,String> filesFromChildrenDirectoryExt(String path,List<String> extensions);
  abstract HashMap<String,String> allFilesFromDirectoryAndSubdirectoryExt(String path,List<String> extensions);

  abstract HashMap<String,String> filesFromDirectorySubstring(String path,String substring);
  abstract HashMap<String,String> filesFromChildrenDirectorySubstring(String path,String substring);
  abstract HashMap<String,String> filesFromDirectoryAndSubdirectorySubstring(String path,String substring);


  abstract String folderNameByFileName(String nameOfFile);
  abstract List<String> returnFilesInDateInterval(String directoryName, Date fromDate, Date toDate);

  public Configuration getConfiguration() {
    return configuration;
  }

  public String getRootFolderPath() {
    return rootFolderPath;
  }

  public void setRootFolderPath(String rootFolderPath) {
    this.rootFolderPath = rootFolderPath;
  }
}
