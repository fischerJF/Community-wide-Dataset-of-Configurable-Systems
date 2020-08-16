package tests;

import java.io.IOException;
import java.io.InputStream;

public class TestInputStream extends InputStream {
  int[] stream;
  int cont;
  int eos;
  int max;
  
  TestInputStream(int[] newStream){
    stream = newStream;
    cont = 0;
    max = stream.length;
    if(stream == null){
      eos = 1;
    }
  }
  
  @Override
  public int read() throws IOException {   
    if(cont < max){
        int result = stream[cont];
        cont++;
        return result;
    }
    eos = 1;
    return -1;
  }
  
  public void close(){
    stream = null;
  }
}
