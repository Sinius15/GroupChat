package com.sinius15.chatter;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChatFrame extends JFrame {

	private static final long serialVersionUID = -8462915185217605133L;
	private JPanel contentPane;
	private JTextField textField;

	private ChatFrame thiss = this;
	
	public ChatFrame() {
		setTitle("Simple Chatter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnConnection = new JMenu("Connection");
		menuBar.add(mnConnection);
		
		JMenuItem mntmConnect = new JMenuItem("Connect...");
		mnConnection.add(mntmConnect);
		
		JMenuItem mntmCreateNewChat = new JMenuItem("Create New...");
		mnConnection.add(mntmCreateNewChat);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmStatus = new JMenuItem("Status");
		mntmStatus.addActionListener(statusAction);
		mnHelp.add(mntmStatus);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		ChatArea chatArea = new ChatArea();
		contentPane.add(chatArea, BorderLayout.CENTER);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
	}
	
	private ActionListener statusAction = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(thiss, Chatter.getStatusInfo(), "Status", JOptionPane.INFORMATION_MESSAGE);
		}
	};
	
}
