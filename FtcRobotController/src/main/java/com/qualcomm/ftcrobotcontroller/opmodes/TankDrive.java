package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class TankDrive {

    DcMotor[] leftMotors;
    DcMotor[] rightMotors;

    private boolean reverse = false;

    private float speedVariable = 1;

    public TankDrive(DcMotor[] leftMotors, DcMotor[] rightMotors){
        this.leftMotors = leftMotors;
        this.rightMotors = rightMotors;
    }

    public void drive (float rightY, float leftY){

        if(reverse){
            float tmp = rightY;
            rightY = leftY;
            leftY = tmp;
            rightY *= -1;
            leftY *= -1;

        }

        for(DcMotor motor : leftMotors){
            motor.setPower((leftY*speedVariable));
        }

        for(DcMotor motor : rightMotors){
            motor.setPower((rightY*speedVariable));
        }
    }

    public void reverse(){
        reverse = !reverse;
    }

    public float getSpeedVariable(){
        return speedVariable;
    }

    public void setSpeedVariable(float speedVariable){
        this.speedVariable = speedVariable;
    }

}