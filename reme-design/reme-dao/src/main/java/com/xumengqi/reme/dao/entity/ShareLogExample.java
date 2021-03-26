package com.xumengqi.reme.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShareLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShareLogExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andShareRecordIdIsNull() {
            addCriterion("share_record_id is null");
            return (Criteria) this;
        }

        public Criteria andShareRecordIdIsNotNull() {
            addCriterion("share_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andShareRecordIdEqualTo(Long value) {
            addCriterion("share_record_id =", value, "shareRecordId");
            return (Criteria) this;
        }

        public Criteria andShareRecordIdNotEqualTo(Long value) {
            addCriterion("share_record_id <>", value, "shareRecordId");
            return (Criteria) this;
        }

        public Criteria andShareRecordIdGreaterThan(Long value) {
            addCriterion("share_record_id >", value, "shareRecordId");
            return (Criteria) this;
        }

        public Criteria andShareRecordIdGreaterThanOrEqualTo(Long value) {
            addCriterion("share_record_id >=", value, "shareRecordId");
            return (Criteria) this;
        }

        public Criteria andShareRecordIdLessThan(Long value) {
            addCriterion("share_record_id <", value, "shareRecordId");
            return (Criteria) this;
        }

        public Criteria andShareRecordIdLessThanOrEqualTo(Long value) {
            addCriterion("share_record_id <=", value, "shareRecordId");
            return (Criteria) this;
        }

        public Criteria andShareRecordIdIn(List<Long> values) {
            addCriterion("share_record_id in", values, "shareRecordId");
            return (Criteria) this;
        }

        public Criteria andShareRecordIdNotIn(List<Long> values) {
            addCriterion("share_record_id not in", values, "shareRecordId");
            return (Criteria) this;
        }

        public Criteria andShareRecordIdBetween(Long value1, Long value2) {
            addCriterion("share_record_id between", value1, value2, "shareRecordId");
            return (Criteria) this;
        }

        public Criteria andShareRecordIdNotBetween(Long value1, Long value2) {
            addCriterion("share_record_id not between", value1, value2, "shareRecordId");
            return (Criteria) this;
        }

        public Criteria andShareRecordStatusIsNull() {
            addCriterion("share_record_status is null");
            return (Criteria) this;
        }

        public Criteria andShareRecordStatusIsNotNull() {
            addCriterion("share_record_status is not null");
            return (Criteria) this;
        }

        public Criteria andShareRecordStatusEqualTo(Integer value) {
            addCriterion("share_record_status =", value, "shareRecordStatus");
            return (Criteria) this;
        }

        public Criteria andShareRecordStatusNotEqualTo(Integer value) {
            addCriterion("share_record_status <>", value, "shareRecordStatus");
            return (Criteria) this;
        }

        public Criteria andShareRecordStatusGreaterThan(Integer value) {
            addCriterion("share_record_status >", value, "shareRecordStatus");
            return (Criteria) this;
        }

        public Criteria andShareRecordStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("share_record_status >=", value, "shareRecordStatus");
            return (Criteria) this;
        }

        public Criteria andShareRecordStatusLessThan(Integer value) {
            addCriterion("share_record_status <", value, "shareRecordStatus");
            return (Criteria) this;
        }

        public Criteria andShareRecordStatusLessThanOrEqualTo(Integer value) {
            addCriterion("share_record_status <=", value, "shareRecordStatus");
            return (Criteria) this;
        }

        public Criteria andShareRecordStatusIn(List<Integer> values) {
            addCriterion("share_record_status in", values, "shareRecordStatus");
            return (Criteria) this;
        }

        public Criteria andShareRecordStatusNotIn(List<Integer> values) {
            addCriterion("share_record_status not in", values, "shareRecordStatus");
            return (Criteria) this;
        }

        public Criteria andShareRecordStatusBetween(Integer value1, Integer value2) {
            addCriterion("share_record_status between", value1, value2, "shareRecordStatus");
            return (Criteria) this;
        }

        public Criteria andShareRecordStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("share_record_status not between", value1, value2, "shareRecordStatus");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeIsNull() {
            addCriterion("operator_type is null");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeIsNotNull() {
            addCriterion("operator_type is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeEqualTo(Integer value) {
            addCriterion("operator_type =", value, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeNotEqualTo(Integer value) {
            addCriterion("operator_type <>", value, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeGreaterThan(Integer value) {
            addCriterion("operator_type >", value, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("operator_type >=", value, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeLessThan(Integer value) {
            addCriterion("operator_type <", value, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeLessThanOrEqualTo(Integer value) {
            addCriterion("operator_type <=", value, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeIn(List<Integer> values) {
            addCriterion("operator_type in", values, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeNotIn(List<Integer> values) {
            addCriterion("operator_type not in", values, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeBetween(Integer value1, Integer value2) {
            addCriterion("operator_type between", value1, value2, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("operator_type not between", value1, value2, "operatorType");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
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