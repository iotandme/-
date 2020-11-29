package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.LibraryCardDao;
import model.BookInfo;
import model.LibraryCard;
import util.DbUtil;
import util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LibraryCardManageInterFrm extends JInternalFrame {
	private JTable libraryCardTable;
	private JTextField s_LibraryCardBorrowsnoTxt;
	private JTextField s_LibraryCardSnameTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private LibraryCardDao libraryCardDao = new LibraryCardDao();
	private JTextField libraryCardBorrowsnoTxt;
	private JTextField libraryCardSnameTxt;
	private JTextField libraryCardSdeTxt;
	private JTextField libraryCardSspTxt;
	private JTextField libraryCardBorrowMaxTxt;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryCardManageInterFrm frame = new LibraryCardManageInterFrm();
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
	public LibraryCardManageInterFrm() {
		setTitle("\u501F\u4E66\u8BC1\u4FE1\u606F\u7BA1\u7406");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 815, 629);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u501F\u4E66\u8BC1\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 14));
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3   \u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 14));
		
		s_LibraryCardBorrowsnoTxt = new JTextField();
		s_LibraryCardBorrowsnoTxt.setColumns(10);
		
		s_LibraryCardSnameTxt = new JTextField();
		s_LibraryCardSnameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5    \u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				libraryCardSearchActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 14));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(176)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_1)
								.addGap(18)
								.addComponent(s_LibraryCardSnameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(141)
								.addComponent(btnNewButton))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(s_LibraryCardBorrowsnoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)))
					.addContainerGap(176, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(71)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_LibraryCardBorrowsnoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(btnNewButton)
						.addComponent(s_LibraryCardSnameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_2 = new JLabel("\u501F\u4E66\u8BC1\u53F7\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 14));
		
		libraryCardBorrowsnoTxt = new JTextField();
		libraryCardBorrowsnoTxt.setEditable(false);
		libraryCardBorrowsnoTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u59D3    \u540D\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 14));
		
		libraryCardSnameTxt = new JTextField();
		libraryCardSnameTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u7CFB    \u522B\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 14));
		
		libraryCardSdeTxt = new JTextField();
		libraryCardSdeTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u4E13    \u4E1A\uFF1A");
		lblNewLabel_5.setFont(new Font("宋体", Font.BOLD, 14));
		
		libraryCardSspTxt = new JTextField();
		libraryCardSspTxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u501F\u4E66\u4E0A\u9650\uFF1A");
		lblNewLabel_6.setFont(new Font("宋体", Font.BOLD, 14));
		
		libraryCardBorrowMaxTxt = new JTextField();
		libraryCardBorrowMaxTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u4FEE    \u6539");
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				libraryCardUpdateActionEvent(e);
			}
		});
		
		JButton btnNewButton_2 = new JButton("\u5220    \u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				libraryCardDeleteActionEvent(e);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_4))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(libraryCardBorrowsnoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(libraryCardSdeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(37)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(libraryCardSnameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(libraryCardSspTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton_1)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(libraryCardBorrowMaxTxt, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton_2)))
					.addContainerGap(74, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(libraryCardBorrowsnoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(libraryCardSnameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(libraryCardSdeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(libraryCardSspTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(libraryCardBorrowMaxTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		libraryCardTable = new JTable();
		libraryCardTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				libraryCardTableMousePressed(e);
			}
		});
		libraryCardTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u501F\u4E66\u8BC1\u53F7", "\u7CFB\u522B", "\u4E13\u4E1A", "\u59D3\u540D", "\u501F\u4E66\u4E0A\u9650"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(libraryCardTable);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new LibraryCard());
	}
	
	/**
	 * 借书证信息删除事件处理
	 * @param evt
	 */
	private void libraryCardDeleteActionEvent(ActionEvent evt) {
		String libraryCardBorrowsno = libraryCardBorrowsnoTxt.getText();
		if(StringUtil.isEmpty(libraryCardBorrowsno)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if(n==0) {
			Connection con = null;
			try {
				con = dbUtil.getCon();
				int deleteNum = libraryCardDao.delete(con, libraryCardBorrowsno);
				if(deleteNum == 1)
				{
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new LibraryCard());
				}else {
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败");
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
	 * 借书证信息修改事件处理
	 * @param evt
	 */
	private  void libraryCardUpdateActionEvent(ActionEvent evt) {
		String libraryCardBorrowsno = libraryCardBorrowsnoTxt.getText();
		String libraryCardSde = libraryCardSdeTxt.getText();
		String libraryCardSsp = libraryCardSspTxt.getText();
		String libraryCardSname = libraryCardSnameTxt.getText();
		String libraryCardBorrowMax = libraryCardBorrowMaxTxt.getText();
		
		if(StringUtil.isEmpty(libraryCardBorrowsno)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		if(StringUtil.isEmpty(libraryCardSname)) {
			JOptionPane.showMessageDialog(null, "请输入姓名");
			return;
		}
		if(StringUtil.isEmpty(libraryCardBorrowMax)) {
			JOptionPane.showMessageDialog(null, "请输入可借图书上限");
			return;
		}
		LibraryCard libraryCard =new LibraryCard(libraryCardBorrowsno,libraryCardSde,libraryCardSsp,libraryCardSname,Integer.parseInt(libraryCardBorrowMax));
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int modifyNum = libraryCardDao.update(con, libraryCard);
			if(modifyNum==1) {
				JOptionPane.showMessageDialog(null, "修改成功");
				this.resetValue();
				this.fillTable(new LibraryCard());
			}else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改失败");
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
	 * 表格行点击处理事件
	 * @param evt
	 */
	private void libraryCardTableMousePressed(MouseEvent evt) {
		int row = libraryCardTable.getSelectedRow();
		 libraryCardBorrowsnoTxt.setText((String)libraryCardTable.getValueAt(row, 0));
		 libraryCardSdeTxt.setText((String)libraryCardTable.getValueAt(row, 1));
		 libraryCardSspTxt.setText((String)libraryCardTable.getValueAt(row, 2));
		 libraryCardSnameTxt.setText((String)libraryCardTable.getValueAt(row, 3));
		 libraryCardBorrowMaxTxt .setText((String)libraryCardTable.getValueAt(row, 4));
		
	}

	/**
	 * 借书证信息搜索事件处理
	 * @param e
	 */
	protected void libraryCardSearchActionPerformed(ActionEvent evt) {
		String  s_LibraryCardBorrowsno = this.s_LibraryCardBorrowsnoTxt.getText();
		String  s_LibraryCardSname = this.s_LibraryCardSnameTxt.getText();
		
		LibraryCard libraryCard =new LibraryCard();
		libraryCard.setBorrowsno(s_LibraryCardBorrowsno);
		libraryCard.setSname(s_LibraryCardSname);
		
		this.fillTable(libraryCard);
		
		
	}

	/**
	 * 表格初始化
	 * @param bookInfo
	 */
	public void fillTable(LibraryCard libraryCard) {
		DefaultTableModel dtm = (DefaultTableModel) libraryCardTable.getModel();
		dtm.setRowCount(0);//设置成0行
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = libraryCardDao.list(con, libraryCard);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getString("Borrowsno"));
				v.add(rs.getString("Sde"));
				v.add(rs.getString("Ssp"));
				v.add(rs.getString("Sname"));
				v.add(rs.getString("BorrowMax"));
				dtm.addRow(v);
			}
		}catch(Exception e){
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
	 * 重置表单
	 */
	private void resetValue() {
		this.libraryCardBorrowsnoTxt.setText("");
		this.libraryCardSdeTxt.setText("");
		this.libraryCardSspTxt.setText("");
		this.libraryCardSnameTxt.setText("");
		this.libraryCardBorrowMaxTxt.setText("");
		
	}

}
