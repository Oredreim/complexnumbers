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
public class ComplexMath {
    public Complex suma(Complex c1, Complex c2){
        double x = c1.getReal()+ c1.getReal();
        double y = c2.getImg() + c2.getImg();
        return new Complex(x,y);
    }
    public Complex produc(Complex c1, Complex c2){
        double x=c1.getReal()*c1.getReal()-c2.getImg()*c2.getImg();
        double y=c1.getReal()*c2.getImg()+c1.getReal()*c2.getReal();
        return new Complex(x,y);
    }
    public Complex resta (Complex c1, Complex c2){
        double x = c1.getReal()- c1.getReal();
        double y = c2.getImg() - c2.getImg();
        return new Complex(x,y);
    }
    public Complex cociente(Complex c1, Complex c2){
        double aux, x, y;
        aux=c2.getReal()*c2.getReal()+c2.getImg()*c2.getImg();
        x=c1.getReal()*c2.getReal()+c1.getImg()*c2.getImg()/aux;
        y=c1.getImg()*c2.getReal()-c1.getReal()*c2.getImg()/aux;
        return new Complex(x, y);
    }
    public Complex conjugado (Complex c1){
        return new Complex (c1.getReal(),-c1.getImg());
    }
    public Angle polar (Complex c1){
        double angle=Math.atan(c1.getImg()/c1.getReal());
        double magnum=Math.sqrt(c1.getReal()*c1.getReal()+c1.getImg()*c1.getImg());
        return new Angle(magnum,angle);
    }
    public Complex cartier(Angle a){
        double x=a.getMagnum()*Math.cos(a.getAngle());
        double y=a.getMagnum()*Math.sin(a.getAngle());
        return new Complex (x,y);      
    }
}
    