import java.util.ArrayList;
public class Folder extends AbstractFileSystemNode{
    public String name;
    public ArrayList<FileSystemNode> list = new ArrayList<>();
    
    @Override
    public String getName(){
        return name;
    }
    
    Folder(String name, FileSystemNode ... v){
        this.name = name;
        for(int i = 0; i < v.length; i++) {
            list.add(v[i]);
            v[i].setParent(this);
        }
    }
    
    
}