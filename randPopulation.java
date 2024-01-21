import java.util.HashMap;

public class randPopulation {
    public HashMap<Double,String> randomPopulation(double TARGET_NUMBER,int stringLength,int POPULATION_SIZE)
    {
        int temp=-1;
        HashMap<Double,String> population=new HashMap<>();

        RandomBinaryStringGenerator rsg= new RandomBinaryStringGenerator();
        for (int i = 0; i < 1000; i++)
        {
            String binaryString=rsg.generateRandomBinaryString(stringLength);
            double candidate=rsg.binaryDecimal(binaryString,stringLength);

            if(candidate <= (TARGET_NUMBER/2))
            {
                population.put(candidate,binaryString);
                //System.out.println(binaryString+" "+candidate);
                temp++;
                if(temp == POPULATION_SIZE-1){
                    break;
                }
            }
        }
        return population;
    }
}
