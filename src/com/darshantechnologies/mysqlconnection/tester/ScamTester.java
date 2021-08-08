package com.darshantechnologies.mysqlconnection.tester;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ScamTester {

	public static void main(String[] args) {
		String username = "root";
		String password = "7892441472hp";
		String url = "jdbc:mysql://localhost:3306/transformers";
		String fqnOfDriverImpl = "com.mysql.cj.jdbc.Driver";

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			Statement statement = connection.createStatement();
		/*	String query1 = "INSERT INTO scam VALUES(1,'Indian Coal Allocation Scam', 'Coal', 2012, 'Manmohan Singh government', '1.86Lakh crore', 'India', 'Indian Governments allocation of nations coal deposit to PSUs and private companies')";
			String query2 = "INSERT INTO scam VALUES(2,'Indian stock market Scam', 'Market manipulation', 1992, 'Harshad Mehta', '1 billion', 'India', 'Mehta was accused of signing fake cheques, and committed a fraud to buy stocks on the Bombay Stock Exchange')";
			String query3 = "INSERT INTO scam VALUES(3,'Social Media Scam', 'Online store', 2020, 'Shoppie', '117 million', 'India', 'The Shoppie is a very high suspicious website which do not respond after taking orders')";
			String query4 = "INSERT INTO scam VALUES(4,'fake TRP Scam', 'Manipulation Of TRP', 2021, 'Dasgupta','', 'Maharastra', 'The manipulations done by bribing some to watch it, resulted in showing Republic TV as a top ranked TV channel')";
			String query5 = "INSERT INTO scam VALUES(5,'Aavin Milk Scam', '10 year adultration of Milk', 2014, 'Baibyan nadhan', '23 lakh per day', 'Tindivanam', '10 year adultration of milk supplied from societies of tamilnadu milk union')";
			String query6 = "INSERT INTO scam VALUES(6,'Vijay Mallya Scam', 'loan laundering from banks', 2016, 'Vijay Malya', '9000crore', 'India', 'He allegedly owes various banks over 9000crore which he had taken has a loan')";
			String query7 = "INSERT INTO scam VALUES(7,'2G spectrum Scam', 'undercharged mobile tele-companies', 2008, 'former telecom minister A.Raja', '1.76Trillion', 'India', 'It was alleged that they had undercharged mobile telephone companies for frequency allocation licenses that were used to create 2G spectrum subscriptions')";
			String query8 = "INSERT INTO scam VALUES(8,'CommonWealth Games Scam', 'Cheating and forgery', 2010, 'Suresh Kalmadi', '70,000crore', 'India', 'He was accused of corruption and malpractices in the common wealth games')";
			String query9 = "INSERT INTO scam VALUES(9,'Satyam Scam', 'Corporate Scam', 2019, 'B Ramalingaraju and  S.Satyam computer services limited', '14,000crore', 'India', 'The company manipulated and falsified their accounts of over Rs.14000 crore')";
			String query10 = "INSERT INTO scam VALUES(10,'Hawala Scam', 'Bribery', 1990, 'Hawala brothers', '18 million', 'India', 'It was found that the payment of supposed black money were done by politicians like LK Advani, Arjun Singh, Yeshwant Sinha, and Madan Lal khurana through the Hawala brothers')";
			String query11 = "INSERT INTO scam VALUES(11,'Abishek Verma Arm deals Scam', 'Scorpene submarines deal case scandal', 2006, 'Abishek Verma', '200 Million', 'India', 'He was accused of receiving bribe of approx 200million through a 4-5 Billion Indian Military deal involving the Indian Governments purchase of 6 Scorpene-class submarines')";
			String query12 = "INSERT INTO scam VALUES(12,'Wakf Board land Scam', 'land scam', 2012, 'Real Estate Mafia', '2000 billion', 'Karnataka', 'Over 50% of land has been embezzled or allocated illegally by politicians and board members under the watch of Karnataka Warf Board')";
			String query13 = "INSERT INTO scam VALUES(13,'Amaravati Project Scam', 'land scam', 2019, 'Chandrababu Naidu', '20,000 crore', 'Amaravati', 'CM naidu and some companies brought land and acuired 60% of land in the proposed capital city')";
			String query14 = "INSERT INTO scam VALUES(14,'PM-Kisan Scam', 'Fund scheme scam', 2012, 'Govt officials and hackers', '110crore', 'Tamilnadu', '5,00,000 fake beneficiaries have got Rs 110 crore from PM-Kisan Nidhi Scheme')";
			String query15 = "INSERT INTO scam VALUES(15,'The Granite Scam', 'Corruption scandal', 2012, 'P.R. Palanisamy and Panneer Mohamed', '16,000 crore', 'madurai', '84 private quarries had violated license conditions and taken part in illegal mining')";
			String query16 = "INSERT INTO scam VALUES(16,'2013 Chopper Scam', 'bribal scam', 2013, 'Finmeccanica CEO Giuseppe Orsi', '3600crore', 'India', 'bribes allegedly paid to secure the sale of 12 AgustaWestland AW101 helicopters to india')";
			String query17 = "INSERT INTO scam VALUES(17,'CommonWealth Games Scam', 'Cheating and forgery', 2010, 'Suresh Kalmadi', '70,000crore', 'India', 'He was accused of corruption and malpractices in the common wealth games')";
			String query18 = "INSERT INTO scam VALUES(18,'Social Media Scam', 'Online store', 2020, 'Shoppie', '117 million', 'India', 'The Shoppie is a very high suspicious website which dont respond after taking orders')";
			*///String query19 = "INSERT INTO scam VALUES(19,'Saradha Group Fund scam','Financial',2013,'Saradha Group company','2500crore','Kolkata','he money was collected through a wide network of agents, who were paid commissions of over 25 per cent.Variety of collective investment schemes')";
			String query20 = "INSERT INTO scam VALUES(20,'Bellary mining scam','Mining leases',2011,'Reddy brothers','2000 crore','Bellary','Reddy brothers paid huge money for their mining company named Obulapuram mining Company. It involes  forest areas and Mining in a Larger area than permitted')";
		/*	statement.execute(query1);
			statement.execute(query2);
			statement.execute(query3);
			statement.execute(query4);
			statement.execute(query5);
			statement.execute(query6);
			statement.execute(query7);
			statement.execute(query8);
			statement.execute(query9);
			statement.execute(query10);
			statement.execute(query11);
			statement.execute(query12);
			statement.execute(query13);
			statement.execute(query14);
			statement.execute(query15);
			statement.execute(query16);
			statement.execute(query17);
			statement.execute(query18);
			statement.execute(query19);
		*/statement.execute(query20);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
