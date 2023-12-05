
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_C_GameObject extends GameObject implements KeyListener {

	public Type_C_GameObject(int x, int y) {
		super(x, y);
		setDirection(Direction.NONE);

		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_C_Left.png"));
		imageList.add(new ImageIcon("images/Type_C_Right.png"));

	}

	public void move(Canvas c) {
		Icon icon = getCurrentImage();

		int iconWidth = icon.getIconWidth();
		int canvasWidth = (int) c.getSize().getWidth();

		// MOVE BALL AND CHECK FOR A COLLISION WITH WALL
		if (isHighlighted()) {
			switch (getDirection()) {
			case Direction.LEFT:
				setX(getX() + getVelocity());
				if (getX() + iconWidth > canvasWidth) {
					setX((int) (canvasWidth - iconWidth));
				}
				break;
			case Direction.RIGHT:
				setX(getX() - getVelocity());
				if (getX() < 0) {
					setX(0);
				}
				break;
			default:
				break;
			}
		} else {
			if (getDirection() == Direction.LEFT) {
				setX(getX() + getVelocity());
				if (getX() + iconWidth > c.getSize().getWidth()) {
					setX((int) (c.getSize().getWidth() - iconWidth));
					setDirection(Direction.RIGHT);
				}

			} else {
				setX(getX() - getVelocity());
				if (getX() < 0) {
					setX(0);

					setDirection(Direction.LEFT);
				}
			}
		}

	}

	// SPECIFY THE IMAGE TO DISPLAY
	// USED FOR ANIMATION
	public void setImage() {
		switch (getDirection()) {
		case Direction.NONE:
			break;
		case Direction.LEFT:
			currentImage = 0;
			break;
		case Direction.RIGHT:
			currentImage = 1;
			break;
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() != KeyEvent.VK_TAB) {
			setDirection(Direction.NONE);
		}
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			setDirection(Direction.LEFT);
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			setDirection(Direction.RIGHT);
		}
	}
}
