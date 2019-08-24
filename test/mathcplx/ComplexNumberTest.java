package mathcplx;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComplexNumberTest {

    Complex c1 = Complex.newComplexNumberAlgebraicForm(3,-4);
    Complex c2 = Complex.newComplexNumberAlgebraicForm(-6,7);

    @Test
    void sum() {
        assertTrue(Complex.newComplexNumberAlgebraicForm(-3,3).equals(c1.sum(c2)));

    }

    @Test
    void rest() {
        assertTrue(Complex.newComplexNumberAlgebraicForm(9,-11).equals(c1.resta(c2)));
    }

    @Test
    void multiply() {
        assertTrue(Complex.newComplexNumberAlgebraicForm(10,45).equals(c1.produc(c2)));
    }

    @Test
    void divide() {
        assertTrue(Complex.newComplexNumberAlgebraicForm(-46.0/85.0,3.0/85.0).equals(c1.divide(c2)));
    }  
    
    @Test
    void conjugate() {
        assertTrue(Complex.newComplexNumberAlgebraicForm(3,4).equals(c1.conjugate()));
    }
}