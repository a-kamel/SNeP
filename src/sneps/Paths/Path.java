/**
 * @className Path.java
 * 
 * @ClassDescription A path in SNePS is a sequence of n-arcs 
 * 	with some constraints on the arcs included in the path and
 * 	on the way they are connected to form the path. This class
 * 	is an abstract class and it is the super class of all other 
 * 	types of paths.
 * 
 * @author Nourhan Zakaria
 * @version 2.00 18/6/2014
 */
package sneps.Paths;

import java.util.LinkedList;

import sneps.Network;
import sneps.PathTrace;
import sneps.Relation;
import sneps.Nodes.Node;
import snip.CompilationTuple;
import snip.Flag;
import snip.InferenceTuple;
import SNeBR.Context;

public abstract class Path {

	private LinkedList<CompilationTuple> compilationTuples;

	/**
	 * This method follows the current path starting at the given node in the
	 * given context and adds the paths followed along with their supports to
	 * the given path trace.
	 * 
	 * @param node
	 *            the node that the current path will be followed starting at
	 *            it.
	 * 
	 * @param trace
	 *            the path trace representing the trace of following the current
	 *            path.
	 * 
	 * @param context
	 *            the context that the propositions in this path is asserted in.
	 * 
	 * @return a linked list of objects' arrays. Each object array is a pair
	 *         that contains a node resulted from following the path along with
	 *         the path trace that was followed till reaching this node.
	 */
	public abstract LinkedList<Object[]> follow(Node node, PathTrace trace,
			Context context);

	/**
	 * This method follows the converse of current path starting at the given
	 * node in the given context and adds the paths followed along with their
	 * supports to the given path trace.
	 * 
	 * @param node
	 *            the node that the converse of the current path will be
	 *            followed starting at it.
	 * 
	 * @param trace
	 *            the path trace representing the trace of following the
	 *            converse of the current path.
	 * 
	 * @param context
	 *            the context that the propositions in this path is asserted in.
	 * 
	 * @return a linked list of objects' arrays. Each object array is a pair
	 *         that contains a node resulted from following the converse of the
	 *         path along with the path trace that was followed till reaching
	 *         this node.
	 */
	public abstract LinkedList<Object[]> followConverse(Node node,
			PathTrace trace, Context context);

	/**
	 * This method overrides the clone method inherited from the Object class.
	 */
	@Override
	public abstract Path clone();

	/**
	 * This method overrides the equals method inherited from the Object class.
	 */
	@Override
	public abstract boolean equals(Object obj);

	/**
	 * This method is used to get the converse of the current path.
	 * 
	 * @return a path representing the converse of the current path.
	 */
	public abstract Path converse();

	public abstract LinkedList<Relation> firstRelations();

	public abstract LinkedList<CompilationTuple> compile();

	public LinkedList<CompilationTuple> getCompilationTuples() {
		return compilationTuples;
	}

	public void setCompilationTuples(
			LinkedList<CompilationTuple> compilationTuples) {
		this.compilationTuples = compilationTuples;
	}

	public ComposePath compose(Path p, LinkedList<Path> l) {

		LinkedList<Path> l1 = new LinkedList<Path>();
		l1.add(p);
		for (int i = 0; i < l.size(); i++) {
			l1.add(l.get(i));

		}
		ComposePath cp = new ComposePath(l1);
		return cp;

	}

	public LinkedList<Path> difference(LinkedList<Path> l1, LinkedList<Path> l2) {
		LinkedList<Path> l3 = new LinkedList<Path>();
		for (int i = 0; i < l1.size(); i++) {
			Path p = l1.get(i);
			if (!l2.contains(p)) {
				l3.add(p);
			}
		}
		for (int j = 0; j < l2.size(); j++) {
			Path p1 = l2.get(j);
			if (!l1.contains(p1)) {
				l3.add(p1);
			}
		}
		return l3;
	}

	public void MakeInferenceTuples(Relation relation) {
		LinkedList<CompilationTuple> cts = this.compile();
		for (int i = 0; i < cts.size(); i++) {
			while (cts.get(i) != null) {
				CompilationTuple ct = cts.get(i);
				InferenceTuple it = new InferenceTuple(relation);
				it.getPheads().add(ct.getPhead());
				it.getPtails().add(ct.getPtail());
				it.getFlags().add(new Flag(ct.isFlag()));
				for (int j = i + 1; j < cts.size(); j++) {
					if (cts.get(j).getRelation() == ct.getRelation()) {
						it.getPheads().add(cts.get(j).getPhead());
						it.getPtails().add(cts.get(j).getPtail());
						it.getFlags().add(new Flag(cts.get(j).isFlag()));
						cts.remove(j);
					}
				}
				// 3amla moshkela>>>
				Network.getRelations().get(ct.getRelation())
						.addInferenceTuple(it);
				cts.remove(i);
			}
		}

	}
}
