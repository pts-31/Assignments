import java.io.File;

public class listAllFiles {

	 public void walk( String path ) {

	        File root = new File( path );
	        File[] list = root.listFiles();

	        if (list == null) return;

	        for ( File f : list ) {
	            if ( f.isDirectory() ) {
	                walk( f.getAbsolutePath() );
	                System.out.println( "Dir:" + f.getAbsoluteFile() );
	            }
	            else {
	                System.out.println( "File:" + f.getAbsoluteFile() );
	            }
	        }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	        listAllFiles fw = new listAllFiles();
	        fw.walk("c:\\Program Files\\Dell" );
	}

}
