package cadastro;

import java.util.Random;

public class Conta {
	
	private String numeroTalefone;
	private String digito;
	
	//(sacar)(valor) verificar -> saldo+limite /verificar senha/atualizar saldo
	//depositar(valor) -> atualizar saldo
	
	private double saldo=0;
	private String senha="";
	private double limite=120;
	private String token;
	private String biometria;
	private Pessoa titular;
	
	private byte tentativasGetSenha=0;
	
	
	
	public Pessoa getTitular() {
		return titular;
	}
	public void setTitular(Pessoa titular) {
		this.titular = titular;
	}
	
	
	public String getNumero() {
		return numeroTalefone;
	}
	public void setNumero(String numero) {
		this.numeroTalefone = numero;
	}
	
	
	public String getDigito() {
		return digito;
	}
	public void setDigito(String digito) {
		this.digito = digito;
	}
	
	public double getLimite() {return this.limite;}
	//=============================================================
	
	/* Método usado para validar senha de acesso a uma Conta no banco */
	public boolean validaSenha(String senha) {
		
		if(this.senha.equals(senha) && tentativasGetSenha<=3 && !this.senha.isBlank()) {
			return true;
		}
		else {
			if(tentativasGetSenha<=3) {
				tentativasGetSenha++;
				System.out.println("Tentativas:"+tentativasGetSenha);
			}else 
				System.out.print("Excedeu número de tentativas.");
		}
		
		return false;
	}
	
	
	/* Método usado para alterar ou criar uma nova senha */
	public boolean setSenha(String senha1,String senha2) {
		
		if(senha1.equals(senha2) && !senha1.isBlank())
			if(!this.senha.equals(senha1)) {
				this.senha = senha1;
				System.out.println("Senha Alterada com Sucesso!");
				return true;
			}
			else System.out.println("A deve ser diferente da senha atual.");
		else System.out.println("Erro nas Senhas"); 
			
		return false;
	}
	
	/* Método usado para fazer saque de uma determinada quantia */
	public boolean setSaldo(String saque,String senha) {
							// saque (String) tiver apena números e "."  E saque (String) não ser VAZIO
		if(validaSenha(senha) && saque.matches("[0-9.]*") && !saque.isBlank()) {
				
			double saqueDouble = Double.parseDouble(saque);
		
			if(saqueDouble>=0) {
								
				if(this.saldo>=saqueDouble) {//sacar do saldo
					this.saldo-=saqueDouble;
					return true;
				}else if(this.limite>=saqueDouble) {//sacar do limite
					this.limite-=saqueDouble;
					return true;
				}
			}			
			
		}
		return false;
	}
	
	public double getSaldo() {return this.saldo;}
	
	
	public boolean depositar(String valor) {
		   //valor (String) tiver apena números e "."  E valor (String) não ser VAZIO
		if(valor.matches("[0-9.]*") && !valor.isBlank()) {
			this.saldo+=Double.parseDouble(valor);
			return true;
		}
		return false;
	}
	
	//=======================================================
	
	public String getToken() {
		return token;
	}
	public void setToken() {
		//token (String) = valor (String) de random (Int)
		this.token = String.valueOf(new Random().nextInt(999999));
	}
	
	public String getBiometria() {
		return biometria;
	}
	public void setBiometria(String biometria) {
		this.biometria = biometria;
	}

	
	
	
}