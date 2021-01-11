package demo;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import page.GoodsShowTablePanel;

public class GoodsShowTableDemo {

	public static void main(String[] args) {
		GoodsShowTablePanel myPage = new GoodsShowTablePanel();
		JFrame myDemo = new JFrame();
		
		myDemo.setBounds(1000, 100, 600, 600);
		myDemo.setLayout(new FlowLayout());
		myDemo.add(myPage);
		myDemo.setDefaultCloseOperation(myDemo.EXIT_ON_CLOSE);;
		myDemo.setVisible(true);
	}
}
