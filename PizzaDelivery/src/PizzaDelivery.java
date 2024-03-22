import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PizzaDelivery extends Application {
    Label pizza_app_title,
            input_name_lbl,
            input_phone_lbl,
            crust_lbl,
            toppings_lbl;


    ImageView pizza_image_view;

    TextField name_tf;
    TextField phone_tf;

    RadioButton thick_option, thin_option;

    CheckBox olives_cb, mushroom_cb, corn_cb, sausage_cb;

    Button send_order_btn, clear_order_btn;

    @Override
    public void start(Stage stage) {
        initialize();
        setProgramFont();

        Header();

        HBox inputPane = inputPane();
        VBox crustPane = crustPane();
        VBox toppingsPane = toppingsPane();
        HBox finishOptionPane = finishOptionPane();

        VBox root = new VBox(pizza_app_title, pizza_image_view, inputPane, crustPane, toppingsPane, finishOptionPane);

        root.setSpacing(20);
        root.setPadding(new Insets(8.5));
        root.setAlignment(Pos.CENTER);

        // Scene implementation -----------------------------------
        Scene scene = new Scene(root, 320, 630);
        stage.setScene(scene);

        finishActions();
        crustActions();
        // Stage implementation -----------------------------------
        stage.getIcons().add(new Image("recsources/pizza Icon.png"));
        stage.setX(330);
        stage.setY(40);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    //initialize the objects =================================================
    private void initialize() {
        //initialize labels ==========================================
        pizza_app_title = new Label("Pizza Delivery");
        input_name_lbl = new Label("Your Name:");
        input_phone_lbl = new Label("Phone Number:");
        crust_lbl = new Label("Crust:");
        toppings_lbl = new Label("Toppings:");


        //initialize Images view ==========================================
        pizza_image_view = new ImageView(new Image("recsources/pizzaImage.png"));
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
        olives_cb = new CheckBox("Olives");
        mushroom_cb = new CheckBox("Mushroom");
        corn_cb = new CheckBox("Corn");
        sausage_cb = new CheckBox("Sausage");

        //initialize buttons==========================================================
        send_order_btn = new Button("Send Order");
        clear_order_btn = new Button("Clear Order");

        //
    }

    //Header =================================================================
    private void Header() {
        pizza_app_title.setFont(new Font("Sylfaen", 30));
        pizza_app_title.setTextFill(Color.rgb(140, 0, 0));

    }

    //input pane ========================================================
    private HBox inputPane() {
        VBox inputLblsPane = new VBox(input_name_lbl, input_phone_lbl);
        VBox inputTfsPane = new VBox(name_tf, phone_tf);
        HBox inputPane = new HBox(inputLblsPane, inputTfsPane);

        inputPane.setMinHeight(75);
        inputLblsPane.setMinHeight(inputPane.getMinHeight());
        inputTfsPane.setMinHeight(inputPane.getMinHeight());


        inputPane.setAlignment(Pos.CENTER);
        inputLblsPane.setAlignment(Pos.CENTER_LEFT);
        inputTfsPane.setAlignment(Pos.CENTER);

        input_name_lbl.setPadding(new Insets(0, 0, 5, 0));


        setBoxesSpacing(10, inputPane, inputLblsPane, inputTfsPane);

        return inputPane;
    }

    //crust option pane =================================================
    private VBox crustPane() {
        HBox CrustTypePane = new HBox(10, thick_option, thin_option);
        VBox CrustPane = new VBox(crust_lbl, CrustTypePane);

        CrustPane.setMinWidth(160);
        CrustTypePane.setMinWidth(160);

        CrustTypePane.setAlignment(Pos.CENTER);

        setBoxesSpacing(10, CrustPane, CrustTypePane);

        return CrustPane;
    }

    //toppings pane =====================================================
    private VBox toppingsPane() {
        VBox toppinCBsPane = new VBox(10, olives_cb, mushroom_cb, corn_cb, sausage_cb);
        VBox toppingsPane = new VBox(10, toppings_lbl, toppinCBsPane);

        setBoxesSpacing(10, toppingsPane);
        setBoxesSpacing(5, toppinCBsPane);

        toppings_lbl.setAlignment(Pos.CENTER_LEFT);

        return toppingsPane;
    }

    // finish option pane ===============================================
    private HBox finishOptionPane() {
        HBox ButtonsPane = new HBox(send_order_btn, clear_order_btn);

        ButtonsPane.setSpacing(10);

        ButtonsPane.setAlignment(Pos.CENTER);

        return ButtonsPane;
    }


    //set font of nodes ======================================================
    private void setProgramFont() {
        setFont("Sylfaen", 16, input_name_lbl, input_phone_lbl, crust_lbl, toppings_lbl, send_order_btn, clear_order_btn);
        setFont("Sylfaen", 14, thick_option, thin_option, olives_cb, mushroom_cb, corn_cb, sausage_cb);
    }

    private void setFont(String fontStyle, double fontSize, Control... controls) {
        Font fontStyleOb = new Font(fontStyle, fontSize);
        for (Control control : controls) {
            if (control instanceof Labeled) {
                ((Labeled) control).setFont(fontStyleOb);
                ((Labeled) control).setTextFill(Color.rgb(80, 80, 80));
            } else if (control instanceof TextInputControl) {
                ((TextInputControl) control).setFont(fontStyleOb);
            }
        }
    }

    //set spacing of Boxes =============================================================
    private void setBoxesSpacing(double spacingLength, Pane... panes) {
        for (Pane currentPane : panes) {
            if (currentPane instanceof HBox)
                ((HBox) currentPane).setSpacing(spacingLength);
            else if (currentPane instanceof VBox)
                ((VBox) currentPane).setSpacing(spacingLength);
        }
    }


    //send result stage =================================================
    private Stage createWarningStage(Label warningMessage){
        VBox warningRoot = new VBox(warningMessage);
        Scene scene = new Scene(warningRoot);
        Stage warningStage = new Stage();

        warningStage.getIcons().add(new Image("recsources/warning Image.png"));

        warningStage.setScene(scene);
        warningStage.setX(314);
        warningStage.setY(221);

        //worning root properties
        warningRoot.setMinSize(360, 90);
        warningRoot.setPadding(new Insets(20));
        warningRoot.setAlignment(Pos.CENTER);
        warningRoot.setSpacing(20);

        warningMessage.setFont(new Font("Sylfaen",20));
        warningMessage.setTextFill(Color.rgb(170,0,0));

        return warningStage;
    }

    private boolean isValidInfos(){
        //name validation
            //check if empty
        try{
            if(name_tf.getText().isEmpty()){
                throw new IllegalArgumentException("Enter your name.");
            }else {
                char ch;
                for (int i = 0; i < name_tf.getLength(); i++) {
                    ch = name_tf.getText().charAt(i);
                if (!(ch >= 65 || ch <= 90 && ch >= 97 || ch <= 122 || ch == 32)){
                        throw new IllegalArgumentException("Remove punctuation characters from your name.");
                    }
                }
            }

            if(phone_tf.getText().isEmpty())
                throw new IllegalArgumentException("Enter your phone number please.");
            else{
                char ch;
                for (int i = 0; i < phone_tf.getLength(); i++) {
                    ch  = phone_tf.getText().charAt(i);
                    if (ch < 48 || ch > 57)
                        throw new IllegalArgumentException("Enter correct phone number please.");
                }
            }
            if(!(thick_option.isSelected() || thin_option.isSelected()))
                throw new IllegalArgumentException("Select the crust.");

            if(!(olives_cb.isSelected() || mushroom_cb.isSelected() || corn_cb.isSelected() || sausage_cb.isSelected()))
                throw new IllegalArgumentException("Select one toppings at least.");

        }catch(IllegalArgumentException e){

            Label warningMessage = new Label(e.getMessage());


            Stage warningStage = createWarningStage(warningMessage);

            warningStage.show();

            return false;
        }
        return true;
    }
   private void sendResultStage(){
        if(isValidInfos()){
            // stage properties
            Stage sendStage = new Stage();
            sendStage.getIcons().add(new Image("recsources/Order Sent Successfully Icon.png"));
            sendStage.setX(700);
            sendStage.setY(150);

            Scene sendScene = createSendScene();
            sendStage.setScene(sendScene);

            sendStage.show();
        }
   }
   private Scene createSendScene(){
       Text orderInfos = new Text(getOrderInfos());
       Label orderSentLbl = new Label("Order Sent Successfully");

       orderInfos.setFont(new Font("Sylfaen",16.5));
       orderSentLbl.setFont(new Font("Sylfaen",25));
       orderInfos.setFill(Color.rgb(80, 80, 80));
       orderSentLbl.setTextFill(Color.rgb(0,80,0));


        // root properties
       VBox sendRoot = new VBox(10,orderInfos,orderSentLbl);
       sendRoot.setAlignment(Pos.CENTER);
       sendRoot.setSpacing(70);

       //send scene
       Scene sendScene = new Scene(sendRoot,380,250);

       return sendScene;
   }



    // Evenets ===============================================================
    //Input actions ==========================================================
    private void inputActions() {

    }
    //Crust actions ==========================================================
    private void crustActions(){
        thin_option.setOnAction(actionEvent -> {
            if(thick_option.isSelected()){
                thick_option.setSelected(false);
            }
        });
        thick_option.setOnAction(actionEvent -> {
            if(thin_option.isSelected()){
                thin_option.setSelected(false);
            }
        });
    }
    //finish order buttons ===================================================
    private void finishActions(){
        send_order_btn.setOnAction(actionEvent -> {
            sendResultStage();
        });
    }


    //get order infos ========================================================
    private String getOrderInfos(){
        String crustType;
        if(thick_option.isSelected())
            crustType = thick_option.getText();
        else
            crustType = thin_option.getText();

        String toppings = "";
        if(olives_cb.isSelected())
            toppings += olives_cb.getText()+ " ";
        if (mushroom_cb.isSelected())
            toppings += mushroom_cb.getText()+ " ";
        if(corn_cb.isSelected())
            toppings += corn_cb.getText() + " ";
        if(sausage_cb.isSelected())
            toppings += sausage_cb.getText();

        return String.format("Name: %s     Phone number: %s%n" +
                "Toppings: %s%n"
                + "Crust: %s",name_tf.getText(),phone_tf.getText(),toppings,crustType);
    }
}