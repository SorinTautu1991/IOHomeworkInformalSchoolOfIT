package com.tse;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

public class AthletesList {
    private List<Athlete> li;

    public AthletesList() {
        this.li = new ArrayList<>();
    }

    public void addAthlete(Athlete a){
        li.add(a);
    }
    public void listAthletes(){
        for(Athlete a: li){
            System.out.println(a);
        }
    }

    public void calculateExtraTime(){
        for(Athlete a: li){
            // Getting the amount of seconds we need to add to the current time of the athlete
            int extraTimeInSeconds = extraTime(a.getScoreOne()) + extraTime(a.getScoreTwo()) + extraTime(a.getScoreThree());
            String time = a.getTime();
            String newTime = addTimeToActualTime(time, extraTimeInSeconds);
            System.out.println(newTime);
            a.setTime(newTime);
        }
    }

    //Adding the seconds to the time of the athlete
    private String addTimeToActualTime(String currentTime, int extraSeconds)  {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("mm:ss");
        DateTime dt = formatter.parseDateTime(currentTime);
        int sec = dt.secondOfDay().get() + extraSeconds;
        int min = dt.minuteOfDay().get();
        int newMin = sec/60;
        int newSec = sec%60;
        return String.valueOf(newMin) + ":" + String.valueOf(newSec);
    }


    //Calculating the amount of seconds needs to be added to the athletes
    private int extraTime(String score){
        int count = 0;
        for(int i=0;i<score.length();i++){
            if(score.charAt(i) == 'o'){
                count+=10;
            }
        }
        return count;
    }

    public List<Athlete> getLi() {
        return li;
    }

}
