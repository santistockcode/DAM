/* tendré que terminar de ver la clase de entornos y entregr programación esta
 * tarde y preparar las clases de mañana
 */
import javax.swing.JOptionPane;
public class ejerciciodeldia2
{
    public static void main(String args[]){
        boolean _boolean;
        char _char;
        byte _byte;
        short _short;
        int _int;
        long _long;
        float _float;
        double _double;
        String quedeque;
        quedeque = JOptionPane.showInputDialog("Frase tírale: ");
        _float = Float.parseFloat(JOptionPane.showInputDialog("Float con punto: "));        
        _char = JOptionPane.showInputDialog("Un character: ").charAt(0);        
        _long = Long.parseLong(JOptionPane.showInputDialog("Un Long: "));
        _int = Integer.parseInt(JOptionPane.showInputDialog("Un integer: "));
        _short = Short.parseShort(JOptionPane.showInputDialog("Un short: "));
        _byte = Byte.parseByte(JOptionPane.showInputDialog("Un byte: "));
        _boolean = Boolean.parseBoolean(JOptionPane.showInputDialog("Un boolean: "));
        _double = Double.parseDouble(JOptionPane.showInputDialog("Un double: "));

        JOptionPane.showMessageDialog(null, "Esto es lo que has introducido: " + 
        _boolean + " " +
        _char + " " +
        _byte+ " " +
        _short+ " " +
        _int+ " " +
        _long+ " " +
        _float+ " " +
        _double+ " " +
        quedeque
        );
        
    }}

 
    

