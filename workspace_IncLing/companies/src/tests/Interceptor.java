//from http://stackoverflow.com/questions/3228427/redirect-system-out-println

package tests;

import static org.junit.Assert.assertTrue;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Interceptor extends PrintStream
{
  /** the logger */
  private List<String> log;
  /** the origin output stream */
  PrintStream orig;

  /**
   * Initializes a new instance of the class Interceptor.
   *
   * @param out the output stream to be assigned
   * @param log the logger
   */
  public Interceptor(OutputStream out)
  {
    super( out, true );
    this.log = new ArrayList<String>();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void finalize() throws Throwable
  {
    detachOut();
    super.finalize();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void print( String s )
  {
    //do what ever you like
    orig.print( s );
    log.add(s);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void println( String s )
  {
    log.add(s);
  }

  /**
   * Attaches System.out to interceptor.
   */
  public void attachOut()
  {
    orig  = System.out;
    System.setOut( this );
  }

  /**
   * Attaches System.err to interceptor.
   */
  public void attachErr()
  {
    orig = System.err;
    System.setErr( this );
  }

  /**
   * Detaches System.out.
   */
  public void detachOut()
  {
    if( null != orig )
    {
      System.setOut( orig );
    }
  }

  /**
   * Detaches System.err.
   */
  public void detachErr()
  {
    if( null != orig )
    {
      System.setErr( orig );
    }
  }
  
  public void checkOutput(List<String> expected) {
    for(String s : expected) {
      boolean f = false;
      for (String e : log) {
        f = e.contains(s);
        
        if (f) {
          break;
        }
      }
      if (!f)
      assertTrue(s,f);
    }
  }
}