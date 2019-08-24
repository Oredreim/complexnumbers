package mathcplx;

public class ComplexMatrix {
    private Complex[][] matrix;

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
    
}



