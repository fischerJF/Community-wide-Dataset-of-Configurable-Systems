package smashed;//import the packages for using the classes in them into the program

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.RepaintManager;

import annotationclasses___.Feature___;
/*@(Print)*/
 


/**
 *A class for creating a printer option.
 */
@Feature___("Print")
public class Print implements Printable{
/*@(Print)*/
 
	@Feature___("Print")
	private Component componentToBePrinted;
/*@(Print)*/
 
	
	@Feature___("Print")
	public static void printComponent(Component c){
		new Print(c).print();
	}
/*@(Print)*/
 
	@Feature___("Print")
	public Print(Component componentToBePrinted){
		this.componentToBePrinted = componentToBePrinted;
	}
/*@(Print)*/
 
	@Feature___("Print")
	public void print(){
//		PrinterJob printJob = PrinterJob.getPrinterJob();
		try{
		  PrinterJob printJob = (PrinterJob) Class.forName("sun.print.PSPrinterJob").newInstance();
	    printJob.setPrintable(this);
	    if(printJob.printDialog())
			printJob.print();
		}
		catch(PrinterException pe){
			System.out.println("Error printing: " + pe);
		} catch (InstantiationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
	}
/*@(Print)*/
 
	@Feature___("Print")
	public int print(Graphics g, PageFormat pageFormat, int pageIndex){
		if(pageIndex > 0){
			return(NO_SUCH_PAGE);
		}
		else{
			Graphics2D g2d = (Graphics2D)g;
			g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
			disableDoubleBuffering(componentToBePrinted);
			componentToBePrinted.paint(g2d);
			enableDoubleBuffering(componentToBePrinted);
			return(PAGE_EXISTS);
		}
	}
/*@(Print)*/
 
	@Feature___("Print")
	public static void disableDoubleBuffering(Component c){
		RepaintManager currentManager = RepaintManager.currentManager(c);
		currentManager.setDoubleBufferingEnabled(false);
	}
/*@(Print)*/
 
	@Feature___("Print")
	public static void enableDoubleBuffering(Component c){
		RepaintManager currentManager = RepaintManager.currentManager(c);
		currentManager.setDoubleBufferingEnabled(true);
	}
}
