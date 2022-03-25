public class Main
{
	public static void main(String[] args) {
	    File txt1 = new File("new.txt");
	    File txt2 = new File("purrr.txt");
	    File java1 = new File("Main.java");
	    File py1 = new File("Main.py");
	    Folder pred1 = new Folder("users", txt1, java1);
	    Folder pred2 = new Folder("mine", txt2, py1);
	    Folder f = new Folder("C:", pred1, pred2);

	    System.out.println(java1.getExpansion());
	    System.out.println(txt2.getPath());

	}
}
