package ru.arinageek.ButcherShop.meat;

public class Filters {
    private Double maxPrice = DEFAULT_MAX_PRICE;
    private String searchQuery = DEFAULT_SEARCH_QUERY;

    public Filters() {}

    public Filters(Double maxPrice, String searchQuery) {
        this.maxPrice = maxPrice;
        this.searchQuery = searchQuery;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    final static Double DEFAULT_MAX_PRICE = 2000.0;
    final static String DEFAULT_SEARCH_QUERY = "";
}
