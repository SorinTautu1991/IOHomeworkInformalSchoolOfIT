package com.tse;

public class Athlete {
    private String nr;
    private String name;
    private String countryCode;
    private String time;
    private String scoreOne;
    private String scoreTwo;
    private String scoreThree;

    public Athlete(String nr, String name, String countryCode, String time, String scoreOne, String scoreTwo, String scoreThree) throws NullPointerException {
        setNr(nr);
        setName(name);
        setCountryCode(countryCode);
        setTime(time);
        setScoreOne(scoreOne);
        setScoreTwo(scoreTwo);
        setScoreThree(scoreThree);

    }

    public void setNr(String nr) {
        if(nr.matches("^[\\d]+")){
            this.nr = nr;
        } else {
            throw new NullPointerException("Number cannot be empty!");
        }
    }

    public void setName(String name) {
        if(name == null || name.equals("")){
            throw new NullPointerException("Name cannot be empty!");
        }else {
            this.name = name;
        }
    }

    public void setCountryCode(String countryCode) {
        if(countryCode.matches("[A-Za-z]{2}")){
            this.countryCode = countryCode;
        }else {
            throw new NullPointerException("Country code must be exactly 2 characters and cannot be empty!");
        }
    }

    public void setTime(String time) {
        if(time.matches("[\\d]{2}[:][\\d]{1,2}")){
            this.time = time;
        }else {
            throw new NullPointerException("Time cannot be empty!");
        }
    }

    public void setScoreOne(String scoreOne) {
        if(scoreOne.matches("[xo]{5}")){
            this.scoreOne = scoreOne;
        }else {
            throw new NullPointerException("ScoreOne cannot be empty!");
        }
    }

    public void setScoreTwo(String scoreTwo) {
        if(scoreTwo.matches("[xo]{5}")){
            this.scoreTwo = scoreTwo;
        }else {
            throw new NullPointerException("ScoreTwo cannot be empty!");
        }
    }

    public void setScoreThree(String scoreThree) {
        if(scoreThree.matches("[xo]{5}")){
            this.scoreThree = scoreThree;
        }else {
            throw new NullPointerException("ScoreThree cannot be empty!");
        }
    }

    public String getNr() {
        return nr;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getTime() {
        return time;
    }

    public String getScoreOne() {
        return scoreOne;
    }

    public String getScoreTwo() {
        return scoreTwo;
    }

    public String getScoreThree() {
        return scoreThree;
    }

    @Override
    public String toString() {
        return "com.tse.Athlete =>" +
                "nr='" + nr + '\'' +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", time='" + time + '\'' +
                ", scoreOne='" + scoreOne + '\'' +
                ", scoreTwo='" + scoreTwo + '\'' +
                ", scoreThree='" + scoreThree + '\'';
    }
}
