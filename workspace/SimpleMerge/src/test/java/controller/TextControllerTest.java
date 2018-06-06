package controller;

import org.junit.Before;
import org.junit.Test;

import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import junit.framework.TestCase;
import model.SubModel;

public class TextControllerTest extends TestCase{
	TextController testController;
	private SubModel subModel;
	@Before
	public void setUp() {
		JFXPanel a = new JFXPanel();
		testController = new TextController();
		subModel = new SubModel();
		testController.setSubModel(subModel);
	}
	
	@Test
	public void testEdit() {
		testController.editClick(new ActionEvent());
		assertTrue(subModel.isEditable());
	}
	
	/* �������� ��Ȳ */
	@Test
	public void save1() {
		subModel.setLineText(0, "aaaaaa");
		testController.saveClick(new ActionEvent());
	}
	@Test
	public void save2() {
		
	}
	@Test
	public void save3() {
		
	}
	@Test
	public void load1() {
		
	}
}
