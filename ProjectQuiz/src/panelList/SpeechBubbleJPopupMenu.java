package panelList;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class SpeechBubbleJPopupMenu extends JPopupMenu {
	JMenuItem anItem;
    public SpeechBubbleJPopupMenu(String msg){
        anItem = new JMenuItem(msg);
        add(anItem);
    }
}
