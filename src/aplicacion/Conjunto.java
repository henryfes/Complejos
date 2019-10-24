package aplicacion;

public class Conjunto {
		private int adya;
	   private Complejo pes;
	    
	    
	    public Conjunto(int adyacencia,Complejo peso) throws Exception{
	        this.pes = peso;
	        this.adya = adyacencia;        
	    }
	    public int getAdy(){
	        return adya;
	    }
	    public Complejo getPeso(){
	        return pes;
	    }
	    
	    public void setPeso(Complejo peso){
	        this.pes = peso;        
	    }
}
