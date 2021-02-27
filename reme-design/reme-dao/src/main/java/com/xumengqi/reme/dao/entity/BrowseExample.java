package com.xumengqi.reme.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BrowseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BrowseExample() {
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

        public Criteria andBrowseIdIsNull() {
            addCriterion("browse_id is null");
            return (Criteria) this;
        }

        public Criteria andBrowseIdIsNotNull() {
            addCriterion("browse_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrowseIdEqualTo(Long value) {
            addCriterion("browse_id =", value, "browseId");
            return (Criteria) this;
        }

        public Criteria andBrowseIdNotEqualTo(Long value) {
            addCriterion("browse_id <>", value, "browseId");
            return (Criteria) this;
        }

        public Criteria andBrowseIdGreaterThan(Long value) {
            addCriterion("browse_id >", value, "browseId");
            return (Criteria) this;
        }

        public Criteria andBrowseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("browse_id >=", value, "browseId");
            return (Criteria) this;
        }

        public Criteria andBrowseIdLessThan(Long value) {
            addCriterion("browse_id <", value, "browseId");
            return (Criteria) this;
        }

        public Criteria andBrowseIdLessThanOrEqualTo(Long value) {
            addCriterion("browse_id <=", value, "browseId");
            return (Criteria) this;
        }

        public Criteria andBrowseIdIn(List<Long> values) {
            addCriterion("browse_id in", values, "browseId");
            return (Criteria) this;
        }

        public Criteria andBrowseIdNotIn(List<Long> values) {
            addCriterion("browse_id not in", values, "browseId");
            return (Criteria) this;
        }

        public Criteria andBrowseIdBetween(Long value1, Long value2) {
            addCriterion("browse_id between", value1, value2, "browseId");
            return (Criteria) this;
        }

        public Criteria andBrowseIdNotBetween(Long value1, Long value2) {
            addCriterion("browse_id not between", value1, value2, "browseId");
            return (Criteria) this;
        }

        public Criteria andTargetTypeIsNull() {
            addCriterion("target_type is null");
            return (Criteria) this;
        }

        public Criteria andTargetTypeIsNotNull() {
            addCriterion("target_type is not null");
            return (Criteria) this;
        }

        public Criteria andTargetTypeEqualTo(Byte value) {
            addCriterion("target_type =", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeNotEqualTo(Byte value) {
            addCriterion("target_type <>", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeGreaterThan(Byte value) {
            addCriterion("target_type >", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("target_type >=", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeLessThan(Byte value) {
            addCriterion("target_type <", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeLessThanOrEqualTo(Byte value) {
            addCriterion("target_type <=", value, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeIn(List<Byte> values) {
            addCriterion("target_type in", values, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeNotIn(List<Byte> values) {
            addCriterion("target_type not in", values, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeBetween(Byte value1, Byte value2) {
            addCriterion("target_type between", value1, value2, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("target_type not between", value1, value2, "targetType");
            return (Criteria) this;
        }

        public Criteria andTargetIdIsNull() {
            addCriterion("target_id is null");
            return (Criteria) this;
        }

        public Criteria andTargetIdIsNotNull() {
            addCriterion("target_id is not null");
            return (Criteria) this;
        }

        public Criteria andTargetIdEqualTo(Long value) {
            addCriterion("target_id =", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotEqualTo(Long value) {
            addCriterion("target_id <>", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdGreaterThan(Long value) {
            addCriterion("target_id >", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdGreaterThanOrEqualTo(Long value) {
            addCriterion("target_id >=", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdLessThan(Long value) {
            addCriterion("target_id <", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdLessThanOrEqualTo(Long value) {
            addCriterion("target_id <=", value, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdIn(List<Long> values) {
            addCriterion("target_id in", values, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotIn(List<Long> values) {
            addCriterion("target_id not in", values, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdBetween(Long value1, Long value2) {
            addCriterion("target_id between", value1, value2, "targetId");
            return (Criteria) this;
        }

        public Criteria andTargetIdNotBetween(Long value1, Long value2) {
            addCriterion("target_id not between", value1, value2, "targetId");
            return (Criteria) this;
        }

        public Criteria andBrowseUserIdIsNull() {
            addCriterion("browse_user_id is null");
            return (Criteria) this;
        }

        public Criteria andBrowseUserIdIsNotNull() {
            addCriterion("browse_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrowseUserIdEqualTo(Long value) {
            addCriterion("browse_user_id =", value, "browseUserId");
            return (Criteria) this;
        }

        public Criteria andBrowseUserIdNotEqualTo(Long value) {
            addCriterion("browse_user_id <>", value, "browseUserId");
            return (Criteria) this;
        }

        public Criteria andBrowseUserIdGreaterThan(Long value) {
            addCriterion("browse_user_id >", value, "browseUserId");
            return (Criteria) this;
        }

        public Criteria andBrowseUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("browse_user_id >=", value, "browseUserId");
            return (Criteria) this;
        }

        public Criteria andBrowseUserIdLessThan(Long value) {
            addCriterion("browse_user_id <", value, "browseUserId");
            return (Criteria) this;
        }

        public Criteria andBrowseUserIdLessThanOrEqualTo(Long value) {
            addCriterion("browse_user_id <=", value, "browseUserId");
            return (Criteria) this;
        }

        public Criteria andBrowseUserIdIn(List<Long> values) {
            addCriterion("browse_user_id in", values, "browseUserId");
            return (Criteria) this;
        }

        public Criteria andBrowseUserIdNotIn(List<Long> values) {
            addCriterion("browse_user_id not in", values, "browseUserId");
            return (Criteria) this;
        }

        public Criteria andBrowseUserIdBetween(Long value1, Long value2) {
            addCriterion("browse_user_id between", value1, value2, "browseUserId");
            return (Criteria) this;
        }

        public Criteria andBrowseUserIdNotBetween(Long value1, Long value2) {
            addCriterion("browse_user_id not between", value1, value2, "browseUserId");
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

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
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