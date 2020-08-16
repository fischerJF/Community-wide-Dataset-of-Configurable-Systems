package engine; 

import java.awt.EventQueue; 

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 

import java.io.File; 
import java.io.IOException; 

import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 
import javax.swing.JFrame; 
import javax.swing.JMenu; 
import javax.swing.JMenuBar; 
import javax.swing.JMenuItem; 

import com.mpatric.mp3agic.InvalidDataException; 
import com.mpatric.mp3agic.UnsupportedTagException; 

import org.tritonus.share.sampled.file.TAudioFileFormat; 
import java.util.Map; 

import javax.sound.sampled.AudioFileFormat; 
import javax.sound.sampled.AudioSystem; 
import javax.swing.JFileChooser; 
import javax.swing.filechooser.FileFilter; 
import javax.swing.filechooser.FileNameExtensionFilter; 
import com.mpatric.mp3agic.Mp3File; 

import engine.Application; 

import engine.ID3Tag; 
import javax.sound.sampled.AudioFormat; 
import javax.sound.sampled.AudioInputStream; 
import java.text.DecimalFormat; 
import java.util.Timer; 
import java.util.TimerTask; 

import javax.swing.ImageIcon; 
import javax.swing.JButton; 
import engine.MP3Player; 
import javax.swing.JProgressBar; 
import javax.swing.JLabel; 
import javax.swing.JSlider; 
import javax.swing.event.ChangeEvent; 
import javax.swing.event.ChangeListener; 
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent; 
import java.io.FileNotFoundException; 
import java.io.FileOutputStream; 
import java.io.PrintWriter; 

import javax.swing.DefaultListModel; 
import javax.swing.JList; 
import javax.swing.JScrollPane; 

import engine.Zuordnung;
import specifications.Configuration;

import java.io.BufferedReader; 
import java.io.FileReader; 

import java.awt.Color; 

/**
 * TODO description
 */
public   class  Application {
	
	
	private JFrame frmAsd;

	
	private JMenu menu;

	
	private JMenuBar menuBar;

	
	private File selectedFile;

	
	public boolean playlist=false, repeatPlaylist=false, repeatTrack=false, 
				   shuffle=false, showTime=false, muted=false,
				   WAV=false, OGG=false, MP3=false;

	


	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Configuration.featureamp=true;
		Configuration.playengine=true;
		Configuration.choosefile=true;
		Configuration.mp3=true;
		Configuration.gui=true;
		Configuration.skins=true;
		Configuration.light=true;
		Configuration.filesupport=true;
		Configuration.showtime=true;
		Configuration.tracktime=true;
		Configuration.playlist=true;
		Configuration.loadfolder=true;
		Configuration.control=true;
		
		Configuration.volumecontrol=true;
		Configuration.skiptrack=true;
		Configuration.progressbar=true;	
		Configuration.removetrack=true;
		Configuration.wav=true;
		Configuration.reorderplaylist=true;
		Configuration.saveandloadplaylist=true;
		
		Configuration.queuetrack=true;
		Configuration.mute=true;
		Configuration.shufflerepeat=false;
		Configuration.ogg=true;
		Configuration.dark=true;
		Configuration.clearplaylist=true;
		Configuration.showcover=true;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {////APPLICATION STARTEN
					new Application();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	/**
	 * Create the application and Load Plugins.
	 */
	public Application() 
		{
		if (specifications.Configuration.featureamp) {
				initialize();
				frmAsd.setVisible(true);
					}
	}

	


	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAsd = new JFrame();
		
		setFrame();

		addMenu();
		addButtons();
		addEngine();
		changeSkin();
	}

	

 private void  setFrame__wrappee__FeatureAMP  ()
	{
	frmAsd.setBounds(100, 100, 807, 511);
	frmAsd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frmAsd.getContentPane().setLayout(null);
	}

	
	
	public void setFrame()
		{
		if (!specifications.Configuration.queuetrack) {
			setFrame__wrappee__FeatureAMP();
			return;
		}
		frmAsd.setBounds(100, 100, 1207, 511);
		frmAsd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAsd.getContentPane().setLayout(null);
		}

		
	
public void setTitelleiste(String leistentext)
	{
	frmAsd.setTitle(leistentext);
	}

	

/*
 * Gibt Zufallszahl zwischen low und high aus (int)
 */
public int myRandom(int low, int high) 
	{
	return (int) (Math.random() * (high - low) + low);
	}

	

