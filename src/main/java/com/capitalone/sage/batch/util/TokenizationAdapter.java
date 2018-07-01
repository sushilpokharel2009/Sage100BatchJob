// package com.capitalone.sage.batch.util;
//
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
//
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import javax.inject.Inject;
// import javax.inject.Named;
//
// import org.apache.commons.lang.StringUtils;
//
// import com.capitalone.sage.batch.bean.ReconDTO;
//
//
//
//// import
// com.capitalone.chassis.engine.model.exception.SystemNotAvilableException;
//// import com.capitalone.fsgarage.turingclient.service.v3.TuringService;
//// import com.capitalone.fsgarage.turingclient.service.v3.model.TuringElement;
//// import com.capitalone.fsgarage.turingclient.service.v3.model.TuringElement;
//
//
// @Named
// public class TokenizationAdapter {
//
// private final Logger logger =
// LoggerFactory.getLogger(TokenizationAdapter.class);
// private static final int mimimumTuringLength = 9;
// private static final char paddingCharacter = '0';
//
// @Inject
// private TuringService turingService;
//
// public List<ReconDTO>
// populatePaymentAccountsWithTokenizedAccountNumbers(List<ReconDTO>
// paymentAccounts){
//
// List<TuringElement> banTokensList = new ArrayList<TuringElement>();
// TuringElementBuilder turingElementBuilder = new TuringElementBuilder();
// List<TuringElement> tokenizedBans = null;
// List<ReconDTO> updatedPaymentAccounts = new ArrayList<ReconDTO>();
//
//// creating the list of Turing Elements
//
// for(ReconDTO paymentAccountEntity : paymentAccounts) {
// try {
// if(StringUtils.isNumeric(paymentAccountEntity.getBankAccountNumber()))
// banTokensList.add(turingElementBuilder.createBanWithAbaForTokenize(paymentAccountEntity.getBankAccountNumber(),
// StringUtils.leftPad(paymentAccountEntity.getAbaNumber(), minimumTuringLength,
// paddingCharacter), paymentAccountEntity.getPmtAcctUnqId().toString()));
// }catch(Exception e) {
// logger.info("Unable to tokenize the values ::"+e.getMessage());
// }
// }
//
//// Actual BAN Tokenization call
// try {
// tokenizedBans = turingService.tokenize(BAN, banTokensList);
//
// }catch(Exception e) {
// logger.error("Tokenization call falied: " +e);
// throw new SystemNotAvilableException("Bank Account Number Tokenization call
// falied"+ e);
// }
//
// Map<String, String> map = new HashMap<String, String>();
// tokenizedBans.forEach(turingElement -> {
// if(StringUtils.isNumeric(turingElement.getValue()) ||
// turingElement.hasError()) {
// logger.warn("Bank Account Number Tokenization Failed. Tokenized Account
// Number is Bllank for Payment Reference Id:" + turingElement.getId());
// }else {
// map.put(turingElement.getId(), turingElement.getValue());
// }
// });
//
// paymentAccounts.forEach(paymentAccountEntity -> {
// String tokenizedBankAccountNumber =
// paymentAccountEntity.getPmtAcctUnqId().toString();
//
// if (map.containsKey(tokenizedBankAccountNumber)) {
// paymentAccountEntity.setBankAccountNumberTokenized(map.get(tokenizedBankAccountNumber));
// updatedPaymentAccounts.add(paymentAccountEntity);
// }else {
// logger.warn("Skipping the record while updating pams as invalid data is found
// in the record with paymentAccountUniqueId ["+
// paymentAccountEntity.getPmtAcctUnqId()+"].");
// }
// });
//
// return updatedPaymentAccounts;
// }
//
// }
