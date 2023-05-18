package view;

import javax.swing.JOptionPane;

import controller.ApartamentoController;

public class main {

	public static void main(String[] args) {
		
		ApartamentoController c = new ApartamentoController();
		
		int opc = 0;
		String morador = "";
		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar usúario \n2 - Consultar Apartamento \n3 - Excluir Apartamento \n4 - Listar Andar \n9 - Finaliza"));
			switch (opc) {
			case 1:
				morador = c.Registra();
				System.out.println("\nO Morador(a) " + morador +" foi Cadastrado\n");
				System.out.println("=====================================================================");
				break;
			case 2:
				c.Consultar();
				break;
			case 3: 
				c.Excluir();
				break;
			case 4:
				c.MostraAndar();
				break;
			case 9:
				JOptionPane.showMessageDialog(null, "Programa finalizado");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção Inválida");
			} // FECHA SWITCH
		}
		
	}

}
