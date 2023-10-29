package utils;

import models.Player;

public class MenuUtil {

    public static String[] creatMenuArr(Player player) {
        String arr[] = new String[64];

        for (int i = 0; i < 64; i++) {
            arr[i] = "[ ~~ ]";
        }
        return arr;
    }

    public static void printMenu(String[] arr, Player player) {
        System.out.println("(======" +player.getName()+ "'s area" + "======)");
        System.out.println(" ~~~~~~~~~~~~ ");
        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i] + " ");


            if (i == 7 || i == 15 || i == 23 || i == 31 || i == 39 || i == 47 || i == 55) {
                System.out.println("");

            }

        }
        System.out.println("");
        System.out.println("(============)");
        System.out.println(" ~~~~~~~~~~~~ ");
    }

    public static void printMenuForWrong(String[] arr, int n) {

        System.out.println("======= Comp's area ======");

        arr[n] = "[ " + "X" + " ]";

        for (int i = 0; i < 64; i++) {


            System.out.print(arr[i]);

            if (i == 7 || i == 15 || i == 23 || i == 31 || i == 39 || i == 47 || i == 55) {
                System.out.println("");

            }

        }
        System.out.println("");
        System.out.println("=========================");



    }
    public static void printMenuForWrongWhenYouPLayFriend(String[] arr, int n,Player player) {

        System.out.println("======= "+player.getName() + "'s area"+" ======");

        arr[n] = "[ " + "X" + " ]";

        for (int i = 0; i < 64; i++) {


            System.out.print(arr[i]);

            if (i == 7 || i == 15 || i == 23 || i == 31 || i == 39 || i == 47 || i == 55) {
                System.out.println("");

            }

        }
        System.out.println("");
        System.out.println("=========================");



    }

    public static void printMenuForShip(String[]arr ,int n) {
        arr[n] = "[ " + "B.O.M.B" + " ]";

        for (int i = 0; i < 64; i++) {


            System.out.print(arr[i]);

            if (i == 7 || i == 15 || i == 23 || i == 31 || i == 39 || i == 47 || i == 55) {
                System.out.println("");

            }

        }
    }


}
