import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Worker> workers = new ArrayList<>();

        Worker blake = new Worker("000001", "Blake", "Szalapski", "Mr.", 2002, 18.0);
        workers.add(blake);

        Worker john = new Worker("000002", "John", "Doe", "Mr.", 1993, 33.0);
        workers.add(john);

        Worker jane = new Worker("000003", "Jane", "Doe", "Ms.", 1988, 25.0);
        workers.add(jane);

        Worker jeff = new SalaryWorker("000004", "Jeffrey", "Jones",
                "Mr.", 1941, 35.0, 72800.0);
        workers.add(jeff);

        Worker jimmy = new SalaryWorker("000005", "Jimmy", "Johnson",
                "Mr.", 2000, 17.0, 35360.0);
        workers.add(jimmy);

        Worker abigail = new SalaryWorker("000006", "Abigail", "Smith",
                "Ms.", 2003, 20.0, 41600.0);
        workers.add(abigail);


        int[] weeklyHours = {40,50,40};

        System.out.println("\nEmployee Weekly Pay Report");
        System.out.println("---------------------------------------------------");
        System.out.printf("%-15s %-10s %-10s %-10s%n", "Name", "Week 1", "Week 2", "Week 3");
        System.out.println("---------------------------------------------------");

        for (Worker worker : workers) {
            System.out.printf("%-15s", worker.getFullName());
            for (int hours : weeklyHours) {
                double weeklyPay = worker.calculateWeeklyPay(hours);
                System.out.printf(" $%-9.2f", weeklyPay);
            }
            System.out.println();









    }

}
}
