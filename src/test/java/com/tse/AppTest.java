package com.tse;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppTest {
    public static AthletesList model = new AthletesList();


    @Test
    public void loadFile() {
        boolean succes = false;

        //Reading the csv file
        try (FileReader fileReader = new FileReader("ioFile.csv")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";


            while ((line = bufferedReader.readLine()) != null) {
                String sLine = line.replace(" ", "");
                String[] arr = sLine.split(",");
                if (arr.length == 7) {
                    try {
                        Athlete newAthlete = new Athlete(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]);
                        model.addAthlete(newAthlete);
                        succes = true;
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage() + " " + e.getCause());
                    }
                } else {
                    System.out.println("Something went wrong your file doesn`t contain all the data necessary!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(succes, true);
    }


    @Test
    public void calculateTheTimeForPlayer() {
        model.calculateExtraTime();
        String theCorrectTimeThePlayerShouldHave = "25:54";
        for(int i=0;i<model.getLi().size();i++){
            Athlete first = model.getLi().get(0);
            assertEquals(theCorrectTimeThePlayerShouldHave, first);
        }
    }

    @Test
    public void testWinners(){
        List<Athlete> l = new ArrayList<>();
        l.addAll(model.getLi());
        Collections.sort(l, new ComparatorByTime());
        for(int i=0;i<l.size();i++){
            if(l.indexOf(l.get(i)) == 0){
                assertEquals("JohnDoe7", l.get(i).getName());
            }
        }
    }

    //Test the regex that matches the input nr
    @Test
    public void inputNr(){
        String nr = "23";
        assertTrue(nr.matches("^[\\d]+"));
    }


    //Test for case input is not valid
    @Test
    public void inputNr2(){
        String nr = "234LSSMD";
        assertFalse(nr.matches("^[\\d]+"));
    }


    @Test
    public void setName(){
        String name = "John Doe1";
        assertNotNull(name);
    }

    @Test
    public void setNameTwoNull(){
        String name = null;
        assertNull(name);
    }

    @Test(expected = NullPointerException.class)
    public void setNameThreeEmpty(){
        String name = "";
        Athlete athlete = new Athlete("1", "", "RO", "25:45", "xxxoo", "oooxx", "xxxxx");
    }


    @Test
    public void setCountryCode(){
        String countryCode = "RO";
        assertTrue(countryCode.matches("[A-Za-z]{2}"));
    }


    @Test
    public void countryCodeFail(){
        String countryCode = "ROOO";
        assertFalse(countryCode.matches("[A-Za-z]{2}"));
    }


    @Test
    public void setTime(){
        String time = "25:49";
        assertTrue(time.matches("[\\d]{2}[:][\\d]{1,2}"));
    }

    @Test
    public void setTimeNotWorking(){
        String time = "2567:34";
        assertFalse(time.matches("[\\d]{2}[:][\\d]{1,2}"));
    }


    @Test
    public void setScores(){
        String score = "xxoxx";
        assertTrue(score.matches("[xo]{5}"));
    }

    @Test
    public void setScoreFail(){
        String score = "xxxxxxxxxxxx";
        assertFalse(score.matches("[xo]{5}"));
    }


}