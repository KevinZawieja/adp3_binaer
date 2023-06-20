package trees;

import java.io.*;
import java.util.List;

/**
 * Ein Worteinleser dient zum Einlesen von Wörtern
 * aus einer Textdatei in eine gegebene Liste.
 * 
 * @author Axel Schmolitzky
 * @version 2023
 */
class Worteinleser
{

    /**
     * Liest Wörter aus einer Textdatei in eine Liste ein.
     * @param dateiName der Dateiname der einzulesenden Textdatei
     * @param wortliste die Liste, in die die Wörter eingefügt werden
     */
    public static void einlesenAusDatei(String dateiName, List<String> wortliste)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(dateiName)))
        {
            String zeile;
            while ((zeile = reader.readLine()) != null)
            {
                if (zeile.length() > 0)
                {
                    verarbeiteZeile(zeile,wortliste);
                }
            }
            
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Fehler beim Oeffnen von " + dateiName);
        }
        catch (IOException e)
        {
            System.out.println("Fehler beim Lesen aus " + dateiName);
        }
    }

    private static void verarbeiteZeile(String zeile, List<String> wortliste)
    {
        String[] woerter = zeile.toLowerCase().split("[^a-z]");
        for (String wort : woerter)
        {
            if (wort.length() > 0)
            {
                wortliste.add(wort);
            }
        }
    }
}
