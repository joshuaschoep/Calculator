package main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import calculator.CalculatorPage;

public class MainPage extends JPanel{
	private static MainPage mainPage = new MainPage();
	
	public static MainPage getInstance() {
		return mainPage;
	}

	private MainPage(){
		super.setLayout(new GridLayout(2,2));
		JButton graphingButton = new JButton("Graphing");
		JButton calculatorButton = new JButton("Calculator");
		calculatorButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				return;
			}
		});
		JButton specialButton = new JButton("Special");
		JButton settingsButton = new JButton("Settings");
		this.add(graphingButton);
		this.add(calculatorButton);
		this.add(specialButton);
		this.add(settingsButton);
	}

}
