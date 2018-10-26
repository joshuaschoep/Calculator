package main;

import javax.swing.JFrame;
import javax.swing.JPanel;

import calculator.CalculatorPage;
import support.Page;


/**
 * Single class that holds the single window used for the main part of the calculator's work environment
 * Contains main where the frame for the window is initialized and then the game loop is begun, allowing
 * refreshing of the page each run through. Begins on instance of MainPage class and then can move into 
 * other Page types as they are called.
 * 
 * To add more windows and pages, add a button to the MainPage window, PageType enumerable, and add in a case
 * to the switch found in loop().
 * @author Josh Schoep
 *
 */
public class MainWindow extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Only instance of MainWindow allowed, as to not have multiple calculators for the same program at the same
	 * time
	 */
	private static MainWindow instance = new MainWindow();
	
	/**
	 * @return - single instance of MainWindow class allowed in singleton format
	 */
	public MainWindow getInstance() {
		return instance;
	}
	
	/**
	 * Adds MainPage to the frame to start program
	 * 
	 * If new starting page is wanted, add here instead
	 */
	private MainWindow() {
		this.add(MainPage.getInstance());
	}
	
	/**
	 * Loops over the switch to change pages, skipping that step
	 * unless the selected class differs from the active class.
	 * @param frame - the window to load into
	 */
	private void loop(JFrame frame) {
		while(true) {
			if(Page.getCurrentPage().getPageClass() != this.getComponent(0)) {
				switch(Page.getCurrentPage()) {
				case CALCULATOR:
					this.removeAll();
					this.add(CalculatorPage.getInstance());
					CalculatorPage.getInstance().calculatorLoop(frame);
					break;
				case GRAPHING:
					break;
				case SPECIAL:
					break;
				case SETTINGS:
					break;
				default:
					break;
				}
			}
			frame.revalidate();
			frame.repaint();
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(instance);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 950);
		frame.setVisible(true);
		
		instance.loop(frame);
	}
}
