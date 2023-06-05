package view;


import exception.CalculatorException;
import exception.ErrorMessage;
import view.OutputView.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static Scanner sc;

    private static Scanner getInstance() {
        if (sc == null) {
            sc = new Scanner(System.in);
        }
        return sc;
    }

    public static Menu selectMenuInput() throws CalculatorException {
        try {
            return switch (getInstance().nextInt()) {
                case 1 -> Menu.CHECK;
                case 2 -> Menu.CALCULATE;
                case 3 -> Menu.END;
                default -> throw new CalculatorException(ErrorMessage.INVALID_MENU_NUMBER);
            };
        } catch (InputMismatchException e) {
            throw new CalculatorException(ErrorMessage.INVALID_TYPE_INPUT);
        }
    }

    public static String mathExpressionInput() {
        getInstance().nextLine(); //개행문자 제거
        return getInstance().nextLine();
    }

    public static void inputClose() {
        if (getInstance() != null) {
            getInstance().close();
        }
    }
}
