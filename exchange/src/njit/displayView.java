package njit;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class displayView extends JPanel {
	JTextField text1, text2;
	JPanel pan;
	JTextArea textarea;

	public displayView() {
		text1 = new JTextField(3);
		text2 = new JTextField(3);
		text1.setEditable(false);
		text2.setEditable(false);
		pan = new JPanel();
		pan.setLayout(new GridLayout(4, 2));// ���ڲ�����������
		pan.add(new JLabel("ȱҳ��"));
		pan.add(text1);
		pan.add(new JLabel("ȱҳ��"));
		pan.add(text2);
		textarea = new JTextArea();
		textarea.setEditable(false);
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.CENTER, textarea);
		this.add(BorderLayout.SOUTH, pan);
	}
}
