import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BMICalculator extends JFrame implements ActionListener {
    JTextField heightField, weightField;
    JLabel resultLabel;

    public BMICalculator() {
        setTitle("BMI Calculator by Saurabhh");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null); // Center the window

        JLabel heightLabel = new JLabel("Height (cm):");
        heightField = new JTextField();

        JLabel weightLabel = new JLabel("Weight (kg):");
        weightField = new JTextField();

        JButton calcButton = new JButton("Calculate BMI");
        calcButton.addActionListener(this);

        resultLabel = new JLabel("Your BMI will appear here", JLabel.CENTER);

        add(heightLabel);
        add(heightField);
        add(weightLabel);
        add(weightField);
        add(new JLabel()); // empty cell
        add(calcButton);
        add(new JLabel()); // empty cell
        add(resultLabel);

        setVisible(true);
		
		heightLabel.setBounds(40,30, 100,20);
		heightField.setBounds(130,33, 100,20);
		weightLabel.setBounds(40,60, 100,20);
		weightField.setBounds(130,66, 100,20);
		calcButton.setBounds(130,100, 100,20);
		resultLabel.setBounds(40,132, 150,20);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double heightCm = Double.parseDouble(heightField.getText());
            double weightKg = Double.parseDouble(weightField.getText());

            double heightM = heightCm / 100;
            double bmi = weightKg / (heightM * heightM);
            String category = "";

            if (bmi < 18.5) category = "Underweight";
            else if (bmi < 24.9) category = "Normal";
            else if (bmi < 29.9) category = "Overweight";
            else category = "Obese";

            resultLabel.setText(String.format("BMI: %.2f (%s)", bmi, category));
        } catch (Exception ex) {
            resultLabel.setText("❌ Invalid Input");
        }
    }

    public static void main(String[] args) {
        new BMICalculator();
    }
}
