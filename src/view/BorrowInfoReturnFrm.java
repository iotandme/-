package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.BorrowInfoDao;
import model.BookInfo;
import model.BorrowInfo;
import util.DbUtil;
import util.StringUtil;

import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class BorrowInfoReturnFrm extends JInternalFrame {
	
	private DbUtil dbUtil = new DbUtil();
	private BorrowInfoDao borrowInfoDao = new BorrowInfoDao();
	
	private JTextField s_BnoTxt;
	private JTextField s_BorrowsnoTxt;
	private JTable BorrowInfoTable;
	private JTextField bnoTxt;
	private JTextField borrowsnoTxt;
	private JTextField borrowTimeTxt;
	private JTextField FineTxt;
	private JTextField returnTimeTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowInfoReturnFrm frame = new BorrowInfoReturnFrm();
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
	public BorrowInfoReturnFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u56FE\u4E66\u5F52\u8FD8\u754C\u9762");
		setBounds(100, 100, 904, 604);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 14));
		
		s_BnoTxt = new JTextField();
		s_BnoTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u501F\u4E66\u8BC1\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 14));
		
		s_BorrowsnoTxt = new JTextField();
		s_BorrowsnoTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5    \u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrowInfoSearchActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(83)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(s_BnoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(154)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(s_BorrowsnoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
							.addComponent(btnNewButton)))
					.addGap(90))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_BnoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(s_BorrowsnoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(35)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 14));
		
		bnoTxt = new JTextField();
		bnoTxt.setEditable(false);
		bnoTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u501F\u4E66\u8BC1\u53F7\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 14));
		
		borrowsnoTxt = new JTextField();
		borrowsnoTxt.setEditable(false);
		borrowsnoTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u501F\u9605\u65F6\u95F4\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 14));
		
		borrowTimeTxt = new JTextField();
		borrowTimeTxt.setEditable(false);
		borrowTimeTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u5F52\u8FD8\u56FE\u4E66");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrowInfoReturnActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 14));
		
		JLabel lblNewLabel_5 = new JLabel("\u7F5A\u6B3E\u91D1\u989D\uFF1A");
		lblNewLabel_5.setFont(new Font("宋体", Font.BOLD, 14));
		
		FineTxt = new JTextField();
		FineTxt.setEditable(false);
		FineTxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u5F52\u8FD8\u65F6\u95F4\uFF1A");
		lblNewLabel_6.setFont(new Font("宋体", Font.BOLD, 14));
		
		returnTimeTxt = new JTextField();
		returnTimeTxt.setEditable(false);
		returnTimeTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bnoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(borrowTimeTxt, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
							.addGap(68)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(borrowsnoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(28)
									.addComponent(lblNewLabel_6)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(returnTimeTxt, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(FineTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(256)
							.addComponent(btnNewButton_1)))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(bnoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(borrowsnoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6)
						.addComponent(returnTimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(borrowTimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(FineTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		BorrowInfoTable = new JTable();
		BorrowInfoTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				borrowInfoTableMousePressed(e);
			}
		});
		BorrowInfoTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u56FE\u4E66\u7F16\u53F7", "\u501F\u9605\u65F6\u95F4", "\u501F\u4E66\u8BC1\u53F7", "\u5F52\u8FD8\u65F6\u95F4", "\u5230\u671F\u65F6\u95F4", "\u8D85\u671F\u5929\u6570", "\u7F5A\u6B3E\u91D1\u989D"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(BorrowInfoTable);
		getContentPane().setLayout(groupLayout);

		this.fillTable(new BorrowInfo());
	}

	

	/**
	 * 图书归还事件处理
	 * @param evt
	 */
	private void borrowInfoReturnActionPerformed(ActionEvent evt) {
		String bookInfoBno = this.bnoTxt.getText();
		String borrowsno = this.borrowsnoTxt.getText();
		String borrowTime=this.borrowTimeTxt.getText();
		String money = this.FineTxt.getText();
		String returnTime = this.returnTimeTxt.getText();
		
		if(StringUtil.isEmpty(borrowsno)) {
			JOptionPane.showMessageDialog(null, "请选择要归还的记录");
			return;
		}
		if(StringUtil.isNoEmpty(returnTime)) {
			JOptionPane.showMessageDialog(null, "该书已还");
			resetValue();
			return;
		}
		BorrowInfo borrowInfo  = new BorrowInfo(bookInfoBno,borrowTime,borrowsno);
		Connection con = null;
		if(StringUtil.isEmpty(money)) {
			try {
				con = dbUtil.getCon();
				int modifyNum = borrowInfoDao.returnbook(con, borrowInfo);
				if(modifyNum ==1) {
					JOptionPane.showMessageDialog(null, "归还成功");
					this.resetValue();
					this.fillTable(new BorrowInfo());
				}else {
					JOptionPane.showMessageDialog(null, "归还失败");
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else {
			int a = JOptionPane.showConfirmDialog(null, "是否缴清罚款");
			if(a==0) {
				try {
					con = dbUtil.getCon();
					int modifyNum = borrowInfoDao.returnbook(con, borrowInfo);
					if(modifyNum ==1) {
						JOptionPane.showMessageDialog(null, "归还成功");
						this.resetValue();
						this.fillTable(new BorrowInfo());
					}else {
						JOptionPane.showMessageDialog(null, "归还失败");
					}
					
				}catch(Exception e) {
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
		}
			
			
		
		
		
	}

	/**
	 * 表格行点击事件处理
	 * @param e
	 */
	private void borrowInfoTableMousePressed(MouseEvent evt) {
		int row = BorrowInfoTable.getSelectedRow();
		 bnoTxt.setText((String)BorrowInfoTable.getValueAt(row, 0));
		 borrowTimeTxt.setText((String)BorrowInfoTable.getValueAt(row, 1));
		 borrowsnoTxt.setText((String)BorrowInfoTable.getValueAt(row, 2));
		 returnTimeTxt.setText((String)BorrowInfoTable.getValueAt(row, 3));
		 FineTxt.setText((String)BorrowInfoTable.getValueAt(row, 6));
		
	}
	
	/**
	 * 借阅信息搜索事件处理
	 * @param evt
	 */
	private void borrowInfoSearchActionPerformed(ActionEvent evt) {
		String  s_Bno = this.s_BnoTxt.getText();
		String  s_Borrowsno = this.s_BorrowsnoTxt.getText();
		
		BorrowInfo borrowInfo =new BorrowInfo();
		borrowInfo.setBno(s_Bno);
		borrowInfo.setBorrowsno(s_Borrowsno);
		
		this.fillTable(borrowInfo);
		
	}
	
	
	/**
	 * 初始化表格
	 * @param borrowInfo
	 */
	public void fillTable(BorrowInfo  borrowInfo) {
		DefaultTableModel dtm = (DefaultTableModel) BorrowInfoTable.getModel();
		dtm.setRowCount(0);//设置成0行
		Connection con = null;
		try {
			con = dbUtil.getCon();
			borrowInfoDao.update(con);
			ResultSet rs = borrowInfoDao.list(con, borrowInfo);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getString("Bno"));
				v.add(rs.getString("Borrowtime"));
				v.add(rs.getString("Borrowsno"));
				v.add(rs.getString("Rturntime"));
				v.add(rs.getString("Expiretime"));
				v.add(rs.getString("Overduetime"));
				v.add(rs.getString("Fine"));
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
		this.bnoTxt.setText("");
		this.borrowsnoTxt.setText("");
		this.borrowTimeTxt.setText("");
		this.FineTxt.setText("");
		this.returnTimeTxt.setText("");
		this.s_BnoTxt.setText("");
		this.s_BorrowsnoTxt.setText("");
		
		
	}
}
