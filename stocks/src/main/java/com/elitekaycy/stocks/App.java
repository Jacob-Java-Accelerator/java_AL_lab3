package com.elitekaycy.stocks;

import io.reactivex.rxjava3.core.Observable;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

  private final StockProcessor stockPriceProcessor = new StockProcessor();
  private final Label priceLabel = new Label("Stock Price: ");

  @Override
  public void start(Stage primaryStage) {
    VBox root = new VBox();
    root.getChildren().addAll(priceLabel);

    Scene scene = new Scene(root, 300, 200);

    primaryStage.setTitle("Real-Time Stock Price");
    primaryStage.setScene(scene);
    primaryStage.show();

    Observable<Double> priceObservable = stockPriceProcessor.getFilteredStockPrices();

    priceObservable.subscribe(price -> primaryStage.setTitle(price.toString()));
    priceObservable.subscribe(price -> System.out.println("sample price " + price));
    priceObservable.subscribe(price -> Platform.runLater(() -> updateUI(priceLabel, price)));

  }

  private void updateUI(Label label, double price) {
    label.setText("Stock Price: " + price);
  }

  public static void main(String[] args) {
    launch(args);
  }
}
