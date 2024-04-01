import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import javafx.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.scene.Node;
import java.util.HashMap;
import java.util.Map;


public class Main extends Application {
    Stage primaryStage;
    Color color = Color.web("#c6cabc");
    HBox menuItems;
    private Scene homeScene;
    Scene menuScene;
    Scene galleryScene;
    Scene bookingScene;
    Scene contactsScene;

    @Override
    public void start(Stage primaryStage)  {
        this.primaryStage = primaryStage;
        Group root1 = new Group();
        ScrollPane scroll1 = new ScrollPane(root1);
        menuItems = new HBox();
        menuItems.setBackground(new Background(new BackgroundFill(color ,null,null)));
        Button home = new Button("Home");
        home.setStyle("-fx-background-color: transparent;");

        Button menu = new Button("Menu");
        menu.setStyle("-fx-background-color: transparent;");
        menu.setOnAction(e -> primaryStage.setScene(getMenuScene()));

        Button gallery = new Button("Gallery");
        gallery.setStyle("-fx-background-color: transparent;");
        gallery.setOnAction(e -> primaryStage.setScene(getGalleryScene()));

        Button bookingButton = new Button("Booking");
        bookingButton.setOnAction(e -> {
            try {
                primaryStage.setScene(getBookingScene());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bookingButton.setStyle("-fx-background-color: transparent;");

        Button contacts = new Button("Contacts");
        contacts.setOnAction(e-> primaryStage.setScene(getContactScene()));
        contacts.setStyle("-fx-background-color: transparent;");
        Pane spacer = new Pane();
        spacer.setMinWidth(850);
        menuItems.getChildren().addAll(home, spacer, menu, gallery, bookingButton, contacts);
        VBox imageHolder = new VBox();
        Text text = new Text("Eat Pray Love");
        text.setFont(Font.font("Castellar", FontWeight.BOLD, 100));
        text.setFill(Color.WHITE);
        StackPane stackPane = new StackPane();
        Image image = new Image("IMG_7415.JPG");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(550);
        imageView.setFitWidth(1300);
        stackPane.getChildren().addAll(imageView, text);
        Text welcome = new Text("Welcome To Sweetie!");
        Text intro = new Text("Sweetie Café is more than just a place to enjoy a delicious meal." +
                " It's a place where memories are made, friendships are formed," +
                " and laughter fills the air. ");
        Pane spacer5 = new Pane();
        spacer5.setPrefWidth(1200);
        spacer5.setPrefHeight(100);
        Pane spacer6 = new Pane();
        spacer6.setPrefWidth(1200);
        spacer6.setPrefHeight(100);
        welcome.setFont(Font.font("Bell MT", FontPosture.ITALIC, 60));
        intro.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 25));
        intro.setWrappingWidth(1000);
        HBox hbox = new HBox();
        Image img = new Image("77f489824039a10734649c7d6f441f58.jpg");
        ImageView im = new ImageView(img);
        im.setFitWidth(450);
        im.setFitHeight(600);

        VBox texts = new VBox();
        Pane space = new Pane();
        space.setPrefWidth(100);
        texts.setSpacing(35);
        texts.setAlignment(Pos.TOP_CENTER);
        Text popular = new Text();
        popular.setText("Menu Favorites");
        popular.setFont(Font.font("Lucida Bright", FontWeight.BOLD,30));
        Text pop1 = new Text("Asian Pear Salad");
        Text des1 = new Text("Crisp pears and pecans with tender frisee, and  maple syrup with cheese.");
        des1.setWrappingWidth(500);
        des1.setFont(Font.font("Lucida Bright",FontPosture.REGULAR,20));
        HBox first = new HBox();
        first.setSpacing(10);
        Pane firstp = new Pane();
        firstp.setPrefHeight(10);
        VBox firstv = new VBox();
        firstv.getChildren().addAll(pop1,firstp, des1);
        Line line1 = new Line();
        line1.setEndY(80);
        line1.setStrokeWidth(3);
        first.getChildren().addAll(line1,firstv);
        pop1.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 20));

