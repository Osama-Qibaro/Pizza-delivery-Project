
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;

public class Main extends Application {
    Label pizza_app_title,
            input_name_lbl,
            input_phone_lbl,
            crust_lbl,
            toppings_lbl,
            olives_cb_lbl,
            mushroom_cb_lbl;


    ImageView pizza_image_view;

    TextField name_tf;
    TextField phone_tf;

    RadioButton thick_option, thin_option;

    CheckBox olives_cb,mushroom_cb,corn_cb,sausage_cb;

    Button send_order_btn, clear_order_btn;

    @Override
    public void start(Stage stage){
        initialize();
        VBox input_lbl_pane = new VBox(input_name_lbl, input_phone_lbl);
        VBox input_tf_pane = new VBox(name_tf,phone_tf);
        HBox inputPane = new HBox(input_lbl_pane,input_tf_pane);

        HBox crust_options_pane = new HBox(thick_option,thin_option);

        VBox crust_pane = new VBox(crust_lbl,crust_options_pane);

        HBox olives_pane = new HBox(olives_cb,olives_cb_lbl);
        olives_cb.setAccessibleHelp("Olives oil");
        VBox toppings_pane = new VBox(toppings_lbl,olives_pane);
        toppings_pane.setAlignment(Pos.CENTER);

        HBox finish_order_pane = new HBox(send_order_btn,clear_order_btn);


        Pane root = new VBox(pizza_app_title,pizza_image_view,inputPane,crust_pane,toppings_pane,finish_order_pane);

        changeFont("Bell MT",pizza_app_title,input_name_lbl,input_phone_lbl,crust_lbl,thick_option,thin_option,toppings_lbl,olives_cb,mushroom_cb,corn_cb,sausage_cb);
        setSpacing(input_lbl_pane,input_tf_pane,inputPane,crust_options_pane,crust_pane,toppings_pane,finish_order_pane,root);
        setAlignment(Pos.CENTER,root,crust_options_pane,finish_order_pane);


        Scene scene = new Scene(root,500,650);
        stage.setScene(scene);

        stage.setResizable(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void initialize(){
    //initialize labels ==========================================
        pizza_app_title = new Label("Pizza Delivery");
        input_name_lbl = new Label("Your Name:");
        input_phone_lbl = new Label("Phone Number:");
        crust_lbl = new Label("Crust:");
        toppings_lbl = new Label("Toppings:");
        olives_cb_lbl = new Label("Olives");
        mushroom_cb_lbl = new Label();

    //initialize Images view ==========================================
        pizza_image_view = new ImageView(new Image("pizzaImage.png"));
        pizza_image_view.setFitWidth(200);
        pizza_image_view.setFitHeight(200);

    //initialize tf ====================================================
        name_tf = new TextField();
        phone_tf = new TextField();

    //initialize radio button====================================================
        thick_option = new RadioButton();
        thick_option.setText("Thick");
        thin_option = new RadioButton();
        thin_option.setText("Thin");

    //initialize check boxes=====================================================
        olives_cb = new CheckBox();
        mushroom_cb = new CheckBox("Mushroom");
        corn_cb = new CheckBox("Corn");
        sausage_cb = new CheckBox("Sausage");

    //initialize buttons==========================================================
        send_order_btn = new Button("Send Order");
        clear_order_btn = new Button("Clear Order");
    }

    private void changeFont(String fontStyle,Control... control){
        Font font = new Font(fontStyle,17);

        for(Control c : control){
            if(c instanceof Labeled){
                ((Labeled) c).setFont(font);

            } else if (c instanceof TextInputControl) {
                ((TextInputControl)c).setFont(font);
            }
        }
    }

    private void setSpacing(Pane... Box){
        for(Pane p : Box){
            if(p instanceof VBox){
                ((VBox) p ).setSpacing(15);
            }else if (p instanceof HBox){
                ((HBox) p ).setSpacing(25);
            }

        }
    }

    private void setAlignment(Pos pos,Pane... Box){
        for(Pane p : Box){
            if(p instanceof VBox){
                ((VBox) p ).setAlignment(pos);
            }else if (p instanceof HBox){
                ((HBox) p ).setAlignment(pos);
            }
        }
    }

}