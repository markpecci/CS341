import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import javax.swing.*;

public class Canvas extends JComponent implements ActionListener, KeyListener {
	private JFrame frame;
	private Timer gameLoopTimer;
	private List<GameObject> gameObjectList;
	private int highlighted = 0;

	public Canvas() {
		gameObjectList = new LinkedList<>();

		frame = new JFrame("Animation Canvas");
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);

		gameLoopTimer = new Timer(25, this);
		gameLoopTimer.start();

		setFocusTraversalKeysEnabled(false);
		addKeyListener(this);

		frame.setVisible(true);
	}

	public synchronized void addGameObject(GameObject sprite) {
		gameObjectList.add(sprite);
	}

	public synchronized void paint(Graphics g) {
		super.paint(g);
		for (GameObject obj : gameObjectList) {
			obj.draw(this, g);
			if (obj == gameObjectList.get(highlighted)) {
				g.setColor(Color.RED);
				g.drawRect(obj.getX(), obj.getY(), 140, 180);
			}
		}
	}

	public synchronized void actionPerformed(ActionEvent e) {
		for (GameObject obj : gameObjectList) {
			obj.move(this);
			obj.setImage();
		}
		repaint();
	}

	public void keyTyped(KeyEvent e) {
		// Implement if needed
	}

	public void keyPressed(KeyEvent e) {
		GameObject highlightedObject = gameObjectList.get(highlighted);
		if (highlightedObject instanceof Type_D_GameObject) {
			Type_D_GameObject typedObject = (Type_D_GameObject) highlightedObject;
			typedObject.keyPressed(e);
			repaint();
		} else if (highlightedObject instanceof Type_A_GameObject) {
			Type_A_GameObject typedObject = (Type_A_GameObject) highlightedObject;
			typedObject.keyPressed(e);
			repaint();
		} else if (highlightedObject instanceof Type_B_GameObject) {
			Type_B_GameObject typedObject = (Type_B_GameObject) highlightedObject;
			typedObject.keyPressed(e);
			repaint();
		} else if (highlightedObject instanceof Type_C_GameObject) {
			Type_C_GameObject typedObject = (Type_C_GameObject) highlightedObject;
			typedObject.keyPressed(e);
			repaint();
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_TAB) {
			// reset isHighlighted to false for all objects
			for (GameObject obj : gameObjectList) {
				obj.setHighlighted(false);
			}
			highlighted = (highlighted + 1) % gameObjectList.size();
			repaint();
		} else {
			GameObject highlightedObject = gameObjectList.get(highlighted);
			if (highlightedObject instanceof Type_D_GameObject) {
				Type_D_GameObject typedObject = (Type_D_GameObject) highlightedObject;
				typedObject.setHighlighted(true);
				typedObject.keyReleased(e);
			} else if (highlightedObject instanceof Type_A_GameObject) {
				Type_A_GameObject typedObject = (Type_A_GameObject) highlightedObject;
				typedObject.setHighlighted(true);
				typedObject.keyReleased(e);
			} else if (highlightedObject instanceof Type_B_GameObject) {
				Type_B_GameObject typedObject = (Type_B_GameObject) highlightedObject;
				typedObject.setHighlighted(true);
				typedObject.keyReleased(e);
			} else if (highlightedObject instanceof Type_C_GameObject) {
				Type_C_GameObject typedObject = (Type_C_GameObject) highlightedObject;
				typedObject.setHighlighted(true);
				typedObject.keyReleased(e);
			}
			repaint();
		}
	}
}
