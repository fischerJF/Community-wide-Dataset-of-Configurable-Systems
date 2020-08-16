//

package net.sf.zipme;

import splat.ZipMeVariables;





/**
 * This class stores the pending output of the Deflater.
 * 
 * @author Jochen Hoenicke
 * @date Jan 5, 2000
 */
class DeflaterPending extends PendingBuffer {
	public DeflaterPending() {
		super(DeflaterConstants.PENDING_BUF_SIZE);
		if (ZipMeVariables.getSINGLETON().isBASE___() ){
		}
	}
}
