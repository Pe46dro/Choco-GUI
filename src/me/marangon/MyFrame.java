package me.marangon;

/**
 * Simple class to manage JFrame
 * @author marangon.pietro
 */
import java.awt.*; 
import javax.swing.*;

class MyFrame extends JFrame
{
    
/**
 * 
 * @param title
 * @param sizeX
 * @param sizeY
 * @param locX
 * @param locY
 * @param align
 * @param hgap
 * @param vgap 
 */
  MyFrame( String title , int sizeX , int sizeY, int locX, int locY, int align, int hgap, int vgap ){
    super(title);
    setSize(sizeX,sizeY);
    setLocation(locX,locY);
    setLocationRelativeTo(null);
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setLayout( new FlowLayout(align,hgap,vgap) );
  }

  
  /**
   * Create a new JFrame whit GridLayout
   * @param title
   * @param sizeX
   * @param sizeY
   * @param locX
   * @param locY
   * @param layout
   * @param row
   * @param col
   * @param hgap
   * @param vgap 
   */
  MyFrame( String title , int sizeX , int sizeY, int locX, int locY , int row, int col, int hgap, int vgap ){
    super(title);
    setSize(sizeX,sizeY);
    setLocation(locX,locY);
    setLocationRelativeTo(null);
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setLayout( new GridLayout(row,col,hgap,vgap) );
  }
  
  /**
   * Create a new JFrame BorderLayout 
   * @param title
   * @param sizeX
   * @param sizeY
   * @param locX
   * @param locY
   * @param hgap
   * @param vgap 
   */
  MyFrame( String title , int sizeX , int sizeY, int locX, int locY, int hgap, int vgap ){
    super(title);
    setSize(sizeX,sizeY);
    setLocation(locX,locY);
    setLocationRelativeTo(null);
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setLayout( new BorderLayout(hgap,vgap) );
  }
  
  /**
   * Create a new JFrame whitout layout
   * @param title
   * @param sizeX
   * @param sizeY
   * @param locX
   * @param locY 
   */
  MyFrame( String title , int sizeX , int sizeY, int locX, int locY){
    super(title);
    setSize(sizeX,sizeY);
    setLocation(locX,locY);
    setLocationRelativeTo(null);
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setLayout( null );
  }
  
  /**
   * Show frame
   */
  public void showFrame(){
      setVisible(true);
  }

  /**
   * Hide Frame
   */
  public void hideFrame(){
      setVisible(false);
  }

} 
