package util.document;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class DocumentMonetario extends PlainDocument {
	/**
	 * @author Gabriel Fonseca
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {

		if (str.length() <= 16) { // Permite até 16 caracteres 

			str = str.replaceAll("[^0-9|^R|^$|^.|^,]", ""); // Permite somente os caracteres descritos

			super.insertString(offs, str, a);

		}

	}

}