package entities;

public class P_Juridica extends Contribuintes{
	protected Integer n_funcionarios;
	
	public Integer getN_funcionarios() {
		return n_funcionarios;
	}
	public void setN_funcionarios(Integer n_funcionarios) {
		this.n_funcionarios = n_funcionarios;
	}
	public P_Juridica() {
		super();
	}
	public P_Juridica(String name, Double anualIncoming, Integer n_funcionarios) {
		super(name, anualIncoming);
		this.n_funcionarios = n_funcionarios;
	}
	
	@Override
	public double paidTax() {
		double ir = 0;
		if(n_funcionarios<10) {
			ir = (anualIncoming *0.16);
		}
		else {
			ir = (anualIncoming *0.14);
		}
		return ir;
	}
	@Override
	public String toString() {
		return super.toString() + " - Número de funcionários: " + n_funcionarios+ " - IRPJ: $"+String.format("%.2f", paidTax());
	}
	 
}
