// DerivativeCompressGZIP

package net.sf.zipme;



import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;

import specifications.Configuration;




/**
 * This filter stream is used to compress a stream into a "GZIP" stream. The
 * "GZIP" format is described in RFC 1952.
 * 
 * @author John Leuner
 * @author Tom Tromey
 * @since JDK 1.1
 */
public class GZIPOutputStream extends DeflaterOutputStream {
  /**
   * CRC-32 value for uncompressed data
   */
  public CRC32 crc;

  /**
   * Creates a GZIPOutputStream with the default buffer size
   * 
   * @param out
   *            The stream to read data (to be compressed) from
   */
  public GZIPOutputStream(OutputStream out) throws IOException {
    this(out, 4096);
    if (Configuration.DERIVATIVE_COMPRESS_GZIP){
    }
  }

  /**
   * Creates a GZIPOutputStream with the specified buffer size
   * 
   * @param out
   *            The stream to read compressed data from
   * @param size
   *            Size of the buffer to use
   */
  public GZIPOutputStream(OutputStream out, int size) throws IOException {
    super(out, new Deflater(Deflater.DEFAULT_COMPRESSION, true), size);
  if (Configuration.DERIVATIVE_COMPRESS_GZIP){
      hook();
      int mod_time = (int) (System.currentTimeMillis() / 1000L);
      byte[] gzipHeader = { (byte) GZIPInputStream.GZIP_MAGIC,
          (byte) (GZIPInputStream.GZIP_MAGIC >> 8),
          (byte) Deflater.DEFLATED, 0, (byte) mod_time,
          (byte) (mod_time >> 8), (byte) (mod_time >> 16),
          (byte) (mod_time >> 24), 0, (byte) 255 };
      out.write(gzipHeader);
    }
  }

  public void hook() {
  if (Configuration.DERIVATIVE_COMPRESS_GZIP){}
    if (Configuration.DERIVATIVE_COMPRESS_GZIPCRC){
       crc=new CRC32();
    }
  }

  public synchronized void write(byte[] buf, int off, int len)
      throws IOException {
    super.write(buf, off, len);
    this.hook31(buf, off, len);
  if (Configuration.DERIVATIVE_COMPRESS_GZIP){
    }
  }

  /**
   * Writes remaining compressed output data to the output stream and closes
   * it.
   */
  public void close() throws IOException {
  if (Configuration.DERIVATIVE_COMPRESS_GZIP){
      finish();
      out.close();
    }
  }

  public void finish() throws IOException {
    super.finish();
  if (Configuration.DERIVATIVE_COMPRESS_GZIP){
      int totalin = def.getTotalIn();
      byte[] gzipFooter = new byte[8];
      hook2(gzipFooter);
      gzipFooter[4] = (byte) totalin;
      gzipFooter[5] = (byte) (totalin >> 8);
      gzipFooter[6] = (byte) (totalin >> 16);
      gzipFooter[7] = (byte) (totalin >> 24);
      out.write(gzipFooter);
    }
  }

  private void hook2(byte[] gzipFooter) {
  if (Configuration.DERIVATIVE_COMPRESS_GZIP){
      new GZIPOutputStream_hook22(this, gzipFooter).execute();
    }
  }

  public void hook31(byte[] buf, int off, int len) throws IOException {
  if (Configuration.DERIVATIVE_COMPRESS_GZIP){}
    if (Configuration.DERIVATIVE_COMPRESS_GZIPCRC){
      crc.update(buf,off,len);
    }
  }
}
