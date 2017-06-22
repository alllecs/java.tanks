import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public abstract class Display extends Tanks{

	private static boolean created = false;
	private static JFrame window;
	private static Canvas content;

	public static void create(int width, int height, String title) {

		if (created)
			return;

		window = new JFrame(title);
		// exit whith close window
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		content = new Canvas() {
			public void paint(Graphics g) {
				super.paint(g);
				render(g);
			}				
		};
		// size window
		Dimension size = new Dimension(width, height);
		content.setPreferredSize(size);
		content.setBackground(Color.black);

		// пользователь не может менять размер окна
		window.setResizable(false);
		// добавить во внутреннюю часть окна
		window.getContentPane().add(content);
		// изменит размер окна под размер content
		window.pack();
		// окно появляется по центру
		window.setLocationRelativeTo(null);
		// окно видимо
		window.setVisible(true);
	}

	public static void render() {
		content.repaint();
	}

	private static void render(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(300 - 50, 300 - 50, 100, 100);
	}

}
