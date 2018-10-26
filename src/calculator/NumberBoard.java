package calculator;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JPanel;

import support.KeyPress;

public class NumberBoard extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Queue<KeyPress> inputBuffer;
	JButton[] numbers;
	
	public NumberBoard(Queue<KeyPress> inputBuffer) {
		this.setLayout(new GridBagLayout());
		this.inputBuffer = inputBuffer;
		numbers = new JButton[10];
		for(int i = 0; i <= 9; i++) {
			numbers[i] = new JButton(Integer.toString(9 - i));
			numbers[i].setPreferredSize(new Dimension(100, 100));
			
			GridBagConstraints numberLayout = new GridBagConstraints();
			
			KeyPress temp;
			
			switch(9 - i) {
			case 0:
				numberLayout.gridx = 1;
				temp = KeyPress.ZERO;
				break;
			case 1:
				numberLayout.gridx = 0;
				temp = KeyPress.ONE;
				break;
			case 2:
				numberLayout.gridx = 1;
				temp = KeyPress.TWO;
				break;
			case 3:
				numberLayout.gridx = 2;
				temp = KeyPress.THREE;
				break;
			case 4:
				numberLayout.gridx = 0;
				temp = KeyPress.FOUR;
				break;
			case 5:
				numberLayout.gridx = 1;
				temp = KeyPress.FIVE;
				break;
			case 6:
				numberLayout.gridx = 2;
				temp = KeyPress.SIX;
				break;
			case 7:
				numberLayout.gridx = 0;
				temp = KeyPress.SEVEN;
				break;
			case 8:
				numberLayout.gridx = 1;
				temp = KeyPress.EIGHT;
				break;
			case 9:
				numberLayout.gridx = 2;
				temp = KeyPress.NINE;
				break;
			default:
				temp = KeyPress.NONE;
				break;
			}
			
			numbers[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					inputBuffer.add(temp);
				}
			});
			add(numbers[i], numberLayout);
		}
	}
}
