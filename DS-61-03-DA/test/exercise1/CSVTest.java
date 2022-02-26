package exercise1;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author ivan.garcia.fernandez
 * @author daniel.quintillan
 */
public class CSVTest {

    public CSVTest() {
    }

    /**
     * Test of getState method, of class CSVStateBasedAnalyzer. It tests that
     * the default state is Start
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        CSVStateBasedAnalyzer instance = new CSVStateBasedAnalyzer();
        CSVState expResult = Start.instance();
        CSVState result = instance.getState();
        assertEquals(expResult, result);
    }

    /**
     * Test of setState method, of class CSVStateBasedAnalyzer. Sets a state
     * different from start and then it tests that it has changed
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        CSVStateBasedAnalyzer csv = new CSVStateBasedAnalyzer();
        csv.setState(ReadingCharacters.instance());
        assertEquals(ReadingCharacters.instance(), csv.getState());
    }

    @Test
    public void testSingleWordRead() {
        String input = "\"Country\"";
        List<Field> output = new ArrayList<>();
        output.add(new StringField("Country"));
        CSVStateBasedAnalyzer instance = new CSVStateBasedAnalyzer();
        assertEquals(output.get(0).getValue(), instance.read(input).get(0).getValue());

    }

    @Test
    public void testDoubleWordRead() {
        String input = "\"Country\",\"Roads\"";
        List<Field> output = new ArrayList<>();
        output.add(new StringField("Country"));
        output.add(new StringField("Roads"));
        CSVStateBasedAnalyzer instance = new CSVStateBasedAnalyzer();
        assertEquals(output.get(0).getValue(), instance.read(input).get(0).getValue());
        assertEquals(output.get(1).getValue(), instance.read(input).get(1).getValue());

    }

    @Test
    public void testSingleNumberRead() {
        String input = "123456";
        List<Field> output = new ArrayList<>();
        output.add(new NumberField(123456));
        CSVStateBasedAnalyzer instance = new CSVStateBasedAnalyzer();
        assertEquals(output.get(0).getValue(), instance.read(input).get(0).getValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCSV() {
        String input = "123m456";
        CSVStateBasedAnalyzer instance = new CSVStateBasedAnalyzer();
        instance.read(input);
    }

    @Test
    public void testDoubleNumberRead() {
        String input = "123456,7890";
        List<Field> output = new ArrayList<>();
        output.add(new NumberField(123456));
        output.add(new NumberField(7890));
        CSVStateBasedAnalyzer instance = new CSVStateBasedAnalyzer();
        assertEquals(output.get(0).getValue(), instance.read(input).get(0).getValue());
        assertEquals(output.get(1).getValue(), instance.read(input).get(1).getValue());
    }

    /**
     * Test of read method, of class CSVStateBasedAnalyzer.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        String input = "\"Country\",\"Area\",\"Capital\",\"Population\"\n"
                + "\"Spain\",504645,\"Madrid\",46439864\n"
                + "\"Portugal\",92391,\"Lisbon\",10562178\n"
                + "\"France\",675417,\"Paris\",66952000\n";
        System.out.println(input);
        System.out.println(input.charAt(139));
        List<Field> output = new ArrayList<>();
        output.add(new StringField("Country"));
        output.add(new StringField("Area"));
        output.add(new StringField("Capital"));
        output.add(new StringField("Population"));
        output.add(new StringField("Spain"));
        output.add(new NumberField(504645));
        output.add(new StringField("Madrid"));
        output.add(new NumberField(46439864));
        output.add(new StringField("Portugal"));
        output.add(new NumberField(92391));
        output.add(new StringField("Lisbon"));
        output.add(new NumberField(10562178));
        output.add(new StringField("France"));
        output.add(new NumberField(675417));
        output.add(new StringField("Paris"));
        output.add(new NumberField(66952000));

        CSVStateBasedAnalyzer instance = new CSVStateBasedAnalyzer();
        output = instance.read(input);
        assertEquals(output.size(), output.size());
        for (int i = 0; i < output.size(); i++) {
            assertEquals(output.get(i).getValue(), output.get(i).getValue());

        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCharacterRead() {
        System.out.println("read");
        String input = "\"Country";
        CSVStateBasedAnalyzer instance = new CSVStateBasedAnalyzer();
        instance.read(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCharacterRead2() {
        System.out.println("read");
        String input = "\"Country\n 582";
        CSVStateBasedAnalyzer instance = new CSVStateBasedAnalyzer();
        instance.read(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidStart() {
        System.out.println("read");
        String input = "m";
        CSVStateBasedAnalyzer instance = new CSVStateBasedAnalyzer();
        instance.read(input);
    }
}
