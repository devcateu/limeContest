import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by slawek on 2015-09-29.
 */
public class Main {
    int cuts = 2;
    String scenes = "DDSDSSD";

    public static void main(String[] args) {


        //readFile();
    }

    private static void readFile() {
        BufferedReader br = null;

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader("C:\\testing.txt"));

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
