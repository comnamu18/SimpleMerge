package model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;

public class MainModel {
	private BooleanProperty isCompared;	// compare flag, Modified����
	private SubModel leftSubModel;
	private SubModel rightSubModel;
	
	public MainModel() {
		this.isCompared = new SimpleBooleanProperty(false);
		this.leftSubModel = new SubModel();
		this.rightSubModel = new SubModel();
	}
	
	public SubModel getLeftSubModel() {
		return this.leftSubModel;
	}
	public void setLeftSubModel(SubModel leftSubModel) {
		this.leftSubModel = leftSubModel;
	}
	public SubModel getRightSubModel() {
		//return this.getRightSubModel(); <- miss?
		return this.rightSubModel;
	}
	public void setRightSubModel(SubModel rightSubModel) {
		this.rightSubModel = rightSubModel;
	}
	public boolean isCompared() {
		return this.isCompared.getValue();
	}
	public void setIsCompared(boolean isCompared) {
		this.isCompared.setValue(isCompared);;
	}
	
	public void toggleIsCompared() {
		this.isCompared.setValue(!isCompared.getValue());
	}
	
	public boolean LCS() {
		return true;
	}
	public void copyToLeft() {
	}
	public void copyToRight() {
	}

	public BooleanProperty getIsComparedProperty() {
		return isCompared;
	}
}
