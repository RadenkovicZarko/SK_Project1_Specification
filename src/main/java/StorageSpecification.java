import java.io.File;
import java.util.HashMap;
import java.util.List;

public abstract class StorageSpecification {

  private Configuration configuration=new Configuration();

  abstract void createRootFolder(Configuration configuration);
  abstract void setConfigurationSizeOfStorage(int size);
  abstract void setConfigurationExtensions(List<String> extensions);
  abstract void setConfigurationNumberOfFiles(int numberOfFiles);
  abstract void createFolderOnSpecifiedPath(String path);



  abstract void putFileOnSpecifiedPath(List<File> listFiles, String path);
  abstract void deleteFileOrDirectory(String name);
  abstract void deleteFileOrDirectory(String name,String path);
  abstract void moveFileFromDirectoryToAnother(String fileName,String pathFrom,String pathTo);
  abstract void downloadFileOrDirectory(String pathFrom,String pathTo);
  abstract void renameFileOrDirectory(String path,String nameBefore,String nameAfter);
  abstract HashMap<String,FileMetadata> filesFromDirectory(String path);
  abstract HashMap<String,FileMetadata> filesFromChildrenDirectory(String path);
  abstract HashMap<String,FileMetadata> allFilesFromDirectoryAndSubdirectory(String path);
  abstract HashMap<String,String> filesFromDirectoryExt(String path, List<String> extensions);
  abstract HashMap<String,String> filesFromChildrenDirectoryExt(String path,List<String> extensions);
  abstract HashMap<String,String> allFilesFromDirectoryAndSubdirectoryExt(String path,List<String> extensions);
  abstract HashMap<String,String> filesFromDirectorySubstring(String path,String substring);
  abstract String folderNameByFileName(String nameOfFile);
  abstract List<String> returnFilesInDateInterval(String directoryName, Date fromDate, Date toDate);
}
