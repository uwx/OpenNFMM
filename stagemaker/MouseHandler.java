package stagemaker;

/* MouseHandler - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
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
        id = i;
    }
    
    public void mousePressed(MouseEvent mouseevent) {
        if (mouseevent.isPopupTrigger()) {
            popupMenu.show(mouseevent.getComponent(), mouseevent.getX(), mouseevent.getY());
            Madness.textid = id;
            mouseevent.consume();
        }
    }
    
    public void mouseReleased(MouseEvent mouseevent) {
        if (mouseevent.isPopupTrigger()) {
            popupMenu.show(mouseevent.getComponent(), mouseevent.getX(), mouseevent.getY());
            Madness.textid = id;
            mouseevent.consume();
        }
    }
}
