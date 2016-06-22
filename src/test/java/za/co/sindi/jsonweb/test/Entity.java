/**
 * 
 */
package za.co.sindi.jsonweb.test;

import java.io.Serializable;

/**
 * @author buhake.sindi
 * @since 2016/05/06
 *
 */
public class Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4170464565466064924L;
	
	private int i1;
	private int i2;
	/**
	 * @return the i1
	 */
	public int getI1() {
		return i1;
	}
	/**
	 * @param i1 the i1 to set
	 */
	public void setI1(int i1) {
		this.i1 = i1;
	}
	/**
	 * @return the i2
	 */
	public int getI2() {
		return i2;
	}
	/**
	 * @param i2 the i2 to set
	 */
	public void setI2(int i2) {
		this.i2 = i2;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i1;
		result = prime * result + i2;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity other = (Entity) obj;
		if (i1 != other.i1)
			return false;
		if (i2 != other.i2)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Entity [i1=" + i1 + ", i2=" + i2 + "]";
	}
	
	public static Entity test(Entity entity) {
		entity.setI1(10);
		entity.setI2(20);
		
		return entity;
	}
	
	public static void main(String[] args) {
		Entity entity = new Entity();
		entity.setI1(1);
		entity.setI2(2);
		
		System.out.println(entity);
		System.out.println(test(entity));
	}
}
