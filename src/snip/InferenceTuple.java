package snip;

import java.util.ArrayList;

import sneps.Relation;
import sneps.Paths.Path;

public class InferenceTuple {

	private Relation relation;

	private ArrayList<Path> ptails = new ArrayList<Path>();

	private ArrayList<Path> pheads = new ArrayList<Path>();

	private ArrayList<Flag> flags;

	public InferenceTuple(Relation R, ArrayList<Path> p1, ArrayList<Path> p2,
			ArrayList<Flag> f) {

		this.setRelation(R);
		this.setPheads(p1);
		this.setPtails(p2);
		this.setFlags(f);

	}

	public InferenceTuple(Relation R) {
		this.setRelation(R);
		ArrayList<Path> p1 = new ArrayList<Path>();
		this.setPheads(p1);
		ArrayList<Path> p2 = new ArrayList<Path>();
		this.setPtails(p2);
		ArrayList<Flag> f = new ArrayList<Flag>();
		this.setFlags(f);

	}

	public Relation getRelation() {
		return relation;
	}

	private void setRelation(Relation relation) {
		this.relation = relation;
	}

	public ArrayList<Path> getPtails() {
		return ptails;
	}

	private void setPtails(ArrayList<Path> ptails) {
		this.ptails = ptails;
	}

	public ArrayList<Path> getPheads() {
		return pheads;
	}

	private void setPheads(ArrayList<Path> pheads) {
		this.pheads = pheads;
	}

	public ArrayList<Flag> getFlags() {
		return flags;
	}

	private void setFlags(ArrayList<Flag> flags) {
		this.flags = flags;
	}

}
