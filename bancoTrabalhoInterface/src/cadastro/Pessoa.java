package cadastro;

import java.util.ArrayList;
import java.util.Calendar;

public class Pessoa{
    //Atributos:
    private String nome; //char nome[30]
    private String cpf;
    private Calendar dataNascimento = Calendar.getInstance();
    private String endereco; //( Rua, Número, Bairro, Cidade)
    private String telefone;
    private String codigo;
    private float rendaMensal;
    private String emprego;
    
    private ArrayList<String> contaTokensList = new ArrayList<String>();
    
    //Métodos:
    
    
    public boolean hasToken(String token) {
    	
    	for(String tokenC:contaTokensList) {
    		if(tokenC.equals(token))return true;
    	}
    	
    	return false;
    }
    
    
    /* ============================================ */
    public void setDataNascimento(int dia,int mes,int ano) {
		//seta a data de nascimento
		dataNascimento.set(ano,mes-1,dia);

		return;
    }
    
    public void escreverDataNascimento() {
        System.out.println("Data Nascimento:"+
        		dataNascimento.get(Calendar.DAY_OF_MONTH)
        		+"/"+dataNascimento.get(Calendar.MONTH)
        		+"/"+dataNascimento.get(Calendar.YEAR));
        return ;
    }
    
    public Calendar getCalendario() {
    	return this.dataNascimento;
    }
    

    /* ============================================ */
    public boolean setNome(String pnome){
        if((pnome.length()>0) && (pnome.matches("^[A-Z][a-zA-Zéãçáéýúíûê\\s]*"))){
            this.nome=pnome;
            return true;
        }
        System.out.println("\nNome ínvalido!!");
        
        
        return false;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    /* ============================================ */
    public boolean setCodigo(String pcodigo){
        if((pcodigo.length()>0) && (pcodigo.matches("[0-9]*"))){
            this.codigo=pcodigo;
            return true;
        }
        System.out.println("\nCodigo ínvalido!!");
        
        return false;
    }
    
    public String getCodigo(){
        return this.codigo;
    }
    
    /* ============================================ */
    public boolean setCPF(String pCpf){
      if((pCpf.length()>=11) && (pCpf.matches("[0-9.-]*"))){
        this.cpf=pCpf;
        
        return true;
      }
      System.out.println("CPF ínvalido!!");
      return false;
    }
    
    public String getCPF(){
      return this.cpf;
    }
    
    /* ============================================ */
    public boolean setTelefone(String ptelefone){
        if((ptelefone.length()>=11) && (ptelefone.matches("[0-9()\\s]*"))){
          this.telefone=ptelefone;
          
          return true;
        }
        System.out.println("Telefone ínvalido!!");
        return false;
      }
      
    public String getTelefone(){
      return this.telefone;
    }
   
    /* ============================================ */
    public void setEmprego(String pemprego){
          this.emprego=pemprego;
     }
      
    public String getEmprego(){
      return this.emprego;
    }
    
    /* ============================================ */
    public void setEndereco(String pendereco){
          this.endereco=pendereco;
     }
      
    public String getEndereco(){
      return this.endereco;
    }
    
    /* ============================================ */
    public boolean setRenda(String renda){
    	
        if(renda.matches("[0-9.]*")){
          this.rendaMensal=Float.parseFloat(renda);
          return true;
        }
        System.out.println("Renda ínvalido!!");
        return false;
      }
      
    public float getRendaMensal(){
      return this.rendaMensal;
    }
}