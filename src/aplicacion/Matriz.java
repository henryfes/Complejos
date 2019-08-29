package aplicacion;

public class Matriz{
	int filas;
	int columnas;
	Complejo[][] A;
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
	
	
	public Complejo[][]suma(Matriz A, Matriz B) throws Exception {

		Complejo[][] res=new Complejo[A.get_filas()][A.get_colu()];
		if (A.get_filas()!=B.get_filas() || A.get_colu()!=B.get_colu()) {
			throw new Exception();
		}
		for(int i=0;i<A.get_filas();i++) {
			for(int j=0;j<A.get_colu();j++) {
				res[i][j]=A.get_matriz()[i][j].suma(B.get_matriz()[i][j]);
			}
		}
		return res;
	}
	
	public Complejo[][]inverso(Matriz A) {
	
		for(int i=0;i<A.get_filas();i++) {
			for(int j=0;j<A.get_colu();j++) {
				A.get_matriz()[i][j]=(new Complejo(-A.get_matriz()[i][j].get_real(),-A.get_matriz()[i][j].get_img()));
			}
		}
		return A.get_matriz();
	}
	
	public Complejo[][]Escalar(Matriz A, int escalar) {
		
		for(int i=0;i<A.get_filas();i++) {
			for(int j=0;j<A.get_colu();j++) {
				A.get_matriz()[i][j]=A.get_matriz()[i][j].Escalar(escalar);
			}
		}
		return A.get_matriz();
	}
	
	public Complejo[][] multiplicacion(Matriz B) throws Exception {
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
		return res;
	}
	
	public Complejo[][] transpuesta () {
		Complejo[][] res=new Complejo[this.get_colu()][this.get_filas()];
		for(int i=0;i<res.length;i++) {
			for(int j=0;j<res[i].length;j++) {
				res[i][j]=this.get_matriz()[j][i];
			}
		}
		return res;
	}
	
	public Complejo[][] Conjugada () {
		
		for(int i=0;i<this.get_filas();i++) {
			for(int j=0;j<this.get_colu();j++) {
				this.get_matriz()[i][j]=this.get_matriz()[i][j].get_conj();
			}
		}
		return this.get_matriz();
	}
	
	public Complejo[][] adjunta () {
		Complejo[][] resp=this.get_matriz();
		resp=this.transpuesta();
		Matriz respu= new Matriz(resp);
		Complejo[][] respuesta = respu.Conjugada();
		
		return respuesta;
	}
}
