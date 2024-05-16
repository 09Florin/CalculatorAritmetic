package Arithmetic_Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ArithmeticCalculator implements ActionListener {

	JFrame frmArithmeticCalculator;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionsButtons = new JButton[6];
	JButton addButton ,subButton,mulButton,divButton;
	JButton decButton , equButton;
	JPanel panel;
	
	Font Arial = new Font("Arial",Font.BOLD,30);
	
	double num1=0,num2=0,result=0;
	char operator;
	
	
	ArithmeticCalculator(){
		
		frmArithmeticCalculator = new JFrame("Calculator");
		frmArithmeticCalculator.getContentPane().setForeground(new Color(255, 255, 255));
		frmArithmeticCalculator.setTitle("Arithmetic Calculator");
		frmArithmeticCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmArithmeticCalculator.setSize(420,550);
		frmArithmeticCalculator.getContentPane().setLayout(null);
		
		textfield= new JTextField();
		textfield.setBounds(50,25,300,50);
		textfield.setFont(Arial);
		textfield.setEditable(false);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		
		functionsButtons[0]=addButton;
		functionsButtons[1]=subButton;
		functionsButtons[2]=mulButton;
		functionsButtons[3]=divButton;
		functionsButtons[4]=decButton;
		functionsButtons[5]=equButton;

		
		for(int i=0;i<6;i++) {
			functionsButtons[i].addActionListener(this);
			functionsButtons[i].setFont(Arial);
			functionsButtons[i].setFocusable(false);
		}
		
		for(int i=0;i<10;i++) {
			numberButtons[i]=new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(Arial);
			numberButtons[i].setFocusable(false);
		}
				
		panel = new JPanel();
		panel.setBounds(50,100,300,300);
		panel.setLayout(new GridLayout(4,4,10,10));
		panel.setBackground(null);
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		frmArithmeticCalculator.getContentPane().add(panel);
		frmArithmeticCalculator.getContentPane().add(textfield);
		frmArithmeticCalculator.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
			if(e.getSource()==numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==decButton) {
			textfield.setText(textfield.getText().concat(String.valueOf(".")));
		}
		if(e.getSource()==addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		if(e.getSource()==subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		if(e.getSource()==mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		if(e.getSource()==divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		if(e.getSource()==equButton) {
			num2=Double.parseDouble(textfield.getText());
			
			switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;	
		}
			textfield.setText(String.valueOf(result));
			num1=result;			
	}

	}
}

