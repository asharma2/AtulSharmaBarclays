package com.barclays.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.barclays.constants.Constants;
import com.barclays.exception.TimeConversionExeption;

public final class Utilities {

	private static DateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT);

	private Utilities() {
	}

	public static final Date getTime(String time) throws TimeConversionExeption {
		try {
			return format.parse(time);
		} catch (ParseException e) {
			throw new TimeConversionExeption(e);
		}
	}

}
