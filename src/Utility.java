public class Utility {

    public static boolean isValidNumber(String text) {
        try {
            double number = Double.parseDouble(text);
            return !(number <= 0);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
