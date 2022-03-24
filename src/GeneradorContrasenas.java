import java.util.Scanner;

public class GeneradorContrasenas {

    private static final String CONSONANTES = "bcdfghjklmnpqrstvwxyz";
    private static final String VOCALES = "aeiou";
    private static final String NUMEROS = "0123456789";
    private static final String SIMBOLOS = "!@#$&/\\€?*+-,;.:<>\"";

    public static final int NUM_PARES = 3;
    public static final int NUM_NUMS = 2;
    public static final int NUM_SIMB = 1;

    public static final String OTRA = "N";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String respuesta;
        do {
            String password = "";
            for (int i = 0; i < NUM_PARES; i++) {
                password += generaPar();
            }
            for (int i = 0; i < NUM_NUMS; i++) {
                password += getAlea(NUMEROS);
            }
            for (int i = 0; i < NUM_SIMB; i++) {
                password += getAlea(SIMBOLOS);
            }
            System.out.println("La contraseña generada es:\n\t" + password + "\nSi no le gusta y quiere una nueva pulse " + OTRA);
            respuesta = scanner.nextLine();
        } while (respuesta.equalsIgnoreCase(OTRA));

        System.out.println("FIN");
    }

    private static char getAlea(String opciones) {
        int pos = (int) (Math.random() * opciones.length());
        return opciones.charAt(pos);
    }

    private static String generaPar() {
        String par = "";
        par += getAlea(CONSONANTES);
        par += getAlea(VOCALES);
        return par;
    }
}
