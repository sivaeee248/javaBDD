package clarivate.windows;

import org.openqa.selenium.By;
import org.openqa.selenium.winium.WiniumDriver;
import enums.CalciKeys;

/**
 * This is a common methods class calculator operations
 *
 * @author Siva Kumar
 */

public class WindowsCalculator {
	
	private final WiniumDriver winiumDriver;

    public WindowsCalculator(WiniumDriver winiumDriver) {
        this.winiumDriver = winiumDriver;
    }
    
    
    /**
     * This method is used to press any key on Win 7 calculator.
     * @param calciKey This is the enum Calcikeys need to be pressed by mapping the enum to automation_id
     */
    public void pressButton(CalciKeys calciKey) {
            this.winiumDriver.findElement(By.id(String.valueOf(calciKey))).click();
            System.out.println("Pressed Button :" + String.valueOf(calciKey));
    }

    /**
     * This method is used to input a number as a whole to display on calculator screen
     * and perform any operation on it.
     * @param number This is the integer value needed to be input onto calculator screen
     */
    public void inputNumber(int number) {
        for (char ch : String.valueOf(number).toCharArray()) {
            pressButton(CalciKeys.valueOf("NUM" + ch));
        }
    }

    /**
     * This method is used to fetch the currently displayed number from calculator screen
     * @return This returns a double representing the currently displayed number on calculator screen
     */
    public double getResult() {
        String displayedResult = this.winiumDriver.findElement(By.id("CalculatorResults")).getAttribute("Name");
        System.out.println("Result "+displayedResult);
        return Double.parseDouble(displayedResult.split("Display is ")[1]);
    }

}
