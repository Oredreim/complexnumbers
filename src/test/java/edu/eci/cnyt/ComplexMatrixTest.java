package edu.eci.cnyt;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;
public class ComplexMatrixTest {
	Complex c1 = Complex.newComplexNumberAlgebraicForm(3,2);
	Complex c2 = Complex.newComplexNumberAlgebraicForm(-1,3);
	Complex c3 = Complex.newComplexNumberAlgebraicForm(-10,-7);
	Complex c4 = Complex.newComplexNumberAlgebraicForm(9,-8);

	    ComplexMatrix cm1 = new ComplexMatrix(new Complex[][]{{c1,c2},{c3,c4}});

	    Complex c5 = Complex.newComplexNumberAlgebraicForm(-2,2);
	    Complex c6 = Complex.newComplexNumberAlgebraicForm(6,3);
	    Complex c7 = Complex.newComplexNumberAlgebraicForm(-4,-3);
	    Complex c8 = Complex.newComplexNumberAlgebraicForm(2,-3);

	    ComplexMatrix cm2 = new ComplexMatrix(new Complex[][]{{c5,c6},{c7,c8}});

	    @Test
	    public void sum(){
	    	Complex t1 = Complex.newComplexNumberAlgebraicForm(1,4);
	    	Complex t2 = Complex.newComplexNumberAlgebraicForm(5,6);
	    	Complex t3 = Complex.newComplexNumberAlgebraicForm(-14,-10);
	    	Complex t4 = Complex.newComplexNumberAlgebraicForm(11,-11);

	        ComplexMatrix tm1 = new ComplexMatrix(new Complex[][]{{t1,t2},{t3,t4}});
	        assertTrue(tm1.equals(cm1.sum(cm2)));
	    }

	    @Test
	    public void rest(){
	    	Complex t1 = Complex.newComplexNumberAlgebraicForm(5,0);
	    	Complex t2 = Complex.newComplexNumberAlgebraicForm(-7,0);
	    	Complex t3 = Complex.newComplexNumberAlgebraicForm(-6,-4);
	    	Complex t4 = Complex.newComplexNumberAlgebraicForm(7,-5);

	        ComplexMatrix tm1 = new ComplexMatrix(new Complex[][]{{t1,t2},{t3,t4}});
	        assertTrue(tm1.equals(cm1.rest(cm2)));
	    }

	    @Test
	    public void multiply(){
	    	Complex t1 = Complex.newComplexNumberAlgebraicForm(3,-7);
	    	Complex t2 = Complex.newComplexNumberAlgebraicForm(19,30);
	    	Complex t3 = Complex.newComplexNumberAlgebraicForm(-26,-1);
	    	Complex t4 = Complex.newComplexNumberAlgebraicForm(-45,-115);

	        ComplexMatrix tm1 = new ComplexMatrix(new Complex[][]{{t1,t2},{t3,t4}});
	        assertTrue(tm1.equals(cm1.multiply(cm2)));
	    }

	    @Test
	    public void traspose() {
	        ComplexMatrix tm1 = new ComplexMatrix(new Complex[][]{{c1,c3},{c2,c4}});
	        assertTrue(tm1.equals(cm1.traspose()));
	    }
	    
	    @Test
	    public void tensor() {
	    	Complex t1 = Complex.newComplexNumberAlgebraicForm(-10,2);
	    	Complex t2 = Complex.newComplexNumberAlgebraicForm(12,21);
	    	Complex t3 = Complex.newComplexNumberAlgebraicForm(-4,-8);
	    	Complex t4 = Complex.newComplexNumberAlgebraicForm(-15,15);
	    	Complex t5 = Complex.newComplexNumberAlgebraicForm(-6,-17);
	    	Complex t6 = Complex.newComplexNumberAlgebraicForm(12,-5);
	    	Complex t7 = Complex.newComplexNumberAlgebraicForm(13,-9);
	    	Complex t8 = Complex.newComplexNumberAlgebraicForm(7,9);
	    	Complex t9 = Complex.newComplexNumberAlgebraicForm(34,-6);
	    	Complex t10 = Complex.newComplexNumberAlgebraicForm(-39,-72);
	    	Complex t11 = Complex.newComplexNumberAlgebraicForm(-2,34);
	    	Complex t12 = Complex.newComplexNumberAlgebraicForm(78,-21);
	    	Complex t13 = Complex.newComplexNumberAlgebraicForm(19,58);
	    	Complex t14 = Complex.newComplexNumberAlgebraicForm(-41,16);
	    	Complex t15 = Complex.newComplexNumberAlgebraicForm(-60,5);
	    	Complex t16 = Complex.newComplexNumberAlgebraicForm(-6,-43);
	        ComplexMatrix tm1 = new ComplexMatrix(new Complex[][]{{t1,t2,t3,t4},
	                                                                    {t5,t6,t7,t8},
	                                                                    {t9,t10,t11,t12},
	                                                                    {t13,t14,t15,t16}});
	        assertTrue(tm1.equals(cm1.tensor(cm2)));
	    }

