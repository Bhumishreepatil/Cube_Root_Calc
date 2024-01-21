import java.util.Random;
import java.util.*;

public class RandomBinaryStringGenerator {
    public ArrayList<String> binaryPopulation=new ArrayList<String>();
    public static String generateRandomBinaryString(int length) {
        Random random = new Random();

        // Generate the random integral part (whole number)
        int wholeNumber = random.nextInt(100) +1;  // Random whole number between 0 and 100
        String wholeNumberBinary = Integer.toBinaryString(wholeNumber);

        // Generate the random fractional part
        StringBuilder fractionalBinary = new StringBuilder(".");
        for (int i = 0; i < length - wholeNumberBinary.length() - 1; i++) {
            int bit = random.nextInt(2);
            fractionalBinary.append(bit);
        }

        // Combine the whole number and fractional part
        return wholeNumberBinary + fractionalBinary.toString();
    }

    public double binaryDecimal(String Child,int stringLength)
    {
        //int len = 20;

        binaryPopulation.add(Child);
        // Fetch the radix point
        int point = Child.indexOf('.');

        // Update point if not found
        if (point == -1)
            point = stringLength;

        double intDecimal = 0, fracDecimal = 0, twos = 1;

        // Convert integral part of binary to decimal
        // equivalent
        for(int i = point - 1; i >= 0; i--)
        {
            intDecimal += (Child.charAt(i) - '0') * twos;
            twos *= 2;
        }

        // Convert fractional part of binary to
        // decimal equivalent
        twos = 2;
        for(int i = point + 1; i < stringLength; i++)
        {
            fracDecimal += (Child.charAt(i) - '0') / twos;
            twos *= 2.0;
        }
        //System.out.println("Binary to decimal  ");
        //System.out.println(intDecimal + fracDecimal);
        // Add both integral and fractional part
        return intDecimal + fracDecimal;
    }
}