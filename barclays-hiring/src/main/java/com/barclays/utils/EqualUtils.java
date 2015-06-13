package com.barclays.utils;

public final class EqualUtils {

	static public boolean areEqual(boolean _this, boolean _that) {
		return _this == _that;
	}

	static public boolean areEqual(char _this, char _that) {
		return _this == _that;
	}

	static public boolean areEqual(long _this, long _that) {
		return _this == _that;
	}

	static public boolean areEqual(float _this, float _that) {
		return Float.floatToIntBits(_this) == Float.floatToIntBits(_that);
	}

	static public boolean areEqual(double _this, double _that) {
		return Double.doubleToLongBits(_this) == Double.doubleToLongBits(_that);
	}

	static public boolean areEqual(Object _this, Object _that) {
		return _this == null ? _that == null : _this.equals(_that);
	}
}
