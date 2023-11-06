package arreglo;

import clase.Docente;
import java.util.ArrayList;

public class ArregloDocentes {
	private ArrayList<Docente> doc;

	public ArregloDocentes() {
		doc = new ArrayList<Docente>();
		adicionar(new Docente(101, "Juan", 40, 20.0));
		adicionar(new Docente(102, "Maria", 35, 18.5));
		adicionar(new Docente(103, "Pedro", 30, 17.0));
		adicionar(new Docente(104, "Ana", 25, 19.5));
		adicionar(new Docente(105, "Carlos", 20, 22.0));
		adicionar(new Docente(106, "Laura", 15, 23.5));
		adicionar(new Docente(107, "David", 10, 25.0));
		adicionar(new Docente(108, "Sara", 5, 26.5));
	}

	public void adicionar(Docente d) {
		doc.add(d);
	}

	public int tamanio() {
		return doc.size();
	}

	public Docente obtener(int i) {
		return doc.get(i);
	}

	public double sueldoPromedio() {
		double totalSueldo = 0.0;
		for (Docente d : doc) {
			totalSueldo += d.sueldo();
		}
		return totalSueldo / doc.size();
	}

	public double sueldoMayor() {
		double maxSueldo = Double.MIN_VALUE;
		for (Docente d : doc) {
			double sueldo = d.sueldo();
			if (sueldo > maxSueldo) {
				maxSueldo = sueldo;
			}
		}
		return maxSueldo;
	}

	public double sueldoMenor() {
		double minSueldo = Double.MAX_VALUE;
		for (Docente d : doc) {
			double sueldo = d.sueldo();
			if (sueldo < minSueldo) {
				minSueldo = sueldo;
			}
		}
		return minSueldo;
	}

	public double tarifaMayor() {
		double maxTarifa = Double.MIN_VALUE;
		for (Docente d : doc) {
			double tarifa = d.getTarifa();
			if (tarifa > maxTarifa) {
				maxTarifa = tarifa;
			}
		}
		return maxTarifa;
	}

	public double tarifaMenor() {
		double minTarifa = Double.MAX_VALUE;
		for (Docente d : doc) {
			double tarifa = d.getTarifa();
			if (tarifa < minTarifa) {
				minTarifa = tarifa;
			}
		}
		return minTarifa;
	}
}