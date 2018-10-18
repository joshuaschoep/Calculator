package main;

import javax.swing.JFrame;
import javax.swing.JPanel;

import calculator.CalculatorPage;

public class MainWindow extends JPanel {
	private static MainWindow instance = new MainWindow();
	
	public MainWindow getInstance() {
		return instance;
	}
	
	private MainWindow() {
		this.add(MainPage.getInstance());
		this.add(CalculatorPage.getInstance());
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(instance);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 950);
		frame.setVisible(true);
	}
}
