package services.impl;

import models.Player;
import models.dao.Ship;
import services.ComputerService;
import services.PlayerService;
import utils.MenuUtil;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class ManagmentService {

    public static void startGame() {
        Player player1 = new Player();
        Player player2 = new Player();
        Scanner rr = new Scanner(System.in);
        System.out.println("========== Welcome to Battle Ship ==========");
        System.out.println("[ 1 ]. Play with Computer" + "\n" +
                "[ 2 ]. Play with your friend" + "\n" +
                "[ 3 ]. Exit" + "\n" + "============================================");

        System.out.print("Please choose which one do you want: ");
        int options = rr.nextInt();

        switch (options) {
            case 1:
                rr.nextLine();
                System.out.print("Please enter your name : ");
                String name = rr.nextLine();
                player1.setName(name);
                startGameWithComp(player1);
                break;
            case 2:
                rr.nextLine();
                System.out.print("Player 1 please enter your name: ");
                String player1Name = rr.nextLine();
                player1.setName(player1Name);
                System.out.print("Player 2 please enter your name: ");
                String player2Name = rr.nextLine();
                player2.setName(player2Name);
                startGameWithFriend(player1,player2);
                break;
            case 3:
                System.out.println("Good Bye");
                System.exit(0);
                break;
            default:
                System.out.println("Wrong input");
        }


    }

    public static void startGameWithFriend(Player player1 ,Player player2 ){
        Scanner rr = new Scanner(System.in);
        String[] player1Menu = MenuUtil.creatMenuArr(player1);
        String[] player2Menu = MenuUtil.creatMenuArr(player2);

        System.out.println(player1.getName() +" , please located your ships to the area");
        PlayerServiceImpl playerService1 = new PlayerServiceImpl();
        ArrayList<Object> players1Area = playerService1.addShipsToAreaWhenPlayPlayer();

        System.out.println("=======================================================");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("=======================================================");




        System.out.println(player2.getName()+" , please located your ships to the area");
        PlayerServiceImpl playerService2 = new PlayerServiceImpl();
        ArrayList<Object> player2Area = playerService2.addShipsToAreaWhenPlayPlayer();

        System.out.println("=======================================================");

        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.println("Game start!");
        for (int i = 1; i <= 3; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (i == 3) {
                System.out.println("Start");
            }
        }

        ArrayList<Integer> dontRepeatForPlayer1 = new ArrayList<>();
        ArrayList<Integer> dontRepeatForPlayer2 = new ArrayList<>();


        int player1FindShip = 0;
        int player2FindShip = 0;

        LocalTime start = LocalTime.now();
        while (true){
            while (true) {
                MenuUtil.printMenu(player2Menu,player2);

                System.out.println("Please choose area from "+  player2.getName() + " to shoot " + player2.getName()+"'s ship");
                int shoot = rr.nextInt() - 1;


                if (shoot > player2Area.size() || shoot < 0) {
                    System.out.println(player1.getName() + " you have to insert between (1-64)");
                    continue;
                }
                if (dontRepeatForPlayer1.contains(shoot)) {
                    System.out.println(player1.getName()+" you cant shoot to the same area");
                    continue;
                }
                dontRepeatForPlayer1.add(shoot);
                break;
            }

            if (player2Area.get(dontRepeatForPlayer1.get(dontRepeatForPlayer1.size() - 1)) instanceof Ship) {
                player1FindShip += 1;

                System.out.println(player1.getName() + " you found "+player2.getName()+"'s"+player1FindShip + " ship");
                MenuUtil.printMenuForShip(player2Menu, dontRepeatForPlayer1.get(dontRepeatForPlayer1.size() - 1));
            } else {
                System.out.println(player1.getName() + " you entered wrong area");
                MenuUtil.printMenuForWrongWhenYouPLayFriend(player2Menu, dontRepeatForPlayer1.get(dontRepeatForPlayer1.size() - 1),player2);
            }
            if (player1FindShip == 3) {
                System.out.println("");
                System.out.println(player1.getName() + " finds " +player2.getName() +"'s all ship"+player1.getName()+" Win");
                break;
            }

            while (true) {
                MenuUtil.printMenu(player1Menu,player1);

                System.out.println("Please choose area from "+  player1.getName() + " to shoot " + player1.getName()+"'s ship");
                int shoot = rr.nextInt() - 1;



                if (shoot > players1Area.size() || shoot < 0) {
                    System.out.println(player2.getName() + " you have to insert between (1-64)");
                    continue;
                }
                if (dontRepeatForPlayer2.contains(shoot)) {
                    System.out.println(player2.getName() +" you cant shoot to the same area");
                    continue;
                }
                dontRepeatForPlayer2.add(shoot);
                break;
            }

            if (players1Area.get(dontRepeatForPlayer2.get(dontRepeatForPlayer2.size() - 1)) instanceof Ship) {
                player2FindShip += 1;

                System.out.println(player2.getName() + " you found"+ player1.getName() + "'s "+player2FindShip +" ship");
                MenuUtil.printMenuForShip(player1Menu, dontRepeatForPlayer2.get(dontRepeatForPlayer2.size() - 1));
            } else {
                System.out.println(player2.getName() + " you entered wrong area");
                MenuUtil.printMenuForWrongWhenYouPLayFriend(player1Menu, dontRepeatForPlayer2.get(dontRepeatForPlayer2.size() - 1),player1);
            }
            if (player2FindShip == 3) {
                System.out.println("");
                System.out.println(player2.getName() + " you already find "+player1.getName()+"'s all ship,"+ player2.getName()+ " Win");
                break;
            }
        }
        LocalTime endTime = LocalTime.now();

        long seconds = Duration.between(start, endTime).getSeconds();
        System.out.println("Game finished with " + seconds+ "seconds");
        System.out.println(player1.getName() + " find " + player1FindShip);
        System.out.println(player2.getName() + " find " + player2FindShip);

    }

    public static void startGameWithComp(Player players) {
        Scanner rr = new Scanner(System.in);
        String[] strings = MenuUtil.creatMenuArr(players);

        MenuUtil.printMenu(strings, players);

        ComputerService computerService = new ComputerNpcServiceImpl();
        PlayerService playerService = new PlayerServiceImpl();

        ArrayList<Object> comp = computerService.addShipsForNpc();
        ArrayList<Object> player = playerService.addShipsToArea();
        ArrayList<Integer> dontRepeat = new ArrayList<>();

        int playerFindShip = 0;
        int compfinds = 0;

        System.out.println("Game start!");
        for (int i = 1; i <= 3; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (i == 3) {
                System.out.println("Start");
            }
        }

        LocalTime startTime = LocalTime.now();
        while (true) {

            while (true) {
                System.out.println("Please choose area from enemies to shoot ship");
                int shoot = rr.nextInt() - 1;

                if (shoot > comp.size() || shoot < 0) {
                    System.out.println("You have to insert between (1-64)");
                    continue;
                }
                if (dontRepeat.contains(shoot)) {
                    System.out.println("You cant shoot to the same area");
                    continue;
                }
                dontRepeat.add(shoot);
                break;
            }

            if (comp.get(dontRepeat.get(dontRepeat.size() - 1)) instanceof Ship) {
                System.out.println("You found enemies ship");
                playerFindShip += 1;
                MenuUtil.printMenuForShip(strings, dontRepeat.get(dontRepeat.size() - 1));
            } else {
                System.out.println("You entered wrong area");
                MenuUtil.printMenuForWrong(strings, dontRepeat.get(dontRepeat.size() - 1));
            }
            if (playerFindShip == 3) {
                System.out.println("");
                System.out.println("You already find enemies all ship, You Win");
                break;
            }
            Object o = computerService.chooseFromPlayerArea(player);
            if (o instanceof Ship) {
                compfinds += 1;
                System.out.println("");
                System.out.println("Comp find your " + compfinds + " ship");
            } else {
                System.out.println("");
                System.out.println("Comp entered wrong area");
            }
            if (compfinds == 3) {
                System.out.println("Comp already find your all ships, You lost");
                break;
            }
        }
        LocalTime endTime = LocalTime.now();

        long seconds = Duration.between(startTime, endTime).getSeconds();


        System.out.println("Game finished with " + seconds + "seconds");
        System.out.println(players.getName() + " find " + playerFindShip);
        System.out.println("Computer find " + compfinds);

    }
}
