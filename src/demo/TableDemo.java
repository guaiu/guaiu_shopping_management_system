package demo;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import page.ShowTablePanel;

public class TableDemo {

	public static void main(String[] args) {
		ShowTablePanel myPage = new ShowTablePanel();
		JFrame myDemo = new JFrame();
		
		myDemo.setBounds(1000, 100, 600, 600);
		myDemo.setLayout(new FlowLayout());
		myDemo.add(myPage);
		myDemo.setDefaultCloseOperation(myDemo.EXIT_ON_CLOSE);;
		myDemo.setVisible(true);
	}
}
