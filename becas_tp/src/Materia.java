import java.util.ArrayList;
import java.util.Comparator;

public class Materia {

	private String nombre;
	private ArrayList<Alumno> alumnos;
	
	public Materia(String nombre) {
		super();
		this.nombre = nombre;
		this.alumnos = new ArrayList<Alumno>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + ", alumnos=" + alumnos + "]";
	}
	
	public Alumno mejorNotaMateria() {
		Alumno alumnoNotaMasAlta = this.alumnos.stream()
				.max(Comparator.comparingDouble(Alumno::getNota))
				.orElse(null);
		return alumnoNotaMasAlta;
	}

	public Alumno peorNotaAlumno() {
		Alumno alumnoNotaMasBaja = this.alumnos.stream()
				.min(Comparator.comparingDouble(Alumno::getNota))
				.orElse(null);
		return alumnoNotaMasBaja;
	}
	
	public double promedioNotas() {
		double promedioNotas = this.alumnos.stream()
				.mapToDouble(Alumno::getNota).average()
				.orElse(0);
		return promedioNotas;
	}

}
