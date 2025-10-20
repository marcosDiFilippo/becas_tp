import java.util.ArrayList;

public class Alumno {

	private String nombre;
	private double nota;
	private ArrayList <Float> notasFinales;
	private float promedio;

	public Alumno(String nombre, double nota) {
		super();
		this.nombre = nombre;
		this.nota = nota;
		this.notasFinales = new ArrayList<Float>();
		this.promedio = 0;
	}
	
	public void ingresarNotasFinales() {
		for (int i = 0; i < 3; i++) {
			float nota = (float)(Math.random() * 6 + 4);
			notasFinales.add(nota);
		}
	}
	
	public void calcularPromedioGeneral() {
		for (int i = 0; i < notasFinales.size(); i++) {
			promedio += notasFinales.get(i);
		}
		promedio += nota;
		
		promedio /= 4;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
	public ArrayList<Float> getNotasFinales() {
		return notasFinales;
	}
	
	public void setNotasFinales(ArrayList<Float> notasFinales) {
		this.notasFinales = notasFinales;
	}
	
	public float getPromedio() {
		return promedio;
	}
	
	public void setPromedio(float promedio) {
		this.promedio = promedio;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", nota=" + nota + "]\n";
	}

}