 private void  addMenu__wrappee__FeatureAMP  ()
	{
	menuBar = new JMenuBar();
	menuBar.setBounds(0, 0, 1185, 21);
	frmAsd.getContentPane().add(menuBar);
	
	menu = new JMenu("Datei");
	menu.setName("menu");
	menuBar.add(menu);
	
	JMenuItem menuItem_3 = new JMenuItem("Beenden");
	menu.add(menuItem_3);
	
	menuItem_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);				
		}
	});
	}

	

	 private void  addMenu__wrappee__ChooseFile  ()
	{
		if (!specifications.Configuration.choosefile) {
			addMenu__wrappee__FeatureAMP();
			return;
		}
////ChooseFile
		addMenu__wrappee__FeatureAMP();

		JMenuItem menuItem = new JMenuItem("Datei \u00F6ffnen");
		menu.add(menuItem);
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
				{
				try
					{
					fileopen();
					}catch (Exception err)
						{
						}
				}
		});
	}

	
	 private void  addMenu__wrappee__LoadFolder  ()
		{
		if (!specifications.Configuration.loadfolder) {
			addMenu__wrappee__ChooseFile();
			return;
		}
		addMenu__wrappee__ChooseFile();
		JMenuItem mntmOrdnerffnen = new JMenuItem("Ordner \u00F6ffnen");
		menu.add(mntmOrdnerffnen);
		
		mntmOrdnerffnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
				{
				directoryopen();
				}
		});
		}

	

	public void addMenu()
		{
		if (!specifications.Configuration.saveandloadplaylist) {
			addMenu__wrappee__LoadFolder();
			return;
		}
		addMenu__wrappee__LoadFolder();
		////SaveAndLoadPlaylist
		JMenuItem menuItem_1 = new JMenuItem("Playlist speichern");
		menu.add(menuItem_1);
		
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				savePlaylist();
			}
		});
		
		JMenuItem menuItem_2 = new JMenuItem("Playlist laden");
		menu.add(menuItem_2);
		
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadPlaylist();
			}
		});
		}

	

	
	 

	
	 private void  addButtons__wrappee__WAV  ()
		{
		if (!specifications.Configuration.wav) {
			return;
		}
		WAV=true;

		}

	
	 private void  addButtons__wrappee__OGG  ()
		{
		if (!specifications.Configuration.ogg) {
			addButtons__wrappee__WAV();
			return;
		}
		OGG=true;
		addButtons__wrappee__WAV();
		}

	
	 private void  addButtons__wrappee__MP3  ()
		{
		if (!specifications.Configuration.mp3) {
			addButtons__wrappee__OGG();
			return;
		}
		MP3=true;
		addButtons__wrappee__OGG();
		}

	
	
 private void  addButtons__wrappee__GUI  ()
	{
		if (!specifications.Configuration.gui) {
			addButtons__wrappee__MP3();
			return;
		}
	addButtons__wrappee__MP3();
	}

	
	 private void  addButtons__wrappee__ShowTime  ()
		{
		if (!specifications.Configuration.showtime) {
			addButtons__wrappee__GUI();
			return;
		}
		showTime=true;
		addButtons__wrappee__GUI();	
		}

	
	
	 private void  addButtons__wrappee__ProgressBar  ()
		{
		if (!specifications.Configuration.progressbar) {
			addButtons__wrappee__ShowTime();
			return;
		}
		addButtons__wrappee__ShowTime();
		progressBar = new JProgressBar();
		progressBar.setName("progressBar");
		progressBar.setStringPainted(true);
		progressBar.setBounds(26, 251, 301, 17);
		frmAsd.getContentPane().add(progressBar);
		}

	
	
	 private void  addButtons__wrappee__VolumeControl  ()
		{
		if (!specifications.Configuration.volumecontrol) {
			addButtons__wrappee__ProgressBar();
			return;
		}
		addButtons__wrappee__ProgressBar();
	////VolumeControl
				lblLautstrke = new JLabel("Lautst\u00E4rke:");
				lblLautstrke.setBounds(26, 313, 55, 14);
				frmAsd.getContentPane().add(lblLautstrke);
				
				slider=new JSlider();
				slider.setName("slider");
				slider.setValue(100);
				slider.setBounds(100, 304, 135, 23);
				frmAsd.getContentPane().add(slider);
				
				slider.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent arg0) {
						setVolume(slider.getValue());
						volume=slider.getValue();
					}
				});
		}

	
	
	 private void  addButtons__wrappee__Mute  ()
		{
		if (!specifications.Configuration.mute) {
			addButtons__wrappee__VolumeControl();
			return;
		}
	////Mute
		addButtons__wrappee__VolumeControl();
				btnmute = new JButton("");
				btnmute.setName("mute");
				btnmute.setBounds(266, 309, 36, 36);
				btnmute.setIcon(new ImageIcon(Application.class.getResource("/engine/resources/unmute.png")));
				frmAsd.getContentPane().add(btnmute);
				
				btnmute.addActionListener(new ActionListener() 
				{
				public void actionPerformed(ActionEvent arg0) 
					{
					if (muted==false)
						{
						muted=true;
						oldVolume=getVolume();
						setVolume(0);
						setSliderEnabled(false);
						btnmute.setIcon(new ImageIcon(Application.class.getResource("/engine/resources/mute.png")));
						}else
							{
							muted=false;
							setSliderEnabled(true);
							setVolume(oldVolume);
							btnmute.setIcon(new ImageIcon(Application.class.getResource("/engine/resources/unmute.png")));
							}
				}
			});
		}

	
	
	 private void  addButtons__wrappee__Playlist  ()
		{
		if (!specifications.Configuration.playlist) {
			addButtons__wrappee__Mute();
			return;
		}
	////PlayList
		playlist=true;
		addButtons__wrappee__Mute();
				scrollPane = new JScrollPane();
				scrollPane.setBounds(361, 49, 409, 264);
				frmAsd.getContentPane().add(scrollPane);
				
				listModel=new DefaultListModel<String>();		
				list=(new JList<String>(listModel));
				list.setName("p_list");
				scrollPane.setViewportView(list);
				
				list.addMouseListener(new MouseAdapter() 
					{
					public void mouseClicked(MouseEvent e ) 
					  	{
					    if ( e.getClickCount() == 2 && queueListIsEmpty()) 
					    	{
					    	deactivateShuffleRepeat();
					    	
					    	for (int i=0; i<1000;i++)
				    		{
				    		if (zuordnungsliste[i]!=null && zuordnungsliste[i].getAnzeige().equals(list.getSelectedValue()))
				    			{
				    			System.out.println(zuordnungsliste[i].getFile());
				    			selectedFile=(zuordnungsliste[i].getFile());
				    			playTitle(selectedFile,false);
			    			
				    			break;
				    			}
				    		}
					    	}
					    }
					});
		}

	

	 private void  addButtons__wrappee__SkipTrack  ()
		{
		if (!specifications.Configuration.skiptrack) {
			addButtons__wrappee__Playlist();
			return;
		}
		addButtons__wrappee__Playlist();
		btnNextTrack = new JButton("=>");
		btnNextTrack.setName("nextTrack");
		btnNextTrack.setBounds(100, 279, 64, 23);
		frmAsd.getContentPane().add(btnNextTrack);
		
		btnNextTrack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			skiptrack();
			}
		});
		}

	
	
	
	 private void  addButtons__wrappee__ShuffleRepeat  ()
		{
		if (!specifications.Configuration.shufflerepeat) {
			addButtons__wrappee__SkipTrack();
			return;
		}
		addButtons__wrappee__SkipTrack();
		///SHUFFLEREPEAT
		lblRepeattrack = new JLabel("RepeatTrack");
		lblRepeattrack.setBounds(181, 59, 82, 14);
		frmAsd.getContentPane().add(lblRepeattrack);
		
		lblRepeatPlaylist = new JLabel("RepeatPlaylist");
		lblRepeatPlaylist.setBounds(181, 104, 82, 14);
		frmAsd.getContentPane().add(lblRepeatPlaylist);
		
		lblShuffle = new JLabel("Shuffle");
		lblShuffle.setBounds(181, 150, 82, 14);
		frmAsd.getContentPane().add(lblShuffle);
		
		repeatTrackbtn = new JButton("");
		repeatTrackbtn.setName("repeatTrack");
		repeatTrackbtn.setBounds(273, 50, 26, 23);
		repeatTrackbtn.setIcon(new ImageIcon(Application.class.getResource("/engine/resources/red.png")));
		frmAsd.getContentPane().add(repeatTrackbtn);
		
		repeatPlaylistbtn = new JButton("");
		repeatPlaylistbtn.setName("repeatPlaylist");
		repeatPlaylistbtn.setBounds(273, 95, 26, 23);
		repeatPlaylistbtn.setIcon(new ImageIcon(Application.class.getResource("/engine/resources/red.png")));
		frmAsd.getContentPane().add(repeatPlaylistbtn);
		
		shufflebtn = new JButton("");
		shufflebtn.setName("shuffle"); 	
		shufflebtn.setBounds(273, 139, 26, 25);
		shufflebtn.setIcon(new ImageIcon(Application.class.getResource("/engine/resources/red.png")));		
		frmAsd.getContentPane().add(shufflebtn);
		
		repeatTrackbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (repeatTrack)
					{
					repeatTrack=false;
					}else
						{
						repeatTrack=true;
						repeatTrackbtn.setIcon(new ImageIcon(Application.class.getResource("/engine/resources/green.png")));
						repeatPlaylistbtn.setIcon(new ImageIcon(Application.class.getResource("/engine/resources/red.png")));
						shufflebtn.setIcon(new ImageIcon(Application.class.getResource("/engine/resources/red.png")));
						shuffle=false;
						repeatPlaylist=false;
						}
			}
		});
		
		repeatPlaylistbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (repeatPlaylist)
					{
					repeatPlaylist=false;
					}else
						{
						repeatPlaylist=true;
						repeatTrackbtn.setIcon(new ImageIcon(Application.class.getResource("/engine/resources/red.png")));
						repeatPlaylistbtn.setIcon(new ImageIcon(Application.class.getResource("/engine/resources/green.png")));
						shufflebtn.setIcon(new ImageIcon(Application.class.getResource("/engine/resources/red.png")));						
						repeatTrack=false;
						shuffle=false;
						}
			}
		});
		
		shufflebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (shuffle)
					{
					shuffle=false;
					}else
						{
						shuffle=true;
						repeatTrackbtn.setIcon(new ImageIcon(Application.class.getResource("/engine/resources/red.png")));
						repeatPlaylistbtn.setIcon(new ImageIcon(Application.class.getResource("/engine/resources/red.png")));
						shufflebtn.setIcon(new ImageIcon(Application.class.getResource("/engine/resources/green.png")));
						repeatPlaylist=false;
						repeatTrack=false;
						}
			}
		});
		
		}

	
	
	 private void  addButtons__wrappee__RemoveTrack  ()
		{
		if (!specifications.Configuration.removetrack) {
			addButtons__wrappee__ShuffleRepeat();
			return;
		}
		addButtons__wrappee__ShuffleRepeat();
		
		btnRemoveTrack = new JButton("RemoveTrack(s)");
		btnRemoveTrack.setName("removeTrack");
		btnRemoveTrack.setBounds(635, 324, 135, 23);
		frmAsd.getContentPane().add(btnRemoveTrack);
		
		btnRemoveTrack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeTracks();
			}
		});
		}

	
	
	 private void  addButtons__wrappee__ClearPlaylist  ()
		{
		if (!specifications.Configuration.clearplaylist) {
			addButtons__wrappee__RemoveTrack();
			return;
		}
		addButtons__wrappee__RemoveTrack();
		
		////ClearPlaylist
		JButton btnClearList = new JButton("ClearList");
		btnClearList.setName("clearList");
		btnClearList.setBounds(361, 324, 111, 23);
		frmAsd.getContentPane().add(btnClearList);
		
		btnClearList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearList();
			}
		});
		}

	
	
	 private void  addButtons__wrappee__ReorderPlaylist  ()
		{
		if (!specifications.Configuration.reorderplaylist) {
			addButtons__wrappee__ClearPlaylist();
			return;
		}
		addButtons__wrappee__ClearPlaylist();
		JButton btnTrackUp = new JButton("Nach oben");
		btnTrackUp.setName("trackUp");
		btnTrackUp.setBounds(506, 327, 120, 25);
		frmAsd.getContentPane().add(btnTrackUp);
		
		btnTrackUp.addActionListener(new ActionListener() 
			{
			public void actionPerformed(ActionEvent arg0) 
				{
				swapTrackUp();
				}
			});
		
		JButton btnTrackDown = new JButton("Nach unten");
		btnTrackDown.setName("trackDown");
		btnTrackDown.setBounds(506, 360, 120, 25);
		frmAsd.getContentPane().add(btnTrackDown);
		
		btnTrackDown.addActionListener(new ActionListener() 
			{
			public void actionPerformed(ActionEvent arg0) 
				{
				swapTrackDown();
				}
			});
		}

	

	 private void  addButtons__wrappee__QueueTrack  ()
		{
		if (!specifications.Configuration.queuetrack) {
			addButtons__wrappee__ReorderPlaylist();
			return;
		}
		addButtons__wrappee__ReorderPlaylist();
		queueScrollPane = new JScrollPane();
		queueScrollPane.setBounds(850, 49, 259, 300);
		frmAsd.getContentPane().add(queueScrollPane);
		
		queueListModel=new DefaultListModel<String>();		
		queueList=(new JList<String>(queueListModel));
		queueList.setName("queueLis");
		queueScrollPane.setViewportView(queueList);
			
		queueList.addMouseListener(new MouseAdapter() 
			{
			public void mouseClicked(MouseEvent e ) 
			  	{
			    if ( e.getClickCount() == 2 ) 
			    	{
			    	for (int i=0; i<1000;i++)
		    		{
		    		if (zuordnungsliste[i]!=null && zuordnungsliste[i].getAnzeige().equals(queueList.getSelectedValue()))
		    			{
		    			System.out.println(zuordnungsliste[i].getFile());
		    			selectedFile=(zuordnungsliste[i].getFile());
		    			playTitle(selectedFile,false);
		    			break;
		    			}
		    		}
			    	}
			    }
			});
		
		
		
		btnqueueleft = new JButton("<");
		btnqueueleft.setName("left");
		btnqueueleft.setBounds(790, 200, 50, 23);
		frmAsd.getContentPane().add(btnqueueleft);
		
		btnqueueleft.addActionListener(new ActionListener() 
		{
		public void actionPerformed(ActionEvent e) 
			{			
			if (queueList.getSelectedIndex()>-1) queueListModel.remove(queueList.getSelectedIndex());
			if (queueListModel.isEmpty()) playingqueue=false;
			}
		});
		
		btnqueueright = new JButton(">");
		btnqueueright.setName("right");
		btnqueueright.setBounds(790, 250, 50, 23);
		frmAsd.getContentPane().add(btnqueueright);
		
		btnqueueright.addActionListener(new ActionListener() 
		{
		public void actionPerformed(ActionEvent e) 
			{			
			if (getItem()!=null) 
				{
//				if (queueListIsEmpty())
//					{
//			    	for (int i=0; i<1000;i++)
//			    		{
//			    		if (zuordnungsliste[i]!=null && zuordnungsliste[i].getAnzeige().equals(getItem()))
//			    			{
//			    			System.out.println(zuordnungsliste[i].getFile());
//			    			selectedFile=(zuordnungsliste[i].getFile());
//			    			playTitle(selectedFile,false);
//			    			break;
//			    			}
//			    		}
//					}
				queueListModel.addElement(getItem());
				}
			}
		});
		
		}

	
	
	public void addButtons()
		{
		if (!specifications.Configuration.showcover) {
			addButtons__wrappee__QueueTrack();
			return;
		}
		addButtons__wrappee__QueueTrack();
		///SHOWCOVER
		coverlbl = new JLabel("");
		coverlbl.setBounds(13, 59, 164, 147);
		coverlbl.setIcon(new ImageIcon(Application.class.getResource("/engine/resources/img.jpg")));
		frmAsd.getContentPane().add(coverlbl);
		}

	

	
	 private void  addEngine__wrappee__FeatureAMP  ()
		{
		
		}

	
    
    public void addEngine()
    	{
		if (!specifications.Configuration.playengine) {
			addEngine__wrappee__FeatureAMP();
			return;
		}
    	    	
		btnPlay = new JButton("Play");
		btnPlay.setName("play");
		btnPlay.setBounds(26, 279, 64, 23);
		frmAsd.getContentPane().add(btnPlay);
		
		btnStop = new JButton("Stop");
		btnStop.setName("stop");
		btnStop.setBounds(174, 279, 72, 23);
		frmAsd.getContentPane().add(btnStop);
		
		btnPause = new JButton("||");
		btnPause.setName("pause");
		btnPause.setBounds(256, 279, 71, 23);
		frmAsd.getContentPane().add(btnPause);
		
		btnPlay.addActionListener(new ActionListener() 
		{
		public void actionPerformed(ActionEvent e) 
			{			
				if (nowplayingfile!=null) playTitle(nowplayingfile,true);
			}
		});
		
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopPlaying();
				deactivateShuffleRepeat();
			}
		});
		
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressPauseButton();
			}
		});
		
    	}

	
	
	 private void  addTrack__wrappee__FeatureAMP  (String name, File file)
		{
	
		}

	

