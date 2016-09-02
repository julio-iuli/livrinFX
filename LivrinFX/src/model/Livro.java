package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import application.Conexao;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Livro {
	
	private IntegerProperty idLivro;
	private StringProperty titulo;
	private IntegerProperty idAutor;
	//private IntegerProperty idEditora;
	//private IntegerProperty idDono;
	// falta o ano de publicação
	
	public Livro(int idlivr, String tit, int idaut) {
		this.idLivro = new SimpleIntegerProperty(idlivr);
		this.titulo = new SimpleStringProperty(tit);
		this.idAutor = new SimpleIntegerProperty(idaut);
	}
	
	//idLivro
	public IntegerProperty idLivroProperty() {
		if (idLivro == null) idLivro = new SimpleIntegerProperty(this, "idLivro");
		return idLivro;
	}
	public void setIdLivro(int idLivro) {idLivroProperty().set(idLivro);}
	public int getIdLivro() {return idLivroProperty().get();}
	
	//título
	public StringProperty tituloProperty() {
		if (titulo == null) titulo = new SimpleStringProperty(this, "titulo");
		return titulo;
	}
	public void setTitulo(String titulo) {tituloProperty().set(titulo);}
	public String getTitulo() {	return tituloProperty().get();}
	
	//idAutor
	public IntegerProperty idAutorProperty() {
		if (idAutor == null) idAutor = new SimpleIntegerProperty(this, "idAutor");
		return idAutor;
	}
	public void setIdAutor(int idAutor) {idAutorProperty().set(idAutor);}
	public int getIdAutor() {return idAutorProperty().get();}
	
	public static ObservableList<Livro> getListaBD() throws SQLException{
		ObservableList<Livro> listaBD = FXCollections.observableArrayList();
		Connection connection = Conexao.getConexao();
		String sql = "SELECT idlivro, titulo, autor_idautor FROM livro";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()){
			listaBD.add(new Livro(resultSet.getInt("idlivro"), resultSet.getString("titulo"), resultSet.getInt("autor_idautor")));			
		}
		resultSet.close();
		statement.close();
		connection.close();
		return listaBD;
	}
}
