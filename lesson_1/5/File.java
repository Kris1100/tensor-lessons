public class File extends AbstractFileSystemNode{
    public String name;
    
    File(String name){
        this.name = name;
    }
    
    public String getExpansion(){
        String res = "";
        boolean wasPoint = false;
        for (int i = 0; i < name.length(); i++){
            if (name.charAt(i) == '.') wasPoint = true;
            else if (wasPoint) res += name.charAt(i);
        }
        return res;
    }
    
     @Override
    public String getName(){
        return name;
    }
}