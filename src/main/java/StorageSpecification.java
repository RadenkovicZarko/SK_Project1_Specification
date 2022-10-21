import java.io.File;
import java.util.HashMap;
import java.util.List;

public interface StorageSpecification {

  void createRootFolder();
  void createRootFolder(Configuration configuration);

  void createFolderOnSpecifiedPath(String path);
  void putFileOnSpecifiedPath(List<File> listFiles, String path);

  void deleteFileOrDirectory(String name);
  void deleteFileOrDirectory(String name,String path);

  void moveFileFromDirectoryToAnother(String fileName,String pathFrom,String pathTo);
  void downloadFileOrDirectory(String pathFrom,String pathTo);

  void renameFileOrDirectory(String path,String nameBefore,String nameAfter);

  HashMap<String,FileMetadata> filesFromDirectory(String path);
  HashMap<String,FileMetadata> filesFromChildrenDirectory(String path);
  HashMap<String,FileMetadata> allFilesFromDirectoryAndSubdirectory(String path);

  HashMap<String,String> filesFromDirectoryExt(String path, List<String> extensions);
  HashMap<String,String> filesFromChildrenDirectoryExt(String path,List<String> extensions);
  HashMap<String,String> allFilesFromDirectoryAndSubdirectoryExt(String path,List<String> extensions);

  HashMap<String,String> filesFromDirectorySubstring(String path,String substring);

  String folderNameByFileName(String nameOfFile);

  List<String> returnFilesInDateInterval(String directoryName, Date fromDate, Date toDate);
}
