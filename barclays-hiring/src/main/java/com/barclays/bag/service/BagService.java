package com.barclays.bag.service;

import com.barclays.exception.BagExeption;
import com.barclays.model.Bag;

public interface BagService {

	public void saveBag(Bag bag) throws BagExeption;

	public Bag findByBagNumber(String bagNumber) throws BagExeption;
}