public void addTrack(String name, File file)
	{
		if (!specifications.Configuration.playlist) {
			addTrack__wrappee__FeatureAMP(name, file);
			return;
		}
	String insertname=name;
	if (selectedFile==null) 
		{
		selectedFile=file;
		playTitle(selectedFile,false);
		}
	if (!Character.isDigit(insertname.charAt(0))) insertname= generatedTracknumber++ +insertname;
	listModel.addElement(insertname);
	zuordnungsliste[zuordnungsnummer++]=new Zuordnung(insertname,file);
	list.setSelectedIndex(0);
	}

	
	
	 private void  playTitle__wrappee__FeatureAMP  (File selectedFile,boolean pausebeachten) throws UnsupportedTagException, InvalidDataException, IOException, UnsupportedAudioFileException, LineUnavailableException
		{
		
		}

	
    
//////PLAYENGINE-METHODEN
	
	public void playTitle(File selectedFile,boolean pausebeachten) 
	{
		if (!specifications.Configuration.playengine) {
			//playTitle__wrappee__FeatureAMP(selectedFile, pausebeachten);
			return;
		}
	if (selectedFile!=null)
		{
		
		nowplayingfile=selectedFile;
		if (timer!=null) timer.cancel();
		
		
		
		int punktposition = nowplayingfile.toString().lastIndexOf('.');
		String extension="";
		extension = nowplayingfile.toString().substring(punktposition+1);
		
		if (extension.toLowerCase().equals("mp3")) 
			{
		try {
			setId3Info(selectedFile);
		} catch (UnsupportedTagException e1)
			{
			System.out.println("setId3Info UnsupportedTagException");
			}catch (InvalidDataException e2)
				{
				System.out.println("setId3Info InvalidDataException");
				}catch (IOException e3) 
					{
					System.out.println("setId3Info IOExcetion");
					e3.printStackTrace();
					} 
			}
		
		if (extension.toLowerCase().equals("ogg")) 
			{
			AudioFileFormat baseFileFormat;
			try {
				baseFileFormat = AudioSystem.getAudioFileFormat(nowplayingfile);
				Map props = ((TAudioFileFormat)baseFileFormat).properties();
				lengthInSec = Math.round((((Long)props.get("duration")).longValue())/1000000);
				int hh = (int) (lengthInSec * scale3600);
				int mm = (int) (lengthInSec * scale60);
				int ss = (int) (lengthInSec - mm*60 - hh*3600);
				String lengthString=format.format(hh)+ ":"+ format.format(mm) + ":" + format.format(ss);
				
				titelleiste = (String)props.get("author") + " - " +(String)props.get("title") + "  "+ lengthString + " - ";
			} catch (UnsupportedAudioFileException e1)
				{
				e1.printStackTrace();
				}catch (IOException e2) 
					{
					e2.printStackTrace();
					}

			System.out.println(titelleiste);
			id3=titelleiste;
			}
		
		if (extension.toLowerCase().equals("wav")) 
			{
			int wavelength = 0;
			wavelength= (int) getDurationOfWavInSeconds(nowplayingfile);
			lengthInSec=wavelength+1;
			id3=nowplayingfile.getName()+" "+ wavelength+ " - ";
			}


	    
	/// TITELLEISTE setzen
	    setTitelleiste(titelleiste);
		
	/// PLAY			      
			if (player!=null && player.getPlayerStatus()==MP3Player.STATUS_PAUSED && pausebeachten==true)
				{
				player.resume();
				if (muted) player.setLautstaerke(0);
				timer = new Timer();
				timer.schedule( new Task(), 0, 1000 );
				}else
					{
					if (player!=null) player.stop();
					runtime=0;
					setTitelleiste(titelleiste);
					try {
						player=new MP3Player(selectedFile.toString());
					} catch (UnsupportedAudioFileException e1)
						{
						e1.printStackTrace();
						}catch (IOException e2)
							{
							e2.printStackTrace();
							}catch (LineUnavailableException e3) 
							{
							e3.printStackTrace();
							}
					player.play();
					if (muted) player.setLautstaerke(0);
					timer = new Timer();
					timer.schedule( new Task(), 0, 1000 );				
					}		

		}
	}

	
	
	 private void  changeCover__wrappee__FeatureAMP  (ImageIcon image)	
		{
		
		}

	
	
	public void changeCover(ImageIcon image)	
		{
		if (!specifications.Configuration.showcover) {
			changeCover__wrappee__FeatureAMP(image);
			return;
		}
		coverlbl.setIcon(image);
		}

	
	 private void  stopPlaying__wrappee__FeatureAMP  ()
		{
		
		}

	
	
	public void stopPlaying()
	{
		if (!specifications.Configuration.playengine) {
			stopPlaying__wrappee__FeatureAMP();
			return;
		}
	setProgress(0);
	if (player!=null) 
		{
		player.stop();
		if (timer!=null) timer.cancel();
		runtime=0;
	    if (showTime==true) titelleiste=id3+"00:00:00";
	      	else titelleiste=id3;
	    setTitelleiste(titelleiste);
		}
	}

	
	
	 private void  trackFinished__wrappee__FeatureAMP  ()
		{
		
		}

	

 private void  trackFinished__wrappee__Playlist  ()
	{
		if (!specifications.Configuration.playlist) {
			trackFinished__wrappee__FeatureAMP();
			return;
		}
	setProgress(0);
	setTitelleiste("");
	if (repeatTrack)
		{
		playTitle(selectedFile,false);
		}else if(shuffle)
			{
			list.setSelectedIndex(myRandom(0,listModel.getSize()));
			for (int i=0; i<100;i++)
	    		{
	    		if (zuordnungsliste[i]!=null && zuordnungsliste[i].getAnzeige().equals(list.getSelectedValue()))
	    			{
	    			System.out.println(zuordnungsliste[i].getFile());
	    			selectedFile=zuordnungsliste[i].getFile();
	   				playTitle(selectedFile,false);
	    			break;
	    			}
	    		}
			}else if (listModel.getSize() > (list.getSelectedIndex()+1)) 
		    	{
		    	list.setSelectedIndex(list.getSelectedIndex()+1);
		    	for (int i=0; i<100;i++)
		    		{
		    		if (zuordnungsliste[i]!=null && zuordnungsliste[i].getAnzeige().equals(list.getSelectedValue()))
		    			{
		    			System.out.println(zuordnungsliste[i].getFile());
		    			selectedFile=zuordnungsliste[i].getFile();
	    				playTitle(selectedFile,false);
		    			break;
		    			}
		    		}
			    }else if (repeatPlaylist)
	    			{
			    	list.setSelectedIndex(0);	
			    	for (int i=0; i<100;i++)
			    		{
			    		if (zuordnungsliste[i]!=null && zuordnungsliste[i].getAnzeige().equals(list.getSelectedValue()))
			    			{
			    			System.out.println(zuordnungsliste[i].getFile());
			    			selectedFile=zuordnungsliste[i].getFile();
			    			playTitle(selectedFile,false);	
			    			break;
			    			}
			    		}
				}    
	}

	
	
