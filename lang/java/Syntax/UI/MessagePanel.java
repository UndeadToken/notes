package UI;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MessagePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private static GridBagLayout gridBag = new GridBagLayout();
	
	public MessagePanel() {
		super();
		setLayout(gridBag);
		
		// To
		JLabel toLabel = new JLabel("To: ");
		JTextField to = new JTextField();
		
		// Subject
		JLabel subjectLabel = new JLabel("Subject: ");
		JTextField subject = new JTextField();
		
		// CC
		JLabel ccLabel = new JLabel("CC: ");
		JTextField cc = new JTextField();
		
		// BCC
		JLabel bccLabel = new JLabel("BCC: ");
		JTextField bcc = new JTextField();
		
		// Add components
		addComponent(toLabel, 0, 0, 1, 1, 10, 100,
				GridBagConstraints.NONE, GridBagConstraints.EAST);
		
		addComponent(to, 1, 0, 9, 1, 90, 100,
				GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST);
		
		addComponent(subjectLabel, 0, 1, 1, 1, 10, 100,
				GridBagConstraints.NONE, GridBagConstraints.EAST);
		
		addComponent(subject, 1, 1, 9, 1, 90, 100,
				GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST);
		
		addComponent(ccLabel, 0, 2, 1, 1, 10, 100,
				GridBagConstraints.NONE, GridBagConstraints.EAST);
		
		addComponent(cc, 1, 2, 4, 1, 40, 100,
				GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST);
		
		addComponent(bccLabel, 5, 2, 1, 1, 10, 100,
				GridBagConstraints.NONE, GridBagConstraints.EAST);
		
		addComponent(bcc, 6, 2, 4, 1, 40, 100,
				GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST);
	}

	private void addComponent(Component component, int gridx, int gridy, 
			int gridwidth, int gridheight, int weightx, int weighty, int fill,
			int anchor) 
	{
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = gridx;
		constraints.gridy = gridy;
		constraints.gridwidth = gridwidth;
		constraints.gridheight = gridheight;
		constraints.weightx = weightx;
		constraints.weighty = weighty;
		constraints.fill = fill;
		constraints.anchor = anchor;
		gridBag.setConstraints(component, constraints);
		add(component);
	}
}
