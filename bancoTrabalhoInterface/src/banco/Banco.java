package banco;

public class Banco {
	
	private String codigo;
	private String endereco;	//Endereço SED do Banco
	private String nome;
	private String CNPJ;
	
	/*===========--MÉTODOS--================*/
	
	//Retornar o Código do Banco
	public String getCodigo() {return this.codigo;}
	
	//Validar e setar o Código
	public boolean setCodigo(String pcodigo) {
								//sistema só aceita validação de letras sem acentuação e números
		if(pcodigo.length()>0 && pcodigo.matches("[a-zA-Z0-9]*")) {
			this.codigo = pcodigo;
			return true;
		}
		System.out.println("Código inválido");
		return false;
	}
	
	
	
	//Retornar o endereço
	public String getEndereco() {return this.endereco;}
	
	//Validar e setar o Codigo
	public boolean setEndereco(String pendereco) {
		if(!pendereco.isEmpty()) {
			this.endereco = pendereco;
			return true;
		}
		System.out.println("Endereço inválido");
		return false;
	}
	

	
	//Retornar o nome
	public String getNome() {return this.nome;}
	
	//Validar e setar o nom
	public boolean setNome(String pnome) {
									//sistema só aceita validação de letras sem acentuação e números
		if(!pnome.isEmpty() && pnome.matches("^[A-Z][a-zA-Zéãçáéýúíûê\\s.]*")) {
			this.nome = pnome;
			return true;
		}
		System.out.println("Nome inválido");
		return false;
	}
	


	//Retornar o CNPJ
	public String getCNPJ() {return CNPJ;}
	
	//Validar e setar o CNPJ
	public boolean setCNPJ(String cNPJ) {
		if(cNPJ.length()>=14 && cNPJ.matches("[0-9.-/]*")) {
			this.CNPJ=cNPJ;
			return true;
		}
		System.out.println("CNPJ inválido");
		return false;
	}
	


	//Retornar informaçoes do Banco
	public String getInfo() {
		return "Nome:"+this.getNome()+"\nEndereço:"+this.getEndereco()+
				"\nCodigo:"+this.getCodigo()+"\nCNPJ"+this.getCNPJ();
	}
}
