package entities;

public abstract class Contribuintes {
	protected String name;
	protected Double anualIncoming;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getAnualIncoming() {
		return anualIncoming;
	}
	public void setAnualIncoming(Double anualIncoming) {
		this.anualIncoming = anualIncoming;
	}
	
	public Contribuintes() {
		
	}
	public Contribuintes(String name, Double anualIncoming) {
		this.name = name;
		this.anualIncoming = anualIncoming;
	}
	
	public abstract double paidTax();
	@Override
	
	public String toString() {
		return "Nome: " + name + " - Renda anual: $" + String.format("%.2f", anualIncoming);
	}
	
	
}
