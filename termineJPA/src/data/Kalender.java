package data;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the kalender database table.
 * 
 */
@Entity
@Table(name="kalender")
public class Kalender implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="k_id")
	private int kId;

	@Column(name="k_name")
	private String kName;

	//bi-directional many-to-one association to Termine
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_k_id")
	private List<Termin> termine = new ArrayList<>();

	public Kalender() {
	}

	public int getKId() {
		return this.kId;
	}

	public void setKId(int kId) {
		this.kId = kId;
	}

	public String getKName() {
		return this.kName;
	}

	public void setKName(String kName) {
		this.kName = kName;
	}

	public List<Termin> getTermine() {
		return this.termine;
	}

	public void setTermine(List<Termin> termine) {
		this.termine = termine;
	}

}