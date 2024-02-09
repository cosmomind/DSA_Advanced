package com.company.OOPS.Inheritance;

class bicycle{
public int gear;
public int speed;

public bicycle(int gear,int speed){
    this.gear = gear;
    this.speed = speed;

}

public String to_String(){
        return ("No of gears are " + gear + "\n"
                + "speed of bicycle is " + speed);
    }


}

class mountain extends bicycle{
    int seatheight;


    public mountain(int gear, int speed,int seatheight) {
        super(gear, speed);
        this.seatheight = seatheight;
    }

    @Override public String to_String(){
        return (super.to_String()+ "\nseat height is "
                + seatheight);
    }
}
public class inheritance {
    public static void main(String[] args) {


            mountain mb = new mountain(3, 100, 25);
            System.out.println(mb.to_String());

    }
}