        Text pop2 = new Text("Banana Split");
        Pane secondp = new Pane();
        Text des2 = new Text("Featuring scoops of vanilla, chocolate, and strawberry ice cream nestled between banana ");
        des2.setWrappingWidth(500);
        des2.setFont(Font.font("Lucida Bright",FontPosture.REGULAR,20));
        HBox second = new HBox();
        second.setSpacing(10);
        VBox secondv = new VBox();
        secondv.getChildren().addAll(pop2,secondp, des2);
        Line line2 = new Line();
        line2.setEndY(80);
        line2.setStrokeWidth(3);
        second.getChildren().addAll(line2,secondv);
        HBox.setMargin(second,new Insets(10,0,10,0));
        pop2.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 20));

        Text pop3 = new Text("Dessert Sampler");
        Pane thirdp = new Pane();
        Text des3 = new Text("A selection of our chef's favorite desserts, including tiramisu, creme brule, and chocolate lava cake.");
        des3.setWrappingWidth(500);
        des3.setFont(Font.font("Lucida Bright",FontPosture.REGULAR,20));
        HBox third = new HBox();
        third.setSpacing(10);
        VBox thirdv = new VBox();
        thirdv.getChildren().addAll(pop3, thirdp, des3);
        Line line3 = new Line();
        line3.setEndY(90);
        line3.setStrokeWidth(3);
        third.getChildren().addAll(line3, thirdv);
        pop3.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 20));

        Text pop4 = new Text("Thai tea");
        Pane fourp = new Pane();
        Text des4 = new Text("Sweet, creamy beverage made from strongly brewed Ceylon tea, often spiced with star anise ");
        des4.setFont(Font.font("Lucida Bright",FontPosture.REGULAR,20));
        des4.setWrappingWidth(500);
        HBox four = new HBox();
        four.setSpacing(10);
        VBox fourv = new VBox();
        fourv.getChildren().addAll(pop4, fourp, des4);
        Line line4 = new Line();
        line4.setEndY(72);
        line4.setStrokeWidth(3);
        four.getChildren().addAll(line4, fourv);
        pop4.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 20));

        Button openMenu = new Button("Main Menu");
        openMenu.setPrefSize(100,40);
        openMenu.setOnAction(e -> primaryStage.setScene(getMenuScene()));
        openMenu.setStyle("-fx-background-color: Black; -fx-text-fill: White");

        texts.getChildren().addAll(popular, first, second, third, four, openMenu);
        hbox.getChildren().addAll(im,space, texts);
        imageHolder.getChildren().addAll(menuItems,stackPane, spacer5, welcome, intro,spacer6, hbox);
        imageHolder.setAlignment(Pos.CENTER);
        imageHolder.setStyle("-fx-background-color: #c6cabc");

        VBox bookingMenu = new VBox();
        bookingMenu.setStyle("-fx-background-color: #ddcbac");
        HBox imageFolder = new HBox();
        Image bookImage = new Image("82ab0f61694bb4bfd6041d390cb0a694.jpg");
        ImageView bImageView  = new ImageView(bookImage);
        VBox inside = new VBox();
        Text start = new Text("Escape to a Haven of Serenity: ");
        start.setFont(Font.font("Bell MT", FontPosture.ITALIC, 50));
        Text question = new Text("Step into our café and let the world outside fade away. " +
                "With its soft lighting, gentle music, and inviting nooks, " +
                "it's the perfect retreat for those seeking a moment of peace with " +
                "their favorite cup.");
        question.setFont(Font.font("Book Antiqua", FontPosture.REGULAR, 27));
        question.setWrappingWidth(450);
        Pane paneForB = new Pane();
        paneForB.setPrefWidth(150);
        Button openBooking = new Button("I want to book a place");
        openBooking.setStyle("-fx-text-fill: White; -fx-background-color: Black");
        openBooking.setOnAction(e -> {
            try {
                primaryStage.setScene(getBookingScene());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        openBooking.setPrefSize(200, 50);
        inside.setAlignment(Pos.CENTER);
        inside.setSpacing(30);
        inside.setPadding(new Insets(70, 70, 70, 70));
        inside.getChildren().addAll(start, question, openBooking);
        imageFolder.getChildren().addAll(inside, bImageView);
        bookingMenu.getChildren().addAll(imageHolder,imageFolder);
        root1.getChildren().addAll(bookingMenu);
        homeScene = new Scene(scroll1, 1200,1000);


        primaryStage.setScene(homeScene);
        primaryStage.show();
    }
    public Scene getMenuScene() {
        VBox mainV = new VBox();
        BorderPane borderPane = new BorderPane(mainV);
        HBox menuItems = new HBox();
        menuItems.setStyle("-fx-background-color: #d7cbb5");
        Pane non = new Pane();
        non.setMinWidth(850);
        Button home = new Button("Home");
        home.setStyle("-fx-background-color: transparent");
        home.setOnAction(e-> primaryStage.setScene(homeScene));
        Button menu = new Button("Menu");
        menu.setStyle("-fx-background-color: transparent");
        Button gallery = new Button("Gallery");
        gallery.setStyle("-fx-background-color: transparent");
        gallery.setOnAction(e-> primaryStage.setScene(getGalleryScene()));
        Button booking = new Button("Booking");
        booking.setStyle("-fx-background-color: transparent");
        booking.setOnAction(e-> {
            try{
                primaryStage.setScene(getBookingScene());
            }catch(IOException io){
                throw new RuntimeException();
            }
        });
        Button contacts = new Button("Contacts");
        contacts.setStyle("-fx-background-color: transparent");
        contacts.setOnAction(e-> primaryStage.setScene(getContactScene()));

        VBox menuText = new VBox();
        Text me = new Text("ME");
        me.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 100));
        me.setWrappingWidth(324);
        me.setTextAlignment(TextAlignment.RIGHT);
        Text nu = new Text("NU");
        nu.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 100));
        me.setWrappingWidth(324);
        menuText.setAlignment(Pos.TOP_RIGHT);
        nu.setTextAlignment(TextAlignment.RIGHT);
        menuText.getChildren().addAll(me,nu);

        Text d1 = new Text("Main Course.");
        d1.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 28));
        Text d2 = new Text("Grilled Fingerlings                      6.99");
        Text d3 = new Text("grilled potatoes with a western floir served with souce of choice");
        Text d4 = new Text("Asian Pear Salad                         6.49");
        Text d5 = new Text("Crisp pears and pecans with tender frisee, and maple syrup with cheese.");
        Text d6 = new Text("Roasted Acorn Squash               5.99");
        Text d7 = new Text("Spicy - sweet, solt wedges potatoes which makes a no-fuss holiday meal.");
        Text d8 = new Text("Smothered Chicken                    6.99");
        Text d9 = new Text("Drilled chicken breast topped with mushrooms, onions and Cheese.");
        d2.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 20));
        d3.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 14));
        d4.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 20));
        d5.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 14));
        d6.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 20));
        d7.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 14));
        d8.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 20));
        d9.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 14));
        d3.setWrappingWidth(280);
        d5.setWrappingWidth(280);
        d7.setWrappingWidth(280);
        d9.setWrappingWidth(280);

        VBox v1 = new VBox();

        Text d10 = new Text("Dessert.");
        Text d11 = new Text("Banana Split                               4.49");
        Text d12 = new Text("Cheese Cake                               3.99");
        Text d13 = new Text("Chocolate ice Cream                  5.49");
        d10.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 28));
        d11.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 20));
        d12.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 20));
        d13.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 20));
        v1.getChildren().addAll(menuText,d1, d2,d3,d4,d5,d6,d7,d8,d9, d10,d11,d12,d13);
        v1.setSpacing(15);

        Text d14 = new Text("Appetizer.");
        Text d15 = new Text("Garlic Bread          5.50");
        Text d16 = new Text("Potato Wedges         4.49");
        Text d17 = new Text("Meat Ball            6.01");
        Text d18 = new Text("Rotatouille          6.99");
        d14.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 30));
        d15.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 20));
        d16.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 20));
        d17.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 20));
        d18.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 20));
        VBox v2 = new VBox();

        v2.setSpacing(15);

        Pane chef = new Pane();
        chef.setPrefHeight(47);
        chef.prefWidth(347);
        chef.setStyle("-fx-background-color: Black");
        Text special = new Text("Chef's specials. ");
        special.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 30));
        special.setFill(Color.WHITE);
        special.setLayoutX(20);
        special.setLayoutY(30);
        chef.getChildren().add(special);
        Text d19 = new Text("Beef Wellington               10.99");
        Text d20 = new Text("Classic dish featuring tender beef tenderloin coated with mushroom duxelles and wrapped in puff pastry.");
        Text d21 = new Text("Lobster Ravioli                 9.99");
        Text d22 = new Text("Homemade ravioli stuffed with fresh lobster meat and ricotta cheese.");
        Text d23 = new Text("Vegetarian Risotto           14.99");
        Text d24 = new Text("Creamy risotto cooked with Arborio rice, mixed vegetables, and Parmesan cheese.");
        Text d25 = new Text("Dessert Sampler              12.99");
        Text d26 = new Text("A selection of our chef's favorite desserts, including tiramisu, crème brûlée, and chocolate lava cake.");
        d19.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 20));
        d20.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 14));
        d21.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 20));
        d22.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 14));
        d23.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 20));
        d24.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 14));
        d25.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 20));
        d26.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 14));
        d20.setWrappingWidth(280);
        d22.setWrappingWidth(280);
        d24.setWrappingWidth(280);
        d26.setWrappingWidth(280);

        Text d27 = new Text("Drinks.");
        Text d28 = new Text("Latte                                         4.40");
        Text d29 = new Text("Ice / Hot Tea                            3.99");
        Text d30 = new Text("Thai Tea                                   4.99");
        Text d31 = new Text("Soda                                         3.99");
        d27.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 30));
        d28.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 20));
        d29.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 20));
        d30.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 20));
        d31.setFont(Font.font("Lucida Bright", FontPosture.REGULAR, 20));
        Image food = new Image("Healthy-Food-Plate-PNG.png");
        ImageView dish = new ImageView(food);
        dish.setFitWidth(400);
        dish.setFitHeight(660);

        v2.getChildren().addAll(d14,d15, d16, d17, d18, chef,d19,d20,d21,d22,d23,d24, d25,d26,d27,d28,d29,d30,d31);

        HBox horizontal = new HBox();
        horizontal.getChildren().addAll(v1,dish, v2);
        horizontal.setSpacing(30);
        horizontal.setAlignment(Pos.CENTER);
        horizontal.setPadding(new Insets(20));

        menuItems.getChildren().addAll(home,non, menu, gallery,booking, contacts);
        mainV.setStyle("-fx-background-color: #d7cbb5");
        mainV.getChildren().addAll(menuItems, horizontal);

        menuScene = new Scene(borderPane, 1200,1000);
        return menuScene;
    }
    public Scene getBookingScene() throws IOException {
        Group root2 = new Group();
        Pane scroll2 = new Pane(root2);

        ArrayList<Booking> bookings = new ArrayList<>();
        String filePath = "booking.txt";
        if (Files.exists(Paths.get(filePath))) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                Booking booking = new Booking();
                while ((line = reader.readLine()) != null) {
                    if(line.equals("---====---")){
                        bookings.add(booking);
                        booking = new Booking();
                    } else{
                        String type = "";
                        int kos = line.indexOf(':');
                        for(int i =0;i<kos; i++)
                            type+=line.charAt((i));
                        int utur = line.indexOf((';'));
                        String value ="";
                        for (int i=kos+1; i<utur; i++)
                            value+=line.charAt((i));
                        switch (type){
                            case "name": booking.setName(value); break;
                            case "email": booking.setEmail(value); break;
                            case "phone": booking.setPhoneNumber(value); break;
                            case "date": booking.setDate(value); break;
                            case "time": booking.setTime(value); break;
                            case "size": booking.setSize(value); break;
                            case "specialRequests": booking.setSpecialRequests(value); break;
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println("Произошла ошибка при чтении файла: " + e.getMessage());
            }
        } else {
            File file = new File("booking.txt");
            FileWriter fw = new FileWriter(file, true);
            fw.write("");
            fw.close();
        }
        HBox menuItems1 = new HBox();
        menuItems1.setStyle("-fx-background-color: #c6cabc");
        Button specialButton = new Button("Home");
        specialButton.setOnAction(e -> primaryStage.setScene(homeScene));
        specialButton.setStyle("-fx-background-color: transparent;");

        Button menu1 = new Button("Menu");
        menu1.setStyle("-fx-background-color: transparent;");
        menu1.setOnAction(e -> primaryStage.setScene(getMenuScene()));

        Button gallery1 = new Button("Gallery");
        gallery1.setStyle("-fx-background-color: transparent;");
        gallery1.setOnAction(e -> primaryStage.setScene(getGalleryScene()));
        Button booking1 = new Button("Booking");
        booking1.setOnAction(e-> {
            try {
                primaryStage.setScene(getBookingScene());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        booking1.setStyle("-fx-background-color: transparent;");

        Button contacts1 = new Button("Contacts");
        contacts1.setStyle("-fx-background-color: transparent;");
        contacts1.setOnAction(e-> primaryStage.setScene(getContactScene()));
        Pane spacer1 = new Pane();
        spacer1.setMinWidth(840);
        menuItems1.getChildren().addAll(specialButton,spacer1, menu1, gallery1,booking1, contacts1);

        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.TOP_LEFT);
        vbox.setPadding(new Insets(0, 10, 10, 10));
        vbox.setFillWidth(true);
        Text mainText = new Text("BOOKING");
        mainText.setFont(Font.font("Lucida Bright", FontWeight.BOLD, 50));

        Label name = new Label("Name: (required)");

        TextField nameField = new TextField();
        name.setFont(Font.font("Lucida Bright", FontWeight.BOLD, 20));
        nameField.setMaxWidth(200);

        Label email = new Label("Email: (required)");
        TextField emailField = new TextField();
        email.setFont(Font.font("Lucida Bright", FontWeight.BOLD, 20));
        emailField.setMaxWidth(200);

        Label phone = new Label("Phone number: ");
        TextField phoneField = new TextField();
        phone.setFont(Font.font("Lucida Bright", FontWeight.BOLD, 20));
        phoneField.setMaxWidth(200);

        Label date = new Label("Date: (required)");
        date.setFont(Font.font("Lucida Bright", FontWeight.BOLD, 20));
        DatePicker datePicker = new DatePicker();
        datePicker.setValue(LocalDate.now());
        datePicker.setDayCellFactory(getDayCellFactory());
        datePicker.setEditable(false);

        Label time = new Label("Time: (required)");
        time.setFont(Font.font("Lucida Bright", FontWeight.BOLD, 20));
        ComboBox<String> timePicker = new ComboBox<>();
        String[] times = {"11.00", "12.00", "13.00", "14.00", "15.00", "16.00", "17.00", "18.00"};
        timePicker.setCellFactory(lv -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setDisable(false);
                    setStyle("");
                } else {
                    setText(item);
                    if (!isTimeAvailable(item,bookings, String.valueOf(datePicker.getValue()))) {
                        setDisable(true);
                        setStyle("-fx-text-fill: gray; -fx-background-color: #d49696;");
                    } else {
                        setDisable(false);
                        setStyle("-fx-text-fill: black;");
                    }
                }
            }
        });

        timePicker.getItems().addAll(times);
        datePicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            timePicker.getItems().clear();

            timePicker.setValue(null);
            timePicker.setCellFactory(lv -> new ListCell<String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                        setDisable(false);
                        setStyle("");
                    } else {
                        setText(item);
                        if (!isTimeAvailable(item,bookings, String.valueOf(newValue))){
                            setDisable(true);
                            setStyle("-fx-text-fill: gray; -fx-background-color: #ffc0c0;");
                        } else {
                            setDisable(false);
                            setStyle("-fx-text-fill: black;");
                        }
                    }
                }
            });

            timePicker.getItems().addAll(times);
        });

        Label size = new Label("Size: (required)");
        size.setFont(Font.font("Lucida Bright", FontWeight.BOLD, 20));
        ComboBox<Integer> sizePicker = new ComboBox<>();
        sizePicker.getItems().addAll(1, 2, 3, 4, 5, 6);

        Label specialRequests = new Label("Special Requests:");
        TextArea requestsArea = new TextArea();

        requestsArea.setWrapText(true);
        requestsArea.setMaxWidth(300);
        requestsArea.setMaxHeight(150);

        Button book = new Button("Finish Booking");
        book.setPadding(new Insets(5,5,5,5));
        book.setPrefSize(140,30);
        book.setStyle("-fx-background-color: #626c55; -fx-text-fill: White");
        book.setOnAction(e -> {

            try {
                if (nameField.getText().length() == 0) {
                    throw new Exception("Enter proper name!");
                } else if(nameField.getText().matches(".*\\d.*")){
                    throw new Exception("Enter proper name!");
                } else if(emailField.getText().length()==0){
                    throw new Exception("Enter proper email!");
                } else if(emailField.getText().indexOf('@')==-1){
                    throw new Exception("Enter proper email!");
                } else if(phoneField.getText().length()!=0 && phoneField.getText().length()!=11) {
                    throw new Exception("Enter correct phone number!");
                } else if(phoneField.getText().length()!=0 && !phoneField.getText().matches("^[0-9]+$")){
                    throw new Exception("Enter correct phone number!");
                } else if (datePicker.getValue() == null) {
                    throw new Exception("Please select a date for your booking.");
                } else if (timePicker.getValue() == null) {
                    throw new Exception("Please select a time for your booking.");
                } else if (sizePicker.getValue() == null) {
                    throw new Exception("Please select the size of your group.");
                }
                String bookingValue = "name:" + nameField.getText()+";\n"+
                        "email:" +emailField.getText()+";\n"+
                        "phone:" +phoneField.getText()+";\n"+
                        "date:" +datePicker.getValue()+";\n"+
                        "time:" +timePicker.getValue()+";\n"+
                        "size:" +sizePicker.getValue()+";\n"+
                        "specialRequests:" +requestsArea.getText()+";\n"+
                        "---====---";
                writeToFile("booking.txt",bookingValue);
                bookings.clear();
                if (Files.exists(Paths.get(filePath))) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                        String line;
                        Booking booking2 = new Booking();
                        while ((line = reader.readLine()) != null) {
                            if(line.equals("---====---")){
                                bookings.add(booking2);
                                booking2 = new Booking();
                            } else{
                                String type = "";
                                int kos = line.indexOf(':');
                                for(int i =0;i<kos; i++)
                                    type+=line.charAt((i));
                                int utur = line.indexOf((';'));
                                String value ="";
                                for (int i=kos+1; i<utur; i++)
                                    value+=line.charAt((i));
                                switch (type){
                                    case "name": booking2.setName(value); break;
                                    case "email": booking2.setEmail(value); break;
                                    case "phone": booking2.setPhoneNumber(value); break;
                                    case "date": booking2.setDate(value); break;
                                    case "time": booking2.setTime(value); break;
                                    case "size": booking2.setSize(value); break;
                                    case "specialRequests": booking2.setSpecialRequests(value); break;

                                }
                            }

                        }
                    } catch (IOException ex) {
                        System.err.println("Error: " + ex.getMessage());
                    }
                } else {
                    System.err.println("File does not exist: " + filePath);
                }
                nameField.setText("");
                emailField.setText("");
                phoneField.setText("");
                requestsArea.setText("");
                datePicker.setValue(LocalDate.now());
                timePicker.setValue("");
                sizePicker.setValue(null);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Booking is successfully");
                Image le = new Image("icons8-booking-80.png");
                ImageView finish = new ImageView(le);
                alert.setGraphic(finish);
                alert.show();
                timePicker.setCellFactory(lv -> new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setText(null);
                            setDisable(false);
                            setStyle("");
                        } else {
                            setText(item);
                            if (!isTimeAvailable(item,bookings, String.valueOf(datePicker.getValue()))) {
                                setDisable(true);
                                setStyle("-fx-text-fill: gray; -fx-background-color: #ffc0c0;");
                            } else {
                                setDisable(false);
                                setStyle("-fx-text-fill: black;");
                            }
                        }
                    }
                });
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
                alert.show();
            }
        });
        VBox example = new VBox();
        example.getChildren().addAll(mainText, name, nameField, email, emailField, phone, phoneField, date, datePicker,
                time, timePicker, size, sizePicker, specialRequests, requestsArea, book);
        example.setStyle("-fx-background-color: rgba(255,255,255,0.7)");
        example.setMaxWidth(500);
        example.setPadding(new Insets(50,0,50,0));
        example.setAlignment(Pos.CENTER);
        example.setSpacing(10);
        VBox.setMargin(example, new Insets(100, 0,0,0));
        vbox.getChildren().addAll(menuItems1, example);
        vbox.setAlignment(Pos.CENTER);

        scroll2.setStyle("-fx-background-image: url('n.jpg'); -fx-background-repeat: no-repeat;" +
                "-fx-background-size: cover;");
        root2.getChildren().addAll(vbox);

        return bookingScene = new Scene(scroll2, 1200, 1000);

    }
    public Scene getGalleryScene(){
        Group root3 = new Group();
        HBox menuItems2 = new HBox();
        menuItems2.setStyle("-fx-background-color: #c6cabc");
        Button home2 = new Button("Home");
        home2.setStyle("-fx-background-color: transparent");
        home2.setOnAction(e-> primaryStage.setScene(homeScene));
        Button menu2 = new Button("Menu");
        menu2.setStyle("-fx-background-color: transparent");
        menu2.setOnAction(e-> primaryStage.setScene(getMenuScene()));
        Button booking2 = new Button("Booking");
        booking2.setStyle("-fx-background-color: transparent");
        booking2.setOnAction(e-> {
            try {
                primaryStage.setScene(getBookingScene());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        Button gallery2 = new Button("Gallery");
        gallery2.setStyle("-fx-background-color: transparent");
        gallery2.setOnAction(e -> primaryStage.setScene(getGalleryScene()));
        Button contacts2 = new Button("Contacts");
        contacts2.setStyle("-fx-background-color: transparent");
        contacts2.setOnAction(e-> primaryStage.setScene(getContactScene()));
        Pane spacer2 = new Pane();
        spacer2.setMinWidth(850);

        menuItems2.getChildren().addAll(home2,spacer2,menu2,gallery2,booking2,contacts2);
        root3.getChildren().add(menuItems2);


        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: #e0d8cb");
        VBox last = new VBox();
        last.getChildren().addAll(menuItems2,gridPane);
        ScrollPane scrollPane = new ScrollPane(last);
        scrollPane.setStyle("-fx-background-color: #e0d8cb");
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));

        Map<String, String> imagePaths = new HashMap<>();
        imagePaths.put("asianPearSalad.jpg", "This is an Asian Pear Salad, 6.49$");
        imagePaths.put("bananaSplit.jpg", "This is a Banana Split, 4.49$");
        imagePaths.put("beef.jpg", "This is a Beef Wellington, 10.99$");
        imagePaths.put("cheeseCake.jpg", "This is cheese Cake, 3.99$");
        imagePaths.put("chocolateIceCream.jpg", "This is a Chocolate Ice Cream, 5.49$");
        imagePaths.put("frenchFries.jpg", "This is a Potato Wedges, 4.99$");
        imagePaths.put("fruitCake.jpg", "this is a Fruit Cake, 12.99$");
        imagePaths.put("garlicBread.jpg", "This is a Garlic Bread, 5.50$");
        imagePaths.put("grilledFingerlings.jpg", "This is a Grilled Fingerlings, 6.99$");
        imagePaths.put("iceTea.jpg", "This is an Ice Tea, 3.99$");
        imagePaths.put("latte.jpg", "This is a Latte, 4.40$");
        imagePaths.put("lobster.jpg", "This is a Lobster Ravioli, 9.99$");
        imagePaths.put("meatBall.jpg", "This is a Meat Ball, 6.01$");
        imagePaths.put("roastedAcornSquash.jpg", "This is a Roasted Acorn Squash, 5.99$");
        imagePaths.put("rotatouille.jpg", "This is a Rotatouille, 6.99$");
        imagePaths.put("smotheredChicken.jpg", "This is Smothered Chicken, 6.99$");
        imagePaths.put("soda.jpg", "This is a Soda, 3.99$");
        imagePaths.put("thaitea.jpg", "This is a Thai Tea, 4.99$");
        imagePaths.put("vegetarian.jpg", "This is a Vegetarian Risotto, 14.99$");
        imagePaths.put("sweet.jpg", "This is a Dessert Sampler, 12.99$");

        List<String> list = new ArrayList<>(imagePaths.keySet());
        Collections.shuffle(list);

        int numberOfRows = 6;
        int numberOfColumns = 3;
        for (int i = 0, imageIndex = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++, imageIndex++) {
                if (imageIndex < imagePaths.size()) {
                    String imagePath = list.get(imageIndex);
                    Image imagenew = new Image(imagePath);
                    ImageView imageViewnew = new ImageView(imagenew);
                    imageViewnew.setFitWidth(400);
                    imageViewnew.setFitHeight(400);
                    imageViewnew.setPreserveRatio(true);
                    Rectangle clip = new Rectangle(400, 400);
                    clip.setArcWidth(20);
                    clip.setArcHeight(20);
                    imageViewnew.setClip(clip);

                    final String message = imagePaths.get(imagePath);
                    imageViewnew.setOnMouseClicked(e -> {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information:");
                        alert.setHeaderText(null);
                        alert.setContentText(message);
                        Image al = new Image("icons8-info-100.png");
                        ImageView forAlert = new ImageView(al);
                        forAlert.setFitWidth(100);
                        forAlert.setFitHeight(100);
                        alert.setGraphic(forAlert);

                        alert.showAndWait();
                    });

                    gridPane.add(imageViewnew, j, i);
                }
            }
        }

        return galleryScene = new Scene(scrollPane, 1200, 1000);
    }

    public Scene getContactScene(){
        Group root4 = new Group();
        ScrollPane scroll4 = new ScrollPane(root4);
        Pane line = new Pane();
        line.setStyle("-fx-background-color: black");
        line.setPrefSize(1200,3);
        HBox menuItems3 = new HBox();
        menuItems3.setStyle("-fx-background-color: #ecd493");
        Button home3 = new Button("Home");
        home3.setStyle("-fx-background-color: transparent;");
        home3.setOnAction(e-> primaryStage.setScene(homeScene));
        Button menu3 = new Button("Menu");
        menu3.setStyle("-fx-background-color: transparent;");
        menu3.setOnAction(e-> primaryStage.setScene(getMenuScene()));
        Button booking3 = new Button("Booking");
        booking3.setStyle("-fx-background-color: transparent;");
        booking3.setOnAction(e-> {
            try {
                primaryStage.setScene(getBookingScene());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        Button gallery3 = new Button("Gallery");
        gallery3.setStyle("-fx-background-color: transparent;");
        gallery3.setOnAction(e-> primaryStage.setScene(getGalleryScene()));
        Button contacts3 = new Button("Contacts");
        contacts3.setStyle("-fx-background-color: transparent;");
        Pane spacer3 = new Pane();
        spacer3.setMinWidth(850);
        menuItems3.getChildren().addAll(home3,spacer3,menu3,gallery3,booking3,contacts3);
        VBox content = new VBox();
        Image map = new Image("map.png");
        ImageView maps = new ImageView(map);
        maps.setFitHeight(400);
        maps.setFitWidth(1200);
        content.getChildren().addAll(menuItems3,line,maps);

        Pane fields = new Pane();
        fields.setMaxHeight(10);
        VBox forContact = new VBox();
        HBox ep = new HBox();
        HBox.setMargin(ep, new Insets(30,50,0,20));
        Text inspiration = new Text("Help us in creating cafe of our dreams.");
        inspiration.setFont(Font.font("Bell MT", FontPosture.ITALIC, 40));
        TextField e = new TextField();
        e.setPromptText("email(required)");
        e.setStyle("-fx-background-color: #f2b826; -fx-prompt-text-fill: grey");
        TextField p = new TextField();
        p.setPromptText("phone number(required)");
        p.setStyle("-fx-background-color: #f2b826; -fx-prompt-text-fill: grey");
        ep.getChildren().addAll(e,p);
        TextField n = new TextField();
        n.setPromptText("name");
        n.setStyle("-fx-background-color: #f2b826; -fx-prompt-text-fill: grey");
        TextArea a = new TextArea();
        a.setPromptText("your experience");
        a.setStyle("-fx-background-color: #f2b826; -fx-prompt-text-fill: grey");
        Button send = new Button("Share my opinion");
        send.setPrefSize(200,70);
        send.setTextAlignment(TextAlignment.CENTER);
        send.setStyle("-fx-background-color: #f2b826; -fx-text-fill: Black; -fx-font-size: 17px; -fx-font-weight: bold;");
        forContact.setAlignment(Pos.CENTER);
        send.setOnAction(event -> {
            try {
                if (e.getText().isEmpty()) {
                    throw new Exception("We need your email to reconnect with you.");
                } else if (!e.getText().contains("@")) {
                    throw new Exception("Enter a correct email address.");
                } else if (!p.getText().isEmpty() && p.getText().length() != 11) {
                    throw new Exception("Enter a correct phone number!");
                } else if (!p.getText().isEmpty() && !p.getText().matches("^[0-9]+$")) {
                    throw new Exception("Phone number should not contain any letters.");
                }
                String feedback = "email: " + e.getText() + "\nphone: " + p.getText() + "\nname: " + n.getText() + "\nFeedBack: " + a.getText()+"\n--------------";
                writeToFile("feedback.txt", feedback);
                Alert sent = new Alert(Alert.AlertType.INFORMATION, "Thank you! We appreciate your opinion.");
                Image ima = new Image("icons8-thanks-64.png");
                ImageView thanks = new ImageView(ima);
                sent.setGraphic(thanks);
                sent.show();
                e.setText("");
                p.setText("");
                a.setText("");
                n.setText("");
            } catch (Exception excep) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR, excep.getMessage());
                errorAlert.showAndWait();
            }
        });

        forContact.setSpacing(20);
        forContact.setPadding(new Insets(40));
        forContact.setStyle("-fx-background-color: #fcf1b7");
        ep.setSpacing(20);
        e.setMinWidth(300);
        e.setMinHeight(40);
        p.setMinWidth(300);
        p.setMinHeight(40);
        n.setMaxWidth(620);
        n.setMinHeight(40);
        a.setMaxWidth(620);

        HBox info = new HBox();
        info.setSpacing(50);
        info.setStyle("-fx-background-color: #fcf1b7");

        Text num = new Text("  8-800-800-08-08");
        num.setFont(Font.font("Cascadia Code", FontWeight.BOLD,20));
        num.setFill(Color.WHITE);
        Text help1 = new Text("We are happy to receive your call at any time :)");
        help1.setWrappingWidth(220);
        help1.setTextAlignment(TextAlignment.CENTER);
        help1.setFont(Font.font("Cascadia Code", FontWeight.BOLD,20));
        help1.setFill(Color.WHITE);
        VBox numberBox = new VBox();
        numberBox.setSpacing(5);
        numberBox.setStyle("-fx-background-color: #ecd493; -fx-background-radius: 50");
        numberBox.setPrefSize(250,250);
        Image phineIcon = new Image("icons8-phone-100.png");
        ImageView phoneI = new ImageView(phineIcon);
        numberBox.getChildren().addAll(phoneI, num, help1);

        Text myEmail = new Text("  subb04a@gmail.com");
        myEmail.setFont(Font.font("Cascadia Code", FontWeight.BOLD,20));
        myEmail.setFill(Color.WHITE);
        Text help2 = new Text("If you are uncomfortable with call, we also have an email!");
        help2.setWrappingWidth(220);
        help2.setFont(Font.font("Cascadia Code", FontWeight.BOLD,20));
        help2.setFill(Color.WHITE);
        help2.setTextAlignment(TextAlignment.CENTER);
        VBox emailBox = new VBox();
        emailBox.setSpacing(5);
        emailBox.setStyle("-fx-background-color: #ecd493; -fx-background-radius: 50");
        emailBox.setPrefSize(250,250);
        Image emailIcon = new Image("icons8-email-100.png");
        ImageView emailI = new ImageView(emailIcon);
        emailBox.getChildren().addAll(emailI, myEmail, help2);

        Text location = new Text("  Kasqelen KZ");
        location.setFont(Font.font("Cascadia Code", FontWeight.BOLD,20));
        location.setFill(Color.WHITE);
        Text help3 = new Text("You can see our office on weekdays");
        help3.setWrappingWidth(220);
        help3.setFont(Font.font("Cascadia Code", FontWeight.BOLD,20));
        help3.setFill(Color.WHITE);
        help3.setTextAlignment(TextAlignment.CENTER);
        VBox locationBox = new VBox();
        locationBox.setSpacing(5);
        locationBox.setStyle("-fx-background-color: #ecd493; -fx-background-radius: 50");
        locationBox.setPrefSize(250,250);
        Image locationIcon = new Image("icons8-location-100.png");
        ImageView locationI = new ImageView(locationIcon);
        locationBox.getChildren().addAll(locationI, location, help3);
        HBox workTime = new HBox();
        VBox weekDays = new VBox();
        Text working = new Text("Our service is available: ");
        working.setFont(Font.font("Bell MT", FontPosture.ITALIC,30));
        Text mon = new Text("Monday:   9.00am - 7.00pm");
        mon.setFont(Font.font("Bell MT", FontPosture.REGULAR, 20));
        Text tues = new Text("Tuesday:   9.00am - 7.00pm");
        tues.setFont(Font.font("Bell MT", FontPosture.REGULAR, 20));
        Text wed = new Text("Wednesday:   9.00am - 7.00pm");
        wed.setFont(Font.font("Bell MT", FontPosture.REGULAR, 20));
        Text thurs = new Text("Thursday:   9.00am - 7.00pm");
        thurs.setFont(Font.font("Bell MT", FontPosture.REGULAR, 20));
        Text fri = new Text("Friday:   9.00am - 7.00pm");
        fri.setFont(Font.font("Bell MT", FontPosture.REGULAR, 20));
        Text sat = new Text("Saturday:   closed");
        sat.setFont(Font.font("Bell MT", FontPosture.REGULAR, 20));
        Text sun = new Text("Sunday:   closed");
        sun.setFont(Font.font("Bell MT", FontPosture.REGULAR, 20));
        weekDays.getChildren().addAll(working,mon,tues,wed,thurs,fri,sat,sun);
        weekDays.setAlignment(Pos.CENTER_LEFT);
        weekDays.setSpacing(20);
        weekDays.setPadding(new Insets(20, 10, 120,20));
        info.setPadding(new Insets(40));
        info.getChildren().addAll(numberBox, emailBox,locationBox);
        forContact.getChildren().addAll(inspiration, ep, n, a, send, fields);
        workTime.getChildren().addAll(forContact,weekDays);

        content.getChildren().addAll(workTime, info);
        content.setStyle("-fx-background-color: #fcf1b7");
        root4.getChildren().addAll(content);
        return contactsScene = new Scene(scroll4, 1200,1000);
    }

    public static void writeToFile(String name,String s){
        try {
            File file = new File(name);
            FileWriter fw = new FileWriter(file, true);
            fw.write(s + "\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("Something went wrong in writing text!");
        }
    }

    class Booking{
        String name;
        String email;
        String phoneNumber;
        String date;
        String time;
        String size;
        String specialRequests;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getSpecialRequests() {
            return specialRequests;
        }

        public void setSpecialRequests(String specialRequests) {
            this.specialRequests = specialRequests;
        }
    }
    boolean isTimeAvailable(String time, ArrayList<Booking> arrayList,String date) {
        for(int i=0;i<arrayList.size();i++){
            if(arrayList.get(i).getDate().equals(date) && arrayList.get(i).getTime().equals(time)){
                return false;
            }
        }
        return true;
    }
    private Callback<DatePicker, DateCell> getDayCellFactory() {
        return new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item.isBefore(LocalDate.now())) {
                            setDisable(true);
                            setStyle("-fx-background-color: #ffc0cb;");
                        }
                    }
                };
            }
        };
    }

    public static void main(String[] args) {
        launch(args);
    }
}