//	public void trackFinished()
//	{
//		if (!specifications.Configuration.queuetrack) {
//			trackFinished__wrappee__Playlist();
//			return;
//		}
//	setProgress(0);
//	setTitelleiste("");
//	
//	if (!queueListIsEmpty())
//		{
//		if (playingqueue==false)
//			{
//			for (int k=0; k<1000;k++)
//				{
//				queueList.setSelectedIndex(0);
//				if (zuordnungsliste[k]!=null && zuordnungsliste[k].getAnzeige().equals(queueList.getSelectedValue()))
//					{
//					selectedFile=zuordnungsliste[k].getFile();
//					playTitle(selectedFile,false);
//					break;
//					}
//				}
//			playingqueue=true;
//			}else
//				{
//				for (int i=0; i<1000;i++)
//					{
//					if (zuordnungsliste[i]!=null && zuordnungsliste[i].getFile().equals(selectedFile))
//						{
//						int stelle=0;
//						for (int j=0; j<queueListModel.getSize();j++)
//							{
//							if (queueListModel.get(j).equals(zuordnungsliste[i].getAnzeige())) stelle=j;
//							}
//						if (stelle<queueListModel.getSize()-1) queueList.setSelectedIndex(stelle+1);
//							else queueList.setSelectedIndex(0);			
//						for (int k=0; k<1000;k++)
//							{
//							if (zuordnungsliste[k]!=null && zuordnungsliste[k].getAnzeige().equals(queueList.getSelectedValue()))
//								{
//								selectedFile=zuordnungsliste[k].getFile();
//								playTitle(selectedFile,false);
//								break;
//								}
//							}
//						break;
//						}
//					}
//				}
//		}else if (repeatTrack)
//			{
//			playTitle(selectedFile,false);
//			}else if(shuffle)
//				{
//				list.setSelectedIndex(myRandom(0,listModel.getSize()));
//				for (int i=0; i<100;i++)
//		    		{
//		    		if (zuordnungsliste[i]!=null && zuordnungsliste[i].getAnzeige().equals(list.getSelectedValue()))
//		    			{
//		    			System.out.println(zuordnungsliste[i].getFile());
//		    			selectedFile=zuordnungsliste[i].getFile();
//		   				playTitle(selectedFile,false);
//		    			break;
//		    			}
//		    		}
//				}else if (listModel.getSize() > (list.getSelectedIndex()+1)) 
//			    	{
//			    	list.setSelectedIndex(list.getSelectedIndex()+1);
//			    	for (int i=0; i<100;i++)
//			    		{
//			    		if (zuordnungsliste[i]!=null && zuordnungsliste[i].getAnzeige().equals(list.getSelectedValue()))
//			    			{
//			    			System.out.println(zuordnungsliste[i].getFile());
//			    			selectedFile=zuordnungsliste[i].getFile();
//		    				playTitle(selectedFile,false);
//			    			break;
//			    			}
//			    		}
//				    }else if (repeatPlaylist)
//		    			{
//				    	list.setSelectedIndex(0);	
//				    	for (int i=0; i<100;i++)
//				    		{
//				    		if (zuordnungsliste[i]!=null && zuordnungsliste[i].getAnzeige().equals(list.getSelectedValue()))
//				    			{
//				    			System.out.println(zuordnungsliste[i].getFile());
//				    			selectedFile=zuordnungsliste[i].getFile();
//				    			playTitle(selectedFile,false);	
//				    			break;
//				    			}
//				    		}
//					}    
//	}

	
	 private void  skiptrack__wrappee__FeatureAMP  ()
		{
		
		}

	


