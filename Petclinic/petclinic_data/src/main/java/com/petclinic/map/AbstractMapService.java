package com.petclinic.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T, ID> {

	protected Map<ID, T> map = new HashMap<>();

	public Set<T> findAll() {
		return new HashSet<>(map.values());
	}

	public T findById(ID id) {
		return map.get(id);
	}

	  public T save(T t, ID id) { map.put(id, t); return t; }
	 
	
	public void deleteByID(ID id) {
		map.remove(id);
	}
	
	void delete(T object) {
		map.entrySet().removeIf(s -> s.getValue().equals(object) );
	}

	
}
