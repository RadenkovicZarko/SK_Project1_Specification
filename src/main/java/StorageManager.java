public class StorageManager {
  private static StorageSpecification storage = null;

  public static void registerStorage(StorageSpecification st) {
    StorageManager.storage = st;
  }

  public static StorageSpecification getStorage(String path) {
    if (StorageManager.storage != null) {
      StorageManager.storage.setRootFolderPath(path);
    }
    return StorageManager.storage;
  }
}
