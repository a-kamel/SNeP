package snip;

import sneps.Relation;
import sneps.Paths.Path;

public class CompilationTuple {

	private Relation relation;

	private Path ptail;

	private Path phead;

	private boolean flag;

	public CompilationTuple(Relation r, Path p1, Path p2, boolean f) {

		this.setRelation(r);
		this.setFlag(f);
		this.setPhead(p1);
		this.setPtail(p2);

	}

	public Relation getRelation() {
		return relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}

	public Path getPtail() {
		return ptail;
	}

	public void setPtail(Path ptail) {
		this.ptail = ptail;
	}

	public Path getPhead() {
		return phead;
	}

	public void setPhead(Path phead) {
		this.phead = phead;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
