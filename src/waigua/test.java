package waigua;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class test {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
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
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 567, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 37, 316, 391);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		String a = "1������˹������������ �� �� Ѱ���� \n2���ز��������� �ҿ�,��һ��� �о�\n 3���������������ҿ��޼��� \n4�� ɭ������ ������ʲô,��ʲô\n 5���԰׽��� ���������� ���ڲ��ҿ�,�ҿ�ֻ��רҵ�� \n6�������������� ����������Ҳ�� 7������ ���������ҿ�,һ�� ���п���\n 8���������� �������,�ҹ�,��ҹ�, �ҹ�\n 9��ũ��ɽȪ �������������е���\n 10�� �õ����������� �ҹң�������Ĺ�\n 11���׼� ������������ ���һ�ƣ����˯�������ٹ� һ�ƣ�˯����\n 12��������������ѧ������ �ƣ�ѧУ����ô �� \n13���޹��������������� ~~��ҲҪ�� �ƣ�\n 14����������������֪���� �Ƶ�ζ�� �� \n15����̤���������ҹҿƣ��� ϲ����\n 16��NIKE��������Just �� it��\n 17�� ���и������������ڵĹҿư������������ߣ� ��һ�ƶ���ȥ��ƣ����㣡�����ң�һ������ ����ƣ����Ѿ���\n18�����׽����������ҹҸ� ������\n19����ˮ�ϰ׸����������ҳ�����ζ��\n 20����������������һ���������ԣ��������� ��ƣ�ͣ������Ƴ������ϡ��������ҿƺü���";
		textArea.setText(a);
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"��ӳɹ�");
			}
		});
		btnNewButton.setBounds(417, 405, 93, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
