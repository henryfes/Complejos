package aplicacion;

public class Vector {
	
	private Complejo vector[];
	
	/**
	 * Constructor de la clase vector
	 * @param num Es el numero de elementos aleatorios que tendr� el vector
	 */
	public Vector(int num) {
		vector = new Complejo[num];
		
		for (int i = 0; i < vector.length; i++) {
			double real = Math.floor(Math.random()*(100 - (-100) + 1) - 100);
			double imaginario = Math.floor(Math.random()*(100 - (-100) + 1) - 100);
			vector[i] = new Complejo(real, imaginario);				
		}
		
	}
	
	/**
	 * Constructor de la clase vector para valores dados
	 * @param A Es el vector con los valores dados
	 */
	public Vector(Complejo[] A) {
		vector = new Complejo[A.length];
		
		for (int i = 0; i < vector.length; i++) {
			vector[i] = A[i];
		}
	}
	
	public Vector(double[][] A) {
		vector = new Complejo[A.length];
		for (int i = 0; i < vector.length; i++) {
			vector[i] = new Complejo(A[i][0], A[i][1]);
		}
	}
	
	
	public Complejo multiplicacion(Vector B) {
		Complejo resultado = new Complejo(0, 0);
		
		for (int i = 0; i < vector.length; i++) {
			resultado = resultado.suma(vector[i].get_conj().multiplicacion(B.getVector()[i]));
		}
		
		
		
		return resultado;
	}
	
	
	/**
	 * Suma dos vectores y los retorna
	 * @param B Es el otro vector a sumar
	 * @return Un nuevo vector con la suma de los vectores
	 * @throws Exception En caso de que los dos vectores sean diferentes
	 */
	public Vector sumarVectores(Vector B) throws Exception {
		if (vector.length !=  B.getVector().length) {
			throw new Exception("No puede sumar matrices que no tengan el mismo tama�o");
		}
		
		Complejo[] resultado = new Complejo[vector.length];
		for (int i = 0; i < resultado.length; i++) {
			resultado[i] = vector[i].suma(B.getVector()[i]);
			
		}
		return new Vector(resultado);
	}
	
	
	/**
	 * Realiza la inversa de un vector
	 * @return El nuevo vector con su inversa
	 */
	public Vector inversa() {
		Complejo[] res = new Complejo[vector.length];
		for (int i = 0; i < vector.length; i++) {
			double aux1 = -vector[i].get_real(), aux2 = -vector[i].get_img();
			if (vector[i].get_real() == 0) aux1 = 0;
			if (vector[i].get_img() == 0) aux2 = 0;
			res[i] = new Complejo(aux1, aux2);
		}
		return new Vector(res);
	}
	
	/**
	 * Multiplica el vector con un escalar y la retorna
	 * @param c Es el escalar a multiplicar por el vector
	 * @return el nuevo vector
	 */
	public Vector multiplicacionEscalar(double c) {
		Complejo[] res = new Complejo[vector.length];
		for (int i = 0; i < vector.length; i++) {
			res[i] = new Complejo(c * vector[i].get_real(), c * vector[i].get_img());	
		}
		return new Vector(res);
	}
	
	/**
	 * Multiplica el vector con un escalar y la retorna
	 * @param c Es el numero complejo
	 * @return El nuevo vector
	 */
	public Vector multiplicacionEscalar2(Complejo c) {
		Complejo[] res = new Complejo[vector.length];
		for (int i = 0; i < vector.length; i++) {
			res[i] = vector[i].multiplicacion(c);
		}
		return new Vector(res);
	}
	
	
	/**
	 * Multiplica el vector por una matriz (la accion)
	 * @param A Es la matriz
	 * @return El nuevo vector resultante
	 */
	public Vector multiplicacion(Matriz A) {
		Complejo[] res = new Complejo[vector.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = new Complejo(0, 0);
		}
		
		for (int i = 0; i < A.get_matriz().length; i++) {
			for (int j = 0; j < A.get_matriz()[i].length; j++) {
					res[i] = res[i].suma(A.get_matriz()[i][j].multiplicacion(vector[j]));
				}
			}
		
		return new Vector(res);
	}
	
	
	/**
	 * Imprimir el vector
	 */
	public void imprimir() {
		System.out.println();
		for (int i = 0; i < vector.length; i++) {
				System.out.print("("+ vector[i].get_real() + ", " + vector[i].get_img() + ")" + " ");
		}
		System.out.println();
	}
	
	
	/**
	 * Retorna el vector en lista
	 * @return vector
	 */
	public Complejo[] getVector() {
		return vector;
	}
	
	/**
	 * Verifica que el hascode de ambos objetos sea igual
	 * @param obj
	 * @return true, false depndiendo de la condicion
	 */
	@Override
	public boolean equals(Object obj) {
		return (this.hashCode() == obj.hashCode());
	}
	/**
	 * Muestra la informacion del hashcode del objeto
	 * @return hash Es la informacion obtenida
	 */
	@Override
	public int hashCode() {
		int hash = 7;
		for (int i = 0; i < vector.length; i++) {
			hash = 53 * hash + (int) (Double.doubleToLongBits(vector[i].get_real()) ^ (Double.doubleToLongBits(vector[i].get_real()) >>> 32));
			hash = 53 * hash + (int) (Double.doubleToLongBits(vector[i].get_img()) ^ (Double.doubleToLongBits(vector[i].get_img()) >>> 32));
		}
		return hash;
	}
	

}
