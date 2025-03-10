package com.elitekaycy.stocks;

import com.google.gson.Gson;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class StockProcessor {
  private StockPriceService stockPriceService = new StockPriceService();
  private Gson gson = new Gson();

  public StockProcessor() {
  }

  /**
   * Stream with reactive Programming
   */
  public Observable<Double> getFilteredStockPrices() {
    return this.stockPriceService.fetchCurrentStockPrice()
        .map(response -> gson.fromJson(response, StockData.class))
        .map(stockData -> stockData.getBpi("USD").getRate_float())
        .subscribeOn(Schedulers.io());
  }
}
