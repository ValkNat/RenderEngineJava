import javax.swing.*;
import java.awt.*;

//This is all basically just boilerplate code to actually get something to physically display
//Guide used to create this can be found here: http://blog.rogach.org/2015/08/how-to-create-your-own-simple-3d-render.html

public class DemoViewer {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Container pane = frame.getContentPane();
		pane.setLayout(new BorderLayout());

		//horizontal rotation
		JSlider headingSlider = new JSlider(0,360,180);
		pane.add(headingSlider, BorderLayout.SOUTH);

		//vertical rotation
		JSlider pitchSlider = new JSlider(SwingConstants.VERTICAL, -90,90,0);
		pane.add(pitchSlider, BorderLayout.EAST);

		//render results panel
		JPanel renderPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setColor(Color.BLACK);
				g2.fillRect(0,0,getWidth(), getHeight());
				super.paintComponent(g);
			}
		};

		pane.add(renderPanel, BorderLayout.CENTER);
		frame.setSize(400, 400);
		frame.setVisible(true);

	}

//Vertex class for storing basic coordinates
class Vertex {
	
	//Three coordinate variables
	double x, y, z;
	Vertex(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

class Triangle {
	//Stores all three points of triangle
	Vertex v1, v2, v3;
	//Stores color of triangle
	Color color;

	Triangle(Vertex v1, Vertex v2, Vertex v3, Color color) {
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
		this.color = color;
	}

}

class Tetrahedron {
	Vertex[] vertices = {
		new Vertex(0, 0, 1),
		new Vertex(1, 0, -1),
		new Vertex(-1, 0, -1),
		new Vertex(0, 1, 0)
	};

	int[][] faces = {
		{0, 1, 2},
		{0, 1, 3},
		{1, 2, 3},
		{2, 0, 3}
	};
}


}

}