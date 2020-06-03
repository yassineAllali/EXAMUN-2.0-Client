package ClientInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;

public class CheckListner implements ActionListener
{
	private JToggleButton[] buttons;
	public CheckListner(JToggleButton[] buttons) 
	{
		this.buttons = buttons;
		addActionListner();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		JToggleButton toggler = (JToggleButton) e.getSource();
		deselectAll();
		toggler.setSelected(true);
	}
	
	private void addActionListner()
	{
		for(int i = 0 ; i < buttons.length ; i++)
		{
			buttons[i].addActionListener(this);
		}
	}
	
	private void deselectAll()
	{
		for(int i = 0 ; i < buttons.length ; i++)
		{
			buttons[i].setSelected(false);
		}
	}

}
