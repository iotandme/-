package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import dao.UserDao;
import model.User;
import util.DbUtil;
import util.StringUtil;

public class LogOnFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private UserDao userDao=new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnFrm frame = new LogOnFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogOnFrm() {
		setResizable(false);
		setTitle("\u7BA1\u7406\u5458\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u9986\u501F\u9605\u5B50\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("华文仿宋", Font.BOLD, 30));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 15));
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6 \u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 15));
		
		userNameTxt = new JTextField(); 
		userNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 15));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restValueActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 15));
		
		passwordTxt = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(213, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_1))
							.addGap(23)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnNewButton_1))
								.addComponent(passwordTxt)
								.addComponent(userNameTxt, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
							.addGap(281))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(271))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(66)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(99)
							.addComponent(lblNewLabel_1))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
							.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(83)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addContainerGap(90, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		//设置JFrame居中显示
		this.setLocationRelativeTo(null);
	}
	/**
	 * 登录事件处理
	 * @param e
	 */
private void loginActionPerformed(ActionEvent evt) {
		String userName = this.userNameTxt.getText();
		String password =  new String(this.passwordTxt.getPassword());
		if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null,"用户名不能为空");
			return;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null,"密码不能为空");
			return;
		}
		User user = new User(userName,password);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			User currentUser = userDao.login(con, user);
			if(currentUser!=null) {
				//JOptionPane.showMessageDialog(null,"登录成功");
				dispose();//销毁当前窗口
				new MainFrm().setVisible(true);//显示MainFrm
			}
			else {
				JOptionPane.showMessageDialog(null,"用户名或密码错误");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

/**
 * 重置事件处理
 * @param e
 */
	private void restValueActionPerformed(ActionEvent evt) {
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
		
	}
}
