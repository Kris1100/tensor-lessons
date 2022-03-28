interface FileSystemNode{
    var parent : FileSystemNode?
    var name : String
    fun getParent2() : FileSystemNode?
    fun getName2() : String
    fun getPath() : String
    fun setParent2(parent : FileSystemNode?) : Unit
}

abstract class AbstractFileSystemNode : FileSystemNode{
    override var parent : FileSystemNode? = null
    override abstract var name : String
    
    override fun getParent2() : FileSystemNode?{
        return this.parent
    }

    override fun getName2() : String{
        return this.name
    }
    
    override fun getPath() : String{
        var res : String = ""
        var curr : FileSystemNode? = this
        while (true){
            if (curr != null){
            	res = curr.getName2() + "\\" + res 
            	curr = curr.getParent2()
            }
            else break
        }
        return res
    }
     	override fun setParent2(parent : FileSystemNode?) : Unit{
        this.parent = parent
    }
    
}

class Folder : AbstractFileSystemNode{
    override var name : String
    var list : List<FileSystemNode>
    

    
    constructor(name : String, vararg v: FileSystemNode){
        this.name = name
        this.list = v.toList()
        for (i in v){
            i.parent = this
        }
        
    }
}

public class File : AbstractFileSystemNode{
    override var name : String
    
    constructor(name : String){
        this.name = name
    }
    
    public fun getExpansion() : String{
        var res : String = "";
        var wasPoint : Boolean = false;
        for (i in name){
            if (i == '.') wasPoint = true;
            else if (wasPoint) res += i
        }
        return res
    }
    
  
}

fun main() {
    var txt1 = File("new.txt")
    var txt2 = File("purrr.txt")
    var java1 = File("Main.java")
    var py1 = File("Main.py")
    var pred1 = Folder("users", txt1, java1)
    var pred2 = Folder("mine", txt2, py1)
    var f1 = Folder("C:", pred1, pred2)
    println(f1.getPath())
    println(java1.getExpansion())
	println(txt2.getPath())
}
