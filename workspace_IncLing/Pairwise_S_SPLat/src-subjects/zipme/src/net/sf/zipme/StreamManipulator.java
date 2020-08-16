//

package net.sf.zipme;

import splat.ZipMeVariables;






/**
 * This class allows us to retrieve a specified amount of bits from the input
 * buffer, as well as copy big byte blocks. It uses an int buffer to store up to
 * 31 bits for direct manipulation. This guarantees that we can get at least 16
 * bits, but we only need at most 15, so this is all safe. There are some
 * optimizations in this class, for example, you must never peek more then 8
 * bits more than needed, and you must first peek bits before you may drop them.
 * This is not a general purpose class but optimized for the behaviour of the
 * Inflater.
 * 
 * @author John Leuner, Jochen Hoenicke
 */
class StreamManipulator {
	private byte[] window;
	private int window_start = 0;
	private int window_end = 0;
	private int buffer = 0;
	private int bits_in_buffer = 0;

	/**
	 * Get the next n bits but don't increase input pointer. n must be less or
	 * equal 16 and if you if this call succeeds, you must drop at least n-8
	 * bits in the next call.
	 * 
	 * @return the value of the bits, or -1 if not enough bits available.
	 */
	public final int peekBits(int n) {
		if (ZipMeVariables.getSINGLETON().isBASE___() ){
			if (bits_in_buffer < n) {
				if (window_start == window_end)
					return -1;
				buffer |= (window[window_start++] & 0xff | (window[window_start++] & 0xff) << 8) << bits_in_buffer;
				bits_in_buffer += 16;
			}
			return buffer & ((1 << n) - 1);
		} else
			return -1;
	}

	public final void dropBits(int n) {
		if (ZipMeVariables.getSINGLETON().isBASE___() ){
			buffer >>>= n;
			bits_in_buffer -= n;
		}
	}

	/**
	 * Gets the next n bits and increases input pointer. This is equivalent to
	 * peekBits followed by dropBits, except for correct error handling.
	 * 
	 * @return the value of the bits, or -1 if not enough bits available.
	 */
	public final int getBits(int n) {
		if (ZipMeVariables.getSINGLETON().isBASE___() ){
			int bits = peekBits(n);
			if (bits >= 0)
				dropBits(n);
			return bits;
		} else
			return -1;
	}

	/**
	 * Gets the number of bits available in the bit buffer. This must be only
	 * called when a previous peekBits() returned -1.
	 * 
	 * @return the number of bits available.
	 */
	public final int getAvailableBits() {
		if (ZipMeVariables.getSINGLETON().isBASE___() ){
			return bits_in_buffer;
		} else
			return -1;
	}

	/**
	 * Gets the number of bytes available.
	 * 
	 * @return the number of bytes available.
	 */
	public final int getAvailableBytes() {
		if (ZipMeVariables.getSINGLETON().isBASE___() ){
			return window_end - window_start + (bits_in_buffer >> 3);
		} else
			return -1;
	}

	/**
	 * Skips to the next byte boundary.
	 */
	public void skipToByteBoundary() {
		if (ZipMeVariables.getSINGLETON().isBASE___() ){
			buffer >>= (bits_in_buffer & 7);
			bits_in_buffer &= ~7;
		}
	}

	public final boolean needsInput() {
		if (ZipMeVariables.getSINGLETON().isBASE___() ){
			return window_start == window_end;
		} else
			return false;
	}

	public int copyBytes(byte[] output, int offset, int length) {
		if (ZipMeVariables.getSINGLETON().isBASE___() ){
			if (length < 0)
				throw new IllegalArgumentException("length negative");
			if ((bits_in_buffer & 7) != 0)
				throw new IllegalStateException("Bit buffer is not aligned!");
			int count = 0;
			while (bits_in_buffer > 0 && length > 0) {
				output[offset++] = (byte) buffer;
				buffer >>>= 8;
				bits_in_buffer -= 8;
				length--;
				count++;
			}
			if (length == 0)
				return count;
			int avail = window_end - window_start;
			if (length > avail)
				length = avail;
			System.arraycopy(window, window_start, output, offset, length);
			window_start += length;
			if (((window_start - window_end) & 1) != 0) {
				buffer = (window[window_start++] & 0xff);
				bits_in_buffer = 8;
			}
			return count + length;
		} else
			return -1;
	}

	public StreamManipulator() {
		if (ZipMeVariables.getSINGLETON().isBASE___() ){
		}
	}

	public void reset() {
		if (ZipMeVariables.getSINGLETON().isBASE___() ){
			window_start = window_end = buffer = bits_in_buffer = 0;
		}
	}

	public void setInput(byte[] buf, int off, int len) {
		if (ZipMeVariables.getSINGLETON().isBASE___() ){
			if (window_start < window_end)
				throw new IllegalStateException(
						"Old input was not completely processed");
			int end = off + len;
			if (0 > off || off > end || end > buf.length)
				throw new ArrayIndexOutOfBoundsException();
			if ((len & 1) != 0) {
				buffer |= (buf[off++] & 0xff) << bits_in_buffer;
				bits_in_buffer += 8;
			}
			window = buf;
			window_start = off;
			window_end = end;
		}
	}
}