// private void  skiptrack__wrappee__Playlist  ()
//	{
//		if (!specifications.Configuration.playlist) {
//			skiptrack__wrappee__FeatureAMP();
//			return;
//		}
//	stopPlaying();
//	if (selectedFile!=null)
//		{
//		if (shuffle==false)
//				{
//				for (int i=0; i<1000;i++)
//	    			{
//					if (zuordnungsliste[i]!=null && zuordnungsliste[i].getFile().equals(selectedFile))
//	    				{
//						if (zuordnungsliste[i+1]!=null)
//							{							
//							selectedFile=(zuordnungsliste[i+1].getFile());
//							list.setSelectedValue(zuordnungsliste[i+1].getAnzeige(), true);
//								playTitle(selectedFile,false);
//							}else
//								{
//								selectedFile=zuordnungsliste[0].getFile();
//								list.setSelectedValue(zuordnungsliste[0].getAnzeige(), true);
//								playTitle(selectedFile,false);
//								}
//						break;
//	    				}
//	    			}
//				}else
//					{
//			    	list.setSelectedIndex(myRandom(0,listModel.getSize()));
//			    	for (int i=0; i<100;i++)
//			    		{
//			    		if (zuordnungsliste[i]!=null && zuordnungsliste[i].getAnzeige().equals(list.getSelectedValue()))
//			    			{
//			    			System.out.println(zuordnungsliste[i].getFile());
//			    			selectedFile=zuordnungsliste[i].getFile();
//		    				playTitle(selectedFile,false);
//			    			}
//			    		}
//					}
//		}
//}
//
//	
	
	public void skiptrack()
		{
		if (!specifications.Configuration.queuetrack) {
//			skiptrack__wrappee__Playlist();
			return;
		}
		stopPlaying();
		if (selectedFile!=null)
			{
			if (!queueListIsEmpty())
				{
				if (playingqueue==false)
					{
					for (int k=0; k<1000;k++)
						{
						queueList.setSelectedIndex(0);
						if (zuordnungsliste[k]!=null && zuordnungsliste[k].getAnzeige().equals(queueList.getSelectedValue()))
							{
							selectedFile=zuordnungsliste[k].getFile();
							playTitle(selectedFile,false);
							break;
							}
						}
					playingqueue=true;
					}else
						{
					for (int i=0; i<1000;i++)
						{
						if (zuordnungsliste[i]!=null && zuordnungsliste[i].getFile().equals(selectedFile))
							{
							int stelle=0;
							for (int j=0; j<queueListModel.getSize();j++)
								{
								if (queueListModel.get(j).equals(zuordnungsliste[i].getAnzeige())) stelle=j;
								}
							if (stelle<queueListModel.getSize()-1) queueList.setSelectedIndex(stelle+1);
								else queueList.setSelectedIndex(0);			
							for (int k=0; k<1000;k++)
								{
								if (zuordnungsliste[k]!=null && zuordnungsliste[k].getAnzeige().equals(queueList.getSelectedValue()))
									{
									selectedFile=zuordnungsliste[k].getFile();
									playTitle(selectedFile,false);
									break;
									}
								}
							break;
							}
						}
					}
			}else if (shuffle==false)
					{
					for (int i=0; i<1000;i++)
		    			{
						if (zuordnungsliste[i]!=null && zuordnungsliste[i].getFile().equals(selectedFile))
		    				{
							if (zuordnungsliste[i+1]!=null)
								{							
								selectedFile=(zuordnungsliste[i+1].getFile());
								list.setSelectedValue(zuordnungsliste[i+1].getAnzeige(), true);
									playTitle(selectedFile,false);
								}else
									{
									selectedFile=zuordnungsliste[0].getFile();
									list.setSelectedValue(zuordnungsliste[0].getAnzeige(), true);
									playTitle(selectedFile,false);
									}
							break;
		    				}
		    			}
					}else
						{
				    	list.setSelectedIndex(myRandom(0,listModel.getSize()));
				    	for (int i=0; i<100;i++)
				    		{
				    		if (zuordnungsliste[i]!=null && zuordnungsliste[i].getAnzeige().equals(list.getSelectedValue()))
				    			{
				    			System.out.println(zuordnungsliste[i].getFile());
				    			selectedFile=zuordnungsliste[i].getFile();
			    				playTitle(selectedFile,false);
				    			}
				    		}
						}
			}
		}

	
	 private void  setVolume__wrappee__FeatureAMP  (int volume)
		{
		
		}

	

