import view.EmployeeView;
import view.EmployeeViewImplement;

public class MainThread {
    public static void main(String[] args) {
        EmployeeView employeeView = new EmployeeViewImplement();
        employeeView.generateMenu();
    }
}
