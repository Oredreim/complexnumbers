package edu.eci.cnyt;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2124000
 */
public class Complex {
    private double real;
    private double ima;
    public Complex(double r, double i){
        this.real = r;
        this.ima = i;  
    }
    
    public double getReal() {
        return real;
    }
    
    public void setReal(double real) {
        this.real = real;
    }

    public double getIma() {
        return ima;
    }

    public void setIma(double ima) {
        this.ima = ima;
    }
    
    /**
     * New Complex Number with real and imaginary parts
     * @param realPart Real part
     * @param imaginaryPart Imaginary Part
     * @return
     */
    public static Complex newComplexNumberAlgebraicForm(double real, double ima){
        return new Complex(real, ima);
    }

    /**
     * Sums two number complex
     * @param c the other complex number
     * @return
     */
    public Complex sum(Complex c){
        double x = real+c.getReal();
        double y = ima+c.getIma();
        return new Complex(x, y);
    }
    
    /**
     * Rests two number complex
     * @param c the other complex number
     * @return
     */
    public Complex resta (Complex c){
        double x = real-c.getReal();
        double y = ima-c.getIma();
        return new Complex(x, y);
    }
    
    /**
     * Multiplys two complex numbers
     * @param c the other complex number
     * @return
     */
    public Complex produc(Complex c){
    	return new Complex(real*c.getReal()-ima*c.getIma(), real*c.getIma()+ima*c.getReal());
    }
    
    /**
     * Divides two complex numbers
     * @param c the other complex number
     * @return
     */
    public Complex divide(Complex c){
        double div = Math.pow(c.getReal(),2)+Math.pow(c.getIma(),2);
        return new Complex((real*c.getReal()+ima*c.getIma())/div, (ima*c.getReal()-real*c.getIma())/div);
    }
    
    /**
     * Returns the conjugate of the Complex Number
     * @return
     */
    public Complex conjugate(){ return new Complex(real, -ima);}
    public String toString() {
        return "main.ComplexNumber{" +
                "realPart=" + real +
                ", imaginaryPart=" + ima +
                '}';
    }
    
    public double getModule(){
        return Math.sqrt(Math.pow(real,2)+Math.pow(ima,2));
    }
    public Angle polar (Complex c1){
        double angle=Math.atan(c1.getIma()/c1.getReal());
        double magnum=Math.sqrt(c1.getReal()*c1.getReal()+c1.getIma()*c1.getIma());
        return new Angle(magnum,angle);
    }
    
    public Complex cartier(Angle a){
        double x=a.getMagnum()*Math.cos(a.getAngle());
        double y=a.getMagnum()*Math.sin(a.getAngle());
        return new Complex (x,y);      
    }
    
    public double norm(){
        return Math.sqrt(Math.pow(real,2)+Math.pow(ima,2));
    }
}