	    @Test
	    public void isHermitian() {
	    	Complex t1 = Complex.newComplexNumberAlgebraicForm(2,0);
	    	Complex t2 = Complex.newComplexNumberAlgebraicForm(2,1);
	    	Complex t3 = Complex.newComplexNumberAlgebraicForm(4,0);
	    	Complex t4 = Complex.newComplexNumberAlgebraicForm(2,-1);
	    	Complex t5 = Complex.newComplexNumberAlgebraicForm(3,0);
	    	Complex t6 = Complex.newComplexNumberAlgebraicForm(0,1);
	    	Complex t7 = Complex.newComplexNumberAlgebraicForm(4,0);
	    	Complex t8 = Complex.newComplexNumberAlgebraicForm(0,-1);
	    	Complex t9 = Complex.newComplexNumberAlgebraicForm(1,0);
	        assertTrue(new ComplexMatrix(new Complex[][]{{t1,t2,t3},
	                                                            {t4,t5,t6},
	                                                            {t7,t8,t9}})
	                .isHermitian());
	    }

	    @Test
	    public void isUnitary(){
	    	Complex t1 = Complex.newComplexNumberAlgebraicForm(1,1);
	    	Complex t2 = Complex.newComplexNumberAlgebraicForm(1,-1);
	        ComplexMatrix complexMatrix = new ComplexMatrix(new Complex[][]{{t1,t2},{t2,t1}});
	        assertTrue(complexMatrix.multiplyEscalar(Complex.newComplexNumberAlgebraicForm(1.0/2.0,0)).isUnitary());
	    }

	    @Test
	    public void multiplyEscalar() {
	        Complex t1 = Complex.newComplexNumberAlgebraicForm(12,-5);
	        Complex t2 = Complex.newComplexNumberAlgebraicForm(7,9);
	        Complex t3 = Complex.newComplexNumberAlgebraicForm(-41,16);
	        Complex t4 = Complex.newComplexNumberAlgebraicForm(-6,-43);
	        ComplexMatrix tm1= new ComplexMatrix(new Complex[][]{{t1,t2},{t3,t4}});
	        assertTrue(tm1.equals(cm1.multiplyEscalar(Complex.newComplexNumberAlgebraicForm(2,-3))));
	    }
            @Test
            void innerProduct(){
            ComplexMatrix tm1 = new ComplexMatrix(new Complex[][]{{c1,c2,c3,c4}});
            ComplexMatrix tm2 = new ComplexMatrix(new Complex[][]{{c5,c6,c7,c8}});
            assertTrue(Complex.newComplexNumberAlgebraicForm(-12,32).equals(tm1.innerProduct(tm2)));
            }
            
            @Test
            void varience(){
            assertTrue(Complex.newComplexNumberAlgebraicForm(0.25,0).equals( new ComplexMatrix(new Complex[][]{{
                Complex.newComplexNumberAlgebraicForm(1,0),
                Complex.newComplexNumberAlgebraicForm(0,-1)
            },{
            Complex.newComplexNumberAlgebraicForm(0,1),
                Complex.newComplexNumberAlgebraicForm(2,0)
            }}).varience(new ComplexMatrix(new Complex[][]{{
            Complex.newComplexNumberAlgebraicForm(Math.sqrt(2)/2.0,0)
            },{
            Complex.newComplexNumberAlgebraicForm(0,Math.sqrt(2)/2.0)
            }}))));
            }
            
            @Test
            void orbit(){
            Complex t1 = Complex.newComplexNumberAlgebraicForm(1,1);
            Complex t2 = Complex.newComplexNumberAlgebraicForm(1,-1);
            ComplexMatrix complexMatrix = new ComplexMatrix(new Complex[][]{{t1,t2},{t2,t1}}).multiplyEscalar(Complex.newComplexNumberAlgebraicForm(1.0/2.0,0));
            ComplexMatrix vector = new ComplexMatrix(new Complex[][]{{Complex.newComplexNumberAlgebraicForm(1,0), Complex.newComplexNumberAlgebraicForm(0,0)}}).adjoint();
            ArrayList<ComplexMatrix> complexMatrices = new ArrayList<ComplexMatrix>();
            complexMatrices.add(complexMatrix);
            complexMatrices.add(complexMatrix);
            assertTrue(ComplexMatrix.finalOrbit(complexMatrices,vector).equals(new ComplexMatrix(new Complex[][]{{Complex.newComplexNumberAlgebraicForm(0,0)},{Complex.newComplexNumberAlgebraicForm(1,0)}})));
            }
            
            
	    private void assertTrue(boolean equals) {
			// TODO Auto-generated method stub
	    }
}
