package com.petclinic.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import com.petclinic.model.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

	protected Map<Long, T> map = new HashMap<>();

	public Set<T> findAll() {
		return new HashSet<>(map.values());
	}

	public T findById(ID id) {
		return map.get(id);
	}

	  public T save(T t) { 
		  if(t != null) {
			  if( t.getId() ==null) {
				  t.setId(getNextId());
			  }
			  map.put(t.getId(), t); 
		  }else {
			  throw new RuntimeException("Object cannot be null");
		  }
		  
		  return t;
		  
	  }
	 
	
	public void deleteByID(ID id) {
		map.remove(id);
	}
	
	void delete(T object) {
		map.entrySet().removeIf(s -> s.getValue().equals(object) );
	}

	private Long getNextId() {
		Long nextId= null;
		try {
			nextId = Collections.max(map.keySet()) + 1;
			
		}catch (NoSuchElementException e) {
			nextId =1L;
		}
		return nextId;
	}
	
}
