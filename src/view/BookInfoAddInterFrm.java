package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.BookInfoDao;
import model.BookInfo;
import util.DbUtil;
import util.StringUtil;

public class BookInfoAddInterFrm extends JInternalFrame {
	private JTextField BookInfoBnoTxt;
	private JTextField BookInfoBnameTxt;
	private JTextField BookInfoBpressTxt;
	private JTextField BookInfoBtimeTxt;
	private JTextField BookInfoBlocaTxt;
	private JTextField BookInfoBnumTxt;

	private DbUtil dbUtil = new DbUtil();
	private BookInfoDao bookInfoDao= new BookInfoDao();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookInfoAddInterFrm frame = new BookInfoAddInterFrm();
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
	public BookInfoAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u4FE1\u606F\u6DFB\u52A0");
		setBounds(100, 100, 647, 437);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 15));
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 15));
		
		JLabel lblNewLabel_2 = new JLabel("\u51FA \u7248 \u793E\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 15));
		
		JLabel lblNewLabel_3 = new JLabel("\u51FA\u7248\u65E5\u671F\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 15));
		
		JLabel lblNewLabel_4 = new JLabel("\u5B58\u653E\u4F4D\u7F6E\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 15));
		
		JLabel lblNewLabel_5 = new JLabel("\u6570    \u91CF\uFF1A");
		lblNewLabel_5.setFont(new Font("宋体", Font.BOLD, 15));
		
		BookInfoBnoTxt = new JTextField();
		BookInfoBnoTxt.setColumns(10);
		
		BookInfoBnameTxt = new JTextField();
		BookInfoBnameTxt.setColumns(10);
		
		BookInfoBpressTxt = new JTextField();
		BookInfoBpressTxt.setColumns(10);
		
		BookInfoBtimeTxt = new JTextField();
		BookInfoBtimeTxt.setColumns(10);
		
		BookInfoBlocaTxt = new JTextField();
		BookInfoBlocaTxt.setColumns(10);
		
		BookInfoBnumTxt = new JTextField();
		BookInfoBnumTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6DFB   \u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookInfoAddActionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u91CD  \u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerforme(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(88)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addGap(18)
							.addComponent(BookInfoBtimeTxt, 167, 167, 167))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(BookInfoBnoTxt, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(BookInfoBnameTxt, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
								.addComponent(BookInfoBpressTxt, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_5))
							.addGap(14)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnNewButton))
								.addComponent(BookInfoBlocaTxt, 167, 167, Short.MAX_VALUE)
								.addComponent(BookInfoBnumTxt))))
					.addGap(11)
					.addComponent(btnNewButton_1)
					.addGap(192))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(BookInfoBnoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(BookInfoBnameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(BookInfoBpressTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(BookInfoBtimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(BookInfoBlocaTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(BookInfoBnumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
	
	/**
	 * 图书信息添加事件处理
	 */
	private void bookInfoAddActionPerformed(ActionEvent evt) {
		String bookInforBno = this.BookInfoBnoTxt.getText();
		String bookInfoBname = this.BookInfoBnameTxt.getText();
		String bookInfoBpress=this.BookInfoBpressTxt.getText();
		String bookInfoBtime=this.BookInfoBtimeTxt.getText();
		String bookInfoBloca=this.BookInfoBlocaTxt.getText();
		String bookInfoBnum=this.BookInfoBnumTxt.getText();
		

		
		if(StringUtil.isEmpty(bookInforBno)) {
			JOptionPane.showMessageDialog(null, "图书编号不能为空!");
			return;
		}else if(StringUtil.isEmpty(bookInfoBname)) {
			JOptionPane.showMessageDialog(null, "图书名不能为空!");
			return;
		}
		else if(StringUtil.isEmpty(bookInfoBnum)){
			JOptionPane.showMessageDialog(null, "图书数量不能为空!");
			return;
		}else {
			int a = Integer.parseInt(bookInfoBnum);
			BookInfo bookInfo = new BookInfo(bookInforBno,bookInfoBname,bookInfoBpress,bookInfoBtime,bookInfoBloca,a);
			Connection con = null;
			try {
				con = dbUtil.getCon();
				int n =bookInfoDao.add(con, bookInfo);
				if(n==1) {
					JOptionPane.showMessageDialog(null, "图书信息添加成功!");
					resetValue();
				}else {
					JOptionPane.showMessageDialog(null, "添加失败!");
				}
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "添加失败!");
			}finally {
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 重置事件处理
	 * @param evt
	 */
	private void resetValueActionPerforme(ActionEvent evt) {
		this.resetValue();
		
	}

	/**
	 * 重置表单
	 */
	private void resetValue() {
		this.BookInfoBnoTxt.setText("");
		this.BookInfoBnameTxt.setText("");
		this.BookInfoBpressTxt.setText("");
		this.BookInfoBtimeTxt.setText("");
		this.BookInfoBlocaTxt.setText("");
		this.BookInfoBnumTxt.setText("");
	}
	
}
