package poo.tarefas.tarefa16.b.etapa3;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainJanelaCores {

	public static void main(String[] args) {
		criarJanelaTrocaDeCores(0, Color.GREEN, Color.RED).setVisible(true);
		criarJanelaTrocaDeCores(1, Color.BLUE, Color.ORANGE).setVisible(true);
		criarJanelaTrocaDeCores(2, Color.GRAY, Color.YELLOW).setVisible(true);
	}

	private static JFrame criarJanelaTrocaDeCores(int indiceJanela, Color cor1, Color cor2) {
		JFrame f1 = new JFrame();
		f1.setLayout(new GridLayout(2, 1));
		JLabel l1 = new JLabel("Texto");
		l1.setHorizontalAlignment(JLabel.CENTER);
		l1.setOpaque(true);
		JButton b1 = new JButton("Trocar cor");
		b1.addActionListener(e -> l1.setBackground(l1.getBackground() == cor1 ? cor2 : cor1));
		f1.add(l1);
		f1.add(b1);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.pack();
		f1.setLocation(indiceJanela * 60, indiceJanela * 60);
		return f1;
	}

}
