import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.BorderLayout;


public class Frame extends JFrame implements ActionListener{
	TextParser ps = new TextParser();
	JButton BtnPlus = new JButton("+");
	JButton BtnMinus = new JButton("-");
	JButton BtnMultiply = new JButton("*");
	JButton BtnPercent = new JButton("%");
	JButton BtnDivide = new JButton("/");
	JButton BtnEquals = new JButton("=");
	JButton BtnClear = new JButton("Clear");
	JButton[] BtnNumbers = new JButton[10];
	JTextField textField = new JTextField(30);
	
	public Frame(){
		
		textField.setText("");
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel btnsNums = new JPanel(new GridLayout(3,3,5,5));
		for (int i = 1; i<=9; i++){
			BtnNumbers[i] = new JButton("" +i);
			btnsNums.add(BtnNumbers[i]);
			BtnNumbers[i].addActionListener(this);
			BtnNumbers[i].setActionCommand(""+i);;
		}
		BtnNumbers[0] = new JButton("" + 0);
		BtnNumbers[0].addActionListener(this);
		BtnNumbers[0].setActionCommand(""+0);;
		
		JPanel btnsDown = new JPanel();
		btnsDown.add(BtnClear);
		btnsDown.add(BtnNumbers[0]);
		btnsDown.add(BtnPercent);
		
		JPanel panelRight = new JPanel(new GridLayout(5,1,5,5));
		panelRight.add(BtnPlus);
		panelRight.add(BtnMinus);
		panelRight.add(BtnMultiply);
		panelRight.add(BtnDivide);
		panelRight.add(BtnEquals);
		
		JPanel textPanel = new JPanel();
		textPanel.add(textField);
		
		BorderLayout layout = new BorderLayout();
		BorderLayout layout3 = new BorderLayout();
		
		JPanel panelLeft = new JPanel(layout);
		panelLeft.add(textPanel, BorderLayout.NORTH);
		panelLeft.add(btnsNums, BorderLayout.CENTER);
		panelLeft.add(btnsDown, BorderLayout.SOUTH);
		
		JPanel parentPanel = new JPanel(layout3);
		parentPanel.add(panelLeft, BorderLayout.WEST);
		parentPanel.add(panelRight, BorderLayout.EAST);
		
		
		BtnPlus.addActionListener(this);
		BtnEquals.addActionListener(this);
		BtnMinus.addActionListener(this);
		BtnPercent.addActionListener(this);
		BtnMultiply.addActionListener(this);
		BtnDivide.addActionListener(this);
		BtnClear.addActionListener(this);
		
		BtnPlus.setActionCommand("+");
		BtnEquals.setActionCommand("=");
		BtnMinus.setActionCommand("-");
		BtnPercent.setActionCommand("%");
		BtnMultiply.setActionCommand("*");
		BtnDivide.setActionCommand("/");
		BtnClear.setActionCommand("Clear");
		
		add(parentPanel);
	}
	public void txtUpdate(String input){
		String temp = textField.getText() + input;
		textField.setText(temp);
	}
	
	public  void actionPerformed(ActionEvent e){
		String temp = e.getActionCommand();
		if("=".equals(temp)){
			txtUpdate(temp);
			String temptext = textField.getText();
			double result = TextParser.parse(temptext);
			JOptionPane.showMessageDialog(null,""+result);
			textField.setText("");
		}else if("Clear".equals(temp)){
			textField.setText("");
		}else{
			txtUpdate(temp);
		}
	}
}