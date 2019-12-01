import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public void ChangeHamletToLeon(){
       Pattern p = Pattern.compile("Hamlet");
        Matcher m = p.matcher(hamletData);
        String replaceLeon = m.replaceAll("Leon");
        hamletData = replaceLeon;
    }
    public void ChangeHoratioToTariq(){
        Pattern p = Pattern.compile("Horatio");
        Matcher m = p.matcher(hamletData);
        String replaceTariq = m.replaceAll("Tariq");
        hamletData = replaceTariq;
    }

    public Boolean findHoratio(){
        Pattern p = Pattern.compile("Horatio");

        Matcher m = p.matcher(getHamletData());
        return m.find();
    }

    public Boolean findHamlet(){
        Pattern p = Pattern.compile("Hamlet");

        Matcher m = p.matcher(getHamletData());
        return m.find();
    }
}
