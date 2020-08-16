package featureAMP;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.io.File; 
import java.util.Collection; 

import javax.swing.JFileChooser; 
import javax.swing.JMenu; 
import javax.swing.JMenuBar; 
import javax.swing.JMenuItem; 
import javax.swing.filechooser.FileNameExtensionFilter; public   class  MenuManager {
	
	
	private FeatureAmp featureAmp;

	
	
	private JMenuBar menuBar;

	
	
	private File currentFile;

	
	
	public MenuManager(FeatureAmp featureAmp) {
		if (specifications.Configuration.base_featureamp) {
			
			this.featureAmp = featureAmp;
			this.menuBar = new JMenuBar();
			
			this.initMenuBar();
			
				}
	}

	
	
	private void initMenuBar() {
		this.initMenues();
		this.initMenuItems();
	}

	
	
	private void initMenues() {
		this.addMenu("Datei");
	}

	
	
	 private void  initMenuItems__wrappee__BASE_FEATUREAMP  () {
		JMenuItem menuItem = new JMenuItem("Datei öffnen...");
		menuItem.addActionListener(new LoadFileListener());
		this.addMenuItem(0, menuItem);
	}

	
	
	private void initMenuItems() {
		if (!specifications.Configuration.playlist) {
			initMenuItems__wrappee__BASE_FEATUREAMP();
			return;
		}}

	
	
	public JMenuBar getMenuBar() {
		return this.menuBar;
	}

	
	
	public File getCurrentFile() {
		return this.currentFile;
	}

	
	
	public void setCurrentFile(File currentFile) {
		this.currentFile = currentFile;
	}

	
	
	public void addMenu(String title) {
		this.menuBar.add(new JMenu(title));
	}

	
	
	public void addMenuItem(int menuIndex, JMenuItem item) {
		this.menuBar.getMenu(menuIndex).add(item);
	}

	
	
	 
	
	class  LoadFileListener  implements ActionListener {
		

		@Override
		public void actionPerformed(ActionEvent e) {
			
			JFileChooser fileChooser;
			if (MenuManager.this.currentFile != null)
				fileChooser = new JFileChooser(MenuManager.this.currentFile);
			else
				fileChooser = new JFileChooser();
			Collection<String> fileExtensions = AudioFactory.getSupportedFileExtensions();
			fileChooser.setFileFilter(new FileNameExtensionFilter("Audiodateien",
					fileExtensions.toArray(new String[fileExtensions.size()])));
			
			int returnCode = fileChooser.showOpenDialog(
					MenuManager.this.featureAmp.getFrame());
			if (returnCode == JFileChooser.APPROVE_OPTION) {
				
				File file = fileChooser.getSelectedFile();
				MenuManager.this.currentFile = file;
				MenuManager.this.featureAmp.getFrame().setTitle("lädt...");
				try {
					MenuManager.this.featureAmp.setAudioController(
							AudioFactory.createAudioController(
									AudioFactory.createAudioFile(file)));
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
			
		}


	}


}
