package persistence.impl;

import java.util.List;

public interface IDAOImpl<T> {
	public void insert(T classe);
	public void update(T classe);	
	public void delete(T classe);
	public T searchById(int id);
	public List<T> listarTodos();
}
