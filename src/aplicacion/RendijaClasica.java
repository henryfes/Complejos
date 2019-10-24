package aplicacion;

public class RendijaClasica {
	  private double[][] matriz;
	    private double[] estado0;
	    private int blancos,rendijas;
	    public RendijaClasica(int rendijas, int blancos, int[][] ady) throws Exception{
	        if ( (rendijas+blancos+1) != ady.length) {
	        	throw new Exception();
	        	}
	        this.rendijas = rendijas;
	        this.blancos = blancos;
	        estado0 = Estinicial();
	        matriz = new double[ady.length][ady.length];
	        for(int i = 0; i < ady.length; i++) {
	        	for(int j: ady[i]) 
	        	{
	            if(j>=rendijas && i == 0) {
	            	matriz[j-1][i] = (double)Math.round((1d/rendijas) * 10d) / 10d ;
	            
	            }else { 
	            	if(i>0 && i<=rendijas) { 
	            		matriz[j-1][i] = (double)Math.round((1d/3) * 10d) / 10d;
	            	}else {
	            		matriz[j-1][i] = 1;}
	            	}
	        	}
	        }
	        
	    }
	    public double[] click(int n){
	        double[] y = estado0;
	        for(int i=0; i<n; i++){
	            y = mulVect(y);
	        }
	        return y;
	    }
	    
	    private double[] Estinicial(){
	        double[] aux = new double[rendijas+blancos+1];
	        aux[0] = 1;
	        return aux;
	    }
	    
	    public static void imprimir (double [][] M){
	        System.out.print("\n ");
	        for (int i = 0; i < M.length; i++) {
	        	System.out.print("   "+(i));
	        	}
	        for(int i = 0; i< M.length; i++) {
	            System.out.print("\n"+(i)+"| ");
	            for (int j = 0; j<M.length;j++) {
	            	System.out.print(M[i][j]+" ");
	            	}
	            System.out.print("|");
	        }
	    }
	  
	
	    public double[] getEstado(){
	        return estado0;
	    }
	    public double[][] getMatriz(){
	        return matriz;
	    }
	    private double[] mulVect(double[] y){
	        double[] aux =  new double[y.length];
	        for (int i = 0; i < matriz.length; i++){
	            double cont = 0;
	            for (int j = 0; j < matriz.length; j++){
	                cont += (double)Math.round(matriz[i][j]*y[j]*10d)/10d; 
	            }
	            aux[i] = cont;
	        }
	        return aux;
	    }
	
}
