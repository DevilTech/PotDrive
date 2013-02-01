
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.AnalogChannel;


public class Potentiometer {
    double halfmaxvolt;
    double deadspace;
    AnalogChannel an;
    
    public Potentiometer(AnalogChannel an, double halfmaxvolt){
        this.an = an;
        this.halfmaxvolt = halfmaxvolt;
    }
    
    public double potValueBeginning(){
        double input = an.getAverageVoltage();
        input = input/(halfmaxvolt * 2);
        return input;
    }
    
    public double potValueMiddle(){
        double input = an.getAverageVoltage();
        if(input >  halfmaxvolt + deadspace ||input < halfmaxvolt - deadspace){
            input  =  input - halfmaxvolt;
             return input / halfmaxvolt;
        }
        else{
            return 0;
        }
    }   
}
