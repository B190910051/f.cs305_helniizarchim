package lab1;

import java.util.Hashtable;
import java.util.Scanner;

public class lab1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String exp = null; // expression
		int index = 0, vildelIdx = 0; // vildeliin index bolon huwisagchiin index
		isnum ob = new isnum(); // isnum class-iin object
		int result; // ilerhiileliin hariu
		Hashtable<String, Integer> ht = new Hashtable<>();
		Scanner sc = new Scanner(System.in);
		exp = sc.next();
		char[] ch = exp.toCharArray();

		try { // tootsooloogvi aldaanaas sergiilj exception ashiglaw
			for (int i = 0; i < exp.length(); i++) { // vildel bolon huwisagchiig salgaj hadaglah array-iin hemjeeg
														// todorhoiloh dawtalt.
				if (String.valueOf(ch[i]).charAt(0) == 43 || String.valueOf(ch[i]).charAt(0) == 45)
					index++;
			}
			String[] huwisagch = new String[(index + 1)];
			char[] vildel = new char[index];
			index = 0;

			for (int i = 0; i < exp.length(); i++) { // expression string-ees huwisagch, vildel, too-g ylgaj hash
														// husnegt, vildel array-d hadgalah dawtalt.

				if (ch[i] == '-' || ch[i] == '+' || exp.length() == i + 1) {
					if (exp.length() == i + 1) {
						if (huwisagch[index] == null)
							huwisagch[index] = "";
						huwisagch[index] = huwisagch[index] + ch[i];
					}
					if (ob.isNumeric(huwisagch[index])) {
						ht.put(String.valueOf(i), Integer.parseInt(huwisagch[index]));
						huwisagch[index] = String.valueOf(i);
						index++;
						if (vildelIdx < vildel.length) {
							vildel[vildelIdx] = ch[i];
							vildelIdx++;
						}
					} else {
						System.out.print(huwisagch[index] + " = ");
						ht.put(huwisagch[index], sc.nextInt());
						index++;
						if (vildelIdx < vildel.length) {
							vildel[vildelIdx] = ch[i];
							vildelIdx++;
						}
					}

				} else {
					if (huwisagch[index] == null)
						huwisagch[index] = "";
					huwisagch[index] = huwisagch[index] + ch[i];
				}
			}

			for (int q = 0; q < vildel.length; q++) {
				switch (vildel[q]) {
				case '+': {
					result = ht.get(huwisagch[q]) + ht.get(huwisagch[q + 1]);
					if (q != vildel.length - 1) {
						ht.put(huwisagch[q + 1], result);
					} else {
						System.out.println(exp + " = " + result);
					}

					break;
				}
				case '-': {
					result = ht.get(huwisagch[q]) - ht.get(huwisagch[q + 1]);
					if (q != vildel.length - 1) {
						ht.put(huwisagch[q + 1], result);
					} else {
						System.out.println(exp + " = " + result);
					}

					break;
				}
				default:
					System.err.println("ggg");
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(
					" Учирлаарай буруу утга!!! Энэ код нь зөвхөн нэмэх болон хасах үйлдэлтэй, хувьсагч болон натурал тооноос бүтсэн хэдийн ч урттай илэрхийллийг тооцоолдог. ");
		}

		sc.close();
	}

}
