package view;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import application.Conexao;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import model.Dono;

public class donoController {
	
	@FXML
	private TableView<Dono> donoTable;
	@FXML
	private TableColumn<Dono, String> nomeDonoColumn;
	@FXML
	private TableColumn<Dono, Number> idDonoColumn; // contraintuitivamente, usa number :/
	
	public ObservableList<Dono> listaDono = FXCollections.observableArrayList();
	
	public donoController() {
		// TODO Auto-generated constructor stub
	}
	
	@FXML
	private void initialize() throws SQLException {
		
		Connection con = Conexao.getConexao();
		PreparedStatement statement = con.prepareStatement("SELECT nomedono, iddono FROM dono");
		ResultSet resultSet = statement.executeQuery();
		String nome;
		int iddono;
		
		while(resultSet.next()){
			nome = resultSet.getString("nomedono");
			iddono = resultSet.getInt("iddono");
			System.out.println(nome + iddono);
			listaDono.add(new Dono(nome, iddono));
			
		}
		
		resultSet.close();
		statement.close();
		con.close();
		
		//nomeDonoColumn.setCellValueFactory(new PropertyValueFactory("nomeDono"));
		nomeDonoColumn.setCellValueFactory(cellData -> cellData.getValue().nomeDonoPropriety());
		//idDonoColumn.setCellValueFactory(new PropertyValueFactory("idDono"));
		idDonoColumn.setCellValueFactory(cellData -> cellData.getValue().idDonoPropriety());
		donoTable.setItems(listaDono);
		//donoTable.getColumns().setAll(nomeDonoColumn, idDonoColumn);
		donoTable.setEditable(true);
		nomeDonoColumn.setEditable(true);
		nomeDonoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	}
	
	@FXML
	private void handlerCancelar() {
		Main.getRoot().setCenter(null);
	}
	
	@FXML
	private void handlerSalvar() throws SQLException{
		// testando a conexão com o Banco de Dados
		Connection con = Conexao.getConexao();
		PreparedStatement statement = con.prepareStatement("SELECT nomedono, iddono FROM dono");
		ResultSet resultSet = statement.executeQuery();
		String nome;
		int iddono;
		
		while(resultSet.next()){
			nome = resultSet.getString("nomedono");
			iddono = resultSet.getInt("iddono");
			System.out.println(nome + iddono);
			
		}
		
		
		resultSet.close();
		statement.close();
		con.close();
			
		}

}
