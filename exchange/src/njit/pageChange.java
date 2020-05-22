package njit;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class pageChange extends JPanel implements ActionListener {
	JPanel pan1, pan2, pan3, pan4;
	JButton button1, button2, button3, clearButton, randomButton;
	JTextField text1, text2, text3, text4;
	String m_random = "";// 页面序列
	int m, n, length;
	int myt[];
	randomNumber RN;
	displayView FIFOTA, LRUTA, OptTA;

	public pageChange() {
		pan1 = new JPanel();
		pan2 = new JPanel();
		pan3 = new JPanel();
		text1 = new JTextField(4);
		text2 = new JTextField(5);
		text3 = new JTextField();
		text4 = new JTextField();
		pan1.setLayout(new GridLayout(4, 2));
		pan1.add(new JLabel("物理块数"));
		pan1.add(text1);
		pan1.add(new JLabel("置换页面数"));
		pan1.add(text2);
		pan1.add(new JLabel("页表长度"));
		pan1.add(text3);
		pan1.add(new JLabel("页面号引用串"));
		pan1.add(text4);
		FIFOTA = new displayView();
		LRUTA = new displayView();
		OptTA = new displayView();
		pan2.setLayout(new GridLayout(1, 3));
		pan2.add(FIFOTA);
		pan2.add(LRUTA);
		pan2.add(OptTA);
		button1 = new JButton("FIFO");
		button2 = new JButton("LRU");
		button3 = new JButton("Opt");
		randomButton = new JButton("Random");
		clearButton = new JButton("Clear");
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		randomButton.addActionListener(this);
		clearButton.addActionListener(this);
		pan3.add(button1);
		pan3.add(button2);
		pan3.add(button3);
		pan3.add(randomButton);
		pan3.add(clearButton);
		setLayout(new BorderLayout());
		add(BorderLayout.NORTH, pan1);
		add(BorderLayout.CENTER, pan2);
		add(BorderLayout.SOUTH, pan3);
	}

	public void misInPut() {
		try {
			String str1, str2;
			str1 = "";
			str2 = "";
			m = Integer.parseInt(text1.getText());
			n = Integer.parseInt(text2.getText());
			length = Integer.parseInt(text3.getText());
			if (m == 0 || n == 0 || length == 0) {
				JOptionPane.showMessageDialog(this, "请输入字符", "提示！", JOptionPane.ERROR_MESSAGE);
			}
			if (m > n && length != 0) {
				JOptionPane.showMessageDialog(this, "输入的物理块数大于页面数或页表长度为0", "警告！", JOptionPane.WARNING_MESSAGE);
				text1.setText("0");
				text2.setText("0");
				text3.setText("0");
				text4.setText("");

			} else {
				myt = new int[n];    
				RN = new randomNumber();
				myt = RN.rand(n, length);
				for (int i = 0; i < n; i++) {
					str2 = String.valueOf(myt[i]);
					str1 = str1 + "," + str2;
				}
				m_random = str1;
				text4.setText("" + m_random);
			}
		} catch (NumberFormatException ee) {
			JOptionPane.showMessageDialog(this, "输入数字字符！", "警告！", JOptionPane.WARNING_MESSAGE);
			text1.setText("0");
			text2.setText("0");
			text3.setText("0");
			text4.setText("");
			FIFOTA.text1.setText("0");
			FIFOTA.text2.setText("0");
			FIFOTA.textarea.setText(null);
			LRUTA.text1.setText("0");
			LRUTA.text2.setText("0");
			LRUTA.textarea.setText(null);
			OptTA.text1.setText("0");
			OptTA.text2.setText("0");
			OptTA.textarea.setText(null);
		}
	}

	public void FIFO() {     //先进先出    
		int f_absent;
		double f_absentf;	
		int r;
		int as = 0;
		boolean x;
		String str1, str2;
		String f_list = "FIFO置换算法";
		int mym[];
		mym = new int[m]; 
		for (int i = 0; i < n; i++) {
			str1 = "";
			str2 = "";
			x = true;
			for (int k = 0; k < m; k++) { 
				if (myt[i] == mym[k]) { 
					x = false; 
					break;
				}
			}
			if (x) { 
				for (r = 0; r < m - 1; r++)
					mym[r] = mym[r + 1]; 
				mym[r] = myt[i]; 
				as++; 
				}
			int b;
			for (int j = 0; j < m; j++) {
				b = mym[j];
				str2 = String.valueOf(b); 
				str1 = str1 +","+ str2;
			}
			f_list = f_list + '\n' + str1;
		}
		f_absent = as; 
		f_absentf = (double) as / n; 

		FIFOTA.text1.setText("" + f_absent);
		FIFOTA.text2.setText("" + f_absentf);
		FIFOTA.textarea.setText("" + f_list);
	}

	public void LRU() {           //最近最久未使用
		int l_absent;
		double l_absentf;
		int mym[];
		int as = 0;
		int r;
		boolean x;
		String str2, str1;
		String l_list = "LUR置换算法";
		mym = new int[m];
		for (int i = 0; i < n; i++) {
			str1 = "";
			str2 = "";
			x = true;
			for (int k = 0; k < m; k++) {
				if (myt[i] == mym[k]) { 
					for (r = k; r < m - 1; r++)
						mym[r] = mym[r + 1];
					mym[r] = myt[i]; 
					x = false;
					break;
				}
			}
			if (x) { 
				for (r = 0; r < m - 1; r++)
					mym[r] = mym[r + 1]; 
				mym[r] = myt[i]; 
				as++; 
			}
			for (int j = 0; j < m; j++) {
				int b;
				b = mym[j];
				str2 = String.valueOf(b);
				str1 = str1 + "," + str2;
			}
			l_list = l_list + '\n' + str1;
		}
		l_absent = as;
		l_absentf = (double) as / n;

		LRUTA.text1.setText("" + l_absent);
		LRUTA.text2.setText("" + l_absentf);
		LRUTA.textarea.setText("" + l_list);
	}

	public void Opt() {               //最佳页面
		int o_absent; 
		double o_absentf; 
		int m1 = 0;
		int a;
		int as = 0; 
		int time[]; 
		time = new int[n];
		boolean x; 
		String str2, str1;
		String o_list = "Opt置换算法";
		int mym[];
		mym = new int[m];
		int c = 0;
		int d;
		for (int i = 0; i < n; i++) {
			str1 = "";
			str2 = "";
			x = true;
			for (int k = 0; k < m; k++) {
				if (myt[i] == mym[k]) {
					x = false; 
					m1++;       
					break;
				}
			}

			if (x) {
				if ((i - m1) < m) { 
					a = i - m1;                              
				} else {
					for (int k = 0; k < m; k++) {       
						for (int h = i; h < n; h++) {
							if (mym[k] == myt[h]) {
								time[k] = h;
								break; 
							}
							if (h == n - 1) 
								time[k] = n; 
						}
					}
					d = time[0];
					for (int h = 0; h < m; h++) { 
						if (d < time[h]) {
							d = time[h];
							c = h;
						}
					}
					a = c;
				}
				   mym[a] = myt[i];                     
				time[a] = 0; 
				for (int k = 0; k < m; k++) { 
					if (k != a)
						time[k] = time[k] + 1;
				}
				as++;
			}
			for (int j = 0; j < m; j++) {
				int b;
				b = mym[j];
				str2 = String.valueOf(b);
				str1 = str1 + "," + str2;
			}
			o_list = o_list + '\n' + str1;
		}
		o_absent = as;
		o_absentf = (double) as / n;

		OptTA.text1.setText("" + o_absent);
		OptTA.text2.setText("" + o_absentf);
		OptTA.textarea.setText("" + o_list);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == randomButton) {
			misInPut();
		}
		if (e.getSource() == button1) {
			FIFO();
		}
		if (e.getSource() == button2) {
			LRU();
		}
		if (e.getSource() == button3) {
			Opt();
		}
		if (e.getSource() == clearButton) {
			text1.setText("0");
			text2.setText("0");
			text3.setText("0");
			text4.setText("");
			FIFOTA.text1.setText("0");
			FIFOTA.text2.setText("0");
			FIFOTA.textarea.setText(null);
			LRUTA.text1.setText("0");
			LRUTA.text2.setText("0");
			LRUTA.textarea.setText(null);
			OptTA.text1.setText("0");
			OptTA.text2.setText("0");
			OptTA.textarea.setText(null);
			myt = new int[0];
		}

	}

}
