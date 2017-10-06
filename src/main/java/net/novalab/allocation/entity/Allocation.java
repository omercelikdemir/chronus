package net.novalab.allocation.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Entity
@NamedQueries({
        @NamedQuery(name = "Allocation.allocation_from", query = "select a from Allocation a where a.allocationTime > :fromDate order by a.allocationTime asc")
})

public class Allocation {

    public static final String ALLOCATIONS_FROM = "Allocation.allocation_from";

    private String source;
    private Date allocationTime;
    @CollectionTable
    @MapKeyColumn(name = "allocation")
    @Column(name = "quantity")
    @ElementCollection
    private Map<String, Double> allocations;
    @Version
    private long version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Allocation() {
        allocations = new HashMap<>();
    }

    public Allocation(String source, Date allocationTime) {
        this.source = source;
        this.allocationTime = allocationTime;
        allocations = new HashMap<>();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getAllocationTime() {
        return allocationTime;
    }

    public void setAllocationTime(Date allocationTime) {
        this.allocationTime = allocationTime;
    }

    public Map<String, Double> getAllocations() {
        return allocations;
    }

    public void setAllocations(Map<String, Double> allocations) {
        this.allocations = allocations;
    }

    public double calculateAllocation() {
        return allocations.entrySet().stream().mapToDouble(Map.Entry::getValue).sum();
    }

    public void addAllocation(String product, Double quantity) {
        allocations.compute(product, (k, v) -> v == null ? Math.max(0, quantity) : Math.max(0, v + quantity));

    }


}
