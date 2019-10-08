package edu.eci.cnyt;

public class ComplexMatrix {
    private Complex[][] matrix;
    double probability;

    public ComplexMatrix(int i, int j){
        matrix = new Complex[i][j];
    }

    public ComplexMatrix(Complex[][] matrix){
        this.matrix = matrix;
    }
    
    public void put(int i, int j, Complex c){
        matrix[i][j] = c;
    }
    
    public Complex[][] getMatrix() {
        return matrix;
    }
    public void setMatrix(Complex[][] matrix) {
        this.matrix = matrix;
    }
    
    
    public ComplexMatrix traspose(){
        Complex[][] resultado = new Complex[matrix[0].length][matrix.length];
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                resultado[j][i] = matrix[i][j];
            }
        }
        return new ComplexMatrix(resultado);
    }
    
    public ComplexMatrix conjugate(){
        Complex[][] resultado = new Complex[matrix.length][matrix[0].length];
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                resultado[i][j] = matrix[i][j].conjugate();
            }
        }
        return new ComplexMatrix(resultado);
    }
    public ComplexMatrix adjoint(){
        return this.traspose().conjugate();
    }
    
    public boolean isHermitian(){
        if(this.equals(this.adjoint())){
            return true;
        }else{
            return false;
        }
    }
    
    public ComplexMatrix sum(ComplexMatrix c) {
    	Complex[][] ans=new Complex[matrix.length][matrix[0].length];
    	for (int i =0; i<matrix.length; i++){
    		for (int j=0; j<matrix[0].length; j++) {
    		ans[i][j]=matrix[i][j].sum(c.getMatrix()[i][j]);
    		}
    	}
    	return new ComplexMatrix(ans);
    }
    
    public ComplexMatrix rest(ComplexMatrix c){
        Complex[][] resultado = new Complex[matrix.length][matrix[0].length];
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                resultado[i][j] = matrix[i][j].resta(c.getMatrix()[i][j]);
            }
        }
        return new ComplexMatrix(resultado);
    }
    
    public ComplexMatrix multiply(ComplexMatrix c){
        Complex[][] resultado = new Complex[matrix.length][c.getMatrix()[0].length];
        for(int i = 0; i< matrix.length; i++){
            for(int k = 0; k< c.getMatrix()[0].length; k++){
                Complex temp = Complex.newComplexNumberAlgebraicForm(0,0);
                for(int j = 0; j< matrix[0].length; j++){
                    temp = temp.sum(matrix[i][j].produc(c.getMatrix()[j][k]));
                }
                resultado[i][k] = temp;
            }
        }
        return new ComplexMatrix(resultado);
    }
    
    public ComplexMatrix multiplyEscalar(Complex c){
        Complex[][] resultado = new Complex[matrix.length][matrix[0].length];
        for(int i = 0; i<matrix.length;i++){
            for(int j = 0; j<matrix[0].length;j++){
                resultado[i][j] = matrix[i][j].produc(c);
            }
        }
        return new ComplexMatrix(resultado);
    }
    
    public Double norm(){
        Double temp = 0.0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                temp+=Math.pow(matrix[i][j].norm(),2);
            }
        }
        return  Math.sqrt(temp);
    }
    
    public Double distance(ComplexMatrix c){
        return this.rest(c).norm();
    }
    
    public boolean isUnitary(){
        Complex[][] tempMatrix = new Complex[matrix.length][matrix.length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                if(i==j){
                    tempMatrix[i][j] = Complex.newComplexNumberAlgebraicForm(1,0);
                }else{
                    tempMatrix[i][j] = Complex.newComplexNumberAlgebraicForm(0,0);
                }
            }
        }
        ComplexMatrix iden = new ComplexMatrix(tempMatrix);
        ComplexMatrix first = this.multiply(this.adjoint());
        ComplexMatrix second = this.adjoint().multiply(this);
        boolean bol = true;

        for (int i = 0; i<matrix.length;i++){
            for(int j = 0; j<matrix.length;j++){
                if(!first.getMatrix()[i][j].equals(iden.getMatrix()[i][j]) ||
                !second.getMatrix()[i][j].equals(iden.getMatrix()[i][j])) bol = false;
            }
        }
        return bol;
    }
    public ComplexMatrix tensor(ComplexMatrix c){
        Complex[][] resultado = new Complex[matrix.length* c.getMatrix().length][matrix[0].length* c.getMatrix()[0].length];
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                for(int m = 0; m< c.getMatrix().length; m++){
                    for(int n = 0; n< c.getMatrix()[0].length; n++){
                        resultado[i* c.getMatrix().length+m][j* c.getMatrix()[0].length+n]=matrix[i][j].produc(c.getMatrix()[m][n]);
                    }
                }
            }
        }
        return new ComplexMatrix(resultado);
    }
    
    public double calculateProbabilityInAPosition(int n){
        return Math.pow(matrix[0][n].norm()/this.norm(),2);
    }
    
    public Complex varience(ComplexMatrix complexMatrix){
        if(!isHermitian()){
            return null;
        }else{
            Complex mu = mean(complexMatrix);
            Complex[][] matrixTemp = new Complex[matrix.length][matrix.length];
            for(int i = 0; i<matrixTemp.length;i++){
                for(int j = 0;j<matrixTemp.length;j++){
                    if(i==j) matrixTemp[i][j] = mu;
                    else matrixTemp[i][j] = Complex.newComplexNumberAlgebraicForm(0,0);
                }
            }
            return complexMatrix.bra()
                    .multiply(this.rest(new ComplexMatrix(matrixTemp))
                            .multiply(this.rest(new ComplexMatrix(matrixTemp))))
                    .multiply(complexMatrix).getMatrix()[0][0];
        }
    }
    public Complex mean(ComplexMatrix complexMatrix) {
        return multiply(complexMatrix).bra().multiply(complexMatrix).getMatrix()[0][0];
    }
    
    public ComplexMatrix bra(){
        return this.adjoint();
    }
    
    public Complex innerProduct(ComplexMatrix complexMatrix){
        
        Complex temp = Complex.newComplexNumberAlgebraicForm(0,0);
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                temp = temp.sum(matrix[i][j].produc(complexMatrix.getMatrix()[i][j]));
            }
        }
        return temp;
    }
    public Complex amplitudeTransition(ComplexMatrix complexMatrix){
        return this.bra().innerProduct(complexMatrix);
    }  
 
    public double probabilities(int slit, int target){
        return probability;
    }
    public void setProbability(double probability){
        this.probability=probability;
    }
}



