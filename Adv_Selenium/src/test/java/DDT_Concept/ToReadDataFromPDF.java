package DDT_Concept;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ToReadDataFromPDF {

	public static void main(String[] args) throws Throwable {
		File fs = new File("./src/test/resources/32_Sample_Chapter.pdf");
		
		PDDocument doc = new PDDocument();
		PDDocument pd = doc.load(fs);
		
		//To print total number of pages in pdf
		int pages = pd.getNumberOfPages();
		System.out.println(pages);
		
		// to print entire content of pdf 
		PDFTextStripper content = new PDFTextStripper();
		
		String EntirePdf = content.getText(pd);
		System.out.println(EntirePdf);
		
	}

}
