package support;

import javax.swing.JPanel;

public abstract class Page extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static protected PageType currentPage = PageType.HOME;
	
	public static PageType getCurrentPage() {
		return currentPage;
	}
}
