package de.schifi.cahcardgen.main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CardGenerator {

    private File file;
    List<String> textList = new ArrayList<String>();

    public CardGenerator(File file) {
        this.file = file;
        readFileToStringList();
    }

    private void readFileToStringList() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                textList.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
