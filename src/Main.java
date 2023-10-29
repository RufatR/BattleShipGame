import models.dao.Ship;
import services.ComputerService;
import services.impl.ComputerNpcServiceImpl;
import services.impl.ManagmentService;
import utils.MenuUtil;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {

ManagmentService.startGame();

//  ManagmentService.startGameWithComp();

//        if (secondShip >= area.size() || secondShip < 0) {
//            boolean isRight = true;
//            while (isRight) {
//                System.out.println("Please insert area between (1-64) ");
//                secondShip = rr.nextInt() - 1;
//                if (secondShip <= area.size() && secondShip >= 0){
//                    isRight =false;
//                }
//            }
//        }
//
//
//        if (dontRepeat.get(0).equals(secondShip)) {
//            boolean isRight = true;
//            while (isRight) {
//                System.out.println("You cant add your ship to the same area!Please located to the different area");
//                secondShip = rr.nextInt() - 1;
//
//
//
//                if (!dontRepeat.get(0).equals(secondShip)) {
//                    dontRepeat.set(1, secondShip);
//                    isRight = false;
//                }
//
//            }
//        }







//        ManagmentService.startGameWithComp();
//        ComputerService computerService = new ComputerNpcServiceImpl();
//
//        Scanner rr = new Scanner(System.in);
//        Ship ship = new Ship();
//
//        ArrayList<Object> arrayLists1 = computerService.addShipsForNpc();
//
//        for (int j = 0, l = 0; j < 8; j++) {
//            for (int k = 0; k < 8; k++) {
//                System.out.print("[ " + arrayLists1.get(l) + " ]" + " ");
//                l++;
//            }
//            System.out.println();
//        }
//        String[] strings = MenuUtil.creatMenuArr();
//        while (true){
//            System.out.println("");
//    System.out.print("Choose area: ");
//    int i = rr.nextInt() - 1;
//
//
//    Object objects = arrayLists1.get(i);
//    System.out.println(objects);
//
//
//    System.out.println(ship);
//    if (objects instanceof Ship) {
//        System.out.println("You found enemies ship ");
//        MenuUtil.printMenuForShip(strings,i);
//
//    } else {
//        System.out.println("You entered wrong area");
//        MenuUtil.printMenuForWrong(strings,i);
//
//
//    }
}



    }
