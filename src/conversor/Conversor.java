package conversor;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Conversor {
    public static void main(String[] args) {
    	
    	//menu seleccionar conversor de moneda o temperatura
        String[] opciones = {"Conversor de Moneda", "Conversor de Temperatura"};

        boolean deseaContinuar = true;
        // dependiendo de la opcion se ingresa si  no sale sale del cilo
        while (deseaContinuar) {
            
            String seleccionTipo = (String) JOptionPane.showInputDialog(null, "Selecciona el tipo de conversión:",
                    "Conversores", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (seleccionTipo.equals("Conversor de Moneda")) {
                convertirDivisas();
            } else if (seleccionTipo.equals("Conversor de Temperatura")) {
                convertirTemperatura();
            }

            int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas continuar?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                deseaContinuar = true;
            } else {
                deseaContinuar = false;
            }
        }

        JOptionPane.showMessageDialog(null, "Programa terminado", "Terminado", JOptionPane.INFORMATION_MESSAGE);
    }

    // menu 
    public static void convertirDivisas() {
        String[] opciones = {"Pesos Colombiano","Dólar", "Euro", "Libra Esterlina", "Yen Japonés", "Won surcoreano"};

        // seleccion de menu conversor de moneda
        String seleccionEntrada = (String) JOptionPane.showInputDialog(null, "1. Seleccione una opción de conversión:",
        		"Conversor de Moneda", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        // Seleccion de la segunda opcion
        String seleccionSalida = (String) JOptionPane.showInputDialog(null, "2. Selecciona la opción que deseas convertir :",
        		"Conversor de Moneda", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        
       // ingreso del dinero que se va a convertir

        double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Ingresa la cantidad de dinero que deseas convertir:"));

        double resultado = 0;
        //dependiendo de la eleccion en el menu, se realiza metodos

        switch (seleccionEntrada) {
        case "Pesos Colombiano":
            resultado = convertirColombiano(cantidad, seleccionSalida);
            break;
        
            case "Dólar":
                resultado = convertirDolares(cantidad, seleccionSalida);
                break;
            case "Euro":
                resultado = convertirEuros(cantidad, seleccionSalida);
                break;
            case "Libra Esterlina":
                resultado = convertirLibras(cantidad, seleccionSalida);
                break;
            case "Yen Japonés":
                resultado = convertirYenes(cantidad, seleccionSalida);
                break;
            case "Won surcoreano":
                resultado = convertirWons(cantidad, seleccionSalida);
                break;
        }
        
        // para que imprima la respuesta con puntos y decimales
        DecimalFormat df = new DecimalFormat("#,###.00"); // Patrón de formato con puntos y dos decimales
        String resultadoFormateado = df.format(resultado);

        JOptionPane.showMessageDialog(null," Tienes $" + resultadoFormateado + " " + seleccionSalida + ".",
                "Resultado", JOptionPane.INFORMATION_MESSAGE);

        /*JOptionPane.showMessageDialog(null," Tienes $  " + resultado + " " + seleccionSalida + ".",
                "Resultado", JOptionPane.INFORMATION_MESSAGE);*/
    }

    // menu temperatura opciones
    public static void convertirTemperatura() {
        String[] opciones = {"Celsius", "Fahrenheit", "Kelvin", "Rankine"};

        // Menu de temperatura inicial
        String seleccionEntrada = (String) JOptionPane.showInputDialog(null, "Selecciona la opción de temperatura inicial:",
                "Conversor de Temperatura", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        // Menu de temperatura final
        String seleccionSalida = (String) JOptionPane.showInputDialog(null, "Selecciona la opción de temperatura que desea convertir :",
                "Conversor de Temperatura", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Ingresa la temperatura que deseas convertir:"));

        double resultado = 0;

        switch (seleccionEntrada) {
            case "Celsius":
                resultado = convertirCelsius(cantidad, seleccionSalida);
                break;
            case "Fahrenheit":
                resultado = convertirFahrenheit(cantidad, seleccionSalida);
                break;
            case "Kelvin":
                resultado = convertirKelvin(cantidad, seleccionSalida);
                break;
            case "Rankine":
                resultado = convertirRankine(cantidad, seleccionSalida);
                break;
        }

        JOptionPane.showMessageDialog(null, cantidad + " " + seleccionEntrada + " es equivalente a " + resultado + " " + seleccionSalida + ".",
                "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }

    // Conversor de divisas 
    
    public static double convertirColombiano(double cantidad, String divisaSalida) {
        switch (divisaSalida) {
            case "Pesos Colombiano":
            	return cantidad;
        
            case "Dólar":
                return cantidad / 3650.0; // Tipo de cambio de Peso Colombiano a Dólar
            case "Euro":
                return cantidad / 4200.0; // Tipo de cambio de Peso Colombiano a Euro
            case "Libra Esterlina":
                return cantidad / 4800.0; // Tipo de cambio de Peso Colombiano a Libra Esterlina
            case "Yen Japonés":
                return cantidad / 38.0; // Tipo de cambio de Peso Colombiano a Yen Japonés
            case "Won surcoreano":
                return cantidad / 3.5; // Tipo de cambio de Peso Colombiano a Won surcoreano
            default:
                return 0;
        }
    }

    public static double convertirDolares(double cantidad, String divisaSalida) {
        switch (divisaSalida) {
        
            case "Pesos Colombiano":
        	return cantidad *3650; // Tipo de cambio de Dólar a peso colombiano
            case "Dólar":
                return cantidad;
            case "Euro":
                return cantidad / 0.85; // Tipo de cambio de Dólar a Euro
            case "Libra Esterlina":
                return cantidad / 0.73; // Tipo de cambio de Dólar a Libra Esterlina
            case "Yen Japonés":
                return cantidad / 110.23; // Tipo de cambio de Dólar a Yen Japonés
            case "Won surcoreano":
                return cantidad / 1166.11; // Tipo de cambio de Dólar a Won surcoreano
            default:
                return 0;
        }
    }

    public static double convertirEuros(double cantidad, String divisaSalida) {
        switch (divisaSalida) {
        
            case "Pesos Colombiano":
            	return cantidad *4200;
            case "Dólar":
                return cantidad * 0.85; // Tipo de cambio de Euro a Dólar
            case "Euro":
                return cantidad;
            case "Libra Esterlina":
                return cantidad * 0.85 / 0.73; // Tipo de cambio de Euro a Libra Esterlina
            case "Yen Japonés":
                return cantidad * 0.85 / 110.23; // Tipo de cambio de Euro a Yen Japonés
            case "Won surcoreano":
                return cantidad * 0.85 / 1166.11; // Tipo de cambio de Euro a Won surcoreano
            default:
                return 0;
        }
    }

    public static double convertirLibras(double cantidad, String divisaSalida) {
        switch (divisaSalida) {
            case "Pesos Colombiano":
        	    return cantidad *4800; //Tipo de cambio de Libra Esterlina a peso colombiano
            case "Dólar":
                return cantidad * 0.73; // Tipo de cambio de Libra Esterlina a Dólar
            case "Euro":
                return cantidad * 0.73 / 0.85; // Tipo de cambio de Libra Esterlina a Euro
            case "Libra Esterlina":
                return cantidad;
            case "Yen Japonés":
                return cantidad * 0.73 / 110.23; // Tipo de cambio de Libra Esterlina a Yen Japonés
            case "Won surcoreano":
                return cantidad * 0.73 / 1166.11; // Tipo de cambio de Libra Esterlina a Won surcoreano
            default:
                return 0;
        }
    }

    public static double convertirYenes(double cantidad, String divisaSalida) {
        switch (divisaSalida) {
        
            case "Pesos Colombiano":
    	    return cantidad *38.0; // Tipo de cambio de yen japones a peso colombiano
            case "Dólar":
                return cantidad * 110.23; // Tipo de cambio de Yen Japonés a Dólar
            case "Euro":
                return cantidad * 110.23 / 0.85; // Tipo de cambio de Yen Japonés a Euro
            case "Libra Esterlina":
                return cantidad * 110.23 / 0.73; // Tipo de cambio de Yen Japonés a Libra Esterlina
            case "Yen Japonés":
                return cantidad;
            case "Won surcoreano":
                return cantidad * 110.23 / 1166.11; // Tipo de cambio de Yen Japonés a Won surcoreano
            default:
                return 0;
        }
    }

    public static double convertirWons(double cantidad, String divisaSalida) {
        switch (divisaSalida) {
        
           case "Pesos Colombiano":
    	       return cantidad *3.5; // Tipo de cambio de Won surcoreano a pesos solombianos
            case "Dólar":
                return cantidad * 1166.11; // Tipo de cambio de Won surcoreano a Dólar
            case "Euro":
                return cantidad * 1166.11 / 0.85; // Tipo de cambio de Won surcoreano a Euro
            case "Libra Esterlina":
                return cantidad * 1166.11 / 0.73; // Tipo de cambio de Won surcoreano a Libra Esterlina
            case "Yen Japonés":
                return cantidad * 1166.11 / 110.23; // Tipo de cambio de Won surcoreano a Yen Japonés
            case "Won surcoreano":
                return cantidad;
            default:
                return 0;
        }
    }

   // metodos de conversor de temperatura
    public static double convertirCelsius(double cantidad, String unidadSalida) {
        switch (unidadSalida) {
            case "Celsius":
                return cantidad;
            case "Fahrenheit":
                return (cantidad * 9/5) + 32;
            case "Rankine":
                return  (cantidad * 9/5) + 491.67;
            case "Kelvin":
                return cantidad + 273.15;
            default:
                return 0;
        }
    }

    public static double convertirFahrenheit(double cantidad, String unidadSalida) {
        switch (unidadSalida) {
            case "Celsius":
                return (cantidad - 32) * 5 / 9;
            case "Fahrenheit":
                return cantidad;
            case "Rankine":
                return cantidad+ 459.67;
            case "Kelvin":
                return (cantidad + 459.67) * 5 / 9;
            default:
                return 0;
        }
    }

    public static double convertirKelvin(double cantidad, String unidadSalida) {
        switch (unidadSalida) {
            case "Celsius":
                return cantidad - 273.15;
            case "Fahrenheit":
                return (cantidad * 9 / 5) - 459.67;
            case "Kelvin":
                return cantidad;
            case "Rankine":
                return cantidad* 1.8;
            default:
                return 0;
        }
    }
    
    public static double  convertirRankine(double cantidad, String unidadSalida) {
        switch (unidadSalida) {
            case "Celsius":
                return (cantidad - 491.67)*5/9; 
            case "Fahrenheit":
                return cantidad -459.67;
            case "Kelvin":
                return cantidad * 5/9;
            case "Rankine":
                return cantidad;
            default:
                return 0;
        }
    }
}
