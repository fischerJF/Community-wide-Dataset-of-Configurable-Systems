package featureAMP;
import java.awt.GridLayout; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 

import javax.swing.JButton; 
import javax.swing.JPanel; 

public  class  PlayerBar {
	
	
	private FeatureAmp featureAmp;

	
	
	private JPanel playerPanel;

	
	
	private JButton playButton;

	
	private JButton pauseButton;

	
	private JButton stopButton;

	
	
	public PlayerBar(FeatureAmp featureAmp) {
		if (specifications.Configuration.player_bar) {
			
			this.featureAmp = featureAmp;
			this.featureAmp.addAudioListener(new AudioListener());
			
			// Play-Button
			this.playButton = new JButton("Play");
			this.playButton.setName("play");
			this.playButton.addActionListener(new PlayButtonListener());
			
			// Pause-Button
			this.pauseButton = new JButton("Pause");
			this.pauseButton.setName("pause");
			this.pauseButton.addActionListener(new PauseButtonListener());
			
			// Stop-Button
			this.stopButton = new JButton("Stop");
			this.stopButton.setName("stop");
			this.stopButton.addActionListener(new StopButtonListener());
			
			this.initButtons();
			
			// PlayerPanel
			this.playerPanel = new JPanel();
			playerPanel.setLayout(new GridLayout(1,3));
			playerPanel.add(this.playButton);
			playerPanel.add(this.pauseButton);
			playerPanel.add(this.stopButton);
			
				}
	}

	
	
	private void initButtons() {
		this.playButton.setEnabled(false);
		this.pauseButton.setEnabled(false);
		this.stopButton.setEnabled(false);
	}

	
	
	public JPanel getPlayerPanel() {
		return this.playerPanel;
	}

	
	
	 
	
	class  PlayButtonListener  implements ActionListener {
		

		@Override
		public void actionPerformed(ActionEvent e) {
			if (PlayerBar.this.featureAmp.getAudioController().getStatus()
					== AudioController.STATUS_PAUSED)
				PlayerBar.this.featureAmp.getAudioController().resume();
			else
				PlayerBar.this.featureAmp.getAudioController().play();
		}


	}

	
	
	 
	
	class  PauseButtonListener  implements ActionListener {
		

		@Override
		public void actionPerformed(ActionEvent e) {
			PlayerBar.this.featureAmp.getAudioController().pause();
		}


	}

	
	
	 
	
	class  StopButtonListener  implements ActionListener {
		

		@Override
		public void actionPerformed(ActionEvent e) {
			PlayerBar.this.featureAmp.getAudioController().stop();
		}


	}

	
	
	 
	
	class  PlayListener  implements Listener<AudioController> {
		

		@Override
		public void update(AudioController object) {
			PlayerBar.this.playButton.setEnabled(false);
			PlayerBar.this.pauseButton.setEnabled(true);
			PlayerBar.this.stopButton.setEnabled(true);
		}


	}

	
	
	 
	
	class  PauseListener  implements Listener<AudioController> {
		

		@Override
		public void update(AudioController object) {
			PlayerBar.this.playButton.setEnabled(true);
			PlayerBar.this.pauseButton.setEnabled(false);
			PlayerBar.this.stopButton.setEnabled(true);
		}


	}

	
	
	 
	
	class  StopListener  implements Listener<AudioController> {
		

		@Override
		public void update(AudioController object) {
			PlayerBar.this.playButton.setEnabled(true);
			PlayerBar.this.pauseButton.setEnabled(false);
			PlayerBar.this.stopButton.setEnabled(false);
		}


	}

	
	
	 
	
	class  AudioListener  implements Listener<FeatureAmp> {
		

		@Override
		public void update(FeatureAmp object) {
			if (object.getAudioController() != null) {
				PlayerBar.this.playButton.setEnabled(true);
				PlayerBar.this.pauseButton.setEnabled(false);
				PlayerBar.this.stopButton.setEnabled(false);
				object.getAudioController().addPlayListener(new PlayListener());
				object.getAudioController().addPauseListener(new PauseListener());
				object.getAudioController().addResumeListener(new PlayListener());
				object.getAudioController().addStopListener(new StopListener());
			}
			else
				PlayerBar.this.initButtons();
		}


	}


}
