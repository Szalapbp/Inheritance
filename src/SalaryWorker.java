public class SalaryWorker extends Worker{

    public double annualSalary;

    public SalaryWorker(String ID, String firstName, String lastName, String title, int YOB, double hourlyPayRate, double annualSalary) {

        super(ID, firstName, lastName, title, YOB, hourlyPayRate);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }
    @Override
    public double calculateWeeklyPay(double hoursWorked){
        return annualSalary / 52;
    }

    @Override
    public void displayWeeklyPay(double hoursWorked){
        System.out.printf("Salary Worker Weekly Pay: $%.2f (Annual Salary: $%.2f)%n", calculateWeeklyPay(hoursWorked), annualSalary);

    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + annualSalary;
    }

    @Override
    public String toXML() {
        return "<SalaryWorker>\n" +
                "    " + super.toXML() + "\n" +
                "    <AnnualSalary>" + annualSalary + "</AnnualSalary>\n" +
                "</SalaryWorker>";
    }

    @Override
    public String toJSON() {
        return super.toJSON().replace("}", "") + ",\n" +
                "  \"AnnualSalary\": " + annualSalary + "\n" +
                "}";
    }

    @Override
    public String toString() {
        return "SalaryWorker{" + super.toString() + " annualSalary=" + annualSalary + "}";
    }
}
