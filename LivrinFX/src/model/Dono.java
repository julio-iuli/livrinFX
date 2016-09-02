package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Dono {
	
	private StringProperty nomeDono;
	private IntegerProperty idDono;
	
	public Dono(String nomeDono, int idDono) {
		this.nomeDono = new SimpleStringProperty(nomeDono);
		this.idDono = new SimpleIntegerProperty(idDono);
	}
	

	// javabeamsFX do nomeDono
	public String getNomeDono() {
		return nomeDono.get();
	}
	public void setNomeDono(String nome) {
		this.nomeDono.set(nome);
	}
	public StringProperty nomeDonoPropriety() {
		return nomeDono;
	}
	
	// javabeamsFX do idDono
	public int getIdDono() {
		return idDono.get();
	}
	public void setIdDono(int idDono) {
		this.idDono.set(idDono);
	}
	public IntegerProperty idDonoPropriety() {
		return idDono;
	}
	

}
