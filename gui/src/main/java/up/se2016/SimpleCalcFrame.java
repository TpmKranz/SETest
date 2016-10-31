package up.se2016;

import javax.swing.*;
import java.awt.*;
import up.se2016.interfaces.Calculator;

/**
 * Represents a very basic integer calculator
 */
public class SimpleCalcFrame extends JFrame {
  private final Calculator calc;
  private final JButton[] buttons;
  private final JTextField[] inputs;
  private final String[] labels = {"+", "-", "*", "/"};
  private final JTextField output;

  /**
   * Builds the frame with given title and calculator engine
   *
   * @param title Frame title
   * @param calc  Calculator engine
   */
  public SimpleCalcFrame(String title, Calculator calc) {
    super(title);
    this.calc = calc;

    setSize(512,256);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    GridBagLayout layout = new GridBagLayout();
    layout.columnWidths = new int[]{128,128,128,128};
    layout.rowHeights = new int[]{64,64,64,64};
    setLayout(layout);

    buttons = new JButton[4];
    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.BOTH;

    inputs = new JTextField[2];
    for ( int i = 0; i < 2; i++ ) {
      c.gridx = 0;
      c.gridy = i;
      c.ipadx = 16;
      c.ipady = 16;
      c.gridheight = 1;
      c.gridwidth = 4;
      inputs[i] = new JTextField();
      getContentPane().add(inputs[i], c);
    }

    c.gridx = 0;
    c.gridy = 3;
    output = new JTextField();
    output.setEditable(false);
    getContentPane().add(output, c);

    Action operationAction = new SimpleCalcAction(this.calc, this.output, this.inputs, this.buttons, this.labels);
    for ( int i = 0; i < 4; i++ ) {
      c.gridx = i;
      c.gridy = 2;
      c.gridheight = 1;
      c.gridwidth = 1;
      buttons[i] = new JButton();
      buttons[i].setAction(operationAction);
      buttons[i].setText(labels[i]);
      getContentPane().add(buttons[i], c);
    }

    pack();
    setVisible(true);
  }
}
