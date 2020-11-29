package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.BookInfoDao;
import dao.LibraryCardDao;
import model.BookInfo;
import model.LibraryCard;
import util.DbUtil;
import util.StringUtil;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class LibraryCardAddInterFrm extends JInternalFrame {
	private JTextField LibraryCardBorrowsnoTxt;
	private JTextField LibraryCardSdeTxt;
	private JTextField LibraryCardSspTxt;
	private JTextField LibraryCardSnameTxt;
	private JTextField LibraryCardBorrowMaxTxt;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	
	private DbUtil dbUtil = new DbUtil();
	private LibraryCardDao libraryCardDao = new LibraryCardDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryCardAddInterFrm frame = new LibraryCardAddInterFrm();
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
	public LibraryCardAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u501F\u4E66\u8BC1\u4FE1\u606F\u6DFB\u52A0");
		setBounds(100, 100, 735, 522);
		
		JLabel lblNewLabel = new JLabel("\u501F\u4E66\u8BC1\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 15));
		
		JLabel lblNewLabel_1 = new JLabel("\u7CFB    \u522B\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 15));
		
		JLabel lblNewLabel_2 = new JLabel("\u4E13    \u4E1A\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 15));
		
		JLabel lblNewLabel_3 = new JLabel("\u59D3    \u540D\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 15));
		
		JLabel lblNewLabel_4 = new JLabel("\u501F\u4E66\u4E0A\u9650\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 15));
		
		LibraryCardBorrowsnoTxt = new JTextField();
		LibraryCardBorrowsnoTxt.setColumns(10);
		
		LibraryCardSdeTxt = new JTextField();
		LibraryCardSdeTxt.setColumns(10);
		
		LibraryCardSspTxt = new JTextField();
		LibraryCardSspTxt.setColumns(10);
		
		LibraryCardSnameTxt = new JTextField();
		LibraryCardSnameTxt.setColumns(10);
		
		LibraryCardBorrowMaxTxt = new JTextField();
		LibraryCardBorrowMaxTxt.setColumns(10);
		
		btnNewButton = new JButton("\u63D0    \u4EA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				libraryCardAddActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 15));
		
		btnNewButton_1 = new JButton("\u91CD    \u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerforme(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(122)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(91)
							.addComponent(btnNewButton_1))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(LibraryCardBorrowsnoTxt, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(LibraryCardSdeTxt, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(LibraryCardSspTxt, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(LibraryCardSnameTxt, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(LibraryCardBorrowMaxTxt, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(204, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(71)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(LibraryCardBorrowsnoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(LibraryCardSdeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(LibraryCardSspTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(LibraryCardSnameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(LibraryCardBorrowMaxTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(79)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
	
	/**
	 * 借书证信息添加处理事件
	 * @param e
	 */
	protected void libraryCardAddActionPerformed(ActionEvent evt) {

		String libraryCardBorrowsno = this.LibraryCardBorrowsnoTxt.getText();
		String libraryCardSde = this.LibraryCardSdeTxt.getText();
		String libraryCardSsp=this.LibraryCardSspTxt.getText();
		String libraryCardSname=this.LibraryCardSnameTxt.getText();
		String libraryCardBorrowMax=this.LibraryCardBorrowMaxTxt.getText();
		
		

		
		if(StringUtil.isEmpty(libraryCardBorrowsno)) {
			JOptionPane.showMessageDialog(null, "借书证编号不能为空!");
			return;
		}else if(StringUtil.isEmpty(libraryCardBorrowMax)) {
			JOptionPane.showMessageDialog(null, "借书上限不能为空!");
			return;
		}else {
			int a = Integer.parseInt(libraryCardBorrowMax);
			LibraryCard libraryCard = new LibraryCard(libraryCardBorrowsno,libraryCardSde,libraryCardSsp,libraryCardSname,a);
			Connection con = null;
			try {
				con = dbUtil.getCon();
				int n =libraryCardDao.add(con, libraryCard);
				if(n==1) {
					JOptionPane.showMessageDialog(null, "借书证信息添加成功!");
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
		this.LibraryCardBorrowsnoTxt .setText("");
		this.LibraryCardSdeTxt.setText("");
		this.LibraryCardSspTxt.setText("");
		this.LibraryCardSnameTxt.setText("");
		this.LibraryCardBorrowMaxTxt.setText("");
	}

}
