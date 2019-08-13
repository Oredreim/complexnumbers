package mathcplx;

import static org.junit.Assert.*;

import org.junit.Test;

public class complexmathtest {
	

	@Test
	public void testSuma() {
		Complex a = new Complex(5, -1);
        Complex b = new Complex(6, 3);
        Complex answ = new Complex(11, 2);
        assertEquals(answ.getReal(), ComplexMath.suma(a, b).getReal(),0);
        assertEquals(answ.getImg(), ComplexMath.suma(a, b).getImg(),0);
	}

	@Test
	public void testProduc() {
		Complex a = new Complex(3, -2);
        Complex b = new Complex(1, 2);
        Complex answ = new Complex(7, 4);
        assertEquals(answ.getImg(),ComplexMath.produc(a, b).getImg(),0);
        assertEquals(answ.getReal(),ComplexMath.produc(a, b).getReal(),0);
	}

	@Test
	public void testResta() {
		Complex a = new Complex(4, 10);
        Complex b = new Complex(2, -15);
        Complex answ = new Complex(2, 25);
        assertEquals(answ.getImg(),ComplexMath.resta(a, b).getImg(),0);
        assertEquals(answ.getReal(),ComplexMath.resta(a, b).getReal(),0);
	}

	@Test
	public void testCociente() {
	        Complex a = new Complex(1, 0);
	        Complex b = new Complex(3, 1);
	        Complex answ = new Complex(3/10, -1/10);
	        assertEquals(answ.getImg(),ComplexMath.cociente(a, b).getImg(),0);
	        assertEquals(answ.getReal(),ComplexMath.cociente(a, b).getReal(),0);
	    }

	@Test
	public void testConjugado() {
		Complex a = new Complex(2,5);
        Complex b = new Complex(2,-5);
        a.conjugado(b);
        assertEquals(a.getReal(),b.getReal(),0);
        assertEquals(a.getImg(),b.getImg(),0);
	}

	@Test
	public void testPolar() {
		fail("Not yet implemented");
	}

	@Test
	public void testCartier() {
		fail("Not yet implemented");
	}

	@Test
	public void testObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClass() {
		fail("Not yet implemented");
	}

	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testEquals() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotify() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotifyAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLongInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testWait() {
		fail("Not yet implemented");
	}

	@Test
	public void testFinalize() {
		fail("Not yet implemented");
	}

}
