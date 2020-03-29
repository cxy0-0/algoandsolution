package appUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppUtils {
    /**
     *
     * @param filePath file's path
     * @return read the file's content and return to a list
     */
    public static List<String> readFileInput (String filePath) {
        BufferedReader br = null;
        List<String> lines = new ArrayList<>();
        try {
            String line;
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            return lines;
        } catch ( IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