public void setVolume(int volume)
	{
		if (!specifications.Configuration.playengine) {
			setVolume__wrappee__FeatureAMP(volume);
			return;
		}
	if (player!=null) player.setLautstaerke(volume);
	}

	
	 private void  setProgress__wrappee__FeatureAMP  (int progress)	
		{
		
		}

	

	public void setProgress(int progress)	
		{
		if (!specifications.Configuration.progressbar) {
			setProgress__wrappee__FeatureAMP(progress);
			return;
		}
		progressBar.setValue(progress);
		}

	
	 private void  deactivateShuffleRepeat__wrappee__FeatureAMP  ()
		{
		
		}

	
	
	public void deactivateShuffleRepeat()
		{
		if (!specifications.Configuration.shufflerepeat) {
			deactivateShuffleRepeat__wrappee__FeatureAMP();
			return;
		}
		repeatTrackbtn.setIcon(new ImageIcon(Application.class.getResource("/engine/resources/red.png")));
		repeatPlaylistbtn.setIcon(new ImageIcon(Application.class.getResource("/engine/resources/red.png")));
		shufflebtn.setIcon(new ImageIcon(Application.class.getResource("/engine/resources/red.png")));
		shuffle=false;
		repeatPlaylist=false;
		repeatTrack=false;
		}

	
	
	 private void  emptyTrack__wrappee__FeatureAMP  ()
		{
		
		}

	

public void emptyTrack()
	{
		if (!specifications.Configuration.playengine) {
			emptyTrack__wrappee__FeatureAMP();
			return;
		}
	nowplayingfile=null;
	}

	
	 private void  changeSkin__wrappee__FeatureAMP  ()
		{
		
		}

	
	 private void  changeSkin__wrappee__Light  ()
		{
		if (!specifications.Configuration.light) {
			changeSkin__wrappee__FeatureAMP();
			return;
		}
		frmAsd.getContentPane().setBackground(Color.WHITE);
		}

	
	public void changeSkin()
		{
		if (!specifications.Configuration.dark) {
			changeSkin__wrappee__Light();
			return;
		}
		frmAsd.getContentPane().setBackground(Color.BLACK);
		}

	


	
