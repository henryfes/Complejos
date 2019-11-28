package aplicacion;

public class Simon {
	private Matriz uf;
	private Vector vecto;
	private int num;
	public Simon(int n,Vector v) {
		num=n;
		vecto=v;
	}
	
	public Matriz Hn() {
		return new Matriz((int)Math.pow(2,num),(int)Math.pow(2,num));
	}
	
	public void algoritmo(Matriz m, Vector v) {
		Vector aux =v.multiplicacion(m);
		Vector resp= aux.multiplicacion(Hn());
		m.productoTensor(Hn());
		
		
		
	}
	
		

}
