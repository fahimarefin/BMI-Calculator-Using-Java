package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static String Name;
    private static int age;

    public static void main(String[] args) {
     Scanner MyScanner=new Scanner(System.in);
     int number;
        boolean ContinueInput=true;
        do {
            try {
                System.out.println("Enter your Name:");
                Name  =MyScanner.nextLine();
                ContinueInput=false;
            }catch (InputMismatchException e){
                System.out.println("you have given wrong value as input please try again.");
            }
        }while (ContinueInput);
        boolean ContinueInput1=true;
        do {
            try {
                System.out.println("Enter your age:");
                boolean ContinueInput2=true;
                do {
                    age=MyScanner.nextInt();
                    if (age<0){
                        System.out.println("You have given negative value as input please try again.");
                    }else {
                        ContinueInput2=false;
                    }
                }while (ContinueInput2);
                ContinueInput1=false;
            }catch (InputMismatchException e){
                System.out.println("You have given String value as input please try again.");
                MyScanner.nextLine();
            }
        }while (ContinueInput1);

    x:
    while (true){
        System.out.println("Calculate BMI in pound and meter (TAP):1");
        System.out.println("Calculate BMI in weight and kg (TAP):2");
        System.out.println("For main menu (TAP):3");
        System.out.println("For exit (TAP):4");
        number=MyScanner.nextInt();
        switch (number){
            case 1:{

                BMI bmi=new BMI_In_Pound_And_Meter(Name,age);
                System.out.println(bmi.toString());
                break ;
            }
            case 2:{
                BMI bmi=new BMI_In_Weight_And_Kg(Name,age);
                System.out.println(bmi.toString());

            }
            case 3:{
                continue x;

            }
            case 4:{
                System.exit(number);
            }
        }

    }

    }
}
abstract class BMI{
    private String name;
    private int age;

    BMI(String name,int age){
        this.name=name;
        this.age=age;

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }


    abstract double getBmi();

    abstract String getStatus();

    @Override
    public String toString() {
        return "BMI{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class BMI_In_Pound_And_Meter extends BMI {
    private double Pound;
    private double Meter;
    private double bmi;

    BMI_In_Pound_And_Meter(String name, int age) {
        super(name, age);
    }
    Scanner MyScanner = new Scanner(System.in);

    @Override
    public double getBmi() {

        boolean ContinueInput = true;
        do {
            try {
                System.out.println("Input your Pound:");
                boolean ContinueInput1 = true;
                do {
                 Pound   = MyScanner.nextDouble();
                    if (Pound > 0) {
                        ContinueInput1 = false;
                    } else {
                        System.out.println("You have given negative value as pound input please try again.");
                    }

                } while (ContinueInput1);
                ContinueInput=false;
            } catch (InputMismatchException e) {
                System.out.println("You have given String value as input please try again.");
                MyScanner.nextLine();
            }
        } while (ContinueInput);


        boolean ContinueInput2=true;
        do {
            try {
                System.out.println("Input your height in meter:");
                boolean ContinueInput3=true;
                do {
                    Meter=MyScanner.nextDouble();
                    if(Meter>0){
                        ContinueInput3=false;
                    }else {
                        System.out.println("You have given negative value as input in meter please input a positive " +
                                "value");
                    }
                }while (ContinueInput3);
                ContinueInput2=false;
            }catch (InputMismatchException e){
                System.out.println("You have given a string value as input in meter please try gain");
                MyScanner.nextLine();
            }
        }while (ContinueInput2);
        double kgWeight=Pound/2.20462;
        bmi=(kgWeight/(Meter*Meter));
        return bmi;
    }

   @Override
    public String getStatus() {
        if(bmi<18.5)
            return "UnderWeight";
        else if(bmi<25)
            return "Normal";
        else if(bmi<30)
            return "OverWeight";
        else
           return "Obese";
    }

    @Override
    public String toString() {
        return  super.toString()+
        "BMI_In_Pound_And_Meter{" +
                "Bmi=" +getBmi()+
                ", Status="+getStatus()+
                "} " ;
    }
}
class BMI_In_Weight_And_Kg extends BMI{
    private double kg;
    private double feet;
    private double inch;
    private double bmi;

    BMI_In_Weight_And_Kg(String name, int age) {
        super(name, age);
    }


    Scanner MyScanner=new Scanner(System.in);
    @Override
    double getBmi() {
       boolean ContinueInput=true;
       do {
           try {
               System.out.println("Input your kg:");
               boolean ContinueInput1=true;
               do {
                   kg=MyScanner.nextDouble();
                   if(kg<=0) {
                       System.out.println("You have given zero or negative value as input please try again.");
                   }else {
                       ContinueInput1=false;
                   }
               }while (ContinueInput1);
               ContinueInput=false;
           }catch (InputMismatchException e){
               System.out.println("You have given string value as input please try again.");
               MyScanner.nextLine();
           }
       }while (ContinueInput);
       boolean ContinueInput2=true;
       do {
           try {
               System.out.println("Enter your height in Feet:");
               boolean ContinueInput3=true;
               do {
                   feet=MyScanner.nextDouble();
                   if(feet<=0){
                       System.out.println("You have given zero or negative value as input please try again.");
                   }else {
                       ContinueInput3=false;
                   }
               }while (ContinueInput3);
               ContinueInput2=false;
           }catch (InputMismatchException e){
               System.out.println("You have given string value as input please try again.");
               MyScanner.nextLine();
           }
       }while (ContinueInput2);
       boolean ContinueInput4=true;
       do {
           try {
               System.out.println("Enter your left inch after input height:");
               boolean ContinueInput5=true;
               do {
                   inch=MyScanner.nextDouble();
                   if(inch<0){
                       System.out.println("You have given negative value as input please try again.");
                   }else {
                       ContinueInput5=false;
                   }

               }while (ContinueInput5);
               ContinueInput4=false;
           }catch (InputMismatchException e){
               System.out.println("You have given string value as input please try again.");
           }
       }while (ContinueInput4);
       double Inch=(feet*12)+inch;
       double meter=Inch*0.0254;
       bmi=kg/(meter*meter);
       return bmi;
    }

    @Override
    String getStatus() {
        if(bmi<18.5)
            return "UnderWeight";
        else if(bmi<25)
            return "Normal";
        else if(bmi<30)
            return "OverWeight";
        else
            return "Obese";
    }

    @Override
    public String toString() {
        return super.toString() +
                "BMI_In_Weight_And_Kg{" +
                " Bmi=" + getBmi() +
                " Status=" + getStatus()+
    "}";
    }
}
