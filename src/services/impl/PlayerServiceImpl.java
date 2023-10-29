package services.impl;

import models.dao.Ship;
import models.dao.Wave;
import services.PlayerService;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerServiceImpl implements PlayerService {
    @Override
    public ArrayList<Object> addShipsToArea() {
        Scanner rr = new Scanner(System.in);

        Ship ship = new Ship();


        Wave wave = new Wave();


        ArrayList<Object> area = new ArrayList<>();
        ArrayList<Integer> dontRepeat = new ArrayList<>();

        for (int j = 0; j < 64; j++) {
            area.add(wave);
        }

        System.out.println("Where you want to add your ship");
        System.out.print("Add first ship: ");
        int firstShip = rr.nextInt() - 1;
        if (firstShip >= area.size() || firstShip < 0) {
            boolean isRight = true;
            while (isRight) {
                System.out.println("Please insert area between (1-64) ");
                firstShip = rr.nextInt() - 1;
                if (firstShip < area.size() && firstShip >= 0) {
                    isRight = false;
                }
            }
        }

        dontRepeat.add(firstShip);


        while (true) {
            System.out.print("Add second ship: ");
            int secondShip = rr.nextInt() - 1;
            if (secondShip != firstShip) {

                if (secondShip < area.size() && secondShip > 0) {
                    System.out.println("second ship added successfully");
                    dontRepeat.add(secondShip);
                    break;
                } else {
                    System.out.println("wrong input");
                }

            } else {
                System.out.println("Same location");
            }
        }

        while (true){
            System.out.print("Add third ship: ");
            int third = rr.nextInt()-1;

            if ( !dontRepeat.get(1).equals(third) && third != firstShip ){
                if (third < area.size() && third > 0) {
                    System.out.println("third ship added successfully");
                    dontRepeat.add(third);
                    break;
                } else {
                    System.out.println("wrong input");
                }


            }else {
                System.out.println("Same location");
            }
        }


        area.set(firstShip, ship);
        area.set(dontRepeat.get(1), ship);
        area.set(dontRepeat.get(2), ship);


        for (int j = 0, l = 0; j < 8; j++) {
            for (int k = 0; k < 8; k++) {
                System.out.print( area.get(l) + " ");
                l++;
            }
            System.out.println();
        }
        return area;
    }

    public  ArrayList<Object> addShipsToAreaWhenPlayPlayer() {
        Scanner rr = new Scanner(System.in);

        Ship ship = new Ship();


        Wave wave = new Wave();


        ArrayList<Object> area = new ArrayList<>();
        ArrayList<Integer> dontRepeat = new ArrayList<>();

        for (int j = 0; j < 64; j++) {
            area.add(wave);
        }

        System.out.println("Where you want to add your ship");
        System.out.print("Add first ship: ");
        int firstShip = rr.nextInt() - 1;
        if (firstShip >= area.size() || firstShip < 0) {
            boolean isRight = true;
            while (isRight) {
                System.out.println("Please insert area between (1-64) ");
                firstShip = rr.nextInt() - 1;
                if (firstShip < area.size() && firstShip >= 0) {
                    isRight = false;
                }
            }
        }

        dontRepeat.add(firstShip);


        while (true) {
            System.out.print("Add second ship: ");
            int secondShip = rr.nextInt() - 1;
            if (secondShip != firstShip) {

                if (secondShip < area.size() && secondShip > 0) {
                    System.out.println("second ship added successfully");
                    dontRepeat.add(secondShip);
                    break;
                } else {
                    System.out.println("wrong input");
                }

            } else {
                System.out.println("Same location");
            }
        }

        while (true){
            System.out.print("Add third ship: ");
            int third = rr.nextInt()-1;

            if ( !dontRepeat.get(1).equals(third) && third != firstShip ){
                if (third < area.size() && third > 0) {
                    System.out.println("third ship added successfully");
                    dontRepeat.add(third);
                    break;
                } else {
                    System.out.println("wrong input");
                }


            }else {
                System.out.println("Same location");
            }
        }


        area.set(firstShip, ship);
        area.set(dontRepeat.get(1), ship);
        area.set(dontRepeat.get(2), ship);



        return area;
    }

}
