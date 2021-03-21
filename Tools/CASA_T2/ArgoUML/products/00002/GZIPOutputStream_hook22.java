// DerivativeCompressGZIP



public   class  GZIPOutputStream_hook22 {
	
	public GZIPOutputStream_hook22  (GZIPOutputStream _this, byte[] gzipFooter) {
	
			this._this = _this;
			this.gzipFooter = gzipFooter;
		
   }

	

	public void execute  () {
			crcval=(int)(_this.crc.getValue() & 0xffffffff);
		    gzipFooter[0]=(byte)crcval;
		    gzipFooter[1]=(byte)(crcval >> 8);
		    gzipFooter[2]=(byte)(crcval >> 16);
		    gzipFooter[3]=(byte)(crcval >> 24);
		
	}

	

	public GZIPOutputStream _this  ;

	
	public byte[] gzipFooter  ;

	
	public int crcval  ;


}
