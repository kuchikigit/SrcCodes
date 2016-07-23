package net.brian.jdk.notes.tij.datastructure;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SlowSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, java.io.Serializable {
	private transient Map<E, Object> map = new SlowMap<E, Object>();
	private static final Object PRESENT = new Object();

	public boolean add(E e) {
		return map.put(e, PRESENT) == null;
	}

	public boolean contains(Object obj) {
		return map.containsKey(obj);
	}

	@Override
	public Iterator<E> iterator() {
		return map.keySet().iterator();
	}

	@Override
	public int size() {
		return map.size();
	}
}
