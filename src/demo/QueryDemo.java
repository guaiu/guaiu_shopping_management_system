package demo;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import page.GoodsQueryPanel;

public class QueryDemo {

	public static void main(String[] args) {
	 GoodsQueryPanel myPage = new GoodsQueryPanel();
	
	JFrame myDemo = new JFrame();
	
	myDemo.setBounds(1000, 100, 400, 600);
	myDemo.setLayout(new FlowLayout());
	myDemo.add(myPage);
	myDemo.setDefaultCloseOperation(myDemo.EXIT_ON_CLOSE);;
	myDemo.setVisible(true);
	
}
	
}
