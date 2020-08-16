package tests;

import static org.junit.Assert.assertTrue;

import java.io.Reader;
import java.io.StringReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.susebox.jtopas.Flags;
import de.susebox.jtopas.StandardTokenizer;
import de.susebox.jtopas.StandardTokenizerProperties;
import de.susebox.jtopas.Token;
import de.susebox.jtopas.TokenizerProperties;

public class TestTextAccess extends JTopasTest{
  
  @Override
  protected void configure() {
    // set mandatory features
    super.configure();
    if (testName == null) {
      throw new RuntimeException();
    }
    String strTestName = testName.getMethodName();
//    if (strTestName.equals("testGetText")
//     || strTestName.equals("testSetReadPos")
//        ) {
//      // it works with just BASE___ feature enabled
//    } else {
//      System.err.printf("%s did not set default configuration", strTestName);
//    }
  }

  private StandardTokenizer   _tokenizer  = null;
  private TokenizerProperties _properties = null;
  
  @Before
  public void setUp() throws Exception {
    _properties = new StandardTokenizerProperties();
    _tokenizer  = new StandardTokenizer(_properties);
    
    _properties.setParseFlags(_properties.getParseFlags() 
                            | Flags.F_KEEP_DATA 
                            | Flags.F_RETURN_WHITESPACES);
    _properties.addString("'", "'", "\\");
    _properties.addString("\"", "\"", "\\");
  }
  
  @After
  public void tearDown() throws Exception {
    _tokenizer.close();
  }

  /**
   * Testing various direct text access things. Moreover, the determination of
   * the read position is tested.
   */
  @Test
  public void testGetText() throws Throwable {
    String  text   = "A text to parse.";
    Reader  reader = new StringReader(text);

    // setting the input stream
    _tokenizer.setSource(reader);
    _tokenizer.readMore();
    
    // checking ranges and positions
    int startPos = _tokenizer.getRangeStart();
    int readPos  = _tokenizer.getReadPosition();
    
    assertTrue("Current read position " + readPos + " differs from range start + " + startPos + ".", 
               startPos == readPos);
    assertTrue("Current range " + _tokenizer.currentlyAvailable() + " differs from text length " + text.length() + ".", 
               _tokenizer.currentlyAvailable() == text.length());
    
    // Check the moving of the read position
    while (_tokenizer.hasMoreToken()) {
      Token token = _tokenizer.nextToken();
    
      assertTrue("Current read position did not move by length of token " + token.getLength() 
                  + ". Moved by " + (_tokenizer.getReadPosition() - readPos) + ".",
                 _tokenizer.getReadPosition() - readPos == token.getLength());
      readPos = _tokenizer.getReadPosition();
    }
    
    // retrieving text
    String  readText = _tokenizer.getText(0, text.length());
    assertTrue("Retrieved different text \"" + readText + "\".", readText.equals(text));
    
    // retrieving text piecewise
    for (int pos = 0; pos < text.length(); ++pos) {
      for (int len = 0; len < _tokenizer.currentlyAvailable() - pos; ++len) {
        readText = _tokenizer.getText(pos, len);
        assertTrue("Expected \"" + text.substring(pos, pos + len) + "\", found \"" + readText + "\".",
                  readText.equals(text.substring(pos, pos + len)));
      }
    }

    // retrieving text characters
    for (int pos = 0; pos < text.length(); ++pos) {
      char ch = _tokenizer.getChar(pos);
      
      assertTrue("Expected '" + text.charAt(pos) + "', found '" + ch + "'.",
                 ch == text.charAt(pos));
    }
  }
  
  
  /**
   * Testing various direct text access things. Moreover, the determination of
   * the read position is tested.
   */
  @Test
  public void testSetReadPos() throws Throwable {
    String  text   = "A text to parse.";
    Reader  reader = new StringReader(text);

    // setting the input stream
    _tokenizer.setSource(reader);
    _tokenizer.readMore();
    
    // Check relative setting of the read position
    while (_tokenizer.hasMoreToken()) {
      Token   token = _tokenizer.nextToken();
      String  image = _tokenizer.currentImage();
      int     retry = 0;
      
      if (token.getType() == Token.EOF) {
        break;
      }
      while (retry++ < 10) {
        Token token2;
        
        _tokenizer.setReadPositionRelative( - token.getLength());
        assertTrue("Should have another token.", _tokenizer.hasMoreToken());
        token2 = _tokenizer.nextToken();
        assertTrue("Retrieved unexpected token \"" + _tokenizer.currentImage() + "\" instead of \"" + image + "\".",
                   token.equals(token2));
      }
    }

    // Check absolute setting of the read position
    _tokenizer.setReadPositionAbsolute(0);
    assertTrue(_tokenizer.getReadPosition() == 0);
    
    while (_tokenizer.hasMoreToken()) {
      Token   token    = _tokenizer.nextToken();
      String  image    = _tokenizer.currentImage();
      int     startPos = token.getStartPosition();
      int     retry    = 0;
      
      if (token.getType() == Token.EOF) {
        break;
      }
      while (retry++ < 10) {
        Token token2;
        
        _tokenizer.setReadPositionAbsolute(startPos);
        assertTrue("Should have another token.", _tokenizer.hasMoreToken());
        token2 = _tokenizer.nextToken();
        assertTrue("Retrieved unexpected token \"" + _tokenizer.currentImage() + "\" instead of \"" + image + "\".",
                   token.equals(token2));
      }
    }
  }
  
}

