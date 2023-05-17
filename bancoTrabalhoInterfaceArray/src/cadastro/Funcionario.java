package cadastro;

public class Funcionario extends Pessoa{
	private int cargaHoraria;
	
	public Funcionario() {
		this.setEmprego("Banco NUBANK");
	}
	
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public void setCargo(String pcargo) {
		this.setEmprego(this.getEmprego()+" / "+pcargo);
	}
	
}