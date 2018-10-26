package calculator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Queue;
import java.util.concurrent.LinkedTransferQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import support.KeyPress;
import support.Page;

public class CalculatorPage extends Page {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Queue<KeyPress> subclassBuffer;
	private NumberBoard numbers;
	private JLabel console;
	
	private static CalculatorPage calculatorPage = new CalculatorPage();
	
	public static CalculatorPage getInstance() {
		return calculatorPage;
	}
	
	public void calculatorLoop(JFrame frame) {
		while(true) {
			if(!subclassBuffer.isEmpty()) {
				console.setText(console.getText() + subclassBuffer.poll());
			}
			frame.revalidate();
			frame.repaint();
		}
	}

	private CalculatorPage() {
		subclassBuffer = new LinkedTransferQueue<KeyPress>();
		numbers = new NumberBoard(subclassBuffer);
		
		console = new JLabel("", JLabel.RIGHT);
		console.setBackground(Color.WHITE);
		console.setOpaque(true);
		console.setPreferredSize(new Dimension(300, 70));
		console.setFont(new Font("Arial", Font.PLAIN, 32));
		GridBagLayout layout = new GridBagLayout();
		
		layout.minimumLayoutSize(this);
		
		JPanel organizer = new JPanel(new GridBagLayout());
		
		GridBagConstraints consoleConstraints = new GridBagConstraints();
		consoleConstraints.gridx = 0;
		consoleConstraints.gridy = 0;
		consoleConstraints.gridwidth = 3;
		consoleConstraints.gridheight = 1;
		consoleConstraints.fill = GridBagConstraints.BOTH;
		organizer.add(console, consoleConstraints);
		
		GridBagConstraints numberPadConstraints = new GridBagConstraints();
		numberPadConstraints.gridx = 0;
		numberPadConstraints.gridy = 1;
		numberPadConstraints.gridwidth = 3;
		numberPadConstraints.gridheight = 5;
		numberPadConstraints.fill = GridBagConstraints.BOTH;
		
		organizer.add(numbers, numberPadConstraints);
		this.add(organizer);
	}
}
