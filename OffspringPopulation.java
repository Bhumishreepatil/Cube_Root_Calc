import java.util.*;
public class OffspringPopulation {
    public static HashMap<Double, String> offspringP(double TARGET_NUMBER, int stringLength, int POPULATION_SIZE)
    {
        // Create an instance of AnotherClass
        randPopulation rp = new randPopulation();
        RandomBinaryStringGenerator rbsg = new RandomBinaryStringGenerator();
        HashMap<Double,String> offspringPop=new HashMap<>();

        // Retrieve the HashMap from AnotherClass
        HashMap<Double, String> population = rp.randomPopulation(TARGET_NUMBER,stringLength, POPULATION_SIZE);

        for(int i=0;i< POPULATION_SIZE;i++)
        {
            //candidate1:
            // Access a random key-value pair from the HashMap
            Map.Entry<Double, String> Candidate1 = getRandomEntry(population);
            // Retrieve the key and value from the random entry
            Double key1 = Candidate1.getKey();
            String value1 = Candidate1.getValue();
            //System.out.println("Randomly accessed key: " + key1);
            //System.out.println("Randomly accessed value: " + value1);

            //Candidate2:
            Map.Entry<Double, String> Candidate2 = getRandomEntry(population);
            // Retrieve the key and value from the random entry
            Double key2 = Candidate2.getKey();
            String value2 = Candidate2.getValue();
            //System.out.println("Randomly accessed key: " + key2);
            //System.out.println("Randomly accessed value: " + value2);

            String mutated1 = Mutation(value1);
            Double mutatedVal1 = rbsg.binaryDecimal(mutated1,stringLength);
            String crossover1 = crossover(value1,value2);
            Double coVal1 = rbsg.binaryDecimal(crossover1,stringLength);

            offspringPop.put(mutatedVal1, mutated1);
            offspringPop.put(coVal1 , crossover1);
        }
        //System.out.println("offspring population");
        //System.out.println(offspringPop);
        return offspringPop;
    }
    public static String crossover(String parent1, String parent2)
    {
        StringBuilder child = new StringBuilder();
        int crossoverPoint = (int) (Math.random() * parent1.length());

        for (int i = 0; i < parent1.length(); i++) {
            if (i < crossoverPoint) {
                child.append(parent1.charAt(i));
            } else {
                child.append(parent2.charAt(i));
            }
        }
        return child.toString();

    }
    public static String Mutation(String Mcandidate)
    {
        // generate random index
        int index = (int) (Math.random() * (Mcandidate.length() - 1));
        // get the character at that index
        char ch = Mcandidate.charAt(index);
        String str;
        if(ch == '.')
        {
            char c = Mcandidate.charAt(++index);
            if(c == '1')
            {
                str = Mcandidate.substring(0, index) + '0'
                        + Mcandidate.substring(index + 1);
            }
            else {
                str = Mcandidate.substring(0, index) + '1'
                        + Mcandidate.substring(index + 1);
            }
        }
        else {
            if(ch == '1')
            {
                str = Mcandidate.substring(0, index) + '0'
                        + Mcandidate.substring(index + 1);
            }
            else {
                str = Mcandidate.substring(0, index) + '1'
                        + Mcandidate.substring(index + 1);
            }
        }
        //System.out.println("without mutation"+Mcandidate);
        //System.out.println("mutated"+str);
        return str.toString();
    }
    public static Map.Entry<Double, String> getRandomEntry(HashMap<Double, String> hashMap) {

        // Convert the entry set to an array for random selection
        Map.Entry<Double, String>[] entries = hashMap.entrySet().toArray(new Map.Entry[0]);

        // Select a random index
        Random random = new Random();
        int randomIndex = random.nextInt(entries.length);

        // Retrieve the random entry
        return entries[randomIndex];
    }
}

