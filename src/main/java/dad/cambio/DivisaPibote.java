package dad.cambio;

import javafx.event.ActionEvent;

public class DivisaPibote {	

	private String nombre;
	private Double tasa;

	public DivisaPibote(String nombre, Double tasa) {
		super();
		this.nombre = nombre;
		this.tasa = tasa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getTasa() {
		return tasa;
	}

	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}
	
	public Double fromEuro(Double euros) {
		return euros * tasa;
	}

	public Double toEuro(Double moneda) {
		return moneda / tasa;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
	
	public static Double fromTo(DivisaPibote from, DivisaPibote to, Double cantidad) {
		return to.toEuro(from.toEuro(cantidad));
	}

}
