/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class RobotTemplate extends SimpleRobot {
  Jaguar jag;
  
  AnalogChannel an;
  Potentiometer pot;
  Joystick joy;
  Servo hopper;
  
  
    public void robotInit() {
        try {
            jag = new Jaguar(1);
       } catch (Exception ex) {
            ex.printStackTrace();        }
        
        an = new AnalogChannel(2);
        pot = new Potentiometer(an, 2.0);
        LiveWindow.addActuator("pot", "numbers!", an);
        LiveWindow.setEnabled(true);
        hopper = new Servo(4);
        joy= new Joystick(1);
        
        
    }
  
    public void autonomous() {
        
    }

    public void operatorControl() {
        while(isEnabled()) {
            shoot(SmartDashboard.getNumber("Slider 1")/100);
            System.out.println(SmartDashboard.getNumber("Slider 1")/100);
            LiveWindow.run();
            if(joy.getRawButton(1)){
                hopper.setAngle(90);
                Timer.delay(.3);
                hopper.setAngle(10);
            }
        }
    }
     public void shoot(double in)
    {
        try {
            jag.set(in);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void stop()
    {
        try {
            jag.set(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void test() {
    
    }
}
