package poo.tarefas.tarefa16.b.etapa4;

import java.awt.Color;

public class MainJanelaCores {

	public static void main(String[] args) {
		FabricaJanelaCores fabrica = new FabricaJanelaCores();
		fabrica.criarJanela(0, Color.GREEN, Color.RED).setVisible(true);
		fabrica.criarJanela(1, Color.BLUE, Color.ORANGE).setVisible(true);
		fabrica.criarJanela(2, Color.GRAY, Color.YELLOW).setVisible(true);
	}

}
