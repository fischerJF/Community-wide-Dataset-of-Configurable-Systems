package smashed;//import the packages for using the classes in them into this class

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import annotationclasses___.Anonymous___;
import annotationclasses___.Feature___;



/**
 *A class for creating JFontDialog
 */
@Feature___("Format")
public class Fonts extends JDialog{
  /*@(Format)*/

  /**
   *@see Center.java
   *this class to make the JDialog in the center
   */
  @Feature___("Format")
  public Center center = new Center(this);
  /*@(Format)*/


  //declaration of the private variables used in the program
  @Feature___("Format")
  private JPanel jp = new JPanel();
  /*@(Format)*/

  @Feature___("Format")
  private JLabel fjl = new JLabel("Fonts: ");
  /*@(Format)*/

  @Feature___("Format")
  private JComboBox fjcb = new JComboBox();
  /*@(Format)*/

  /**
   *-> GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames() <-
   *		WE USING THIS METHOD TO GET ALL FONT IN THE SYSTEM (OS)
   */
  @Feature___("Format")
  private String fonts[]=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
  /*@(Format)*/

  @Feature___("Format")
  private JLabel sjl = new JLabel("Sizes: ");
  /*@(Format)*/

  @Feature___("Format")
  private JComboBox sjcb = new JComboBox();
  /*@(Format)*/

  @Feature___("Format")
  private String sizes[] = {"8","10","12","14","16","18","20","24","28","32","48","72"};
  /*@(Format)*/

  @Feature___("Format")
  private JLabel tjl = new JLabel("Types: ");
  /*@(Format)*/

  @Feature___("Format")
  private JComboBox tjcb = new JComboBox();
  /*@(Format)*/

  @Feature___("Format")
  private String types[] = {"Regular", "Bold", "Italic", "Bold Italic"};
  /*@(Format)*/

  @Feature___("Format")
  private JLabel jjl = new JLabel("Preview:");
  /*@(Format)*/

  @Feature___("Format")
  private JLabel jl = new JLabel("AaBaCcDdeEfFgGhHjJ");
  /*@(Format)*/

  @Feature___("Format")
  private JButton okjb = new JButton("OK");
  /*@(Format)*/

  @Feature___("Format")
  private JButton cajb = new JButton("Cancel");
  /*@(Format)*/

  //for using ok & cancel button @Actions.java
  @Feature___("Format")
  public JButton getOkjb(){
    return okjb;
  }
  /*@(Format)*/

  @Feature___("Format")
  public JButton getCajb(){
    return cajb;
  }
  /*@(Format)*/

  //Constructor of Fonts
  @Feature___("Format")
  public Fonts(){
    //for setting the title
    setTitle("Font Dialog");
    setResizable(false);
    /**
     *setting the layout (GridLayout: 5 rows & 2 columns)
     *add font JLabel, add font JComboBox
     *add type JLabel, add type JComboBox
     *add size JLabel, add size JComboBox
     *add preview JLabel,add test JLabel
     *add ok button, add cancel button
     */
    jp.setLayout(new GridLayout(5,2,1,1));
    jp.add(fjl);
    jp.add(fjcb = new JComboBox(fonts));
    jp.add(sjl);
    jp.add(sjcb = new JComboBox(sizes));
    jp.add(tjl);
    jp.add(tjcb = new JComboBox(types));
    jp.add(jjl);
    jl.setBorder(BorderFactory.createEtchedBorder());
    jp.add(jl);
    jp.add(okjb);
    jp.add(cajb);
    //add JPanel to the Container
    this.getContentPane().add(jp);
    /**
     *for making JDialog at the center, 
     *@Center.java 
     */
    center.fCenter();
    //add action listener to Font JComboBox to get the selected item for setting the preview
    fjcb.addActionListener(new ActionListener(){
      /*@(Format)*/

      @Anonymous___("0")
      @Feature___("Format")
      public void actionPerformed(ActionEvent ae){
        jl.setFont(new Font(String.valueOf(fjcb.getSelectedItem()),tjcb.getSelectedIndex(),14));
      }
    });
    //add action listener to Type JComboBox to get the selected index for setting the preview
    tjcb.addActionListener(new ActionListener(){
      /*@(Format)*/

      @Anonymous___("1")
      @Feature___("Format")
      public void actionPerformed(ActionEvent ae){
        jl.setFont(new Font(String.valueOf(fjcb.getSelectedItem()),tjcb.getSelectedIndex(),14));
      }
    });
  }
  /*@(Format)*/

  /*
   *@return font value: (Font,Type,Size)
   */
  @Feature___("Format")
  public Font font(){
    Font font = new Font(String.valueOf(fjcb.getSelectedItem()), tjcb.getSelectedIndex(),
        Integer.parseInt(String.valueOf(sjcb.getSelectedItem())));
    return font;
  }
}
