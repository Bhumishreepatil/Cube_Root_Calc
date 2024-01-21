public class doubleToBinaryString {
    public static String doubleToBinaryString1(double num) {
        long bits = Double.doubleToLongBits(num);
        String binaryStr = Long.toBinaryString(bits); // Convert the long value to a binary string
        binaryStr = binaryStr.substring(binaryStr.length() - 5); // Truncate or pad the binary string to a length of 5
       return binaryStr;

    }
}
