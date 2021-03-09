package com.xumengqi.reme.dao.entity;

import java.util.ArrayList;
import java.util.List;

public class ConfessionAttachExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ConfessionAttachExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andConfessionIdIsNull() {
            addCriterion("confession_id is null");
            return (Criteria) this;
        }

        public Criteria andConfessionIdIsNotNull() {
            addCriterion("confession_id is not null");
            return (Criteria) this;
        }

        public Criteria andConfessionIdEqualTo(Long value) {
            addCriterion("confession_id =", value, "confessionId");
            return (Criteria) this;
        }

        public Criteria andConfessionIdNotEqualTo(Long value) {
            addCriterion("confession_id <>", value, "confessionId");
            return (Criteria) this;
        }

        public Criteria andConfessionIdGreaterThan(Long value) {
            addCriterion("confession_id >", value, "confessionId");
            return (Criteria) this;
        }

        public Criteria andConfessionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("confession_id >=", value, "confessionId");
            return (Criteria) this;
        }

        public Criteria andConfessionIdLessThan(Long value) {
            addCriterion("confession_id <", value, "confessionId");
            return (Criteria) this;
        }

        public Criteria andConfessionIdLessThanOrEqualTo(Long value) {
            addCriterion("confession_id <=", value, "confessionId");
            return (Criteria) this;
        }

        public Criteria andConfessionIdIn(List<Long> values) {
            addCriterion("confession_id in", values, "confessionId");
            return (Criteria) this;
        }

        public Criteria andConfessionIdNotIn(List<Long> values) {
            addCriterion("confession_id not in", values, "confessionId");
            return (Criteria) this;
        }

        public Criteria andConfessionIdBetween(Long value1, Long value2) {
            addCriterion("confession_id between", value1, value2, "confessionId");
            return (Criteria) this;
        }

        public Criteria andConfessionIdNotBetween(Long value1, Long value2) {
            addCriterion("confession_id not between", value1, value2, "confessionId");
            return (Criteria) this;
        }

        public Criteria andAttachIdIsNull() {
            addCriterion("attach_id is null");
            return (Criteria) this;
        }

        public Criteria andAttachIdIsNotNull() {
            addCriterion("attach_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttachIdEqualTo(Long value) {
            addCriterion("attach_id =", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdNotEqualTo(Long value) {
            addCriterion("attach_id <>", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdGreaterThan(Long value) {
            addCriterion("attach_id >", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdGreaterThanOrEqualTo(Long value) {
            addCriterion("attach_id >=", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdLessThan(Long value) {
            addCriterion("attach_id <", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdLessThanOrEqualTo(Long value) {
            addCriterion("attach_id <=", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdIn(List<Long> values) {
            addCriterion("attach_id in", values, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdNotIn(List<Long> values) {
            addCriterion("attach_id not in", values, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdBetween(Long value1, Long value2) {
            addCriterion("attach_id between", value1, value2, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdNotBetween(Long value1, Long value2) {
            addCriterion("attach_id not between", value1, value2, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachOrderIsNull() {
            addCriterion("attach_order is null");
            return (Criteria) this;
        }

        public Criteria andAttachOrderIsNotNull() {
            addCriterion("attach_order is not null");
            return (Criteria) this;
        }

        public Criteria andAttachOrderEqualTo(Integer value) {
            addCriterion("attach_order =", value, "attachOrder");
            return (Criteria) this;
        }

        public Criteria andAttachOrderNotEqualTo(Integer value) {
            addCriterion("attach_order <>", value, "attachOrder");
            return (Criteria) this;
        }

        public Criteria andAttachOrderGreaterThan(Integer value) {
            addCriterion("attach_order >", value, "attachOrder");
            return (Criteria) this;
        }

        public Criteria andAttachOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("attach_order >=", value, "attachOrder");
            return (Criteria) this;
        }

        public Criteria andAttachOrderLessThan(Integer value) {
            addCriterion("attach_order <", value, "attachOrder");
            return (Criteria) this;
        }

        public Criteria andAttachOrderLessThanOrEqualTo(Integer value) {
            addCriterion("attach_order <=", value, "attachOrder");
            return (Criteria) this;
        }

        public Criteria andAttachOrderIn(List<Integer> values) {
            addCriterion("attach_order in", values, "attachOrder");
            return (Criteria) this;
        }

        public Criteria andAttachOrderNotIn(List<Integer> values) {
            addCriterion("attach_order not in", values, "attachOrder");
            return (Criteria) this;
        }

        public Criteria andAttachOrderBetween(Integer value1, Integer value2) {
            addCriterion("attach_order between", value1, value2, "attachOrder");
            return (Criteria) this;
        }

        public Criteria andAttachOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("attach_order not between", value1, value2, "attachOrder");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}