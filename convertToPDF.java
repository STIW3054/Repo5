package output;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import static output.errorLog.fileName;

/**
 *
 * @author Don Lee Hoi
 */
public class convertToPDF {
    
    LinkedList<String> al = new LinkedList<String>();
    String create;
    String str;
    File file;
    BufferedReader in;

    String workingDirectory;
    String absoluteFilePath;
    String name1;
    
    public void convert() throws FileNotFoundException, IOException, COSVisitorException{
     JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            file = new File(selectedFile.getAbsolutePath());
        }
        workingDirectory = System.getProperty("user.dir");
        absoluteFilePath = workingDirectory + File.separator;
        in = new BufferedReader(new FileReader(file));
        int i=1, y=750;
        fileName =  "log" + i + ".pdf";
        i++;
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
       
        while ((str = in.readLine()) != null) {
        contentStream.beginText(); 
        contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
        contentStream.moveTextPositionByAmount(20,y-=30);
        String text = str;
        contentStream.drawString(text);
        contentStream.endText();
        }
        
        System.out.println("Content added");
        contentStream.close();
        document.save(fileName);
        document.close();
    }
}
