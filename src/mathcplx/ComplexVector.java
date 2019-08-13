package mathcplx;

public class ComplexVector {
	private int tam;
    private double[] x;
    public ComplexVector(int tam) {
        this.tam = tam;
        x=new double[tam];
        for(int i=0; i<tam;i++) {
        		x[i]=0; 	
        }
    }  	
}


