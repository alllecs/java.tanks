import javax.swing.Timer;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;


public class Tanks {
	public static void main(String[] args) {
		Display.create(600, 600, "Tanks");

		// Таймер 60 раз в секунде (примерно). 
		Timer t = new Timer(1000 / 60, new AbstractAction() {
			// функция вызывается каждый интервал времени
			public void actionPerformed(ActionEvent e) {
				Display.render();
			}

		});

		t.setRepeats(true);
		t.start();
	}
}
