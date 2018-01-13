package jade;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class FileRules {
    String[] stringArr ;

    public void FileRules(){
        
    };

    public String[] readRules () {
        try {
            Scanner sc = new Scanner(new File("rules.txt"));
            List<String> lines = new ArrayList<String>();
            while (sc.hasNextLine()) {
              lines.add(sc.nextLine().trim());
            }
            stringArr = lines.toArray(new String[0]);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            return stringArr;
        }
    };
    
    public void saveNewRules(String[] rulesToSave){
        try {
        FileWriter writer = new FileWriter("rules.txt", false);
        writer.write("");
        for (int i = 0; i < rulesToSave.length; i++) {
             writer.write(rulesToSave[i]);
            //this is the code that you change, this will make a new line between each y value in the array
            writer.write("\n");   // write new line
        }
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    }
 
}