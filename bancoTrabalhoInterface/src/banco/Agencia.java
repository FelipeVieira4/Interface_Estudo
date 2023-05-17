package banco;

public class Agencia {
	
	private String codigo;
	private String nome;
	private String email;		//Email de contado
	private String telefone;	//Telefone de contado
	private String endereco;
	
	/*===========--MÉTODOS--================*/
	
	//Retornar Código
	public String getCodigo() { return this.codigo; }
	
	//Validar e setar o Código
	public boolean setCodigo(String pcodigo) {
	    // sistema só aceita validação de  números
	    if (pcodigo.length() > 0 && pcodigo.matches("[0-9]*")) {
	      this.codigo = pcodigo;
	      return true;
	    }
	    System.out.println("Código inválido");
	    return false;
	 }
	
	//Retornar o Nome
	public String getNome() { return this.nome; }
	
	//Validar e setar o Nome
	public boolean setNome(String pnome) {
	    // sistema só aceita validação de letras sem acentuação e números
	    if (!pnome.isEmpty() && pnome.matches("^[A-Z][a-zA-Zéãçáéýúíûê\\s.]*")) {
	      this.nome = pnome;
	      return true;
	    }
	    System.out.println("Nome inválido");
	    return false;
	}
	
	//Retornar o Email
	public String getEmail() { return this.email; }
	
	//Validar e setar o Emails
	public boolean setEmail(String pemail) {
	    if (!pemail.isEmpty()) {
	      this.email = pemail;
	      return true;
	    }
	    System.out.println("Email inválido");
	    return false;
	}
	
	//Retornar o Endereço
	public String getEndereco() { return this.endereco; }
	
	//Validar e setar o Endereço
	public boolean setEndereco(String pendereco) {
	    if (!pendereco.isEmpty()) {
	      this.endereco = pendereco;
	      return true;
	    }
	    System.out.println("Endereço inválido");
	    return false;
	}
	
	//Retornar o Telefone
	public String getTelefone() { return this.telefone; }
	
	//Validar e setar o Telefone
	public boolean setTelefone(String ptelefone) {
	
	    if ((ptelefone.length() >= 11) && (ptelefone.matches("[0-9()\\s]*"))) {
	      this.telefone = ptelefone;
	
	      return true;
	    }
	    System.out.println("Número de telefone ínvalido!!");
	    return false;
	}
	
	
	//Retornar as informaçoes da Agência
	public String getInfo() {
	    return "Nome:" + this.nome + "\nEndereço:" + this.endereco +
	           "\nCodigo:" + this.codigo + "\nTelefone:" + this.telefone;
	}
}
