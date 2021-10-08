package br.com.alura.store.vo;

import java.time.LocalDate;

public class SalesReportVo {

    private String productName;
    private Long soldAmount;
    private LocalDate lastSale;

    public SalesReportVo() {
    }

    public SalesReportVo(String productName, Long soldAmount, LocalDate lastSale) {
        this.productName = productName;
        this.soldAmount = soldAmount;
        this.lastSale = lastSale;
    }

    @Override
    public String toString() {
        return "SalesReportVo{" +
                "productName='" + productName + '\'' +
                ", soldAmount=" + soldAmount +
                ", lastSale=" + lastSale +
                '}';
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getSoldAmount() {
        return soldAmount;
    }

    public void setSoldAmount(Long soldAmount) {
        this.soldAmount = soldAmount;
    }

    public LocalDate getLastSale() {
        return lastSale;
    }

    public void setLastSale(LocalDate lastSale) {
        this.lastSale = lastSale;
    }
}
