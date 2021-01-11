package page;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GoodsInputPanel extends InputPanel{

	private JLabel label_name;
	private JLabel label_price;
	private JLabel label_num;
	
	private JTextField textField_name;
	private JTextField textField_price;
	private JTextField textField_num;
	
	public GoodsInputPanel() {
		// TODO Auto-generated constructor stub
		super();
		
		this.setLayout(new GridLayout(15,1));
		
		this.label_name = new JLabel("输入商品名称");
		this.label_price = new JLabel("输入商品价格");
		this.label_num = new JLabel("输入商品数量");
		
		this.textField_name = new JTextField();
		this.textField_price = new JTextField();
		this.textField_num = new JTextField();
		
		this.add(label_name);
		this.add(textField_name);
		this.add(label_price);
		this.add(textField_price);
		this.add(label_num);
		this.add(textField_num);
	}

	public JLabel getLabel_name() {
		return label_name;
	}

	public JLabel getLabel_price() {
		return label_price;
	}

	public JLabel getLabel_num() {
		return label_num;
	}

	public JTextField getTextField_name() {
		return textField_name;
	}

	public JTextField getTextField_price() {
		return textField_price;
	}

	public JTextField getTextField_num() {
		return textField_num;
	}

//	public void setLabel_name(JLabel label_name) {
//		this.label_name = label_name;
//	}
//
//	public void setLabel_price(JLabel label_price) {
//		this.label_price = label_price;
//	}
//
//	public void setLabel_num(JLabel label_num) {
//		this.label_num = label_num;
//	}
//
//	public void setTextField_name(JTextField textField_name) {
//		this.textField_name = textField_name;
//	}
//
//	public void setTextField_price(JTextField textField_price) {
//		this.textField_price = textField_price;
//	}
//
//	public void setTextField_num(JTextField textField_num) {
//		this.textField_num = textField_num;
//	}


}
