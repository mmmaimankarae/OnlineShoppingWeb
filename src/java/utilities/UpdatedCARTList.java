package utilities;

import java.util.ArrayList;
import javax.servlet.ServletContext;

public class UpdatedCARTList {
    
     public static boolean isUpdating(ServletContext sc, int id) {
        ArrayList<Integer> idUsed = (ArrayList<Integer>) sc.getAttribute("idUsed");
        if (idUsed == null) {
            idUsed = new ArrayList<>();
            idUsed.add(id);
            sc.setAttribute("idUsed", idUsed);
        }
        else {
            if (idUsed.indexOf(id) == -1) {
                idUsed.add(id);
            }
            else {
                return true;
            }
        }
        return false;
    }
     
    public static void finishUpdating(ServletContext sc, Integer id) {
        ArrayList<Integer> idUsed = (ArrayList<Integer>) sc.getAttribute("idUsed");
        if (idUsed == null) return;
        idUsed.remove(id);
    }
}
