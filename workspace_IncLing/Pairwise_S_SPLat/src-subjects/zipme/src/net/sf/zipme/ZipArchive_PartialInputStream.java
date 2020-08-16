//

package net.sf.zipme;



import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.UnsupportedEncodingException;

import splat.ZipMeVariables;




public final class ZipArchive_PartialInputStream extends ByteArrayInputStream {
	private int dummyByteCount;

	public ZipArchive_PartialInputStream(byte[] buffer, int offset, int length) {
		super(buffer, offset, length);
		if (ZipMeVariables.getSINGLETON().isBASE___() ){
		}
	}

	synchronized void setLength(int length) {
		if (ZipMeVariables.getSINGLETON().isBASE___() ){
			count = pos + length;
			if (count > buf.length)
				count = buf.length;
		}
	}

	public synchronized int read() {
		if (ZipMeVariables.getSINGLETON().isBASE___() ){
			if (dummyByteCount > 0 && pos == count) {
				dummyByteCount = 0;
				pos++;
				return 0;
			}
			return super.read();
		} else
			return -1;
	}

	public synchronized int read(byte[] buffer, int offset, int length) {
		if (ZipMeVariables.getSINGLETON().isBASE___() ){
			int numBytes = super.read(buffer, offset, length);
			if (dummyByteCount > 0 && numBytes < length) {
				dummyByteCount = 0;
				if (pos < count)
					buffer[offset + numBytes++] = buf[pos++];
				else if (pos == count) {
					if (numBytes == -1)
						numBytes = 0;
					buffer[offset + numBytes++] = 0;
					pos++;
				}
			}
			return numBytes;
		} else
			return -1;
	}

	void seek(int newpos) {
		if (ZipMeVariables.getSINGLETON().isBASE___() ){
			pos = newpos;
		}
	}

	void readFully(byte[] buf) throws EOFException {
		if (ZipMeVariables.getSINGLETON().isBASE___() ){
			if (read(buf, 0, buf.length) != buf.length)
				throw new EOFException();
		}
	}

	void readFully(byte[] buf, int off, int len) throws EOFException {
		if (ZipMeVariables.getSINGLETON().isBASE___() ){
			if (read(buf, off, len) != len)
				throw new EOFException();
		}
	}

	synchronized int readLeShort() throws EOFException {
		if (ZipMeVariables.getSINGLETON().isBASE___() ){
			int b0 = read();
			int b1 = read();
			if (b1 == -1)
				throw new EOFException();
			return (b0 & 0xff) | (b1 & 0xff) << 8;
		} else
			return -1;
	}

	synchronized int readLeInt() throws EOFException {
		if (ZipMeVariables.getSINGLETON().isBASE___() ){
			int b0 = read();
			int b1 = read();
			int b2 = read();
			int b3 = read();
			if (b3 == -1)
				throw new EOFException();
			return ((b0 & 0xff) | (b1 & 0xff) << 8)
					| ((b2 & 0xff) | (b3 & 0xff) << 8) << 16;
		} else
			return -1;
	}

	synchronized String readString(int length) throws EOFException {
		if (ZipMeVariables.getSINGLETON().isBASE___() ){
			if (length > count - pos)
				throw new EOFException();
			try {
				byte[] b = new byte[length];
				readFully(b);
				return new String(b, 0, length, "UTF-8");
			} catch (UnsupportedEncodingException uee) {
				throw new Error(uee.toString());
			}
		} else
			return null;
	}

	public void addDummyByte() {
		if (ZipMeVariables.getSINGLETON().isBASE___() ){
			dummyByteCount = 1;
		}
	}
}
