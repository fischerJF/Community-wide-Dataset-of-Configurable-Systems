package featureamp.gui.elements; 

import java.awt.Component; 
import java.io.File; 

import javax.swing.JFileChooser; 
import javax.swing.filechooser.FileFilter; 

import featureamp.playback.TrackFactory; 
import java.awt.Container; 

/**
 * TODO description
 */
public   class  Dialogs {
	

	public static File openFile(String filename, Component parent) {
		// Base

		JFileChooser c = new JFileChooser(filename);
		c.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				String formats = null;
				for (String s : TrackFactory.getFormats()) {
					formats = formats == null ? "*." + s : formats + ", *." + s;
				}
				return "Audio files (" + formats + ")";
			}

			@Override
			public boolean accept(File f) {
				boolean b = f.isDirectory();
				for (String s : TrackFactory.getFormats()) {
					b |= f.getName().endsWith(s);
				}
				return b;
			}
		});
		c.setDialogTitle("Please choose any audio file");
		return c.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION ? c
				.getSelectedFile() : null;
	}

	

	public static File openFolder(String filename, Component parent) {
		// OpenFolder

		JFileChooser c = new JFileChooser(filename);
		c.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		c.setDialogTitle("Please choose any folder");
		return c.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION ? c
				.getSelectedFile() : null;
	}

	

	public static File openPlaylist(String filename, Component parent) {
		// SaveAndLoad

		JFileChooser c = new JFileChooser(filename);
		c.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return "Playlist files (*.m3u)";
			}

			@Override
			public boolean accept(File f) {
				return f.isDirectory() || f.getName().endsWith("m3u");
			}
		});
		c.setDialogTitle("Please choose any playlist file");
		return c.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION ? c
				.getSelectedFile() : null;
	}

	

	public static File savePlaylist(String filename, Container parent) {
		// SaveAndLoad
		JFileChooser c = new JFileChooser(filename);
		c.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return "any playlist (*.m3u)";
			}

			@Override
			public boolean accept(File f) {
				return f.isDirectory() || f.getName().endsWith("m3u");
			}
		});
		c.setDialogTitle("save any playlist");
		return c.showSaveDialog(parent) == JFileChooser.APPROVE_OPTION ? c
				.getSelectedFile() : null;
	}


}
