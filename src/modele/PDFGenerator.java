/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;

import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;




/**
 *
 * @author debor
 */
public class PDFGenerator 
{
   // public static final String url="C:\\Users\\debor\\Desktop\\BTS\\2eme annee\\PPE\\Applis_Support\\2018\\Appli_Java_JavaFX\\pdftest.pdf";
       private static String url = "C:\\Users\\debor\\Documents\\Java_FormArmor";
    
    public static void main() {

        Document document = new Document(PageSize.A4);

        try {
            
            PdfWriter.getInstance(document,new FileOutputStream(url));
            document.open();
            document.add(new Paragraph("Hello World"));
        } 
        catch (DocumentException de) {
            System.out.println("PLOP: "+de.getMessage());
            de.printStackTrace();
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("PLOP: "+ex.getMessage());
        }

        document.close();

    }
}
