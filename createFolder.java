package readFile;

import java.io.File;

/**
 *
 * @author Don Lee Hoi
 */
public class createFolder {
    static boolean successful = false;

    public File create (String str,String absoluteFilePath ){
           String url = str;
           int slash = url.lastIndexOf('/');
           String substring = url.substring(slash + 1, slash + 7);
           File dir = new File(absoluteFilePath + "realtime" + File.separator + substring);
           System.out.println("GitHub Link " + url);
           System.out.println("directory " + dir.toString());
             if(dir.mkdir()){
                  successful=true;
                  return dir;
                }else{
                  successful=false;
                  return null;
                }
    }
}
