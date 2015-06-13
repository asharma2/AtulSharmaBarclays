package com.barclays.bag.service;

import java.util.LinkedHashMap;
import java.util.Map;

import com.barclays.exception.BagExeption;
import com.barclays.model.Bag;

public class BagServiceImpl implements BagService {

	private static final BagServiceImpl INSTANCE = new BagServiceImpl();
	private Map<String, Bag> bags = new LinkedHashMap<>();

	public static BagService getInstance() {
		return INSTANCE;
	}

	@Override
	public void saveBag(Bag bag) throws BagExeption {
		if (bag == null)
			throw new BagExeption("Bag instance cannot be null");
		bags.put(bag.getBagNumber(), bag);
	}

	@Override
	public Bag findByBagNumber(String bagNumber) throws BagExeption {
		Bag bag = bags.get(bagNumber);
		if (bag == null)
			throw new BagExeption("No bag found for bagNumber: " + bagNumber);
		return bag;
	}

}
