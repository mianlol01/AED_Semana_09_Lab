package arreglo;

import clase.Alumno;
import java.util.ArrayList;

public class ArregloAlumnos {
	private ArrayList<Alumno> alu;

	public ArregloAlumnos() {
		alu = new ArrayList<Alumno>();
		adicionar(new Alumno(123, "Ana", 19, 15));
		adicionar(new Alumno(456, "Juan", 15, 14));
		adicionar(new Alumno(789, "Pedro", 17, 19));
		adicionar(new Alumno(302, "David", 13, 18));
		adicionar(new Alumno(417, "Carlos", 20, 19));
		adicionar(new Alumno(641, "Jorge", 12, 13));
		adicionar(new Alumno(208, "María", 15, 17));
		adicionar(new Alumno(820, "José", 11, 10));
	}

	public void adicionar(Alumno x) {
		alu.add(x);
	}

	public int tamanio() {
		return alu.size();
	}

	public Alumno obtener(int i) {
		return alu.get(i);
	}

	public int cantAprobados() {
		int count = 0;
		for (Alumno alumno : alu) {
			if (alumno.promedio() >= 13) {
				count++;
			}
		}
		return count;
	}

	public int cantDesaprobados() {
		int count = 0;
		for (Alumno alumno : alu) {
			if (alumno.promedio() < 13) {
				count++;
			}
		}
		return count;
	}

	public String nombrePrimerDesaprobado() {
		for (Alumno alumno : alu) {
			if (alumno.promedio() < 13) {
				return alumno.getNombre();
			}
		}
		return null;
	}

	public String nombreUltimoAprobado() {
		for (int i = alu.size() - 1; i >= 0; i--) {
			if (alu.get(i).promedio() >= 13) {
				return alu.get(i).getNombre();
			}
		}
		return null;
	}

	public String nombreSegundoDesaprobado() {
		int desaprobadosCount = 0;
		for (Alumno alumno : alu) {
			if (alumno.promedio() < 13) {
				desaprobadosCount++;
				if (desaprobadosCount == 2) {
					return alumno.getNombre();
				}
			}
		}
		return null;
	}

	public String nombrePenultimoAprobado() {
		for (int i = alu.size() - 2; i >= 0; i--) {
			if (alu.get(i).promedio() >= 13) {
				return alu.get(i).getNombre();
			}
		}
		return null;
	}
}
