import data.ProductInfo;

import java.io.*;
import java.util.ArrayList;

public class Utility {
    public static final int FRAME_WIDTH = 600;
    public static final int FRAME_HEIGHT = 400;

    //This method is used for validate the numbers
    public static boolean isValidNumber(String text) {
        try {
            double number = Double.parseDouble(text);
            return !(number <= 0);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //This method is used to get the list of the products data from file.
    public static ArrayList<ProductInfo> getProductList(){
        File file = new File("src/productsInfo.dat");
        ArrayList<ProductInfo> productList= new ArrayList<>();
        if(file.exists()) {
            try (ObjectInputStream inputStream  = new ObjectInputStream(new FileInputStream(file))){
                productList= (ArrayList<ProductInfo>) inputStream.readObject();
                System.out.println("Data Read !!");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Not able to find File");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Not able to read file.");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return productList;
    }
}
