import java.io.*;

public class Xor {
    public static void main(String[] arguments) {
        XorLauncher.main(arguments);
    }


    public String xor(String str, String key) {
        if (!key.matches("^[0-9a-fA-F]+$")) throw new NumberFormatException("Number should to be in decimal system");
        int keyDec = Integer.parseInt(key, 16);
        StringBuilder result = new StringBuilder();
        char[] strr = str.toCharArray();
        int i = 0;
        while (i < strr.length) {
            int c = strr[i];
            result.append((char) (c ^ keyDec));
            i++;
        }
        return result.toString();
    }

    public void ciphxor(String key1, String inputFileName, String outputFileName) {
        try (Writer output = new FileWriter(outputFileName);
             BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {

            String line = reader.readLine();
            while (line != null) {
                output.write(xor(line, key1));
                line = reader.readLine();
                if (line != null) {
                    output.write(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


