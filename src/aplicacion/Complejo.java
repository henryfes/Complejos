package aplicacion;


public class Complejo {
	double real;
	double img;
	
	public Complejo(double r,double c) {
		real=r;
		img=c;
	}
	
	public double get_real() {
		return this.real;
	}
	
	public double get_img() {
		return this.img;
	}
	
	public Complejo get_conj() {
		return new Complejo(real,-img);
	}
	
	public double get_modulo() {
		return (Math.sqrt((real*real)+(img*img)));
	}
	public double get_fase() {
		return (Math.atan(img/real));
	}
	public Complejo suma(Complejo c2) {
		return new Complejo(this.get_real()+c2.get_real(), this.get_img()+c2.get_img());
	}
	
	public Complejo resta(Complejo c2) {
		return new Complejo(this.get_real()-c2.get_real(), this.get_img()-c2.get_img());
	}
	public Complejo multiplicacion(Complejo c2) {
		double preal=((this.get_real()*c2.get_real())-(this.get_img()*c2.get_img()));
		double pimg=((this.get_real()*c2.get_img())+(this.get_img()*c2.get_real()));
		return new Complejo(preal,pimg);
	}
	
	public Complejo division(Complejo c2) {
		double preal=(((this.get_real()*c2.get_real())+(this.get_img()*c2.get_img()))/((Math.pow(c2.get_real(),2)+Math.pow(c2.get_img(), 2))));
		double pimg=(((this.get_img()*c2.get_real())-(this.get_real()*c2.get_img()))/((Math.pow(c2.get_real(),2)+Math.pow(c2.get_img(), 2))));
		return new Complejo(preal,pimg);
	}
	
	public Complejo Escalar(int escalar) {
		
		return new Complejo(escalar*this.get_real(),escalar*this.get_img());
	}
	
	public void imprimir() {
		System.out.print("("+ real + ", " + img + ")" + " ");
	}
	
	@Override
	public boolean equals(Object c) {
		return (this.hashCode() == c.hashCode());
	}
	@Override
	public int hashCode() {
		int hash=7;
		hash= 53+(int)(Double.doubleToLongBits(this.get_real())^(Double.doubleToLongBits(this.get_real())>>> 32));
		hash= 53+(int)(Double.doubleToLongBits(this.get_img())^(Double.doubleToLongBits(this.get_img())>>> 32));
		return hash;
	}
}
