abstract class AbstractFileSystemNode implements FileSystemNode{
    public FileSystemNode parent;
    String name;
    @Override
    public final FileSystemNode getParent(){
        return parent;
    }
    
    @Override
    public void setParent(FileSystemNode parent){
        this.parent = parent;
    }
    
    @Override
    public String getName(){
        return name;
    }
    
    @Override
    public final String getPath(){
        String res = "";
        FileSystemNode curr = this;
        while (true){
            res = curr.getName() + "\\" + res ;
            curr = curr.getParent();
            if (curr == null) break;
        }
        return res;
    }
}