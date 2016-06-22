/**
 * 
 */
package za.co.sindi.jsonweb;

import java.util.Date;

import za.co.sindi.common.utils.PreConditions;

/**
 * @author Bienfait Sindi
 * @since 31 March 2016
 *
 */
public class NumericDate implements Value<Date, Long> {

	private Date date;
	
	/**
	 * @param date
	 */
	public NumericDate(Date date) {
		super();
		PreConditions.checkArgument(date != null, "A date is required, in UTC.");
		this.date = date;
	}
	
	/**
	 * @param date
	 */
	public NumericDate(long date) {
		super();
		this.date = new Date(date);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.Value#getActualValue()
	 */
	@Override
	public Date getActualValue() {
		// TODO Auto-generated method stub
		return date;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.Value#getJSONValue()
	 */
	@Override
	public Long getJSONValue() {
		// TODO Auto-generated method stub
		return date.getTime();
	}
}
