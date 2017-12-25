package output;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument; 
import org.apache.pdfbox.pdmodel.PDPage;  
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
/**
 *
 * @author Don Lee Hoi
 */
public class errorLog {
     static String directory, subdirectory, folderpath, fileName;
    public String errorLog(String folderpath, long startTime, long endTime) throws IOException, COSVisitorException{
      directory = folderpath + File.separator + "/STIW3054-Result";  //create directory      
      File file = new File(directory);
      file.mkdir(); 
      subdirectory = directory + File.separator + "/Log Files";  //create log files
      File subfile = new File(subdirectory);
      subfile.mkdir(); 
      int i=1;
      fileName =  "log" + i + ".pdf";
      i++;
      PDDocument document = new PDDocument();
      PDPage page = new PDPage();
      document.addPage(page);
      PDPageContentStream contentStream = new PDPageContentStream(document, page);
      long estimatedTime = endTime - startTime;
      SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");    
      Date resultdate = new Date(endTime);
      try{
      contentStream.beginText(); 
      contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
      contentStream.moveTextPositionByAmount(20, 750);

      String text = "Termination time = " + sdf.format(resultdate) + System.getProperty("line.separator")+
                     "\n"+"Total download duration = " + Math.floor(estimatedTime/1000.0) + " seconds";
      contentStream.drawString(text);     
      contentStream.endText();
      System.out.println("Content added");
      contentStream.close();
      document.save(fileName);
      }catch (IOException e) {
            e.getStackTrace();
        }finally{
            //close resources
            try {
                document.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
      return document.toString();
    }
}
