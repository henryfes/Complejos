package aplicacion;

import java.util.Arrays;

public class Matriz{
	int filas;
	int columnas;
	Complejo A[][];
	public Matriz(int fil, int col) {
		A = new Complejo[fil][col];
		filas=fil;
		columnas=col;
		for(int i=0;i<A.length;i++) {
			for(int j=0;j<A[i].length;j++) {
				double real=Math.floor((Math.random()*(100-(-100)+1)-100));
				double ima=Math.floor((Math.random()*(100-(-100)+1)-100));
				A[i][j]=new Complejo(real,ima);
			}
			
		}
	}
	
	public Matriz(Complejo[][] a) {
		A=new Complejo[a.length][a[0].length];
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				A[i][j]=a[i][j];
			}
		}
		
	}
	public Complejo[][] get_matriz(){
		return A;
	}
	public int get_filas() {
		return filas;
	}
	public int get_colu() {
		return columnas;
	}
	
	
	public Matriz suma(Matriz B) throws Exception {

		Complejo[][] res=new Complejo[this.get_filas()][this.get_colu()];
		if (this.get_filas()!=B.get_filas() || this.get_colu()!=B.get_colu()) {
			throw new Exception();
		}
		for(int i=0;i<B.get_filas();i++) {
			for(int j=0;j<B.get_colu();j++) {
				res[i][j]=this.get_matriz()[i][j].suma(B.get_matriz()[i][j]);
			}
		}
		return  new Matriz(res);
	}
	
	public Matriz inverso(Matriz A) {
	
		for(int i=0;i<A.get_filas();i++) {
			for(int j=0;j<A.get_colu();j++) {
				A.get_matriz()[i][j]=(new Complejo(-A.get_matriz()[i][j].get_real(),-A.get_matriz()[i][j].get_img()));
			}
		}
		return A;
	}
	
	public Matriz Escalar(int escalar) {
		
		for(int i=0;i<A.length;i++) {
			for(int j=0;j<A[0].length;j++) {
				A[i][j]= new Complejo(escalar*A[i][j].get_real(),escalar*A[i][j].get_img());
			}
		}
		return new Matriz(A);
	}
