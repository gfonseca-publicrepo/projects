package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class Mascaras {

	private MaskFormatter fSalario;
	private MaskFormatter fRG;
	private MaskFormatter fJornada;
	private MaskFormatter fCPF;
	private MaskFormatter fCEP;
	private MaskFormatter fCel;
	private MaskFormatter fTel;
	private MaskFormatter f2;
	private MaskFormatter mask;

	public MaskFormatter MaskMonetario() { // Falta escrever da direita para a esquerda, colocando primeiros centavos,
											// centenas e milhar.

		try {

			fSalario = new MaskFormatter("R$***.***,**");

			fSalario.setValidCharacters("0123456789");

		} catch (ParseException e) {

			JOptionPane.showMessageDialog(null, "Valor de salário inválido");

		}

		return fSalario;

	}

	public MaskFormatter Mask2Digitos() {
		try {

			f2 = new MaskFormatter("R$**.**");

			f2.setValidCharacters("0123456789");

		} catch (ParseException e) {

			JOptionPane.showMessageDialog(null, "Valor de decimal inválido");

		}

		return f2;

	}

	public MaskFormatter MaskRG() {

		try {

			fRG = new MaskFormatter("**.***.***-*");

			fRG.setValidCharacters("0123456789");

		} catch (ParseException e) {

			JOptionPane.showMessageDialog(null, "Valor do RG inválido");

		}

		return fRG;

	}

	public MaskFormatter MaskPis() {

		try {

			fRG = new MaskFormatter("***.*****.**-*");

			fRG.setValidCharacters("0123456789");

		} catch (ParseException e) {

			JOptionPane.showMessageDialog(null, "Valor do PIS inválido");

		}

		return fRG;

	}

	public MaskFormatter MaskJornada() {

		try {

			fJornada = new MaskFormatter("*** h/mês");

			fJornada.setValidCharacters("0123456789");

		} catch (ParseException e) {

			JOptionPane.showMessageDialog(null, "Valor inválido");

		}

		return fJornada;

	}

	public MaskFormatter MaskCPF() {

		try {

			fCPF = new MaskFormatter("***.***.***-**");

			fCPF.setValidCharacters("0123456789");

		} catch (ParseException e) {

			JOptionPane.showMessageDialog(null, "Valor inválido");

		}

		return fCPF;

	}

	public MaskFormatter MaskCEP() {

		try {

			fCEP = new MaskFormatter("*****-***");

			fCEP.setValidCharacters("0123456789");

		} catch (ParseException e) {

			JOptionPane.showMessageDialog(null, "Valor inválido");

		}

		return fCEP;

	}

	public MaskFormatter MaskCtps() {

		try {

			fCEP = new MaskFormatter("********/*****");

			fCEP.setValidCharacters("0123456789");

		} catch (ParseException e) {

			JOptionPane.showMessageDialog(null, "Valor inválido");

		}

		return fCEP;

	}

	public MaskFormatter MaskCelular() {

		try {

			fCel = new MaskFormatter("(**)*****-****");

			fCel.setValidCharacters("0123456789");

		} catch (ParseException e) {

			JOptionPane.showMessageDialog(null, "Valor inválido");

		}

		return fCel;

	}

	public MaskFormatter MaskTelefone() {

		try {

			fTel = new MaskFormatter("(**)****-****");

			fTel.setValidCharacters("0123456789");

		} catch (ParseException e) {

			JOptionPane.showMessageDialog(null, "Valor inválido");

		}

		return fTel;

	}

	public MaskFormatter Mask100() {

		try {

			mask = new MaskFormatter(
					"****************************************************************************************************");

			mask.setInvalidCharacters(".,*");

		} catch (ParseException e) {

			JOptionPane.showMessageDialog(null, "Valor inválido, no máximo 100 caracteres");

		}

		return mask;

	}

	public MaskFormatter Mask30() {

		try {

			mask = new MaskFormatter("******************************");

			mask.setInvalidCharacters(".,*");

		} catch (ParseException e) {

			JOptionPane.showMessageDialog(null, "Valor inválido, no máximo 30 caracteres");

		}

		return mask;

	}

	public MaskFormatter Mask10Numerica() {

		try {

			mask = new MaskFormatter("**********");

			mask.setInvalidCharacters(".,*");

		} catch (ParseException e) {

			JOptionPane.showMessageDialog(null, "Valor inválido, no máximo 30 caracteres");

		}

		return mask;

	}

	public MaskFormatter Mask60() {

		try {

			mask = new MaskFormatter("************************************************************");

			mask.setInvalidCharacters(".,*");

		} catch (ParseException e) {

			JOptionPane.showMessageDialog(null, "Valor inválido, no máximo 30 caracteres");

		}

		return mask;

	}

	public MaskFormatter MaskEnderecoNumero() {

		try {

			mask = new MaskFormatter("******");
			mask.setInvalidCharacters(".,");

		} catch (ParseException e) {

			JOptionPane.showMessageDialog(null, "Valor inválido, no máximo 100 caracteres");

		}

		return mask;

	}

	public SimpleDateFormat dateFormat() {

		SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");

		return d;

	}

	public boolean verificarCampoVazio(String campo) {
		
		
		
		return false;
	}

}
