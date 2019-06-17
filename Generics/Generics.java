
public class Generics<T> implements Comparable<Generics>{
	
	private T t;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Generics<Integer> b1 = new Generics<Integer>();
		Generics<String> b2 = new Generics<String>();
		
		b1.t=11;
		b2.t="11";
		if(b1.compareTo(b2)==0)
			System.out.println("The objects are not the same");
		else
			System.out.println("The objects are the same");
	}

	@Override
	public int compareTo(Generics o) {
		// TODO Auto-generated method stub
		if(o==t)
			return 1;
		return 0;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((t == null) ? 0 : t.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Generics other = (Generics) obj;
		if (t == null) {
			if (other.t != null)
				return false;
		} else if (!t.equals(other.t))
			return false;
		return true;
	}
}
