package entities;

public class P_Fisica extends Contribuintes{
	protected Double gastosComSaude;
	
	public Double getGastoComSaude() {
		return gastosComSaude;
	}
	public void setGastoComSaude(Double gastosComSaude) {
		this.gastosComSaude = gastosComSaude;
	}
	
	public P_Fisica() {
		super();
	}
	public P_Fisica(String name, Double anualIncoming, Double gastosComSaude) {
		super(name, anualIncoming);
		this.gastosComSaude = gastosComSaude;
	}
	
	@Override
	public double paidTax() {
		double ir = 0;
		if(anualIncoming<20000) {
			ir = (anualIncoming *0.15)-(gastosComSaude*0.5);
		}
		else {
			ir = (anualIncoming *0.25)-(gastosComSaude*0.5);
		}
		return ir;
	}
	@Override
	public String toString() {
		return super.toString() + " - Gastos com saúde: $" + String.format("%.2f", gastosComSaude)+ " - IRPF: $"+String.format("%.2f", paidTax());
	}
	 
}
