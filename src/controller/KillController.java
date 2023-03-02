package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class KillController {
	
	public KillController(){
		super();
		
	}
	
	/**
		 * Método que retorna o Nome do Sistema Operacional
		 * @
		 */
		public String osName() {
			String os = System.getProperty("os.name");
			return os;
		}
			
		 public String getOSVersion() {  
			 String os =System.getProperty("os.version"); 
		        return os;  
		    }  
		

		public void ListaTarefas() {

			String comando="";
			if (System.getProperty("os.name").contains("Windows")) {			
				comando = "tasklist /FO TABLE";	
			} else {			
				comando = ("ps -ef");
			}
			
			try {
				Process processo = Runtime.getRuntime().exec(comando.toString());
				InputStream fluxo = processo.getInputStream();
				InputStreamReader LerFluxo = new InputStreamReader(fluxo);
				BufferedReader bufferLeitura = new BufferedReader(LerFluxo);
				String linha = bufferLeitura.readLine();

				while (linha != null) {
					System.out.println(linha);
					linha = bufferLeitura.readLine();
				}

			} catch (IOException e) {
				e.printStackTrace();
				try {  
				      Process p = Runtime.getRuntime().exec("ps ax"); //aqui fica o comando que vai pegar os processos  
				  
				      BufferedReader resultado = new BufferedReader(new InputStreamReader(p.getInputStream()));  
				  
				      //mostra os resultados obtidos pelo comando 'ps ax'  
				      String s;  
				      while ((s = resultado.readLine()) != null)  
				        System.out.println(s);  
				    } catch (Exception ex) {  
				      ex.printStackTrace();  
				    }  

			}

		}

		public void MataProcesso(String Identificacao) {
			
			String cmdPid = "";
			String cmdNome = "";
			
			
			if (System.getProperty("os.name").contains("Windows")) {			
				cmdPid = "taskkill /PID ";
				cmdNome = "taskkill /IM ";
			} else {			
				cmdPid = "kill -9 ";
				cmdNome = " pkill -f ";
			}
			

			StringBuffer buffer = new StringBuffer();
			int pid = 0;

			try {
				pid = Integer.parseInt(Identificacao);
				buffer.append(cmdPid);
				buffer.append(pid);
			} catch (NumberFormatException e) {
			
				buffer.append(cmdNome);
				buffer.append(Identificacao);

			}
			try {
				Process processo = Runtime.getRuntime().exec(buffer.toString());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO",
						JOptionPane.ERROR_MESSAGE);
			}

		}

}
