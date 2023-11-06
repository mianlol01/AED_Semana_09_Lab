package arreglo;

import clase.Factura;
import java.util.ArrayList;

public class ArregloFacturas {
	private ArrayList<Factura> fac;

	public ArregloFacturas() {
		fac = new ArrayList<Factura>();
		adicionar(new Factura("123456789", "Bethesda", 5, 10.0));
		adicionar(new Factura("987654321", "Ubisoft", 8, 8.5));
		adicionar(new Factura("567890123", "Activision", 10, 7.0));
		adicionar(new Factura("111222333", "Valve", 3, 3));
		adicionar(new Factura("444555666", "Square Enix", 6, 12.0));
		adicionar(new Factura("777888999", "Konami", 7, 11.5));
		adicionar(new Factura("333222111", "Rockstar", 6, 6));
		adicionar(new Factura("666555444", "CapCom", 9, 9.5));
	}

	public void adicionar(Factura f) {
		fac.add(f);
	}

	public int tamanio() {
		return fac.size();
	}

	public Factura obtener(int i) {
		return fac.get(i);
	}

	public double sumaImportesFacturados() {
		double total = 0.0;
		for (Factura f : fac) {
			total += f.importeFacturado();
		}
		return total;
	}

	public double importePromedioFacturado() {
		if (fac.isEmpty()) {
			return 0.0;
		}

		double total = sumaImportesFacturados();
		return total / fac.size();
	}

	public double importeMenorFacturado() {
		double min = Double.MAX_VALUE;
		for (Factura f : fac) {
			double importe = f.importeFacturado();
			if (importe < min) {
				min = importe;
			}
		}
		return min;
	}

	public double importeMayorFacturado() {
		double max = Double.MIN_VALUE;
		for (Factura f : fac) {
			double importe = f.importeFacturado();
			if (importe > max) {
				max = importe;
			}
		}
		return max;
	}

	public String primeraEmpresaConImporteMenorAlPromedio() {
		double promedio = importePromedioFacturado();
		for (Factura f : fac) {
			if (f.importeFacturado() < promedio) {
				return f.getEmpresa();
			}
		}
		return null;
	}
}