//

package net.sf.zipme;



import java.io.IOException;
import java.io.OutputStream;

import splat.ZipMeVariables;



/**
 * This is a special OutputStream deflating the bytes that are written through
 * it. It uses the Deflater for deflating. A special thing to be noted is that
 * flush() doesn't flush everything in Sun's JDK, but it does so in jazzlib.
 * This is because Sun's Deflater doesn't have a way to flush() everything,
 * without finishing the stream.
 * 
 * @author Tom Tromey, Jochen Hoenicke
 * @date Jan 11, 2001
 */
public class DeflaterOutputStream extends OutputStream {

	/**
	 * This is the subordinate <code>OutputStream</code> that this class
	 * redirects its method calls to.
	 */
	protected OutputStream out;

	/**
	 * This buffer is used temporarily to retrieve the bytes from the deflater
	 * and write them to the underlying output stream.
	 */
	public byte[] buf;

	/**
	 * The deflater which is used to deflate the stream.
	 */
	protected Deflater def;

	/**
	 * Creates a new DeflaterOutputStream with a default Deflater and default
	 * buffer size.
	 * 
	 * @param out
	 *            the output stream where deflated output should be written.
	 */
	public DeflaterOutputStream(OutputStream out) {
		this(out, new Deflater(), 4096);
		if (ZipMeVariables.getSINGLETON().isBASE___() ){
		}
	}

	/**
	 * Creates a new DeflaterOutputStream with the given Deflater and default
	 * buffer size.
	 * 
	 * @param out
	 *            the output stream where deflated output should be written.
	 * @param defl
	 *            the underlying deflater.
	 */
	public DeflaterOutputStream(OutputStream out, Deflater defl) {
		this(out, defl, 4096);
		if (ZipMeVariables.getSINGLETON().isBASE___() ){
		}
	}

	/**
	 * Creates a new DeflaterOutputStream with the given Deflater and buffer
	 * size.
	 * 
	 * @param out
	 *            the output stream where deflated output should be written.
	 * @param defl
	 *            the underlying deflater.
	 * @param bufsize
	 *            the buffer size.
	 * @exception IllegalArgumentException
	 *                if bufsize isn't positive.
	 */
	public DeflaterOutputStream(OutputStream out, Deflater defl, int bufsize) {
		if (ZipMeVariables.getSINGLETON().isBASE___() ){
			this.out = out;
			if (bufsize <= 0)
				throw new IllegalArgumentException("bufsize <= 0");
			buf = new byte[bufsize];
			def = defl;
		}
	}

	/**
	 * Deflates everything in the def's input buffers. This will call
	 * <code>def.deflate()</code> until all bytes from the input buffers are
	 * processed.
	 */
	public void deflate() throws IOException {
		if (ZipMeVariables.getSINGLETON().isCOMPRESS___() ){
			while (!def.needsInput()) {
				int len = def.deflate(buf, 0, buf.length);
				if (len <= 0)
					break;
				out.write(buf, 0, len);
			}
			if (!def.needsInput())
				throw new Error("Can't deflate all input?");
		}
	}

	/**
	 * Flushes the stream by calling flush() on the deflater and then on the
	 * underlying stream. This ensures that all bytes are flushed. This function
	 * doesn't work in Sun's JDK, but only in jazzlib.
	 */
	public void flush() throws IOException {
		if (ZipMeVariables.getSINGLETON().isCOMPRESS___() ){
			def.flush();
			deflate();
			out.flush();
		}
	}

	/**
	 * Finishes the stream by calling finish() on the deflater. This was the
	 * only way to ensure that all bytes are flushed in Sun's JDK.
	 */
	public void finish() throws IOException {
		if (ZipMeVariables.getSINGLETON().isCOMPRESS___() ){
			def.finish();
			while (!def.finished()) {
				int len = def.deflate(buf, 0, buf.length);
				if (len <= 0)
					break;
				out.write(buf, 0, len);
			}
			if (!def.finished())
				throw new Error("Can't deflate all input?");
			out.flush();
		}
	}

	/**
	 * Calls finish() and closes the stream.
	 */
	public void close() throws IOException {
		if (ZipMeVariables.getSINGLETON().isCOMPRESS___() ){
			finish();
			out.close();
		}
	}

	/**
	 * Writes a single byte to the compressed output stream.
	 * 
	 * @param bval
	 *            the byte value.
	 */
	public void write(int bval) throws IOException {
		if (ZipMeVariables.getSINGLETON().isCOMPRESS___() ){
			byte[] b = new byte[1];
			b[0] = (byte) bval;
			write(b, 0, 1);
		}
	}

	/**
	 * This method writes all the bytes in the specified array to the underlying
	 * <code>OutputStream</code>. It does this by calling the three parameter
	 * version of this method - <code>write(byte[], int, int)</code> in this
	 * class instead of writing to the underlying <code>OutputStream</code>
	 * directly. This allows most subclasses to avoid overriding this method.
	 * 
	 * @param buf
	 *            The byte array to write bytes from
	 * @exception IOException
	 *                If an error occurs
	 */
	public void write(byte[] buf) throws IOException {
		if (ZipMeVariables.getSINGLETON().isCOMPRESS___() ){
			write(buf, 0, buf.length);
		}
	}

	/**
	 * Writes a len bytes from an array to the compressed stream.
	 * 
	 * @param buf
	 *            the byte array.
	 * @param off
	 *            the offset into the byte array where to start.
	 * @param len
	 *            the number of bytes to write.
	 */
	public void write(byte[] buf, int off, int len) throws IOException {
		if (ZipMeVariables.getSINGLETON().isCOMPRESS___() ){
			def.setInput(buf, off, len);
			deflate();
		}
	}
}
