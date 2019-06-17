import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class listAndDeleteTxtFiles {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Files.list(Paths.get("C:\\Piyusha")).filter(path -> path.toString().endsWith(".txt")).forEach(System.out::println);
	
		File folder = new File("C:\\Piyusha");
		File fList[] = folder.listFiles();

		for (int i = 0; i < fList.length; i++) {
		    File pes = fList[i];
		    if (pes.toString().endsWith(".txt")) {
		    	boolean success = fList[i].delete();
		    }
		}
	}

}
