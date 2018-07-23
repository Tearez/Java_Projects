import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;


public class Cubes extends Frame implements ActionListener {
    private Stack<Cube> cubeList;
    private Label label;
    private TextField text;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;

    public Cubes() {
        setLayout(new FlowLayout());
        label = new Label("Length");
        add(label);
        text = new TextField(" ", 30);
        add(text);
        button1 = new Button("Add");
        add(button1);
        button2 = new Button("Volume");
        add(button2);
        button3 = new Button("Write in File");
        add(button3);
        button4 = new Button("Load from File");
        add(button4);
        button5 = new Button("Remove duplicates");
        add(button5);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);

        this.cubeList = new Stack<>();
        setSize(420, 200);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            double temp1 = Double.parseDouble(this.text.getText());
            this.cubeList.push(new Cube(temp1));
            for (int i = 0; i < cubeList.size(); i++) {
                System.out.println(cubeList.get(i));
            }
        }

        if (e.getSource() == button2) {
            String allVolumes = "";
            for (Cube c : cubeList) {
                allVolumes += (c.volume() + ", ");
            }
            System.out.println(allVolumes);
            this.text.setText(allVolumes);
        }

        if (e.getSource() == button3) {
            PrintWriter out = null;
            try {
                out = new PrintWriter("volumes.txt");

                for (int i = 0; i < this.cubeList.size(); i++) {
                    out.println(this.cubeList.elementAt(i).volume());
                }
            } catch (FileNotFoundException e1) {
                System.out.println(e1.getMessage());
            } finally {
                if (out != null) {
                    out.close();
                }
            }
        }

        if(e.getSource()==button4){
            try{
                Scanner fileReader = new Scanner(new File("volumes.txt"));
                double temp2;

                while (fileReader.hasNextLine()){
                    temp2  = Double.parseDouble(fileReader.nextLine());
                    this.cubeList.add(new Cube(Math.cbrt(temp2)));
                }
                fileReader.close();
            } catch (FileNotFoundException e1) {
                System.out.println(e1.getMessage());
            }
        }

        if (e.getSource()==button5){
            if (this.cubeList!=null) {
                Set<Cube> remove = new HashSet<>();
                remove.addAll(this.cubeList);
                this.cubeList.clear();
                this.cubeList.addAll(remove);
            } else {
                this.text.setText("No Cubes Loaded");
            }
        }
    }
}
