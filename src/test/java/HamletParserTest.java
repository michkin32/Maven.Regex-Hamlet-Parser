import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        HamletParser hamletParser = new HamletParser();

        Pattern p = Pattern.compile("Hamlet");
        hamletParser.ChangeHamletToLeon();
        Matcher m = p.matcher(hamletParser.getHamletData());

        Assert.assertFalse(m.find());

    }

    @Test
    public void testChangeHoratioToTariq() {
        HamletParser hamletParser = new HamletParser();

        Pattern p = Pattern.compile("Horatio");
        hamletParser.ChangeHoratioToTariq();
        Matcher m = p.matcher(hamletParser.getHamletData());

        Assert.assertFalse(m.find());
    }

    @Test
    public void testFindHoratio() {
        HamletParser hamletParser = new HamletParser();



        Assert.assertTrue(hamletParser.findHoratio());
    }

    @Test
    public void testFindHamlet() {
        HamletParser hamletParser = new HamletParser();



        Assert.assertTrue(hamletParser.findHamlet());

    }
}