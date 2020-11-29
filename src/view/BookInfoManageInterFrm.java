package view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.BookInfoDao;
import model.BookInfo;
import util.DbUtil;
import util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookInfoManageInterFrm extends JInternalFrame {
	private JTable bookInfoTable;
	
	private DbUtil dbUtil = new DbUtil();
	private BookInfoDao bookInfoDao= new BookInfoDao();
	private JTextField s_bookInfoBnoTxt;
	private JTextField s_bookInfoBnameTxt;
	private JTextField bookInfoBnoTxt;
	private JTextField bookInfoBnameTxt;
	private JTextField bookInfoBpressTxt;
	private JTextField bookInfoBtimeTxt;
	private JTextField bookInfoBlocaTxt;
	private JTextField bookInfoBnumTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookInfoManageInterFrm frame = new BookInfoManageInterFrm();
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
	public BookInfoManageInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 846, 639);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 14));
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		
		s_bookInfoBnoTxt = new JTextField();
		s_bookInfoBnoTxt.setColumns(10);
		
		s_bookInfoBnameTxt = new JTextField();
		s_bookInfoBnameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5    \u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookInfoSearchActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 14));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(153)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(s_bookInfoBnoTxt))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(s_bookInfoBnameTxt, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))
							.addGap(156)
							.addComponent(btnNewButton)))
					.addContainerGap(152, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_bookInfoBnoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(s_bookInfoBnameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(44)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 14));
		
		bookInfoBnoTxt = new JTextField();
		bookInfoBnoTxt.setEditable(false);
		bookInfoBnoTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 14));
		
		bookInfoBnameTxt = new JTextField();
		bookInfoBnameTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u51FA \u7248 \u793E\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 14));
		
		bookInfoBpressTxt = new JTextField();
		bookInfoBpressTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u51FA\u7248\u65E5\u671F\uFF1A");
		lblNewLabel_5.setFont(new Font("宋体", Font.BOLD, 14));
		
		bookInfoBtimeTxt = new JTextField();
		bookInfoBtimeTxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u5B58\u653E\u4F4D\u7F6E\uFF1A");
		lblNewLabel_6.setFont(new Font("宋体", Font.BOLD, 14));
		
		bookInfoBlocaTxt = new JTextField();
		bookInfoBlocaTxt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u5269\u4F59\u6570\u91CF\uFF1A");
		lblNewLabel_7.setFont(new Font("宋体", Font.BOLD, 14));
		
		bookInfoBnumTxt = new JTextField();
		bookInfoBnumTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u4FEE   \u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookInfoUpdateActionEvent(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 14));
		
		JButton btnNewButton_2 = new JButton("\u5220   \u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookInfoDeleteActionEvent(e);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton_1)
							.addGap(18))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel_2)
									.addComponent(lblNewLabel_4))
								.addComponent(lblNewLabel_6))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(bookInfoBlocaTxt)
								.addComponent(bookInfoBnoTxt)
								.addComponent(bookInfoBpressTxt))))
					.addGap(34)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblNewLabel_3)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(bookInfoBnameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblNewLabel_5)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(bookInfoBtimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnNewButton_2, Alignment.TRAILING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_7)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookInfoBnumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addContainerGap(108, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(bookInfoBnoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(bookInfoBnameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(bookInfoBpressTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_5)
							.addComponent(bookInfoBtimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_7)
							.addComponent(bookInfoBnumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(bookInfoBlocaTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_6)))
					.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_1))
					.addGap(34))
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
				"\u56FE\u4E66\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u51FA\u7248\u793E", "\u51FA\u7248\u65E5\u671F", "\u5B58\u653E\u4F4D\u7F6E", "\u5269\u4F59\u5728\u9986\u6570\u91CF"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookInfoTable.getColumnModel().getColumn(2).setPreferredWidth(91);
		bookInfoTable.getColumnModel().getColumn(5).setPreferredWidth(96);
		scrollPane.setViewportView(bookInfoTable);
		getContentPane().setLayout(groupLayout);

		this.fillTable(new BookInfo());
	}
	
	/**
	 * 图书信息删除事件处理
	 * @param e
	 */
	protected void bookInfoDeleteActionEvent(ActionEvent evt) {
		String bookInfoBno = bookInfoBnoTxt.getText();
		if(StringUtil.isEmpty(bookInfoBno)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if(n==0) {
			Connection con = null;
			try {
				con = dbUtil.getCon();
				int deleteNum = bookInfoDao.delete(con, bookInfoBno);
				if(deleteNum == 1)
				{
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new BookInfo());
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
	 * 图书信息修改事件处理
	 * @param evt
	 */
	private void bookInfoUpdateActionEvent(ActionEvent evt) {
		String bookInfoBno = bookInfoBnoTxt.getText();
		String bookInfoBname = bookInfoBnameTxt.getText();
		String bookInfoBpress = bookInfoBpressTxt.getText();
		String bookInfoBtime = bookInfoBtimeTxt.getText();
		String bookInfoBloca = bookInfoBlocaTxt.getText();
		String bookInfoBnum = bookInfoBnumTxt.getText();
		
		if(StringUtil.isEmpty(bookInfoBno)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		if(StringUtil.isEmpty(bookInfoBname)) {
			JOptionPane.showMessageDialog(null, "请输入图书名称");
			return;
		}
		if(StringUtil.isEmpty(bookInfoBnum)) {
			JOptionPane.showMessageDialog(null, "请输入图书数量");
			return;
		}
		BookInfo bookInfo =new BookInfo(bookInfoBno,bookInfoBname,bookInfoBpress,bookInfoBtime,bookInfoBloca,Integer.parseInt(bookInfoBnum));
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int modifyNum = bookInfoDao.update(con, bookInfo);
			if(modifyNum==1) {
				JOptionPane.showMessageDialog(null, "修改成功");
				this.resetValue();
				this.fillTable(new BookInfo());
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
	 * 表格行点击事件处理
	 * @param e
	 */
	private void bookInfoTableMousePressed(MouseEvent evt) {
		int row = bookInfoTable.getSelectedRow();
		 bookInfoBnoTxt.setText((String)bookInfoTable.getValueAt(row, 0));
		 bookInfoBnameTxt.setText((String)bookInfoTable.getValueAt(row, 1));
		 bookInfoBpressTxt.setText((String)bookInfoTable.getValueAt(row, 2));
		 bookInfoBtimeTxt.setText((String)bookInfoTable.getValueAt(row, 3));
		 bookInfoBlocaTxt .setText((String)bookInfoTable.getValueAt(row, 4));
		 bookInfoBnumTxt.setText((String)bookInfoTable.getValueAt(row, 5));
		
	}

	/**
	 * 图书信息搜索事件处理
	 * @param evt
	 */
	private void bookInfoSearchActionPerformed(ActionEvent evt) {
		String  s_bookInfoBno = this.s_bookInfoBnoTxt.getText();
		String  s_bookInfoBname = this.s_bookInfoBnameTxt.getText();
		
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
		this.bookInfoBpressTxt.setText("");
		this.bookInfoBtimeTxt.setText("");
		this.bookInfoBlocaTxt.setText("");
		this.bookInfoBnumTxt.setText("");
		
	}
}
