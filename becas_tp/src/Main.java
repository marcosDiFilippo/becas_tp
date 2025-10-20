import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

		Alumno a1 = new Alumno("Marcos Jesús Di Filippo", 10);
		Alumno a2 = new Alumno("Juan", 5);
		Alumno a3 = new Alumno("Tobías", 9);
		Alumno a4 = new Alumno("Favala", 7);
		Alumno a5 = new Alumno("Octavio", 2);
		Alumno a6 = new Alumno("Gerónimo", 6);
		Alumno a7 = new Alumno("Santiago", 1);
		Alumno a8 = new Alumno("Galo", 2);

		alumnos.add(a1);
		alumnos.add(a2);
		alumnos.add(a3);
		alumnos.add(a4);
		alumnos.add(a5);
		alumnos.add(a6);
		alumnos.add(a7);
		alumnos.add(a8);
		
		StringBuilder msj = new StringBuilder();
		msj.append("---Notas Finales---");
		
		StringBuilder promedioGeneralPorAlumno = new StringBuilder();
		promedioGeneralPorAlumno.append("---Promedios---");
		
		StringBuilder top3 = new StringBuilder();
		
		StringBuilder promedioGeneralAlumnos = new StringBuilder();
		
		for (Alumno alumno : alumnos) {
			alumno.ingresarNotasFinales();
			alumno.calcularPromedioGeneral();
			msj.append("\nAlumno: " + alumno.getNombre() + " | Notas finales: " + alumno.getNotasFinales() + "\n");	
			promedioGeneralPorAlumno.append("\nAlumno: " + alumno.getNombre() + " | Promedio general: " + alumno.getPromedio() + "\n");
		}
		
		List <Alumno> mejoresPromedios = alumnos.stream()
				.sorted(Comparator.comparing(Alumno::getPromedio).reversed())
				.collect(Collectors.toList());
		
		top3.append("---Top 3 Promedios---\n");
		
		for (int i = 0; i < 3; i++) {
			top3.append("\nAlumno: " + mejoresPromedios.get(i).getNombre() + " | Promedio: " + mejoresPromedios.get(i).getPromedio());
		}
		double promedioGeneral = 0;
		
		promedioGeneralAlumnos.append("---Promedio General De Alumnos---\n");
		
		for (Alumno alumno : mejoresPromedios) {
			promedioGeneral += alumno.getPromedio();
		}
		
		promedioGeneralAlumnos.append("Promedio de: " + promedioGeneral / mejoresPromedios.size());
		
		JOptionPane.showMessageDialog(null, msj);

		JOptionPane.showMessageDialog(null, promedioGeneralPorAlumno);
		
		JOptionPane.showMessageDialog(null, top3);
		
		JOptionPane.showMessageDialog(null, promedioGeneralAlumnos);
		
		Materia matematicas = new Materia("Matemáticas");
		Materia historia = new Materia("Historia");
		Materia geografia = new Materia("Geografía");

		matematicas.getAlumnos().add(a1);
		geografia.getAlumnos().add(a2);
		historia.getAlumnos().add(a3);
		geografia.getAlumnos().add(a4);
		matematicas.getAlumnos().add(a5);
		matematicas.getAlumnos().add(a6);
		historia.getAlumnos().add(a7);
		geografia.getAlumnos().add(a8);

		ArrayList<Materia> materias = new ArrayList<Materia>();

		materias.add(matematicas);
		materias.add(historia);
		materias.add(geografia);

		String mejorNota = "La mejor nota de la materia ";

		for (int i = 0; i < materias.size(); i++) {
			mejorNota += materias.get(i).getNombre() + " es " + materias.get(i).mejorNotaMateria();
		}
		JOptionPane.showMessageDialog(null, mejorNota);

		String peorNota = "La peor nota de la materia ";

		for (int i = 0; i < materias.size(); i++) {
			peorNota += materias.get(i).getNombre() + " es " + materias.get(i).peorNotaAlumno();
		}
		JOptionPane.showMessageDialog(null, peorNota);

		double promedioGral = alumnos.stream().mapToDouble(Alumno::getNota).average().orElse(0);
		JOptionPane.showMessageDialog(null, "El promedio general es de " + promedioGral);

		List<Alumno> ordenado = alumnos.stream().sorted(Comparator.comparingDouble(Alumno::getNota).reversed())
				.collect(Collectors.toList());
		JOptionPane.showMessageDialog(null, "La lista de alumnos de mayor a menor nota: \n" + ordenado);

		String pNotaMateria = "El promedio de notas de la materia ";

		for (int i = 0; i < materias.size(); i++) {
			pNotaMateria += materias.get(i).getNombre() + " es " + materias.get(i).getAlumnos().size()
					+ "\n Cantidad de alumnos " + materias.get(i).getAlumnos().size() + "\n";
		}

		JOptionPane.showMessageDialog(null, pNotaMateria);
		
		JOptionPane.showMessageDialog(null, "Gracias por usar el programa!");
	}
}