public void fileopen() throws UnsupportedTagException, InvalidDataException, IOException
	{
	FileFilter mp3filter = new FileNameExtensionFilter("MP3-Dateien","mp3"); 
	FileFilter wavfilter = new FileNameExtensionFilter("WAV-Dateien","wav"); 
	FileFilter oggfilter = new FileNameExtensionFilter("OGG-Dateien","ogg"); 

	JFileChooser fileChooser = new JFileChooser();
	
	fileChooser.setAcceptAllFileFilterUsed(false);
	
	if (OGG) fileChooser.setFileFilter(oggfilter);
	if (WAV) fileChooser.setFileFilter(wavfilter);
	if (MP3) fileChooser.setFileFilter(mp3filter);	
	
	int result = fileChooser.showOpenDialog(fileChooser);
	if (result == JFileChooser.APPROVE_OPTION) 
		{
		
		String listenelement="";
		File choosenFile = fileChooser.getSelectedFile();
		int punktposition = choosenFile.toString().lastIndexOf('.');
		String extension="";
		extension = choosenFile.toString().substring(punktposition+1);
		

		
		if (extension.toLowerCase().equals("mp3")) 
			{
			Mp3File mp3file;
			mp3file = new Mp3File(choosenFile.toString());
			ID3Tag id3infos=new ID3Tag(mp3file,140,140,true);
			listenelement=id3infos.getTrack()+" "+ id3infos.getTitle()+" : "+id3infos.getArtist()+" - "+id3infos.getAlbum()+" "+id3infos.getlengthString();
			}

		
		if (extension.toLowerCase().equals("ogg"))
			{
			System.out.println("OGG");
			try {
				AudioFileFormat baseFileFormat = AudioSystem.getAudioFileFormat(choosenFile);
				Map props = ((TAudioFileFormat)baseFileFormat).properties();
				lengthInSec = Math.round((((Long)props.get("duration")).longValue())/1000000);
				
				int hh = (int) (lengthInSec * scale3600);
				int mm = (int) (lengthInSec * scale60);
				int ss = (int) (lengthInSec - mm*60 - hh*3600);
				String lengthString=format.format(hh)+ ":"+ format.format(mm) + ":" + format.format(ss);
				
				listenelement=" "+(String)props.get("title") + " : " + (String)props.get("author") + " - "+ (String)props.get("album") + " " + lengthString;
				} catch (UnsupportedAudioFileException e) 
					{
					e.printStackTrace();
					}
			}
		
		if (extension.toLowerCase().equals("wav"))
			{
			System.out.println("WAV");
			listenelement=" "+choosenFile.getName();
			}
		

		if (playlist==false) 
			{
			selectedFile= choosenFile;
			System.out.println(selectedFile);
			playTitle(selectedFile,false);
			}
		addTrack(listenelement, choosenFile);
		}
	}

	
	
	private JButton btnPlay,btnStop,btnPause;

	
	private Timer timer;

	
	private MP3Player player;

	
	private int runtime=0;

	
	private long lengthInSec;

	
	DecimalFormat format = new DecimalFormat("00");

	
	private final double scale3600 = 1.0/3600;

	
    private final double scale60 = 1.0/60;

	
    private String titelleiste,id3;

	
    private File nowplayingfile;

	
	

	
	public void setId3Info(File selectedFile) throws UnsupportedTagException, InvalidDataException, IOException{
		////MP3File erzeugen
	    Mp3File mp3file= new Mp3File(selectedFile.toString());
	    ID3Tag id3infos=new ID3Tag(mp3file,140,140,true);
		id3=id3infos.getTitleleiste();
		
		titelleiste=id3;

		changeCover(id3infos.getAlbumImage());

	    lengthInSec=id3infos.getLengthInSec();

	}

	
	
	public void changetime()
	{
	if (lengthInSec>runtime)
		{
		runtime++;
		double prozent=100.0/(float)lengthInSec*(float)runtime;
		setProgress((int)prozent);
		int hh = (int) (runtime * scale3600);
		int mm = (int) (runtime * scale60);
		long ss = runtime - mm*60 - hh*3600;
		String laufzeit = format.format(hh)+ ":"+ format.format(mm) + ":" + format.format(ss);
		if (showTime==true) titelleiste=id3+laufzeit;
			else titelleiste=id3;
		setTitelleiste(titelleiste);
		}else
			{
			player.stop();
			if (timer!=null) timer.cancel();
			runtime=0;
//			trackFinished();
			}
	}

	

public void pressPauseButton()
	{
	if (player!=null) 
		{
		player.pause();	
		if (timer!=null) timer.cancel();
		}
	}

	

public double getDurationOfWavInSeconds(File file)
{   
    AudioInputStream stream = null;
    try 
    	{
        stream = AudioSystem.getAudioInputStream(file);
        AudioFormat format = stream.getFormat();
        return file.length() / format.getSampleRate() / (format.getSampleSizeInBits() / 8.0) / format.getChannels();
    	}
    	catch (Exception e) 
    		{
    		// log an error
    		return -1;
    		}
    		finally
    			{
    			try { stream.close(); } catch (Exception ex) { }
    			}
}

	

	
	 

	
	class  Task  extends TimerTask {
		
		@Override 
		public void run()
			{
			changetime();
			}


	}

	
	private JProgressBar progressBar;

	
	private JSlider slider;

	
	JLabel lblLautstrke;

	
	private int volume=100;

	
	
	public int getVolume()
		{
		return volume;
		}

	
	
	public void setSliderEnabled(boolean onoff)
		{
		slider.setEnabled(onoff);
		}

	
	
	private JButton btnmute;

	
	private int oldVolume=0;

	
	private JScrollPane scrollPane;

	
	private Zuordnung[] zuordnungsliste = new Zuordnung[1000];

	
	private DefaultListModel<String> listModel;

	
	private JList<String> list;

	
	private int zuordnungsnummer=0;

	
	private int generatedTracknumber=0;

	
	
public void deleteTrack(int index)
	{
	zuordnungsliste[index]=null;
	for (int i=0; i<999;i++)
		{
		if (zuordnungsliste[i]==null) 
			{
			zuordnungsliste[i]=zuordnungsliste[i+1];
			zuordnungsliste[i+1]=null;
			}
		}
	}

	

public String getItem()
	{
	return list.getSelectedValue();
	}

	

public Zuordnung[] getZuordnungsliste()
	{
	return zuordnungsliste;
	}

	

 private boolean  queueListIsEmpty__wrappee__Playlist  ()
	{
	return true;
	}

	
	
	public boolean queueListIsEmpty()
		{
		if (!specifications.Configuration.queuetrack)
			return queueListIsEmpty__wrappee__Playlist();
		return queueListModel.getSize()==0;
		}

	

 private void  clearList__wrappee__Playlist  ()
	{
	zuordnungsliste=new Zuordnung[1000];
	zuordnungsnummer=0;
	generatedTracknumber=0;
	listModel.clear();
	stopPlaying();
	setTitelleiste("");
	emptyTrack();
	}

		
	

	public void clearList()
		{
		if (!specifications.Configuration.queuetrack) {
			clearList__wrappee__Playlist();
			return;
		}
		clearList__wrappee__Playlist();
		queueListModel.clear();
		}

	

public void removeTracks()
	{
	int[] indices=list.getSelectedIndices();

	for (int i=indices.length-1;i>-1;i--)
		{
		
		if (selectedFile.equals(zuordnungsliste[indices[i]].getFile()))
			{
			stopPlaying();
			setTitelleiste("");
			emptyTrack();
			}

		deleteTrack(indices[i]);
		listModel.removeElementAt(indices[i]);
		}
	}

	
public void writeToFile(String fileName) throws FileNotFoundException {
    PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
    for (int i=0; i<listModel.getSize();i++)
		{
    	pw.println(zuordnungsliste[i].getFile().toString());
		}
    pw.close();
}

	



public void swapTrackUp()
	{
	if (list.getSelectedIndex()>0 && list.getSelectedIndex()<listModel.size())
		{
		Zuordnung swapZuordnung=zuordnungsliste[list.getSelectedIndex()];
		zuordnungsliste[list.getSelectedIndex()]=zuordnungsliste[list.getSelectedIndex()-1];
		zuordnungsliste[list.getSelectedIndex()-1]=swapZuordnung;
		
		
		String swap= listModel.get(list.getSelectedIndex());
		listModel.set(list.getSelectedIndex(), listModel.get(list.getSelectedIndex()-1));
		listModel.set(list.getSelectedIndex()-1, swap);
		list.setSelectedIndex(list.getSelectedIndex()-1);
		

		}
	}

	

