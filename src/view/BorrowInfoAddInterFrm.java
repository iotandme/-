package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import dao.BookInfoDao;
import dao.BorrowInfoDao;
import model.BookInfo;
import model.BorrowInfo;
import model.LibraryCard;
import util.DbUtil;
import util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class BorrowInfoAddInterFrm extends JInternalFrame {
	
	private DbUtil dbUtil = new DbUtil();
	private BorrowInfoDao borrowInfoDao = new BorrowInfoDao();
	private BookInfoDao bookInfoDao= new BookInfoDao();
	
	private JTextField s_BookInfoBnoTxt;
	private JTextField libraryCardBorrowsnoTxt;
	private JTextField s_BookInfoBnameTxt;
	private JTable bookInfoTable;
	private JTextField bookInfoBnoTxt;
	private JTextField bookInfoBnameTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowInfoAddInterFrm frame = new BorrowInfoAddInterFrm();
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
	public BorrowInfoAddInterFrm() {
		setTitle("\u501F\u9605\u4FE1\u606F\u6DFB\u52A0");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 835, 639);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 14));
		
		s_BookInfoBnoTxt = new JTextField();
		s_BookInfoBnoTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 14));
		
		s_BookInfoBnameTxt = new JTextField();
		s_BookInfoBnameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5    \u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookInfoSearchActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnNewButton_1 = new JButton("\u63D0    \u4EA4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrowInfoAddActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(116)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_BookInfoBnoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(118)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_BookInfoBnameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(66))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(111)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE))
					.addContainerGap(111, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(347)
					.addComponent(btnNewButton_1)
					.addContainerGap(369, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_BookInfoBnoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(s_BookInfoBnameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(83)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addGap(69)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(35))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u501F\u4E66\u8BC1\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 14));
		
		libraryCardBorrowsnoTxt = new JTextField();
		libraryCardBorrowsnoTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 14));
		
		bookInfoBnoTxt = new JTextField();
		bookInfoBnoTxt.setEditable(false);
		bookInfoBnoTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 14));
		
		bookInfoBnameTxt = new JTextField();
		bookInfoBnameTxt.setEditable(false);
		bookInfoBnameTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookInfoBnoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(71)
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookInfoBnameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(5)
							.addComponent(libraryCardBorrowsnoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(195, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(bookInfoBnoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(bookInfoBnameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1))
						.addComponent(libraryCardBorrowsnoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31))
		);
		panel.setLayout(gl_panel);
		
		bookInfoTable = new JTable();
		bookInfoTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookInfoTableMousePressed(e);
			}
		});
		bookInfoTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u56FE\u4E66\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u51FA\u7248\u793E", "\u51FA\u7248\u65F6\u95F4", "\u5B58\u653E\u4F4D\u7F6E", "\u5269\u4F59\u6570\u91CF"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(bookInfoTable);
		getContentPane().setLayout(groupLayout);

		this.fillTable(new BookInfo());
	}
	
	/**
	 * 借阅信息添加处理
	 */
	private void borrowInfoAddActionPerformed(ActionEvent evt) {
		String bookInfoBno = this.bookInfoBnoTxt.getText();
		String libraryCardBorrowsno = this.libraryCardBorrowsnoTxt.getText();
		
		if(StringUtil.isEmpty(bookInfoBno)) {
			JOptionPane.showMessageDialog(null, "请选择要借的书");
			return;
		}else if(StringUtil.isEmpty(libraryCardBorrowsno)) {
			JOptionPane.showMessageDialog(null, "请输入借书证号");
			return;
		}else {
			//int a = JOptionPane.showConfirmDialog(null, "确定要添加该记录吗？");
			//if(a==0) {
			BorrowInfo borrowInfo = new BorrowInfo(bookInfoBno,libraryCardBorrowsno);
			Connection con = null;
			try {
				con = dbUtil.getCon();
				int n =borrowInfoDao.add(con, borrowInfo);
				if(n==1) {
					JOptionPane.showMessageDialog(null, "借阅信息添加成功!");
					this.fillTable(new BookInfo());
					resetValue();
				}else {
					JOptionPane.showMessageDialog(null, "添加失败1!");
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
		//}	
		}
							
		
	}

	/**
	 * 表格行点击事件处理
	 * @param e
	 */
	private void bookInfoTableMousePressed(MouseEvent evt) {
		int row = bookInfoTable.getSelectedRow();
		 bookInfoBnoTxt.setText((String)bookInfoTable.getValueAt(row, 0));
		 bookInfoBnameTxt.setText((String)bookInfoTable.getValueAt(row, 1));
		
		
	}
	
	/**
	 * 图书信息搜索事件处理
	 * @param evt
	 */
	private void bookInfoSearchActionPerformed(ActionEvent evt) {
		String  s_bookInfoBno = this.s_BookInfoBnoTxt.getText();
		String  s_bookInfoBname = this.s_BookInfoBnameTxt.getText();
		
		BookInfo bookInfo =new BookInfo();
		bookInfo.setBno(s_bookInfoBno);
		bookInfo.setBname(s_bookInfoBname);
		
		this.fillTable(bookInfo);
		
	}
	
	/**
	 * 初始化表格
	 * @param bookInfo
	 */
	public void fillTable(BookInfo bookInfo) {
		DefaultTableModel dtm = (DefaultTableModel) bookInfoTable.getModel();
		dtm.setRowCount(0);//设置成0行
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookInfoDao.list(con, bookInfo);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getString("Bno"));
				v.add(rs.getString("Bname"));
				v.add(rs.getString("Bpress"));
				v.add(rs.getString("Btime"));
				v.add(rs.getString("Bloca"));
				v.add(rs.getString("Bnum"));
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
		this.bookInfoBnoTxt.setText("");
		this.bookInfoBnameTxt.setText("");
		this.libraryCardBorrowsnoTxt.setText("");
		this.s_BookInfoBnoTxt.setText("");
		this.s_BookInfoBnameTxt.setText("");
		
		
	}
}
