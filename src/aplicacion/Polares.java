package aplicacion;

public class Polares {
	double angulo;
	double raiz;
	
	public Polares(Complejo c1) {
		
		angulo= Math.atan(Math.toRadians((c1.get_img()/c1.get_real())));
		raiz=Math.sqrt(Math.pow(c1.get_img(), 2)+ Math.pow(c1.get_real(),2));
		
		
	}
	

}
