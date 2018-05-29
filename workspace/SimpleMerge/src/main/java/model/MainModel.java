package model;

import java.util.ArrayList;
import java.util.Iterator;

public class MainModel {
	private boolean isCompared;	// compare flag, Modified����
	private SubModel leftSubModel;
	private SubModel rightSubModel;
	
	public MainModel() {
		this.isCompared = false;
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
		return this.isCompared;
	}
	public void setIsCompared(boolean isCompared) {
		this.isCompared = isCompared;
	}
	
	public void toggleIsCompared() {
		this.isCompared = !isCompared;
	}
	
	/*
	public void LCS() {
		// leftSubModel.getText()���ؼ�  ArrayList �޾ƿͼ� �ϱ�
		// Implement here!!!
		
		Iterator<Line> left = leftSubModel.getTextPage().getTextLines().iterator();
		Iterator<Line> right = rightSubModel.getTextPage().getTextLines().iterator();
		// SubModel class didn't have getTextPage method
		
		while (left.hasNext()&&right.hasNext()) { // if both has next
			Line leftside = left.next();
			Line rightside = right.next();
			if (!leftside.getLineText().equals(rightside.getLineText())) { // if diff
				leftside.setIsShaded(true);
				rightside.setIsShaded(true);
			}
		}
		
		while(left.hasNext()||right.hasNext()) { // if one side has next
			// later
		}
		
	}
	*/
}
