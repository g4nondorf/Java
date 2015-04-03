
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hadj
 */
public class CopyBinaire {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataInputStream in;
        DataOutputStream out;
        if (args.length != 2) {
            System.out.println("java Copier source destination");
            return;
        }
        File inF = new File(args[0]);
        File ouF = new File(args[1]);
        
        if (!inF.exists()) {
            System.out.println(args[0] + " n'existe pas");
            return;
        }
        if (ouF.exists()) {
            System.out.println(args[1] + " existe deja");
            return;
        }
        try {
            in = new DataInputStream(new BufferedInputStream(new FileInputStream(inF)));
            out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(ouF)));
            try {
                int b;
                while (true) {
                    b = in.readUnsignedByte();
                    int r = 0x0;
                    for(int i = 7; i >= 0; i--){//Changements binaire complexe a revoir en précision. Sorte de cryptage
                        int c = (b>>i) & 0x1;
                        int e = c<<(7-i);
                        r = r|e;
                    }
                    out.writeByte(r);
                }
            } catch (EOFException e) {
                out.close();
                in.close();
                return;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Probleme ouvrire fichier");
        } catch (IOException e) {
            System.out.println("Probleme d'E/S");
        }
    }
}
