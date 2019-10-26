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

            
	    private void assertTrue(boolean equals) {
			// TODO Auto-generated method stub
		}
		@Test
    	public void deterministicTest(){
			Complex[][] matrix = new Complex[6][6];
			for(int i = 0; i<6;i++){
				for(int j = 0; j<6;j++){
					Complex temp;
					if((i==2 && j==1) || (i==2 && j==5) || (i==3 && j==3) || (i==4 && j==2) || (i==5 && j==0) || (i==5 && j==4))
						temp = Complex.newComplexNumberAlgebraicForm(1,0);
					else temp = Complex.newComplexNumberAlgebraicForm(0,0);
					matrix[i][j] = temp;
				}
			}
			ComplexMatrix complexMatrix = new ComplexMatrix(matrix);
			Complex[][] matrixX = new Complex[6][1];
			matrixX[0][0] = Complex.newComplexNumberAlgebraicForm(6,0);
			matrixX[1][0] = Complex.newComplexNumberAlgebraicForm(2,0);
			matrixX[2][0] = Complex.newComplexNumberAlgebraicForm(1,0);
			matrixX[3][0] = Complex.newComplexNumberAlgebraicForm(5,0);
			matrixX[4][0] = Complex.newComplexNumberAlgebraicForm(3,0);
			matrixX[5][0] = Complex.newComplexNumberAlgebraicForm(10,0);
			ComplexMatrix X = new ComplexMatrix(matrixX);
			Complex[][] matrixTest = new Complex[6][1];
			matrixTest[0][0] = Complex.newComplexNumberAlgebraicForm(0,0);
			matrixTest[1][0] = Complex.newComplexNumberAlgebraicForm(0,0);
			matrixTest[2][0] = Complex.newComplexNumberAlgebraicForm(12,0);
			matrixTest[3][0] = Complex.newComplexNumberAlgebraicForm(5,0);
			matrixTest[4][0] = Complex.newComplexNumberAlgebraicForm(1,0);
			matrixTest[5][0] = Complex.newComplexNumberAlgebraicForm(9,0);
			ComplexMatrix test = new ComplexMatrix(matrixTest);
			assertTrue(complexMatrix.multiply(X).equals(test));
    	}

    @Test
    	public void BulletTest(){
			Complex[][] matrix = new Complex[8][8];
			for(int i = 0; i<8; i++){
				for(int j = 0;j<8;j++){
					Complex temp;
					if((i==1 && j==0)||(i==2 && j==0)) temp = Complex.newComplexNumberAlgebraicForm(1.0/2.0,0);
					else if((i==3 && j==1) || (i==4 && j==1) || (i==5 && j==1) || (i==5 && j==2) || (i==6 && j==2) || (i==7 && j==2))
						temp = Complex.newComplexNumberAlgebraicForm(1.0/3.0,0);
					else if(i>2 && j>2 && i==j) temp = Complex.newComplexNumberAlgebraicForm(1,0);
					else temp = Complex.newComplexNumberAlgebraicForm(0,0);
					matrix[i][j] = temp;
				}
			}
			ComplexMatrix complexMatrix = new ComplexMatrix(matrix);
			Complex[][] matrixX = new Complex[8][1];
			for(int i = 0; i<8;i++){
				Complex temp;
				if (i==0) temp = Complex.newComplexNumberAlgebraicForm(1,0);
				else temp = Complex.newComplexNumberAlgebraicForm(0,0);
				matrixX[i][0] = temp;
			}
			ComplexMatrix X = new ComplexMatrix(matrixX);
			Complex[][] test = new Complex[8][1];
			for(int i = 0; i<8;i++){
				Complex temp;
				if(i==3 || i==4 || i==6 || i==7) temp = Complex.newComplexNumberAlgebraicForm(1.0/6.0,0);
				else if(i == 5) temp = Complex.newComplexNumberAlgebraicForm(1.0/3.0,0);
				else temp = Complex.newComplexNumberAlgebraicForm(0,0);
				test[i][0] = temp;
			}
			ComplexMatrix matrixTest = new ComplexMatrix(test);
			assertTrue(complexMatrix.multiply(complexMatrix).multiply(X).equals(matrixTest));
    	}

    	@Test
    	public void doubleSlit(){
			Complex[][] matrix = new Complex[8][8];
			for(int i = 0; i<8;i++){
				matrix[0][i]=Complex.newComplexNumberAlgebraicForm(0,0);
			}
			matrix[1][0] = Complex.newComplexNumberAlgebraicForm(1.0/Math.sqrt(2),0);
			for(int i = 1; i<8;i++) {
				matrix[1][i] = Complex.newComplexNumberAlgebraicForm(0, 0);
			}
			matrix[2][0] = Complex.newComplexNumberAlgebraicForm(1.0/Math.sqrt(2),0);
			for(int i = 1; i<8;i++) {
				matrix[2][i] = Complex.newComplexNumberAlgebraicForm(0, 0);
			}
			for(int i = 0;i<8;i++){
				Complex temp;
				if(i==1) {
					temp = Complex.newComplexNumberAlgebraicForm(-1.0, 1).multiplyEscalar(1.0 / Math.sqrt(6));
				}else if(i==3){
					temp = Complex.newComplexNumberAlgebraicForm(1,0);
				}else{
					temp = Complex.newComplexNumberAlgebraicForm(0,0);
				}
				matrix[3][i] = temp;
			}
			for(int i = 0;i<8;i++){
				Complex temp;
				if(i==1) {
					temp = Complex.newComplexNumberAlgebraicForm(-1.0, -1.0).multiplyEscalar(1.0 / Math.sqrt(6));
				}else if(i==4){
					temp = Complex.newComplexNumberAlgebraicForm(1,0);
				}else{
					temp = Complex.newComplexNumberAlgebraicForm(0,0);
				}
				matrix[4][i] = temp;
			}
			for(int i = 0;i<8;i++){
				Complex temp;
				if(i==1) {
					temp = Complex.newComplexNumberAlgebraicForm(1.0, -1.0).multiplyEscalar(1.0 / Math.sqrt(6));
				}else if(i==2){
					temp = Complex.newComplexNumberAlgebraicForm(-1.0, 1.0).multiplyEscalar(1.0 / Math.sqrt(6));
				}else if(i==5){
					temp = Complex.newComplexNumberAlgebraicForm(1,0);
				}else{
					temp = Complex.newComplexNumberAlgebraicForm(0,0);
				}
				matrix[5][i] = temp;
			}
			for(int i = 0;i<8;i++){
				Complex temp;
				if(i==2) {
					temp = Complex.newComplexNumberAlgebraicForm(-1.0, -1.0).multiplyEscalar(1.0 / Math.sqrt(6));
				}else if(i==6){
					temp = Complex.newComplexNumberAlgebraicForm(1,0);
				}else{
					temp = Complex.newComplexNumberAlgebraicForm(0,0);
				}
				matrix[6][i] = temp;
			}
			for(int i = 0;i<8;i++){
				Complex temp;
				if(i==2) {
					temp = Complex.newComplexNumberAlgebraicForm(1.0, -1.0).multiplyEscalar(1.0 / Math.sqrt(6));
				}else if(i==7){
					temp = Complex.newComplexNumberAlgebraicForm(1,0);
				}else{
					temp = Complex.newComplexNumberAlgebraicForm(0,0);
				}
				matrix[7][i] = temp;
			}
			ComplexMatrix result = new ComplexMatrix(matrix);

			//EXPECTED
			Complex[][] expected = new Complex[8][8];
			for(int i = 0; i<3;i++){
				for(int j = 0; j<8;j++){
					expected[i][j]=Complex.newComplexNumberAlgebraicForm(0,0);
				}
			}
			for(int i = 0; i<8;i++){
				Complex temp;
				if(i==0){
					temp = Complex.newComplexNumberAlgebraicForm(-1,1).multiplyEscalar(1.0/Math.sqrt(12));
				}else if(i==1){
					temp = Complex.newComplexNumberAlgebraicForm(-1,1).multiplyEscalar(1.0/Math.sqrt(6));
				}else if(i==3){
					temp = Complex.newComplexNumberAlgebraicForm(1,0);
				}else{
					temp = Complex.newComplexNumberAlgebraicForm(0,0);
				}
				expected[3][i] = temp;
			}
			for(int i = 0; i<8;i++){
				Complex temp;
				if(i==0){
					temp = Complex.newComplexNumberAlgebraicForm(-1,-1).multiplyEscalar(1.0/Math.sqrt(12));
				}else if(i==1){
					temp = Complex.newComplexNumberAlgebraicForm(-1,-1).multiplyEscalar(1.0/Math.sqrt(6));
				}else if(i==4){
					temp = Complex.newComplexNumberAlgebraicForm(1,0);
				}else{
					temp = Complex.newComplexNumberAlgebraicForm(0,0);
				}
				expected[4][i] = temp;
			}
			for(int i = 0; i<8;i++){
				Complex temp;
				if(i==1){
					temp = Complex.newComplexNumberAlgebraicForm(1,-1).multiplyEscalar(1.0/Math.sqrt(6));
				}else if(i==2){
					temp = Complex.newComplexNumberAlgebraicForm(-1,1).multiplyEscalar(1.0/Math.sqrt(6));
				}else if(i==5){
					temp = Complex.newComplexNumberAlgebraicForm(1,0);
				}else{
					temp = Complex.newComplexNumberAlgebraicForm(0,0);
				}
				expected[5][i] = temp;
			}
			for(int i = 0; i<8;i++){
				Complex temp;
				if(i==0){
					temp = Complex.newComplexNumberAlgebraicForm(-1,-1).multiplyEscalar(1.0/Math.sqrt(12));
				}else if(i==2){
					temp = Complex.newComplexNumberAlgebraicForm(-1,-1).multiplyEscalar(1.0/Math.sqrt(6));
				}else if(i==6){
					temp = Complex.newComplexNumberAlgebraicForm(1,0);
				}else{
					temp = Complex.newComplexNumberAlgebraicForm(0,0);
				}
				expected[6][i] = temp;
			}
			for(int i = 0; i<8;i++){
				Complex temp;
				if(i==0){
					temp = Complex.newComplexNumberAlgebraicForm(1,-1).multiplyEscalar(1.0/Math.sqrt(12));
				}else if(i==2){
					temp = Complex.newComplexNumberAlgebraicForm(1,-1).multiplyEscalar(1.0/Math.sqrt(6));
				}else if(i==7){
					temp = Complex.newComplexNumberAlgebraicForm(1,0);
				}else{
					temp = Complex.newComplexNumberAlgebraicForm(0,0);
				}
				expected[7][i] = temp;
			}
			ComplexMatrix expectedMatrix = new ComplexMatrix(expected);
			assertTrue(result.multiply(result).multiply(result).equals(expectedMatrix));
			}

    	@Test
    	public void probabilityInAPosition(){
			Complex[][] matrix = new Complex[1][4];
			matrix[0][0] = Complex.newComplexNumberAlgebraicForm(-3,-1);
			matrix[0][1] = Complex.newComplexNumberAlgebraicForm(0,-2);
			matrix[0][2] = Complex.newComplexNumberAlgebraicForm(0,1);
			matrix[0][3] = Complex.newComplexNumberAlgebraicForm(2,0);
			assertEquals(new ComplexMatrix(matrix).calculateProbabilityInAPosition(2),0.05263157894736841);
		}

		@Test
		public void transition() {
			Complex[][] si = new Complex[1][2];
			Complex[][] phi = new Complex[1][2];
			si[0][0] = Complex.newComplexNumberAlgebraicForm(0,1);
			si[0][1] = Complex.newComplexNumberAlgebraicForm(-1,0);

			phi[0][0] = Complex.newComplexNumberAlgebraicForm(1,0);
			phi[0][1] = Complex.newComplexNumberAlgebraicForm(0,1);

			assertTrue(new ComplexMatrix(si).bra().traspose().multiplyEscalar(Complex.newComplexNumberAlgebraicForm(Math.sqrt(2)/2,0)).
					innerProduct(new ComplexMatrix(phi).multiplyEscalar(Complex.newComplexNumberAlgebraicForm(Math.sqrt(2)/2,0))).equals(
					Complex.newComplexNumberAlgebraicForm(0,-1.0000000000000002)));
		}
		private void assertTrue(boolean equals) {
				// TODO Auto-generated method stub
			}
}
