package banco;

public class CaixaEletronico {
		
	private String localizacao;
	private float limite;		 	//Limite de saque do Caixa
	private float saldo;
	private String leitorCartao;	//Leitor do Caixa
	private String identificacao;	//identificação(código) do Caixa
	
	/*===========--MÉTODOS--================*/
	
	//Retornar identificação
	public String getIdentificacao() {
		return this.identificacao;
	}
	
	//Validar e setar a Identificação
	public boolean setIdentificacao(String pidentificacao) {
		if(!pidentificacao.isEmpty() && pidentificacao.matches("[A-Z0-9]*")) {
			this.identificacao = pidentificacao;
			return true;
		}
		System.out.println("Identificação inválido");
		return false;
	}
	
	
	//Retornar a localização
	public String getLocalizacao() {return this.localizacao;}
	
	//Validar e setar a Localização
	public boolean setLocalizacao(String plocalizacao) {
		if(!plocalizacao.isEmpty()) {
			this.localizacao = plocalizacao;
			return true;
		}
		System.out.println("Locailização inválido");
		return false;
	}
	
	
	//Retornar o saldo
	public float getSaldo() {return this.saldo;}
	
	//Validar e setar o Saldo
	public Boolean setSaldo(float psaldo) {
		if(psaldo>0) {
			this.saldo = psaldo;
			return true;
		}
		System.out.println("Saldo inválido");
		return false;
	}
		
	
	//Retornar o limite
	public float getLimite() {return this.limite;}
	
	//Validar e setar o Limite
	public boolean setLimite(float plimite) {
		if(plimite<saldo) {
			this.limite = plimite;
			return true;
		}
		System.out.println("Limite invalido!!");
		return false;
	}
	
	//Retornar a localizaçãodd
	public String getLeitor() {return this.leitorCartao;}
	
	//Validar e setar o Leitor
	public boolean setLeitor(String pLeitor) {
		if(!pLeitor.isBlank()) {
			this.leitorCartao=pLeitor;
			return true;
		}
		System.out.println("Preencher o Leitor");
		return false;
		
	}
	
	
	//Retornar as informaçoes do Caixa Elêtronico 
	public String getInfo() {
		return "Identificação:"+this.getIdentificacao()+"\nSaldo:"+this.getSaldo()+
				"\nLimite:"+this.getLimite()+"\nLocalização:"+this.getLocalizacao()
				+"\nLeitor:"+this.getLeitor();
	}

}
