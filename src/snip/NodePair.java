package snip;

import sneps.Nodes.Node;




public class NodePair {

	private Node a1;
	private Node a2;
	
	public NodePair (Object[] x, Object[] y) {
		this.setA1((Node)(x[0]));
		this.setA2((Node)(y[0]));
	}
	public Node getA1() {
		return a1;
	}

	public void setA1(Node a1) {
		this.a1 = a1;
	}

	public Node getA2() {
		return a2;
	}

	public void setA2(Node a2) {
		this.a2 = a2;
	}

	
}
