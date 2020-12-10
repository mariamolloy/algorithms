import java.util.Random;

public class Simulation {
    public populationList population;
    public int popSize;
    public double infectionRate;
    public double testAccuracy;
    public int groupSize;

    int totalTestsUsed = 0; //total tests we use
    int testCounter = 0;
    int totalSick = 0; //total amount of infected people we find //should = popSize * infectionRate (20 in this case)


    //counter to keep track of how many instances of each case in a sim run
    int case1Count = 0;
    int case2Count = 0;
    int case3Count = 0;

    //counter to keep track of how many tests are used per case
    //when sim is done the sum of these three ints should = totalTestsUsed
    int case1Tests = 0;
    int case2Tests = 0;
    int case3Tests = 0;

    String print = "";

    Simulation(){
    }

    //function to reset a simulation w a new population size
    //param size = population sample size
    public void init(int size){
        popSize =  size;
        infectionRate = 0.02;
        testAccuracy = 1.00;
        groupSize = 8;

        this.population = makePop();

        this.totalSick = 0;
        this.totalTestsUsed =0;

        //counter to keep track of how many instances of each case in a sim run
        int case1Count = 0;
        int case2Count = 0;
        int case3Count = 0;

        //counter to keep track of how many tests are used per case
        //when sim is done the sum of these three ints should = totalTestsUsed
        int case1Tests = 0;
        int case2Tests = 0;
        int case3Tests = 0;
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
    public  void goViral(){

        int[] infectedPpl = chooseInfected();
        populationList.infectPpl(population, infectedPpl);

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

    //function called to break a population into groups of 8 and call the recursive test() function
    //returns our output to print
    public String testPop(){
        int numOfGroups = this.popSize / this.groupSize; //nned to add one to run a number where theres pop size not / by groupsize
        int groupCounter = 0;
        String print = "";

        //each time we run through this we make a new group
        //we shld run through this 125 times
        while(!(population.isEmpty()) && (groupCounter <= numOfGroups)){
            boolean case2or3 = false; //lets assume its case 1. it probably is
            this.testCounter = 0; //reset

            populationList groupX = new populationList();

            //add groupSize(8) people to groupX
            for (int i = 0; i < groupSize; i++) {

                Person copyPerson = population.dequeue(); //it feels weird to say new when i named the variable person??

                if (copyPerson.infected == true){
                    //we must find them!!
                    case2or3 = true; //theres someone infected
                    this.testCounter++; //number of inf people in this group goes up by 1
                }
                groupX.enqueue(copyPerson.infected);
            }

            if (this.testCounter == 0){
                this.case1Count++;
            } else if (this.testCounter == 1){
                this.case2Count++;
            } else {
                this.case3Count++;
                testCounter = 2; //if its greater than 2 just so we know its case 3
            }

            this.test(case2or3, groupX, (testCounter + 1));
        }

        case2Tests = totalTestsUsed - case1Tests - case3Tests;
        if (case1Tests + case2Tests + case3Tests != totalTestsUsed){
            System.out.println("uh oh we messed up with the test count");
        }
        print = (("Case(1): ") + numOfGroups + " x 0.85 --> " +  case1Count + " instances with "+ case1Tests +" tests used \n" +
                     "Case(2): " + numOfGroups + " x 0.1496 --> " +  case2Count + " instances with " + case2Tests +" tests used \n" +
                   "Case(3): " + numOfGroups + " x 0.0004 --> " + case3Count + " instances with " + case3Tests + " tests used \n" +
                    "---------------------------------------------------------------------------------------------------------------------------------------------------- \n" +
                    this.totalTestsUsed + " tests found " + totalSick + " infected people in a population of " + popSize + " people with an infection rate of " + (infectionRate * 100) + "% \n\n\n" );
            return print;
    }

    //this is where we recurse
    //function to divide groups in half and test them for the virus
    //param : inf = infected?? if the pool has tested positive and needs to be subdivided
    //param : exposed = list of people we are testing
    //param : caseNum = is this a case 1, case 2, or case 3 situation???
    public void test(boolean inf, populationList exposed, int caseNum){
        this.totalTestsUsed++;
        switch(caseNum){
            case 1:
                this.case1Tests++;
                break;
            case 2:
                this.case2Tests++;
                break;
            case 3:
                this.case3Tests++;
                break;
        }
        if (inf == true){
            this.totalTestsUsed++;
            populationList a = new populationList();
            boolean aInf = false;

            populationList b = new populationList();
            boolean bInf = false;

            int grpSz = exposed.getSize(exposed);

            //we cant recurse any longer
            if (grpSz == 2){
                for (int i = 0; i < 2;i ++){
                    Person temp = exposed.dequeue();
                    if (temp.infected == true){
                        this.totalSick++; //we found the person making the group test positive
                    }
                }
            } else {
                //go through list half by half
                for (int i = 0; i < grpSz / 2; i++){
                    Person temp = exposed.dequeue(); //this just feels like this the office
                    if (temp.infected == true){
                        aInf = true;
                    }
                    a.enqueue(temp.infected);
                }
                for (int j = 0; j < grpSz / 2; j++){
                    Person temp = exposed.dequeue(); //this just feels like this the office
                    if (temp.infected == true){
                        bInf = true;
                    }
                    b.enqueue(temp.infected);
                }

                //no matter what just test both
                test(aInf, a, caseNum);
                test(bInf, b, caseNum);
            }

        } //else : do nothing no infection = were done
    }

    //Runs the simulation
    //returns an output string to print
    //param pop is the population size we are running the simulation with
    public String runSim(int pop){

        this.init(pop);
        this.goViral();

        return(this.testPop());
    }





}
