package swing_avanzado;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class PruebaJTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MiVentana2 miVentana=new MiVentana2();

		miVentana.setVisible(true);
	}

}


class MiVentana2 extends JFrame {

	public MiVentana2 () {
		this.setBounds(400, 200, 600, 600);
		this.setTitle("Árbol Sencillo");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DefaultMutableTreeNode raiz=new DefaultMutableTreeNode("Mundo");
		DefaultMutableTreeNode espana=new DefaultMutableTreeNode("España");
		DefaultMutableTreeNode alemania=new DefaultMutableTreeNode("Alemania");

		raiz.add(espana);
		raiz.add(alemania);
		
		DefaultMutableTreeNode madrid=new DefaultMutableTreeNode("Madrid");
		DefaultMutableTreeNode cantabria=new DefaultMutableTreeNode("Cantabria");
		DefaultMutableTreeNode baviera=new DefaultMutableTreeNode("Baviera");

		espana.add(madrid);
		espana.add(cantabria);
		alemania.add(baviera);

		DefaultMutableTreeNode mostoles=new DefaultMutableTreeNode("Móstoles");
		DefaultMutableTreeNode alcobendas=new DefaultMutableTreeNode("Alcobendas");
		DefaultMutableTreeNode santillana=new DefaultMutableTreeNode("Santillana del Mar");
		
		madrid.add(mostoles);
		madrid.add(alcobendas);
		cantabria.add(santillana);
		
		DefaultMutableTreeNode munich=new DefaultMutableTreeNode("Munich");

		baviera.add(munich);
		
		JTree miArbol=new JTree(raiz);
		
		JScrollPane miScroll=new JScrollPane(miArbol);
		
		add(miScroll);
		
		//Lamina2 miLamina=new Lamina2(miArbol);
		
		//add(miLamina);
		
	}
}

/*class Lamina2 extends JPanel {
	public Lamina2(JTree arbol) {
		setLayout(new BorderLayout());
		
		add(arbol, BorderLayout.NORTH);
		
	}
}
*/