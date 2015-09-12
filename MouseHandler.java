/* MouseHandler - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.awt.PopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MouseHandler extends MouseAdapter
{
    private PopupMenu popupMenu;
    int id;
    
    public MouseHandler(PopupMenu popupmenu, int i) {
	popupMenu = popupmenu;
	this.id = i;
    }
    
    public void mousePressed(MouseEvent mouseevent) {
	if (mouseevent.isPopupTrigger()) {
	    popupMenu.show(mouseevent.getComponent(), mouseevent.getX(),
			   mouseevent.getY());
	    Madness.textid = this.id;
	    mouseevent.consume();
	}
    }
    
    public void mouseReleased(MouseEvent mouseevent) {
	if (mouseevent.isPopupTrigger()) {
	    popupMenu.show(mouseevent.getComponent(), mouseevent.getX(),
			   mouseevent.getY());
	    Madness.textid = this.id;
	    mouseevent.consume();
	}
    }
}
