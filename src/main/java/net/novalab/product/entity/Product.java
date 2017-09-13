package net.novalab.product.entity;

import javax.persistence.Entity;
import java.util.Objects;

/**
 * Created by gsoo on 23/08/2017.
 */
@Entity
public class Product {
    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(code, product.code) &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name);
    }
}
