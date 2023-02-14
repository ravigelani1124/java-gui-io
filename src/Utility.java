import data.ProductInfo;

import java.io.*;
import java.util.ArrayList;

public class Utility {

    public static boolean isValidNumber(String text) {
        try {
            double number = Double.parseDouble(text);
            return !(number <= 0);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static ArrayList<ProductInfo> getProductList(){
        File file = new File("src/productsInfo.dat");
        ArrayList<ProductInfo> productList= new ArrayList<>();
        if(file.exists()) {
            try (ObjectInputStream inputStream  = new ObjectInputStream(new FileInputStream(file))){
                productList= (ArrayList<ProductInfo>) inputStream.readObject();
                System.out.println("The Object has been read from the file");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("File not found.");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error reading file.");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Class not found.");
            }
        }
        return productList;
    }
}
