import java.lang.reflect.Array;

//question 1
public class GenericStack<E> {

	private E[] list;
	private int array_size = 10;
	private Class<E> generic_type;

	public GenericStack(Class<E> t) {
		generic_type = t;
		list = (E[]) Array.newInstance(generic_type, array_size);
	}

	public GenericStack(Class<E> t, int s) {
		array_size = s;
		generic_type = t;
		list = (E[]) Array.newInstance(generic_type, array_size);
	}

	public int getSize() {
		return list.length;
	}

	public E peek() {
		return list[array_size - 1];
	}

	public void push(E o) {

		// copy array into one +1 size
		E[] prevArray = list;
		array_size += 1;
		list = (E[]) Array.newInstance(generic_type, array_size);

		for (int i = 0; i < array_size - 1; i++) {
			list[i] = prevArray[i];
		}

		list[array_size - 1] = o;

	}

	public E pop() {

		E o = list[array_size - 1];

		// copy array into one -1 size
		E[] prevArray = list;
		if (array_size > 0) {
			array_size -= 1;
		}
		list = (E[]) Array.newInstance(generic_type, array_size);

		for (int i = 0; i < array_size; i++) {
			list[i] = prevArray[i];
		}

		return o;
	}

	public boolean isEmpty() {
		return array_size == 0;
	}

	@Override
	public String toString() {
		return "stack: " + list.toString();
	}

}
