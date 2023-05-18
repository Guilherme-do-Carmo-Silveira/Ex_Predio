package model;

public class Morador {
	
	public int NumAp;
	public String morador;
	public String ModeloCar;
	public String Cor;
	public String Placa;
	
	public int getNumAp() {
		return NumAp;
	}
	public void setNumAp(int numAp) {
		NumAp = numAp;
	}
	public String getMorador() {
		return morador;
	}
	public void setMorador(String morador) {
		this.morador = morador;
	}
	public String getModeloCar() {
		return ModeloCar;
	}
	public void setModeloCar(String modeloCar) {
		ModeloCar = modeloCar;
	}
	public String getCor() {
		return Cor;
	}
	public void setCor(String cor) {
		Cor = cor;
	}
	public String getPlaca() {
		return Placa;
	}
	public void setPlaca(String placa) {
		Placa = placa;
	}
	
	@Override
	public String toString() {
		return "Morador: " + morador + "\nNumAp: " + NumAp + "\nModeloCar: " + ModeloCar + "\nCor: " + Cor + "\nPlaca: " + Placa + "\n";
	}
	
	
}
