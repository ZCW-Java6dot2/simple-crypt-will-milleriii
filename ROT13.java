import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

import java.io.*;

public class ROT13  {
    private Character cs;
    private Character cf;
    private Integer shiftDif;

    ROT13(Character cs, Character cf) {
        this.cs = cs;
        this.cf = cf;
    }

    ROT13() {
        cs = 'a';
        cf = 'n';
    }


public String crypt(String text) throws UnsupportedOperationException {
    StringBuilder result = new StringBuilder();
    int shiftDif = 13;
    for (int i = 0; i < text.length(); i++) {
        if (Character.isUpperCase(text.charAt(i))) {
            char c = (char) (((int) text.charAt(i) + shiftDif - 65) % 26 + 65);
            result.append(c);
        } else if(Character.isLowerCase(text.charAt(i))){
            char c = (char) (((int) text.charAt(i) + shiftDif - 97) % 26 + 97);
            result.append(c);
        } else {
            result.append(text.charAt(i));
        }
    }
    return result.toString();
}

    public String encrypt(String text) {
        return crypt(text);
    }

    public String decrypt(String text) {
        return crypt(text);
    }

    public static String rotate(String s, Character c) {
        StringBuilder stringBuilder = new StringBuilder();
        int charIndex = s.indexOf(c);

        String spliceFront = s.substring(charIndex);
        String spliceBack = s.substring(0, charIndex);

        stringBuilder.append(spliceFront).append(spliceBack);
        return stringBuilder.toString();
    }

    public void encryptFile(File fileInput){
        try{
            BufferedReader fileReader = new BufferedReader(new FileReader(fileInput));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(new File("sonnet18.enc")));
            String textLine;
            while((textLine = fileReader.readLine()) != null){
                fileWriter.write(encrypt(textLine) + "\n");
            }
            fileWriter.close();
            fileReader.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.fillInStackTrace();
        }

    }

    public void decryptFile(File fileInput){
        try{
            BufferedReader fileReader = new BufferedReader(new FileReader(fileInput));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter("sonnet18.dec"));
            String textLine;
            while((textLine = fileReader.readLine()) != null){
                fileWriter.write(encrypt(textLine) + "\n");
            }
            fileWriter.close();
            fileReader.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.fillInStackTrace();
        }

    }

}