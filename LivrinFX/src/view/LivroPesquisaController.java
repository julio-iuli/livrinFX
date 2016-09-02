package view;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Livro;

public class LivroPesquisaController {
	
	
	@FXML
	private TableView<Livro> tabLivro;
	@FXML
	private TableColumn<Livro, String> colTitulo;
	@FXML
	private TableColumn<Livro, Number> colIdLivro;
	
	public LivroPesquisaController() {}
	
	@FXML
	private void initialize() {
	
		try {
			tabLivro.setItems(Livro.getListaBD());
			colIdLivro.setCellValueFactory(cellData -> cellData.getValue().idLivroProperty());
			colTitulo.setCellValueFactory(cellData -> cellData.getValue().tituloProperty());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@FXML
	private void handlePesquisar() {
		
	}
	

}
