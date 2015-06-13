package com.barclays.utils;

import java.lang.reflect.Array;

public class HashCodeUtil {

	private static final int PRIME_ODD = 37;
	public static final int SEED = 23;

	private static int firstTerm(int seed) {
		return PRIME_ODD * seed;
	}

	public static int hash(int seed, boolean aBoolean) {
		return firstTerm(seed) + (aBoolean ? 1 : 0);
	}

	public static int hash(int seed, char aChar) {
		return firstTerm(seed) + (int) aChar;
	}

	public static int hash(int seed, int aInt) {
		return firstTerm(seed) + aInt;
	}

	public static int hash(int seed, long aLong) {
		return firstTerm(seed) + (int) (aLong ^ (aLong >>> 32));
	}

	public static int hash(int seed, float aFloat) {
		return hash(seed, Float.floatToIntBits(aFloat));
	}

	public static int hash(int seed, double aDouble) {
		return hash(seed, Double.doubleToLongBits(aDouble));
	}

	public static int hash(int seed, Object aObject) {
		int result = seed;
		if (aObject == null) {
			result = hash(result, 0);
		} else if (!isArray(aObject)) {
			result = hash(result, aObject.hashCode());
		} else {
			int length = Array.getLength(aObject);
			for (int idx = 0; idx < length; ++idx) {
				Object item = Array.get(aObject, idx);
				if (!(item == aObject))
					result = hash(result, item);
			}
		}
		return result;
	}

	private static boolean isArray(Object aObject) {
		return aObject.getClass().isArray();
	}

}
