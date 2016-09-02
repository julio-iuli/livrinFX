package view;

import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Livro;

public class LivroPesquisaController {
	
	private ObservableList<Livro> listaLivros = FXCollections.observableArrayList();	
	@FXML
	private TableView<Livro> tabLivro;
	@FXML
	private TableColumn<Livro, String> colTitulo;
	@FXML
	private TableColumn<Livro, Number> colIdLivro;
	@FXML
	private TextField pesquisaField;
	
	// campos de detalhes do livro
	@FXML
	private Label tituloLabel;
	@FXML
	private Label autorLabel;
	@FXML
	private Label editoraLabel;
	@FXML
	private Label anoPublicacaoLabel;
	@FXML
	private Label donoLabel;
	
	public LivroPesquisaController() {}
	
	@FXML
	private void initialize() {
	
		try {
			listaLivros = Livro.getListaBD();
			tabLivro.setItems(listaLivros);
			colIdLivro.setCellValueFactory(cellData -> cellData.getValue().idLivroProperty());
			colTitulo.setCellValueFactory(cellData -> cellData.getValue().tituloProperty());
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tabLivro.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showDetalhesLivro(newValue));
		
	}
	
	@FXML
	private void handlePesquisar() {
		try {
			listaLivros = Livro.getListaBD(pesquisaField.getText());
			tabLivro.setItems(listaLivros);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void showDetalhesLivro(Livro livro) {
		if (livro != null) {
			System.out.println(livro.getTitulo());
			tituloLabel.setText(livro.getTitulo());
			System.out.println(livro.getIdAutor());
			Integer idautor = livro.getIdAutor();
			autorLabel.setText(idautor.toString());
		}
	}

}
