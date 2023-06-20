package trees;

import java.util.List;
import java.util.ArrayList;

/**
 * Eine fachliche Anwendung des generischen Set-Interfaces
 * als eine Menge von Wörtern.
 * 
 * @author Axel Schmolitzky
 * @version 2023
 */
class Startup
{
    public static void start(ADSortedSet<String> wortschatz)
    {
        // Einlesen des Textes
        List<String> wortliste = new ArrayList<String>();
        System.out.print("Starte Einlesen: ... ");
        long start = System.currentTimeMillis();
        Worteinleser.einlesenAusDatei("moby10b.txt",wortliste);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("eingelesene Wörter: " + wortliste.size());
        System.out.println("Benötigte Zeit: " + time + "ms");
        
        System.out.print("Starte Einfügen: ... ");
        start = System.currentTimeMillis();
        for (String wort : wortliste)
        {
            wortschatz.add(wort);
        }
        end = System.currentTimeMillis();
        time = end - start;
        System.out.println("Wörter im Wortschatz: " + wortschatz.size());
        System.out.println("Benötigte Zeit: " + time + "ms \n");
    }
}
