import base.CommandParser;
import base.ProjectManagementSystem;

/*
ADD-TODO wash_the_dishes chore NOT DONE
ADD-TASK do_the_project uni_stuff HIGH 2018.3.12 2018.5.30 Martin Dimitrov
LIST-TODOS
LIST-ALL
*/

public class Main {

    public static void main(String[] args) {
        CommandParser parser = new CommandParserImpl();
        ProjectManagementSystem system = new ProjectManagementSystemImpl();
        Application app = new Application(parser, system);
        app.run();
    }
}
