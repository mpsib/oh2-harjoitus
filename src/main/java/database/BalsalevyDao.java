package database;

import java.util.List;
import model.Balsalevy;

public interface BalsalevyDao {
	public List<Balsalevy> getAllItems();
	public Balsalevy getItem(long id);
	public boolean addItem(Balsalevy newItem);
	public boolean removeItem(Balsalevy item);
}