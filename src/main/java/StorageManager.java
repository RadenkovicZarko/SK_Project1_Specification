public class StorageManager {
  private static StorageSpecification storage = null;

  public static void registerStorage(StorageSpecification st) {
    storage = st;
  }
  
  public static StorageSpecification getStorage() {
    return StorageManager.storage;
  }
}
