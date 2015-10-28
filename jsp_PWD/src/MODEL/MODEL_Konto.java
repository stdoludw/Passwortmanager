package MODEL;

import CONTROLLER.CONTROLLER_Statments;

public class MODEL_Konto {

    public MODEL_Konto(int id, String mstrDienst, String mstrUsername, String mstrantworta, String mstrantwortb, String mstremail, String mstrerstellt, String mstrfragea, String mstrfrageb, String mstrgeanertam, String mstrkontakt, String mstrpasswort, String mstrresetemail, String mstrreseturl, String mstrwebseite) {
        this.mintID =id;
    	this.mstrDienst = mstrDienst;
        this.mstrUsername = mstrUsername;
        this.mstrantworta = mstrantworta;
        this.mstrantwortb = mstrantwortb;
        this.mstremail = mstremail;
        this.mstrerstellt = mstrerstellt;
        this.mstrfragea = mstrfragea;
        this.mstrfrageb = mstrfrageb;
        this.mstrgeanertam = mstrgeanertam;
        this.mstrkontakt = mstrkontakt;
        this.mstrpasswort = mstrpasswort;
        this.mstrresetemail = mstrresetemail;
        this.mstrreseturl = mstrreseturl;
        this.mstrwebseite = mstrwebseite;
    }

    public MODEL_Konto() {
		// TODO Auto-generated constructor stub
	}

    public int getMintID() {
		return mintID;
	}

	public void setMintID(int mintID) {
		this.mintID = mintID;
	}

	private int mintID;
	private String mstrDienst;
    private String mstrUsername;
    private String mstrantworta;
    private String mstrantwortb;
    private String mstremail;
    private String mstrerstellt;
    private String mstrfragea;
    private String mstrfrageb;
    private String mstrgeanertam;
    private String mstrkontakt;
    private String mstrpasswort;
    private String mstrresetemail;
    private String mstrreseturl;
    private String mstrwebseite;

    //verschluesseln
    public MODEL_Konto encode (AES_verschluesselung aes)
    {
         this.mstrDienst = aes.verschluesselnAES(mstrDienst);
        this.mstrUsername = aes.verschluesselnAES(mstrUsername);
        this.mstrantworta = aes.verschluesselnAES(mstrantworta);
        this.mstrantwortb = aes.verschluesselnAES(mstrantwortb);
        this.mstremail = aes.verschluesselnAES(mstremail);
        this.mstrerstellt = aes.verschluesselnAES(mstrerstellt);
        this.mstrfragea = aes.verschluesselnAES(mstrfragea);
        this.mstrfrageb = aes.verschluesselnAES(mstrfrageb);
        this.mstrgeanertam = aes.verschluesselnAES(mstrgeanertam);
        this.mstrkontakt = aes.verschluesselnAES(mstrkontakt);
        this.mstrpasswort = aes.verschluesselnAES(mstrpasswort);
        this.mstrresetemail = aes.verschluesselnAES(mstrresetemail);
        this.mstrreseturl = aes.verschluesselnAES(mstrreseturl);
        this.mstrwebseite = aes.verschluesselnAES(mstrwebseite);
        return this;
    }
    
    //entschluesseln
       public MODEL_Konto decode (AES_verschluesselung aes)
    {
         this.mstrDienst = aes.entschluesselnAES(mstrDienst);
        this.mstrUsername = aes.entschluesselnAES(mstrUsername);
        this.mstrantworta = aes.entschluesselnAES(mstrantworta);
        this.mstrantwortb = aes.entschluesselnAES(mstrantwortb);
        this.mstremail = aes.entschluesselnAES(mstremail);
        this.mstrerstellt = aes.entschluesselnAES(mstrerstellt);
        this.mstrfragea = aes.entschluesselnAES(mstrfragea);
        this.mstrfrageb = aes.entschluesselnAES(mstrfrageb);
        this.mstrgeanertam = aes.entschluesselnAES(mstrgeanertam);
        this.mstrkontakt = aes.entschluesselnAES(mstrkontakt);
        this.mstrpasswort = aes.entschluesselnAES(mstrpasswort);
        this.mstrresetemail = aes.entschluesselnAES(mstrresetemail);
        this.mstrreseturl = aes.entschluesselnAES(mstrreseturl);
        this.mstrwebseite = aes.entschluesselnAES(mstrwebseite);
        return this;
    }

    
    public String getMstrDienst() {
        return mstrDienst;
    }

