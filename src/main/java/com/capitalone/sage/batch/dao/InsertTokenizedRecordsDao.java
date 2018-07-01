package com.capitalone.sage.batch.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.ObjectError;

import com.capitalone.sage.batch.bean.PaymentAccount;

import com.capitalone.sage.batch.bean.PaymentAccount;

public class InsertTokenizedRecordsDao {
	public static final String CENTRAL_TIME_ZONE = "America/Chicago";
	final Logger logger = LoggerFactory.getLogger(InsertTokenizedRecordsDao.class);

	@Value("${sql.inserthsql}")
	public String insertQuery;

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Inject
	ObjectError objectMapper;

	public void insertRecord(List<PaymentAccount> records) {
		int[] updatedArray = null;
		try {
			updatedArray = jdbcTemplate.batchUpdate(insertQuery, new BatchPreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement PreparedStatement, int i) throws SQLException {

				}

				@Override
				public int getBatchSize() {
					return records.size();
				}
			});

			logger.info("Inserted Records count ::" + updatedArray.length);

		} catch (Exception e) {
			logger.error("Payment Account Insert Failed for :: " + e.getMessage());
		}
	}

	private void prepareAccountObject(PreparedStatement preparedStatement, int i, List<PaymentAccount> paymentAccounts)
			throws SQLException {
		PaymentAccount paymentAccount = paymentAccounts.get(i);
		preparedStatement.setInt(1, paymentAccount.getId());
		preparedStatement.setString(2, paymentAccount.getName());
		preparedStatement.setString(3, paymentAccount.getBankAccountNumberTokenized());
		preparedStatement.setString(4, paymentAccount.getAbaNum());
	}

}
