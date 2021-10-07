package br.com.alura.store.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_value")
    private BigDecimal totalValue;

    private LocalDate date = LocalDate.now();

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL) // Necessário por ser um relacionamento bi-direcional (One Order) <=> (Many OrderItem)
    private List<OrderItem> items = new ArrayList<>(); // Sempre inicializar listas para garantir que elas nunca serão nulas

    public Order() {
    }

    public Order(BigDecimal totalValue, LocalDate date, Client client) {
        this.totalValue = totalValue;
        this.date = date;
        this.client = client;
    }

    public Order(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem item) {

        // Importante para que os dois lados do relacionamento estejam ligados (Order e OrderItem)
        item.setOrder(this);
        this.items.add(item);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
