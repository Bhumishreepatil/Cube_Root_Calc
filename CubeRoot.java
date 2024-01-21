import java.util.*;
public class CubeRoot<temp>
{
    Scanner sc =new Scanner(System.in);
    static final double TARGET_NUMBER = 27; // Change this to the number you want to find the cube root of
    private static final int POPULATION_SIZE = 80;
    private static final int MAX_GENERATIONS = 400;
    static int stringLength= 40;
    static String binaryString;
    static double fitnessFunction;
    static double candidate;
    static double bestCandidate;
    static double result;
    public static void main(String[] args)
    {
        //1. Initial population-------->random
        //2.offspring population------>mutation and crossover of previous population
        //3.Calculation of fitnesstable of both population--------->return the best candidate value in the generation loop
        //4.Best value from best candidate of parent as well as offspring
        //5.If best value is less than 0.001 the best solution is FOUND otherwise not
        //6.Keep a track of best candidate from each generation and store it in an array
        Double[] generationArray= new Double[MAX_GENERATIONS];
        for(int generation=1; generation<=MAX_GENERATIONS; generation++)
        {
            randPopulation rp= new randPopulation();
            OffspringPopulation op=new OffspringPopulation();

            HashMap<Double,String> population= rp.randomPopulation(TARGET_NUMBER,stringLength, POPULATION_SIZE);
            //System.out.println("Initial population");
            //System.out.println(population);
            Double best1= fitnessFunc(population);

            HashMap<Double, String> offpopulation = op.offspringP(TARGET_NUMBER,  stringLength,  POPULATION_SIZE);
            //System.out.println("offspring population");
            //System.out.println(offpopulation);
            Double best2= fitnessFunc(offpopulation);
            if(best1<=best2)
            {
                bestCandidate=best1;
            }
            else
                bestCandidate=best2;

            System.out.println("Generation "+generation+" :     "+bestCandidate);
            generationArray[generation-1]=bestCandidate;
            Double Solution = Math.abs(Math.pow(bestCandidate, 3) - TARGET_NUMBER);
            if (Solution<= 0.001) {
                System.out.println("Found solution at generation "+ generation);
                System.out.println("Cube root of "+TARGET_NUMBER+ " is " + bestCandidate);
                break;
            }
        }
        //System.out.println("best Near Solution "+bestCandidate);
        Double result=generationwise(generationArray);
        System.out.println("Nearest Solution: "+result);
    }
    public static double fitnessFunc(HashMap<Double,String> population)
    {
        HashMap<Double,Double> fitnessScores = new HashMap<>();

        for (double i: population.keySet()) {
            fitnessFunction = Math.abs(Math.pow(i, 3) - TARGET_NUMBER);
            fitnessScores.put(i, fitnessFunction);
        }
        ////
        //System.out.println("FitnessScores: "+fitnessScores);
        // Convert HashMap to List of entries
        List<Map.Entry<Double,Double>> entrySet = new ArrayList<>(fitnessScores.entrySet());

        // Sort the list based on values
        Collections.sort(entrySet, new Comparator<Map.Entry<Double,Double>>() {
            public int compare(Map.Entry<Double,Double> entry1, Map.Entry<Double,Double> entry2) {
                return entry1.getValue().compareTo(entry2.getValue());
            }
        });
        /*System.out.println();
        // Display the sorted entries

        for (Map.Entry<Double,Double> entry : entrySet) {
            System.out.print(entry.getKey() + " : " + entry.getValue()+"    ");
        }*/
       // System.out.println();
        for (Map.Entry<Double,Double> entry : entrySet) {
            bestCandidate=entry.getKey();
            //System.out.println("Best candidate:"+entry.getKey() + " : " + entry.getValue());
            //System.out.println("Bestest Candidate: "+bestCandidate);
            break;
        }

        return bestCandidate;
    }

    public static double generationwise(Double [] generationArray)
    {
        HashMap<Double,Double> generationWiseBestCandidates = new HashMap<>();
        for (double i: generationArray) {
            fitnessFunction = Math.abs(Math.pow(i, 3) - TARGET_NUMBER);
            generationWiseBestCandidates.put(i, fitnessFunction);
        }
        List<Map.Entry<Double,Double>> entries = new ArrayList<>(generationWiseBestCandidates.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Double,Double>>() {
            public int compare(Map.Entry<Double,Double> entry1, Map.Entry<Double,Double> entry2) {
                return entry1.getValue().compareTo(entry2.getValue());
            }
        });
        /*
        for (Map.Entry<Double,Double> entry : entries) {
            System.out.print(entry.getKey() + " : " + entry.getValue()+"    ");
        }*/
        for (Map.Entry<Double,Double> entry : entries) {
            result=entry.getKey();
            ////
            //System.out.println("Best candidate from all generations:"+entry.getKey() + " : " + entry.getValue());
            //System.out.println("Bestest Candidate: "+bestCandidate);
            break;
        }
        return result;
    }

}

/*
* population----> (double,string)
* offspringPopulation----> (double,string)
* fitnessscores----------> (Double,Double)-----> i, ff
* HashMap<Double,Double> generationwise = new HashMap<>();
* */