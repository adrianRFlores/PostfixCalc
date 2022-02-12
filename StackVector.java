import java.util.Vector;

/**
 * @author Adrian Flores
 *
 */
class StackVector<T> implements IStack<T>{
	//Prueba para realizar un stack con Vector aunque sea más lento que ArrayList :)

	private Vector<T> coreList;
	
	public StackVector() {
		coreList = new Vector<T>();
	}
	
	@Override
	public void push(T value) {		
		coreList.addElement(value);
	}

	@Override
	public T pull() {
		return coreList.remove(coreList.size()-1);
	}

	@Override
	public T peek() {
		return coreList.get(coreList.size()-1);
	}

	@Override
	public int count() {
		return coreList.size();
	}

	@Override
	public boolean isEmpty() {		
		return coreList.isEmpty();
	}
}