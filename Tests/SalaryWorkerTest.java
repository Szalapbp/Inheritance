import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SalaryWorkerTest {
    private SalaryWorker salaryWorker;

    @BeforeEach
    void setUp() {
        salaryWorker = new SalaryWorker("000001", "Blake", "Szalapski",
                "Mr.", 2002, 18.0, 37440.0);
    }

    @Test
    void getAnnualSalary() {
        assertEquals(37440.0, salaryWorker.getAnnualSalary());
    }

    @Test
    void setAnnualSalary() {
        salaryWorker.setAnnualSalary(50000.0);
        assertEquals(50000.0, salaryWorker.getAnnualSalary());
    }

    @Test
    void calculateWeeklyPay() {
        assertEquals(720.0, salaryWorker.calculateWeeklyPay(40));
        assertEquals(720.0, salaryWorker.calculateWeeklyPay(60));
    }

    @Test
    void displayWeeklyPay() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        salaryWorker.displayWeeklyPay(40);

        String expected = "Salary Worker Weekly Pay: $720.00 (Annual Salary: $37440.00)";


    }

    @Test
    void toCSV() {
        assertEquals("000001,Blake,Szalapski,Mr.,2002,18.0,37440.0", salaryWorker.toCSV());
    }

    @Test
    void toXML() {
        String expectedXML = "<SalaryWorker>\n" +
                "    <Worker>\n" + "<Person>\n" +
                "    <ID>000001</ID>\n" +
                "    <FirstName>Blake</FirstName>\n" +
                "    <LastName>Szalapski</LastName>\n" +
                "    <Title>Mr.</Title>\n" +
                "    <YOB>2002</YOB>\n" +
                "<HourlyPayRate>18.0</HourlyPayRate>\n" +
                "</Worker>\n" +
                "    <AnnualSalary>37440.0</AnnualSalary>\n" +
                "</SalaryWorker>";
        assertEquals(expectedXML, salaryWorker.toXML());
    }

    @Test
    void toJSON() {
        String expectedJSON = "{\n" +
                "  \"ID\": \"000001\",\n" +
                "  \"FirstName\": \"Blake\",\n" +
                "  \"LastName\": \"Szalapski\",\n" +
                "  \"Title\": \"Mr.\",\n" +
                "  \"YOB\": 2002\n" + ",\n" +
                " \"HourlyPayRate\": 18.0\n" + ",\n" +
                "  \"AnnualSalary\": 37440.0\n" +
                "}";
        assertEquals(expectedJSON, salaryWorker.toJSON());
    }

    @Test
    void testToString() {
        assertEquals("SalaryWorker{Worker{000001, Blake, Szalapski, Mr., " +
                "2002 hourlyPayRate=18.0} annualSalary=37440.0}", salaryWorker.toString());

    }
}