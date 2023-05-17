package principal;

import java.util.ArrayList;

/*
 * CRIADO POR FELIPE VIEIRA
 *
 *
 *
 *
*/

//import java.util.ArrayList;
//import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import cadastro.Conta;
import cadastro.Pessoa;

public class Main {//Interface (MVC) - Model View Controller

	public static void main(String[] args) {
		/*
	 	1) Abrir a conta
		2) Cadastrar o cliente
		3) Definir o titular da conta -> Conta -> Cliente
		4) Sacar
		5) Depositar
		6) Mostrar os dados da conta: cliente, número da conta e saldo
		*/
		
		System.out.println("-");
		
		JLabel text=new JLabel("ESCOLHA A OPÇÃO");
		JComboBox<Object> menu = new JComboBox<>();
		
		menu.addItem("Abrir Conta");
		menu.addItem("Remover Conta");
		menu.addItem("Cadastar Cliente");
		menu.addItem("Remover Cliente");
		menu.addItem("Definir o titular Conta");
		menu.addItem("Sacar");
		menu.addItem("Depositar");
		menu.addItem("Mostrar Informaçoes Conta");
		menu.addItem("Sair do Programa");
		

		ArrayList<Conta> contaList = new ArrayList<Conta>();
		ArrayList<Pessoa> clienteList = new ArrayList<Pessoa>();
		
		do {
		
			Object[] components= {text,menu};
			JOptionPane.showMessageDialog(null, components,"Informe",JOptionPane.OK_CANCEL_OPTION);
	
			switch(menu.getSelectedItem().toString()) {
				case "Abrir Conta":
					Conta contaBuff = new Conta();
					
					contaBuff.setToken();
					
					System.out.println(contaBuff.getToken());
					JOptionPane.showMessageDialog(null,"TOKEN DA CONTA\n"+contaBuff.getToken(),"TOKEN",JOptionPane.OK_CANCEL_OPTION);
					
					//Abrir a Conta
					//Todos os dados da conta,exceto saldo e limite
					
					JLabel lbDigito = new JLabel("Digito:");
					JTextField DigitoText = new JTextField();
					
					JLabel lbNovaSenha = new JLabel("Nova Senha:");
					JTextField NovaSenhaText = new JTextField();
					
					JLabel lbSenha = new JLabel("Digite Senha Novamente:");
					JTextField SenhaNovamenteText = new JTextField();
					
					
					JLabel lbNumero = new JLabel("Número");
					JFormattedTextField numeroText = null;
					
					JLabel lbBiometria = new JLabel("Biometria:");
					JTextField BiometriaText = new JTextField();
					
					JLabel lbToken = new JLabel("Token");
					JTextField tokenText = new JTextField();
					
					try {
						numeroText=new JFormattedTextField(new MaskFormatter("####-####-####-####"));
					}catch (Exception error) {
						//Não criou máscara exibir mensagem de erro e sair do programa
						JOptionPane.showMessageDialog(null,"ERRO JFormattedTextField",null, JOptionPane.OK_CANCEL_OPTION);
						System.exit(-1);
					}					
					
					
					//Array de objetos da interface Abrir conta
					Object[] abriConta = { lbDigito,DigitoText,
											lbNovaSenha,NovaSenhaText,
											lbSenha,SenhaNovamenteText,
											lbBiometria,BiometriaText,
											lbNumero,numeroText,
											lbToken,tokenText};
										
					do {						
						JOptionPane.showMessageDialog(null,abriConta,"Abrir Conta",JOptionPane.OK_CANCEL_OPTION);
						
						contaBuff.setDigito(DigitoText.getText());
						contaBuff.setNumero(numeroText.getText());
						contaBuff.setBiometria(BiometriaText.getText());
						//Não sair da interface enquanto não validar o Token e setar a senha do usúario
					}while(!contaBuff.getToken().equals(tokenText.getText()) || !contaBuff.setSenha(NovaSenhaText.getText(), SenhaNovamenteText.getText()));
							
					Object[] mostraConta = {new JLabel("Número:"+contaBuff.getNumero()),
											new JLabel("TOKEN:"+contaBuff.getToken()),
											new JLabel("Digito:"+contaBuff.getDigito())
											};
					
					JOptionPane.showMessageDialog(null,mostraConta,"Informaçoes Cliente",JOptionPane.OK_CANCEL_OPTION);
					
					contaList.add(contaBuff);
				break;
				case "Remover Conta":
					System.out.println(contaList.size());
					
					JLabel  lbContaID=new JLabel("ID da Conta");
					JTextField contaIDText = new JTextField();
					
					do {
						JOptionPane.showMessageDialog(null,new Object[] {lbContaID,contaIDText},"Informaçoes Cliente",JOptionPane.OK_CANCEL_OPTION);
					
					}while(contaIDText.getText().isBlank() || !contaIDText.getText().matches("[0-9]*"));

					int idConta = Integer.parseInt(contaIDText.getText());
					

					if(idConta<=contaList.size()-1) {
						contaList.remove(idConta);
					}else JOptionPane.showMessageDialog(null,"ID de conta não existente","Informaçoes Cliente",JOptionPane.OK_CANCEL_OPTION);
					
				break;
				case "Cadastar Cliente":
					
					Pessoa cliente = new Pessoa();
					
					
					//Nome do Cliente
					JLabel lbNomeCliente = new JLabel("Nome");
					JTextField txNomeCliente = new JTextField();
					
					//CPF do Cliente
					JLabel lbCpfCliente = new JLabel("CPF");
					JFormattedTextField txCpfCliente=null;
					
					//Telefone do Cliente
					JLabel lbEmpregoCliente = new JLabel("Emprego");
					JTextField txEmpregoCliente = new JTextField();
					
					//Endereço do Cliente
					JLabel lbEndereçoCliente = new JLabel("Endereço");
					JTextField txendereçoCliente = new JTextField();
					
					//Renda do Cliente
					JLabel lbRendaCliente = new JLabel("Renda");
					JTextField txRendaCliente = new JTextField();
					
					//Endereço do Cliente
					JLabel lbCodigoCliente = new JLabel("Codigo");
					JTextField txCodigoCliente = new JTextField();
					
					//Telefone do Cliente
					JLabel lbTelefoneCliente = new JLabel("Telefone");
					JFormattedTextField txTelefoneCliente=null;
					
					//Tentar criar máscara para CPF e Telefon
					try {
						txCpfCliente=new JFormattedTextField(new MaskFormatter("###.###.###-##"));		
						txTelefoneCliente=new JFormattedTextField(new MaskFormatter("(##)#########"));		
					}catch (Exception e) {
						JOptionPane.showMessageDialog(null,e.getCause(),null, JOptionPane.OK_CANCEL_OPTION);
						System.exit(-1);
					}		
					
					
					
					Object[] cadastroCliente= {lbNomeCliente,txNomeCliente,
												lbCpfCliente,txCpfCliente,
												lbCodigoCliente,txCodigoCliente,
												lbTelefoneCliente,txTelefoneCliente,
												lbEmpregoCliente,txEmpregoCliente,
												lbEndereçoCliente,txendereçoCliente,
												lbRendaCliente,txRendaCliente};					
					
					do {
						JOptionPane.showMessageDialog(null,cadastroCliente,"Cadastar Cliente",JOptionPane.OK_CANCEL_OPTION);
						cliente.setEmprego(txEmpregoCliente.getText());
											
					}while(!cliente.setNome(txNomeCliente.getText())|| !cliente.setTelefone(txTelefoneCliente.getText()) ||
							!cliente.setCPF(txCpfCliente.getText()) || !cliente.setCodigo(txCodigoCliente.getText()) || !cliente.setRenda(txRendaCliente.getText()) );
					
					//Interface data
					
					JLabel lbDiaNascimento = new JLabel("DIA");
					JFormattedTextField txDia = null;
										JLabel lbMesNascimento = new JLabel("MES");
					JFormattedTextField txMes = null;

					JLabel lbAnoNascimento = new JLabel("ANO");
					JFormattedTextField txAno = null;
					
					try {
						txDia=new JFormattedTextField(new MaskFormatter("##"));		
						txMes=new JFormattedTextField(new MaskFormatter("##"));	
						txAno=new JFormattedTextField(new MaskFormatter("####"));	
					}catch (Exception e) {
						JOptionPane.showMessageDialog(null,e.getCause(),null, JOptionPane.OK_CANCEL_OPTION);
						System.exit(-1);
					}	
					
					Object[] DataNascimento= {lbDiaNascimento,txDia,lbMesNascimento,txMes,lbAnoNascimento,txAno};
					
					do {
					JOptionPane.showMessageDialog(null,DataNascimento,"DATA Nascimento",JOptionPane.OK_CANCEL_OPTION);
					}while(txDia.getText().isBlank() || txMes.getText().isBlank() || txAno.getText().isBlank());
					
					cliente.setDataNascimento(Integer.parseInt(txDia.getText()),Integer.parseInt(txMes.getText()),Integer.parseInt(txAno.getText()));
					
					
					clienteList.add(cliente);
				break;
				case "Remover Cliente":
					System.out.println(clienteList.size());
					
					JLabel  lbClienteID1=new JLabel("ID do cliente");
					JTextField clienteIDText = new JTextField();
					
					do {
						JOptionPane.showMessageDialog(null,new Object[] {lbClienteID1,clienteIDText},"Informaçoes Cliente",JOptionPane.OK_CANCEL_OPTION);
					
					}while(clienteIDText.getText().isBlank() || !clienteIDText.getText().matches("[0-9]*"));

					int idCliente = Integer.parseInt(clienteIDText.getText());
					

					if(idCliente<=clienteList.size()-1) {
						contaList.remove(idCliente);
					}else JOptionPane.showMessageDialog(null,"ID de conta não existente","Informaçoes Cliente",JOptionPane.OK_CANCEL_OPTION);
					
				break;
				/*
				case "Definir o titular Conta":
					conta.setTitular(cliente);
				break;
				
				case "Sacar":
					JLabel lbSacarSenha = new JLabel("Senha");
					JTextField sacarSenhaText = new JTextField();
					
					JLabel lbSaqueSenha = new JLabel("Saque");
					JTextField saqueText = new JTextField();
										
					Object[] sacarComponente = {lbSacarSenha,sacarSenhaText,lbSaqueSenha,saqueText};
					
					do {
						JOptionPane.showMessageDialog(null,sacarComponente,"Sacar",JOptionPane.OK_CANCEL_OPTION);
					}while(!conta.setSaldo(saqueText.getText(),sacarSenhaText.getText()));
					
					JOptionPane.showMessageDialog(null,"Saldo:"+conta.getSaldo()+"\nLimite"+conta.getLimite(),"Sacar",JOptionPane.OK_CANCEL_OPTION);
				break;
				case "Depositar":
					
					JTextField depositarText=new JTextField();
					Object[] depositarComponente = {new JLabel("Valor Deposito"),depositarText};
					
					do {
						JOptionPane.showMessageDialog(null,depositarComponente,"Depositar",JOptionPane.OK_CANCEL_OPTION);
					}while(!conta.depositar(depositarText.getText()));
					
					JOptionPane.showMessageDialog(null,"Saldo:"+conta.getSaldo(),"Sacar",JOptionPane.OK_CANCEL_OPTION);
				break;
				case "Mostrar Informaçoes Conta":
					
					if(conta.getTitular()!=null) {
						Object[] informacoesConta= {
								new JLabel("Conta:"),
								new JLabel("Digito:"+conta.getDigito()),
								new JLabel("Número:"+conta.getNumero()),
								new JLabel("Saldo:"+conta.getSaldo()),
								new JLabel("Limite:"+conta.getLimite()),
								new JLabel("Titular"),
								new JLabel("Nome:"+conta.getTitular().getNome()),
								new JLabel("Telefone:"+conta.getTitular().getTelefone()),
								new JLabel("CPF:"+conta.getTitular().getCPF()),
						};
						
						
						JOptionPane.showMessageDialog(null,informacoesConta,"Informaçoes",JOptionPane.OK_CANCEL_OPTION);
					
					}else JOptionPane.showMessageDialog(null,"Essa conta não tem TITULAR.","ERROR",JOptionPane.OK_CANCEL_OPTION);
				break;
				*/
			}
		

			
		}while(!menu.getSelectedItem().equals("Sair do Programa"));
		
		for(Conta c:contaList) {
			System.out.println(c.getBiometria());
		}
		for(Pessoa c:clienteList) {
			System.out.println(c.getCPF());
		}
	}

}