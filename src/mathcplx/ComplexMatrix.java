package mathcplx;

public class ComplexMatrix {
	private int filas, columnas;
    private double[][] x;
    public ComplexMatrix(int filas, int columnas) {
        this.filas = filas;
        this.columnas= columnas;
        x=new double[filas][columnas];
        for(int i=0; i<filas;i++) {
        	for (int j=0; j<columnas; j++) {
        		x[i][j]=0;
        	}    	
        }
    }

}




