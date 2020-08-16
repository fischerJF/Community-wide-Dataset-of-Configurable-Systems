package atm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import specifications.Configuration;

public class ATMUserInterface extends JFrame {

	public static final String JANELA_TITULO = "ATM";
	public static final int JANELA_LARGURA = 900;
	public static final int JANELA_ALTURA = 800;
	public static final Color JANELA_COR_FUNDO = Color.WHITE;
	public static final Color WINDOWS_COLOR_TEXT = new Color(0, 125, 0);
	public static final String HEADER_TITLE = "ATM";
	public static final ImageIcon HEADER_IMG = new ImageIcon("img/dollar.png");
	public static final Color CAIXA_TEXTO_COR_FUNDO = new Color(185, 255, 185);
	public static final ImageIcon LOCK_BUTTON_IMG = new ImageIcon("img/lock.png");
	public static final ImageIcon BALANCE_BUTTON_IMG = new ImageIcon("img/balance.png");
	public static final ImageIcon DEPOSIT_BUTTON_IMG = new ImageIcon("img/deposit.png");
	public static final ImageIcon WITHDRAW_BUTTON_IMG = new ImageIcon("img/withdraw.png");
	public static final ImageIcon LOG_BUTTON_IMG = new ImageIcon("img/log.png");
	public static final ImageIcon LOGOUT_BUTTN = new ImageIcon("img/botaoSair.png");
	private static final ImageIcon OFF_BUTTON_IMG = new ImageIcon("img/off.png");
	private static final ImageIcon TOTALMONEY_BUTTON_IMG = new ImageIcon("img/Totalmoney.png");
	private static final ImageIcon DOLAR_BUTTON_IMG = new ImageIcon("img/dollar__.png");
	public static final Color BACKGROUND_BUTTON = Color.WHITE;
	public static final Color BACKGROUND_BUTTON_DOLLAR = new Color(143, 188, 143);

	private JTextArea lbReturn;
	public String msg = "";
	private JTextArea textArea;
	private JPanel pnMedium;
	private JPanel pnMedium2;
	private JTextField tfLoggin;
	private JTextField tfPassword;
	private JTextField jTFDeposit;
	private JTextField jTFWithdraw;
	private JPanel pnCore;
	private ATM atm;

	public ATMUserInterface(ATM atm) {

		super(JANELA_TITULO);
		this.atm = atm;
		setSize(JANELA_LARGURA, JANELA_ALTURA);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(createMainPainel());
		setVisible(true);
	}

	private JPanel createMainPainel() {
		JPanel pnPrincipal = new JPanel(new GridLayout(2, 1));
		pnPrincipal.setBackground(JANELA_COR_FUNDO);
		pnPrincipal.add(createMainMenu());
		pnPrincipal.add(creatScrollPane());
       
		return pnPrincipal;
	}

	private JPanel createMainMenu() {
		JPanel header = new JPanel(new GridLayout(2, 1));
		header.add(createHeader());
		header.add(createPanelLogin());

		JPanel header_menu = new JPanel(new GridLayout(2, 1));
		header_menu.add(header);
		header_menu.add(createPanelMenu());
		return header_menu;
	}

	private JScrollPane creatScrollPane() {
		JScrollPane scroll = new JScrollPane(lbReturn = createPanelMessage());
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		return scroll;
	}

	private JLabel createHeader() {
		JLabel lbTitle = new JLabel(HEADER_TITLE, HEADER_IMG, SwingConstants.CENTER);
		lbTitle.setFont(lbTitle.getFont().deriveFont(30F));
		lbTitle.setForeground(WINDOWS_COLOR_TEXT);

		return lbTitle;
	}

