package util;

import javax.swing.JComboBox;

public class Box {

	public static final JComboBox<String> boxEstadoCivil() {

		JComboBox<String> estadoCivil = new JComboBox<String>();
		estadoCivil.addItem("Solteiro (a)");
		estadoCivil.addItem("Casado (a)");
		estadoCivil.addItem("Divorciado (a)");
		estadoCivil.addItem("Viúvo (a)");
		estadoCivil.addItem("União Estavel");

		return estadoCivil;

	}

	public static final JComboBox<String> boxSexo() {

		JComboBox<String> boxSexo = new JComboBox<String>();
		boxSexo.addItem("Masculino");
		boxSexo.addItem("Feminino");
		boxSexo.addItem("Outro");

		return boxSexo;

	}

	public static final JComboBox<String> boxUF() {

		JComboBox<String> boxUF = new JComboBox<String>();
		boxUF.addItem("AC");
		boxUF.addItem("AL");
		boxUF.addItem("AP");
		boxUF.addItem("AM");
		boxUF.addItem("BA");
		boxUF.addItem("CE");
		boxUF.addItem("DF");
		boxUF.addItem("ES");
		boxUF.addItem("GO");
		boxUF.addItem("MA");
		boxUF.addItem("MT");
		boxUF.addItem("MS");
		boxUF.addItem("PB");
		boxUF.addItem("PR");
		boxUF.addItem("PE");
		boxUF.addItem("PI");
		boxUF.addItem("RJ");
		boxUF.addItem("RN");
		boxUF.addItem("RS");
		boxUF.addItem("RO");
		boxUF.addItem("RR");
		boxUF.addItem("SC");
		boxUF.addItem("SP");
		boxUF.addItem("SE");
		boxUF.addItem("TO");

		return boxUF;

	}

	public static final JComboBox<String> parentesco() {

		JComboBox<String> boxP = new JComboBox<String>();

		boxP.addItem("Filho(a)");
		boxP.addItem("Cônjuge");
		boxP.addItem("Pai/Mãe");
		boxP.addItem("Outro");

		return boxP;

	}

	public static final JComboBox<String> boxSituacao() {

		JComboBox<String> situacao = new JComboBox<String>();
		situacao.addItem("Ativo");
		situacao.addItem("Desligado");

		return situacao;

	}

}
