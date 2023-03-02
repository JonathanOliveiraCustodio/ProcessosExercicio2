package view;

import javax.swing.JOptionPane;

import controller.KillController;


public class Principal {

	public static void main(String[] args) {
		// Instancia da Classe OpProc
		KillController Operacoes = new KillController();
		
		// 1° Chamado Identifica o SO
		String os = Operacoes.osName();
		System.out.println(os);
		
		// 2° Chamado Lista os Processos Windows ou Linux
		Operacoes.ListaTarefas();
		
		// 3° Chamado Mata Por PID Windows ou Linux
		Operacoes.MataProcesso(JOptionPane.showInputDialog(null, "Informe um PID :"));
		
		// 4° Chamado Mata Por Nome Windows ou Linux
		Operacoes.MataProcesso(JOptionPane.showInputDialog(null, "Informe um Nome: :"));
		
		


	}

}
