package com.mj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Helper {

	public static String callService(String link, String object) throws Exception {
		String result = "";
		try {
			URL url = new URL(link);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String input = object;

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
			// System.out.println(input);
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output = br.readLine();
			// System.out.println("Output from Server .... \n");
			// System.out.println(output);
			result = output;
			// System.out.println(result);
			conn.disconnect();

		} catch (MalformedURLException e) {

			throw new Exception(e);

		} catch (IOException e) {

			throw new Exception(e);

		}
		return result;
	}

	public static String getCurrentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDate localDate = LocalDate.now();
		String result = dtf.format(localDate).toUpperCase();
		return result;
	}

}