package view;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

public class rootController {
	
	@FXML
	private void abrirDono() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../view/dono.fxml"));
		HBox hBox = new HBox();
		hBox = loader.load();
		Main.getRoot().setCenter(hBox);
	}
	
	@FXML
	private void handlePesquisar() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../view/LivroPesquisa.fxml"));
		HBox hBox = new HBox();
		hBox = loader.load();
		Main.getRoot().setCenter(hBox);
	}

}
