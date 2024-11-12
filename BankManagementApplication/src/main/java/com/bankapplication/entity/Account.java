package com.bankapplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Account {
		@Id
		@GeneratedValue
		private Long account_number;
		
		private String customer_name;
		
		private Double account_balance;
        
		public Account() {
			
		}
		
		public Account(String customer_name, Double account_balance) {
			super();
			this.customer_name = customer_name;
			this.account_balance = account_balance;
		}
		public Long getAccount_number() {
			return account_number;
		}
		public void setAccount_number(Long account_number) {
			this.account_number = account_number;
		}
		public String getCustomer_name() {
			return customer_name;
		}
		public void setCustomer_name(String customer_name) {
			this.customer_name = customer_name;
		}
		public Double getAccount_balance() {
			return account_balance;
		}
		public void setAccount_balance(Double account_balance) {
			this.account_balance = account_balance;
		}
		@Override
		public String toString() {
			return "Account [account_number=" + account_number + ", customer_name=" + customer_name
					+ ", account_balance=" + account_balance + "]";
		}
		
}
