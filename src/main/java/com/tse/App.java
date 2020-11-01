package com.tse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class App {
    public static void main( String[] args ) {

        //Reading the csv file
        try(FileReader fileReader = new FileReader("ioFile.csv")){
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            AthletesList model = new AthletesList();

            while((line = bufferedReader.readLine()) != null){
                String sLine = line.replace(" ", "");
                String[] arr = sLine.split(",");
                if(arr.length == 7){
                    try{
                        Athlete newAthlete = new Athlete(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]);
                        model.addAthlete(newAthlete);
                    }catch (NullPointerException e){
                        System.out.println(e.getMessage() + " " + e.getCause());
                    }
                } else {
                    System.out.println("Something went wrong your file doesn`t contain all the data necessary!");
                }
            }

            model.listAthletes();
            System.out.println("-----------------------------------");
            model.calculateExtraTime();
            System.out.println("-------------------------------");
            model.listAthletes();
            List<Athlete> l = new ArrayList<>();
            l.addAll(model.getLi());
            Collections.sort(l, new ComparatorByTime());
            System.out.println("________________Sorted collection----------------------");
            for(Athlete a: l){
                System.out.println(a);
            }


            //And the winners are: ->
            for(int i=0;i<l.size();i++){
                if(l.indexOf(l.get(i)) == 0){
                    System.out.println("Winner is: " + l.get(i).getName() + " " + l.get(i).getTime());
                } else if(l.indexOf(l.get(i)) == 1){
                    System.out.println("Runner up is: " + l.get(i).getName() + " " + l.get(i).getTime());
                } else if(l.indexOf(l.get(i)) == 2){
                    System.out.println("Third place is: " + l.get(i).getName() + " " + l.get(i).getTime());
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
