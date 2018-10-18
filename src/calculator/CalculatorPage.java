package calculator;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CalculatorPage extends JPanel {
	private static CalculatorPage calculatorPage = new CalculatorPage();
	JButton[] numbers;
	
	public static CalculatorPage getInstance() {
		return calculatorPage;
	}

	private CalculatorPage() {
		numbers = new JButton[9];
		super.setLayout(new GridLayout(3,3));
		for(int i = 0; i < 9; i++) {
			numbers[i] = new JButton(Integer.toString(9 - i));
			add(numbers[i]);
		}
	}
}
