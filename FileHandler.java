import java.io.*;
import java.util.*;

public class FileHandler {
    public static void saveArrayListToFile(ArrayList data, String fileName, String sep){
        StringBuilder ans = new StringBuilder();
        for (Object record : data) {
            ans.append(record.toString());
            ans.append(sep);
        }
        saveStringToFile(ans.toString(), fileName);
    }

    public static void saveArrayListToFile(ArrayList data, String fileName){
        saveArrayListToFile(data,fileName,"\n");
    }

    public static void saveStringToFile(String data, String fileName){
        BufferedWriter bufferedWriter=null;
        try {
             bufferedWriter = new BufferedWriter(
                    new FileWriter(fileName,false));
            bufferedWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public static String readFile(String fileName){
        StringBuilder res = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(fileName)
        )) {
            String line = bufferedReader.readLine();
            while (line != null){
                res.append(line+"\n");
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("file "+fileName + " not foound");
        } catch (IOException e) {
            System.out.println("error reading "+fileName);
        }
        return res.toString();
    }

    public static HashMap<String, String> readProperties(String file_name){
        HashMap<String,String> prop = new HashMap<String, String>();
        try (InputStream input = new FileInputStream(file_name)) {
            Properties properties = new Properties();
            properties.load(input);
            for (String key : properties.stringPropertyNames()) {
                String value = properties.getProperty(key);
                prop.put(key, value);
            }
        }catch (IOException e){
            System.out.println("Error reading properties ");
        }
        return prop;
    }

    public static void setProperties(HashMap<String, String> map, String fileName){
        Properties p = new Properties();
        Set<HashMap.Entry<String,String>> set = map.entrySet();
        for (Map.Entry<String,String> entry : set) {
            p.put(entry.getKey(), entry.getValue());
        }
        OutputStream outputStream;
        try {
            outputStream = new FileOutputStream(fileName);
            p.store(outputStream,"System properties");
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }


    }

}
