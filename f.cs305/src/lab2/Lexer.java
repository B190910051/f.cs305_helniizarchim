package lab2;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import lab3.MyStack;

public class Lexer extends MyStack {
	private char ch = ' ';
	private BufferedReader input;
	private String line = "";
	private int col = 1;
	private final String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	Hashtable<String, Integer> ht = new Hashtable<>();
	private final char eolnCh = '\n';
	private final char eofCh = '\004';
	static ArrayList<String> ar = new ArrayList<String>();

	public Lexer(String fileName) {
		try {
			ht.put("void", 0);
			ht.put("int", 0);
			ht.put("main", 1);
			ht.put("(", 2);
			ht.put(")", 3);
			ht.put("{", 4);
			ht.put("}", 5);

			input = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + fileName);
			System.exit(1);
		}
	}

	private char nextChar() {
		col++;
		if (col >= line.length()) {
			try {
				line = input.readLine();
			} catch (IOException e) {
				System.err.println(e);
				System.exit(1);
			}
			if (line == null)
				line = "" + eofCh;
			else {
				line += eolnCh;
			}
			col = 0;
		}
		return line.charAt(col);
	}

	public String next() {
		do {
			if (isLetter(ch)) {
				String spelling = concat(letters);
				return spelling;
			} else
				switch (ch) {
				case ' ':
				case '\t':
				case '\r':
				case eolnCh:
					ch = nextChar();
					break;

				case '(':
					ch = nextChar();
					return "(";
				case ')':
					ch = nextChar();
					return ")";
				case '{':
					ch = nextChar();
					return "{";
				case '}':
					ch = nextChar();
					return "}";
				// Энд зарим шалгах ёстой дутуу токенуудыг нөхөж бичих
				case eofCh:
					return "eof";

				default:

				}
		} while (true);
	}

	private boolean isLetter(char c) {
		// үсэг мөн эсэхийг шалгаад bool утга буцаах кодыг нөхөж бич.
		if ((int) c <= 90 && (int) c >= 65 || (int) c >= 97 && (int) c <= 122)
			return true;
		else
			return false;
	}

	private String concat(String set) {
		String r = "";
		do {
			r += ch;
			ch = nextChar();
		} while (set.indexOf(ch) >= 0);
		return r;
	}

	private String isCSyntax() {

		String res = "СИ код биш";
		// Салгасан токенуудыг int, main, (, ), {, } дараалалтай байгаа эсэхийг шалгах
		// кодыг нөхөж бич
		try {
			for (int i = 0; i < ar.size(); i++) {
				if (ht.get(ar.get(i)) == i)
					res = "СИ код мөн";
				else
					return "СИ код биш";

			}
		} catch (Exception e) {
			res = "СИ код биш";
		}
		return res;
	}

	static public void main(String[] argv) {

		int i = 0;
		Lexer lexer = new Lexer("C:\\Users\\gdwoo\\eclipse-workspace\\f.cs305\\src\\lab2\\newton.cpp");
		String tok = lexer.next();
		while (tok != "eof") {
			System.out.println(tok);
			ar.add(tok);
			tok = lexer.next();
		}
		System.out.println(lexer.isCSyntax());
	}
}
