import java.util.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public abstract class StorageSpecification {

  private final Configuration configuration=new Configuration();
  private String rootFolderPath="";
  private int searchAttributes=SearchAttributes.wholePath;

  /**
   * Creates root folder and sets root path
   */
  abstract void createRootFolder();

  /**
   * Sets size of storage in configuration file
   * @param size Size of a storage in bytes
   */
  void setConfigurationSizeOfStorage(int size)
  {
    configuration.setSize(size);
  }
  /**
   * Sets extensions in configuration file
   * @param extensions List of forbidden extensions
   */
  void setConfigurationExtensions(List<String> extensions)
  {
    configuration.setForbiddenExtensions(extensions);
  }
  /**
   * Sets number of files for each folder in configuration file
   * @param map map of pairs (file name, file size)
   */
  void setConfigurationNumberOfFilesInFolder(Map<String,Integer> map)
  {
    configuration.setNumberOfFilesInFolder(map);
  }
  /**
   * Checks if root folder path is valid
   * @param path Root folder path
   */
  abstract void setRootFolderPathInitialization(String path);

  /**
   * Creates a new folder inside storage
   * @param path relative path where folder is created
   * @param name name of the folder
   */
  abstract void createFolderOnSpecifiedPath(String path, String name);
  /**
   * Uploads files in storage
   * @param listFiles list of full paths of local files
   * @param path relative path of a storage folder
   */
  abstract void putFilesOnSpecifiedPath(List<String> listFiles, String path); //Proslede se putanje od fajlova i onda se u implementaciji proveravaju i traze ti fajlovi
  /**
   * Deletes a file or a directory in storage
   * @param path relative path of a file/directory to be deleted
   */
  abstract void deleteFileOrDirectory(String path);
  /**
   * Moves file inside storage between folders
   * @param filePath relative path of a source folder
   * @param pathTo relative path of a destination folder
   */
  abstract void moveFileFromDirectoryToAnother(String filePath,String pathTo); //Putanja fajla i putanja do drugog foldera u koji treba da se sacuva
  /**
   * Downloads file from storage to local folder
   * @param pathFrom relative path of a storage file/directory
   * @param pathTo full path of destination local folder
   */
  abstract void downloadFileOrDirectory(String pathFrom,String pathTo);
  /**
   * Renames file or directory in storage
   * @param path relative path of a storage
   * @param nameAfter new name
   */
  abstract void renameFileOrDirectory(String path,String nameAfter);

  /**
   * Returns files from storage
   * @param path relative path of a storage file/directory
   * @return Files from directory and metadata
   */
  abstract Map<String,FileMetadata> filesFromDirectory(String path);
  /**
   * Returns files from children directories in storage directory
   * @param path relative path of a storage file/directory
   * @return Files from children directories and metadata
   */
  abstract Map<String,FileMetadata> filesFromChildrenDirectory(String path);

  /**
   * Returns all files from storage directory and subdirectories
   * @param path relative path of a storage file/directory
   * @return Files from directory and subdirectories and metadata
   */
  abstract Map<String,FileMetadata> allFilesFromDirectoryAndSubdirectory(String path);

  /**
   * Returns files from storage with allowed extensions
   * @param path relative path of a storage file/directory
   * @param extensions allowed extensions
   * @return Files from directory and metadata
   */
  abstract Map<String,FileMetadata> filesFromDirectoryExt(String path, List<String> extensions);
  /**
   * Returns files from children directories in storage directory with allowed extensions
   * @param path relative path of a storage file/directory
   * @param extensions allowed extensions
   * @return Files from children directories and metadata
   */
  abstract Map<String,FileMetadata> filesFromChildrenDirectoryExt(String path,List<String> extensions);
  /**
   * Returns all files from storage directory and subdirectories
   * @param path relative path of a storage file/directory
   * @param extensions allowed extensions
   * @return Files from directory and subdirectories and metadata
   */
  abstract Map<String,FileMetadata> allFilesFromDirectoryAndSubdirectoryExt(String path,List<String> extensions);

  /**
   * Returns files from storage that contain substring
   * @param path relative path of a storage file/directory
   * @param substring substring
   * @return Files from directory and metadata
   */
  abstract Map<String,FileMetadata> filesFromDirectorySubstring(String path,String substring);
  /**
   * Returns files from children directories in storage directory that contain substring
   * @param path relative path of a storage file/directory
   * @param substring substring
   * @return Files from children directories and metadata
   */
  abstract Map<String,FileMetadata> filesFromChildrenDirectorySubstring(String path,String substring);
  /**
   * Returns all files from storage directory and subdirectories that contain substring
   * @param path relative path of a storage file/directory
   * @param substring substring
   * @return Files from directory and subdirectories and metadata
   */
  abstract Map<String,FileMetadata> filesFromDirectoryAndSubdirectorySubstring(String path,String substring);

  /**
   * Checks does directory contain specified files
   * @param path relative path of a storage file/directory
   * @param namesOfFiles list of names of files
   * @return null if path is invalid, otherwise it returns valid files or reports that there is no such files
   */
  abstract String doesDirectoryContainFiles(String path,List<String> namesOfFiles);
  /**
   * Returns relative path of a folder where file is located
   * @param fileName name of file to be searched
   * @return relative path of a folder containing a file
   */
  abstract String folderNameByFileName(String fileName);

  /**
   * Returns list of files created in date interval
   * @param pathToDirectory Relative path of a folder to be searched
   * @param fromDate starting date
   * @param toDate ending date
   * @return list of files in given date interval
   */
  abstract Map<String,FileMetadata> returnCreatedFilesInDateInterval(String pathToDirectory, Date fromDate, Date toDate);
  /**
   * Returns list of files modified in date interval
   * @param pathToDirectory Relative path of a folder to be searched
   * @param fromDate starting date
   * @param toDate ending date
   * @return list of files in given date interval
   */
  abstract Map<String,FileMetadata> returnModifiedFilesInDateInterval(String pathToDirectory, Date fromDate, Date toDate);
  /**
   * Returns list of files modified after given date
   * @param pathToDirectory Relative path of a folder to be searched
   * @param fromDate starting date
   * @return list of files in given date interval
   */
  abstract Map<String,FileMetadata> returnModifiedFilesFromDate(String pathToDirectory, Date fromDate);
  /**
   * Returns list of files modified before given date
   * @param pathToDirectory Relative path of a folder to be searched
   * @param toDate ending date
   * @return list of files in given date interval
   */
  abstract Map<String,FileMetadata> returnModifiedFilesBeforeDate(String pathToDirectory,  Date toDate);

  /**
   * Sets limit of files for new folder in configuration file
   * @param path Relative path of a folder
   * @param number file size
   * @return list of files in given date interval
   */
  abstract void addLimitForFolder(String path, int number);

  /**
   * Sorts file by file name
   * @param hashMap file names and metadata
   * @param desc descending order
   * @return sorted files
   */
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

  /**
   * Sorts file by created date
   * @param hashMap file names and metadata
   * @param desc descending order
   * @return sorted files
   */
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

  /**
   * Sorts file by file size
   * @param hashMap file names and metadata
   * @param desc descending order
   * @return sorted files
   */
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

  /**
   * Sets whole path attribute in output string
   */
  public void setWholePathAttribute() {
    this.searchAttributes |= (SearchAttributes.wholePath);
  }

  /**
   * Removes whole path attribute in output string
   */
  public void removeWholePathAttribute() {
    this.searchAttributes &= ~(SearchAttributes.wholePath);
  }

  /**
   * Sets file size attribute in output string
   */
  public void setFileSizeAttribute() {
    this.searchAttributes |= (SearchAttributes.fileSize);
  }

  /**
   * Removes file size attribute in output string
   */
  public void removeFileSizeAttribute() {
    this.searchAttributes &= ~(SearchAttributes.fileSize);
  }

  /**
   * Sets created date attribute in output string
   */
  public void setDateAttribute() {
    this.searchAttributes |= (SearchAttributes.createdDate);
  }

  /**
   * Removes created date attribute in output string
   */
  public void removeDateAttribute() {
    this.searchAttributes &= ~(SearchAttributes.createdDate);
  }

  /**
   * Sets modification date attribute in output string
   */
  public void setModificationDateAttribute() {
    this.searchAttributes |= (SearchAttributes.modificationDate);
  }

  /**
   * Removes modification date attribute in output string
   */
  public void removeModificationDateAttribute() {
    this.searchAttributes &= ~(SearchAttributes.modificationDate);
  }

  /**
   * Returns string for files output
   * @param map file names and metadata
   * @return output string
   */
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

  /**
   * Provides different ways of files creation
   * @param input input string
   * @param path folder path
   */
  public abstract void mkdirCreateFiles(String input, String path);
}
