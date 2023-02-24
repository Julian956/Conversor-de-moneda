import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class CONVERSOR {

        private JFrame frame;
        private JPanel panel;
        private JComboBox<String> fromCurrencyList;
        private JComboBox<String> toCurrencyList;
        private JTextField amountField;
        private JLabel resultLabel;

        // Array with conversion rates
        private double[] conversionRates = {1.0, 1.11, 1.39, 0.009, 0.80, 0.77, 1.08, 0.72, 0.12};

        public CONVERSOR() {
            createUI();
        }

        private void createUI() {
            frame = new JFrame("Conversor de Divisas");
            panel = new JPanel();
            fromCurrencyList = new JComboBox<>(new String[]{"USD - Dólar estadounidense", "EUR - Euro",
                    "GBP - Libra esterlina", "JPY - Yen japonés", "CAD - Dólar canadiense",
                    "AUD - Dólar australiano", "CHF - Franco suizo", "NZD - Dólar neozelandés",
                    "SEK - Corona sueca", "NOK - Corona noruega"});
            toCurrencyList = new JComboBox<>(new String[]{"USD - Dólar estadounidense", "EUR - Euro",
                    "GBP - Libra esterlina", "JPY - Yen japonés", "CAD - Dólar canadiense",
                    "AUD - Dólar australiano", "CHF - Franco suizo", "NZD - Dólar neozelandés",
                    "SEK - Corona sueca", "NOK - Corona noruega"});
            amountField = new JTextField(10);
            resultLabel = new JLabel("");

            JButton convertButton = new JButton("Convertir");
            convertButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String fromCurrency = fromCurrencyList.getSelectedItem().toString();
                    String toCurrency = toCurrencyList.getSelectedItem().toString();
                    double amount = Double.parseDouble(amountField.getText());
                    int fromIndex = fromCurrencyList.getSelectedIndex();
                    int toIndex = toCurrencyList.getSelectedIndex();
                    double fromRate = conversionRates[fromIndex];
                    double toRate = conversionRates[toIndex];
                    double result = amount * (toRate / fromRate);
                    DecimalFormat df = new DecimalFormat("#,###.##");
                    resultLabel.setText(df.format(result) + " " + toCurrency.substring(0, 3));
                }
            });

            panel.add(fromCurrencyList);
            panel.add(toCurrencyList);
            panel.add(amountField);
            panel.add(convertButton);
            panel.add(resultLabel);

            frame.add(panel);
            frame.setSize(400, 200);
            frame.setVisible(true);
        }

        public static void main(String[] args) {
            CONVERSOR cc = new CONVERSOR();
        }
    }


