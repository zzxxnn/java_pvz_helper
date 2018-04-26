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
		String a = "1，美特斯邦威提醒您： 不 挂 寻常科 \n2、特步提醒您： 挂科,死一般的 感觉\n 3、百事提醒您：挂科无极限 \n4、 森马提醒 您：考什么,挂什么\n 5、脑白金提 醒您：今年 过节不挂科,挂科只挂专业科 \n6、汇仁肾宝提醒 您：他挂我也挂 7、李宁 提醒您：挂科,一切 皆有可能\n 8、旺旺提醒 您：你挂,我挂,大家挂, 挂挂\n 9、农夫山泉 提醒您：不挂有点悬\n 10、 好迪提醒您：大 家挂，才是真的挂\n 11、白加 黑提醒您：白 天挂一科，不瞌睡；晚上再挂 一科，睡得香\n 12、联想提醒您：学生不挂 科，学校会怎么 样 \n13、娃哈哈提醒您：妈妈 ~~我也要挂 科！\n 14、清嘴提醒您：你知道挂 科的味道 吗？ \n15、安踏提醒您：我挂科，我 喜欢！\n 16、NIKE提醒您：Just 挂 it！\n 17、 钙中钙提醒您：现在的挂科啊，它含金量高， 挂一科顶过去五科，方便！你瞧我，一口气挂 上五科，不费劲！\n18、妇炎洁提醒您：挂挂更 健康！\n19、衡水老白干提醒您：挂出男人味！\n 20、肾宝提醒您：挂一科提神醒脑；挂两科永 不疲劳；挂三科长生不老。肾宝，挂科好极辽";
		textArea.setText(a);
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"添加成功");
			}
		});
		btnNewButton.setBounds(417, 405, 93, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
