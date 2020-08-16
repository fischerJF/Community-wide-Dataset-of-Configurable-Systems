package splat;

import java.util.Map;

import entry.FeatureVar;

public class ZipMeVariables extends Variables {

	private static ZipMeVariables SINGLETON;

	public static ZipMeVariables getSINGLETON() {
		if (SINGLETON == null) {
			SINGLETON = new ZipMeVariables();
		}
		return SINGLETON;
	}

	private FeatureVar BASE___, COMPRESS___, GZIP___, EXTRACT___,
			ARCHIVECHECK___, CRC___, ADLER32CHECKSUM___,
			DERIVATIVE_COMPRESS_ADLER32CHECKSUM___, DERIVATIVE_COMPRESS_CRC___,
			DERIVATIVE_COMPRESS_GZIP___, DERIVATIVE_COMPRESS_GZIPCRC___,
			DERIVATIVE_EXTRACT_CRC___, DERIVATIVE_GZIPCRC___;

	private ZipMeVariables() {
		this.BASE___ = new FeatureVar("BASE___");
		this.COMPRESS___ = new FeatureVar("COMPRESS___");
		this.GZIP___ = new FeatureVar("GZIP___");
		this.EXTRACT___ = new FeatureVar("EXTRACT___");
		this.ARCHIVECHECK___ = new FeatureVar("ARCHIVECHECK___");
		this.CRC___ = new FeatureVar("CRC___");
		this.ADLER32CHECKSUM___ = new FeatureVar("ADLER32CHECKSUM___");
		this.DERIVATIVE_COMPRESS_ADLER32CHECKSUM___ = new FeatureVar(
				"DERIVATIVE_COMPRESS_ADLER32CHECKSUM___");
		this.DERIVATIVE_COMPRESS_CRC___ = new FeatureVar(
				"DERIVATIVE_COMPRESS_CRC___");
		this.DERIVATIVE_COMPRESS_GZIP___ = new FeatureVar(
				"DERIVATIVE_COMPRESS_GZIP___");
		this.DERIVATIVE_COMPRESS_GZIPCRC___ = new FeatureVar(
				"DERIVATIVE_COMPRESS_GZIPCRC___");
		this.DERIVATIVE_EXTRACT_CRC___ = new FeatureVar(
				"DERIVATIVE_EXTRACT_CRC___");
		this.DERIVATIVE_GZIPCRC___ = new FeatureVar("DERIVATIVE_GZIPCRC___");
		restore();

		try {
		//	guidsl = loadGUIDSL(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void init() {
		state.put(BASE___, "1");
		state.put(COMPRESS___, "?");
		state.put(GZIP___, "?");
		state.put(EXTRACT___, "?");
		state.put(ARCHIVECHECK___, "?");
		state.put(CRC___, "?");
		state.put(ADLER32CHECKSUM___, "?");
		state.put(DERIVATIVE_COMPRESS_ADLER32CHECKSUM___, "?");
		state.put(DERIVATIVE_COMPRESS_CRC___, "?");
		state.put(DERIVATIVE_COMPRESS_GZIP___, "?");
		state.put(DERIVATIVE_COMPRESS_GZIPCRC___, "?");
		state.put(DERIVATIVE_EXTRACT_CRC___, "?");
		state.put(DERIVATIVE_GZIPCRC___, "?");
	}

	private String notifyFeatureRead(FeatureVar fvar) {
		String value = state.get(fvar);
		if (value == "?") {
			/**
			 * only makes a choice if it is not already present in the map
			 */
		//	value = SPLat.bt.choose(fvar, this) ? "1" : "0";
			// state.put(fvar, value);
			// System.out.println(fvar.getName() + " = " + state.get(fvar));//
			// remove
		}
		return value;
	}

	public Map<FeatureVar, String> getState() {
		return this.state;
	}

	public boolean isBASE___() {
		return notifyFeatureRead(BASE___).equals("1") ? true : false;
	}

	public boolean isEXTRACT___() {
		return notifyFeatureRead(EXTRACT___).equals("1") ? true : false;
	}

	public boolean isARCHIVECHECK___() {
		return notifyFeatureRead(ARCHIVECHECK___).equals("1") ? true : false;
	}

	public boolean isGZIP___() {
		return notifyFeatureRead(GZIP___).equals("1") ? true : false;
	}

	public boolean isCRC___() {
		return notifyFeatureRead(CRC___).equals("1") ? true : false;
	}

	public boolean isCOMPRESS___() {
		return notifyFeatureRead(COMPRESS___).equals("1") ? true : false;
	}

	public boolean isADLER32CHECKSUM___() {
		return notifyFeatureRead(ADLER32CHECKSUM___).equals("1") ? true : false;
	}

	public boolean isDERIVATIVE_COMPRESS_ADLER32CHECKSUM___() {
		return notifyFeatureRead(DERIVATIVE_COMPRESS_ADLER32CHECKSUM___)
				.equals("1") ? true : false;
	}

	public boolean isDERIVATIVE_COMPRESS_CRC___() {//
		return notifyFeatureRead(DERIVATIVE_COMPRESS_CRC___).equals("1") ? true
				: false;
	}

	public boolean isDERIVATIVE_COMPRESS_GZIP___() {
		return notifyFeatureRead(DERIVATIVE_COMPRESS_GZIP___).equals("1") ? true
				: false;
	}

	public boolean isDERIVATIVE_COMPRESS_GZIPCRC___() {
		return notifyFeatureRead(DERIVATIVE_COMPRESS_GZIPCRC___).equals("1") ? true
				: false;
	}

	public boolean isDERIVATIVE_EXTRACT_CRC___() {
		return notifyFeatureRead(DERIVATIVE_EXTRACT_CRC___).equals("1") ? true
				: false;
	}

	public boolean isDERIVATIVE_GZIPCRC___() {
		return notifyFeatureRead(DERIVATIVE_GZIPCRC___).equals("1") ? true
				: false;
	}

	public void setBASE___(boolean v) {
		state.put(BASE___, (v ? "1" : "0"));
	}

	public void setEXTRACT___(boolean v) {
		state.put(EXTRACT___, (v ? "1" : "0"));
	}

	public void setARCHIVECHECK___(boolean v) {
		state.put(ARCHIVECHECK___, (v ? "1" : "0"));
	}

	public void setGZIP___(boolean v) {
		state.put(GZIP___, (v ? "1" : "0"));
	}

	public void setCRC___(boolean v) {
		state.put(CRC___, (v ? "1" : "0"));
	}

	public void setCOMPRESS___(boolean v) {
		state.put(COMPRESS___, (v ? "1" : "0"));
	}

	public void setADLER32CHECKSUM___(boolean v) {
		state.put(ADLER32CHECKSUM___, (v ? "1" : "0"));
	}

	public void setDERIVATIVE_COMPRESS_ADLER32CHECKSUM___(boolean v) {
		state.put(DERIVATIVE_COMPRESS_ADLER32CHECKSUM___, (v ? "1" : "0"));
	}

	public void setDERIVATIVE_COMPRESS_CRC___(boolean v) {
		state.put(DERIVATIVE_COMPRESS_CRC___, (v ? "1" : "0"));
	}

	public void setDERIVATIVE_COMPRESS_GZIP___(boolean v) {
		state.put(DERIVATIVE_COMPRESS_GZIP___, (v ? "1" : "0"));
	}

	public void setDERIVATIVE_COMPRESS_GZIPCRC___(boolean v) {
		state.put(DERIVATIVE_COMPRESS_GZIPCRC___, (v ? "1" : "0"));
	}

	public void setDERIVATIVE_EXTRACT_CRC___(boolean v) {
		state.put(DERIVATIVE_EXTRACT_CRC___, (v ? "1" : "0"));
	}

	public void setDERIVATIVE_GZIPCRC___(boolean v) {
		state.put(DERIVATIVE_GZIPCRC___, (v ? "1" : "0"));
	}

	/******************/

	@Override
	public void restore() {
		state.clear();
		init();
	}

	@Override
	public String getSPLName() {
		return "zipme";
	}

}
