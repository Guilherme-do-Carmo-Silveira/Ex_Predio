package controller;

import javax.swing.JOptionPane;

import docarmo.ListaObject.ListaEncadeadaObj;
import model.Morador;

public class ApartamentoController {

	ListaEncadeadaObj[] Tabela;

	public ApartamentoController() {
		Tabela = new ListaEncadeadaObj[10];
		IniciaTab();
	}

	private void IniciaTab() {
		int tam = Tabela.length;
		for (int i = 0; i < tam; i++) {
			Tabela[i] = new ListaEncadeadaObj();
		}
	}

	public String Registra() {

		Morador m = new Morador();
		m.morador = JOptionPane.showInputDialog("Insira o nome do Morador");
		do {
			m.NumAp = Integer.parseInt(JOptionPane.showInputDialog("Insira o numero do Apartamento"));
		} while (m.NumAp > 9999);
		m.ModeloCar = JOptionPane.showInputDialog("Insira o nome do carro");
		m.Cor = JOptionPane.showInputDialog("Insira a cor do carro");
		m.Placa = JOptionPane.showInputDialog("Insira a placa COM O TRAÇO");
		int valor = HashCode(m.NumAp);
		if (Tabela[valor].isEmpty()) {
			Tabela[valor].addFirst(m);
		} else {
			try {
				Tabela[valor].addLast(m);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return m.morador;
	}

	private int HashCode(int Nap) {
		String NumAp = Integer.toString(Nap);
		int tam = NumAp.length();
		if (tam < 4) {
			String posicao = NumAp.substring(0, 1);
			int andar = Integer.parseInt(posicao);
			return (andar - 1);
		} else {
			String posicao = NumAp.substring(0, 2);
			int andar = Integer.parseInt(posicao);
			return (andar - 1);
		}
	}

	public void Consultar() {

		int Nap = 0;

		do {
			Nap = Integer.parseInt(JOptionPane.showInputDialog("Insira o Número do Apartamento"));
		} while (Nap > 9999);

		int andar = Nap;

		Nap = HashCode(Nap);

		try {
			int tam = Tabela[Nap].size();
			boolean status = false;
			for (int i = 0; i < tam; i++) {
				Morador m = new Morador();
				m = (Morador) Tabela[Nap].get(i);
				if (andar == m.NumAp) {
					System.out.println("\nAPARTAMENTO " + m.NumAp);
					System.out.println(m);
					System.out.println("=====================================================================");
					break;
				}else if(i == tam -1){
					status = true;
				}
			}
			if(status == true) {
				System.out.println("\nApartamento " + andar + " nao foi encontrado\n");
				System.out.println("=====================================================================");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Excluir() {
		int Nap = 0;

		do {
			Nap = Integer.parseInt(JOptionPane.showInputDialog("Insira o Número do Apartamento"));
		} while (Nap > 9999);

		int andar = Nap;

		Nap = HashCode(Nap);

		try {
			int tam = Tabela[Nap].size();
			boolean status = false;
			for (int i = 0; i < tam; i++) {
				Morador m = new Morador();
				m = (Morador) Tabela[Nap].get(i);
				if (andar == m.NumAp) {
					Tabela[Nap].remove(i);
					System.out.println("\nApartamento " + andar + " foi excluido\n");
					System.out.println("=====================================================================");
					break;
				} else if(i == tam -1){
					status = true;
				}
			}
			if(status == true) {
				System.out.println("\nApartamento " + andar + " nao foi encontrado\n");
				System.out.println("=====================================================================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void MostraAndar() {

		int andar = 0;

		do {
			andar = Integer.parseInt(JOptionPane.showInputDialog("Insira o Número do Andar (1 - 10)"));
		} while (andar <= 0 || andar > 10);

		andar--;

		try {
			int tam = Tabela[andar].size();
			System.out.println("\nAPARTAMENTOS DO " + (andar + 1) + " ANDAR\n");
			for (int i = 0; i < tam; i++) {
				Morador m = new Morador();
				m = (Morador) Tabela[andar].get(i);
				System.out.println(m);
			}	
			System.out.println("======================================================================================");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
