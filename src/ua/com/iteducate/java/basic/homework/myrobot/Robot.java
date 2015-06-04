/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.iteducate.java.basic.homework.myrobot;

/**
 *
 * @author user
 */
public class Robot {
    private final double[] paintVolume = new double[]{10,100};
    private double[] paintVolumeToUse;
    
    protected Robot(Shape[] shapeStorage){
        if (shapeStorage.length == 0){
            System.out.println("No shapes specified.");
        }else{
            paintVolumeToUse = new double[]{0,0};
            this.doJob(shapeStorage);
            }
        }
    
    private void doJob(Shape[] shapeStorage){
        for (Shape shapeFromStorage : shapeStorage) {
            paintVolumeToUse[0] += shapeFromStorage.perimeter();
            paintVolumeToUse[1] += shapeFromStorage.square();
            if (paintVolumeToUse[0]>this.paintVolume[0] || paintVolumeToUse[1]>this.paintVolume[1]){
                System.out.println("Not enough paint");
                break;
            }
            shapeFromStorage.draw();
        }
    }
}