public Matriz EscalarCo(Matriz A, Complejo escalar) {
		
		for(int i=0;i<A.get_filas();i++) {
			for(int j=0;j<A.get_colu();j++) {
				A.get_matriz()[i][j]=A.get_matriz()[i][j].multiplicacion(escalar);
			}
		}
		return A;
	}

	public Matriz multiplicacion(Matriz B) throws Exception {
		if (this.get_colu()!=B.get_filas()) {
			throw new Exception("No se pueden multiplicar");
		}
		Complejo[][] res=new Complejo[this.get_filas()][B.get_colu()];
		for(int i=0;i<res.length;i++) {
			for(int j=0;j<res[i].length;j++) {
				for (int x=0; x<this.get_colu();x++) {
					res[i][j]= res[i][j].suma(this.get_matriz()[i][x].multiplicacion(B.get_matriz()[x][j])); 
					
				}
			}
		}
		return new Matriz(res);
	}
	
	public Matriz transpuesta () {
		Complejo[][] res=new Complejo[A.length][A[0].length];
		for(int i=0;i<res.length;i++) {
			for(int j=0;j<res[i].length;j++) {
				res[i][j]=this.get_matriz()[j][i];
			}
		}
		return new Matriz(res);
	}
	
	public Matriz Conjugada () {
		
		for(int i=0;i<this.get_filas();i++) {
			for(int j=0;j<this.get_colu();j++) {
				this.get_matriz()[i][j]=this.get_matriz()[i][j].get_conj();
			}
		}
		return this;
	}
	
	public Matriz adjunta () {
	
		Complejo [][] resp=this.transpuesta().Conjugada().get_matriz();
		
		return new Matriz(resp);
	}
	
	public double norma (Matriz A) throws Exception{
		return Math.sqrt(productointerno(A));
	}
	public double productointerno (Matriz A) throws Exception {
		double respu=0;
		Matriz aux = A.adjunta();
		Matriz res= aux.multiplicacion(A);
		for (int i=0;i<res.get_filas();i++) {
			for (int j=0;j<res.get_colu();i++) {
				if(i==j) {
					respu+=Math.sqrt(Math.pow(res.get_matriz()[i][j].get_real(),2)+Math.pow(res.get_matriz()[i][j].get_img(),2));
				}
			}
		}
		return respu;
	}
	
	public double distancia (Matriz A,Matriz B) throws Exception{
		return norma(A.suma((B.inverso(B))));
	}
	public Matriz unit(int filas,int colum) {
		Matriz res=new Matriz(filas,colum);
		for(int i=0;i<filas;i++) {
			for (int j=0;j<colum;i++) {
				if (i==j) {
				res.get_matriz()[i][j]=new Complejo(1,1);
				}
				else {
					res.get_matriz()[i][j]=new Complejo(0,0);
				}
			}
		}
	return res;
	}
	public boolean isHermitian (Matriz A){
		boolean res=false;
		if (A.equals(A.adjunta())){
			res=true;
		}
		return res;
	}
	
	public boolean isUnit (Matriz A) throws Exception{
		boolean res=false;
		if (A.transpuesta().multiplicacion(A).equals(A.unit(A.get_filas(), A.get_colu()))){
			res=true;
		}
		return res;
	}
	
	
	public void imprimir() {
		System.out.println();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				System.out.print("("+ A[i][j].get_real() + ", " + A[i][j].get_img() + ")" + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	public Matriz productoTensor(Matriz B) {
		Complejo[][] res =  new Complejo[A.length * B.get_matriz().length][A[0].length * B.get_matriz()[0].length];
		int cont = 0, cont2 = 0, auxInt = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				Complejo[][] aux = B.EscalarCo(B,(A[i][j])).get_matriz();
				auxInt = aux.length;
				for (int k = 0; k < aux.length; k++) {
					for (int l = 0; l < aux[k].length; l++) {
						res[k + cont][l + cont2] = aux[k][l];
					} 
				}
				cont2 += aux[i].length;
				if (cont2 >= res[i].length) cont2 = 0;
			}
			cont += auxInt;
			if (cont >= res.length) cont = 0;
		}
		
		return new Matriz(res);
	}
	
	public Matriz inversa() {
		Complejo[][] res = new Complejo[A.length][A[0].length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				double aux1 = -A[i][j].get_real(), aux2 = -A[i][j].get_img();
				if (A[i][j].get_real() == 0) aux1 = 0;
				if (A[i][j].get_img() == 0) aux2 = 0;
				res[i][j] = new Complejo(aux1, aux2);
			}
		}
		return new Matriz(res);
	}
	
	public void imprimirRes(Complejo[][] res) {
		System.out.println();
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				if (res[i][j] == null) {
					System.out.println("(0,0)");
					continue;
				}
				System.out.print("("+ res[i][j].get_real() + ", " + res[i][j].get_img() + ")" + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	public Vector experimentoCanicas(int clicks, Matriz m, Vector v) {
		for (int i = 0; i < clicks; i++) {
			v = v.multiplicacion(m);
		}
		return v;
	}

	@Override
	public boolean equals(Object obj) {
		return (this.hashCode() == obj.hashCode());
	}
	
	@Override
	public int hashCode() {
		int hash = 7;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				hash = 53 * hash + (int) (Double.doubleToLongBits(A[i][j].get_real()) ^ (Double.doubleToLongBits(A[i][j].get_real()) >>> 32));
				hash = 53 * hash + (int) (Double.doubleToLongBits(A[i][j].get_img()) ^ (Double.doubleToLongBits(A[i][j].get_img()) >>> 32));
			}
		}
		return hash;
	}
	
}
