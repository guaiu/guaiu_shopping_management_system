package page;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import listener.*;

/**
 * 查询面板
 * @author guaiu
 *
 */
public class QueryPanel extends ActionPanel{
	
	private JRadioButton radioButton_id;
	private JRadioButton radioButton_name;
	private JTextField textField_id;
	private JTextField textField_name;
	private JButton button_query;
	private JButton button_query_all;
	
	
	/**
	 * 无参数方法，生成查询面板
	 */
	public QueryPanel() {
		// TODO Auto-generated constructor stub
		super("查询");
		
		this.setLayout(new GridLayout(3,2));
		
		this.radioButton_id = new JRadioButton("id查询");
		this.radioButton_name = new JRadioButton("名称查询");
		this.radioButton_name.setSelected(true);
		
		this.textField_id = new JTextField();
		this.textField_name = new JTextField();
		this.textField_id.setEnabled(false);
		
		this.button_query = new JButton("查询");
		this.button_query_all = new JButton("查询所有");

		
		ButtonGroup radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(this.radioButton_id);
		radioButtonGroup.add(this.radioButton_name);

		this.add(this.radioButton_id);
		this.add(this.textField_id);
		this.add(this.radioButton_name);
		this.add(this.textField_name);
		this.add(this.button_query);
		this.add(this.button_query_all);
		
		this.radioButton_id.addChangeListener(new JTextFieldEnableListener(this.radioButton_id, this.textField_id));
		this.radioButton_name.addChangeListener(new JTextFieldEnableListener(this.radioButton_name, this.textField_name));
		
		this.textField_id.addFocusListener(new JTextFieldHintListener(this.textField_id, "输入ID"));
		this.textField_name.addFocusListener(new JTextFieldHintListener(textField_name, "输入名称"));
	}


	public JRadioButton getRadioButton_id() {
		return radioButton_id;
	}


	public JRadioButton getRadioButton_name() {
		return radioButton_name;
	}


	public JTextField getTextField_id() {
		return textField_id;
	}


	public JTextField getTextField_name() {
		return textField_name;
	}


	public JButton getButton_query() {
		return button_query;
	}


	public JButton getButton_query_all() {
		return button_query_all;
	}


//	public void setRadioButton_id(JRadioButton radioButton_id) {
//		this.radioButton_id = radioButton_id;
//	}
//
//
//	public void setRadioButton_name(JRadioButton radioButton_name) {
//		this.radioButton_name = radioButton_name;
//	}
//
//
//	public void setTextField_id(JTextField textField_id) {
//		this.textField_id = textField_id;
//	}
//
//
//	public void setTextField_name(JTextField textField_name) {
//		this.textField_name = textField_name;
//	}
//
//
//	public void setButton_query(JButton button_query) {
//		this.button_query = button_query;
//	}
//
//
//	public void setButton_query_all(JButton button_query_all) {
//		this.button_query_all = button_query_all;
//	}	
}
