import java.util.Random;

public class Simulation {
    public populationList population;
    public int popSize;
    public double infectionRate;
    public double testAccuracy;
    public int groupSize;

    Simulation(int s){
        popSize =  s;
        infectionRate = 0.02;
        testAccuracy = 1.00;
        groupSize = 8;

        this.population = makePop();
    }

    //function to create a population list of a population of people
    public populationList makePop(){
        populationList newPop = new populationList();
        for (int i = 0; i < popSize; i++){
            newPop.addTo(newPop);
        }
        return newPop;
    }

    //function to set a percentage of the population to infected
    //basically a function to spread the virus, hence the name
    //called from Simulation class bc it needs to know the infection rate to know how many ppl to infect
    //param: rate = infection rate
    public  void goViral(){

        int[] infectedPpl = chooseInfected();
        population.infectPpl(population, infectedPpl);

    }

    //helper function that returns a sorted array of the indices of the people who are infected
    public int[] chooseInfected(){
        //find # of infected ppl per infection rate w this pop size
        int amtPplInfected = (int)(popSize * infectionRate);
        int[] pplInf = new int[amtPplInfected];

        int[] indices = new int[population.getSize(population)];
        Person last = population.first;
        int counter = 0;
        while (last.pointer != null){
            indices[counter] = last.index;
            last = last.pointer;
            counter++;
        }
        //for each person infected, find a random index
        for(int i = 0; i < pplInf.length; i++){
            Random rand = new Random();
            //generate random values from 0 - max population size
            int randomInf = rand.nextInt(popSize);
            if (indices[randomInf] == -1){
                while(indices[randomInf] == -1){
                    Random rando = new Random();
                    //generate random values from 0 - max population size
                    randomInf = rando.nextInt(popSize);
                }
                pplInf[i] = randomInf;
                indices[randomInf] = -1; //means this one was already chosen
            } else {
                pplInf[i] = randomInf;
                indices[randomInf] = -1; //means this one was already chosen
            }
        }

        //lets sort this to make our lives a little easier //we have the code why not
        Sort s = new Sort(pplInf);
        s.quickSort(0, pplInf.length - 1);
        pplInf = s.arr;

        return pplInf;
    }

    public void testPop(){

    }

    public void test(){}





}
