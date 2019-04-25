package util;

import javax.swing.JFrame;
import javax.swing.JPanel;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

public class Leitor {
	private String filePath;

	public Leitor(String caminho) {
		this.filePath = caminho;
		SwingController controller = new SwingController();

		SwingViewBuilder factory = new SwingViewBuilder(controller);

		JPanel viewerComponentPanel = factory.buildViewerPanel();

		controller.getDocumentViewController().setAnnotationCallback(
				new org.icepdf.ri.common.MyAnnotationCallback(controller.getDocumentViewController()));

		JFrame applicationFrame = new JFrame();
		applicationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// applicationFrame.getContentPane().add(viewerComponentPanel);
		applicationFrame.add(viewerComponentPanel);

		controller.openDocument(filePath);

		applicationFrame.pack();
		applicationFrame.setVisible(true);
		applicationFrame.setSize(800, 600);
		applicationFrame.setLocationRelativeTo(null);
	}


}
