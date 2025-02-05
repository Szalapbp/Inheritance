public class Worker extends Person
{
    double hourlyPayRate;

    @Override
    public String toString(){
        return "Worker{" + super.toString() + " hourlyPayRate=" + hourlyPayRate + "}";
    }

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public void setHourlyPayRate(double hourlyPayRate) {
        this.hourlyPayRate = hourlyPayRate;
    }



    public Worker(String ID, String firstName, String lastName, String title, int YOB, double hourlyPayRate)
    {
        super(ID, firstName, lastName, title, YOB);
        this.hourlyPayRate = hourlyPayRate;

    }

    public Worker(Person person, double hourlyPayRate){
        super(person.getID(),
                person.getFirstName(),
                person.getLastName(),
                person.getTitle(),
                person.getYOB());
        this.hourlyPayRate = hourlyPayRate;
    }

    public double calculateWeeklyPay(double hoursWorked){
        double regularHours = Math.min(hoursWorked, 40);
        double overtime = Math.max(hoursWorked - 40, 0);
        return (regularHours * hourlyPayRate) + (overtime * hourlyPayRate * 1.5);

    }

    public void displayWeeklyPay(double hoursWorked){

        double regularHours = Math.min(hoursWorked, 40);
        double overtime = Math.max(hoursWorked - 40, 0);
        double regularPay = regularHours * hourlyPayRate;
        double overtimePay = overtime * hourlyPayRate * 1.5;
        double totalPay = regularPay + overtimePay;

        System.out.printf("Regular Hours: %.2f - Regular Pay:$%.2f%n", regularHours, regularPay);
        System.out.printf("Overtime: %.2f - Overtime Pay:$%.2f%n", overtime, overtimePay);
        System.out.printf("Total Pay: $%.2f%n", totalPay);

    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + hourlyPayRate;
    }

    @Override
    public String toJSON() {
        return super.toJSON().replace("}", ",") +
                "\n \"HourlyPayRate\": " + hourlyPayRate + "\n" + "}";
    }

    @Override
    public String toXML() {
        return "<Worker>\n" +
                super.toXML().replace("</Person>", "") +
                "<HourlyPayRate>" + hourlyPayRate + "</HourlyPayRate>\n" +
                "</Worker>";
    }
}
