package application;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entities.Contribuintes;
import entities.P_Fisica;
import entities.P_Juridica;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date now = new Date();
		System.out.println(sdf.format(now));		
		System.out.println();
		
		List<Contribuintes> contribuintes = new ArrayList<>();
		System.out.print("Número de contribuintes: ");
		int n;
		try {
			n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("--- Contribuinte #"+i+" ---");
			System.out.print("Pessoa física ou juridica (F ou J): ");
			char tipo = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Renda anual: $");
			Double anualIncoming = sc.nextDouble();
			if(tipo == 'F' || tipo == 'f') {
				System.out.print("Gastos com saúde: $");
				Double gastosComSaude = sc.nextDouble();
				P_Fisica p_fisica = new P_Fisica(name, anualIncoming, gastosComSaude);
				contribuintes.add(p_fisica);
			}
			else if(tipo == 'J' || tipo == 'j') {
				System.out.print("Número de funcionários: ");
				int n_funcionarios = sc.nextInt();
				P_Juridica p_juridica = new P_Juridica(name, anualIncoming, n_funcionarios);
				contribuintes.add(p_juridica);
			}
			else {
				System.out.println("Tipo não identificado.");
			}
		}
		System.out.println();
		double sum=0;
		for(Contribuintes pessoas : contribuintes) {
			System.out.println(pessoas.toString());
			sum += pessoas.paidTax();
		}
		System.out.println();
		System.out.println("MONTANTE TOTAL: $"+String.format("%.2f", sum));
		
		sc.close();

		}
		catch (InputMismatchException e) {
			System.out.println("Ops, tem que ser um número!");
			//e.printStackTrace();
			System.out.println("Programa finalizado, vc não sabe brincar!");
			n=0;
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado.");
		}
	}

}
