package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Main extends Application {
TextField txtnum1, txtnum2;
Button btnadd, btnsub, btndiv, btnmul, btnclear;
Label lblanswer;
    @Override
    public void start(Stage primaryStage) {
        //lav funktionerne
        txtnum1 = new TextField();
        txtnum2 = new TextField();
        btnadd = new Button("+");
        btnsub = new Button("-");
        btnmul = new Button("x");
        btndiv = new Button("/");
        btnclear = new Button("Clear");
        lblanswer = new Label("?");

        //centrér tekst i labellerne
        lblanswer.setAlignment(Pos.CENTER);

        //Tilsæt css-lignende stil til label
        lblanswer.setStyle("-fx-border-color: #000; -fx-padding: 5px;");

        //Lav "containeren til app'en
        GridPane root = new GridPane();
        //Put containeren i midten af scenen
        root.setAlignment(Pos.CENTER);
        //Set mellemrum mellem controls i gridden
        root.setHgap(10);
        root.setVgap(10);
        //tilsæt grid, celle for celle
        root.add(btnadd,0,0);
        root.add(btnsub,1,0);
        root.add(btnmul,0,1);
        root.add(btndiv,1,1);
        root.add(txtnum1,0,2);
        root.add(txtnum2,1,2);
        //Sidste to linjer henover 2 kollonner
        //col, rol, colspan, rowspan
        root.add(lblanswer,0,3,2,1);
        root.add(btnclear,0,4,2,1);
        //sætter bredde for alle funktioner i applikationen
        setWidths();
        //klistrer knapper og kode sammen
        attachCode();

        //usual stuff
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Mathtastic 1.0");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void setWidths(){
        //Metode til at sætte bredde til alle funktioner
        txtnum1.setPrefWidth(70);
        txtnum2.setPrefWidth(70);
        btnadd.setPrefWidth(70);
        btnsub.setPrefWidth(70);
        btnmul.setPrefWidth(70);
        btndiv.setPrefWidth(70);
        btnclear.setPrefWidth(150);
        lblanswer.setPrefWidth(150);
    }

    public void attachCode()
    {
        //en metode til at igangsætte en anden metode som indeholder koder for hver enkel funktion
        btnadd.setOnAction(e -> btncode(e)); //'e' er en variabel i btncode metoden
        btnsub.setOnAction(e -> btncode(e));
        btnmul.setOnAction(e -> btncode(e));
        btndiv.setOnAction(e -> btncode(e));
        btnclear.setOnAction(e -> btncode(e));
    }

    public void btncode(ActionEvent e)
    {
        int num1, num2, answer;
        char symbol;
        //e fortæller os hvilken knap der blev trykket på
        if(e.getSource()==btnclear)
        {
            txtnum1.setText("");//tomt tekst felt, venter på at blive udfyldt af bruger
            txtnum2.setText("");
            lblanswer.setText("?");
            txtnum1.requestFocus();
            return;
        }
        //read numbers in from textfields
        num1=Integer.parseInt(txtnum1.getText());
        num2=Integer.parseInt(txtnum2.getText());
        if(e.getSource()==btnadd)
        {
            symbol='+';
            answer=num1+num2;
        }
        else if(e.getSource()==btnsub)
        {
            symbol='-';
            answer=num1-num2;
        }
        else if(e.getSource()==btnmul)
        {
            symbol='x';
            answer=num1*num2;
        }
        else
        {
            symbol='/';
            answer=num1/num2;
        }
        //display answer
        lblanswer.setText("" + num1 + symbol + num2 + "=" + answer);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
