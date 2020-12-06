import java.util.Random;

public class Simulation {
    public populationList population;
    public int popSize;
    public double infectionRate;
    public double testAccuracy;
    public int groupSize;

    Simulation(populationList pop){
        this.population = pop;
        popSize =  1000;
        infectionRate = 0.02;
        testAccuracy = 1.00;
        groupSize = 8;
    }

    public void setPop(){
        for (int i = 0; i < popSize; i++){

        }
    }

    //function to set a percentage of the population to infected
    //called from Simulation class bc it needs to know the infection rate to know how many ppl to infect
    //param: rate = infection rate
    public  populationList goViral(populationList p){
        int[] infectedPpl = chooseInfected();
        int index = 1;
        Person last = p.first;
        if (last.index == infectedPpl[0]){

        } else {
            //go through the list
            while (last.pointer != null){
                for (int i = 0; i < infectedPpl.length; i++){
                    if (last.index == infectedPpl[i]){

                    }
                }
            }
        }
        //go through the list
        while (last.pointer != null){
            for (int i = 0; i < infectedPpl.length; i++){
                if (last.index == infectedPpl[i]){

                }
            }
        }
    }

    public int[] chooseInfected(){
        //find # of infected ppl per infection rate w this pop size
        int amtPplInfected = (int)(popSize * infectionRate);
        int[] pplInf = new int[amtPplInfected];

        int[] indices = new int[population.getSize(population)];
        Person last = population.first;
        int counter = 0;
        while (last.pointer != null){
            indices[counter] = last.index;
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
            } else {
                pplInf[i] = randomInf;
                indices[randomInf] = -1; //means this one was already chosen
            }
        }

        //lets sort this to make our lives a little easier //we have the code why not
        Sort s = new Sort(pplInf);
        s.quickSort(0, pplInf.length);
        pplInf = s.arr;

        return pplInf;
    }





}
