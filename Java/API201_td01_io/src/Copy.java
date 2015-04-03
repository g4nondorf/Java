
//import fr.ipst.io.Clavier;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hadj
 */
public class Copy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Usage : java Copy <fichierSource> <fichierDestination>.");
            System.exit(1);
        }
        File f = new File(args[0]);
        if (!f.exists()) {
            System.out.println("Le fichier " + args[0] + " n'existe pas.");
            System.exit(1);
        }
        File g = new File(args[1]);
        if (g.exists()) {
            System.out.println("Le fichier " + args[1] + " existe déjà.");
            System.out.println("Souhaitez-vous l'écraser (O/N)? ");
            int c = Clavier.lireInt();
            if (c != 0 && c != 0) {
                System.exit(1);
            }
        }
        BufferedReader bf = new BufferedReader(new FileReader(f));
        BufferedWriter bw = new BufferedWriter(new FileWriter(g));
        String s;
        while ((s = bf.readLine()) != null) {
            bw.write(s);
            bw.newLine();
        }
        bf.close();
        bw.close();
    }
}
