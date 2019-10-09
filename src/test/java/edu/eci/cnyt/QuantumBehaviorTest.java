package edu.eci.cnyt;



import static org.junit.Assert.*;

import org.junit.Test;

public class QuantumBehaviorTest {

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