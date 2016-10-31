package up.se2016;

import up.se2016.interfaces.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Represents very basic calculator actions triggered by buttons
 */
public class SimpleCalcAction extends AbstractAction{

    private final Calculator calc;
    private final JTextField[] operands;
    private final JButton[] operators;
    private final String[] map;
    private final JTextField result;

    /**
     * Builds the action with a default button-operator mapping of "+", "-", "*", "/"
     * @param calc      Calculator engine
     * @param result    Text field for results
     * @param operands  Text fields for operands
     * @param operators Buttons representing the operators
     * @throws IllegalArgumentException if not enough operand fields or fewer or more than four operators are provided
     */
    public SimpleCalcAction(Calculator calc, JTextField result, JTextField[] operands, JButton[] operators)
            throws IllegalArgumentException {
        this(calc, result, operands, operators, new String[] {"+","-","*","/"});
    }

    /**
     * Builds the action with a custom button-operator mapping
     * @param calc      Calculator engine
     * @param result    Text field for results
     * @param operands  Text fields for operands
     * @param operators Buttons representing the operators
     * @param map       String[] with one of "+", "-", "*", "/" for each of the operators
     * @throws IllegalArgumentException if not enough operand fields or fewer or more operators than map entries are provided
     */
    public SimpleCalcAction(Calculator calc, JTextField result, JTextField[] operands, JButton[] operators, String[] map)
            throws IllegalArgumentException {
        this.calc = calc;
        this.result = result;
        if ( operands.length < 2 ) {
            throw new IllegalArgumentException("Too few operands.");
        } else {
            this.operands = operands;
        }
        if ( operators.length != map.length || doesMapContainInvalidValues(map) ) {
            throw new IllegalArgumentException("Invalid button-operator mapping.");
        } else {
            this.operators = operators;
            this.map = map;
        }
    }

    /**
     * Checks if map contains Strings other than "+", "-", "*", "/"
     * @param map   The mapping to check
     * @return      true if a String other than an operator String is found, false else
     */
    protected boolean doesMapContainInvalidValues(String[] map) {
        for (String mapping : map) {
            if (!(mapping.equals("+") || mapping.equals("-") || mapping.equals("*") || mapping.equals("/"))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            int operand1 = Integer.parseInt(operands[0].getText());
            int operand2 = Integer.parseInt(operands[1].getText());
            switch (findOperation(actionEvent.getSource())) {
                case "+":
                    result.setText(String.format("%d", calc.sum(operand1, operand2)));
                    break;
                case "-":
                    result.setText(String.format("%d", calc.difference(operand1, operand2)));
                    break;
                case "*":
                    result.setText(String.format("%d", calc.product(operand1, operand2)));
                    break;
                case "/":
                    result.setText(String.format("%d", calc.quotient(operand1, operand2)));
                    break;
                default:
                    break;
            }
        } catch (NumberFormatException ex) {
            result.setText(ex.getMessage());
        }
    }

    /**
     * Finds the operation a given source represents
     * @param source    The source to inspect
     * @return          "+", "-", "*" or "/" if the source belongs to an operation, "" else
     */
    protected String findOperation(Object source) {
        int index = -1;
        for ( int i = 0; i < operators.length; i++ ) {
            if ( source.equals(operators[i]) ) {
                index = i;
                break;
            }
        }
        if ( index >= 0 ) {
            return map[index];
        } else {
            return "";
        }
    }
}
