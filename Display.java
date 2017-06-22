import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Arrays;


public abstract class Display extends Tanks{

	private static boolean created = false;
	private static JFrame window;
	private static Canvas content;

	// создаем буффер
	private static BufferedImage buffer;
	private static int[] bufferData;
	private static Graphics bufferGraphics;
	private static int clearColor;
	private static float delta = 0;

	public static void create(int width, int height, String title, int _clearColor) {

		if (created)
			return;

		window = new JFrame(title);
		// exit whith close window
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		content = new Canvas();
		// size window
		Dimension size = new Dimension(width, height);
		content.setPreferredSize(size);

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

		buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		// достать цвет 
		bufferData = ( (DataBufferInt) buffer.getRaster().getDataBuffer()).getData();
		// достать объект с изображения
		bufferGraphics = buffer.getGraphics();
		clearColor = _clearColor;

		created = true;

	}

	public static void clear() {
		// заполнение массива значениями вместо "for loop"
		Arrays.fill(bufferData, clearColor);
	}

	public static void render() {
		bufferGraphics.setColor(new Color(0xff0000ff));
		bufferGraphics.fillOval((int)(250 + (Math.sin(delta) * 200)), 250, 100, 100);
		delta += 0.02f;
		
	}

	public static void swapBuffers() {
		// достали графику
		Graphics g = content.getGraphics();
		// что хотим нарисовать, координаты, ширина и высота
		g.drawImage(buffer, 0, 0, null);
	}

}