	private JPanel createPanelLogin() {

		JPanel pnLogin = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 10));
		pnLogin.setOpaque(false);

		JLabel lbAccount = new JLabel("Enter your account number");
		lbAccount.setFont(lbAccount.getFont().deriveFont(Font.BOLD, 15));
		lbAccount.setForeground(WINDOWS_COLOR_TEXT);
		pnLogin.add(lbAccount);

		tfLoggin = new JTextField(6);
		tfLoggin.setFont(tfLoggin.getFont().deriveFont(Font.BOLD, 30));
		tfLoggin.setBackground(CAIXA_TEXTO_COR_FUNDO);
		tfLoggin.setForeground(WINDOWS_COLOR_TEXT);
		tfLoggin.addActionListener(new UserLogginListener(this));
		tfLoggin.setName("loggin");
		pnLogin.add(tfLoggin);

		JLabel lbPassword = new JLabel("Enter your PIN");
		lbPassword.setFont(lbPassword.getFont().deriveFont(Font.BOLD, 15));
		lbPassword.setForeground(WINDOWS_COLOR_TEXT);
		pnLogin.add(lbPassword);

		tfPassword = new JTextField(6);
		tfPassword.setFont(tfPassword.getFont().deriveFont(Font.BOLD, 30));
		tfPassword.setBackground(CAIXA_TEXTO_COR_FUNDO);
		tfPassword.setForeground(WINDOWS_COLOR_TEXT);
		tfPassword.setName("password");
		tfPassword.addActionListener(new UserLogginListener(this));
		pnLogin.add(tfPassword);

		JButton btLogin = new JButton("login", LOCK_BUTTON_IMG);
		btLogin.setFont(btLogin.getFont().deriveFont(Font.BOLD, 15));
		btLogin.setBackground(BACKGROUND_BUTTON);
        btLogin.setName("btLogin");
		
		btLogin.addActionListener(tfLoggin.getActionListeners()[0]);
		pnLogin.add(btLogin);
		
		JButton btLogout = new JButton("logout", LOGOUT_BUTTN);
		btLogout.setBackground(BACKGROUND_BUTTON);
		btLogout.addActionListener(new LogoutListener(this));
		btLogout.setName("Logout");
		pnLogin.add(btLogout);

		return pnLogin;
	}

	private JPanel createPanelMenu() {

		JPanel pnMain = new JPanel(new GridLayout(3, 1));
		JPanel pnMeio = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 10));
		pnMeio.setOpaque(false);

		if (Configuration.BALANCE_INQUIRY) {
			JButton btBalance = new JButton("Balance", BALANCE_BUTTON_IMG);
			btBalance.setFont(btBalance.getFont().deriveFont(Font.BOLD, 15));
			btBalance.setBackground(BACKGROUND_BUTTON);
			btBalance.addActionListener(new BallaceListener(this));
			btBalance.setName("btBalance");
			pnMeio.add(btBalance);
		}

		if (Configuration.WITHDRAWING) {
			JButton btWithdraw = new JButton("Withdraw", WITHDRAW_BUTTON_IMG);
			btWithdraw.setFont(btWithdraw.getFont().deriveFont(Font.BOLD, 15));
			btWithdraw.setBackground(BACKGROUND_BUTTON);
			btWithdraw.addActionListener(new WithdrawalListener(this));
			btWithdraw.setName("btWithdraw");
			pnMeio.add(btWithdraw);
		}

		if (Configuration.DEPOSITING) {
			JButton btDeposit = new JButton("Deposit", DEPOSIT_BUTTON_IMG);
			btDeposit.setFont(btDeposit.getFont().deriveFont(Font.BOLD, 15));
			btDeposit.setBackground(BACKGROUND_BUTTON);
			btDeposit.addActionListener(new DepositOptionListener(this));
			btDeposit.setName("btDeposit");
			pnMeio.add(btDeposit);
		}

		if (Configuration.LOGGING) {
			JButton btLog = new JButton("Log", LOG_BUTTON_IMG);
			btLog.setFont(btLog.getFont().deriveFont(Font.BOLD, 15));
			btLog.setBackground(BACKGROUND_BUTTON);
			btLog.addActionListener(new LoggerListener(this));
			btLog.setName("btLog");
			pnMeio.add(btLog);
		}

		if (Configuration.ADMIN_CONTROL) {

			JButton btOff = new JButton("TotalDeposit", TOTALMONEY_BUTTON_IMG);
			btOff.setFont(btOff.getFont().deriveFont(Font.BOLD, 15));
			btOff.setBackground(BACKGROUND_BUTTON);
			btOff.addActionListener(new TotalDeposit(this));
			pnMeio.add(btOff);

			JButton btTotalOff = new JButton("off ATM", OFF_BUTTON_IMG);
			btTotalOff.setFont(btTotalOff.getFont().deriveFont(Font.BOLD, 15));
			btTotalOff.setBackground(BACKGROUND_BUTTON);
			btTotalOff.addActionListener(new OFFListener(this));
			pnMeio.add(btTotalOff);
		}
		
		dollarMenu();
		createWithDrawMenu();
		pnMedium2.setVisible(false);
		pnMedium.setVisible(false);
		pnMain.add(pnMeio);
		pnMain.add(pnMedium);
		pnMain.add(pnMedium2);
		return pnMain;
	}
	private void createWithDrawMenu() {
		pnMedium2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 1, 5));
		pnMedium2.setOpaque(false);

		jTFDeposit = new JTextField(6);
		jTFDeposit.setFont(jTFDeposit.getFont().deriveFont(Font.BOLD, 30));
		jTFDeposit.setBackground(CAIXA_TEXTO_COR_FUNDO);
		jTFDeposit.setForeground(WINDOWS_COLOR_TEXT);
		jTFDeposit.setName("jTFDeposit");
		pnMedium2.add(jTFDeposit);

		JButton btDeposit = new JButton("submit!", LOCK_BUTTON_IMG);
		btDeposit.setFont(btDeposit.getFont().deriveFont(Font.BOLD, 15));
		btDeposit.setBackground(BACKGROUND_BUTTON);
		btDeposit.addActionListener(new DepositListener(this));
		btDeposit.setName("btSubmitDeposit");
		pnMedium2.add(btDeposit);
	}
	private void dollarMenu() {
	 	pnCore = new JPanel(new GridLayout(3, 3));
		pnCore.setOpaque(false);

		JButton bt$20 = new JButton("$20", DOLAR_BUTTON_IMG);
		bt$20.setFont(bt$20.getFont().deriveFont(Font.BOLD, 15));
		bt$20.setBackground(BACKGROUND_BUTTON_DOLLAR);
		bt$20.setName("bt20");
		bt$20.addActionListener(new WithdrawMoney(this, 20));
		
		pnCore.add(bt$20);

		JButton bt$40 = new JButton("$40", DOLAR_BUTTON_IMG);
		bt$40.setFont(bt$40.getFont().deriveFont(Font.BOLD, 15));
		bt$40.setBackground(BACKGROUND_BUTTON_DOLLAR);
		bt$40.addActionListener(new WithdrawMoney(this, 40));
		bt$40.setName("bt40");
		pnCore.add(bt$40);

		JButton bt$60 = new JButton("$60", DOLAR_BUTTON_IMG);
		bt$60.setFont(bt$60.getFont().deriveFont(Font.BOLD, 15));
		bt$60.setBackground(BACKGROUND_BUTTON_DOLLAR);
		bt$60.addActionListener(new WithdrawMoney(this, 60));
		bt$60.setName("bt60");
		pnCore.add(bt$60);

		JButton bt$80 = new JButton("$80", DOLAR_BUTTON_IMG);
		bt$80.setFont(bt$80.getFont().deriveFont(Font.BOLD, 15));
		bt$80.setBackground(BACKGROUND_BUTTON_DOLLAR);
		bt$80.addActionListener(new WithdrawMoney(this, 80));
		bt$80.setName("bt80");
		pnCore.add(bt$80);

		JButton bt$100 = new JButton("$100", DOLAR_BUTTON_IMG);
		bt$100.setFont(bt$100.getFont().deriveFont(Font.BOLD, 15));
		bt$100.setBackground(BACKGROUND_BUTTON_DOLLAR);
		bt$100.addActionListener(new WithdrawMoney(this, 100));
		bt$100.setName("bt100");
		pnCore.add(bt$100);

		JButton bt$200 = new JButton("$200", DOLAR_BUTTON_IMG);
		bt$200.setFont(bt$200.getFont().deriveFont(Font.BOLD, 15));
		bt$200.setBackground(BACKGROUND_BUTTON_DOLLAR);
		bt$200.addActionListener(new WithdrawMoney(this, 200));
		bt$200.setName("bt200");
		pnCore.add(bt$200);
		
		JPanel pnCore2 = new JPanel(new GridLayout(1, 1));
		pnCore2.setOpaque(false);
		
		jTFWithdraw = new JTextField(6);
		jTFWithdraw.setFont(jTFWithdraw.getFont().deriveFont(Font.BOLD, 30));
		jTFWithdraw.setBackground(CAIXA_TEXTO_COR_FUNDO);
		jTFWithdraw.setForeground(WINDOWS_COLOR_TEXT);
		jTFWithdraw.setName("jTFWithdraw");
		pnCore2.add(jTFWithdraw);

		JButton btWithdrawAllValue = new JButton("Withdraw", LOCK_BUTTON_IMG);
		btWithdrawAllValue.setFont(btWithdrawAllValue.getFont().deriveFont(Font.BOLD, 15));
		btWithdrawAllValue.setBackground(BACKGROUND_BUTTON_DOLLAR);
		btWithdrawAllValue.addActionListener(new WithdrawMoneyAllValues(this));
		btWithdrawAllValue.setName("btWithdrawAllValue");
		pnCore2.add(btWithdrawAllValue);
		
		if(Configuration.WITHDRAWING_ALL_VALUES) {
			pnMedium = new JPanel(new GridLayout(1, 2));
		}else {
			pnMedium = new JPanel(new GridLayout(1, 1));
		}
		pnMedium.add(pnCore);
		if(Configuration.WITHDRAWING_ALL_VALUES) {
			pnMedium.add(pnCore2);
		}
	}

	private JTextArea createPanelMessage() {
		JLabel lbResposta = new JLabel(msg);
		lbResposta.setHorizontalAlignment(SwingConstants.CENTER);
		lbResposta.setForeground(WINDOWS_COLOR_TEXT);
		lbResposta.setFont(lbResposta.getFont().deriveFont(20F));

		textArea = new JTextArea(msg);
		textArea.setFont(new Font("Serif", Font.ITALIC, 16));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setName("textArea");

		return textArea;
	}

	private void errorMessage(JFrame windows) {
		JOptionPane.showMessageDialog(windows, "You are not connected!", "Exiting the system...",
				JOptionPane.ERROR_MESSAGE);
	}
	private void clearTextField() {
		tfLoggin.setText("");
		tfPassword.setText("");
	}

	private class UserLogginListener implements ActionListener {

		private JFrame windows;

		public UserLogginListener(JFrame janela) {
			this.windows = janela;
		}

		public void actionPerformed(ActionEvent e) {

			int loggin = Integer.parseInt(tfLoggin.getText());
			int password = Integer.parseInt(tfPassword.getText());
			JOptionPane.showMessageDialog(windows, atm.authenticateUser_UserInterface(loggin, password),
					"System reports:", JOptionPane.INFORMATION_MESSAGE);
			clearTextField();
			msg+="Welcome!";
			lbReturn.setText(msg);
			lbReturn.invalidate();
		}
	}

	private class OFFListener implements ActionListener {
		private JFrame windows;

		public OFFListener(JFrame janela) {
			this.windows = janela;
		}

		public void actionPerformed(ActionEvent e) {
			int selectedOption = JOptionPane.showConfirmDialog(null, "Really want to Exit?", "System reports:",
					JOptionPane.YES_NO_OPTION);
			if (selectedOption == JOptionPane.YES_OPTION) {
				atm.setUserExited(true);
				msg = "";
				lbReturn.setText(msg);
				lbReturn.invalidate();
				System.exit(0);
			}
		}
	}

	private class LogoutListener implements ActionListener {

		private JFrame windows;

		public LogoutListener(JFrame janela) {
			this.windows = janela;
		}

		public void actionPerformed(ActionEvent e) {

			atm.setUserExited(true);
			atm.setUserAuthenticated(false);
			msg = "";
			lbReturn.setText(msg);
			lbReturn.invalidate();
			JOptionPane.showMessageDialog(windows, "Thank you! Goodbye!", "Exiting the system...",
					JOptionPane.INFORMATION_MESSAGE);
			pnMedium.setVisible(false);
			pnMedium2.setVisible(false);
		}

	}

	private class BallaceListener implements ActionListener {

		private JFrame windows;

		public BallaceListener(JFrame windows) {
			this.windows = windows;
		}

		public void actionPerformed(ActionEvent e) {
			if(atm.isUserAuthenticated()) {
				atm.balance();
				lbReturn.setText(msg);
				lbReturn.invalidate();
			}else
				errorMessage(windows);
		}
	}

	private class WithdrawMoney implements ActionListener {
		
		private JFrame windows;
		private int amount;
		
		public WithdrawMoney(JFrame windows, int amount) {
			this.windows = windows;
			this.amount = amount;
			
		}
		
		public void actionPerformed(ActionEvent e) {
			if(atm.isUserAuthenticated()) {
				pnMedium.setVisible(false);
				atm.Withdrawal(amount);
				lbReturn.setText(msg);
				lbReturn.invalidate();
			}else 
				errorMessage(windows);
		}
	}
	private class WithdrawMoneyAllValues implements ActionListener {

		private JFrame windows;
		private int amount;

		public WithdrawMoneyAllValues(JFrame windows) {
			this.windows = windows;
			

		}

		public void actionPerformed(ActionEvent e) {
			if(atm.isUserAuthenticated()) {
				pnMedium.setVisible(false);
				amount = Integer.parseInt(jTFWithdraw.getText());
				atm.Withdrawal(amount);
				lbReturn.setText(msg);
				lbReturn.invalidate();
			}else 
				errorMessage(windows);
		}
	}

	private class WithdrawalListener implements ActionListener {

		private JFrame windows;

		public WithdrawalListener(JFrame windows) {
			this.windows = windows;
		}

		public void actionPerformed(ActionEvent e) {
			if(atm.isUserAuthenticated()) {
			pnMedium.setVisible(true);
			pnMedium2.setVisible(false);
			}else {
				errorMessage(windows);
			}
		}
	}

	private class DepositOptionListener implements ActionListener {

		private JFrame windows;

		public DepositOptionListener(JFrame windows) {
			this.windows = windows;
		}

		public void actionPerformed(ActionEvent e) {
			if(atm.isUserAuthenticated()) {
				pnMedium2.setVisible(true);
		    	pnMedium.setVisible(false);
			}else {
				errorMessage(windows);
			}
		}
	}

	private class DepositListener implements ActionListener {

		private JFrame windows;

		public DepositListener(JFrame windows) {
			this.windows = windows;
		}

		public void actionPerformed(ActionEvent e) {
			if(atm.isUserAuthenticated()) {
				pnMedium2.setVisible(false);
				int value = Integer.parseInt(jTFDeposit.getText());
				atm.deposit(value);
				lbReturn.setText(msg);
				lbReturn.invalidate();
			}else {
				errorMessage(windows);
			}
		}
	}

	private class LoggerListener implements ActionListener {

		private JFrame windows;

		public LoggerListener(JFrame windows) {
			this.windows = windows;
		}

		public void actionPerformed(ActionEvent e) {
			Logger.printLog(atm.getScreen());
			lbReturn.setText(msg);
			lbReturn.invalidate();
		}
	}

	private class TotalDeposit implements ActionListener {
		private JFrame windows;

		public TotalDeposit(JFrame windows) {
			this.windows = windows;
		}
	
		public void actionPerformed(ActionEvent e) {
			msg+="Total Deposit: "+ atm.getTotalDeposit();
			lbReturn.setText(msg);
			lbReturn.invalidate();
		}
		
	}
}