public void swapTrackDown()
	{
	if (list.getSelectedIndex()>-1 && list.getSelectedIndex()<listModel.size()-1)
		{
		Zuordnung swapZuordnung=zuordnungsliste[list.getSelectedIndex()];
		zuordnungsliste[list.getSelectedIndex()]=zuordnungsliste[list.getSelectedIndex()+1];
		zuordnungsliste[list.getSelectedIndex()+1]=swapZuordnung;
		
		String swap= listModel.get(list.getSelectedIndex());
		listModel.set(list.getSelectedIndex(), listModel.get(list.getSelectedIndex()+1));
		listModel.set(list.getSelectedIndex()+1, swap);
		list.setSelectedIndex(list.getSelectedIndex()+1);
		}
	}

	
	
	public void directoryopen()
		{
		JFileChooser fileChooser = new JFileChooser("media/");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int result = fileChooser.showOpenDialog(fileChooser);
		if (result == JFileChooser.APPROVE_OPTION) 
			{
			File suchordner = fileChooser.getSelectedFile();
			File[] fileArray = suchordner.listFiles();
			if (fileArray != null) 
				{
				clearList();
				for (int i = 0; i < fileArray.length; i++) 
					{			
					
					int punktposition = fileArray[i].toString().lastIndexOf('.');
					String extension="";
					if (i >= 0) extension = fileArray[i].toString().substring(punktposition+1);
					
					if (extension.toLowerCase().equals("mp3") && MP3) 
						{
						System.out.println(fileArray[i].getAbsolutePath());
						try 
							{
							Mp3File mp3file;
							mp3file = new Mp3File(fileArray[i].toString());
							ID3Tag id3infos=new ID3Tag(mp3file,140,140,true);
							String listenelement=id3infos.getTrack()+" "+ id3infos.getTitle()+" : "+id3infos.getArtist()+" - "+id3infos.getAlbum()+" "+id3infos.getlengthString();						
							addTrack(listenelement,fileArray[i]);
							} catch (UnsupportedTagException e1)
								{}catch (InvalidDataException e2)
									{}catch(IOException e3) 
										{
										e3.printStackTrace();
										}
						}
					
					if (extension.toLowerCase().equals("wav") && WAV) 
						{
						System.out.println(fileArray[i].getAbsolutePath());
						String listenelement=" "+fileArray[i].getName();
						addTrack(listenelement,fileArray[i]);
						}
					
					if (extension.toLowerCase().equals("ogg") && OGG) 
						{
						System.out.println(fileArray[i].getAbsolutePath());
						try {
							AudioFileFormat baseFileFormat=null;
							try {
								baseFileFormat = AudioSystem.getAudioFileFormat(fileArray[i]);
							} catch (IOException e) {
								e.printStackTrace();
							}
							Map props = ((TAudioFileFormat)baseFileFormat).properties();
							lengthInSec = Math.round((((Long)props.get("duration")).longValue())/1000000);
							
							int hh = (int) (lengthInSec * scale3600);
							int mm = (int) (lengthInSec * scale60);
							int ss = (int) (lengthInSec - mm*60 - hh*3600);
							String lengthString=format.format(hh)+ ":"+ format.format(mm) + ":" + format.format(ss);
							
							String listenelement=" "+(String)props.get("title") + " : " + (String)props.get("author") + " - "+ (String)props.get("album") + " " + lengthString;
							addTrack(listenelement,fileArray[i]);
							} catch (UnsupportedAudioFileException e) 
								{
								e.printStackTrace();
								}
						}
					
					
					}
				}					
			}
		}

	
	JButton btnNextTrack;

	
	private JLabel lblRepeattrack, lblRepeatPlaylist, lblShuffle;

	
	private JButton repeatTrackbtn, repeatPlaylistbtn, shufflebtn;

	
	JButton btnRemoveTrack;

	
	
	public void savePlaylist()
	{
	JFileChooser chooser = new JFileChooser(); 
    chooser.setDialogType(JFileChooser.SAVE_DIALOG); 
    FileNameExtensionFilter markUpFilter = new FileNameExtensionFilter( 
            ".m3u", "m3u"); 
    chooser.removeChoosableFileFilter(chooser.getAcceptAllFileFilter()); 
    chooser.setFileFilter(markUpFilter); 
    chooser.setDialogTitle("Speichern unter..."); 
    chooser.setVisible(true); 
    int result = chooser.showSaveDialog(chooser); 
    
    if (result == JFileChooser.APPROVE_OPTION) 
    	{ 

        String pfad = chooser.getSelectedFile().toString(); 
        File file = new File(pfad); 
        if (markUpFilter.accept(file)) 
            System.out.println(pfad + " kann gespeichert werden."); 
        else 
        	pfad+=".m3u";
        System.out.println(pfad + " kann gespeichert werden."); 
        try {
			writeToFile(pfad);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	} 
    chooser.setVisible(false); 
	}

	


	
	public void loadPlaylist()
		{
		FileFilter filter = new FileNameExtensionFilter(".m3u","m3u");         
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(filter); ///// -> Hier durch ADDFilter andere Formate einfügen!
		int result = fileChooser.showOpenDialog(fileChooser);
		if (result == JFileChooser.APPROVE_OPTION) 
			{
	        String pfad = fileChooser.getSelectedFile().toString(); 
	        readFromFile(pfad);
			}
		}

	
	
	public void readFromFile(String fileName)
		{
		BufferedReader br=null;
		clearList();
		try 
			{
			br = new BufferedReader(new FileReader(fileName));
	        String line = br.readLine();
	
	        while (line != null) 
	        	{
	        	System.out.println(line);
	        	if (!line.startsWith("#"))
		        	{
					Mp3File mp3file;
					File file = new File(line); 
					mp3file = new Mp3File(line);
					ID3Tag id3infos=new ID3Tag(mp3file,140,140,true);
					String listenelement=id3infos.getTrack()+" "+ id3infos.getTitle()+" : "+id3infos.getArtist()+" - "+id3infos.getAlbum()+" "+id3infos.getlengthString();
					addTrack(listenelement,file);
		        	}
				line = br.readLine();
	        	}
	        
	        
			} catch (IOException e1)
				{}catch (UnsupportedTagException e2)
					{}catch (InvalidDataException e3) 
				{
				e3.printStackTrace();
				} finally 
					{
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					}
		}

	
	private DefaultListModel<String> queueListModel;

	
	private JList<String> queueList;

	
	private JScrollPane queueScrollPane;

	
	private JButton btnqueueleft, btnqueueright;

	
	private boolean playingqueue=false;

	
	private JLabel coverlbl;


}
