package page;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GoodsInputPanel extends InputPanel{

	private JLabel label_name;
	private JLabel label_price;
	private JLabel label_num;
	
	private JTextField field_name;
	private JTextField field_price;
	private JTextField field_num;
	
	public GoodsInputPanel() {
		// TODO Auto-generated constructor stub
		super();
		
		this.setLayout(new GridLayout(15,1));
		
		this.label_name = new JLabel("输入商品名称");
		this.label_price = new JLabel("输入商品价格");
		this.label_num = new JLabel("输入商品数量");
		
		this.field_name = new JTextField();
		this.field_price = new JTextField();
		this.field_num = new JTextField();
		
		this.add(label_name);
		this.add(field_name);
		this.add(label_price);
		this.add(field_price);
		this.add(label_num);
		this.add(field_num);
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

	public JTextField getField_name() {
		return field_name;
	}

	public JTextField getField_price() {
		return field_price;
	}

	public JTextField getField_num() {
		return field_num;
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
//	public void setField_name(JTextField field_name) {
//		this.field_name = field_name;
//	}
//
//	public void setField_price(JTextField field_price) {
//		this.field_price = field_price;
//	}
//
//	public void setField_num(JTextField field_num) {
//		this.field_num = field_num;
//	}


}
