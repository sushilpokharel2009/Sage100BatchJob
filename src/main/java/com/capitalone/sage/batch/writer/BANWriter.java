package com.capitalone.sage.batch.writer;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;

import org.springframework.batch.item.ItemWriter;

import com.capitalone.sage.batch.bean.PaymentAccount;
import com.capitalone.sage.batch.dao.InsertTokenizedRecordsDao;

public class BANWriter implements ItemWriter<List<PaymentAccount>> {

	final Logger logger = LoggerFactory.getLogger(BANWriter.class);

	@Inject
	InsertTokenizedRecordsDao paymentAccountDao;

	// @Override
	public void write(List<? extends List<PaymentAccount>> items) throws Exception {

		List<PaymentAccount> paymentAccountsListToBeUpdated = new ArrayList<>();
		for (int i = 0; i < items.size(); i++) {
			paymentAccountsListToBeUpdated.addAll(items.get(i));
		}
		try {
			paymentAccountDao.insertRecord(paymentAccountsListToBeUpdated);
		} catch (Exception e) {
			logger.info("Error occured while inserting the record to DB" + e);
		}
	}
}
