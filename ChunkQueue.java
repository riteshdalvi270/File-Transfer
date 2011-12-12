import java.util.LinkedList;
import java.util.*;
public class ChunkQueue extends LinkedList{
	LinkedList<String> names = new LinkedList<String>();
	ArrayList listeners = new ArrayList<CQListener>();
	public ChunkQueue() {
		super();
	}
	public void addChunk(byte[] ba, String name) {
		add(ba);
		names.add(name);
		fireCQEvent();
	}
	public String pollName () {
		return names.poll();
	}
	public void addCQListener(CQListener cql) {
		this.listeners.add(cql);
	}
	public void fireCQEvent() {
		for (int i=0; i<listeners.size(); i++) {
			CQListener cql = (CQListener) listeners.get(i);
			cql.CQActionPerformed();
		}
	}
}