
import java.io.BufferedWriter;
import java.io.File;
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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File f = new File("Data.txt");
            try( BufferedWriter bw = new BufferedWriter(new FileWriter(f))){
                  bw.write('A');
                  bw.write('\n');
                  bw.write("Bonjours");
                  bw.close();
            } catch(IOException e){
                
            }
        
    }
}
