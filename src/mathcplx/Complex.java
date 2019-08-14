package mathcplx;

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
    private double img;
    public Complex(double r, double i){
        this.real = r;
        this.img = i;  
    }

    /**
     * @return the real
     */
    public double getReal() {
        return real;
    }

    /**
     * @return the img
     */
    public double getImg() {
        return img;
    }
    
    public double modulo(){
        return Math.sqrt(real*real+img*img);
    }
    public Complex conjugate(){ return new Complex(real, -img);}

}
