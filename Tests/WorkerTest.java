import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {
    private Worker worker;

    @BeforeEach
    void setUp() {
        worker = new Worker("000001", "Blake",
                "Szalapski", "Mr.", 2002, 18.0);
    }

    @Test
    void testToString() {
        assertEquals("Worker{000001, Blake, Szalapski, Mr., 2002 hourlyPayRate=18.0}", worker.toString());
    }

    @Test
    void getHourlyPayRate() {
        assertEquals(18.0, worker.getHourlyPayRate());
    }

    @Test
    void setHourlyPayRate() {
        worker.setHourlyPayRate(20.0);
        assertEquals(20.0, worker.getHourlyPayRate());
    }

    @Test
    void calculateWeeklyPay() {
        assertEquals(720, worker.calculateWeeklyPay(40));

    }

    @Test
    void calculateWeeklyPayWithOT(){
        assertEquals(855, worker.calculateWeeklyPay(45));
    }

    @Test
    void displayWeeklyPay() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        worker.displayWeeklyPay(45);
        String expected = "Regular Hours: 40.00 - Regular Pay: $720.00\n" +
                "Overtime: 5.00 - Overtime Pay: $135.00\n" + "Total Pay: $855.00\n";

    }

    @Test
    void toCSV() {
        assertEquals("000001,Blake,Szalapski,Mr.,2002,18.0", worker.toCSV());
    }

    @Test
    void toJSON() {
        String expectedJSON = "{\n" +
                "  \"ID\": \"000001\",\n" +
                "  \"FirstName\": \"Blake\",\n" +
                "  \"LastName\": \"Szalapski\",\n" +
                "  \"Title\": \"Mr.\",\n" +
                "  \"YOB\": 2002\n" + ",\n" +
                " \"HourlyPayRate\": 18.0\n" +
                "}";
        assertEquals(expectedJSON, worker.toJSON());
    }

    @Test
    void toXML() {
        String expectedXML = "<Worker>\n" + "<Person>\n" +
                "    <ID>000001</ID>\n" +
                "    <FirstName>Blake</FirstName>\n" +
                "    <LastName>Szalapski</LastName>\n" +
                "    <Title>Mr.</Title>\n" +
                "    <YOB>2002</YOB>\n" +
                "<HourlyPayRate>18.0</HourlyPayRate>\n" +
                "</Worker>";
        assertEquals(expectedXML, worker.toXML());

    }
}