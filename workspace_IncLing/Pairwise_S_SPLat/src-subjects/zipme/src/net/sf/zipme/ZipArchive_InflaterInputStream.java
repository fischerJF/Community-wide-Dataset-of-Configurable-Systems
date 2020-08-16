//

/** 
 */
package net.sf.zipme;



import java.io.IOException;
import java.io.InputStream;

import splat.ZipMeVariables;




public class ZipArchive_InflaterInputStream extends InflaterInputStream {
	private int sz;

	public ZipArchive_InflaterInputStream(InputStream in, Inflater inf, int sz) {
		super(in, inf);
		if (ZipMeVariables.getSINGLETON().isBASE___() ){
			this.sz = sz;
		} 
	}

	public int available() throws IOException {
		if (ZipMeVariables.getSINGLETON().isBASE___() ){
			if (sz == -1)
				return super.available();
			if (super.available() != 0)
				return sz - inf.getTotalOut();
			return 0;
		} else
			return -1;
	}
}
