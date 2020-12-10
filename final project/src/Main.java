public class Main {
    public static void main (String[] args){
        Simulation missRona = new Simulation();
        System.out.print(missRona.runSim(1000));
        System.out.print(missRona.runSim(10000));
        //System.out.print(missRona.runSim(100000));
        //System.out.print(missRona.runSim(1000000));
    }
}
