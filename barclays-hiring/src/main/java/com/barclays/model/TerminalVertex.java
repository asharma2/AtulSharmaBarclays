package com.barclays.model;

import com.barclays.utils.EqualUtils;
import com.barclays.utils.HashCodeUtil;

public class TerminalVertex {

	private final String id;
	private final String name;

	public TerminalVertex(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		int result = HashCodeUtil.SEED;
		result = HashCodeUtil.hash(result, id);
		result = HashCodeUtil.hash(result, name);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof TerminalVertex))
			return false;
		TerminalVertex that = (TerminalVertex) obj;
		return EqualUtils.areEqual(this.id, that.id) && EqualUtils.areEqual(this.name, that.name);
	}

	@Override
	public String toString() {
		return id;
	}
}
