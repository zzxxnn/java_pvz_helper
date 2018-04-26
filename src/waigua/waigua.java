package waigua;

import hanshu.Kernel32;
import hanshu.User32;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class waigua {
	// 句柄
	private int hand;
	// 線程id
	private int[] xcid = new int[1];
	//
	private int[] base = new int[1];
	// 进程id
	private int jcid;
	// 基址
	private final int jizhi = 0x006a9ec0;
	// 偏移
	private final int py[] = { 0x768, 0x5560, 0x82c, 0x28, 0x24 };
	//阳光
	int ygfirst[] = new int[1];
	int ygsecond[] = new int[1];
	//金币
	int moneyfirst[] = new int[1];
	int moneysecond[] = new int[1];
	//等级
	int levelfirst[] = new int[1];
	int levelsecond[] = new int[1];
	
	private boolean a = false;
	private JFrame frame;
	JLabel lblNewLabel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					waigua window = new waigua();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public waigua() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 399, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblNewLabel = new JLabel("\u8BF7\u5148\u6253\u5F00\u8FDB\u7A0B(\u8FDB\u7A0B\u5C1A\u672A\u6253\u5F00)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel.setBounds(16, 10, 351, 21);
		frame.getContentPane().add(lblNewLabel);

		final JButton btnNewButton = new JButton("\u6253\u5F00\u8FDB\u7A0B");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hand = User32.INSTANCE.FindWindowA(null, "植物大战僵尸中文版");
				if (hand != 0) {
					lblNewLabel.setText("打开游戏成功");
					btnNewButton.setEnabled(false);
				}
//				lblNewLabel.setText("打开游戏成功");
				User32.INSTANCE.GetWindowThreadProcessId(hand, xcid);
				jcid = Kernel32.INSTANCE.OpenProcess(0x1f0fff, false, xcid[0]);
				Kernel32.INSTANCE.ReadProcessMemory(jcid, jizhi, base, 4, 0);
			}
		});
		btnNewButton.setBounds(13, 34, 357, 28);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u8BFB\u53D6\u9633\u5149");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new sxxc()).start();
			}
		});
		btnNewButton_1.setBounds(13, 72, 102, 28);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\u4FEE\u6539\u9633\u5149");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a[]= new int[1];
				a[0] =Integer.parseInt(textField_1.getText()); 
				System.out.println(a[0]);
				writeshine(a);
			}
		});
		btnNewButton_2.setBounds(13, 110, 102, 28);
		frame.getContentPane().add(btnNewButton_2);

		JLabel lblNewLabel_1 = new JLabel("\u9633\u5149\uFF1A");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(155, 71, 58, 28);
		frame.getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setText("\u7B49\u5F85\u8BFB\u53D6");
		textField.setBounds(263, 75, 66, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton button = new JButton("\u9501\u5B9A\u9633\u5149");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				new Thread(new sdxc(!a)).start();
			}
		});
		button.setBounds(13, 148, 357, 28);
		frame.getContentPane().add(button);
		
		textField_1 = new JTextField();
		textField_1.setText("1000");
		textField_1.setBounds(179, 114, 126, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton button_1 = new JButton("\u8BFB\u53D6\u91D1\u5E01");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readsMoney();
				textField_2.setText(new Integer(moneysecond[0]).toString());
			}
		});
		button_1.setBounds(13, 186, 106, 28);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u4FEE\u6539\u91D1\u5E01");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] a = new int[1];
				a[0] = Integer.parseInt(textField_2.getText());
				writeMoney(a);
			}
		});
		button_2.setBounds(267, 186, 102, 28);
		frame.getContentPane().add(button_2);
		
		textField_2 = new JTextField();
		textField_2.setText("\u7B49\u5F85\u8BFB\u53D6");
		textField_2.setColumns(10);
		textField_2.setBounds(129, 190, 82, 21);
		frame.getContentPane().add(textField_2);
		
		JLabel label = new JLabel("*10");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(207, 186, 58, 28);
		frame.getContentPane().add(label);
		
		JButton btncd = new JButton("\u65E0cd");
		btncd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] a= new int[1];
				a[0]= 0x90;
				Kernel32.INSTANCE.WriteProcessMemory(jcid, 0x487296, a, 1, 0);
				
				Kernel32.INSTANCE.WriteProcessMemory(jcid, 0x487297, a, 1, 0);
				
			}
		});
		btncd.setBounds(13, 264, 171, 28);
		frame.getContentPane().add(btncd);
		
		JButton btncd_1 = new JButton("\u6B63\u5E38cd");
		btncd_1.setBounds(199, 264, 171, 28);
		frame.getContentPane().add(btncd_1);
		
		JButton button_5 = new JButton("\u4E0D\u6389\u8840");
		button_5.setBounds(13, 304, 171, 28);
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("\u6389\u8840");
		button_6.setBounds(199, 304, 171, 28);
		frame.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("\u540E\u53F0");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] a= new int[1];
				a[0]= 0xb0;
				int[] b= new int[1];
				b[0]= 0x1;
				int[] c= new int[1];
				c[0]= 0x90;
				Kernel32.INSTANCE.WriteProcessMemory(jcid, 0x54e1c2, a, 1, 0);
				Kernel32.INSTANCE.WriteProcessMemory(jcid, 0x54e1c3, b, 1, 0);
				Kernel32.INSTANCE.WriteProcessMemory(jcid, 0x54e1c4, c, 1, 0);
			}
		});
		button_7.setBounds(13, 342, 171, 28);
		frame.getContentPane().add(button_7);
		
		JButton button_8 = new JButton("\u53D6\u6D88\u540E\u53F0");
		button_8.setBounds(199, 342, 171, 28);
		frame.getContentPane().add(button_8);
		
		JButton button_9 = new JButton("\u8BFB\u53D6\u91D1\u5E01");
		button_9.setBounds(13, 380, 171, 28);
		frame.getContentPane().add(button_9);
		
		JButton button_10 = new JButton("\u8BFB\u53D6\u91D1\u5E01");
		button_10.setBounds(199, 380, 171, 28);
		frame.getContentPane().add(button_10);
		
		JButton button_11 = new JButton("\u8BFB\u53D6\u91D1\u5E01");
		button_11.setBounds(13, 418, 171, 28);
		frame.getContentPane().add(button_11);
		
		JButton button_12 = new JButton("\u8BFB\u53D6\u91D1\u5E01");
		button_12.setBounds(199, 418, 171, 28);
		frame.getContentPane().add(button_12);
		
		JButton button_3 = new JButton("\u8BFB\u53D6\u7B49\u7EA7");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				readsLevel();
				textField_3.setText(new Integer(levelsecond[0]).toString());
			}
		});
		button_3.setBounds(13, 224, 107, 28);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("\u4FEE\u6539\u7B49\u7EA7");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] a = new int[1];
				a[0]=Integer.parseInt(textField_3.getText());
				writeLevel(a);
			}
		});
		button_4.setBounds(268, 224, 102, 28);
		frame.getContentPane().add(button_4);
		
		textField_3 = new JTextField();
		textField_3.setText("\u7B49\u5F85\u8BFB\u53D6");
		textField_3.setColumns(10);
		textField_3.setBounds(132, 228, 124, 21);
		frame.getContentPane().add(textField_3);

	}
	public void readshine(){
		Kernel32.INSTANCE.ReadProcessMemory(jcid, base[0]+py[0], ygfirst, 4, 0);
		Kernel32.INSTANCE.ReadProcessMemory(jcid, ygfirst[0]+py[1], ygsecond, 4, 0);
		
	}
	public void writeshine(int[] a){
		Kernel32.INSTANCE.ReadProcessMemory(jcid, base[0]+py[0], ygfirst, 4, 0);
		Kernel32.INSTANCE.WriteProcessMemory(jcid, ygfirst[0]+py[1], a, 4, 0);
	}
	public void readsLevel(){
		Kernel32.INSTANCE.ReadProcessMemory(jcid, base[0]+py[2], levelfirst, 4, 0);
		Kernel32.INSTANCE.ReadProcessMemory(jcid, levelfirst[0]+py[4], levelsecond, 4, 0);
		
	}
	public void writeLevel(int[] a){
		Kernel32.INSTANCE.ReadProcessMemory(jcid, base[0]+py[2], levelfirst, 4, 0);
		Kernel32.INSTANCE.WriteProcessMemory(jcid, levelfirst[0]+py[4], a, 4, 0);
	}
	public void readsMoney(){
		Kernel32.INSTANCE.ReadProcessMemory(jcid, base[0]+py[2], moneyfirst, 4, 0);
		Kernel32.INSTANCE.ReadProcessMemory(jcid, moneyfirst[0]+py[3], ygsecond, 4, 0);
		
	}
	public void writeMoney(int[] a){
		Kernel32.INSTANCE.ReadProcessMemory(jcid, base[0]+py[2], moneyfirst, 4, 0);
		Kernel32.INSTANCE.WriteProcessMemory(jcid, moneyfirst[0]+py[3], a, 4, 0);
	}
	
	public class sxxc implements Runnable{

		@Override
		public void run() {
			while (true) {
				try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			readshine();
			Integer a = ygsecond[0];
			textField.setText(a.toString());
			}
		}
		
	}
	public class sdxc implements Runnable{
		boolean hehe = false;
		public sdxc(boolean he) {
			hehe = he;
		}
		public void run() {
			while (hehe) {
				try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
				int a[]= new int[1];
				a[0] = 1000;
				writeshine(a);
			}
		}
		
	}
}
