// This class is used to crate a GUI for the subnetting class.
// Author: Kevin R. Loughlin
// Date created: 5/3/14
// Date last edited: 11/4/14
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
// Main class
public class gui
{

	public static JFrame frmCustomSubmaskCalculator;
	public static JTextField inputIpAddress;
	public static JTextField inputDefaultSubmask;
	public static JTextField inputCustomSubmask;
	public static JTextField inputSubnets;
	public static JTextField inputHosts;
	public static JButton calculate;
	static JLabel outputDefaultSubMask;
	static JLabel outputIpAddress;
	static JLabel outputCustomSubMask;
	static JLabel outputSubNets;
	static JLabel outputHosts;

	/**
	 * Create the application.
	 */
	public gui()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static void initialize()
	{
		frmCustomSubmaskCalculator = new JFrame();
		frmCustomSubmaskCalculator.setTitle("Subnet Calculator");
		frmCustomSubmaskCalculator.setBounds(100, 100, 450, 300);
		frmCustomSubmaskCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCustomSubmaskCalculator.setVisible(true);
		
		inputIpAddress = new JTextField();
		inputIpAddress.setColumns(10);
		inputIpAddress.setToolTipText("Ip Address");
		inputIpAddress.addKeyListener(new keyListener());
		
		inputDefaultSubmask = new JTextField();
		inputDefaultSubmask.setColumns(10);
		inputDefaultSubmask.addKeyListener(new keyListener());

		
		inputCustomSubmask = new JTextField();
		inputCustomSubmask.setColumns(10);
		inputCustomSubmask.addKeyListener(new keyListener());

		
		inputSubnets = new JTextField();
		inputSubnets.setColumns(10);
		inputSubnets.setToolTipText("SubNets");
		inputSubnets.addKeyListener(new keyListener());

		
		inputHosts = new JTextField();
		inputHosts.setColumns(10);
		inputHosts.setToolTipText("Hosts");
		inputHosts.addKeyListener(new keyListener());
		
		
		calculate = new JButton("Calculate");
		
		JLabel txtIpAddress = new JLabel("Ip Address");
		
		JLabel lblDefaultSubmask = new JLabel("Default SubMask");
		
		JLabel lblCustomSubmask = new JLabel("Custom SubMask");
		
		JLabel lblSubnets = new JLabel("SubNets");
		
		JLabel lblHosts = new JLabel("Hosts");
		
		outputDefaultSubMask = new JLabel("");
		
		outputIpAddress = new JLabel("");
		
		outputCustomSubMask = new JLabel("");
		
		outputSubNets = new JLabel("");
		
		outputHosts = new JLabel("");
		GroupLayout groupLayout = new GroupLayout(frmCustomSubmaskCalculator.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(161)
					.addComponent(calculate, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(inputIpAddress, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addComponent(inputDefaultSubmask, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addComponent(inputCustomSubmask, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addComponent(inputSubnets, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDefaultSubmask, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtIpAddress, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCustomSubmask, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSubnets, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(inputHosts, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblHosts, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(outputDefaultSubMask, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(outputIpAddress, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
							.addComponent(outputHosts, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
						.addComponent(outputSubNets, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
						.addComponent(outputCustomSubMask, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtIpAddress, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
							.addComponent(outputIpAddress, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(inputIpAddress, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(inputDefaultSubmask, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(outputDefaultSubMask, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblDefaultSubmask, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(inputCustomSubmask, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCustomSubmask, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(outputCustomSubMask, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(inputSubnets, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSubnets, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(outputSubNets, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(inputHosts, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(outputHosts, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHosts, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(64)
					.addComponent(calculate, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		frmCustomSubmaskCalculator.getContentPane().setLayout(groupLayout);
		calculate.addKeyListener(new keyListener());
		calculate.addActionListener(new actionListener());
	}
	// KeyListener class
	static class keyListener extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e){
			if (e.getKeyCode() == KeyEvent.VK_ENTER){
				try{
					if (inputSubnets.getText().equals("") && inputHosts.getText().equals("")){
						new subnetting(inputIpAddress.getText());
					}
					else if (inputHosts.getText().equals("")){
						new subnetting(inputIpAddress.getText(), Integer.parseInt(inputSubnets.getText()), true);
					}
					else {
						new subnetting(inputIpAddress.getText(), Integer.parseInt(inputHosts.getText()), false);
					}
				}
				catch (StringIndexOutOfBoundsException r){
					JOptionPane.showMessageDialog(null, "Invalid ip address!");
				}
			}
		}
	}
	// ActionListener class
	static class actionListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{	

			if (inputSubnets.getText().equals("") && inputHosts.getText().equals("")){
				new subnetting(inputIpAddress.getText());
			}
			else if (inputHosts.getText().equals("")){
				new subnetting(inputIpAddress.getText(), Integer.parseInt(inputSubnets.getText()), true);
			}
			else {
				new subnetting(inputIpAddress.getText(), Integer.parseInt(inputHosts.getText()), false);
			}
		}
	}
}
