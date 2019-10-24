package main;

import javax.swing.JOptionPane;

public class Main {

	public static void converterDecBin(String aux) {
		int binario[] = new int[152];
		int indice = 0;
		String num = aux;

		String s = "";
		String s2 = "";
		
		
		int inteiro = Integer.valueOf(aux.split(",")[0]);
		
		if(aux.contains(",")) {
			double flutuante = Double.parseDouble((aux.split(",")[1]));
			System.out.println("ok");
			s2 = flutuanteDecBin(flutuante);
			System.out.println("teste");
		}

		while (inteiro > 0) {
			binario[indice++] = (int) (inteiro % 2);
			inteiro = inteiro / 2;	
		}
		
		for (int i = indice - 1; i >= 0; i--) {
			s = s + binario[i];
		}
		
		JOptionPane.showMessageDialog(null, "Decimal -> Binário \n" + num + " -> " + s + " " + s2);
	}
	
	private static String flutuanteDecBin( double n ) {
	    String val = "0.";
	    for (int i = 0; i < 10; i++) {
	        double r = n * 2;
	        if( r >= 1 ) {
	            val += "1";
	            n = r - 1;
	        }else{
	            val += "0";
	            n = r;
	        }
	    }
	    return val;
	}

	public static void converterDecOct(int n) {
		int octa[] = new int[40];
		int indice = 0;
		int num = n;

		String s = "";

		while (n > 0) {
			octa[indice++] = n % 8;
			n = n / 8;
		}
		for (int i = indice - 1; i >= 0; i--) {
			s = s + octa[i];
		}
		JOptionPane.showMessageDialog(null, "Decimal -> Octal \n" + num + " -> " + s);
	}

	public static void converterDecHex(int n) {
		int hex[] = new int[40];
		int indice = 0;
		int num = n;

		String s = "";

		while (n > 0) {
			hex[indice++] = n % 16;
			n = n / 16;
		}
		for (int i = indice - 1; i >= 0; i--) {
			if (hex[i] == 10) {
				s = s + "A";
			} else if (hex[i] == 11) {
				s = s + "B";
			} else if (hex[i] == 12) {
				s = s + "C";
			} else if (hex[i] == 13) {
				s = s + "D";
			} else if (hex[i] == 14) {
				s = s + "E";
			} else if (hex[i] == 15) {
				s = s + "F";
			} else {
				s = s + hex[i];
			}
		}
		JOptionPane.showMessageDialog(null, "Decimal -> Hexadecimal \n" + num + " -> " + s);
	}

	public static void converterBinDec(int n) {
		int decimal = 0;
		int indice = 0;
		int num = n;

		String s = "";

		while (n != 0) {
			decimal += ((n%10)*Math.pow(2,indice));
            n=n/10;
            indice++;
		}
			s = String.valueOf(decimal);
		JOptionPane.showMessageDialog(null, "Binario -> Decimal \n" + num + " -> " + s);
	}

	public static void converterOctDec(int n) {
		int decimal = 0;
		int indice = 0;
		int num = n;

		String s = "";

		while (n != 0) {
			decimal += ((n%10)*Math.pow(8,indice));
            n=n/10;
            indice++;
		}
			s = String.valueOf(decimal);
		JOptionPane.showMessageDialog(null, "Octal -> Decimal \n" + num + " -> " + s);
	}

	public static void converterHexDec(String n) {
		int decimal = 0;
		int indice = 0;
		String num = n;

		String s = "";	

		while (Integer.valueOf(n) != 0) {
			if(n.equalsIgnoreCase("A")) {
				n = n + "10";
			} else if (n.equalsIgnoreCase("B")) {
				n = n + "11";
			} else if (n.equalsIgnoreCase("C")) {
				n = n + "12";
			} else if (n.equalsIgnoreCase("D")) {
				n = n + "13";
			} else if (n.equalsIgnoreCase("E")) {
				n = n + "14";
			} else if (n.equalsIgnoreCase("F")) {
				n = n + "15";
			}
			
			decimal += ((Integer.valueOf(n)%10)*Math.pow(16,indice));
            n=String.valueOf(Integer.valueOf(n)/10);
            indice++;
		}
			s = String.valueOf(decimal);
		JOptionPane.showMessageDialog(null, "Hexadecimal -> Decimal \n" + num + " -> " + s);
	}

	public static void main(String[] args) {
		
		selecionarDecimal();
		
	}

	public static void selecionarDecimal() {
		String aux = "";
		String[] opcao = { "Dec -> Bin", "Dec -> Oct", "Dec -> Hex", "->" };

		int selecao = JOptionPane.showOptionDialog(null, "Escolha: ", "Decimal", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, opcao, opcao[0]);

		if (selecao == 0) {
			aux = JOptionPane.showInputDialog(null, "Insira um número decimal[<inteiro>, 0.<fração>]: ");
			converterDecBin(aux);
		} else if (selecao == 1) {
			aux = JOptionPane.showInputDialog(null, "Insira um número decimal[<inteiro>]: ");
			converterDecOct(Integer.parseInt(aux));
		} else if (selecao == 2) {
			aux = JOptionPane.showInputDialog(null, "Insira um número decimal[<inteiro>]: ");
			converterDecHex(Integer.parseInt(aux));
		} else if (selecao == 3) {
			selecionarOutros();
		}
	}

	public static void selecionarOutros() {
		String aux = "";
		String[] opcao = { "<-", "Bin -> Dec", "Oct -> Dec", "Hex -> Dec" };

		int selecao = JOptionPane.showOptionDialog(null, "Escolha: ", "Binario", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, opcao, opcao[0]);

		if (selecao == 0) {
			selecionarDecimal();
		} else if (selecao == 1) {
			aux = JOptionPane.showInputDialog(null, "Insira um número binario[<inteiro>]: ");
			converterBinDec(Integer.parseInt(aux));
		} else if (selecao == 2) {
			aux = JOptionPane.showInputDialog(null, "Insira um número octal[<inteiro>]: ");
			converterOctDec(Integer.parseInt(aux));
		} else if (selecao == 3) {
			aux = JOptionPane.showInputDialog(null, "Insira um número hexadecimal[<inteiro>]: ");
			converterHexDec(aux);
		}
	}

}
