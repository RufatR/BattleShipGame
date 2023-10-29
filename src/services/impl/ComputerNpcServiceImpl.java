package services.impl;

import models.dao.Ship;
import models.dao.Wave;
import services.ComputerService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ComputerNpcServiceImpl implements ComputerService {

  public  ArrayList<Object> addShipsForNpc() {


       Ship ship = new Ship();


       Wave wave = new Wave();


       ArrayList<Object> area = new ArrayList<>();

       for (int j = 0; j < 64; j++) {
           area.add(wave);
       }


       int firstShip = new Random().nextInt(64)+1;
       int secondShip = new Random().nextInt(64)+1;
       int thirdShip = new Random().nextInt(64)+1;

       area.set(firstShip-1,ship);
       area.set(secondShip-1,ship);
       area.set(thirdShip-1,ship);



       return area;
   }

    @Override
    public Object chooseFromPlayerArea(ArrayList<Object> area) {
        int randomNum = new Random().nextInt(area.size())+1;
        Ship ship = new Ship();

        ArrayList<Integer> arrayList =  new ArrayList();
        int bount =   64;

        for(int i = 0 ; i<bount ; i++){
            arrayList.add(i);
        }


        int randomInt = getRandomInt(arrayList);


        Object o = area.get(randomInt);
        return o;

    }

    public  static int getRandomInt(ArrayList<Integer> list){
        Integer random = list.get(new Random().nextInt(list.size()));
        list.remove(random);
        return random;

    }


}
