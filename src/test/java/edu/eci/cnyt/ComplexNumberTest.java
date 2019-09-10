package edu.eci.cnyt;
import static org.junit.Assert.*;
import org.junit.Test;


public class ComplexNumberTest {

    Complex c1 = Complex.newComplexNumberAlgebraicForm(3,-4);
    Complex c2 = Complex.newComplexNumberAlgebraicForm(-6,7);

    @Test
    public void sum() {
        assertTrue(Complex.newComplexNumberAlgebraicForm(-3,3).equals(c1.sum(c2)));

    }

	@Test
    public void rest() {
        assertTrue(Complex.newComplexNumberAlgebraicForm(9,-11).equals(c1.resta(c2)));
    }

    @Test
    public void multiply() {
        assertTrue(Complex.newComplexNumberAlgebraicForm(10,45).equals(c1.produc(c2)));
    }

    @Test
    public void divide() {
        assertTrue(Complex.newComplexNumberAlgebraicForm(-46.0/85.0,3.0/85.0).equals(c1.divide(c2)));
    }  
    
    @Test
    public void conjugate() {
        assertTrue(Complex.newComplexNumberAlgebraicForm(3,4).equals(c1.conjugate()));
    }
    
    private void assertTrue(boolean equals) {
		// TODO Auto-generated method stub	
	}
}