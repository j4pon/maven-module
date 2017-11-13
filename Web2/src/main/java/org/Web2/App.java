package org.Web2;

import java.util.List;

import org.otros.ConnectUno;
import org.otros.Cursor;

public class App {

	private static List<Cursor> listCursor = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		ConnectUno app = new ConnectUno();
		listCursor = app.getTest();
		System.out.println(listCursor.size());		
	}

}
