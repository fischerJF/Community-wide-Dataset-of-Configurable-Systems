package featureAMP;
import java.awt.GridLayout; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 

import javax.swing.JButton; 
import javax.swing.JLabel; 
import javax.swing.JPanel; import javax.swing.JToggleButton; 

public   class  VolumeControl {
	
	
	private FeatureAmp featureAmp;

	
	
	private JPanel volumePanel;

	
	
	private JButton quieterButton;

	
	private JLabel percentLabel;

	
	private JButton louderButton;

	
	
	private int currentPercent;

	
	
	public VolumeControl(FeatureAmp featureAmp) {
		if (specifications.Configuration.volume_control) {
			
			this.featureAmp = featureAmp;
			this.featureAmp.addAudioListener(new AudioListener());
			
			this.quieterButton = new JButton("Vol. –");
			this.quieterButton.setName("less_volume");
			this.quieterButton.setEnabled(true);
			this.quieterButton.addActionListener(new QuieterButtonListener());
			
			this.percentLabel = new JLabel();
			this.percentLabel.setHorizontalAlignment(JLabel.CENTER);
			
			this.louderButton = new JButton("Vol. +");
			this.louderButton.setName("more_volume");
			this.louderButton.setEnabled(false);
			this.louderButton.addActionListener(new LouderButtonListener());
			
			this.setPercent(100);
			this.createVolumePanel();
			
				}
	}

	
	
	public JPanel getVolumePanel() {
		return this.volumePanel;
	}

	
	
	 private void  createVolumePanel__wrappee__VOLUME_CONTROL  () {
		
		this.volumePanel = new JPanel();
		this.volumePanel.setLayout(new GridLayout(1, 3));
		
		this.volumePanel.add(this.quieterButton);
		this.volumePanel.add(this.percentLabel);
		this.volumePanel.add(this.louderButton);
		
	}

	
	
	private void createVolumePanel() {
		if (!specifications.Configuration.mute) {
			createVolumePanel__wrappee__VOLUME_CONTROL();
			return;
		}
		
		createVolumePanel__wrappee__VOLUME_CONTROL();
		
		this.muteButton = new JToggleButton("Mute");
		this.muteButton.setEnabled(true);
		this.muteButton.setName("mute");
		this.muteButton.addActionListener(new MuteButtonListener());
		
		this.volumePanel.setLayout(new GridLayout(1, 4));
		this.volumePanel.add(this.muteButton);
		
	}

	
	
	private void setPercent(int percent) {
		this.currentPercent = percent;
		this.percentLabel.setText(percent + " %");
	}

	
	
	 private void  changeVolume__wrappee__VOLUME_CONTROL  () {
		if (this.featureAmp.getAudioController() != null)
			this.featureAmp.getAudioController().setVolume(this.currentPercent);
	}

	
	
	private void changeVolume() {
		if (!specifications.Configuration.mute) {
			changeVolume__wrappee__VOLUME_CONTROL();
			return;
		}
		
		if (this.muted && this.featureAmp.getAudioController() != null)
			this.featureAmp.getAudioController().setVolume(0);
		else
			changeVolume__wrappee__VOLUME_CONTROL();
		
	}

	
	
	 
	
	class  QuieterButtonListener  implements ActionListener {
		

		@Override
		public void actionPerformed(ActionEvent e) {
			
			VolumeControl.this.setPercent(
					VolumeControl.this.currentPercent - 5);
			VolumeControl.this.louderButton.setEnabled(true);
			
			if (VolumeControl.this.currentPercent <= 0)
				VolumeControl.this.quieterButton.setEnabled(false);
			
			VolumeControl.this.changeVolume();
			
		}


	}

	
	
	 
	
	class  LouderButtonListener  implements ActionListener {
		

		@Override
		public void actionPerformed(ActionEvent e) {
			
			VolumeControl.this.setPercent(
					VolumeControl.this.currentPercent + 5);
			VolumeControl.this.quieterButton.setEnabled(true);
			
			if (VolumeControl.this.currentPercent >= 100)
				VolumeControl.this.louderButton.setEnabled(false);
			
			VolumeControl.this.changeVolume();
			
		}


	}

	
	
	 
	
	class  AudioListener  implements Listener<FeatureAmp> {
		
		
		@Override
		public void update(FeatureAmp object) {
			VolumeControl.this.changeVolume();
		}


	}

	
	
	private JToggleButton muteButton;

	
	
	private boolean muted = false;

	
	
	 
	
	class  MuteButtonListener  implements ActionListener {
		

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (VolumeControl.this.muteButton.isSelected())
				VolumeControl.this.muted = true;
			else
				VolumeControl.this.muted = false;
			
			VolumeControl.this.changeVolume();
			
		}


	}


}
