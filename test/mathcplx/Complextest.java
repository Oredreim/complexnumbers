package mathcplx;

import static org.junit.Assert.*;

import org.junit.Test;

public class Complextest {

	@Test
	public void testComplex() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetReal() {
		Complex c = new Complex(0,3);
        assertEquals(0, c.getReal(),0);
	}

	@Test
	public void testGetImg() {
		Complex c = new Complex(0,3);
        assertEquals(3, c.getImg(),0);
	}

	@Test
	public void testModulo() {
		Complex c = new Complex(4,3);
        double d =c.modulo();
        assertEquals(5, d,0);
	}
	
	@Test
	public void testPhase() {
        Complex c = new Complex(1,1);
        assertEquals((Math.PI / 4), c.phase(),0);
    }
	
	@Test
	public void testConjugado() {
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
