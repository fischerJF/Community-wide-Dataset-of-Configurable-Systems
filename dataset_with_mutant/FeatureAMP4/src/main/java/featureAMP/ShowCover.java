package featureAMP;
import java.awt.BorderLayout; 
import java.awt.Dimension; 
import java.awt.Image; 

import javax.swing.ImageIcon; 
import javax.swing.JLabel; 
import javax.swing.JPanel; 

public  class  ShowCover {
	
	
	private FeatureAmp featureAmp;

	
	
	private JPanel imagePanel;

	
	private JLabel noCoverLabel;

	
	private ImageIcon image;

	
	
	public ShowCover(FeatureAmp featureAmp) {
		if (specifications.Configuration.show_cover) {
			
			this.featureAmp = featureAmp;
			
			this.imagePanel = new JPanel();
			this.imagePanel.setLayout(new BorderLayout());
			this.imagePanel.setPreferredSize(new Dimension(200, 200));
			
			this.noCoverLabel = new JLabel("kein AlbumArt vorhanden");
			this.noCoverLabel.setHorizontalAlignment(JLabel.CENTER);
			this.imagePanel.add(this.noCoverLabel, BorderLayout.CENTER);
			
			this.featureAmp.addAudioListener(new AudioListener());
			
				}
	}

	
	
	public JPanel getImagePanel() {
		return this.imagePanel;
	}

	
	
	 
	
	class  AudioListener  implements Listener<FeatureAmp> {
		

		@Override
		public void update(FeatureAmp object) {
			
			ShowCover.this.imagePanel.removeAll();
			
			if ((object.getAudioController() == null) 
					|| (object.getAudioController().getAudioFile().getAlbumArt() == null)) {
				ShowCover.this.image = null;
				ShowCover.this.imagePanel.add(
						ShowCover.this.noCoverLabel, BorderLayout.CENTER);
			}
			else {
				ShowCover.this.image = new ImageIcon(
						object.getAudioController().getAudioFile().getAlbumArt());
				ShowCover.this.imagePanel.add(new JLabel(new ImageIcon(
						ShowCover.this.image.getImage().getScaledInstance(
								200, 200, Image.SCALE_DEFAULT))), BorderLayout.CENTER);
			}
			
			ShowCover.this.imagePanel.repaint();
			ShowCover.this.imagePanel.revalidate();
			
		}


	}


}
