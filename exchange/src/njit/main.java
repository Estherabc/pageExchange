package njit;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class main {
	public static void main(String[] args) {
		JFrame myframe = new JFrame();
		pageChange pc = new pageChange();
		JTabbedPane tab = new JTabbedPane();
		JMenuBar mb = new JMenuBar();
		JMenu mi = new JMenu("Help");
		mi.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				JOptionPane.showMessageDialog(new JOptionPane(), "课本P107", "提示！", JOptionPane.OK_OPTION);
			}

		});
		mb.add(mi);
		tab.add("页面置换算法", pc);
		myframe.setLayout(new BorderLayout());
		myframe.add(BorderLayout.NORTH, mb);
		myframe.add(BorderLayout.CENTER, tab);
		myframe.setTitle("页面置换算法");
		myframe.setSize(950, 850);
		myframe.show(true);

	}
}