    public void setMstrDienst(String mstrDienst) {
        this.mstrDienst = mstrDienst;
    }

    public String getMstrUsername() {
        return mstrUsername;
    }

    public void setMstrUsername(String mstrUsername) {
        this.mstrUsername = mstrUsername;
    }

    public String getMstrantworta() {
        return mstrantworta;
    }

    public void setMstrantworta(String mstrantworta) {
        this.mstrantworta = mstrantworta;
    }

    public String getMstrantwortb() {
        return mstrantwortb;
    }

    public void setMstrantwortb(String mstrantwortb) {
        this.mstrantwortb = mstrantwortb;
    }

    public String getMstremail() {
        return mstremail;
    }

    public void setMstremail(String mstremail) {
        this.mstremail = mstremail;
    }

    public String getMstrerstellt() {
        return mstrerstellt;
    }

    public void setMstrerstellt(String mstrerstellt) {
        this.mstrerstellt = mstrerstellt;
    }

    public String getMstrfragea() {
        return mstrfragea;
    }

    public void setMstrfragea(String mstrfragea) {
        this.mstrfragea = mstrfragea;
    }

    public String getMstrfrageb() {
        return mstrfrageb;
    }

    public void setMstrfrageb(String mstrfrageb) {
        this.mstrfrageb = mstrfrageb;
    }

    public String getMstrgeanertam() {
        return mstrgeanertam;
    }

    public void setMstrgeanertam(String mstrgeanertam) {
        this.mstrgeanertam = mstrgeanertam;
    }

    public String getMstrkontakt() {
        return mstrkontakt;
    }

    public void setMstrkontakt(String mstrkontakt) {
        this.mstrkontakt = mstrkontakt;
    }

    public String getMstrpasswort() {
        return mstrpasswort;
    }

    public void setMstrpasswort(String mstrpasswort) {
        this.mstrpasswort = mstrpasswort;
    }

    public String getMstrresetemail() {
        return mstrresetemail;
    }

    public void setMstrresetemail(String mstrresetemail) {
        this.mstrresetemail = mstrresetemail;
    }

    public String getMstrreseturl() {
        return mstrreseturl;
    }

    public void setMstrreseturl(String mstrreseturl) {
        this.mstrreseturl = mstrreseturl;
    }

    public String getMstrwebseite() {
        return mstrwebseite;
    }

    public void setMstrwebseite(String mstrwebseite) {
        this.mstrwebseite = mstrwebseite;
    }

	public String SQLdelete(int PK) {
		return CONTROLLER_Statments.DeleteKonto(PK);
	}

	public String SQLUpdate(AES_verschluesselung aes) {
		return CONTROLLER_Statments.UpdateKonto(mintID, mstrDienst, mstrUsername, mstrantworta, mstrantwortb, mstremail, mstrerstellt, mstrfragea, mstrfrageb, mstrgeanertam, mstrkontakt, mstrpasswort, mstrresetemail, mstrreseturl, mstrwebseite, aes);
	}

	public String SQLinsert(AES_verschluesselung aes) {
		
		return CONTROLLER_Statments.AddKonto(mstrDienst, mstrUsername, mstrantworta, mstrantwortb, mstremail, mstrerstellt, mstrfragea, mstrfrageb, mstrgeanertam, mstrkontakt, mstrpasswort, mstrresetemail, mstrreseturl, mstrwebseite, aes);
	}


}