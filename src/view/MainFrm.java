package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setTitle("\u56FE\u4E66\u501F\u9605\u5B50\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 417);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u57FA\u672C\u529F\u80FD");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_3 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		mnNewMenu.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookInfoAddInterFrm bookInfoAddInterFrm = new BookInfoAddInterFrm();
				bookInfoAddInterFrm.setVisible(true);
				table.add(bookInfoAddInterFrm);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookInfoManageInterFrm bookInfoManageInterFrm = new BookInfoManageInterFrm();
				bookInfoManageInterFrm.setVisible(true);
				table.add(bookInfoManageInterFrm);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否退出系统");
				//System.out.println(result);
				if(result == 0) {
					dispose();
				}
			}
		});
		
		JMenu mnNewMenu_4 = new JMenu("\u56FE\u4E66\u501F\u9605\u7BA1\u7406");
		mnNewMenu.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u501F\u4E66");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorrowInfoAddInterFrm borrowInfoAddInterFrm = new BorrowInfoAddInterFrm();
				borrowInfoAddInterFrm.setVisible(true);
				table.add(borrowInfoAddInterFrm);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("\u8FD8\u4E66");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorrowInfoReturnFrm borrowInfoReturnFrm = new BorrowInfoReturnFrm();
				borrowInfoReturnFrm.setVisible(true);
				table.add(borrowInfoReturnFrm);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_5 = new JMenu("\u501F\u4E66\u8BC1\u4FE1\u606F\u7BA1\u7406");
		mnNewMenu.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("\u501F\u4E66\u8BC1\u4FE1\u606F\u6DFB\u52A0");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibraryCardAddInterFrm libraryCardAddInterFrm = new LibraryCardAddInterFrm();
				libraryCardAddInterFrm.setVisible(true);
				table.add(libraryCardAddInterFrm);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("\u501F\u4E66\u8BC1\u4FE1\u606F\u7EF4\u62A4");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibraryCardManageInterFrm libraryCardManageInterFrm = new LibraryCardManageInterFrm();
				libraryCardManageInterFrm.setVisible(true);
				table.add(libraryCardManageInterFrm);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_9);
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u5173\u4E8E18207217");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NterFrm nterFrm = new NterFrm();
				nterFrm.setVisible(true);
				table.add(nterFrm);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		 table = new JDesktopPane();
		 table.setBackground(Color.LIGHT_GRAY);
		contentPane.add(table, BorderLayout.CENTER);
		
		//设置JFrame最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
