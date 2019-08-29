package pruebas;

import aplicacion.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class Pruebas {
	
	@Test
	public void deberiaSumar() {
		Calculadora prueba= new Calculadora(true);
		Complejo c1=new Complejo(8,-3);
		Complejo c2=new Complejo(5,5);
		Complejo esperado= new Complejo(13,2);
		Complejo prueb=prueba.suma(c1, c2);
		assertTrue(prueb.equals(esperado));
	}
	
	@Test
	public void deberiaRestar() {
		Calculadora prueba= new Calculadora(true);
		Complejo c1=new Complejo(8,-3);
		Complejo c2=new Complejo(5,5);
		Complejo esperado= new Complejo(-3,-8);
		Complejo prueb=prueba.resta(c1, c2);
		assertTrue(prueb.equals(esperado));
	}
	
	@Test
	public void deberiaMultiplicar() {
		Calculadora prueba= new Calculadora(true);
		Complejo c1=new Complejo(8,-3);
		Complejo c2=new Complejo(5,5);
		Complejo esperado= new Complejo(55,25);
		Complejo prueb=prueba.resta(c1, c2);
		assertTrue(prueb.equals(esperado));
	}
	@Test
	public void deberiaDividir() {
		Calculadora prueba= new Calculadora(true);
		Complejo c1=new Complejo(8,-3);
		Complejo c2=new Complejo(5,5);
		Complejo esperado= new Complejo(55,25);
		Complejo prueb=prueba.resta(c1, c2);
		assertTrue(prueb.equals(esperado));
	}
	@Test
	public void deberiaConjugar() {
		Calculadora prueba= new Calculadora(true);
		Complejo c1=new Complejo(8,-3);
		Complejo c2=new Complejo(5,5);
		Complejo esperado= new Complejo(55,25);
		Complejo prueb=prueba.resta(c1, c2);
		assertTrue(prueb.equals(esperado));
	}
	@Test
	public void deberiaModulo() {
		Calculadora prueba= new Calculadora(true);
		Complejo c1=new Complejo(8,-3);
		Complejo c2=new Complejo(5,5);
		Complejo esperado= new Complejo(55,25);
		Complejo prueb=prueba.resta(c1, c2);
		assertTrue(prueb.equals(esperado));
	}
	@Test
	public void deberiaPolares() {
		Calculadora prueba= new Calculadora(true);
		Complejo c1=new Complejo(8,-3);
		Complejo c2=new Complejo(5,5);
		Complejo esperado= new Complejo(55,25);
		Complejo prueb=prueba.resta(c1, c2);
		assertTrue(prueb.equals(esperado));
	}
	@Test
	public void deberiaFase() {
		Calculadora prueba= new Calculadora(true);
		Complejo c1=new Complejo(8,-3);
		Complejo c2=new Complejo(5,5);
		Complejo esperado= new Complejo(55,25);
		Complejo prueb=prueba.resta(c1, c2);
		assertTrue(prueb.equals(esperado));
	}
	
	@Test
	public void deberiaSumarMatrices() {
		Calculadora prueba= new Calculadora(true);
		Complejo c1=new Complejo(8,-3);
		Complejo c2=new Complejo(5,5);
		Complejo esperado= new Complejo(55,25);
		Complejo prueb=prueba.resta(c1, c2);
		assertTrue(prueb.equals(esperado));
	}
	@Test
	public void deberiaMultMatrices() {
		Calculadora prueba= new Calculadora(true);
		Complejo c1=new Complejo(8,-3);
		Complejo c2=new Complejo(5,5);
		Complejo esperado= new Complejo(55,25);
		Complejo prueb=prueba.resta(c1, c2);
		assertTrue(prueb.equals(esperado));
	}
	@Test
	public void deberiaInversaMatrices() {
		Calculadora prueba= new Calculadora(true);
		Complejo c1=new Complejo(8,-3);
		Complejo c2=new Complejo(5,5);
		Complejo esperado= new Complejo(55,25);
		Complejo prueb=prueba.resta(c1, c2);
		assertTrue(prueb.equals(esperado));
	}
	@Test
	public void deberiaTransMatrices() {
		Calculadora prueba= new Calculadora(true);
		Complejo c1=new Complejo(8,-3);
		Complejo c2=new Complejo(5,5);
		Complejo esperado= new Complejo(55,25);
		Complejo prueb=prueba.resta(c1, c2);
		assertTrue(prueb.equals(esperado));
	}
	@Test
	public void deberiaconjuMatrices() {
		Calculadora prueba= new Calculadora(true);
		Complejo c1=new Complejo(8,-3);
		Complejo c2=new Complejo(5,5);
		Complejo esperado= new Complejo(55,25);
		Complejo prueb=prueba.resta(c1, c2);
		assertTrue(prueb.equals(esperado));
	}
	@Test
	public void deberiaadjunMatrices() {
		Calculadora prueba= new Calculadora(true);
		Complejo c1=new Complejo(8,-3);
		Complejo c2=new Complejo(5,5);
		Complejo esperado= new Complejo(55,25);
		Complejo prueb=prueba.resta(c1, c2);
		assertTrue(prueb.equals(esperado));
	}

}
