package com.capitalone.sage.batch.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
//import org.apache.commons.lang3.StringUtils;

import com.capitalone.sage.batch.bean.PaymentAccount;
import com.capitalone.sage.batch.bean.ReconDTO;
//import com.capitalone.sage.batch.util.TokenizationAdapter;

public class BANProcessor implements ItemProcessor<List<ReconDTO>, List<PaymentAccount>> {

	public static final Double TKNIZED_VERS = 3.0;
	public static final AtomicLong readCount = new AtomicLong(0);
	public static final AtomicLong processedCount = new AtomicLong(0);

	// @Inject
	// TokenizationAdapter tokenizationAdapter;

	// @Override
	public List<PaymentAccount> process(List<ReconDTO> reconDTOList) throws Exception {

		List<PaymentAccount> paymentAccounts = new ArrayList<>();

		if (reconDTOList != null && reconDTOList.isEmpty()) {
			return paymentAccounts;
		}

		// Get the list of tokenized Account Numbers. Uncomment for office purpose of
		// Tokenization

		// List<ReconDTO> reconDTOTokenizedList =
		// tokenizationAdapter.populatePaymentAccountsWithTokenizedAccountNumbers(reconDTOList);

		// Update the ReconDTO with tokenized values

		// if (null != reconDTOTokenizedList) {
		// readCount.getAndAdd(reconDTOTokenizedList.size());
		// reconDTOTokenizedList.forEach(reconDTO -> {
		// PaymentAccount paymentAccount = new PaymentAccount();
		// paymentAccount.setId(reconDTO.getId());
		// paymentAccount.setName(reconDTO.getName());
		// paymentAccount.setAbaNum(reconDTO.getAbaNumber());
		// paymentAccount.setBankAccountNumberTokenized(reconDTO.getBankAccountNumberTokenized());
		// paymentAccounts.add(paymentAccount);

		// Comment this code while doing tokenization because this is for testing
		// purpose in my personal computer
		if (null != reconDTOList) {
			readCount.getAndAdd(reconDTOList.size());
			reconDTOList.forEach(reconDTO -> {
				PaymentAccount paymentAccount = new PaymentAccount();
				paymentAccount.setId(reconDTO.getId());
				paymentAccount.setName(reconDTO.getName());
				paymentAccount.setAbaNum(reconDTO.getAbaNumber());
				paymentAccount.setBankAccountNumberTokenized(reconDTO.getBankAccountNumberTokenized());
				paymentAccounts.add(paymentAccount);

			});
		}

		processedCount.getAndAdd(paymentAccounts.size());
		return paymentAccounts;

	}
}
