public class Main {
    public static void main (String[] args){
        System.out.println("hi world");
        Simulation missRona = new Simulation(1000);
        missRona.goViral();
        System.out.println("bye world");
    }
}
