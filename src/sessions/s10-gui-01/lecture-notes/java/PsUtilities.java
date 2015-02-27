import java.util.Map;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

class PsUtilities {
    static void setSwingDefaultFontSize(int size) {
        for (Map.Entry<Object, Object> entry : UIManager.getDefaults().entrySet()) {
            Object key = entry.getKey();
            Object value = UIManager.get(key);
            if (value != null && value instanceof FontUIResource) {
                FontUIResource fr = (FontUIResource) value;
                FontUIResource f = new FontUIResource(fr.getFamily(), fr.getStyle(), size);
                UIManager.put(key, f);
            }
        }
    }
}
