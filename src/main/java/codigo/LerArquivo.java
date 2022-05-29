/*
Nome: Pedro Henrique Rocha de Castro e Thiago Rodrigues Valentim
Matricula: 
20213004828(Pedro)
20203015926(Thiago)
 */
package codigo;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LerArquivo {
   private static Scanner input;
   
   public static ArrayList<String> palavras=new ArrayList<String>();//public para ser acessado na classe Forca sem precisar instanciar.


    // open file palavras.txt
   public static void openFile()
   {
      try
      {
         input = new Scanner(Paths.get("palavras.txt")); 
      } 
      catch (IOException ioException)
      {
         System.err.println("Error opening file. Terminating.");
         System.exit(1);
      } 
   }

   // read record from file
   public static void readRecords()
   {
      
      try 
      {
         while (input.hasNext()) // while there is more to read
         {
           palavras.add(input.nextLine());//armazena todas palavras no arrayList.
         }
      } 
      catch (NoSuchElementException elementException)
      {
         System.err.println("File improperly formed. Terminating.");
      } 
      catch (IllegalStateException stateException)
      {
         System.err.println("Error reading from file. Terminating.");
      } 
   } // end method readRecords

   // close file and terminate application
   public static void closeFile()
   {
      if (input != null)
         input.close();
   } 
} // end class ReadTextFile

