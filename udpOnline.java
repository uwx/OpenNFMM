/* udpOnline - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class udpOnline implements Runnable
{
    Thread con;
    UDPMistro um;
    int gameport = 7001;
    InetAddress IPAddress;
    DatagramSocket dSocket;
    long sendat = 0L;
    boolean started = false;
    boolean errd = false;
    int nu = 0;
    
    public udpOnline(UDPMistro udpmistro, String string, int i, int i_0_,
		     int i_1_) {
	this.um = udpmistro;
	this.gameport = i;
	this.nu = i_0_;
	try {
	    this.dSocket
		= new DatagramSocket(7010 + i_1_ + this.nu);
	    this.errd = false;
	    this.IPAddress = InetAddress.getByName(string);
	} catch (Exception exception) {
	    System.out.println(new StringBuilder().append
				   ("Error preparing for UDP Connection: ")
				   .append
				   (exception).toString());
	}
    }
    
    public void spark() {
	if (this.errd) {
	    try {
		this.dSocket
		    = new DatagramSocket(7020 + this.nu);
		this.errd = false;
	    } catch (Exception exception) {
		/* empty */
	    }
	}
	try {
	    this.con = new Thread(this);
	    this.con.start();
	} catch (Exception exception) {
	    /* empty */
	}
    }
    
    public void closeSocket() {
	try {
	    this.dSocket.close();
	} catch (Exception exception) {
	    /* empty */
	}
	this.dSocket = null;
	this.errd = true;
	if (this.con != null) {
	    this.con.stop();
	    this.con = null;
	}
	this.started = false;
    }
    
    public void stomp() {
	if (this.con != null) {
	    this.con.stop();
	    this.con = null;
	}
	this.started = false;
    }
    
    public void run() {
	this.started = true;
	Date date = new Date();
	this.sendat = date.getTime();
	String string = "";
	if (!(this.um).go)
	    string = "MAGNITUDE";
	if (this.nu == 0
	    && (this.um).diledelay == 0) {
	    (this.um).sendat
		= this.sendat;
	    string = new StringBuilder().append("").append
			 (this.sendat).toString();
	    string = string.substring(string.length() - 3, string.length());
	    (this.um).sendcheck = string;
	    (this.um).diledelay = 100;
	}
	try {
	    byte[] is = new byte[4];
	    DatagramPacket datagrampacket
		= new DatagramPacket(is, is.length,
				     this.IPAddress,
				     this.gameport);
	    String string_2_
		= new StringBuilder().append("").append(string).append("|")
		      .append
		      ((this.um).im).append
		      ("|").append
		      ((this.um).frame
		       [(this.um).im][0])
		      .append
		      ("|").append
		      ((this.um).info
		       [(this.um).im][0])
		      .append
		      ("|").toString();
	    byte[] is_3_ = string_2_.getBytes();
	    datagrampacket.setData(is_3_);
	    this.dSocket.send(datagrampacket);
	    for (int i = 0;
		 i < (this.um).nplayers - 1; i++) {
		this.dSocket.receive(datagrampacket);
		String string_4_ = new String(datagrampacket.getData());
		if ((this.nu == 0
		     || !(this.um).go)
		    && i == 0) {
		    string = getSvalue(string_4_, 0);
		    if (!(this.um).go
			&& string.equals("1111111"))
			(this.um).go = true;
		}
		int i_5_ = getvalue(string_4_, 1);
		if (i_5_ >= 0
		    && i_5_ < (this.um).nplayers) {
		    int i_6_ = getvalue(string_4_, 2);
		    int i_7_ = 0;
		    for (int i_8_ = 0; i_8_ < 3; i_8_++) {
			if (i_6_ != ((this.um).frame
				     [i_5_][i_8_]))
			    i_7_++;
		    }
		    if (i_7_ == 3) {
			for (int i_9_ = 0; i_9_ < 3; i_9_++) {
			    if (i_6_ > ((this.um)
					.frame[i_5_][i_9_])) {
				for (int i_10_ = 2; i_10_ >= i_9_ + 1;
				     i_10_--) {
				    (this.um)
					.frame[i_5_][i_10_]
					= ((this.um)
					   .frame[i_5_][i_10_ - 1]);
				    (this.um)
					.info[i_5_][i_10_]
					= ((this.um)
					   .info[i_5_][i_10_ - 1]);
				}
				(this.um).frame
				    [i_5_][i_9_]
				    = i_6_;
				(this.um).info
				    [i_5_][i_9_]
				    = getSvalue(string_4_, 3);
				i_9_ = 3;
			    }
			}
		    }
		}
	    }
	    if (this.nu == 0
		&& (this.um).diledelay != 0
		&& (this.um).sendcheck
		       .equals(string)) {
		date = new Date();
		for (int i = 4; i > 0; i--)
		    (this.um).ldelays[i]
			= (this.um).ldelays[i - 1];
		(this.um).ldelays[0]
		    = (int) (date.getTime()
			     - (this.um).sendat);
		(this.um).delay = 0;
		for (int i = 0; i < 5; i++) {
		    if ((this.um).ldelays[i] != 0
			&& ((this.um).delay == 0
			    || ((this.um).ldelays[i]
				< (this.um).delay)))
			(this.um).delay
			    = (this.um).ldelays[i];
		}
		(this.um).diledelay = 0;
		if ((this.um).diled != 10)
		    (this.um).diled++;
	    }
	} catch (Exception exception) {
	    try {
		this.dSocket.close();
	    } catch (Exception exception_11_) {
		/* empty */
	    }
	    this.dSocket = null;
	    this.errd = true;
	}
	this.started = false;
	this.con = null;
    }
    
    public int getvalue(String string, int i) {
	int i_12_ = -1;
	try {
	    int i_13_ = 0;
	    int i_14_ = 0;
	    int i_15_ = 0;
	    String string_16_ = "";
	    String string_17_ = "";
	    for (/**/; i_13_ < string.length() && i_15_ != 2; i_13_++) {
		string_16_ = new StringBuilder().append("").append
				 (string.charAt(i_13_)).toString();
		if (string_16_.equals("|")) {
		    i_14_++;
		    if (i_15_ == 1 || i_14_ > i)
			i_15_ = 2;
		} else if (i_14_ == i) {
		    string_17_ = new StringBuilder().append(string_17_).append
				     (string_16_).toString();
		    i_15_ = 1;
		}
	    }
	    if (string_17_.equals(""))
		string_17_ = "-1";
	    i_12_ = Integer.valueOf(string_17_).intValue();
	} catch (Exception exception) {
	    /* empty */
	}
	return i_12_;
    }
    
    public String getSvalue(String string, int i) {
	String string_18_ = "";
	try {
	    int i_19_ = 0;
	    int i_20_ = 0;
	    int i_21_ = 0;
	    String string_22_ = "";
	    String string_23_ = "";
	    for (/**/; i_19_ < string.length() && i_21_ != 2; i_19_++) {
		string_22_ = new StringBuilder().append("").append
				 (string.charAt(i_19_)).toString();
		if (string_22_.equals("|")) {
		    i_20_++;
		    if (i_21_ == 1 || i_20_ > i)
			i_21_ = 2;
		} else if (i_20_ == i) {
		    string_23_ = new StringBuilder().append(string_23_).append
				     (string_22_).toString();
		    i_21_ = 1;
		}
	    }
	    string_18_ = string_23_;
	} catch (Exception exception) {
	    /* empty */
	}
	return string_18_;
    }
}
