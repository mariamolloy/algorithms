import java.util.Random;

public class Simulation {
    public populationList population;
    public int popSize;
    public double infectionRate;
    public double testAccuracy;
    public int groupSize;
    int testsUsed = 0;


    int case1Count = 0;
    int case2Count = 0;
    int case3Count = 0;

    String print = "";

    Simulation(){
    }

    public void init(int size){
        popSize =  size;
        infectionRate = 0.02;
        testAccuracy = 1.00;
        groupSize = 8;

        this.population = makePop();
    }

    //function to create a population list of a population of people
    public populationList makePop(){
        populationList newPop = new populationList();
        for (int i = 0; i < popSize; i++){
            populationList.addTo(newPop);
        }
        return newPop;
    }

    //function to set a percentage of the population to infected
    //basically a function to spread the virus, hence the name
    //called from Simulation class bc it needs to know the infection rate to know how many ppl to infect
    //param: rate = infection rate
    public  void goViral(){


        int[] infectedPpl = chooseInfected();
        populationList.infectPpl(population, infectedPpl);

        System.out.println("we gave them the rona");

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

      /*  for (int m = 0; m < pplInf.length; m++){
            System.out.println(pplInf[m]);
        }*/
        return pplInf;
    }

    public String testPop(){
        int numOfGroups = this.popSize / this.groupSize; //nned to add one to run a number where theres pop size not / by groupsize
        int groupCounter = 0;
        String print = "";

        //each time we run through this we make a new group
        //we shld run through this 125 times
        while((population.isEmpty()) && (groupCounter <= numOfGroups)){
            boolean case2or3 = false; //lets assume its case 1. it probably is
            populationList groupX = new populationList();

            for (int i = 0; i < groupSize; i++) {

                Person copyPerson = population.dequeue(); //it feels weird to say new when i named the variable person??
                this.testsUsed++;

                if (copyPerson.infected == true){
                    //we must find them!!
                    case2or3 = true;
                }
                groupX.enqueue(copyPerson.infected);

            }
            if (case2or3 == true){ //if its case 1 we dont have to test anymore, no one has it
                test(true, groupX); //where we do the real work
            } else {
                case1Count++;
            }
            }

            case2Count = case1Count - case3Count;
            print = (("Case(1): ") + numOfGroups + " x 0.85 -->" + " with " + case1Count + " tests used \n" +
                     "Case(2): " + numOfGroups + " x 0.1496 -->" +  " with " + case2Count + " tests used \n" +
                   " Case(3): " + numOfGroups + " x 0.0004 -->" + " with " + case3Count + " tests used \n" +
                    "---------------------------------------------------------------------------------------------------------------------------------------------------- \n" +
                    this.testsUsed + " tests for " + popSize + " people with an infection rate of " + (infectionRate * 100) + "% \n\n\n" +
                    "xoxo Gossip girl");

return print;    }

    //this is where we recurse
    public void test(boolean inf, populationList exposed){
        if (inf == true){
            populationList a = new populationList();
            boolean aInf = false;
            int howManyMoreTests = 0;
            populationList b = new populationList();
            boolean bInf = false;

            int grpSz = exposed.getSize(exposed);
            if (grpSz == 1){
                if(exposed.first.infected == true){
                    this.testsUsed++;
                }
            } else {
                for (int i = 0; i < grpSz; i++){
                    Person temp = exposed.dequeue(); //this just feels like this the office

                    if (temp.infected == true){
                        if (i < (i/2)){
                            a.enqueue(temp.infected);
                            aInf = true;
                        } else {
                            b.enqueue(temp.infected);
                            bInf = true;
                        }
                    } else {
                        if (i < (i/2)){
                            a.enqueue(temp.infected);
                        } else {
                            b.enqueue(temp.infected);
                        }
                    }

                }

            }

            if ((aInf == true) && (bInf == true)) {
                case3Count++;
                test(true, a);
                test(true, b);
            }else if (aInf == true){
                case3Count++;
                test(true, a);
            } else if (bInf == true){
                case3Count++;
                test(true, b);
            }
        }
    }

    //Runs the simulation
    //param pop is the population size we are running the simulation with
    public String runSim(int pop){
        this.init(pop);
        this.goViral();

        String print = "we did it! not rlly yet";
        return(this.testPop());
    }





}
