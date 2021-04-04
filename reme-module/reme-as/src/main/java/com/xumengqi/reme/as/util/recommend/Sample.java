package com.xumengqi.reme.as.util.recommend;

import java.util.List;
import java.util.Objects;

/**
 * @author xumengqi
 * @date 2021/4/3 23:50
 */
public class Sample {
    /**
     * 样本ID
     */
    private Long id;

    /**
     * 样本数据
     */
    private List<Double> data;

    public Sample() {

    }

    public Sample(Long id, List<Double> data) {
        this.id = id;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Double> getData() {
        return data;
    }

    public void setData(List<Double> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Sample sample = (Sample) o;
        return Objects.equals(id, sample.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", data=" + data +
                '}';
    }
}
