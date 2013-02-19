package data;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the termine database table.
 * 
 */
@Entity
@Table(name="termine")
public class Termin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="t_id")
	private int tId;

	@Column(name="t_bis")
	private Timestamp tBis;

	@Column(name="t_text")
	private String tText;

	@Column(name="t_von")
	private Timestamp tVon;

	//bi-directional many-to-one association to Kalender
	@ManyToOne
	@JoinColumn(name="fk_k_id")
	private Kalender kalender;

	public Termin() {
	}

	public int getTId() {
		return this.tId;
	}

	public void setTId(int tId) {
		this.tId = tId;
	}

	public Timestamp getTBis() {
		return this.tBis;
	}

	public void setTBis(Timestamp tBis) {
		this.tBis = tBis;
	}

	public String getTText() {
		return this.tText;
	}

	public void setTText(String tText) {
		this.tText = tText;
	}

	public Timestamp getTVon() {
		return this.tVon;
	}

	public void setTVon(Timestamp tVon) {
		this.tVon = tVon;
	}

	public Kalender getKalender() {
		return this.kalender;
	}

	public void setKalender(Kalender kalender) {
		this.kalender = kalender;
	}

}