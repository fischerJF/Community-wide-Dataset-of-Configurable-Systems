import java.io.EOFException; 
import java.io.IOException; 
import java.io.InputStream; 
import java.io.UnsupportedEncodingException; 





/** 
 * This is a FilterInputStream that reads the files in an zip archive
 * one after another.  It has a special method to get the zip entry of
 * the next file.  The zip entry contains information about the file name
 * size, compressed size, CRC, etc.
 * It includes support for STORED and DEFLATED entries.
 * @author Jochen Hoenicke
 */
public   class  ZipInputStream  extends InflaterInputStream  implements ZipConstants {
	

  public CRC32 crc  = new CRC32();

	

  /**
   * Open the next entry from the zip archive, and return its description. If
   * the previous entry wasn't closed, this method will close it.
   */
  public ZipEntry getNextEntry  () throws IOException {
        if (crc == null)
          throw new IOException("Stream closed.");
      
     
      return entry;
  }

	

  public void hook36  () throws IOException {
      crc.reset();
      }

	

  protected void hook37  (byte[] b, int off, int len) throws IOException {
      if (len > 0)
        crc.update(b, off, len);
    }

	

  public void hook38  () throws IOException {
      if (crc == null)
        throw new IOException("Stream closed.");
     
    
  }

	

  protected void hook39  () throws IOException {
      if ((crc.getValue() & 0xffffffffL) != entry.getCrc())
        throw new ZipException("CRC mismatch");
      crc.reset();
    
  }

	

  public void hook40  () throws IOException {
      crc = null;
    
  }

	

  public CRC32 headCRC  ;

	

  public void hook  () {
      crc = new CRC32();
   
  }

	

  private void hook1  () {
      headCRC = new CRC32();
  }

	

  public void hook2  (int CM) {
      headCRC.update(CM);
  }

	

  public void hook3  (int crcval) throws IOException {
      if (crcval != ((int) headCRC.getValue() & 0xffff))
        throw new IOException("Header CRC value mismatch");
  }

	

  public void hook4  (int crcval) throws IOException {
      if (crcval != (int) crc.getValue())
        throw new IOException("GZIP crc sum mismatch, theirs \""
            + Integer.toHexString(crcval) + "\" and ours \""
            + Integer.toHexString((int) crc.getValue()));
  }

	

  public void hook30  (byte[] buf, int offset, int numRead)
      throws IOException {
      if (numRead > 0)
        crc.update(buf, offset, numRead);
  }

	

 
   
  
  private ZipEntry entry  = null;

	
  int csize  ;

	
  int size  ;

	
  int method  ;

	
  int flags  ;

	
  int avail  ;

	
  public boolean entryAtEOF  ;

	

  /**
   * Creates a new Zip input stream, reading a zip archive.
   */
  public ZipInputStream(InputStream in) {
    super(in, new Inflater(true));
  }

	

 
  private void fillBuf  () throws IOException {
    avail = len = in.read(buf, 0, buf.length);
  }

	

  private int readBuf  (byte[] out, int offset, int length) throws IOException {
    if (avail <= 0) {
      fillBuf();
      if (avail <= 0)
        return -1;
    }
    if (length > avail)
      length = avail;
    System.arraycopy(buf, len - avail, out, offset, length);
    avail -= length;
    return length;
    
  }

	

  private void readFully  (byte[] out) throws IOException {
    int off = 0;
    int len = out.length;
    while (len > 0) {
      int count = readBuf(out, off, len);
      if (count == -1)
        throw new EOFException();
      off += count;
      len -= count;
    }
    
  }

	

  private int readLeByte  () throws IOException {
    if (avail <= 0) {
      fillBuf();
      if (avail <= 0)
        throw new ZipException("EOF in header");
    }
    return buf[len - avail--] & 0xff;
    
  }

	

  /**
   * Read an unsigned short in little endian byte order.
   */
  private int readLeShort  () throws IOException {
      return readLeByte() | (readLeByte() << 8);
   
  }

	

  /**
   * Read an int in little endian byte order.
   */
  private int readLeInt  () throws IOException {
      return readLeShort() | (readLeShort() << 16);
     }

	

  
  private void readDataDescr  () throws IOException {
  
    if (readLeInt() != EXTSIG)
      throw new ZipException("Data descriptor signature not found");
    entry.setCrc(readLeInt() & 0xffffffffL);
    csize = readLeInt();
    size = readLeInt();
    entry.setSize(size & 0xffffffffL);
    entry.setCompressedSize(csize & 0xffffffffL);
    
  }

	

 


  /**
   * Closes the current zip entry and moves to the next one.
   */
  public void closeEntry  () throws IOException {
      if (crc == null)
        throw new IOException("Stream closed.");

  }

	

  public int available  () throws IOException {
    return entryAtEOF ? 0 : 1;
  }

	

  /**
   * Reads a byte from the current zip entry.
   * 
   * @return the byte or -1 on EOF.
   * @exception IOException
   *                if a i/o error occured.
   * @exception ZipException
   *                if the deflated stream is corrupted.
   */
  public int read  () throws IOException {
    byte[] b = new byte[1];
    if (read(b, 0, 1) <= 0)
      return -1;
    return b[0] & 0xff;
  }

	

  /**
   * Reads a block of bytes from the current zip entry.
   * 
   * @return the number of bytes read (may be smaller, even before EOF), or -1
   *         on EOF.
   * @exception IOException
   *                if a i/o error occured.
   * @exception ZipException
   *                if the deflated stream is corrupted.
   */
  public int read  (byte[] b, int off, int len) throws IOException {
      if (len == 0)
        return 0;
      this.hook38();
      if (entry == null)
        return -1;
      boolean finished = false;
      switch (method) {
      case ZipOutputStream.DEFLATED:
        len = super.read(b, off, len);
        if (len < 0) {
          if (!inf.finished())
            throw new ZipException("Inflater not finished!?");
          avail = inf.getRemaining();
          if ((flags & 8) != 0)
            readDataDescr();
          if (inf.getTotalIn() != csize || inf.getTotalOut() != size)
            throw new ZipException("size mismatch: " + csize + ";"
                + size + " <-> " + inf.getTotalIn() + ";"
                + inf.getTotalOut());
          inf.reset();
          finished = true;
        }
        break;
      case ZipOutputStream.STORED:
        if (len > csize && csize >= 0)
          len = csize;
        len = readBuf(b, off, len);
        if (len > 0) {
          csize -= len;
          size -= len;
        }
        if (csize == 0)
          finished = true;
        else if (len < 0)
          throw new ZipException("EOF in stored block");
        break;
      }
      this.hook37(b, off, len);
      if (finished) {
        this.hook39();
        entry = null;
        entryAtEOF = true;
      }
      return len;
  
  }

	

  /**
   * Closes the zip file.
   * 
   * @exception IOException
   *                if a i/o error occured.
   */
  public void close  () throws IOException {
    super.close();
    this.hook40();
    entry = null;
    entryAtEOF = true;
  }

	

  /**
   * Creates a new zip entry for the given name. This is equivalent to new
   * ZipEntry(name).
   * 
   * @param name
   *            the name of the zip entry.
   */
  public ZipEntry createZipEntry  (String name) {
      return new ZipEntry(name);
    
  }


}
