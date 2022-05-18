package com.lwf.learn.everyday.coding.level1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-13 09:49
 */
public class ParkingSystem {
    int big;
    int medium;
    int small;
    public ParkingSystem(int big, int medium, int small) {
        this.big=big;
        this.medium=medium;
        this.small=small;
    }

    public boolean addCar(int carType) {
        switch (carType){
            case 1:
                if (big==0){
                    return false;
                }else{
                    big--;
                }break;
            case 2:
                if (medium==0){
                    return false;
                }else{
                    medium--;
                }break;
            case 3:
                if (small==0){
                    return false;
                }else{
                    small--;
                }break;
                default:
                    break;

        }
        return true;
    }
}
