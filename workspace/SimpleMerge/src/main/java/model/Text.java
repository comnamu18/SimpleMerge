package model;

import java.util.ArrayList;

public class Text {
	private ArrayList<Line> textArrList;
	
	// Split whole string to line by line when the text object first made
	public Text(String strTextArea) {
		textArrList = new ArrayList<>();
		String strArr[] = strTextArea.split("\n");
		
		for(int i = 0;i < strArr.length;i++) {
			this.textArrList.add(new Line(strArr[i]));
		}
	}
	
	
	
	////////////////// �Լ� ������ �����ؾ� �Ǵ��� �𸣰��� (arraylist��°�� ��ȯ? / arraylist���� �Լ� �������̵�?)
}
