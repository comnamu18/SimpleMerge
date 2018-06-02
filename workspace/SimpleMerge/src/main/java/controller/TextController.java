package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ListView.EditEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.StringConverter;
import model.Line;
import model.SubModel;
import model.TextPage;

public class TextController implements Initializable {
    @FXML private BorderPane root;
    @FXML private AnchorPane buttonPane;
    @FXML private Button load;
    @FXML private ToggleButton edit;
    @FXML private Button save;
    @FXML private BorderPane textPane;
    @FXML private TextField title;
    @FXML private ListView<Line> text;
    
    private TextPage textPage;
	private SubModel subModel;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		load.setLayoutX(0);
		edit.setLayoutX(0);
		save.setLayoutX(0);

		edit.translateXProperty().bind(load.widthProperty());
		save.translateXProperty().bind(Bindings.add(load.widthProperty(), edit.widthProperty()));
		
		text.setCellFactory(TextFieldListCell.forListView(new StringConverter<Line>() {
			@Override
			public Line fromString(String string) {
				return new Line(string);
			}
			@Override
			public String toString(Line line) {
				return line.toString();
			}
		}));
	}
    
    public DoubleProperty preWidthProperty() {
    	return root.prefWidthProperty();
    }
    
	private void fileLoad() {
		if(subModel.isModified()) {
			//TODO need to verify 'User want to load'
		}
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt"));
		fileChooser.getExtensionFilters().add(new ExtensionFilter("All Files", "*.*"));
		File file = fileChooser.showOpenDialog(null);
		if(file == null || file.getAbsolutePath() == null || file.getAbsolutePath().equals("")) return;
		text.getItems().clear();
		title.clear();
		textPage.setFilePath(file);
		if(text.getItems().isEmpty()) {
			addEmptyLine();
		}
		subModel.setIsEditable(false);
	}
	
	@SuppressWarnings("unchecked")
	private void addEmptyLine() {
		((List<Line>) textPage.getListProperty()).add(new Line(""));
	}

	private void fileSave() {
		try {
			FileChooser fileChooser = new FileChooser();
			fileChooser.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt"));
			fileChooser.getExtensionFilters().add(new ExtensionFilter("All Files", "*.*"));
			File file = fileChooser.showSaveDialog(null);
			if (file != null) {
				try{
					FileWriter writer = null;
					writer = new FileWriter(file);
					writer.write(textPage.getTextField());
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		subModel.setIsModified(false);
		subModel.setIsEditable(false);
	}

	private void edit() {
	}
	
    public void keyPressed(KeyEvent event) {
    	String selectedString = text.getSelectionModel().getSelectedItem().toString();
    	int selectedIndex = text.getSelectionModel().getSelectedIndex();
    	if(text.isEditable()) {
    		if(event.getCode() == KeyCode.BACK_SPACE) {
    			if(selectedString.length() >= 1) {
    				text.getItems().set(selectedIndex, new Line(selectedString.substring(0, selectedString.length() - 1)));
    			}
    			else if(text.getItems().size() > 2) {
    				text.getItems().remove(selectedIndex);
    			}
    		}
    	}

    }
	
	public void editCommit(EditEvent<Line> event) {
		text.getItems().add(text.getSelectionModel().getSelectedIndex(), event.getNewValue());
		text.getItems().remove(text.getSelectionModel().getSelectedIndex());
		text.getItems().add(text.getSelectionModel().getSelectedIndex() +1,new Line());
		text.getSelectionModel().selectNext();
	}
	
	public void loadClick(ActionEvent event) {
		fileLoad();		
	}
	
	public void editClick(ActionEvent event) {
		edit();
	}
	
	public void saveClick(ActionEvent event) {
		fileSave();
	}

	public void setSubModel(SubModel subModel) {
		this.subModel = subModel;
		this.textPage = subModel.getTextPage();
		
		text.editableProperty().bindBidirectional(subModel.getEditableProperty());
		edit.selectedProperty().bindBidirectional(subModel.getEditableProperty());
		text.itemsProperty().bindBidirectional(textPage.getListProperty());
		title.textProperty().bindBidirectional(textPage.getFilePathProperty());
		
		addEmptyLine();
	}
}
