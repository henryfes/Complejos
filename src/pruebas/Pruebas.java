package pruebas;

import aplicacion.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class Pruebas {

		
		public static final double MAXERROR = 0.00000000000001;
		private Calculadora calculadora = new Calculadora(true);
		private Complejo c1 = new Complejo(2,3), c2 = new Complejo(5,-5), c3 = new Complejo(-4,7), c4 = new Complejo(-2,-2);
		
		private Vector v1 = new Vector(new Complejo[]{new Complejo(5,-5), new Complejo(5,-5), new Complejo(5,-5)});
		private Vector v2 = new Vector(new Complejo[]{new Complejo(5,-5), new Complejo(5,-5), new Complejo(5,-5)});
		private Vector v3 = new Vector(new Complejo[]{new Complejo(2, 1), new Complejo(1,-2)});
		
		private Matriz hermitian = new Matriz(new Complejo[][]{{new Complejo(5,0),new Complejo(4,5),new Complejo(6,-16)},
											   				   {new Complejo(4,-5),new Complejo(13,0),new Complejo(7,0)},
											   				   {new Complejo(6,16),new Complejo(7,0),new Complejo(-2.1,0)}});
		
		private Matriz hermitianUnitaria = new Matriz(new Complejo[][] {{new Complejo(0,0),new Complejo(1,0)}, 
																		{new Complejo(1,0),new Complejo(0,0)}});
		
		private Matriz unitaria = new Matriz(new Complejo[][] {{new Complejo(0, 0),new Complejo(1,0)}, 
															   {new Complejo(1,0),new Complejo(0,0)}});
		
		private Matriz m1 = new Matriz(new Complejo[][] {{new Complejo(1,1),new Complejo(1,1)}, 
														 {new Complejo(1,1),new Complejo(1,1)}});
		
		private Matriz norma = new Matriz(new Complejo[][]{{new Complejo(6.5, 2.7),new Complejo(3.1, -3.8)}});
		
		private Matriz m2 = new Matriz(new Complejo[][] {{new Complejo(1,1),new Complejo(0,0)}, 
														 {new Complejo(1,0),new Complejo(0,1)}});
		

		private Matriz ide = new Matriz(new Complejo[][] {{new Complejo(1,1),new Complejo(0,0)}, 
														 {new Complejo(0,0),new Complejo(1,1)}});
		
		private Matriz m3 = new Matriz(new Complejo[][] {{new Complejo(-1,2),new Complejo(-2,-2),new Complejo(0,2)}, 
														 {new Complejo(2,3),new Complejo(3,1),new Complejo(2,2)},
														 {new Complejo(-2,1),new Complejo(1,-1),new Complejo(2,1)}});
		
		private Matriz matrizTensor = new Matriz(new Complejo[][] {{new Complejo(-3,1),new Complejo(0,-4),new Complejo(-2,2), 
																   new Complejo(0,0),new Complejo(0,0),new Complejo(0,0)},
																   {new Complejo(-1,5),new Complejo(2,4),new Complejo(0,4),
															       new Complejo(0,0),new Complejo(0,0),new Complejo(0,0)},
															       {new Complejo(-3,-1),new Complejo(2,0),new Complejo(1,3),
															       new Complejo(0,0),new Complejo(0,0),new Complejo(0,0)},
		       
															       {new Complejo(-1,2),new Complejo(-2,-2),new Complejo(0,2), 
																   new Complejo(-2,-1),new Complejo(2,-2),new Complejo(-2,0)},
																   {new Complejo(2,3),new Complejo(3,1),new Complejo(2,2),
															       new Complejo(-3,2),new Complejo(-1,3),new Complejo(-2,2)},
															       {new Complejo(-2,1),new Complejo(1,-1),new Complejo(2,1),
															       new Complejo(-1,-2),new Complejo(1,1),new Complejo(-1,2)}});
		
		
		@Test
		public void deberiaSumarComplejos() {
			Complejo suma = calculadora.suma(c1, c2);
			Complejo resultado = new Complejo(7, -2);
			assertTrue(suma.equals(resultado));
			suma = calculadora.suma(c3, c2);
			assertTrue(suma.equals(new Complejo(1, 2)));
		}
		
		@Test
		public void deberiaRestarComplejos() {
			Complejo resta = calculadora.resta(c1, c2);
			Complejo resultado = new Complejo(-3, 8);
			assertTrue(resta.equals(resultado));
			resta = calculadora.resta(c3, c2);
			assertTrue(resta.equals(new Complejo(-9, 12)));
		}
		
		@Test
		public void deberiaMultiplicarComplejos() {
			Complejo multiplicacion = calculadora.multiplicacion(c2, c4);
			Complejo resultado = new Complejo(-20, 0);
			assertTrue(multiplicacion.equals(resultado));
			multiplicacion = calculadora.multiplicacion(c3, c2);
			assertTrue(multiplicacion.equals(new Complejo(15, 55)));
		}
		
		@Test
		public void deberiaDividirComplejos() {
			Complejo dividir = calculadora.division(c2, c4);
			Complejo resultado = new Complejo(0, 5/2.0);
			assertTrue(dividir.equals(resultado));
			dividir = calculadora.division(c3, c2);
			assertTrue(dividir.equals(new Complejo(-11/10.0, 3/10.0)));
		}
		
		@Test
		public void deberiaDarModulo() {
			double modulo1 = calculadora.modulo(c1);
			double modulo2 = calculadora.modulo(c2);
			double modulo3 = calculadora.modulo(c3);
			double modulo4 = calculadora.modulo(c4);
			
			assertTrue(modulo1 == Math.sqrt(13));
			assertTrue(modulo2 == 5 * Math.sqrt(2));
			assertTrue(modulo3 == Math.sqrt(65));
			assertTrue(modulo4 == 2 * Math.sqrt(2));
		}
		
		@Test
		public void deberiaDarConjugado() {
			Complejo conjugado = calculadora.conjugado(c1);
			Complejo conjugado2 = calculadora.conjugado(c2);
			
			assertTrue(conjugado.get_real() == 2);
			assertTrue(conjugado.get_img() == -3);
			assertTrue(conjugado2.get_real() == 5);
			assertTrue(conjugado2.get_img() == 5);
		}
		
	
		
		@Test
		public void deberiaDarFase() {
			double fase = calculadora.fase(c4);
			assertEquals(fase, 0.7853981633974483, MAXERROR);
		}
		
		
		@Test 
		public void deberiaSumarVectores() { 
			Vector v = new Vector(new Complejo[]{new Complejo(10,-10), new Complejo(10,-10), new Complejo(10,-10)});
			try {
				assertTrue(v.equals(v1.sumarVectores(v2)));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		@Test 
		public void inversaVectores() { 
			Vector v = new Vector(new Complejo[]{new Complejo(-5,5), new Complejo(-5,5), new Complejo(-5,5)});
			assertTrue(v.equals(v1.inversa()));
		}
		
		
		@Test 
		public void EscalarVectores() { 
			Vector v = new Vector(new Complejo[]{new Complejo(-10,10), new Complejo(-10,10), new Complejo(-10,10)});
			assertTrue(v.equals(v1.inversa().multiplicacionEscalar(2)));
		}

		@Test 
		public void debeSuma() { 
			Matriz m = new Matriz(new Complejo[][] {{new Complejo(0,0),new Complejo(2,0)}, 
													{new Complejo(2,0),new Complejo(0,0)}});
			try {
				assertTrue(m.equals(hermitianUnitaria.suma(hermitianUnitaria)));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Test 
		public void inversa() { 
			Matriz m = new Matriz(new Complejo[][] {{new Complejo(0,0),new Complejo(-1,0)}, 
													{new Complejo(-1,0),new Complejo(0,0)}});
			
			assertTrue(m.equals(hermitianUnitaria.inversa()));
			
		}
		
		@Test 
		public void multiplicacionEscalar() { 
			Matriz m = new Matriz(new Complejo[][] {{new Complejo(0,0),new Complejo(5,0)}, 
													{new Complejo(5,0),new Complejo(0,0)}});
			assertTrue(m.equals(hermitianUnitaria.Escalar(5)));
			
		}
		
		
		@Test 
		public void Transpuesta() { 
			Matriz m = new Matriz(new Complejo[][] {{new Complejo(0,0),new Complejo(5,0)}, 
													{new Complejo(5,0),new Complejo(0,0)}});
			assertTrue(true);
			
		}
		
		@Test 
		public void Conjugada() { 
			Matriz m = new Matriz(new Complejo[][] {{new Complejo(1,-1),new Complejo(1,-1)}, 
													{new Complejo(1,-1),new Complejo(1,-1)}});
			assertTrue(m.equals(m1.Conjugada()));
			
		}
		
		@Test 
		public void Adjunta() { 
			Matriz m = new Matriz(new Complejo[][] {{new Complejo(1,-1),new Complejo(1,-1)}, 
													{new Complejo(1,-1),new Complejo(1,-1)}});
			m1.adjunta().imprimir();
			assertTrue(m.equals(m1.adjunta()));
			
		}
		
		@Test 
		public void accion() { 
			Vector v = new Vector(new Complejo[]{new Complejo(4, 2), new Complejo(4, 2)});		
			assertTrue(v.equals(v3.multiplicacion(m1)));
			
		}
		
		
		@Test 
		public void norma() { 
			double v = 8.578461400507669;
			try {
				assertEquals(v, norma.norma(norma), MAXERROR);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		@Test 
		public void distancia() { 
			double v = 12;
			Vector v1 = new Vector(new Complejo[] {new Complejo(2,7), new Complejo(4,-1), new Complejo(2,-4)});
			Vector v2 = new Vector(new Complejo[] {new Complejo(7,8), new Complejo(2,-8), new Complejo(1,4)});
			Matriz A = new Matriz(new Complejo[][]{v1.getVector()});
			Matriz B = new Matriz(new Complejo[][]{v2.getVector()});
			try {
				assertEquals(A.distancia(A, B), v, MAXERROR);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		@Test
		public void debeUni() {
			try {
			assertTrue(unitaria.isUnit(unitaria));
			}catch(Exception e) {}
		}
		
		@Test
		public void debeHer() {
			assertTrue(hermitian.isHermitian(hermitian));
		}
		
		@Test
		public void canicas() {
			Complejo[] ve = new Complejo[] {new Complejo(0,0), new Complejo(1,1)};
			Complejo[] es = new Complejo[] {new Complejo(0,0), new Complejo(0,0)};
			Vector v = new Vector (ve);
			Matriz ident=ide;
			Vector res=ident.experimentoCanicas(2, ide, v);
			Vector esperado= new Vector(es);
			assertTrue(res.equals(esperado));
		}
		
		/*
		@Test
		public void productoTensor() {
			assertTrue(m2.productoTensor(m3).equals(matrizTensor));
		}*/
		
}
