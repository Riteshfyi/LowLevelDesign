public interface FileComponent {
    String getName();

    // New method for adding subdirectories or files
    default void add(FileComponent fileComponent) {
        throw new UnsupportedOperationException("Cannot add files to a non-directory component.");
    }

    default FileComponent getChild(String name) {
        return null; // Default for files
    }

}