package aplicacion;
import java.util.ArrayList;

public class Calculadora {
	Complejo resu;
	ArrayList<Double>res;
	Complejo[][] A = new Complejo[3][4];
	Complejo[][] B = new Complejo[3][4];
	public Calculadora(boolean x) {
		if (!x) {
		Complejo c1=new Complejo(8,-3);
		Complejo c2=new Complejo(5,5);
		resu=suma(c1,c2);

		/*
		System.out.println("El resultado de la suma es : "+resu.get_real()+" "+resu.get_img()+"i");
		resu=resta(c1,c2);
		System.out.println("El resultado de la resta es : "+resu.get_real()+" "+resu.get_img()+"i");
		*/
		resu=multiplicacion(c1,c2);
		
		System.out.println("El resultado de la multiplicacion es : "+resu.get_real()+" "+resu.get_img()+"i");
		resu=division(c1,c2);
		/*
		System.out.println("El resultado de la division es : "+resu.get_real()+" "+resu.get_img()+"i");
		double resu2 =modulo(c2);
		System.out.println("El resultado de la modulo es : "+resu2);
		resu=conjugado(c1);
		System.out.println("El resultado de la conjugado es : "+resu.get_real()+" "+resu.get_img()+"i");
		res=polar(c2);
		System.out.println("El resultado en polares es : "+(double)res.get(0)+" ,"+(double)res.get(1));
		resu=conjugado(c1);
		System.out.println("El resultado de la fase es : "+resu.get_fase());
		*/}
		
	}
	public static Complejo suma(Complejo c1,Complejo c2) {
		return c1.suma(c2);
	} 
	public Complejo resta(Complejo c1,Complejo c2) {
		return c1.resta(c2);
	}
	
	public static Complejo multiplicacion(Complejo c1,Complejo c2) {
	
		return c1.multiplicacion(c2);
	}
	
	public Complejo division(Complejo c1,Complejo c2) {
		return c1.division(c2);
	}
	
	public double modulo(Complejo c1) {
		return c1.get_modulo();
		
	}
	
	public Complejo conjugado(Complejo c1) {
		return c1.get_conj();
		
	}
	
	public ArrayList<Double> polar(Complejo c1) {
		ArrayList<Double> res= new ArrayList<>();
		Polares polar= new Polares(c1);
		res.add(polar.angulo);
		res.add(polar.raiz);
		return res;
		
	}
	
	public Double fase(Complejo c1) {
		return c1.get_fase();
	}
	public static void main(String[] arg) {
		new Calculadora(true);
	}
	
	

}
