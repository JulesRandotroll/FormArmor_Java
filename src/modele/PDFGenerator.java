package modele;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Date;
import java.util.ArrayList;

public class PDFGenerator 
{
       private static String url = "C:\\Users\\debor\\Documents\\Java_FormArmor\\";
    
       
    public static void main(Session SessionSelect, Formation f) {

        Document document = new Document(PageSize.A4);
        int i=0;

        try 
        {
            PdfWriter.getInstance(document,new FileOutputStream(url+"emergement"+i+".pdf"));
            document.open();
            
            Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
            Paragraph titre = new Paragraph("Feuille d'Emargement\n\n",boldFont); 
            titre.setAlignment(Element.ALIGN_CENTER);
            document.add(titre);
            
            String libelle=f.getLibelle();
            Date DateD=SessionSelect.getDate_debut();
            String Niveau=f.getNiveau();
            String Diplome;
            
            if(f.isDiplomante())
            {
                Diplome="oui";
            }
            else
            {
                Diplome="non";
            }
            String type=f.getType();
            int nbInscrits=SessionSelect.getNb_inscrits();
            
            String enteteG="Libellé: "+libelle+"\nDate Début: "+DateD+"\nNiveau: "+Niveau;
            String enteteD="Diplomante: "+Diplome+"\nType: "+type+"\nNombre d'inscrit: "+nbInscrits;
            
            //On créer un objet table dans lequel on intialise ça taille.
            PdfPTable entete = new PdfPTable(2);
            entete.setWidthPercentage(100);

            //contenu du tableau.
            entete.getDefaultCell().setBorder(0);
            entete.addCell(enteteG);
            entete.addCell(enteteD);
            
            document.add(entete) ; 
            Paragraph espace = new Paragraph("\n"); 
            document.add(espace) ; 
            
            PdfPTable tableau = new PdfPTable(2);
            tableau.setWidthPercentage(100);

            //contenu du tableau.
            ArrayList<Client>lesClients=GestionSql.getLesClientsAFormer(f.getIdFormation());
            System.out.println ("ICI "+lesClients);
            tableau.addCell("NOM Prenom");
            tableau.addCell("Signature");

            if(lesClients.size()==0)
            {
               tableau.addCell("Personne n'est encore ");
               tableau.addCell("inscrit pour cette formation");
            }
            else
            {
                for(int j=0; j<lesClients.size();j++)
                {
                    tableau.addCell(lesClients.get(j).toString());
                    tableau.addCell(" ");
                }
            }
           
            document.add(tableau) ;  
            
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
