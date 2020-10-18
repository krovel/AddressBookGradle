package com.cg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.StreamSupport;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.*;


public class AddressBookIO {

	public static String Contact_FILE_NAME = "Contactfile.txt";
	public static String Contact_SECOND_FILE_NAME = "Contactfile2.txt";
	
	public static final String SAMPLE_CSV_FILE_PATH = "./fileread.csv";
	public static final String SAMPLE_CSV_FILE_PATH2 = "./filewrite.csv";

	public static final String SAMPLE_JSON_FILE_PATH = "./file1.json";
	public static final String SAMPLE_JSON_FILE_PATH2 = "./file2.json";
	public List<Contact> readData() {
		List<Contact> ContactsList = new ArrayList<>();
		try {
			Files.lines(new File(Contact_FILE_NAME).toPath()).map(line -> line.trim()).forEach(line -> {
				String[] words = line.split("[\\s,:]+");

				Contact Contact = new Contact();
				Contact.setFirstName(words[1]);
				Contact.setLastName(words[3]);
				Contact.setAddress(words[5]);
				Contact.setCity(words[7]);
				Contact.setState(words[9]);
				Contact.setZip(words[11]);
				Contact.setPhoneNo(words[13]);
				Contact.setEmail(words[15]);

				ContactsList.add(Contact);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ContactsList;
	}

	public void writeData(List<Contact> ContactList) {
		StringBuffer empBuffer = new StringBuffer();
		ContactList.forEach(Contact -> {
			String employeeDataString = Contact.toString().concat("\n");
			empBuffer.append(employeeDataString);
		});
		try {
			Files.write(Paths.get(Contact_SECOND_FILE_NAME), empBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public long countEntries() {
		long entries = 0;
		try {
			entries = Files.lines(new File(Contact_SECOND_FILE_NAME).toPath()).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entries;
	}
	@SuppressWarnings("unchecked")
	public List<Contact> readCSVData() {
		List<Contact> ContactList = new ArrayList<>();
		try {
			Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
			CsvToBean<Contact> csvToBean = new CsvToBeanBuilder<Contact>(reader).withType(Contact.class)
					.withIgnoreLeadingWhiteSpace(true).build();

			ContactList = csvToBean.parse();
			reader.close();
			return ContactList;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public boolean writeCSVData(List<Contact> contactList) {
		try (Writer writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE_PATH2))){
			StatefulBeanToCsv<Contact> beanToCsv = new StatefulBeanToCsvBuilder<Contact>(writer)
					.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();

			beanToCsv.write(contactList);
		} catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException | IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean writeJsonData(List<Contact> contactList) {
		Gson gson = new Gson();
		String json = gson.toJson(contactList);
		try {
			FileWriter fileWriter = new FileWriter(SAMPLE_JSON_FILE_PATH);
			fileWriter.write(json);
			fileWriter.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean readJsonFile(){
		try {
			Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_JSON_FILE_PATH2));
			JsonParser jsonParser = new JsonParser();
			JsonElement obj = jsonParser.parse(reader);
			JsonArray contactList = (JsonArray) obj;
			System.out.println(contactList);

			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}