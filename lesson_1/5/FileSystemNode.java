public interface FileSystemNode{
    FileSystemNode getParent();
    String getName();
    String getPath();
    void setParent(FileSystemNode parent);
    
}