/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.can.CANTimeoutException;


public class RobotTemplate extends SimpleRobot {
  CANJaguar jag;
  AnalogChannel an;
  Potentiometer pot;
  
    public void robotInit() {
        try {
            jag = new CANJaguar(1);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        an = new AnalogChannel(2);
        pot = new Potentiometer(an, 2.0);
        
    }
  
    public void autonomous() {
        
    }

    public void operatorControl() {
        while(isEnabled()) {
            shoot(pot.potValueBeginning());
        }
    }
     public void shoot(double in)
    {
        try {
            jag.setX(in);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    
    public void stop()
    {
        try {
            jag.setX(0);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    public void test() {
    
    }
}
